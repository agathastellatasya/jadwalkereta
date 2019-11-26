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
        long sumHarga=0;
        int i,j,x,n,m;
		String stanggal;
        ArrayList<String> kereta = new ArrayList<String>();
		ArrayList<String> kereta2 = new ArrayList<String>();
        ArrayList<Long> harga = new ArrayList<Long>();
        for(i=0;i<booking.size();i++)
        {   stanggal = booking.get(i).getTanggal();
            if(mtanggal.equals(stanggal) && booking.get(i).getIsPaid()==1)
            { 
                kereta.add(booking.get(i).getKdKereta());
                harga.add(booking.get(i).getHarga());
		kereta2.add(booking.get(i).getKdKereta());
            }
        }
		n = kereta.size();
		for(i=0; i< n; i++){
			for(j=i+1;j<n;){
				if(kereta.get(i).equals(kereta.get(j)) ){
					for(x=j;x<n;x++){
						kereta.get(x).equals(kereta.get(x-1));
					}
					n--;
				}
				else {
					j++;
				}
				
			}
			
		}
		m = kereta2.size();
                n = kereta.size();
		for(i=0;i<n;i++){
                    System.out.print(i+1);
                    System.out.print("\t"+mtanggal);
			sumHarga=0;
			System.out.print("\t"+kereta.get(i));
			for(j=0;j<m;j++){
				if(kereta.get(i).equals(kereta2.get(j))){
					sumHarga = sumHarga + harga.get(j);
				}
			}
                        
			System.out.println("\t\t"+sumHarga);
		}
    }
    
    public void MenuBulanan(String mtanggal){
        //jadwal = ctrUtil.getJadwal();
        booking = ctrUtil.getBooking();
        long sumHarga=0;
        int i,j,x,n,m;
        ArrayList<String> kereta = new ArrayList<String>();
		ArrayList<String> kereta2 = new ArrayList<String>();
        ArrayList<Long> harga = new ArrayList<Long>();
        for(i=0;i<booking.size();i++)
        {   String[] xtanggal = booking.get(i).getTanggal().split("-");
            int bulan = Integer.valueOf(xtanggal[1]);
            int tahun = Integer.valueOf(xtanggal[2]);
            String stanggal = bulan+"-"+tahun;
            //System.out.println(stanggal);
            if(mtanggal.equals(stanggal) && booking.get(i).getIsPaid()==1)
            { 
                kereta.add(booking.get(i).getTanggal());
                harga.add(booking.get(i).getHarga());
		kereta2.add(booking.get(i).getTanggal());
            }
        }
		n = kereta.size();
		for(i=0; i< n; i++){
			for(j=i+1;j<n;){
				if(kereta.get(i).equals(kereta.get(j)) ){
					for(x=j;x<n;x++){
						kereta.get(x).equals(kereta.get(x-1));
					}
					n--;
				}
				else {
					j++;
				}
				
			}
			
		}
		m = kereta2.size();
                //System.out.print(m);
                
                //n = kereta.size();
                //System.out.print(n);
		for(i=0;i<n;i++){
                    System.out.print(i+1);
                    //System.out.print("\t"+mtanggal);
			sumHarga=0;
			System.out.print("\t"+kereta.get(i));
			for(j=0;j<m;j++){
				if(kereta.get(i).equals(kereta2.get(j))){
					sumHarga = sumHarga + harga.get(j);
				}
			}
                        
			System.out.println("\t\t"+sumHarga);
		}
    }
    
    public void MenuTahunan(String mtanggal){
        //jadwal = ctrUtil.getJadwal();
        booking = ctrUtil.getBooking();
        long sumHarga=0;
        int i,j,x,n,m;
        ArrayList<String> bln = new ArrayList<String>();
	ArrayList<String> bln2 = new ArrayList<String>();
        ArrayList<Long> harga = new ArrayList<Long>();
        for(i=0;i<booking.size();i++)
        {   String stanggal = booking.get(i).getTanggal().split("-")[2];
            //System.out.println(stanggal);
            if(mtanggal.equals(stanggal) && booking.get(i).getIsPaid()==1)
            { 
                //System.out.println(booking.get(i).getTanggal().split("-")[1]);
                bln.add(booking.get(i).getTanggal().split("-")[1]);
		bln2.add(booking.get(i).getTanggal().split("-")[1]);
                harga.add(booking.get(i).getHarga());
            }
        }
		n = bln.size();
                
                /*for (i = 0; i < n; i++) {
                    for (j = i+1; j < n; j++) {
                        if (bln.get(i).equals(bln.get(j))) {
                            bln.remove(j);
                            j--;
                        }
                    }
                }*/
		for(i=0; i< n; i++){
			for(j=i+1;j<n;){
				if(bln.get(i).equals(bln.get(j)) ){
					for(x=j;x<n;x++){
						bln.get(x).equals(bln.get(x-1));
                                                //bln.remove(x-1);
					}
					n--;
				}
				else {
					j++;
				}
				
			}
			
		}
		m = bln2.size();
                System.out.print(m);
                
                n = bln.size();
                System.out.print(n);
		for(i=0;i<n;i++){
                    System.out.print(i+1);
                    //System.out.print("\t"+mtanggal);
			sumHarga=0;
			System.out.print("\t"+bln.get(i));
			for(j=0;j<m;j++){
				if(bln.get(i).equals(bln2.get(j))){
					sumHarga = sumHarga + harga.get(j);
				}
			}
                        
			System.out.println("\t\t"+sumHarga);
		}
    }
   

}
