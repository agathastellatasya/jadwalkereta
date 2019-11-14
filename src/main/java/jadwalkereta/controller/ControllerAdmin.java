/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.Admin;
import jadwalkereta.model.User;
import jadwalkereta.view.ViewAdmin;


import java.util.*;

/**
 *
 * @author ASUS
 */
public class ControllerAdmin {
    String email;
    User user;
    Admin admin;
    ControllerMain ctrMain;
    
    public ControllerAdmin(User user, ControllerMain ctr) {
        this.user = user;
        ctrMain = ctr;
    }
    
    ControllerAdmin(){
        
    }
    
    public void ControlMenuAdmin() {
        Scanner in = new Scanner(System.in);
        ViewAdmin viewAdmin = new ViewAdmin();
        viewAdmin.menuAdmin();
        int pilihan;
        do {
            pilihan = in.nextInt();
            System.out.println();
            switch (pilihan){
                case 1:
                    
                    break;
                case 2:
                    // ControlMenuAdmin();
                    break;
                case 3:
                    
                    break;
                case 4:
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;
                case 11:
                    
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Inputan Salah!");
                    System.out.println();
                    viewAdmin.menuAdmin();
                    break;
            }
        } while (pilihan != 0);

        ctrMain.run();
    }
    
}
