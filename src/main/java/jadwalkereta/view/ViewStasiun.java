/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ViewStasiun {
    private String pilihan;
    Scanner input = new Scanner(System.in);
    public ViewStasiun(){
        
    }
    
    public void menuStasiun() {
        System.out.println("#KELOLA DATA STASIUN#");
        System.out.println("1.  Tambah Data Stasiun");
        System.out.println("2.  Lihat Data Stasiun");
        System.out.println("3.  Delete Data Stasiun");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = input.next();
    }

    public String getPilihan() {
        return pilihan;
    }
}