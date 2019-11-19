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

    public void TambahKARute(int kode, String kodeRute, String kodeKA){
            karute.add(new KARute(kode, kodeRute, kodeKA));
            System.out.println("--------------------------------------------------------------");
            System.out.println("KA berdasarkan Rute Berhasil Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        
    }
    
    public void DeleteKA(String kr){
        int i;
        //System.out.println(karute.size());
        for (i=karute.size()-1; i>=0 ; i--) {
            if (kr.equals(karute.get(i).getKodeRute())) {
                karute.remove(i);
                //System.out.println(i+kr);
            }
            //System.out.println(i+kr);
        }
    }

    public int checkKAsama(String kodeRute, String kodeKA)
    {
        int i;
        boolean found = false;
        for (i=0; i < karute.size(); i++) {
            if (kodeRute.equals(karute.get(i).getKodeRute()) && kodeKA.equals(karute.get(i).getKodeKA())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }

    public int getKode()
    {
        int lastindex = karute.size() - 1;
        int kode = karute.get(lastindex).getKode() + 1;
        return kode;
    }

    public int checkRuteSama(String kodeRute)
    {
        int i;
        boolean found = false;
        for (i=0; i < karute.size(); i++) {
            if (kodeRute.equals(karute.get(i).getKodeRute())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
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
	
	public void LihatKARute(String kodeRute)
    {
        int j=0;
        for(int i=0; i<karute.size();i++)
        {
            if(kodeRute.equals(karute.get(i).getKodeRute()))
            {
                if(j==0)
                {
                    System.out.println("1"+"\t\t"+"KR"+String.format("%02d", karute.get(i).getKode())+"\t\t"+karute.get(i).getKodeRute()+"\t\t"+karute.get(i).getKodeKA());
                    j++;
                }else {
                    System.out.println("\t\t\t\t\t\t"+karute.get(i).getKodeKA());
                }
            }
        }
           
    }

	

}