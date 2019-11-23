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
import jadwalkereta.model.Kereta;
import jadwalkereta.model.KARute;
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

    public void ControlMenuKARute() {
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
        for(int i=0;i<rute.size();i++){
            if(rute.get(i).getKodeRute().equals(kode)) return i;
        }
        System.out.println("Rute Tidak Ditemukan");
        return -1;
    }

    public boolean TambahKARute(String kdKereta, int index){
        int indexKereta=ctrKereta.CheckKereta(kdKereta);
        ArrayList<KARute> karute = rute.get(index).getKARute();
//        int indexKArute=CheckKARute(kdKereta, index);
        if(ctrKereta.CheckKereta(kdKereta) >= 0){
            if(kereta.get(indexKereta).getKodeKereta().equals(kdKereta)){
                System.out.println("Kereta Sudah Ada pada Rute");
                return false;
            }
            else {
                karute.add(new KARute(kereta.get(indexKereta)));
                return true;
            }
        }
        else {
            System.out.println("Kereta tidak ada dalam daftar Kereta");
            return false;
        }
    }

    public void LihatKARute(String kode) {
        int i = CheckRute(kode);
        if(i>=0)
        {
            String sjalur = "        -";
            int menit = 0;
            for (int j = 0; j < rute.get(i).getKARute().size(); j++) {
                KARute temp_karute = rute.get(i).getKARute().get(j);
                if (j == 0) {
                    sjalur = "";
                    sjalur = sjalur + "- " + temp_karute.getKdKereta().getKodeKereta() + "\n";
                } else
                    sjalur = sjalur + "\t\t\t\t\t- " + temp_karute.getKdKereta().getKodeKereta() + "\n";
            }
            //sjalur = sjalur.substring(0, 9) + "\t\t" + menit + " menit" + sjalur.substring(9);
            System.out.println(i + 1 + "\t" + "KR" + String.format("%02d", i + 1) + "\t\t" + rute.get(i).getKodeRute()
                    + "\t\t" + sjalur);
        }

        else System.out.println("Kode Rute Tidak Ditemukan");
    }

    public void HapusKARute(int index){
        rute.get(index).setKARute(new ArrayList<KARute>());
    }
}