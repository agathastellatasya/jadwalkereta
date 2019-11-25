package jadwalkereta.view;

import jadwalkereta.controller.*;
import java.io.*;
import java.util.Scanner;

public class ViewJadwal {
    private int pilihan;
    ControllerJadwal ctrJadwal;
    Scanner input = new Scanner(System.in);

    public ViewJadwal(ControllerJadwal ctr) {
        this.ctrJadwal = ctr;
    }

    public void menuJadwal() {
        System.out.println("#GENERATE DATA WAKTU#");
        System.out.println("1. Lihat Data Waktu");
        System.out.println("99. Menu Utama");
        System.out.print("Pilihan : ");
        pilihan = input.nextInt();
    }

    public void menuGenerateJadwal(){
        System.out.print("Apakah anda yakin untuk generate waktu (Y/N)? ");
        String pilihan  = input.next();
        if(pilihan.equals("Y") || pilihan.equals("y")){
            ctrJadwal.GenerateJadwal();
        }
        else{
            ctrJadwal.ControlMenuJadwal();
        }
        System.out.println("Generate Waktu Berhasil!"); 
    }

    public void menuLihatJadwal(){
        //System.out.println("No\tKode\tWaktu");
        ctrJadwal.LihatJadwal();
    }

    public int getPilihan()
    {
        return pilihan;
    }
}