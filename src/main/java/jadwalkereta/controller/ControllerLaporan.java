/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.*;
import java.util.Scanner;

import jadwalkereta.model.Booking;
import jadwalkereta.model.Jadwal;
import jadwalkereta.model.Jalur;
//import jadwalkereta.model.KARute;
import java.io.*;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Tanggal;
import jadwalkereta.view.ViewBooking;
import jadwalkereta.view.ViewLaporan;

/**
 *
 * @author ASUS
 */
public class ControllerLaporan  {

   //ArrayList<Jadwal> jadwal;
    ArrayList<Booking> booking;
    ControllerMain ctrMain;
    ControllerUtil ctrUtil = new ControllerUtil();
    ControllerAdmin ctrAdmin;
    ViewLaporan viewLaporan;
    Scanner input = new Scanner(System.in);

    public ControllerLaporan(ControllerAdmin admin){
       // ctrBooking = booking;
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        //ctrMain = ctrPenumpang.getControllerMain();
        booking = ctrUtil.getBooking();
    }

    public void ControlMenuLaporan(){
        if(viewLaporan == null) viewLaporan = new ViewLaporan(this);
        viewLaporan.menuLaporan();

        switch (viewLaporan.getPilihan()) {
        case 1: {
            viewLaporan.menuHarian();
            ControlMenuLaporan();
            break;
        }
        case 2: {
            viewLaporan.menuBulanan();
            ControlMenuLaporan();
            break;
        }
        case 3:{
            viewLaporan.menuTahunan();
            ControlMenuLaporan();
            break;
        }
        case 99:
            ctrAdmin.ControlMenuAdmin();
            break;
        default:
            System.out.println("Inputan Salah!");
            ControlMenuLaporan();
            break;
        }
    }
    

    public void MenuHarian(String mtanggal){
        //jadwal = ctrUtil.getJadwal();
        booking = ctrUtil.getBooking();
        Set<String> uniqueKereta = new HashSet<String>();
        ArrayList<Booking> tempbook = new ArrayList<Booking>();
        for(int i=0;i<booking.size();i++)
        {
            String stanggal = booking.get(i).getTanggal();
            if(mtanggal.equals(stanggal)&&booking.get(i).getIsPaid()==1)
            {
               tempbook.add(booking.get(i));
               uniqueKereta.add(booking.get(i).getKdKereta()); 
            }
        }

        String[] namakereta = new String[uniqueKereta.size()];
        uniqueKereta.toArray(namakereta);
        int[] total = new int[uniqueKereta.size()];
        int grandtotal = 0;

        Arrays.sort(namakereta);
        for(int i=0;i<namakereta.length;i++)
        {
            for(int j=0;j<tempbook.size();j++){
                if(tempbook.get(j).getKdKereta().equals(namakereta[i]))
                {
                    //System.out.println("Masuk Sini");
                    total[i]+=tempbook.get(j).getHarga();
                    grandtotal+=tempbook.get(j).getHarga();
                }
            }
        }

        for(int i=0;i<namakereta.length;i++){
            System.out.print(i+1);
            System.out.print("\t"+mtanggal);  
            System.out.print("\t"+namakereta[i]);
            System.out.print("\t"+total[i]);
            System.out.println();
        }
        System.out.println("\nTotal Masukan Harian: "+grandtotal);
    }

    public void MenuBulanan(String mtanggal){
        //jadwal = ctrUtil.getJadwal();
        booking = ctrUtil.getBooking();
        Set<String> uniqueTanggal = new HashSet<String>();
        ArrayList<Booking> tempbook = new ArrayList<Booking>();
        for(int i=0;i<booking.size();i++)
        {
            String[] xtanggal = booking.get(i).getTanggal().split("-");
            int bulan = Integer.valueOf(xtanggal[1]);
            int tahun = Integer.valueOf(xtanggal[2]);
            String stanggal = bulan+"-"+tahun;

            if(mtanggal.equals(stanggal)&&booking.get(i).getIsPaid()==1)
            {
               tempbook.add(booking.get(i));
               uniqueTanggal.add(booking.get(i).getTanggal()); 
            }
        }

        String[] namatanggal = new String[uniqueTanggal.size()];
        uniqueTanggal.toArray(namatanggal);
        int[] total = new int[uniqueTanggal.size()];
        int grandtotal = 0;

        Arrays.sort(namatanggal);
        for(int i=0;i<namatanggal.length;i++)
        {
            for(int j=0;j<tempbook.size();j++){
                if(tempbook.get(j).getTanggal().equals(namatanggal[i]))
                {
                    //System.out.println("Masuk Sini");
                    total[i]+=tempbook.get(j).getHarga();
                    grandtotal+=tempbook.get(j).getHarga();
                }
            }
        }

        for(int i=0;i<namatanggal.length;i++){
            System.out.print(i+1);
            System.out.print("\t"+namatanggal[i]);
            System.out.print("\t"+total[i]);
            System.out.println();
        }
        System.out.println("\nTotal Masukan Bulanan: "+grandtotal);
    }

    public void MenuTahunan(String mtanggal){
        //jadwal = ctrUtil.getJadwal();
        booking = ctrUtil.getBooking();
        Set<String> uniqueBulan = new HashSet<String>();
        ArrayList<Booking> tempbook = new ArrayList<Booking>();
        for(int i=0;i<booking.size();i++)
        {
            String stanggal = booking.get(i).getTanggal().split("-")[2];
            
            if(mtanggal.equals(stanggal)&&booking.get(i).getIsPaid()==1)
            {
               tempbook.add(booking.get(i));
               uniqueBulan.add(booking.get(i).getTanggal().split("-")[1]); 
            }
        }

        String[] namabulan = new String[uniqueBulan.size()];
        uniqueBulan.toArray(namabulan);
        int[] total = new int[uniqueBulan.size()];
        int grandtotal = 0;

        Arrays.sort(namabulan);
        for(int i=0;i<namabulan.length;i++)
        {
            for(int j=0;j<tempbook.size();j++){
                if(tempbook.get(j).getTanggal().split("-")[1].equals(namabulan[i]))
                {
                    //System.out.println("Masuk Sini");
                    total[i]+=tempbook.get(j).getHarga();
                    grandtotal+=tempbook.get(j).getHarga();
                }
            }
        }

        for(int i=0;i<namabulan.length;i++){
            System.out.print(i+1);  
            System.out.print("\t"+namabulan[i]);
            System.out.print("\t"+total[i]);
            System.out.println();
        }
        System.out.println("\nTotal Masukan Tahunan: "+grandtotal);
    }

}
