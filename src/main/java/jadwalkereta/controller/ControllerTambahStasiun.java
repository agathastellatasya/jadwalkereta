/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;
import jadwalkereta.model.Stasiun;
import jadwalkereta.view.ViewTambahStasiun;

/**
 *
 * @author ASUS
 */
public class ControllerTambahStasiun {

    ControllerStasiun controllerStasiun;

    public ControllerTambahStasiun(ControllerStasiun controller) {
        controllerStasiun = controller;
    }
    public void ControlDisplayTambahStasiun(){
            ViewTambahStasiun viewTambahStasiun = new ViewTambahStasiun();
            viewTambahStasiun.display();
            Stasiun stasiun = new Stasiun(viewTambahStasiun.getKode(),viewTambahStasiun.getNama());
            stasiun.TulisStasiunToJson();
            controllerStasiun.ControlMenuStasiun();
    }
}
