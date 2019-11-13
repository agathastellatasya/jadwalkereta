/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ASUS
 */
public class User {
    protected String email;
    protected String nama;
    protected String nik;
    protected String hp;
    protected String password;
    protected int role;
    
    public User() {
    }
    
    public User (String email, String password){
        this.email = email;
        this.password = password;
    }
    
    public User (String email){
        this.email = email;
    }
    
    public User(String email, String password, int role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String nik, String nama, String hp, String email, String password, int role) {
        this.nik = nik;
        this.nama = nama;
        this.hp = hp;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    public void setNik(String nik) {
        this.nik = nik;
    }
    
    public void setHp(String hp) {
        this.hp = hp;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }
    
    public String getNik() {
        return nik;
    }
    
    public String getHp() {
        return hp;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void TulisUserToJson(){
        // create object
        JSONObject root = new JSONObject();
        JSONArray user= new JSONArray();
        JSONParser parser = new JSONParser();
        JSONArray array = null;
          
        File f = new File(ConfigDirektori.direktoriAkun);
        
        if (f.exists() && !f.isDirectory()) { // check file is exist , if not create new file
            try {
                //Object  read = parser.parse(new FileReader(ConfigDirektori.direktoriAkun));
                JSONObject objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.direktoriAkun));
                array = (JSONArray) objFromFile.get("users");
                //array = (JSONArray) read;
            } catch (FileNotFoundException e) {
             e.printStackTrace();
            } catch (IOException e) {
             e.printStackTrace();
            } catch (ParseException ex) {
             Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Create JSONObject and JSONArray and store a class object on it
        JSONObject uo = new JSONObject();
            uo.put("email", email);
            uo.put("password", password);
            uo.put("role", 2);
            uo.put("nama", nama);
            uo.put("nik", nik);
            uo.put("nomor handphone", hp);
        
        if (f.exists() && !f.isDirectory()) {
            array.add(uo);
            // add the array to the root object
            root.put("users",array);
        }
        else{
            user.add(uo);
             // add the array to the root object
            root.put("users",user);
        }
        
        try (FileWriter file = new FileWriter(ConfigDirektori.direktoriAkun)) {
            file.write(root.toJSONString()); // print object to new .json
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    public boolean CekUserFromJson() {
        JSONParser parser = new JSONParser();
        JSONArray array = null;
        boolean found = false;
        
        try {
            JSONObject  objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.direktoriAkun));
            array = (JSONArray) objFromFile.get("users");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < array.size(); i++) {
            JSONObject itemArr = (JSONObject)array.get(i);
            
            if(itemArr.get("email").equals(email)){ // check if username exist
                found = true;
            }       
        }
        return found;
}
    
    public long LoginFromJson(String username, String Password) {
        JSONParser parser = new JSONParser();
        JSONArray array = null;  
        long roles = 0;
        try {
            JSONObject  objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.direktoriAkun));
            array = (JSONArray) objFromFile.get("users");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < array.size(); i++) {
            JSONObject itemArr = (JSONObject)array.get(i);
             //System.out.println(itemArr.get("username"));
             //System.out.println(itemArr.get("password"));
             //System.out.println(itemArr.get("role"));
            if (itemArr.get("email").equals(email) && itemArr.get("password").equals(Password)) {
                roles = (long) itemArr.get("role");  
                //roles = ((Long) itemArr.get("role").intValue());
                break;
            }
        }
        //System.out.println(role);
        return roles;
}
 
}
