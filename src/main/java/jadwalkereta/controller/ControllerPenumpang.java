/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.model.Penumpang;
import jadwalkereta.model.User;
import jadwalkereta.view.ViewPenumpang;

/**
 *
 * @author ASUS
 */
public class ControllerPenumpang {
    String email;
    User user;
    Penumpang penumpang;

    public ControllerPenumpang(String email) {
        this.email = email;
    }

    ControllerPenumpang(User user) {
        this.user = user;
    }
    
     public void ControlMenuPenumpang(){
        ViewPenumpang viewPenumpang = new ViewPenumpang();
        viewPenumpang.menuPenumpang();
        
        if(viewPenumpang.getPilihan()==1){
        }
        else if(viewPenumpang.getPilihan()==2){
            //System.out.println("wakwaw"
        }
        else if(viewPenumpang.getPilihan()==3){
            //System.out.println("wakwaw");
        }
        
        else if(viewPenumpang.getPilihan()==0){
            System.exit(0);
        }
        
    }

}
