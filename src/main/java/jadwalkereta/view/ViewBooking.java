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
        System.out.println("1. Pembayaran");
        System.out.println("2. Detail");
        System.out.println("99. Menu Utama");
        System.out.print("Pilihan : ");
        pilihan = input.nextInt();
    }

    public void book(){
        int i;
        System.out.println("#BOOKING TIKET#");
        System.out.print("Kode Jadwal: ");
        String kode = input.next();
        System.out.print("Jumlah: ");
        int jml = input.nextInt();
        System.out.println("---------------------------------------------------------");
        String[] penumpang = new String[jml];
        String orang;
        for(i=0; i<jml; i++)
        {
            System.out.print("penumpang "+(i+1)+": ");
            orang = input.next();
            penumpang[i] = orang;
        }
        System.out.println();
        System.out.println("---------------------------------------------------------");
        ctrBooking.lihatKursi(kode);
        System.out.println("---------------------------------------------------------");
        System.out.println("Pilih Kursi (Dengan Tanda E/Empty) : ");
        String kursi;
        String[] bangku = new String[jml];
        long harga, sum=0;
        for(i=0; i<jml; i++)
        {
            System.out.print("Kursi "+(i+1)+": ");
            kursi = input.next();
            String kdKelas = Character.toString( kursi.charAt(0));
            //System.out.println(kdKelas);
            int kdGerbong = Integer.valueOf(kursi.charAt(1)+"") ;
            int kdkursi = Integer.valueOf(kursi.charAt(3)+"");
            harga = ctrBooking.PesanKursi(kode, kdKelas, kdGerbong, kdkursi);
            sum = sum+harga;
            bangku[i]=kursi;
            //System.out.println(sum);
        }
        System.out.println();
        System.out.println("---------------------------------------------------------");
        String kdpesan = ctrBooking.GenerateKode();
        System.out.println("Total Pembayaran : "+sum);
        System.out.println("Kode Rekening : 80325567189");
        System.out.println("Kode Booking : " + kdpesan);
        System.out.println("---------------------------------------------------------");
        
        
        String kodeBooking = ctrBooking.booked(kode, kdpesan, penumpang, bangku, sum);
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
        System.out.println("#PEMBAYARAN TIKET KERETA API#");
        System.out.println();
        System.out.print("Kode Booking : ");
        String kodebooking = input.next();
        System.out.println("Kode Rekening : 80325567189");
        long hargatotal = ctrBooking.detailHarga(kodebooking);
        System.out.println("Total Pembayaran : " + hargatotal);
        System.out.print("Apakah data pembayaran sudah benar (Y/N)?");
        String pilihan  = input.next();
        if(pilihan.equals("Y") || pilihan.equals("y")){
            System.out.println();
            System.out.println("---------------------------------------------------------");
            System.out.println("Pembayaran Berhasil");
            System.out.println("Kode Tiket anda : "+kodebooking);
            ctrBooking.detailPenumpang(kodebooking);
            ctrBooking.bayar(kodebooking);
            System.out.println("---------------------------------------------------------");
            System.out.println();
        }
        else{
            menuBooking();
        }
    }
    
}