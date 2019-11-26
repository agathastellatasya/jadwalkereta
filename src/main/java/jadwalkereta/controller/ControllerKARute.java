/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

//import jadwalkereta.model.Kota;
//import java.time.LocalDate;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
import jadwalkereta.model.City;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Kereta;
import jadwalkereta.view.ViewKARute;

public class ControllerKARute {
    ArrayList<Rute> rute;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ControllerUtil ctrUtil = new ControllerUtil();
    ControllerKereta ctrKereta;
    ArrayList<Kereta> kereta;
    ViewKARute viewKARute;
    Scanner input = new Scanner(System.in);

    public ControllerKARute(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrKereta = new ControllerKereta(admin);
        ctrMain = ctrAdmin.getControllerMain();
        rute = ctrUtil.getRute();
        kereta = ctrUtil.getKereta();
    }

    public void ControlMenuKARute(){
        if (viewKARute == null) viewKARute = new ViewKARute(this);
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
        case 3: {
            viewKARute.menuHapus();
            ControlMenuKARute();
            break;
        }
        case 4: {
            ControlMenuKARute();
            break;
        }
        case 99:
            ctrAdmin.ControlMenuAdmin();
            break;
        default:
            System.out.println("Inputan Salah!");
            ControlMenuKARute();
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
	
	public int CheckKeretaRute(String kode, int index)
    {
        String kB = rute.get(index).getKotaBerangkat();
        String kT = rute.get(index).getKotaTujuan();
        int k=-1;
        String kotaBerangkat, kotaTujuan;
        for(int i=0;i<rute.size();i++){
            for(int j=0;j<rute.get(i).getKereta().size();j++){
                kotaBerangkat = rute.get(i).getKotaBerangkat();
                kotaTujuan = rute.get(i).getKotaTujuan();
                //System.out.println(rute.get(i).getKereta().get(j).getKodeKereta());
                if(!kB.equals(kotaTujuan) || !kT.equals(kotaBerangkat)){
                    if(rute.get(i).getKereta().get(j).getKodeKereta().equals(kode))
                    k=i;
                }
            }
        }
        //System.out.println("Kereta Sudah ada pada Rute lain");
        return k;
    }

    public boolean TambahKARute(String kdKereta, int index){
        rute = ctrUtil.getRute();
		kereta = ctrUtil.getKereta();
        int indexKereta=ctrKereta.CheckKereta(kdKereta);
        int indexKodeKereta=-1;
		int indexKeretaRute=CheckKeretaRute(kdKereta, index);
        ArrayList<Kereta> kereta2 = rute.get(index).getKereta();
        for (int i=0; i < kereta2.size(); i++) {
            if(kereta2.get(i).getKodeKereta().equals(kdKereta)){
                indexKodeKereta=i;
            }
        }
        if(indexKereta>=0 && indexKodeKereta<0 && indexKeretaRute<0){
            Kereta kereta1 = kereta.get(indexKereta);
            rute.get(index).getKereta().add(kereta1);
			ctrUtil.WriteJSONRute();
			System.out.println("Kereta berhasil ditambahkan");
            return true;
        }
        else if(indexKereta>=0 && indexKodeKereta>=0){
            System.out.println("Kereta Sudah Ada pada Rute, kereta gagal ditambahkan");
            return false;
        }
        else if(indexKereta>=0 && indexKeretaRute>=0){
            System.out.println("Kereta Sudah Ada pada Rute Lain, kereta gagal ditambahkan");
            return false;
        }
        else {
            System.out.println("Kereta tidak ada dalam daftar Kereta");
            return false;
        }
    }

    public void LihatKARute(String kode) {
        rute = ctrUtil.getRute();
        int i = CheckRute(kode);
        if(i>=0)
        {
            String sjalur = "        -";
            int menit = 0;
            for (int j = 0; j < rute.get(i).getKereta().size(); j++) {
                Kereta temp_kereta = rute.get(i).getKereta().get(j);
                if (j == 0) {
                    sjalur = "";
                    sjalur = sjalur + "- " + temp_kereta.getKodeKereta() + "\n";
                } else
                    sjalur = sjalur + "\t\t\t\t\t\t\t- " + temp_kereta.getKodeKereta() + "\n";
            }
            //sjalur = sjalur.substring(0, 9) + "\t\t" + menit + " menit" + sjalur.substring(9);
            System.out.println(1 + "\t" + "KR" + String.format("%02d", i + 1) + "\t\t\t" + rute.get(i).getKodeRute()
                    + "\t\t\t" + sjalur);
        }

        else System.out.println("Kode Rute Tidak Ditemukan");
    }

    public void HapusKARute(int index){
        rute = ctrUtil.getRute();
        rute.get(index).setKereta(new ArrayList<Kereta>());
        ctrUtil.WriteJSONRute();
    }
}