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
public class ViewAdmin {
    private String pilihan;
    private String email, password;
    Scanner input = new Scanner(System.in);
    
    public void menuAdmin() {
        System.out.println("#Menu Utama Admin#");
        System.out.println("1.  Kelola Akun");
        System.out.println("2.  Kelola Data Kota");
        System.out.println("3.  Generate Waktu");
        System.out.println("4.  Kelola Rute");
        System.out.println("5.  Kelola Stasiun");
        System.out.println("6.  Kelola Jalur Stasiun Pada Rute");
        System.out.println("7.  Kelola Waktu Pada Rute");
        System.out.println("8.  Kelola Kereta Pada Rute");
        System.out.println("9.  Generate Jadwal Kereta Api");
        System.out.println("10.  Lihat Pemasukan");
        System.out.println("11.  Lihat Pemasukan");
        System.out.println("0.  Logout");
        
        System.out.print("Pilih Menu : ");
        pilihan = input.next();
    }

    public String getPilihan() {
        return pilihan;
    }
    
}
