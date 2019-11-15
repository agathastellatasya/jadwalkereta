/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import jadwalkereta.model.User;

import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author ASUS
 */
public class ViewRegister {
    private User user = new User();
    private ArrayList<User> users;
    Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
    Scanner input = new Scanner(System.in);

    public ViewRegister(ArrayList<User> u) {
        users = u;
    }

    public User getUser(){
        return user;
    }
    
    boolean emailFoundInUser(String email){
        boolean found = false;
        int i = 0;
        while (!found && (i<users.size())){
            if (users.get(i).getEmail().equals(email)){
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }

    boolean nikFoundInUser(String nik){
        boolean found = false;
        int i = 0;
        while (!found && (i<users.size())){
            if (users.get(i).getNik().equals(nik)){
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }
    
    public void Register(){
        String nik, nama, email, hp, password, repassword;

        // VALIDASI NIK
        do {
            System.out.print("Nomor KTP : ");
            nik = input.next();

            if (nik.length() != 16 || !(nik.matches("[0-9_]+"))) {
                System.out.println("NIK tidak valid, harus berupa 16 digit angka, misal: 1234567891011121");
            }
            
            if (nikFoundInUser(nik)){
                System.out.println("NIK sudah terdaftar!");
            }

        } while (nikFoundInUser(nik) || nik.length() != 16 || !(nik.matches("[0-9_]+")));
        user.setNik(nik);
        
        // VALIDASI NAMA
        do {
            System.out.print("Nama Lengkap : ");
            nama = input.next();
            if (!nama.matches("^[a-zA-Z\\\\s]*$")){
                System.out.println("Nama harus terdiri dari huruf semua!");
            }
        } while (!nama.matches("^[a-zA-Z\\\\s]*$"));
        user.setNama(nama);
        
        // VALIDASI HP
        do {
            System.out.print("Nomor Handphone : ");
            hp = input.next();

            if ((hp.length() > 12 || hp.length() < 11) || !(hp.matches("[0-9_]+"))) {
                System.out.println("No. hp tidak valid, harus angka dan terdiri dari 11 hingga 12 digit, misal: 085224224224");
            }
        } while ((hp.length() > 12 || hp.length() < 11) || !(hp.matches("[0-9_]+")));
        user.setHp(hp);
        
        // VALIDASI EMAIL
        do {
            System.out.print("Email : ");
            email = input.next();

            if (emailFoundInUser(email)){
                System.out.println("Email sudah terdaftar!");
            }
        } while (emailFoundInUser(email));
        user.setEmail(email);

        // VALIDASI PASSWORD
        do {
            System.out.print("Password : ");
            password = input.next();
            System.out.print("Re-Password : ");
            repassword = input.next();

            if (!password.equals(repassword)){
                System.out.println("Password dan Re-Password tidak sama! Silakan coba kembali!");
            }
        } while (!password.equals(repassword));
        user.setPassword(password);

        users.add(user);
    }
}