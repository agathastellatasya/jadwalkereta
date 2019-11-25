/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jadwalkereta.model.City;
import jadwalkereta.model.ConfigDirektori;
import jadwalkereta.model.Jadwal;
import jadwalkereta.model.User;
import jadwalkereta.model.Jalur;
import jadwalkereta.model.Kereta;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Station;
import jadwalkereta.model.Time;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author ASUS
 */
public class ControllerUtil {
    ControllerMain ctrMain;
    ArrayList<User> users;
    ArrayList<Station> stations;
    ArrayList<Time> times;
    ArrayList<City> cities;
    ArrayList<Rute> rute;
    ArrayList<Kereta> kereta;
    ArrayList<Jadwal> jadwal;
//    User user = new User();
//    Jalur jalur = new Jalur();
//    Rute rute = new Rute();
//    Station station = new Station();
    
    public ControllerUtil(ArrayList<User> u, ArrayList<Station> s, ArrayList<City> c, ArrayList<Rute> r, ArrayList<Time> t, ArrayList<Kereta> k, ArrayList<Jadwal> j)  {
        //viewMain = new ViewMain();
        users = u;
        stations = s;
	cities =c;
        rute = r;
        times = t;
        //timerute = tr;
        kereta = k;
//        karute = kr;
	jadwal = j;
    }

    public ControllerUtil() {
        users = new ArrayList<User>();
        stations = new ArrayList<Station>();
        cities = new ArrayList<City>();
        times = new ArrayList<Time>();
        rute = new ArrayList<Rute>();
        kereta = new ArrayList<Kereta>();
        jadwal = new ArrayList<Jadwal>();
    }
    
    public ArrayList<User> getUsers() {  
        ReadJSONUser(); 
        return users; 
    }
    public ArrayList<Station> getStations() { 
        ReadJSONStation(); 
        return stations; 
    }
    public ArrayList<Time> getTimes() { 
        ReadJSONTime(); 
        return times; 
    }
    public ArrayList<City> getCities() { 
        ReadJSONCity(); 
        return cities; 
    }
    public ArrayList<Rute> getRute() { 
        ReadJSONRute(); 
        return rute; 
    }
    public ArrayList<Kereta> getKereta() { 
        ReadJSONKereta(); 
        return kereta; 
    }
    public ArrayList<Jadwal> getJadwal() { 
        ReadJSONJadwal(); 
        return jadwal; 
    }
    
    public void WriteJSONRute(){
        try
        {
            List<Rute> List = rute;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter(ConfigDirektori.RUTE);
            gson.toJson(List, writer);
            writer.close();
        }
        catch(IOException e){}
    }

    public void WriteJSONStation(){
        try
        {
            List<Station> List = stations;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter(ConfigDirektori.STATION);
            gson.toJson(List, writer);
            writer.close();
        }
        catch(IOException e){}
    }

    public void WriteJSONKereta(){
        try
        {
            List<Kereta> List = kereta;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter(ConfigDirektori.KERETA);
            gson.toJson(List, writer);
            writer.close();
        }
        catch(IOException e){}
    }

    public void WriteJSONCity(){
        try
        {
            List<City> List = cities;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter(ConfigDirektori.CITY);
            gson.toJson(List, writer);
            writer.close();
        }
        catch(IOException e){}
    }

    public void WriteJSONJadwal(){
        try
        {
            List<Jadwal> List = jadwal;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter(ConfigDirektori.JADWAL);
            gson.toJson(List, writer);
            writer.close();
        }
        catch(IOException e){}
    }
    
    public void WriteJSONUser(){
        try
        {
            List<User> List = users;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter(ConfigDirektori.USER);
            gson.toJson(List, writer);
            writer.close();
        }
        catch(IOException e){}
    }

    public void WriteJSONTime(){
        try
        {
            List<Time> List = times;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter(ConfigDirektori.TIME);
            gson.toJson(List, writer);
            writer.close();
        }
        catch(IOException e){}
    }

    public void ReadJSONCity(){
        try
        {
            Gson gson = new Gson();
            Reader reader = new FileReader(ConfigDirektori.CITY);
            cities = (ArrayList) gson.fromJson(reader, new TypeToken<List<City>>() {
            }.getType());
            reader.close();
        }
        catch(IOException e){}
    }

    public void ReadJSONRute(){
        try
        {
            Gson gson = new Gson();
            Reader reader = new FileReader(ConfigDirektori.RUTE);
            rute = (ArrayList) gson.fromJson(reader, new TypeToken<List<Rute>>() {
            }.getType());
            reader.close();
        }
        catch(IOException e){}
    }

    public void ReadJSONKereta(){
        try
        {
            Gson gson = new Gson();
            Reader reader = new FileReader(ConfigDirektori.KERETA);
            kereta = (ArrayList) gson.fromJson(reader, new TypeToken<List<Kereta>>() {
            }.getType());
            reader.close();
        }
        catch(IOException e){}
    }

    public void ReadJSONJadwal(){
        try
        {
            Gson gson = new Gson();
            Reader reader = new FileReader(ConfigDirektori.JADWAL);
            jadwal = (ArrayList) gson.fromJson(reader, new TypeToken<List<Jadwal>>() {
            }.getType());
            reader.close();
        }
        catch(IOException e){}
    }

    public void ReadJSONStation(){
        try
        {
            Gson gson = new Gson();
            Reader reader = new FileReader(ConfigDirektori.STATION);
            stations = (ArrayList) gson.fromJson(reader, new TypeToken<List<Station>>() {
            }.getType());
            reader.close();
        }
        catch(IOException e){}
    }

