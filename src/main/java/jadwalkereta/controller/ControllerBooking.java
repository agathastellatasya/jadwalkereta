/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.*;
import jadwalkereta.view.*;
import jadwalkereta.controller.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;


public class ControllerBooking {
    //ArrayList<Booking> booking = new  ArrayList<Booking>();
    ArrayList<Booking> booking;
    ArrayList<Jadwal> jadwal;
    ControllerMain ctrMain;
    ControllerUtil ctrUtil = new ControllerUtil();
    ControllerKereta ctrKereta;
    ViewBooking viewBooking;
    ControllerPenumpang ctrPenumpang;
    Scanner input = new Scanner(System.in);
    ControllerCariJadwal ctrCariJadwal ;

    public ControllerBooking(ControllerPenumpang penumpang) {
        ctrPenumpang  = penumpang;
        ctrMain = penumpang.getControllerMain();
        jadwal = ctrUtil.getJadwal();
        booking = ctrUtil.getBooking();
        
    }

    

    public void ControlMenuBooking() {
        if (viewBooking == null) viewBooking = new ViewBooking(this);
        viewBooking.menuBooking();
        switch(viewBooking.getPilihan()){
            case 1: {
                if (ctrCariJadwal == null) ctrCariJadwal = new ControllerCariJadwal(this);
                ctrCariJadwal.ControlMenuCariJadwal();
                ControlMenuBooking();
                //viewBooking.menuBooking();
            }
            case 2: {
                viewBooking.book();
                //viewBooking.menuBooking();
                ControlMenuBooking();
                break;
            }

            case 3: {
                viewBooking.menuPembayaran();
                ControlMenuBooking();
                //viewBooking.menuBooking();
                break;
            }
            case 4: {
                viewBooking.cancel();
                ControlMenuBooking();
            break;
			}
			case 5: {
                viewBooking.menuPindah();
                ControlMenuBooking();
            break;
			}

            case 99:{
                ctrPenumpang.ControlMenuPenumpang();
                break;
            }
        }
    }

    public void cancel(String KodePesan){
        jadwal = ctrUtil.getJadwal();
        booking = ctrUtil.getBooking();
        int indexbooked = -1;
        for(int i=0;i<booking.size()&&indexbooked<0;i++)
        {
            if (booking.get(i).getKdBooking() != null) {
                if (booking.get(i).getKdBooking().equals(KodePesan))
                    indexbooked = i;
            }
        }
            

        if(booking.get(indexbooked).getIsPaid()==2) System.out.println("Kode Booking Sudah Tidak Berlaku!");
        else if(indexbooked>=0)
        {
            String KodeJadwal =  booking.get(indexbooked).getKdJadwal();
            int indexjadwal = -1;
            for(int i=0;i<jadwal.size()&&indexjadwal<0;i++)
                if(jadwal.get(i).getKode().equals(KodeJadwal)) indexjadwal = i;

            if(indexjadwal>=0)
            {
                String[] kursi = booking.get(indexbooked).getKursi();
                for(int i = 0; i<kursi.length;i++)
                {
                    String kodekursi = ""+kursi[i].charAt(0);
                    String nomorkursi = kursi[i].substring(1);
                    int gerbong  = Integer.valueOf(nomorkursi.substring(0, nomorkursi.indexOf('-')));
                    int tempatduduk = Integer.valueOf(nomorkursi.substring(nomorkursi.indexOf('-')+1));
                    if(kodekursi.equals("B"))
                        jadwal.get(indexjadwal).getKereta().setBangkuBisnis(gerbong-1, tempatduduk-1, 0);
                    else if(kodekursi.equals("P"))
                        jadwal.get(indexjadwal).getKereta().setBangkuPremium(gerbong-1, tempatduduk-1, 0);
                }
                booking.get(indexbooked).setIsPaid(2);
                User user = ctrPenumpang.getUser(); 
                ArrayList<User> users = ctrUtil.getUsers();
                ControllerUser ctrUser = new ControllerUser(ctrMain);
                int index = ctrUser.findEmailInUsers(user.getEmail());
                String tanggal = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
                user.getTransaksi().add(new Transaksi(booking.get(indexbooked).getKdPesan(), tanggal, "CANCELED", booking.get(indexbooked).getKdBooking()));
                users.set(index, user);
                ctrPenumpang.setUser(user);
                ctrUtil.WriteJSONUser();
                ctrUtil.WriteJSONBooking();
                ctrUtil.WriteJSONJadwal();
                System.out.println("Sukses Cancel!");
            }
            else
            {
                System.out.println("Jadwal Tidak Ditemukan");
            }
        }
        else System.out.println("Kode Pesan Tidak Ditemukan");
    }

