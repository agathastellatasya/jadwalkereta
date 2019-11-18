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
            timerute.add(new TimeRute(kode,kodeTime));
            System.out.println("--------------------------------------------------------------");
            System.out.println("Rute Berhasil Ditambahkan");
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
	
    public void LihatRute(){
        for(int i=0; i<timerute.size();i++)
            System.out.println(i+1+"\t"+timerute.get(i).getKodeRute()+"\t\t\t"+timerute.get(i).getKodeTime()+"\t");
    }

}