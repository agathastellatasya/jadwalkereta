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
    ArrayList<Time> times;
    ArrayList<City> cities;
    ArrayList<Rute> rute;
  
    // Menambahkan parameter ArrayList<Station> s pada konstruktor
    public ControllerMain(ArrayList<User> u, ArrayList<Station> s, ArrayList<City> c, ArrayList<Rute> r, ArrayList<Time> t) {
        viewMain = new ViewMain();
        users = u;
        stations = s;
	    cities =c;
        rute = r;
        times = t;
    }

    public ArrayList<User> getUsers() { return users; }
    public ArrayList<Station> getStations() { return stations; }
    public ArrayList<Time> getTimes() { return times; }
    public ArrayList<City> getCities(){ return cities; }
    public ArrayList<Rute> getRute(){ return rute; }
    
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

    // private void elseif(boolean b) {
    //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }

    
}
