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
import jadwalkereta.model.Kereta;
import jadwalkereta.view.ViewKARute;

public class ControllerKARute {
    ArrayList<Rute> rute;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ControllerKereta ctrKereta;
    ArrayList<Kereta> kereta;
    ViewKARute viewKARute;
    Scanner input = new Scanner(System.in);

    public ControllerKARute(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrKereta = new ControllerKereta(admin);
        ctrMain = ctrAdmin.getControllerMain();
        rute = ctrMain.getRute();
        kereta = ctrMain.getKereta();
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
        rute = ctrMain.getRute();
        for(int i=0;i<rute.size();i++){
            if(rute.get(i).getKodeRute().equals(kode)) return i;
        }
        System.out.println("Rute Tidak Ditemukan");
        return -1;
    }

    public boolean TambahKARute(String kdKereta, int index){
        rute = ctrMain.getRute();
        int indexKereta=ctrKereta.CheckKereta(kdKereta);
        int indexKodeKereta=-1;
        ArrayList<Kereta> kereta2 = rute.get(index).getKereta();
        for (int i=0; i < kereta2.size(); i++) {
            if(kereta2.get(i).getKodeKereta().equals(kdKereta)){
                indexKodeKereta=i;
            }
        }
        if(indexKereta>=0 && indexKodeKereta<0){
            Kereta kereta1 = kereta.get(indexKereta);
            rute.get(index).getKereta().add(kereta1);
            return true;
        }
        else if(indexKereta>=0 && indexKodeKereta>=0){
            System.out.println("Kereta Sudah Ada pada Rute");
            return false;
        }
        else {
            System.out.println("Kereta tidak ada dalam daftar Kereta");
            return false;
        }
    }

    public void LihatKARute(String kode) {
        rute = ctrMain.getRute();
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
        rute = ctrMain.getRute();
        rute.get(index).setKereta(new ArrayList<Kereta>());
        ctrMain.WriteJSONRute();
    }
}