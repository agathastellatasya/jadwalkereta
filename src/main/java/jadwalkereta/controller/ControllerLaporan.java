/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.Booking;
import jadwalkereta.model.Jadwal;
import jadwalkereta.model.Jalur;
//import jadwalkereta.model.KARute;
import java.io.*;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Tanggal;
import jadwalkereta.model.TimeRute;
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
            viewLaporan.menuHarian();
            ControlMenuLaporan();
            break;
        }
        case 3:{
            viewLaporan.menuHarian();
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
        long sum=0;
        
        ArrayList<String> kereta = new ArrayList<String>();
        ArrayList<Long> harga = new ArrayList<Long>();
        for(int i=0;i<booking.size();i++)
        {
            String stanggal = booking.get(i).getTanggal();

            
            if(mtanggal.equals(stanggal))
            {
                
               System.out.println(stanggal);
               System.out.println(booking.get(i).getKdKereta());
               System.out.println(booking.get(i).getHarga());
                kereta.add(booking.get(i).getKdKereta());
                harga.add(booking.get(i).getHarga());
              
                
            }
        

        }
    }
   

}
