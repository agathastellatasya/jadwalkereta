package jadwalkereta.controller;

import jadwalkereta.model.User;
import jadwalkereta.view.ViewUser;

import java.util.*;
import java.io.*;

public class ControllerUser{
    ControllerMain ctrMain;
    ControllerUtil ctrUtil = new ControllerUtil();
    ArrayList<User> users;
    User user = new User();

    public ControllerUser(ControllerMain ctr){
        ctrMain = ctr;
        users = ctrUtil.getUsers();
    }

    public int findNikInUsers(String nik){
        users = ctrUtil.getUsers();
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
        users = ctrUtil.getUsers();
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
        users = ctrUtil.getUsers();
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
        users = ctrUtil.getUsers();
        ViewUser viewUser = new ViewUser(ctrMain, user);
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
                    ControllerPenumpang ctrPenumpang = new ControllerPenumpang(ctrMain, user);
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
        users = ctrUtil.getUsers();
        ViewUser viewUser = new ViewUser(ctrMain,user);
        viewUser.menuRegis();
        users.add(viewUser.getUser());
        System.out.println("Anda sudah berhasil didaftarkan!");
        System.out.println();
        ctrUtil.WriteJSONUser();
        ctrMain.run();
    }

    public void editUser(String nik, String nama, String hp, String email, String pass){
        users = ctrUtil.getUsers();
        users.get(findNikInUsers(nik)).setNama(nama);
        users.get(findNikInUsers(nik)).setHp(hp);
        users.get(findNikInUsers(nik)).setEmail(email);
        users.get(findNikInUsers(nik)).setPassword(pass);
        ctrUtil.WriteJSONUser();
    }
}