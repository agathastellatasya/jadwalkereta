/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.Station;
import jadwalkereta.view.ViewAdmin;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class ControllerAdmin {
    ControllerMain ctrMain;
    ArrayList<Station> stations;
    
    // Menambahkan parameter ArrayList<Station> s pada konstruktor
    public ControllerAdmin(ControllerMain ctr, ArrayList<Station> s) {
        ctrMain = ctr;
        stations =  s;
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
                case 0: break;
                
                case 1:{
                    System.out.println("Pilihan 1");
                    viewAdmin.menuAdmin();
                    break;
                }

                case 2:{
                    System.out.println("Pilihan 2");
                    viewAdmin.menuAdmin();
                    break;
                }

                case 3:{
                    System.out.println("Pilihan 3");
                    viewAdmin.menuAdmin();
                    break;
                }

                case 4:{
                    System.out.println("Pilihan 4");
                    viewAdmin.menuAdmin();
                    break;
                }

                case 5:{
                    ControllerStation ctrStation = new ControllerStation(ctrMain, stations);
                    ctrStation.ControlMenuStation();
                    break;
                }

                case 6:{
                    System.out.println("Pilihan 6");
                    viewAdmin.menuAdmin();
                    break;
                }

                case 7:{
                    System.out.println("Pilihan 7");
                    viewAdmin.menuAdmin();
                    break;
                }

                case 8:{
                    System.out.println("Pilihan 8");
                    viewAdmin.menuAdmin();
                    break;
                }

                case 9:{
                    System.out.println("Pilihan 9");
                    viewAdmin.menuAdmin();
                    break;
                }

                case 10:{
                    System.out.println("Pilihan 10");
                    viewAdmin.menuAdmin();
                    break;
                }
                
                case 11:{
                    System.out.println("Pilihan 11");
                    viewAdmin.menuAdmin();
                    break;
                }

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
