/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.Penumpang;
import jadwalkereta.model.User;
import jadwalkereta.view.ViewLogin;

/**
 *
 * @author ASUS
 */
public class ControllerLogin {
    ViewLogin viewLogin;
    User user;
    Penumpang penumpang;
    ControllerMain ctrMain;
    
    public ControllerLogin(ControllerMain ctr){
        viewLogin = new ViewLogin();
        ctrMain = ctr;
    }
    
    public void ControlLogin() {
        viewLogin.menuLogin();
        User user = new User(viewLogin.getEmail(),viewLogin.getPassword());
        
        if(user.LoginFromJson(user.getEmail(), user.getPassword())==1){
            ControllerAdmin ctrAdmin = new ControllerAdmin(user, ctrMain);
            ctrAdmin.ControlMenuAdmin();
            
        }
        else if (user.LoginFromJson(user.getEmail(), user.getPassword())==2){
            //Dosen dsn = new Dosen(user.getUsername()); 
            ControllerPenumpang ctrPenumpang = new ControllerPenumpang(user);
            ctrPenumpang.ControlMenuPenumpang();
            
        }
         
        else {
            System.out.println("Username atau Password Salah!");
            ControllerMain ctrMain = new ControllerMain();
            ctrMain.run();
        }
    }
    
}
