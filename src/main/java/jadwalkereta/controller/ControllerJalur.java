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

import jadwalkereta.model.Rute;
import jadwalkereta.model.Station;
import jadwalkereta.model.Jalur;
import jadwalkereta.view.ViewJalur;
import java.io.*;

public class ControllerJalur {
    ArrayList<Rute> rute;
    ControllerMain ctrMain;
    ControllerUtil ctrUtil = new ControllerUtil();
    ControllerAdmin ctrAdmin;
    ControllerStation ctrStation;
    ArrayList<Station> stations;
    ViewJalur viewJalur;
    Scanner input = new Scanner(System.in);

    public ControllerJalur(ControllerAdmin admin){
        ctrAdmin = admin;
        ctrStation = new ControllerStation(admin);
        ctrMain = ctrAdmin.getControllerMain();
        rute = ctrUtil.getRute();
        stations = ctrUtil.getStations();
    }

    public void ControlMenuJalur(){
        if (viewJalur == null) viewJalur = new ViewJalur(this);
        viewJalur.menuJalur();

        switch (viewJalur.getPilihan()) {
        case 1: {
            viewJalur.menuTambah();
            ControlMenuJalur();
            break;
        }
        case 2: {
            viewJalur.menuLihat();
            ControlMenuJalur();
            break;
        }
        case 3: {
            viewJalur.menuHapus();
            ControlMenuJalur();
            break;
        }
        case 4: {
            ControlMenuJalur();
            break;
        }
        case 99:
            ctrAdmin.ControlMenuAdmin();
            break;
        default:
            System.out.println("Inputan Salah!");
            ControlMenuJalur();
            break;
        }
    }

    public int CheckRute(String kode)
    {
        rute = ctrUtil.getRute();
        for(int i=0;i<rute.size();i++){
            if(rute.get(i).getKodeRute().equals(kode)) return i;
        }
        System.out.println("Rute Tidak Ditemukan");
        return -1;
    }

    public boolean TambahJalur(String stasiunAwal, String stasiunAkhir, int menit, int index){
        rute = ctrUtil.getRute();
        ArrayList<Jalur> jalur = rute.get(index).getJalur();
        if(ctrStation.CheckStationByName(stasiunAwal) >= 0 && ctrStation.CheckStationByName(stasiunAkhir) >= 0)
        {
            int indexawal = ctrStation.CheckStationByName(stasiunAwal);
            int indexakhir = ctrStation.CheckStationByName(stasiunAkhir);
            if(jalur.size() == 0){
                jalur.add(new Jalur(stations.get(indexawal), stations.get(indexakhir), menit));
                ctrUtil.WriteJSONRute();
                return true;
            }
                
            else if(stations.get(indexawal).equals(jalur.get(jalur.size() - 1).getStasiunAkhir())){
                jalur.add(new Jalur(stations.get(indexawal), stations.get(indexakhir), menit));
                ctrUtil.WriteJSONRute();
                return true;
            }
            else
                System.out.println("Jalur Tidak Berhubungan");    
        }
        else 
            System.out.println("Stasiun Salah");
        return false;
    }

    // public void LihatJalur() {
    //     for(int i = 0; i<rute.size(); i++){
    //         String sjalur = "         ";
    //         int menit = 0;
    //         for(int j = 0; j < rute.get(i).getJalur().size();j++){
    //             Jalur temp_jalur = rute.get(i).getJalur().get(j);
    //             menit += temp_jalur.getMenit();
    //             if(j==0) {
    //                 sjalur = "";
    //                 sjalur = sjalur+"- "+temp_jalur.getStasiunAwal().getKode()+"-"+temp_jalur.getStasiunAkhir().getKode()+"\n";
    //             }
    //             else sjalur = sjalur + "\t\t\t\t\t- " + temp_jalur.getStasiunAwal().getKode() + "-" + temp_jalur.getStasiunAkhir().getKode() + "\n";
    //         }
    //         sjalur = sjalur.substring(0,9) +"\t\t"+menit+" menit"+sjalur.substring(9);
    //         System.out.println(i+1+"\t"+"JL"+String.format("%02d",i+1)+"\t\t"+rute.get(i).getKodeRute()+"\t\t"+sjalur);
    //     }  
    // }


    public void LihatJalur(String kode) {
        rute = ctrUtil.getRute();
        int i = CheckRute(kode);
        if(i>=0)
        {
            String sjalur = "        -";
            int menit = 0;
            for (int j = 0; j < rute.get(i).getJalur().size(); j++) {
                Jalur temp_jalur = rute.get(i).getJalur().get(j);
                menit += temp_jalur.getMenit();
                if (j == 0) {
                    sjalur = "";
                    sjalur = sjalur + "- " + temp_jalur.getStasiunAwal().getKode() + "-"
                            + temp_jalur.getStasiunAkhir().getKode() + "\n";
                } else
                    sjalur = sjalur + "\t\t\t\t\t- " + temp_jalur.getStasiunAwal().getKode() + "-"
                            + temp_jalur.getStasiunAkhir().getKode() + "\n";
            }
            sjalur = sjalur.substring(0, 9) + "\t\t" + menit + " menit" + sjalur.substring(9);
            System.out.println(i + 1 + "\t" + "JL" + String.format("%02d", i + 1) + "\t\t" + rute.get(i).getKodeRute()
                    + "\t\t" + sjalur);
        }

        else System.out.println("Kode Rute Tidak Ditemukan");
    }

    public void HapusJalur(int index){
        rute = ctrUtil.getRute();
        rute.get(index).setJalur(new ArrayList<Jalur>());
        ctrUtil.WriteJSONRute();
    }

    public void LihatRute() {
        rute = ctrUtil.getRute();
        for (int i = 0; i < rute.size(); i++)
            System.out.println(i + 1 + "\t" + rute.get(i).getKotaBerangkat() + "\t\t\t" + rute.get(i).getKotaTujuan()
                    + "\t" + rute.get(i).getKodeRute() + "\t\t" + rute.get(i).getHargaBisnis() + "\t\t"
                    + rute.get(i).getHargaPremium());
    }
}