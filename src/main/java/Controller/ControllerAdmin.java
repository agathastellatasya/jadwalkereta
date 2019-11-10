/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin;
import Model.User;
import View.ViewAdmin;

/**
 *
 * @author ASUS
 */
public class ControllerAdmin {
    String email;
    User user;
    Admin admin;
    ControllerMain ctrMain;
    
    public ControllerAdmin(User user) {
        this.user = user;
    }
    
    ControllerAdmin(){
        
    }
    
    public void ControlMenuAdmin() {
        ViewAdmin viewAdmin = new ViewAdmin();
        viewAdmin.menuAdmin();
        switch (viewAdmin.getPilihan()){
            case "1":
                
                break;
            case "2":
                
                ControlMenuAdmin();
                break;
            case "3":
                
                break;
            case "4":
                break;
            case "5":
                
                break;
            case "6":
                
                break;
            case "7":
                break;
            case "8":
                
                break;
            case "9":
                
                break;
            case "10":
                
                break;
            case "11":
                
                break;
            case "0":
                ctrMain = new ControllerMain();
                ctrMain.run();
                break;
            default:
                System.out.println("Inputan Salah!");
                ControlMenuAdmin();
                break;
        }
    
//        
    }
    
}
