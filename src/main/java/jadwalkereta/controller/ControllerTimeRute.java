/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

//import jadwalkereta.model.Kota;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Time;
import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.TimeRute;
import jadwalkereta.view.ViewTimeRute;


public class ControllerTimeRute {
    ArrayList<TimeRute> timerute;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ViewTimeRute viewTimeRute;
    Scanner input = new Scanner(System.in);

    public ControllerTimeRute(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        timerute = ctrMain.getTimeRute();
    }

    public void ControlMenuTimeRute() {
        if(viewTimeRute == null) viewTimeRute = new ViewTimeRute(this);
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
            viewTimeRute.menuDelete();
            ControlMenuTimeRute();
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
            ControlMenuTimeRute();
            break;
        }
    }

    public void TambahTimeRute(String kode, String kodeTime){
        int i, wr;
        int jam = 0;
        int menit = 0;
        ArrayList<Time> times = ctrMain.getTimes();
        for (i=0; i < times.size(); i++) {
            if (kodeTime.equals(times.get(i).getKode())) {
                jam = times.get(i).getJam();
                menit = times.get(i).getMenit();
                break;
            }
        }
        if(timerute.size()<=0) wr=0;
        else wr=timerute.get(timerute.size()-1).getWaktuRute();
        timerute.add(new TimeRute(kode,wr+1,jam,menit,kodeTime));
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("Kode Waktu Berhasil Ditambahkan");
        System.out.println("--------------------------------------------------------------");
    }
    
    public void DeleteTimeRute(String kode){
		int i;
		//System.out.println(timerute.size());
		for (i=timerute.size()-1; i >=0; i--) {
			//System.out.println(timerute.get(i).getKodeRute()+i);
			if (kode.equals(timerute.get(i).getKodeRute())) {
				timerute.remove(i);
			}
		}
    }

    public int CheckTimeRute(String kodeTime){
        int i;
        boolean found = false;
		ArrayList<Time> times = ctrMain.getTimes();
        for (i=0; i < times.size(); i++) {
            if (kodeTime.equals(times.get(i).getKode())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }
    
    public int CheckRute(String kode){
        int i;
        boolean found = false;
        //ArrayList<Kota> kotaA = Kota.getKota() ;
        ArrayList<Rute> rute = ctrMain.getRute();
        for (i=0; i < rute.size(); i++) {
            if (kode.equals(rute.get(i).getKodeRute())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }
    
    public int CheckWaktuRute(String kode,String kdWaktu){
        int i;
        boolean found = false;
        for (i=0; i < timerute.size(); i++) {
            if (kode.equals(timerute.get(i).getKodeRute()) && kdWaktu.equals(timerute.get(i).getKdWaktu()) ) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }
	
    public void LihatRute(String kode){
        int j=0;
        for(int i=0; i<timerute.size();i++){
            if (kode.equals(timerute.get(i).getKodeRute())) {
                if(j==0) {
                    System.out.println("1\t"+"WR"+String.format("%03d",timerute.get(i).getWaktuRute())+"\t\t"+timerute.get(i).getKodeRute()+"\t\t -\t"+
                    String.format("%02d",timerute.get(i).getJam())+":"+String.format("%02d",timerute.get(i).getMenit())+"\t");
                    j++;
                }
                else System.out.println("\t\t\t\t\t -\t" + String.format("%02d",timerute.get(i).getJam())+":"+String.format("%02d",timerute.get(i).getMenit())+"\t");
            }
        }
    }

}