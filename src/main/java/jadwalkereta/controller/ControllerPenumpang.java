/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.User;
import jadwalkereta.view.ViewPenumpang;
import java.util.*;
import java.io.*;

/**
 *
 * @author ASUS
 */
public class ControllerPenumpang {
    private ControllerMain ctrMain;
    ControllerUtil ctrUtil = new ControllerUtil();
    private User user;
    private ArrayList<User> users;
    ViewPenumpang viewPenumpang;

    public ControllerPenumpang(ControllerMain ctr, User u) {
        ctrMain = ctr;
        user = u;
        users = ctrUtil.getUsers();
       
    }

    public ControllerMain getControllerMain() {
        return ctrMain;
    }
    public User getUser()
    {
        return user;
    }

    public void setUser(User muser)
    {
        user = muser;
    }
    
    public void ControlMenuPenumpang(){
        Scanner in = new Scanner(System.in);
        if (viewPenumpang == null) viewPenumpang = new ViewPenumpang(ctrMain,user);

        do {
            viewPenumpang.menuPenumpang();
            System.out.println();
            switch (viewPenumpang.getPilihan()){
                
                case 1: {
                    //System.out.println("masuk sini");
                    ControllerBooking ctrBooking = new ControllerBooking(this);
                    
                    ctrBooking.ControlMenuBooking();
                    break;
                }

                case 2: {
                    user = viewPenumpang.kelolaProfile();
                    // viewPenumpang.menuPenumpang();
                    break;
                }

                case 3:{
                    viewPenumpang.History();
                    break;
                }

                /*case 4: {
                    ControllerCariJadwal ctrCariJadwal = new ControllerCariJadwal(this);
                    ctrCariJadwal.ControlMenuCariJadwal();
                    // viewPenumpang.menuPenumpang();
                    break;
                }*/
                case 0: {
                    ctrMain.run();
                    // viewPenumpang.menuPenumpang();
                    break;
                }

                default:{
                    System.out.println("Inputan Salah!");
                    System.out.println();
                    // viewPenumpang.menuPenumpang();
                    break;
                }
            }    
        } while (viewPenumpang.getPilihan() != 0);
        
        //ctrMain.run();
    }
}
