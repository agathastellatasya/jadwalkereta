package jadwalkereta.view;

import jadwalkereta.controller.*;
import java.io.*;
import java.util.Scanner;

public class ViewTime {
    private int pilihan;
    ControllerTime ctrTime;
    Scanner input = new Scanner(System.in);

    public ViewTime(ControllerTime ctr) {
        this.ctrTime = ctr;
    }

    public void menuTime(){
        System.out.println("#GENERATE DATA WAKTU#");
        System.out.println("1. Lihat Data Waktu");
        System.out.println("99. Menu Utama");
        System.out.print("Pilihan : ");
        pilihan = input.nextInt();
    }

    public void menuGenerateWaktu() {
        System.out.print("Apakah anda yakin untuk generate waktu (Y/N)? ");
        String pilihan  = input.next();
        if(pilihan.equals("Y") || pilihan.equals("y")){
            ctrTime.GenerateWaktu();
        }
        else{
            ctrTime.ControlMenuTime();
        }
        System.out.println("Generate Waktu Berhasil!"); 
    }

    public void menuLihatWaktu(){
        System.out.println("No\tKode\tWaktu");
        ctrTime.LihatWaktu();
    }

    public int getPilihan()
    {
        return pilihan;
    }
}