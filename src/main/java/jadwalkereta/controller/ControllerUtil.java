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
import jadwalkereta.model.Booking;
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
    ArrayList<Booking> booking;
//    User user = new User();
//    Jalur jalur = new Jalur();
//    Rute rute = new Rute();
//    Station station = new Station();
    
    public ControllerUtil(ArrayList<User> u, ArrayList<Station> s, ArrayList<City> c, ArrayList<Rute> r, ArrayList<Time> t, ArrayList<Kereta> k, ArrayList<Jadwal> j, ArrayList<Booking> b)  {
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
        booking = b;
    }

    public ControllerUtil() {
        users = new ArrayList<User>();
        stations = new ArrayList<Station>();
        cities = new ArrayList<City>();
        times = new ArrayList<Time>();
        rute = new ArrayList<Rute>();
        kereta = new ArrayList<Kereta>();
        jadwal = new ArrayList<Jadwal>();
        booking = new ArrayList<Booking>();
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
    public ArrayList<Booking> getBooking() { 
        ReadJSONBooking(); 
        return booking; 
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
    public void WriteJSONBooking(){
        try
        {
            List<Booking> List = booking;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter(ConfigDirektori.BOOKING);
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
    public void ReadJSONBooking(){
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(ConfigDirektori.BOOKING);
            booking = (ArrayList) gson.fromJson(reader, new TypeToken<List<Booking>>() {
            }.getType());
            reader.close();
        }
        catch (IOException e) {}
    }
    
}
