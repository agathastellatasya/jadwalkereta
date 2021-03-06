/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

//import jadwalkereta.model.Kota;
import jadwalkereta.model.City;
//import jadwalkereta.model.KARute;

import java.util.ArrayList;
import java.util.Scanner;


import jadwalkereta.model.Kereta;
import jadwalkereta.model.Rute;
import jadwalkereta.view.ViewKereta;
import java.io.*;


public class ControllerKereta {
    ArrayList<Kereta> kereta;
    ControllerMain ctrMain;
    ControllerUtil ctrUtil = new ControllerUtil();
    ControllerAdmin ctrAdmin;
    ViewKereta viewKereta;
    Scanner input = new Scanner(System.in);

    public ControllerKereta(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        kereta = ctrUtil.getKereta();
    }

    public void ControlMenuKereta(){
        if(viewKereta == null) viewKereta = new ViewKereta(this);
        viewKereta.menuKereta();

        switch (viewKereta.getPilihan()) {
        case 1: {
            viewKereta.menuTambah();
            ControlMenuKereta();
            break;
        }
        case 2: {
            viewKereta.menuLihat();
            ControlMenuKereta();
            break;
        }
        case 3:{
            viewKereta.menuEdit();
            ControlMenuKereta();
            break;
        }

        case 4: {
            viewKereta.menuDelete();
            ControlMenuKereta();
            break;
        }
        case 99:
            ctrAdmin.ControlMenuAdmin();
            break;
        default:
            System.out.println("Inputan Salah!");
            ControlMenuKereta();
            break;
        }
    }

    public void TambahKereta(String kodeKereta, String namaKereta, String jmlA, String jmlB, String jmlC){
        kereta = ctrUtil.getKereta();
        int index = CheckKereta(kodeKereta);
        //System.out.println(kotaB);
        //System.out.println(kotaT);
        if(index<0){
			char x = jmlA.charAt(0);
			char y = jmlB.charAt(0);
			char z = jmlC.charAt(0);
			String strjmlGerbong = jmlA.replaceAll("[\\D]", ""); 
			int jmlGerbong = Integer.valueOf(strjmlGerbong);
			String strjmlBisnis = jmlB.replaceAll("[\\D]", ""); 
			int jmlBisnis = Integer.valueOf(strjmlBisnis);
			String strjmlPremium = jmlC.replaceAll("[\\D]", ""); 
			int jmlPremium = Integer.valueOf(strjmlPremium);
                        if(jmlGerbong <= 6) {
                            if((x=='G' || x=='g') && (y=='B' || y=='b') && (z=='P' || z=='p') && (jmlGerbong==jmlBisnis+jmlPremium)){
				kereta.add(new Kereta(kodeKereta, namaKereta, jmlGerbong, jmlBisnis, jmlPremium));
				System.out.println("--------------------------------------------------------------");
				System.out.println("Kereta Berhasil Ditambahkan");
				System.out.println("--------------------------------------------------------------");
                            }
                            else {
                                    System.out.println("--------------------------------------------------------------");
                                    System.out.println("Format Input Salah");
                                    System.out.println("--------------------------------------------------------------");
                                    //viewKereta.menuTambah();
                            }
                        }
                        else {
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("Jumlah Gerbong Maksimal 6");
                            System.out.println("--------------------------------------------------------------");
                        }
			
        }    
        else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Kode Kereta sudah ada, Kereta Gagal Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        }
        ctrUtil.WriteJSONKereta();
    }
    
    public void DeleteKereta(int index){
        kereta = ctrUtil.getKereta();
        kereta.remove(index);
        ctrUtil.WriteJSONKereta();
    }

    public int CheckKereta(String kodeKereta){
        kereta = ctrUtil.getKereta();
        int i;
        boolean found = false;
        for (i=0; i < kereta.size(); i++) {
            if (kodeKereta.equals(kereta.get(i).getKodeKereta())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }

    // cek dependensi KA ke KA berdasarkan Rute (KARute)
    public int CheckKARute(String kodeKA){
        int i;
        boolean found = false;
        ArrayList<Rute> rute = ctrUtil.getRute();
        for (i=0; i < rute.size(); i++) {
            for(int j=0;j<rute.get(i).getKereta().size();j++) {
                if (kodeKA.equals(rute.get(i).getKereta().get(j).getKodeKereta())) {
                    found = true;
                    break;
                }
            }
        }
        if(found) return i;
        else return -1;
    }
	
	public void LihatKereta()
    {
        kereta = ctrUtil.getKereta();
        for(int i=0; i<kereta.size();i++)
            System.out.println(i+1+"\t"+kereta.get(i).getKodeKereta()+"\t"+kereta.get(i).getNamaKereta()+"\t\t\t"+kereta.get(i).getJmlGerbong()+"\t\t"+kereta.get(i).getJmlBisnis()+"\t\t\t"+kereta.get(i).getJmlPremium());
    }

}