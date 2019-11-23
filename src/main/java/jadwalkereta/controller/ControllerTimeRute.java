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
import jadwalkereta.model.Time;
import jadwalkereta.model.TimeRute;
import jadwalkereta.view.ViewTimeRute;

public class ControllerTimeRute {
    ArrayList<Rute> rute;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ControllerTime ctrTime;
    ArrayList<Time> times;
    ViewTimeRute viewTimeRute;
    Scanner input = new Scanner(System.in);

    public ControllerTimeRute(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrTime = new ControllerTime(admin);
        ctrMain = ctrAdmin.getControllerMain();
        rute = ctrMain.getRute();
        times = ctrMain.getTimes();
        
    }

    public void ControlMenuTimeRute() {
        if (viewTimeRute == null) viewTimeRute = new ViewTimeRute(this);
        viewTimeRute.menuTimeRute();

        switch (viewTimeRute.getPilihan()) {
        case 1: {
            viewTimeRute.menuTambah();
            ControlMenuTimeRute();
            break;
        }
        case 2: {
            viewTimeRute.menuLihat();
            ControlMenuTimeRute();
            break;
        }
        case 3: {
            viewTimeRute.menuHapus();
            ControlMenuTimeRute();
            break;
        }
        case 4: {
            ControlMenuTimeRute();
            break;
        }
        case 99:
            ctrAdmin.ControlMenuAdmin();
            break;
        default:
            System.out.println("Inputan Salah!");
            ControlMenuTimeRute();
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

    public boolean TambahTimeRute(String kdWaktu, int index){
        int indexTime=ctrTime.CheckWaktu(kdWaktu);
        int i;
        int indexKodeWaktu=-1;
        int jam=88;
        int menit=88;
        ArrayList<TimeRute> timerute = rute.get(index).getTimeRute();
        for (i=0; i < timerute.size(); i++) {
            if(timerute.get(i).getKdWaktu().equals(kdWaktu)){
                indexKodeWaktu=i;
            }
        }
//        int indexKArute=CheckTimeRute(kdKereta, index);
        if(indexTime >= 0){
            if(indexKodeWaktu>=0){
                System.out.println("Waktu Sudah Ada pada Rute");
                return false;
            }    
            else {
                for (i=0; i < times.size(); i++) {
                    if (kdWaktu.equals(times.get(i).getKode())) {
                        jam = times.get(i).getJam();
                        menit = times.get(i).getMenit();
                        break;
                    }
                }
                timerute.add(new TimeRute(kdWaktu,jam,menit));
                return true;
            }
        }
        else {
            System.out.println("Kode Waktu tidak ada dalam daftar Waktu");
            return false;
        }
    }

    public void LihatTimeRute(String kode) {
        int i = CheckRute(kode);
        if(i>=0)
        {
            String sjalur = "        -";
            int menit = 0;
            for (int j = 0; j < rute.get(i).getTimeRute().size(); j++) {
                TimeRute temp_timerute = rute.get(i).getTimeRute().get(j);
                if (j == 0) {
                    sjalur = "";
                    sjalur = sjalur + "- " + String.format("%02d",temp_timerute.getJam()) + "." + String.format("%02d",temp_timerute.getMenit()) + "\n";
                } else
                    sjalur = sjalur + "\t\t\t\t\t- " + String.format("%02d",temp_timerute.getJam()) + "." + String.format("%02d",temp_timerute.getMenit()) + "\n";
            }
            //sjalur = sjalur.substring(0, 9) + "\t\t" + menit + " menit" + sjalur.substring(9);
            System.out.println(i + 1 + "\t" + "KR" + String.format("%02d", i + 1) + "\t\t" + rute.get(i).getKodeRute()
                    + "\t\t" + sjalur);
        }

        else System.out.println("Kode Rute Tidak Ditemukan");
    }

    public void HapusTimeRute(int index){
        rute.get(index).setTimeRute(new ArrayList<TimeRute>());
    }
}