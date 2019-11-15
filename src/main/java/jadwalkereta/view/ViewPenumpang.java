/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import jadwalkereta.model.User;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ViewPenumpang {
    private User user;
    Scanner input = new Scanner(System.in);
    
    public ViewPenumpang(User u){
        user = u;
    }
    
    public void menuPenumpang() {
        System.out.println();
        System.out.println("###### Menu Pengguna ######");
        System.out.println("Welcome, " + user.getNama() + "!");
        System.out.println();
        System.out.println("1. \t Booking Tiket");
        System.out.println("2. \t Kelola Profile");
        System.out.println("3. \t History Pembelian");
        System.out.println("0. \t Logout");
        System.out.println();
        System.out.print("Pilih Menu : ");
    }
}