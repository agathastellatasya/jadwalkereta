/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.User;
import jadwalkereta.view.ViewPenumpang;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class ControllerPenumpang {
    private ControllerMain ctrMain;
    private User user;
    private ArrayList<User> users;

    public ControllerPenumpang(ControllerMain ctr, User u) {
        ctrMain = ctr;
        user = u;
        users = ctrMain.getUsers();
    }

    public ControllerMain getControllerMain() {
        return ctrMain;
    }
    public User getUser()
    {
        return user;
    }
    
    public void ControlMenuPenumpang(){
        Scanner in = new Scanner(System.in);
        ViewPenumpang viewPenumpang = new ViewPenumpang(ctrMain,user);

        do {
            viewPenumpang.menuPenumpang();
            System.out.println();
            switch (viewPenumpang.getPilihan()){
                case 0: break;
                
                case 1: {
                    ControllerBooking ctrBooking = new ControllerBooking(this);
                    ctrBooking.ControlMenuBooking();
                    break;
                }

                case 2: {
                    viewPenumpang.kelolaProfile();
                    // viewPenumpang.menuPenumpang();
                    break;
                }

                case 3:{
                    System.out.println("Pilihan 3");
                    // viewPenumpang.menuPenumpang();
                    break;
                }

                case 4: {
                    ControllerCariJadwal ctrCariJadwal = new ControllerCariJadwal(this);
                    ctrCariJadwal.ControlMenuCariJadwal();
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
        
        ctrMain.run();
    }
}
