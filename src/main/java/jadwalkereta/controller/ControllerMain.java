/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.view.ViewMain;
import jadwalkereta.model.*;

import java.util.*;


/**
 *
 * @author ASUS
 */
public class ControllerMain {
    ViewMain viewMain;
    private int pilihan;
    ArrayList<User> users;
    ArrayList<Station> stations;
  
    // Menambahkan parameter ArrayList<Station> s pada konstruktor
    public ControllerMain(ArrayList<User> u, ArrayList<Station> s) {
        viewMain = new ViewMain();
        users = u;
        stations = s;
    }

    public ArrayList<User> getUsers() { return users; }
    public ArrayList<Station> getStation() { return stations; }
    
    public void run() {
        Scanner in = new Scanner(System.in);
        viewMain.menuMain();
        
        do {
            pilihan = in.nextInt();
            System.out.println();
            switch(pilihan){
                case 0: break;
                case 1: {
                    ControllerUser ctrUser = new ControllerUser(this);
                    ctrUser.register();
                    break;
                }
    
                case 2: {
                    ControllerUser ctrUser = new ControllerUser(this);
                    ctrUser.login();
                    break;
                }
    
                default: {
                    System.out.println("Input salah!");
                    System.out.println();
                    viewMain.menuMain();
                }
            }
        } while (pilihan != 0);
    }

    private void elseif(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
