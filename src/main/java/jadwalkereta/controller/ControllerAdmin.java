/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.City;
import jadwalkereta.model.Rute;
import jadwalkereta.model.User;
import jadwalkereta.model.Station;
import jadwalkereta.view.ViewAdmin;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class ControllerAdmin {
    ControllerMain ctrMain;
    ControllerStation ctrStation;
    ControllerTime ctrTime;
    ControllerJalur ctrJalur;
    ArrayList<User> users;
    ViewAdmin viewAdmin;
    ArrayList<Station> stations;
    ArrayList<City> cities;
    ArrayList<Rute> rute;
    
    public ControllerAdmin(ControllerMain ctr) {
        ctrMain = ctr;
        viewAdmin = new ViewAdmin(ctr);
    }

    public ControllerMain getControllerMain(){ return ctrMain; }
    
    public void ControlMenuAdmin() {
        do {
            viewAdmin.menuAdmin();
            System.out.println();
            switch (viewAdmin.getPilihan()){
                case 0: 
                    ctrMain.run();
                    break;
                case 1:{
                    viewAdmin.menuKelolaAkun();
                    break;
                }
                case 2:{
                    ControllerCity ctrCity = new ControllerCity(this);
                    ctrCity.ControlMenuCity();
                    break;
                }
		        case 3:{
                    if (ctrTime == null) {
                        ctrTime = new ControllerTime(this);
                    }
                    ctrTime.ControlMenuTime();
                    break;
                }
		        case 4:{
                    ControllerRute ctrRute = new ControllerRute(this);
                    ctrRute.ControlMenuRute();
                    break;
                }
                case 5:{
                    if(ctrStation == null ){
                        ctrStation = new ControllerStation(this);
                    }
                    ctrStation.ControlMenuStation();
                    break;
                }
                case 6: {
                    if (ctrJalur == null) {
                        ctrJalur = new ControllerJalur(this);
                    }
                    ctrJalur.ControlMenuJalur();
                    break;
                }
                default:
                    System.out.println("Inputan Salah!");
                    System.out.println();
                    break;
            }
        } while (viewAdmin.getPilihan() != 0);
    }
}
