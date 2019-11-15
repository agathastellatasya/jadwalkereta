/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.User;
import jadwalkereta.view.ViewRegister;

import java.util.*;


/**
 *
 * @author ASUS
 */
public class ControllerRegis {
    User user = new User();
    ControllerMain ctrMain;
    ArrayList<User> users;
    
    public ControllerRegis(ControllerMain ctr, ArrayList<User> u){
        ctrMain = ctr;
        users = u;
    }
    
    public void ControlRegister() {
        ViewRegister viewRegister = new ViewRegister(users);
        viewRegister.Register();
        System.out.println("Anda sudah berhasil didaftarkan!");
        System.out.println();
        
        ctrMain.run();
    }

    // private void regisUser(String nik, String nama, String hp, String email, String password, int role) {
    //     user = new User(nik, nama, hp, email, password, role);
    //     user.TulisUserToJson();
    //     System.out.println("Anda berhasil Regis");
    // }
}
