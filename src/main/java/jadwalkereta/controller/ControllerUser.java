package jadwalkereta.controller;

import jadwalkereta.model.User;
import jadwalkereta.view.ViewUser;

import java.util.*;

public class ControllerUser{
    ControllerMain ctrMain;
    ArrayList<User> users;
    User user = new User();

    public ControllerUser(ControllerMain ctr, ArrayList<User> u){
        users = u;
        ctrMain = ctr;
    }

    public int findNikInUsers(String nik){
        boolean found = false;
        int i = 0;
        int hasil = -99;

        while (!found && (i<users.size())){
            if (users.get(i).getNik().equals(nik)){
                found = true;
                hasil = i;
            } else {
                i++;
            }
        }

        return hasil;
    }

    public int findEmailInUsers(String email){
        boolean found = false;
        int i = 0;
        int hasil = -99;

        while (!found && (i<users.size())){
            if (users.get(i).getEmail().equals(email)){
                found = true;
                hasil = i;
            } else {
                i++;
            }
        }

        return hasil;
    }

    public int successLogin(User u){
        boolean found = false;
        int i = 0;
        int hasil = -99;
        while (!found && (i<users.size())){
            if (users.get(i).getEmail().equals(u.getEmail())){
                if (users.get(i).getPassword().equals(u.getPassword())){
                    found = true;
                    hasil = i;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
    
        return hasil;
    }

    public void login(){
        ViewUser viewUser = new ViewUser(ctrMain,users,user);
        viewUser.menuLogin();
        if (successLogin(viewUser.getUser()) != -99){
            user = users.get(successLogin(viewUser.getUser()));
            switch (user.getRole()){
                case 1: {
                    ControllerAdmin ctrAdmin = new ControllerAdmin(ctrMain);
                    ctrAdmin.ControlMenuAdmin();
                    break;
                }

                case 2: {
                    ControllerPenumpang ctrPenumpang = new ControllerPenumpang(ctrMain,user);
                    ctrPenumpang.ControlMenuPenumpang();
                    break;
                }
            }
        } else {
            System.out.println();
            System.out.println("Username atau Password salah!");
            System.out.println();
            ctrMain.run();
        }
    }

    public void register(){
        ViewUser viewUser = new ViewUser(ctrMain,users,user);
        viewUser.menuRegis();
        users.add(viewUser.getUser());

        System.out.println("Anda sudah berhasil didaftarkan!");
        System.out.println();
        
        ctrMain.run();
    }

    public void editUser(String nik, String nama, String hp, String email, String pass){
        users.get(findNikInUsers(nik)).setNama(nama);
        users.get(findNikInUsers(nik)).setHp(hp);
        users.get(findNikInUsers(nik)).setEmail(email);
        users.get(findNikInUsers(nik)).setPassword(pass);
    }
}