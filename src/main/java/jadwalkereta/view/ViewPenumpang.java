/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import jadwalkereta.model.User;
import jadwalkereta.controller.ControllerMain;
import jadwalkereta.controller.ControllerUser;
import jadwalkereta.controller.ControllerUtil;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class ViewPenumpang {
    private User user;
    ControllerMain ctrMain;
    ControllerUtil ctrUtil = new ControllerUtil();
    ArrayList<User> users;
    private int pilihan;
    Scanner input = new Scanner(System.in);
    
    public ViewPenumpang(ControllerMain ctr, User u){
        user = u;
        ctrMain = ctr;
        users =ctrUtil.getUsers();
    }

    public int getPilihan(){
        return pilihan;
    }
    
    public void menuPenumpang() {
        System.out.println();
        System.out.println("###### Menu Pengguna ######");
        System.out.println("Welcome, " + user.getNama() + "!");
        System.out.println();
        System.out.println("1. \t Booking Tiket");
        System.out.println("2. \t Kelola Profile");
        System.out.println("3. \t History Pembelian");
       // System.out.println("4. \t Cari Jadwal");
        System.out.println("0. \t Logout");
        System.out.println();
        System.out.print("Pilih Menu : ");
        pilihan = input.nextInt();
    }

    public User kelolaProfile(){
        String nama, hp, email, pass, repass;
        ControllerUser ctrUser = new ControllerUser(ctrMain);

        System.out.println("###### KELOLA PROFILE BY PENUMPANG ######");
        System.out.println("------ DATA PENGGUNA ------");
        System.out.println("Nama Lengkap : " + user.getNama());
        System.out.println("Nomor Handphone : " + user.getHp());
        System.out.println("Email : " + user.getEmail());
        System.out.println("Password : " + user.getPassword());
        System.out.println();

        System.out.println("------ UBAH DATA PENGGUNA ------");
        // VALIDASI NAMA
        input.nextLine();
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
                    if (!email.equals(user.getEmail())){
                        System.out.println("Email sudah terdaftar!");
                    }
                }
            } while ((ctrUser.findEmailInUsers(email) != -99) && !email.equals(user.getEmail()));

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
            user  = ctrUser.editUser(user.getNik(), nama, hp, email, pass);
            
            System.out.println();
            System.out.println("DATA BERHASIL DIUPDATE, BERIKUT DATA TERBARU:");
            System.out.println("Nomor KTP : " + user.getNik());
            System.out.println("Nama Lengkap : " + user.getNama());
            System.out.println("Nomor Handphone : " + user.getHp());
            System.out.println("Email : " + user.getEmail());
            System.out.println("Password : " + user.getPassword());

            return ctrUser.editUser(user.getNik(), nama, hp, email, pass);

    }

    public void History()
    {
        System.out.println("==============================Riwayat Transaksi==============================");
        System.out.println("Kode Bayar\t\tTanggal\t\t\tStatus\t\tKode Booking");
        for(int i=0;i<user.getTransaksi().size();i++)
        {
            System.out.print(user.getTransaksi().get(i).getKodebayar()+"\t\t");
            System.out.print(user.getTransaksi().get(i).getTanggal()+"\t\t");
            System.out.print(user.getTransaksi().get(i).getKeterangan()+"\t\t");
            System.out.print(user.getTransaksi().get(i).getKodebooking());
            System.out.println();
        }
        System.out.println("============================================================================");
        
    }
}