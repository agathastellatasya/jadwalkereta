/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

//import jadwalkereta.model.Kota;
import jadwalkereta.model.City;
import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.Kereta;
import jadwalkereta.model.Rute;
import jadwalkereta.view.ViewKereta;
import jadwalkereta.model.KARute;
import jadwalkereta.view.ViewKARute;

public class ControllerKARute {
    ArrayList<KARute> karute;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ViewKARute viewKARute;
    Scanner input = new Scanner(System.in);

    public ControllerKARute(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        karute = ctrMain.getKARute();
    }

    public void ControlMenuKARute() {
        if(viewKARute == null) viewKARute = new ViewKARute(this);
        viewKARute.menuKARute();

        switch (viewKARute.getPilihan()) {
        case 1: {
            viewKARute.menuTambah();
            ControlMenuKARute();
            break;
        }
        case 2: {
            viewKARute.menuLihat();
            ControlMenuKARute();
            break;
        }
        case 3:{
            viewKARute.menuDelete();
            ControlMenuKARute();
            break;
        }
        case 99:
            ctrAdmin.ControlMenuAdmin();
            try{
                this.finalize();
            }
            catch(Throwable ex){
                ex.printStackTrace();
            }
            break;
        default:
            System.out.println("Inputan Salah!");
            ControlMenuKARute();
            break;
        }
    }

    public void TambahKARute(String kodeRute, String kodeKA){
            karute.add(new KARute(kodeRute, kodeKA));
            System.out.println("--------------------------------------------------------------");
            System.out.println("KA berdasarkan Rute Berhasil Ditambahkan");
            System.out.println("--------------------------------------------------------------");
    }
    
    public void DeleteKA(String kr){
        int i;
        System.out.println(karute.size());
        for (i=karute.size()-1; i>=0 ; i--) {
            if (kr.equals(karute.get(i).getKodeRute())) {
                karute.remove(i);
                //System.out.println(i+kr);
            }
            //System.out.println(i+kr);
        }
    }

    public int CheckRute(String kodeRute){
        int i;
        boolean found = false;
        ArrayList<Rute> rute = ctrMain.getRute();
        for (i=0; i < rute.size(); i++) {
            if (kodeRute.equals(rute.get(i).getKodeRute())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }

    public int CheckKA(String kodeKereta){
        int i;
        boolean found = false;
        ArrayList<Kereta> kereta = ctrMain.getKereta();
        for (i=0; i < kereta.size(); i++) {
            if (kodeKereta.equals(kereta.get(i).getKodeKereta())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }
	
	public void LihatKARute()
    {
        for(int i=0; i<karute.size();i++)
            System.out.println(i+1+"\t\t"+"KR"+"\t\t"+karute.get(i).getKodeRute()+"\t\t"+karute.get(i).getKodeKA());
    }

}