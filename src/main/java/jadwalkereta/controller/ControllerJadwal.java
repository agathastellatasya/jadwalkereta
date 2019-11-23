/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.Jadwal;
import jadwalkereta.model.Jalur;
import jadwalkereta.model.KARute;
import jadwalkereta.model.Rute;
import jadwalkereta.model.TimeRute;
import jadwalkereta.view.ViewJadwal;

/**
 *
 * @author ASUS
 */
public class ControllerJadwal {

    ArrayList<Jadwal> jadwal;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ViewJadwal viewJadwal;
    Scanner input = new Scanner(System.in);

    public ControllerJadwal(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        jadwal = ctrMain.getJadwal();
    }

    public void ControlMenuJadwal() {
        if(viewJadwal == null) viewJadwal = new ViewJadwal(this);
        if(jadwal.size()<=0) viewJadwal.menuGenerateJadwal();
        viewJadwal.menuJadwal();
        switch(viewJadwal.getPilihan()){
            case 1: {
                viewJadwal.menuLihatJadwal();
                ControlMenuJadwal();
                break;
            }
            case 99:{
                ctrAdmin.ControlMenuAdmin();
                break;
            }
        }
    }

    public void GenerateJadwal(){
        //ArrayList<TimeRute> timerute = ctrMain.getTimeRute();
        //ArrayList<KARute> karute = ctrMain.getKARute();
        int i,j,k,jam,menit;
	String kdKereta,kdWaktu,koderute,kotaBerangkat,kotaTujuan = "";
        ArrayList<Rute> rute = ctrMain.getRute();
        for (i=0; i < rute.size(); i++) {
            koderute = rute.get(i).getKodeRute();
            kotaBerangkat = rute.get(i).getKotaBerangkat();
            kotaTujuan = rute.get(i).getKotaTujuan();
            ArrayList<KARute> karute = rute.get(i).getKARute();
            ArrayList<TimeRute> timerute = rute.get(i).getTimeRute();
            ArrayList<Jalur> jalur = rute.get(i).getJalur();
            int wktTempuh = 0;
            for (int l = 0; l < jalur.size(); l++) {
                Jalur temp_jalur = jalur.get(l);
                wktTempuh += temp_jalur.getMenit();
            }
            //cek apakah timerute > karute
            if(karute.size()>=timerute.size()) {
                for(j=0; j < timerute.size(); j++){
                    jam = timerute.get(j).getJam();
                    menit = timerute.get(j).getMenit();
                    kdWaktu = String.format("%02d", jam) +"."+ String.format("%02d", menit);
                    kdKereta = karute.get(j).getKdKereta().getKodeKereta();
                    System.out.println(koderute + "\t" + kotaBerangkat + "\t" + kotaTujuan + "\t" + kdWaktu + "\t" + kdKereta + "\t" + wktTempuh);
                }
            }
            else {
                for(j=0; j < timerute.size(); j++){
                    k=j%karute.size();
                    jam = timerute.get(j).getJam();
                    menit = timerute.get(j).getMenit();
                    kdWaktu = String.format("%02d", jam) +"."+ String.format("%02d", menit);
                    kdKereta = karute.get(k).getKdKereta().getKodeKereta();
                    System.out.println(koderute + "\t" + kotaBerangkat + "\t" + kotaTujuan + "\t" + kdWaktu + "\t" + kdKereta + "\t" + wktTempuh);
                }
            }
        }
    }

    public void LihatJadwal(){
        System.out.println("test");
    }

}
