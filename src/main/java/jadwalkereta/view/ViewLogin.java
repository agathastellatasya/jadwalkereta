/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.view;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ViewLogin {
    private int pilihan;
    private String email, password;
    Scanner input = new Scanner(System.in);

    public ViewLogin() {
        menuLogin();
    }
    
    public void menuLogin(){
        System.out.println("#Login#");
        System.out.print("Email : ");
        email = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
