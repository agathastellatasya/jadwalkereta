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
public class ViewMain {
    private int pilihan;

    Scanner input = new Scanner(System.in);
    public ViewMain(){
    }
    
    public void menuMain(){
        System.out.println("#Menu Awal#");
        System.out.println("1.  Register");
        System.out.println("2.  Login");
        System.out.print("Pilih Menu : ");
        pilihan = input.nextInt();
    }
    public int getPilihan() {
        return pilihan;
    }
}
