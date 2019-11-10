/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import View.ViewRegister;



/**
 *
 * @author ASUS
 */
public class ControllerRegis {
    ControllerMain ctrMain;
    User user;
    
    public ControllerRegis(User user){
        ctrMain = new ControllerMain();
        this.user = user;
    }

    ControllerRegis() {
        
    }
    
    public void ControlRegister() {
        ViewRegister viewRegister = new ViewRegister();
        viewRegister.Register();
        
        regisUser(viewRegister.getNik(), viewRegister.getNama(), viewRegister.getHp(), viewRegister.getEmail(), viewRegister.getPassword(), viewRegister.getRole());
        ctrMain.run();
    }

    private void regisUser(String nik, String nama, String hp, String email, String password, int role) {
        user = new User(nik, nama, hp, email, password, role);
        user.TulisUserToJson();
        System.out.println("Anda berhasil Regis");
    }

    
    
}
