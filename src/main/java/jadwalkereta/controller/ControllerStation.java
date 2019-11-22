/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.Jalur;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Station;
import jadwalkereta.view.ViewStation;

/**
 *
 * @author ASUS
 */
public class ControllerStation {

    ArrayList<Station> stations;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ViewStation viewStation;
    Scanner input = new Scanner(System.in);

    public ControllerStation(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        stations = ctrMain.getStations();
    }

    public void ControlMenuStation() {
        if(viewStation == null) viewStation = new ViewStation(this);
        viewStation.menuStation();

        switch (viewStation.getPilihan()) {
        case 1: {
            viewStation.menuTambah();
            ControlMenuStation();
            break;
        }
        case 2: {
            viewStation.menuLihat();
            ControlMenuStation();
            break;
        }
        case 3:{
            viewStation.menuEdit();
            ControlMenuStation();
            break;
        }

        case 4: {
            viewStation.menuDelete();
            ControlMenuStation();
            break;
        }
        case 99:
            ctrAdmin.ControlMenuAdmin();
            break;
        default:
            System.out.println("Inputan Salah!");
            ControlMenuStation();
            break;
        }
    }

    public void TambahStation(String kode, String nama){
        int index = CheckStation(kode);
        if (index<0) {
            stations.add(new Station(kode, nama));
            System.out.println("--------------------------------------------------------------");
            System.out.println("Stasiun Berhasil Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Stasiun Gagal Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void DeleteStation(int index)
    {
        stations.remove(index);
    }

    public int CheckStation(String kode){
        int i = 0;
        boolean found = false;
        for (; i < stations.size(); i++) {
            if (kode.equals(stations.get(i).getKode())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }

    public int CheckStationByName(String nama) {
        int i = 0;
        boolean found = false;
        for (; i < stations.size(); i++) {
            if (nama.equals(stations.get(i).getNama())) {
                found = true;
                break;
            }
        }
        if (found)
            return i;
        else
            return -1;
    }

    public void LihatStation()
    {
        for(int i=0; i<stations.size();i++)
                System.out.println(i+1+"\t"+stations.get(i).getKode()+"\t\t"+stations.get(i).getNama());
    }

    //check dependensi Stasiun ke Jalur lewat array Rute
    public int CheckStationJalur(String kode){
        int i = 0;
        int j, k;
        String Kota = "";
        int flag = 0;
        boolean found = false;
        ArrayList<Rute> rute = ctrMain.getRute();
        
        while (flag==0 && i<stations.size())
        {
            if(kode.equals(stations.get(i).getKode()))
            {
                Kota = stations.get(i).getNama();
                flag = 1;
                break;
            }
            i++;
        }
        
        if(flag == 1)
        {
            for (j=0; j<rute.size(); j++) {
                for (k=0; k<rute.get(j).getJalur().size(); k++)
                {
                    if(Kota.equals(rute.get(j).getJalur().get(k).getStasiunAwal().getNama()) || Kota.equals(rute.get(j).getJalur().get(k).getStasiunAkhir().getNama()) ) {
                        found = true;
                        break;
                    }
                }   
            }
        }
        
        if(found) return i;
        else return -1;
    }



}
