/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Penumpang;
import Model.User;
import View.ViewLogin;

/**
 *
 * @author ASUS
 */
public class ControllerLogin {
    ViewLogin viewLogin;
    User user;
    Penumpang penumpang;
    
    public ControllerLogin(){
        viewLogin = new ViewLogin();
    }
    
    public void ControlLogin() {
        User user = new User(viewLogin.getEmail(),viewLogin.getPassword());
        
        if(user.LoginFromJson(user.getEmail(), user.getPassword())==1){
            ControllerAdmin ctrAdmin = new ControllerAdmin(user);
            ctrAdmin.ControlMenuAdmin();
            
        }
        else if (user.LoginFromJson(user.getEmail(), user.getPassword())==2){
            //Dosen dsn = new Dosen(user.getUsername()); 
            ControllerPenumpang ctrPenumpang = new ControllerPenumpang(user);
            ctrPenumpang.ControlMenuPenumpang();
            
        }
         
        else {
            System.out.println("Username atau Password Salah!!");
            ControllerMain ctrMain = new ControllerMain();
            ctrMain.run();
        }
    }
    
}
