/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author ASUS
 */
public class ViewRegister {
    private String email, password, nik, hp, nama;
    private int role;
    Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
    Scanner input = new Scanner(System.in);

    public ViewRegister() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNik() {
        return nik;
    }

    public int getRole() {
        return role;
    }

    public String getHp() {
        return hp;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void Register(){
        String repassword;
        
        do {
            System.out.print("Nomor KTP : ");
            nik = input.next();

            if (nik.length() != 16 || nik.matches("[0-9_]+")== false) {
                System.out.println("NIK tidak valid, harus berupa 16 digit angka, misal: 1234567891011121");
            }

            //return input=true;
        }while (nik.length() != 16 || nik.matches("[0-9_]+")== false);
        
        do{
            System.out.print("Nama Lengkap : ");
            nama = input.next();
            if (nama.matches("^[a-zA-Z\\\\s]*$")== false) {
                System.out.println("Nama harus terdiri dari huruf semua! ");
            }
        }while(nama.matches("^[a-zA-Z\\\\s]*$")== false);
        
        do{
            System.out.print("Nomor Handphone : ");
            hp = input.next();

            if ((hp.length() <= 12 && hp.length() >= 11) || hp.matches("[0-9_]+")== false) {
                System.out.println("No. hp tidak valid, harus angka dan terdiri dari 11 hingga 12 digit, misal: 085224224224");
            }

            //return input=true;
        } while (hp.length() < 12 || hp.matches("[0-9_]+")== false);
        
        System.out.print("Email : ");
        email = input.next();
        System.out.print("Password : ");
        password = input.next();
    }
}

