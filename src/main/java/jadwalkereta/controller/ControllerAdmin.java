/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

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
    ArrayList<User> users;
    ViewAdmin viewAdmin;
    // Menambahkan parameter ArrayList<Station> s pada konstruktor
    ArrayList<Station> stations;
    
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
                case 5:{
                    if(ctrStation == null ){
                        ctrStation = new ControllerStation(this);
                    }
                    ctrStation.ControlMenuStation();
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