    public String getAlphaString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //String NumString  = "0123456789"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index = (int)(AlphaString.length() * Math.random()); 
            //int index2 = (int)(NumString.length() * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaString.charAt(index)); 
        } 
        return sb.toString(); 
    } 

    static String getNumString(int n) 
    { 
  
        // chose a Character random from this String 
        //String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String NumString  = "0123456789"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            //int index = (int)(AlphaString.length() * Math.random()); 
            int index2 = (int)(NumString.length() * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(NumString.charAt(index2)); 
        } 
        return sb.toString(); 
    } 

    public String GenerateKode()
    {
        String kode = getNumString(8);
        return kode;
    }  
    
    public String GenerateKdBooking()
    {
        String kode = getAlphaString(3)+getNumString(3);
        return kode;
    }  

    public void FillKursi(String kdjadwal, String kdkelas, int kdGerbong, int kdKursi)
    {
            int i;
            for(i=0; i<jadwal.size(); i++)
            {
                if(kdjadwal.equals(jadwal.get(i).getKode()))
                {
                    if(kdkelas.equals("B"))
                    {
                        
                        jadwal.get(i).getKereta().setBangkuBisnis(kdGerbong-1, kdKursi-1, 1);
                  
    
                    }else{
                        jadwal.get(i).getKereta().setBangkuPremium(kdGerbong-1, kdKursi-1, 1);
                        
                    }
                    ctrUtil.WriteJSONJadwal();
                }
            }  
    }

        public void PesanKursi(String kode)
        {
            booking = ctrUtil.getBooking();
            int i, kdGerbong, kdKursi, j;
            String kursi, kdjadwal;
            String kdKelas = "";
            for(i=0; i<booking.size(); i++)
            {
                if(kode.equals(booking.get(i).getKdPesan()))
                {
                   kdjadwal = booking.get(i).getKdJadwal();
                   for(j=0; j<booking.get(i).getKursi().length; j++)
                   {
                    kursi = booking.get(i).getKursi()[j];
                    String kursip [] = kursi.split("-");
                    //System.out.println(kursip.length);
                    if (kursip.length==2){
                        kdKelas = Character.toString(kursi.charAt(0));
                        String nomerGerbong = kursip[0].replaceAll("[\\D]", ""); 
                        kdGerbong = Integer.valueOf(nomerGerbong);
                        String nokursi = kursip[1].replaceAll("[\\D]", "");
                        kdKursi = Integer.valueOf(nokursi);
                        FillKursi(kdjadwal, kdKelas, kdGerbong, kdKursi);
                    }
                   }
                }
            }
        }

        public long HitungHarga(String kdjadwal, String kdkelas) {
            int i;
            long harga = 0;
            for(i=0; i<jadwal.size(); i++)
            {
                if(kdjadwal.equals(jadwal.get(i).getKode()))
                {
                    if(kdkelas.equals("B"))
                    {
                        
                        //jadwal.get(i).getKereta().setBangkuBisnis(kdGerbong-1, kdKursi-1, 1);
                        harga = harga + jadwal.get(i).getHargaB();
    
                    }else{
                        //jadwal.get(i).getKereta().setBangkuPremium(kdGerbong-1, kdKursi-1, 1);
                        harga = harga + jadwal.get(i).getHargaP();
                    }
                }
            }
            return harga;
        }

    public int ValidasiBayar(String kode, long harga)
    {
        booking = ctrUtil.getBooking();
        int i;
        boolean found = false;
        for(i=0; i<booking.size(); i++)
        {
            if(kode.equals(booking.get(i).getKdPesan()))
            {
                if(harga==booking.get(i).getHarga())
                {
                    found=true;
                    break;
                }
            }
        }
        if(found) return i;
        else return -1;
    }

    public int CekKursi(String kode)
    {
        booking = ctrUtil.getBooking();
        int i, kdGerbong, kdKursi, status;
        int j =0, flag =0;
        String kursi, kdjadwal;
        String kdKelas = "";
        boolean found = false;
        for(i=0; i<booking.size(); i++)
        {
            if(kode.equals(booking.get(i).getKdPesan()))
            {
               kdjadwal = booking.get(i).getKdJadwal();
               while(j<booking.get(i).getKursi().length && flag!=1)
               {
                    kursi = booking.get(i).getKursi()[j];
                    String kursip [] = kursi.split("-");
                    //System.out.println(kursip.length);
                    if (kursip.length==2){
                        kdKelas = Character.toString(kursi.charAt(0));
                        String nomerGerbong = kursip[0].replaceAll("[\\D]", ""); 
                        kdGerbong = Integer.valueOf(nomerGerbong);
                        String nokursi = kursip[1].replaceAll("[\\D]", "");
                        kdKursi = Integer.valueOf(nokursi);
                        //System.out.println(kdKelas);
                       // System.out.println(kdGerbong);
                       // System.out.println(kdKursi);
                        status = CekStatus(kdjadwal, kdKelas, kdGerbong, kdKursi);
                        if (status>=0){
                            flag =1;
                            found = true;
                        }
                    }
//                kdKelas = Character.toString( kursi.charAt(0));
//                kdGerbong = Integer.valueOf(kursi.charAt(1)+"") ;
//                kdKursi = Integer.valueOf(kursi.charAt(3) + "");
                    j++;
               }
               
            }
        }
        if(found) return i;
        else return -1;
    }


    public int CekStatus(String kdjadwal, String kdkelas, int kdGerbong, int kdKursi){
        jadwal = ctrUtil.getJadwal();
        int i;
        boolean found = false;
        for (i=0; i < jadwal.size(); i++) {
            if(kdjadwal.equals(jadwal.get(i).getKode()))
            {
                if(kdkelas.equals("B") && kdKursi<=10 && kdKursi>0)
                {
                    //System.out.println(kdGerbong+" "+kdKursi);
                    //System.out.println(jadwal.get(i).getKereta().getBangkuBisnis(kdGerbong-1, kdKursi-1));
                    if((jadwal.get(i).getKereta().getBangkuBisnis(kdGerbong-1, kdKursi-1))==1)
                    {
                        found = true;
                        break;
                    }
                }
                else if(kdkelas.equals("P") && kdKursi<=20 && kdKursi>0){
                    if((jadwal.get(i).getKereta().getBangkuPremium(kdGerbong-1, kdKursi-1))==1 )
                    {
                        found = true;
                        break;
                    }
                }
                else if(kdkelas.equals("P") && kdKursi>20) {
                    found = true;
                    break;
                }
                else if(kdkelas.equals("B") && kdKursi>10) {
                    found = true;
                    break;
                }
            }
        }
        if(found) return i;
        else return -1;
    }




   public String booked(String kdjadwal, String kdpesan, String[] penumpang, String[] kursi, long harga)
   {
        User user = ctrPenumpang.getUser(); 
        ArrayList<User> users = ctrUtil.getUsers();
        ControllerUser ctrUser = new ControllerUser(ctrMain);
        int index = ctrUser.findEmailInUsers(user.getEmail());
        String tanggal = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
        
        int paid = 0;
        String kdKereta = "";
        String stanggal = "";
        for(int i=0; i<jadwal.size(); i++)
        {
            if(kdjadwal.equals(jadwal.get(i).getKode()))
            {
                Tanggal tanggalkereta = jadwal.get(i).getTanggal();
                stanggal = tanggalkereta.getHari()+"-"+tanggalkereta.getBulan()+"-"+tanggalkereta.getTahun();
                kdKereta = jadwal.get(i).getKereta().getKodeKereta();

            }
        }
       

        Booking B1 = new Booking(kdjadwal, paid, kdpesan, penumpang, kursi, harga, user.getEmail(), stanggal, kdKereta);
        booking.add(B1);
        user.getTransaksi().add(new Transaksi(kdpesan, tanggal, "BOOKED", "-"));
        users.set(index, user);
        ctrPenumpang.setUser(user);
        ctrUtil.WriteJSONUser();
        ctrUtil.WriteJSONBooking();
        //System.out.println(booking.size());
        return kdpesan;
   }

   public Long detailHarga(String kode)
   {
       long harga =0;
       for(int i=0; i<booking.size(); i++)
       {
        //System.out.println(booking.get(i).getKdPesan());
        //System.out.println(booking.get(i).getHarga());
        if(kode.equals(booking.get(i).getKdPesan()))
        {
            harga = booking.get(i).getHarga();
        }
       }
       return harga;
       
   }

   public void detailPenumpang(String kode)
   {
       for(int i=0; i<booking.size(); i++)
       {
        if(kode.equals(booking.get(i).getKdPesan()))
        {
            for(int j=0; j<booking.get(i).getPenumpang().length; j++)
            {
                System.out.println("penumpang "+(j+1)+ ": " +booking.get(i).getPenumpang()[j]);
            }
            System.out.println("Kode Booking "+ ": " +booking.get(i).getKdBooking());
        }
       }
       
   }

   public void bayar(String kode)
   {
        for(int i=0; i<booking.size(); i++)
        {
            if(kode.equals(booking.get(i).getKdPesan()))
            {
                    String kdBooking = GenerateKdBooking();
                    booking.get(i).setIsPaid(1);
                    booking.get(i).setKdBooking(kdBooking);
                    User user = ctrPenumpang.getUser(); 
                    ArrayList<User> users = ctrUtil.getUsers();
                    ControllerUser ctrUser = new ControllerUser(ctrMain);
                    int index = ctrUser.findEmailInUsers(user.getEmail());
                    String tanggal = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
                    user.getTransaksi().add(new Transaksi(kode, tanggal, "PAID", kdBooking));
                    users.set(index, user);
                    ctrPenumpang.setUser(user);
                    ctrUtil.WriteJSONUser();
            }
        }
        ctrUtil.WriteJSONBooking();
   }

   public int Cekbayar(String kode){
        int i;
        boolean found = false;
        for (i=0; i < booking.size(); i++) {
            if (kode.equals(booking.get(i).getKdPesan())) {
                if(booking.get(i).getIsPaid()==1)
                {
                    found = true;
                    break;
                }
            }
        }
        if(found) return i;
        else return -1;
    }
	
    public int CekPindah(String kode){
        int i,j;
        boolean found = false;
        User user = ctrPenumpang.getUser(); 
        ArrayList<User> users = ctrUtil.getUsers();
        ControllerUser ctrUser = new ControllerUser(ctrMain);
        for (i=0; i < users.size(); i++) {
            for (j=0; j < users.get(i).getTransaksi().size(); j++) {
                //System.out.println(users.get(i).getTransaksi().get(j).getKodebayar());
                //System.out.println(kode);
                if (kode.equals(users.get(i).getTransaksi().get(j).getKodebayar()) && user.getEmail().equals(users.get(i).getEmail())) {
                    /*String[] xtanggal = users.get(i).getTransaksi().get(j).getTanggal().split("-");
                    int tgl = Integer.valueOf(xtanggal[0]);
                    int bulan = Integer.valueOf(xtanggal[1]);
                    int tahun = Integer.valueOf(xtanggal[2]);
                    String stanggal = bulan+"-"+tahun;
                    LocalDate tanggal2 = LocalDate.of(tahun,bulan,tgl);
                    LocalDate tanggal = LocalDate.now();
                    if(tanggal2.isAfter(tanggal)){*/
                        found = true;
                        break;
                    //}
                }
            }
        }
        if(found) return i;
        else return -1;
    }
	
	public void pindahKursi(int index,String[] kursi){
        booking.get(index).setKursi(kursi);
        ctrUtil.WriteJSONBooking();
    }

    public int cekjadwal(String kode){
        int i;
        boolean found = false;
        for (i=0; i < jadwal.size(); i++) {
            if (kode.equals(jadwal.get(i).getKode())) {
                    found = true;
                    break;
            }
        }
        if(found) return i;
        else return -1;
    }


  
   


    public void lihatKursi(String kode)
    {
        int i,j,k;
        for(i=0; i<jadwal.size(); i++)
        {
            if(kode.equals(jadwal.get(i).getKode()))
            {
                for(j=0; j<jadwal.get(i).getKereta().getJmlBisnis(); j++)
                {
                    System.out.println("Gerbong Business "+(j+1));
                    for(k=0; k<10; k++)
                    {
                        int init = jadwal.get(i).getKereta().getBangkuBisnis(j, k);
                        if (init==0)
                        {
                            char status = 'E';
                            System.out.print("B"+(j+1)+"-"+(k+1)+"/"+status+"\t");
                        }else
                        {
                            char status = 'F';
                            System.out.print("B"+(j+1)+"-"+(k+1)+"/"+status+"\t");
                        }
                    }
                    System.out.println();
                }


                for(j=0; j<jadwal.get(i).getKereta().getJmlPremium(); j++)
                {
                    System.out.println("Gerbong Premium "+(j+1));
                    for(k=0; k<20; k++)
                    {
                        int init = jadwal.get(i).getKereta().getBangkuPremium(j, k);
                        if (init==0)
                        {
                            char status = 'E';
                            System.out.print("P"+(j+1)+"-"+(k+1)+"/"+status+"\t");
                        }else
                        {
                            char status = 'F';
                            System.out.print("P"+(j+1)+"-"+(k+1)+"/"+status+"\t");
                        }

                        if(k==9)
                        {
                            System.out.println();
                        }
                    }
                    
                    System.out.println();
                }
            }
            
        }
        
    }
}
    