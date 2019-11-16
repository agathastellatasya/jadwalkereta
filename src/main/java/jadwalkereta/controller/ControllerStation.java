/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.Station;
import jadwalkereta.view.ViewStation;

/**
 *
 * @author ASUS
 */
public class ControllerStation {

    ArrayList<Station> stations;
    ControllerMain ctrMain;
    Scanner input = new Scanner(System.in);

    public ControllerStation(ControllerMain main, ArrayList<Station> s) {
        ctrMain = main;
        stations = s;
    }

    public void ControlMenuStation() {
        ViewStation viewStation = new ViewStation();
        viewStation.menuStation();

        switch (viewStation.getPilihan()) {
        case 1: {
            ViewTambahStation();
            ControlMenuStation();
            break;
        }
        case 2: {
            ViewLihatStation();
            ControlMenuStation();
            break;
        }
        case 3:{
            ViewEditStation();
            ControlMenuStation();
            break;
        }

        case 4: {
            ViewDeleteStation();
            ControlMenuStation();
            break;
        }
        case 99:
            ctrMain.run();
            break;
        default:
            System.out.println("Inputan Salah!");
            ControlMenuStation();
            break;
        }
    }


    public void ViewTambahStation(){
        System.out.println("#TAMBAH DATA STASIUN#");
        System.out.print("Tambah Stasiun : ");
        String kode = input.next();
        String nama = input.next();
        TambahStation(kode, nama);
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

    public void ViewDeleteStation(){
        System.out.println("#DELETE DATA STASIUN#");
        System.out.print("Delete Stasiun : ");
        String kode = input.next().split("_", 2)[1];
        int index = CheckStation(kode);
        if(index >= 0){
            DeleteStation(index);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Stasiun Berhasil Dihapus");
            System.out.println("--------------------------------------------------------------");
        }
        else{
            System.out.println("--------------------------------------------------------------");
            System.out.println("Stasiun Gagal Dihapus");
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

    public void ViewEditStation(){
        System.out.println("#EDIT DATA STASIUN#");
        System.out.print("Edit Stasiun : ");
        String kode = input.next().split("_",2)[1];
        int index = CheckStation(kode);
            
        if(index>=0){
            DeleteStation(index);
            System.out.print("Kode Stasiun : ");
            kode = input.next();
            System.out.print("Nama Stasiun : ");
            String nama = input.next();
            TambahStation(kode, nama);
        }
        else{
            System.out.println("--------------------------------------------------------------");
            System.out.println("Stasiun Gagal Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void ViewLihatStation()
    {
        System.out.println("#LIHAT DATA STASIUN#");
        System.out.println("Data Lengkap Stasiun");
        System.out.println("--------------------------------------------------------------");
        System.out.println("No\tKode\t\tNama");
        for(int i=0; i<stations.size();i++)
                System.out.println(i+1+"\t"+stations.get(i).getKode()+"\t\t"+stations.get(i).getNama());
        System.out.println("--------------------------------------------------------------");
    }



}
