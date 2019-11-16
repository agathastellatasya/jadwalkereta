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
    
    public void run() {
        // viewMain = new ViewMain();
        Scanner in = new Scanner(System.in);
        viewMain.menuMain();
        
        do {
            pilihan = in.nextInt();
            System.out.println();
            switch(pilihan){
                case 0: break;
                case 1: {
                    // ControllerRegis ctrRegis = new ControllerRegis(this, users);
                    // ctrRegis.ControlRegister();
                    ControllerUser ctrUser = new ControllerUser(this, users, stations);
                    ctrUser.register();
                    break;
                }
    
                case 2: {
/*<<<<<<< HEAD*/
                    // ControllerLogin ctrLogin = new ControllerLogin(this, users);
                    // ctrLogin.ControlLogin();
                    ControllerUser ctrUser = new ControllerUser(this, users, stations);
                    ctrUser.login();
/*=======
                    ControllerLogin ctrLogin = new ControllerLogin(this, users, stations);
                    ctrLogin.ControlLogin();
>>>>>>> 4143a1eeba3affa943ec957e334cd5b40c71acbf*/
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
    
    // public static void main(String[] args) throws ParseException {
    //     ControllerMain main = new ControllerMain(users);
    //     main.run();
    // }

    private void elseif(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
