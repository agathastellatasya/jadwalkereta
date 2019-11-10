/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewMain;
import java.text.ParseException;

/**
 *
 * @author ASUS
 */
public class ControllerMain {
    ViewMain viewMain;
    

    public ControllerMain() {
        viewMain = new ViewMain();
    
    }
    
    
    public void run() {
        
    viewMain = new ViewMain();
    viewMain.menuMain();
    int pilihan = viewMain.getPilihan();
        System.out.println(pilihan);
        if(pilihan==1){
            ControllerRegis ctrRegis = new ControllerRegis();
            ctrRegis.ControlRegister();
            
        }
        else if (pilihan==2){
            ControllerLogin ctrLogin = new ControllerLogin();
            ctrLogin.ControlLogin();
            
        }
        else {
            System.out.println("inputan salah!!");
            ControllerMain ctrMain = new ControllerMain();
            ctrMain.run();
        }
    }
    
    public static void main(String[] args) throws ParseException {
        ControllerMain main = new ControllerMain();
        main.run();
    }

    private void elseif(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
