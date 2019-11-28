package jadwalkereta.view;

import jadwalkereta.model.User;
import jadwalkereta.controller.ControllerUser;
import jadwalkereta.controller.ControllerMain;

import java.util.*;

public class ViewUser{
    User user = new User();
    ControllerMain ctrMain;
    Scanner in = new Scanner(System.in);

    public ViewUser(ControllerMain ctr, User u){
        ctrMain = ctr;
        user = u;
    }

    public User getUser(){
        return user;
    }

    public void menuLogin(){
        // Scanner input = new Scanner(System.in);
        System.out.println("###### LOGIN ######");
        System.out.print("Email : ");
        user.setEmail(in.nextLine());
        System.out.print("Password : ");
        user.setPassword(in.nextLine());
    }

    public void menuRegis(){
        System.out.println("###### REGISTRASI ######");
        String nik, nama, email, hp, password, repassword;
        ControllerUser ctrUser = new ControllerUser(ctrMain);

        // VALIDASI NIK
        do {
            System.out.print("Nomor KTP : ");
            nik = in.nextLine();
            if (nik.length() != 16 || !(nik.matches("[0-9_]+"))) {
                System.out.println("NIK tidak valid, harus berupa 16 digit angka, misal: 1234567891011121");
            }
            
            if (ctrUser.findNikInUsers(nik) != -99){
                System.out.println("NIK sudah terdaftar!");
            }
        } while ((ctrUser.findNikInUsers(nik) != -99) || nik.length() != 16 || !(nik.matches("[0-9_]+")));
        user.setNik(nik);
        
        // VALIDASI NAMA
        do {
            System.out.print("Nama Lengkap : ");
            // in.nextLine();
            nama = in.nextLine();
            if (!nama.matches("^[a-zA-Z\\\\s][a-zA-Z \\\\s]*$")){
                System.out.println("Nama harus terdiri dari huruf semua!");
            }
        } while (!nama.matches("^[a-zA-Z\\\\s][a-zA-Z \\\\s]*$"));
        user.setNama(nama);
        
        // VALIDASI HP
        do {
            System.out.print("Nomor Handphone : ");
            hp = in.nextLine();

            if ((hp.length() > 12 || hp.length() < 11) || !(hp.matches("[0-9_]+"))) {
                System.out.println("No. hp tidak valid, harus angka dan terdiri dari 11 hingga 12 digit, misal: 085224224224");
            }
        } while ((hp.length() > 12 || hp.length() < 11) || !(hp.matches("[0-9_]+")));
        user.setHp(hp);
        
        // VALIDASI EMAIL
        do {
            System.out.print("Email : ");
            email = in.nextLine();

            if (ctrUser.findEmailInUsers(email) != -99){
                System.out.println("Email sudah terdaftar!");
            }

            // if (emailFoundInUser(email)){
            //     System.out.println("Email sudah terdaftar!");
            // }
        } while (ctrUser.findEmailInUsers(email) != -99);
        user.setEmail(email);

        // VALIDASI PASSWORD
        do {
            System.out.print("Password : ");
            password = in.nextLine();
            System.out.print("Re-Password : ");
            repassword = in.nextLine();

            if (!password.equals(repassword)){
                System.out.println("Password dan Re-Password tidak sama! Silakan coba kembali!");
            }
        } while (!password.equals(repassword));
        user.setPassword(password);
    }
}
