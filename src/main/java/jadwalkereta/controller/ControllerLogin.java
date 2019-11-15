/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.User;
import jadwalkereta.view.ViewLogin;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class ControllerLogin {
    User user = new User();
    ArrayList<User> users;
    ControllerMain ctrMain;
    
    public ControllerLogin(ControllerMain ctr, ArrayList<User> us){
        ctrMain = ctr;
        users = us;
    }

    public int SuccessLogin(User u){
        boolean found = false;
        int i = 0;
        int hasil = -99;
        while (!found && (i<users.size())){
            if (users.get(i).getEmail().equals(u.getEmail())){
                if (users.get(i).getPassword().equals(u.getPassword())){
                    found = true;
                    hasil = i;
                }
            } else {
                i++;
            }
        }

        return hasil;
    }
    
    public void ControlLogin() {
        ViewLogin viewLogin = new ViewLogin(user);
        viewLogin.menuLogin();
        if (SuccessLogin(viewLogin.getUser()) != -99){
            user = users.get(SuccessLogin(viewLogin.getUser()));
            switch (user.getRole()){
                case 1: {
                    ControllerAdmin ctrAdmin = new ControllerAdmin(ctrMain);
                    ctrAdmin.ControlMenuAdmin();
                    break;
                }

                case 2: {
                    ControllerPenumpang ctrPenumpang = new ControllerPenumpang(ctrMain,user);
                    ctrPenumpang.ControlMenuPenumpang();
                    break;
                }
            }
        } else {
            System.out.println();
            System.out.println("Username atau Password salah!");
            System.out.println();
            ctrMain.run();
        }
    }
    
}