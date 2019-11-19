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
public class Penumpang extends User{

    public Penumpang() {
    }

    public Penumpang(String nik, String nama, String hp, String email, String password, int role) {
        super(nik, nama, hp, email, password, role);
    }
    
}
