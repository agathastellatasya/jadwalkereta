/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.Time;
import jadwalkereta.view.ViewTime;
import java.io.*;

/**
 *
 * @author ASUS
 */
public class ControllerTime {

    ArrayList<Time> times;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ViewTime viewTime;
    Scanner input = new Scanner(System.in);

    public ControllerTime(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        times = ctrMain.getTimes();
    }

    public void ControlMenuTime(){
        if(viewTime == null) viewTime = new ViewTime(this);
        if(times.size()<=0) viewTime.menuGenerateWaktu();
        viewTime.menuTime();
        switch(viewTime.getPilihan()){
            case 1: {
                viewTime.menuLihatWaktu();
                ControlMenuTime();
                break;
            }
            case 99:{
                ctrAdmin.ControlMenuAdmin();
                break;
            }
        }
    }

    public void GenerateWaktu(){
        times = ctrMain.getTimes();
        for (int i = 0, k = 1; i < 24; i++) {
            for (int j = 0; j < 60; j += 15, k++) {
                times.add(new Time("TM" + k, i,j));
            }
        }
        ctrMain.WriteJSONTime();
    }

    public void LihatWaktu(){
        times = ctrMain.getTimes();
        for(int i=0;i<10;i++)
            System.out.println(i+1+"\t"+times.get(i).getKode()+"\t"+ String.format("%02d", times.get(i).getJam())+"."+ String.format("%02d", times.get(i).getMenit()));
        System.out.println(".......................");
        System.out.println(times.size() + "\t" + times.get(times.size()-1).getKode() + "\t" + String.format("%02d", times.get(times.size()-1).getJam())
                + "." + String.format("%02d", times.get(times.size()-1).getMenit()));
    }
	
	public int CheckWaktu(String kdWaktu){
        times = ctrMain.getTimes();
        int i;
        boolean found = false;
        for (i=0; i < times.size(); i++) {
            if (kdWaktu.equals(times.get(i).getKode())) {
                found = true;
                break;
            }
        }
        if(found) return i;
        else return -1;
    }

}
