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

            case 99:{
                ctrPenumpang.ControlMenuPenumpang();
                break;
            }
        }
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
        String kode = getAlphaString(3)+getNumString(3);
        return kode;
    }  

    public void PesanKursi(String kdjadwal, String kdkelas, int kdGerbong, int kdKursi)
    {
            int i;
            //long harga = 0;
            for(i=0; i<jadwal.size(); i++)
            {
                if(kdjadwal.equals(jadwal.get(i).getKode()))
                {
                    if(kdkelas.equals("B"))
                    {
                        
                        jadwal.get(i).getKereta().setBangkuBisnis(kdGerbong-1, kdKursi-1, 1);
                        //harga = harga + jadwal.get(i).getHargaB();
    
                    }else{
                        jadwal.get(i).getKereta().setBangkuPremium(kdGerbong-1, kdKursi-1, 1);
                        //harga = harga + jadwal.get(i).getHargaP();
                    }
                    ctrUtil.WriteJSONJadwal();
                }
            }
            //return harga;
        
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


    public int CekStatus(String kdjadwal, String kdkelas, int kdGerbong, int kdKursi){
        jadwal = ctrUtil.getJadwal();
        int i;
        boolean found = false;
        for (i=0; i < jadwal.size(); i++) {
            if(kdjadwal.equals(jadwal.get(i).getKode()))
            {
                if(kdkelas.equals("B"))
                {
                    //System.out.println(kdGerbong+" "+kdKursi);
                    //System.out.println(jadwal.get(i).getKereta().getBangkuBisnis(kdGerbong-1, kdKursi-1));
                    if((jadwal.get(i).getKereta().getBangkuBisnis(kdGerbong-1, kdKursi-1))==1)
                    {
                        found = true;
                        break;
                    }
                }else{
                    if((jadwal.get(i).getKereta().getBangkuPremium(kdGerbong, kdKursi))==1)
                    {
                        found = true;
                        break;
                    }
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

        //System.out.println(kdjadwal+"-"+ paid+"-"+ kdpesan+"-"+ harga+"-"+ user+"-"+ penumpang+"-"+ kursi);
        //long harga = 0;
        //String kdpesan = "";
        

        Booking B1 = new Booking(kdjadwal, paid, kdpesan, penumpang, kursi, harga, user.getEmail());
        booking.add(B1);
        user.getTransaksi().add(new Transaksi(kdpesan, tanggal, "BOOKED"));
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
        }
       }
       
   }

   public void bayar(String kode)
   {
        for(int i=0; i<booking.size(); i++)
        {
            if(kode.equals(booking.get(i).getKdPesan()))
            {
                if(booking.get(i).getIsPaid()==0)
                {
                    User user = ctrPenumpang.getUser(); 
                    ArrayList<User> users = ctrUtil.getUsers();
                    ControllerUser ctrUser = new ControllerUser(ctrMain);
                    int index = ctrUser.findEmailInUsers(user.getEmail());
                    String tanggal = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
                    user.getTransaksi().add(new Transaksi(kode, tanggal, "PAID"));
                    users.set(index, user);
                    ctrPenumpang.setUser(user);
                    ctrUtil.WriteJSONUser();
                }
                booking.get(i).setIsPaid(1);
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
    