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
public class Stasiun {
    protected String kode;
    protected String nama;
     
    public Stasiun (String kode, String nama){
        this.kode = kode;
        this.nama = nama;
    }

    public Stasiun(){}

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }
    
    public void TulisStasiunToJson(){
        // create object
        JSONObject root = new JSONObject();
        JSONArray Stasiun = new JSONArray();
        JSONParser parser = new JSONParser();
        JSONArray array = null;
          
        File f = new File(ConfigDirektori.direktoriStasiun);
        
        if (f.exists() && !f.isDirectory()) { // check file is exist , if not create new file
            try {
                //Object  read = parser.parse(new FileReader(ConfigDirektori.direktoriAkun));
                JSONObject objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.direktoriStasiun));
                array = (JSONArray) objFromFile.get("stasiuns");
                //array = (JSONArray) read;
            } catch (FileNotFoundException e) {
             e.printStackTrace();
            } catch (IOException e) {
             e.printStackTrace();
            } catch (ParseException ex) {
             Logger.getLogger(Stasiun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Create JSONObject and JSONArray and store a class object on it
        JSONObject uo = new JSONObject();
        uo.put("kode", kode);
        uo.put("nama", nama);

        if (f.exists() && !f.isDirectory()) {
            array.add(uo);
            // add the array to the root object
            root.put("stasiuns",array);
        }
        else{
            Stasiun.add(uo);
             // add the array to the root object
            root.put("stasiuns",Stasiun);
        }
        
        try (FileWriter file = new FileWriter(ConfigDirektori.direktoriStasiun)) {
            file.write(root.toJSONString()); // print object to new .json
            file.flush();
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DisplayAllStasiun() {
        JSONParser parser = new JSONParser();
        JSONArray array = null;

        try {
            JSONObject objFromFile = (JSONObject) parser.parse(new FileReader(ConfigDirektori.direktoriStasiun));
            array = (JSONArray) objFromFile.get("stasiuns");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Stasiun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Stasiun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Stasiun.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("No\tKode Stasiun\tNama Stasiun");
        for (int i = 0; i < array.size(); i++) {
            JSONObject itemArr = (JSONObject) array.get(i);
                System.out.println(i+1+"\t"+itemArr.get("kode")+"\t\t"+itemArr.get("nama"));
        }
    }
}
