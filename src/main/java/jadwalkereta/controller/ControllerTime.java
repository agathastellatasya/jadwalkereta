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

    public void ControlMenuTime() {
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
        for (int i = 0, k = 1; i < 24; i++) {
            for (int j = 0; j < 60; j += 15, k++) {
                times.add(new Time("TM" + k, i,j));
            }
        }
    }

    public void LihatWaktu(){
        for(int i=0;i<10;i++)
            System.out.println(i+1+"\t"+times.get(i).getKode()+"\t"+ String.format("%02d", times.get(i).getJam())+"."+ String.format("%02d", times.get(i).getMenit()));
        System.out.println(".......................");
        System.out.println(times.size() + "\t" + times.get(times.size()-1).getKode() + "\t" + String.format("%02d", times.get(times.size()-1).getJam())
                + "." + String.format("%02d", times.get(times.size()-1).getMenit()));
    }

}
