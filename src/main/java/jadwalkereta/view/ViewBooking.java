/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import jadwalkereta.model.User;
import jadwalkereta.controller.ControllerBooking;
import jadwalkereta.controller.ControllerMain;
import jadwalkereta.controller.ControllerUser;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class ViewBooking {
    ControllerBooking ctrBooking;
    private int pilihan;
    Scanner input = new Scanner(System.in);
    
    public ViewBooking(ControllerBooking ctr){
       this.ctrBooking = ctr;
    }

    public int getPilihan(){
        return pilihan;
    }
    
    public void menuBooking() {
        System.out.println("#MENU BOOKING TIKET#");
        System.out.println("1. Cari Jadwal");
        System.out.println("2. Booking");
        System.out.println("3. Pembayaran");
        System.out.println("99. Menu Utama");
        System.out.print("Pilihan : ");
        pilihan = input.nextInt();
    }

    public void book(){
        int i, jadwal;
        String kode;
        System.out.println("#BOOKING TIKET#");
       do{
        System.out.print("Kode Jadwal: ");
        kode = input.next();
        jadwal = ctrBooking.cekjadwal(kode);
        if(jadwal < 0)
        {
            System.out.println("Kode Jadwal tidak ada");
        }
       }while(jadwal <0);
        System.out.print("Jumlah: ");
        int jml = input.nextInt();
        if(jml> 0)
        {
            System.out.println("---------------------------------------------------------");
            String[] penumpang = new String[jml];
            String orang;
            for(i=0; i<jml; i++)
            {
                do {
                    System.out.print("penumpang "+(i+1)+": ");
                    
                    orang = input.next();
                    if (!orang.matches("^[a-zA-Z\\\\s][a-zA-Z \\\\s]*$")){
                        System.out.println("Nama harus terdiri dari huruf semua!");
                    }
                } while (!orang.matches("^[a-zA-Z\\\\s][a-zA-Z \\\\s]*$"));
                
                
                penumpang[i] = orang;
            }
            System.out.println();
            System.out.println("---------------------------------------------------------");
            ctrBooking.lihatKursi(kode);
            System.out.println("---------------------------------------------------------");
            System.out.println("Pilih Kursi (Dengan Tanda E/Empty) : ");
            String kursi, kdKelas;
            int kdKursi, kdGerbong, status;
            String[] bangku = new String[jml];
            long harga, sum=0;
            for(i=0; i<jml; i++)
            {
                System.out.print("Kursi "+(i+1)+": ");
                kursi = input.next();
                kdKelas = Character.toString( kursi.charAt(0));
                kdGerbong = Integer.valueOf(kursi.charAt(1)+"") ;
                kdKursi = Integer.valueOf(kursi.charAt(3) + "");
                status = ctrBooking.CekStatus(kode, kdKelas, kdGerbong, kdKursi);
                while (status >= 0)
                {
                    System.out.println("Kursi sudah dipesan, silahkan pilih kursi bertanda E");
                    System.out.print("Kursi "+(i+1)+": ");
                    kursi = input.next();
                    kdKelas = Character.toString( kursi.charAt(0));
                    kdGerbong = Integer.valueOf(kursi.charAt(1)+"") ;
                    kdKursi = Integer.valueOf(kursi.charAt(3) + "");
                    status = ctrBooking.CekStatus(kode, kdKelas, kdGerbong, kdKursi);
                }
                //ctrBooking.PesanKursi(kode, kdKelas, kdGerbong, kdKursi);
                harga = ctrBooking.HitungHarga(kode, kdKelas);
                sum = sum+harga;
                bangku[i]=kursi;
               
            }
            System.out.println();
            System.out.println("---------------------------------------------------------");
            String kdpesan = ctrBooking.GenerateKode();
            System.out.println("Total Pembayaran : "+sum);
            System.out.println("Nomor Rekening : 80325567189");
            System.out.println("Kode Booking : " + kdpesan);
            System.out.println("---------------------------------------------------------");
            
            
            String kodeBooking = ctrBooking.booked(kode, kdpesan, penumpang, bangku, sum);
        }else{
            System.out.println("---------------------------------------------------------");
            System.out.println("Keluar dari menu Booking");
            System.out.println("---------------------------------------------------------");
            System.out.println();   
        }

        //System.out.println(kodeBooking);


    }

    /*public void menuDetail()
    {
        System.out.print("masukkan kode booking :");
        String kode = input.next();
        ctrBooking.detail(kode);
    }*/


    public void menuPembayaran()
    {
        String norek;
        //long norek;
        System.out.println();
        System.out.println("#PEMBAYARAN TIKET KERETA API#");
        System.out.print("Kode Booking : ");
        String kodebooking = input.next();
       

        do {
            System.out.print("Nomor Rekening : ");
            norek = input.next();
            //snorek = Long.toString(norek);

            if (!norek.matches("[0-9_]+")) {
                System.out.println("Tidak valid, nomor rekening harus angka");
            }
        } while (!norek.matches("[0-9_]+"));

        System.out.print("Total Pembayaran : ");
        Long harga = input.nextLong();
        int bayar = ctrBooking.Cekbayar(kodebooking);
        if(bayar>=0)
        {
            System.out.println("---------------------------------------------------------");
            System.out.println("Kode Booking Telah Dibayar");
            System.out.println("---------------------------------------------------------");
            System.out.println();
        }else{
            //System.out.println("Kode Rekening : 80325567189");
            //long hargatotal = ctrBooking.detailHarga(kodebooking);
            //System.out.println("Total Pembayaran : " + hargatotal);
            System.out.print("Apakah data pembayaran sudah benar (Y/N)?");
            String pilihan  = input.next();
            if(pilihan.equals("Y") || pilihan.equals("y")){
                int valid = ctrBooking.ValidasiBayar(kodebooking, norek, harga);
                if(valid>=0)
                {
                    int status = ctrBooking.CekKursi(kodebooking);
                    if(status<0)
                    {
                        ctrBooking.PesanKursi(kodebooking);
                        System.out.println();
                        System.out.println("---------------------------------------------------------");
                        System.out.println("Pembayaran Berhasil!!");
                        System.out.println("Kode Tiket anda : "+kodebooking);
                        ctrBooking.detailPenumpang(kodebooking);
                        ctrBooking.bayar(kodebooking);
                        System.out.println("---------------------------------------------------------");
                        System.out.println();
                    }else{
                        System.out.println("---------------------------------------------------------");
                        System.out.println("Kursi Not Available, silahkan lakukan pemesanan ulang");
                        System.out.println("---------------------------------------------------------");
                    }

                }else{
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Data Salah, silahkan melakukan pembayaran Ulang");
                    System.out.println("---------------------------------------------------------");
                }
            }
            else{
                menuBooking();
            }
        }
        
    }
    
}