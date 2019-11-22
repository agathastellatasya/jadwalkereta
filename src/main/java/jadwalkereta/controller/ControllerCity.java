/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.City;
import jadwalkereta.model.Rute;
import jadwalkereta.view.ViewCity;

/**
 *
 * @author ASUS
 */
public class ControllerCity {

    ArrayList<City> cities;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ViewCity viewCity;
    Scanner input = new Scanner(System.in);

    public ControllerCity(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        cities = ctrMain.getCities();
    }

    public void ControlMenuCity() {
        if(viewCity == null) viewCity = new ViewCity(this);
        viewCity.menuCity();
        switch (viewCity.getPilihan()) {
        case 1: {
            viewCity.menuTambah();
            ControlMenuCity();
            break;
        }
        case 2: {
            viewCity.menuLihat();
            ControlMenuCity();
            break;
        }
        case 3:{
            viewCity.menuEdit();
            ControlMenuCity();
            break;
        }

        case 4: {
            viewCity.menuDelete();
            ControlMenuCity();
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
            ControlMenuCity();
            break;
        }
    }

    public void TambahCity(String kode, String nama){
        int index = CheckCity(kode);
        if (index<0) {
            cities.add(new City(kode, nama));
            System.out.println("--------------------------------------------------------------");
            System.out.println("Kota Berhasil Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Kota Sudah Ada, Gagal Menambahkan");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void DeleteCity(int index)
    {
        cities.remove(index);
    }

    public int CheckCity(String kode){
        int i = 0;
        boolean found = false;
        for (; i < cities.size(); i++) {
            if (kode.equals(cities.get(i).getKode())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }

    public void ViewEditCity(){
        System.out.println("#EDIT DATA KOTA#");
        System.out.print("Edit Kota : ");
        String kode = input.next().split("_",2)[1];
        int index = CheckCity(kode);
            
        if(index>=0){
            DeleteCity(index);
            System.out.print("Kode Kota : ");
            kode = input.next();
            System.out.print("Nama Kota : ");
            String nama = input.next();
            TambahCity(kode, nama);
        }
        else{
            System.out.println("--------------------------------------------------------------");
            System.out.println("Kota Gagal Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void LihatCity()
    {
        for(int i=0; i<cities.size();i++)
                System.out.println(i+1+"\t"+cities.get(i).getKode()+"\t\t"+cities.get(i).getNama());
    }

    


    // cek dependensi Kota ke Rute
    public int CheckRute(String kode){
        int j=0, i=0;
        String nama = "";
        boolean found = false;
        int flag = 0;
        ArrayList<Rute> rute = ctrMain.getRute();

        while (i < cities.size() && flag==0)
        {
            if(kode.equals(cities.get(i).getKode()))
            {
                nama = cities.get(i).getNama();
                flag=1;
                break;
            }
            i++;
        }

        while(j<rute.size() && flag == 1)
        {
           // if(nama.equals(rute.get(j).getKotaBerangkat()))
            if(nama.equals(rute.get(j).getKotaBerangkat()) || nama.equals(rute.get(j).getKotaTujuan()))
            {
                found = true;
                break;
            }
           j++;

        }

        if(found) return j;
        else return -1;
    }
}