    public void ReadJSONTime(){
        try
        {
            Gson gson = new Gson();
            Reader reader = new FileReader(ConfigDirektori.TIME);
            times = (ArrayList) gson.fromJson(reader, new TypeToken<List<Time>>() {
            }.getType());
            reader.close();
        }
        catch(IOException e){}
    }

    public void ReadJSONUser(){
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(ConfigDirektori.USER);
            users = (ArrayList) gson.fromJson(reader, new TypeToken<List<User>>() {
            }.getType());
            reader.close();
        }
        catch (IOException e) {}
    }
    
//    public void TulisUserToJson(String email, String password, String nik, String hp, int role, String nama){
//        // create object
//        JSONObject root = new JSONObject();
//        JSONArray user= new JSONArray();
//        JSONParser parser = new JSONParser();
//        JSONArray array = null;
//          
//        File f = new File(ConfigDirektori.USER);
//        
//        if (f.exists() && !f.isDirectory()) { // check file is exist , if not create new file
//            try {
//                //Object  read = parser.parse(new FileReader(ConfigDirektori.direktoriAkun));
//                JSONObject objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.USER));
//                array = (JSONArray) objFromFile.get("users");
//                //array = (JSONArray) read;
//            } catch (FileNotFoundException e) {
//             e.printStackTrace();
//            } catch (IOException e) {
//             e.printStackTrace();
//            } catch (ParseException ex) {
//             Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        //Create JSONObject and JSONArray and store a class object on it
//        JSONObject uo = new JSONObject();
//        if (role == 1){
//            uo.put("email", email);
//            uo.put("password", password);
//            uo.put("role", role);
//            uo.put("nik",nik);
//            uo.put("nama", nama);
//            uo.put("hp",hp);
//        } 
//        else if (role == 2){
//            uo.put("email", email);
//            uo.put("password", password);
//            uo.put("role", role);
//            uo.put("nik",nik);
//            uo.put("nama", nama);
//            uo.put("hp",hp);
//        
//        } 
//        
//        else {
//            System.out.println("role tidak ditemukan");
//        }
//        
//        if (f.exists() && !f.isDirectory()) {
//            array.add(uo);
//            // add the array to the root object
//            root.put("users",array);
//        }
//        else{
//             user.add(uo);
//             // add the array to the root object
//            root.put("users",user);
//        }
//        
//        try (FileWriter file = new FileWriter(ConfigDirektori.USER)) {
//            file.write(root.toJSONString()); // print object to new .json
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public boolean CekUserFromJson(String email) {
//        JSONParser parser = new JSONParser();
//        JSONArray array = null;
//        boolean found = false;
//        
//        try {
//            JSONObject  objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.USER));
//            array = (JSONArray) objFromFile.get("users");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        for (int i = 0; i < array.size(); i++) {
//            JSONObject itemArr = (JSONObject)array.get(i);
//            
//            if(itemArr.get("email").equals(email)){ // check if username exist
//                found = true;
//            }       
//        }
//        return found;
//    }
//    
//        public long LoginFromJson(String email, String password) {
//        JSONParser parser = new JSONParser();
//        JSONArray array = null;  
//        long roles = 0;
//        try {
//            JSONObject  objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.USER));
//            array = (JSONArray) objFromFile.get("users");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException | ParseException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        for (int i = 0; i < array.size(); i++) {
//            JSONObject itemArr = (JSONObject)array.get(i);
//             //System.out.println(itemArr.get("username"));
//             //System.out.println(itemArr.get("password"));
//             //System.out.println(itemArr.get("role"));
//            if (itemArr.get("email").equals(email) && itemArr.get("password").equals(password)) {
//                roles = (long) itemArr.get("role");  
//                //roles = ((Long) itemArr.get("role").intValue());
//                break;
//            }
//        }
//        //System.out.println(role);
//        return roles;
//    }
//    
//        public void EditUserByAdminFromJson(String email, String password, String nik, String hp, int role, String nama){
//        JSONObject root = new JSONObject();
//        JSONParser parser = new JSONParser();
//        JSONArray array = null;
//        
//        try {
//            JSONObject  objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.USER));
//            array = (JSONArray) objFromFile.get("users");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        for (int i = 0; i < array.size(); i++) {
//            JSONObject itemArr = (JSONObject)array.get(i);
//            
//            if(itemArr.get("nik").equals(nik)){
//                itemArr.put("email", email);
//                itemArr.put("password", password);
//                itemArr.put("role", 2);
//                itemArr.put("hp", hp);
//                itemArr.put("nama", nama);
//            }       
//            root.put("users",array);
//            
//            try (FileWriter file = new FileWriter(ConfigDirektori.USER)) {
//                file.write(root.toJSONString());
//                file.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//        
//        public void EditUserByUserFromJson(String email, String password, String nik, String hp, int role, String nama){
//        JSONObject root = new JSONObject();
//        JSONParser parser = new JSONParser();
//        JSONArray array = null;
//        
//        try {
//            JSONObject  objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.USER));
//            array = (JSONArray) objFromFile.get("users");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        for (int i = 0; i < array.size(); i++) {
//            JSONObject itemArr = (JSONObject)array.get(i);
//            
//                itemArr.put("nik",nik);
//                itemArr.put("email", email);
//                itemArr.put("password", password);
//                itemArr.put("role", 2);
//                itemArr.put("hp", hp);
//                itemArr.put("nama", nama);
//                  
//            root.put("users",array);
//            
//            try (FileWriter file = new FileWriter(ConfigDirektori.USER)) {
//                file.write(root.toJSONString());
//                file.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
