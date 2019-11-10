/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ViewPenumpang {
    private int pilihan;
    private String email, password, nama, nik, hp;
    private int role;
    Scanner input = new Scanner(System.in);
    
    public ViewPenumpang(){
        
    }
    
    public void menuPenumpang() {
        System.out.println("#Menu Pengguna#");
        System.out.println("1.  Booking Tiket");
        System.out.println("2.  Kelola Profile");
        System.out.println("3.  History Pembelian");
        System.out.println("0.  Logout");
        System.out.print("Pilih Menu : ");
        pilihan = input.nextInt();
    }

    public int getPilihan() {
        return pilihan;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public String getHp() {
        return hp;
    }

    public int getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
    
}
