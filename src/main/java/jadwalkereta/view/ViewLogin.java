/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import java.util.Scanner;

import jadwalkereta.model.User;

/**
 *
 * @author ASUS
 */
public class ViewLogin {
    User user;
    private String email, password;   

    public ViewLogin(User u) {
        // menuLogin();
        user = u;
    }
    
    public void menuLogin(){
        Scanner input = new Scanner(System.in);
        System.out.println("###### LOGIN ######");
        System.out.print("Email : ");
        email = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();
        user.setEmail(email);
        user.setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User getUser(){
        return user;
    }
}
