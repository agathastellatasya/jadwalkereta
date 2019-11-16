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
    ArrayList<User> users;
    ViewAdmin viewAdmin;
    // Menambahkan parameter ArrayList<Station> s pada konstruktor
    ArrayList<Station> stations;
    
    public ControllerAdmin(final ControllerMain ctr, final ViewAdmin vAdmin, final ArrayList<User> u, final ArrayList<Station> s) {
        ctrMain = ctr;
        users = u;
        viewAdmin = vAdmin;
        ctrMain = ctr;
        stations =  s;
    }
    
    public void ControlMenuAdmin() {
        final Scanner in = new Scanner(System.in);
        do {
            viewAdmin.menuAdmin();
            System.out.println();
            switch (viewAdmin.getPilihan()){
                case 0: break;
                
                case 1:{
                    viewAdmin.menuKelolaAkun();
                    break;
                }
                case 5:{
                    final ControllerStation ctrStation = new ControllerStation(ctrMain, stations);
                    ctrStation.ControlMenuStation();
                    break;
                }

                default:
                    System.out.println("Inputan Salah!");
                    System.out.println();
                    break;
            }
        } while (viewAdmin.getPilihan() != 0);

        ctrMain.run();
    }
}
