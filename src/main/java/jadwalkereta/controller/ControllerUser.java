package jadwalkereta.controller;

import jadwalkereta.model.User;
import jadwalkereta.view.ViewUser;
import jadwalkereta.view.ViewAdmin;
import jadwalkereta.model.Station;

import java.util.*;

public class ControllerUser{
    ControllerMain ctrMain;
    ArrayList<User> users;
    ArrayList<Station> stations;
    User user = new User();

    public ControllerUser(final ControllerMain ctr, final ArrayList<User> u, final ArrayList<Station> s){
        users = u;
        ctrMain = ctr;
        stations =  s;
    }

    public int findNikInUsers(final String nik){
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

    public int findEmailInUsers(final String email){
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

    public int successLogin(final User u){
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
        final ViewUser viewUser = new ViewUser(ctrMain,users,user,stations);
        viewUser.menuLogin();
        if (successLogin(viewUser.getUser()) != -99){
            user = users.get(successLogin(viewUser.getUser()));
            switch (user.getRole()){
                case 1: {
                    final ViewAdmin viewAdmin = new ViewAdmin(ctrMain,users,stations);
                    final ControllerAdmin ctrAdmin = new ControllerAdmin(ctrMain,viewAdmin,users,stations);
                    ctrAdmin.ControlMenuAdmin();
                    break;
                }

                case 2: {
                    final ControllerPenumpang ctrPenumpang = new ControllerPenumpang(ctrMain,users,user);
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
        final ViewUser viewUser = new ViewUser(ctrMain,users,user,stations);
        viewUser.menuRegis();
        users.add(viewUser.getUser());

        System.out.println("Anda sudah berhasil didaftarkan!");
        System.out.println();
        
        ctrMain.run();
    }

    public void editUser(final String nik, final String nama, final String hp, final String email, final String pass){
        users.get(findNikInUsers(nik)).setNama(nama);
        users.get(findNikInUsers(nik)).setHp(hp);
        users.get(findNikInUsers(nik)).setEmail(email);
        users.get(findNikInUsers(nik)).setPassword(pass);
    }
}