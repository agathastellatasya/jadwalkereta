/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import jadwalkereta.model.User;
import jadwalkereta.controller.ControllerUser;
import jadwalkereta.controller.ControllerMain;
import jadwalkereta.model.Station;

import java.util.*;
/**
 *
 * @author ASUS
 */
public class ViewAdmin {
    Scanner input = new Scanner(System.in);
    private String nik;
    ControllerMain ctrMain;
    ArrayList<User> users;
    int pilihan;
    ArrayList<Station> stations;

    public ViewAdmin(ControllerMain ctrM, ArrayList<User> u, final ArrayList<Station> s){
        ctrMain = ctrM;
        users = u;
        stations =  s;
    }

    public int getPilihan(){
        return pilihan;
    }
    
    public void menuAdmin() {
        System.out.println();
        System.out.println("###### MENU ADMIN ######");
        System.out.println("Welcome, Admin!");
        System.out.println();
        System.out.println("1.  Kelola Akun");
        System.out.println("0.  Logout");
        System.out.println();
        System.out.print("Pilih Menu : ");
        pilihan = input.nextInt();
    }

    public void menuKelolaAkun(){
        ControllerUser ctrUser = new ControllerUser(ctrMain,users,stations);
        System.out.println("###### KELOLA AKUN BY ADMIN ######");
        System.out.println();
        System.out.print("Masukkan nomor KTP : ");
        input.nextLine();
        nik = input.nextLine();
        System.out.println(nik);
        if (ctrUser.findNikInUsers(nik) != -99){
            User u = users.get(ctrUser.findNikInUsers(nik));
            String nama, hp, email, pass, repass;

            System.out.println("------ DATA PENGGUNA ------");
            System.out.println("Nama Lengkap : " + u.getNama());
            System.out.println("Nomor Handphone : " + u.getHp());
            System.out.println("Email : " + u.getEmail());
            System.out.println("Password : " + u.getPassword());
            System.out.println();
            System.out.println("------ UBAH DATA PENGGUNA ------");

            // VALIDASI NAMA
            do {
                System.out.print("Nama Lengkap : ");
                nama = input.nextLine();
                if (!nama.matches("^[a-zA-Z\\\\s][a-zA-Z \\\\s]*$")){
                    System.out.println("Nama harus terdiri dari huruf semua!");
                }
            } while (!nama.matches("^[a-zA-Z\\\\s][a-zA-Z \\\\s]*$"));

            // VALIDASI HP
            do {
                System.out.print("Nomor Handphone : ");
                hp = input.next();

                if ((hp.length() > 12 || hp.length() < 11) || !(hp.matches("[0-9_]+"))) {
                    System.out.println("No. hp tidak valid, harus angka dan terdiri dari 11 hingga 12 digit, misal: 085224224224");
                }
            } while ((hp.length() > 12 || hp.length() < 11) || !(hp.matches("[0-9_]+")));
            
            // VALIDASI EMAIL
            do {
                System.out.print("Email : ");
                email = input.next();

                if (ctrUser.findEmailInUsers(email) != -99){
                    if (!email.equals(users.get(ctrUser.findEmailInUsers(email)).getEmail())){

                        System.out.println("Email sudah terdaftar!");
                    }
                }
            } while ((ctrUser.findEmailInUsers(email) != -99) && !email.equals(users.get(ctrUser.findEmailInUsers(email)).getEmail()));

            // VALIDASI PASSWORD
            do {
                System.out.print("Password : ");
                pass = input.next();
                System.out.print("Re-Password : ");
                repass = input.next();

                if (!pass.equals(repass)){
                    System.out.println("Password dan Re-Password tidak sama! Silakan coba kembali!");
                }
            } while (!pass.equals(repass));

            // UPDATE DATA
            ctrUser.editUser(nik, nama, hp, email, pass);

            System.out.println();
            System.out.println("DATA BERHASIL DIUPDATE, BERIKUT DATA TERBARU:");
            u = users.get(ctrUser.findNikInUsers(nik));
            System.out.println("Nomor KTP : " + u.getNik());
            System.out.println("Nama Lengkap : " + u.getNama());
            System.out.println("Nomor Handphone : " + u.getHp());
            System.out.println("Email : " + u.getEmail());
            System.out.println("Password : " + u.getPassword());
        } else {
            System.out.println("NIK tidak ditemukan!");
        }
    }
}
