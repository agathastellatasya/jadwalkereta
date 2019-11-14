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
public class ViewTambahStasiun {
    private String nama;
    private String kode;
    Scanner input = new Scanner(System.in);
    public ViewTambahStasiun(){
        
    }
    
    public void display() {
        System.out.println("#TAMBAH DATA STASIUN#");
        System.out.println("Tambah Data Stasiun: ");
        kode = input.next();
        nama = input.next();
    }

    public String getNama() {
        return nama;
    }

    public String getKode() {
        return kode;
    }
}