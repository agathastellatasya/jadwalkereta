/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import jadwalkereta.view.ViewMain;
import jadwalkereta.model.*;
import jadwalkereta.model.ConfigDirektori;

import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.*;
import java.io.*;

/**
 *
 * @author ASUS
 */
public class ControllerMain {
    ViewMain viewMain;
    private int pilihan;
    ArrayList<User> users;
    ArrayList<Station> stations;
    ArrayList<Time> times;
    ArrayList<City> cities;
    ArrayList<Rute> rute;
    ArrayList<Kereta> kereta;
    //ArrayList<TimeRute> timerute;
    //ArrayList<KARute> karute;
    ArrayList<Jadwal> jadwal;
  
    // Menambahkan parameter ArrayList<Station> s pada konstruktor
    public ControllerMain(ArrayList<User> u, ArrayList<Station> s, ArrayList<City> c, ArrayList<Rute> r, ArrayList<Time> t, ArrayList<Kereta> k, ArrayList<Jadwal> j)  {
        viewMain = new ViewMain();
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

    public ControllerMain(){
        viewMain = new ViewMain();
        users = new ArrayList<User>();
        stations = new ArrayList<Station>();
        cities = new ArrayList<City>();
        times = new ArrayList<Time>();
        rute = new ArrayList<Rute>();
        kereta = new ArrayList<Kereta>();
        jadwal = new ArrayList<Jadwal>();
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
    

        // ReadJSONJadwal();
        // ReadJSONKereta();
        // ReadJSONUser();
        // ReadJSONTime();
        // ReadJSONStation();

    public ArrayList<User> getUsers() {  ReadJSONUser(); return users; }
    public ArrayList<Station> getStations() { ReadJSONStation(); return stations; }
    public ArrayList<Time> getTimes() { ReadJSONTime(); return times; }
    public ArrayList<City> getCities() { ReadJSONCity(); return cities; }
    public ArrayList<Rute> getRute() { ReadJSONRute(); return rute; }
    public ArrayList<Kereta> getKereta() { ReadJSONKereta(); return kereta; }
    public ArrayList<Jadwal> getJadwal() { ReadJSONJadwal(); return jadwal; }

    
    public void run(){
        ReadJSONJadwal();
        ReadJSONKereta();
        ReadJSONUser();
        ReadJSONTime();
        ReadJSONStation();
        ReadJSONRute();
        ReadJSONCity();

        Scanner in = new Scanner(System.in);
        viewMain.menuMain();
        
        do {
            pilihan = in.nextInt();
            System.out.println();
            switch(pilihan){
                case 0: break;
                case 1: {
                    ControllerUser ctrUser = new ControllerUser(this);
                    ctrUser.register();
                    break;
                }
    
                case 2: {
                    ControllerUser ctrUser = new ControllerUser(this);
                    ctrUser.login();
                    break;
                }
    
                default: {
                    System.out.println("Input salah!");
                    System.out.println();
                    viewMain.menuMain();
                }
            }
        } while (pilihan != 0);
    }

    // private void elseif(boolean b) {
    //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }

    
}
