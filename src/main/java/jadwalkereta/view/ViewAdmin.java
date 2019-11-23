/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import jadwalkereta.model.*;
import jadwalkereta.controller.ControllerUser;
import jadwalkereta.controller.ControllerMain;

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

    public ViewAdmin(ControllerMain ctr){
        ctrMain = ctr;
        users = ctrMain.getUsers();
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
        System.out.println("2.  Kelola Data Kota");
        System.out.println("3.  Generate Waktu");
        System.out.println("4.  Kelola Rute");
        System.out.println("5.  Kelola Stasiun");
        System.out.println("6.  Kelola Jalur Stasiun Pada Rute");
        System.out.println("7.  Kelola Waktu Pada Rute");
        System.out.println("8.  Kelola Kereta Pada Rute");
        System.out.println("9.  Generate Jadwal");
	System.out.println("12. Kelola Data Kereta Api");
        System.out.println("0.  Logout");
        System.out.println();
        System.out.print("Pilih Menu : ");
        pilihan = input.nextInt();
    }

    public void menuKelolaAkun(){
        ControllerUser ctrUser = new ControllerUser(ctrMain);
        System.out.println("###### KELOLA AKUN BY ADMIN ######");
        System.out.println();
        System.out.print("Masukkan nomor KTP : ");
        input.nextLine();
        nik = input.nextLine();
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
                hp = input.nextLine();

                if ((hp.length() > 12 || hp.length() < 11) || !(hp.matches("[0-9_]+"))) {
                    System.out.println("No. hp tidak valid, harus angka dan terdiri dari 11 hingga 12 digit, misal: 085224224224");
                }
            } while ((hp.length() > 12 || hp.length() < 11) || !(hp.matches("[0-9_]+")));
            
            // VALIDASI EMAIL
            do {
                System.out.print("Email : ");
                email = input.nextLine();

                if (ctrUser.findEmailInUsers(email) != -99){
                    if (email.equals(users.get(ctrUser.findEmailInUsers(email)).getEmail())){
                        if (!email.equals(u.getEmail())){
                            System.out.println("Email sudah terdaftar!");
                        }
                    }
                }
            } while ((ctrUser.findEmailInUsers(email) != -99) && email.equals(users.get(ctrUser.findEmailInUsers(email)).getEmail()) && !email.equals(u.getEmail()));

            // VALIDASI PASSWORD
            do {
                System.out.print("Password : ");
                pass = input.nextLine();
                System.out.print("Re-Password : ");
                repass = input.nextLine();

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
