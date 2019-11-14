/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;
import jadwalkereta.model.Stasiun;

/**
 *
 * @author ASUS
 */
public class ControllerLihatStasiun {

    ControllerStasiun controllerStasiun;

    public ControllerLihatStasiun(ControllerStasiun controller) {
        controllerStasiun = controller;
    }
    public void ControlDisplayLihatStasiun(){
           Stasiun stasiun = new Stasiun();
           stasiun.DisplayAllStasiun();
           controllerStasiun.ControlMenuStasiun();
    }
}
