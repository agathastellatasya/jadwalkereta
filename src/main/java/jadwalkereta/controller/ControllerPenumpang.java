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

    public ControllerPenumpang(ControllerMain ctr, User u) {
        ctrMain = ctr;
        user = u;
    }
    
    public void ControlMenuPenumpang(){
        Scanner in = new Scanner(System.in);
        ViewPenumpang viewPenumpang = new ViewPenumpang(user);
        viewPenumpang.menuPenumpang();
        int pilihan;

        do {
            pilihan = in.nextInt();
            System.out.println();
            switch (pilihan){
                case 0: break;
                
                case 1: {
                    System.out.println("Pilihan 1");
                    viewPenumpang.menuPenumpang();
                    break;
                }

                case 2: {
                    System.out.println("Pilihan 2");
                    viewPenumpang.menuPenumpang();
                    break;
                }

                case 3:{
                    System.out.println("Pilihan 3");
                    viewPenumpang.menuPenumpang();
                    break;
                }

                default:{
                    System.out.println("Inputan Salah!");
                    System.out.println();
                    viewPenumpang.menuPenumpang();
                    break;
                }
            }    
        } while (pilihan != 0);
        
        ctrMain.run();
    }
}
