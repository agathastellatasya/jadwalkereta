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
import java.io.*;
import jadwalkereta.model.Rute;
import jadwalkereta.view.ViewRute;


public class ControllerRute {
    public ArrayList<Rute> rute;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ViewRute viewRute;
    Scanner input = new Scanner(System.in);

    public ControllerRute(ControllerAdmin admin){
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        rute = ctrMain.getRute();
    }

    public ControllerMain getControllerMain(){ return ctrMain; }

    public void ControlMenuRute(){
        if(viewRute == null) viewRute = new ViewRute(this);
        viewRute.menuRute();

        switch (viewRute.getPilihan()) {
        case 1: {
            viewRute.menuTambah();
            ControlMenuRute();
            break;
        }
        case 2: {
            viewRute.menuLihat();
            ControlMenuRute();
            break;
        }
        case 3:{
            viewRute.menuEdit();
            ControlMenuRute();
            break;
        }

        case 4: {
            viewRute.menuDelete();
            ControlMenuRute();
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
            ControlMenuRute();
            break;
        }
    }

    public void TambahRute(String kotaBerangkat, String kotaTujuan, long hargaBisnis, long hargaPremium){
        rute = ctrMain.getRute();
        int kotaB = CheckKotaB(kotaBerangkat);
		int kotaT = CheckKotaB(kotaTujuan);
        //System.out.println(kotaB);
        //System.out.println(kotaT);
        if(kotaB>=0 && kotaT>=0){
            String kodeRute = BuatRute(kotaB,kotaT);
            rute.add(new Rute(kodeRute, hargaBisnis, hargaPremium, kotaBerangkat, kotaTujuan));
            System.out.println("--------------------------------------------------------------");
            System.out.println("Rute Berhasil Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        }    
        else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Rute Gagal Ditambahkan");
            System.out.println("--------------------------------------------------------------");
        }
    }
    
    public String BuatRute(int kotaB, int kotaT){
        ArrayList<City> kotaA = ctrMain.getCities();
        String kotaBerangkat = kotaA.get(kotaB).getKode();
        String kotaTujuan = kotaA.get(kotaT).getKode();
        return (kotaBerangkat + "-" + kotaTujuan);
    }

    public void DeleteRute(int index){
        rute = ctrMain.getRute();
        rute.remove(index);
        ctrMain.WriteJSONRute();
    }

    public int CheckRute(String kodeRute){
        rute = ctrMain.getRute();
        int i;
        boolean found = false;
        for (i=0; i < rute.size(); i++) {
            if (kodeRute.equals(rute.get(i).getKodeRute())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }
    
    public int CheckKotaB(String kotaB){
        int i;
        boolean found = false;
        //ArrayList<Kota> kotaA = Kota.getKota() ;
        ArrayList<City> kotaA = ctrMain.getCities();
        for (i=0; i < kotaA.size(); i++) {
            if (kotaB.equals(kotaA.get(i).getNama())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }
	
	public void LihatRute()
    {
        rute = ctrMain.getRute();
        for(int i=0; i<rute.size();i++)
            System.out.println(i+1+"\t"+rute.get(i).getKotaBerangkat()+" "+"\t\t"+rute.get(i).getKotaTujuan()+" \t"+rute.get(i).getKodeRute()+"\t\t"+rute.get(i).getHargaBisnis()+"\t"+rute.get(i).getHargaPremium());
    }

}