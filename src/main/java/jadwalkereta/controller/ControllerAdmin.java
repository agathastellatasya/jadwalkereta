/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.User;
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
    
    public ControllerAdmin(ControllerMain ctr, ViewAdmin vAdmin, ArrayList<User> u) {
        ctrMain = ctr;
        users = u;
        viewAdmin = vAdmin;
    }
    
    public void ControlMenuAdmin() {
        Scanner in = new Scanner(System.in);
        do {
            viewAdmin.menuAdmin();
            System.out.println();
            switch (viewAdmin.getPilihan()){
                case 0: break;
                
                case 1:{
                    viewAdmin.menuKelolaAkun();
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
