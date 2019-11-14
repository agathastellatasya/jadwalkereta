/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;


import jadwalkereta.view.ViewStasiun;

/**
 *
 * @author ASUS
 */
public class ControllerStasiun {

    public ControllerStasiun() {
    }

    
    public void ControlMenuStasiun(){
        ViewStasiun viewStasiun = new ViewStasiun();
        viewStasiun.menuStasiun();

        switch (viewStasiun.getPilihan()) {
            case "1":{
                ControllerTambahStasiun controllerTambahStasiun =  new ControllerTambahStasiun(this);
                controllerTambahStasiun.ControlDisplayTambahStasiun();
                break;
            }
            case "2":{
                ControllerLihatStasiun controllerLihatStasiun =  new ControllerLihatStasiun(this);
                controllerLihatStasiun.ControlDisplayLihatStasiun();
                break;
            }
            case "3":
                break;
            case "4":
                break;
            default:
                System.out.println("Inputan Salah!");
                ControlMenuStasiun();
                break;
        }
    }

}
