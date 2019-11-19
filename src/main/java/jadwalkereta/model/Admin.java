/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.model;

/**
 *
 * @author ASUS
 */
public class Admin extends User {
    
    public Admin(String email, String password, int role){
        this.email  = email;
        this.password = password;
        this.role = role;
    }
}
