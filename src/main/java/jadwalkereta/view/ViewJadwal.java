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
        System.out.println("#GENERATE JADWAL#");
        System.out.println("1. Generate Jadwal");
        System.out.println("2. Lihat Jadwal");
        System.out.println("99. Menu Utama");
        System.out.print("Pilihan : ");
        pilihan = input.nextInt();
    }

    public void menuGenerateJadwal(){
        System.out.print("Apakah anda yakin untuk generate Jadwal (Y/N)? ");
        String pilihan  = input.next();
        if(pilihan.equals("Y") || pilihan.equals("y")){
            ctrJadwal.GenerateJadwal();
        }
        else{
            ctrJadwal.ControlMenuJadwal();
        }
        System.out.println("Generate Jadwal Berhasil!"); 
    }

    public void menuLihatJadwal(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Kode Jadwal\tTanggal\t\tWaktu Keberangkatan\tKeberangkatan\tTujuan\t\tWaktu Tiba\tKAI\t\tStatus");
        //System.out.println("No\tKode\tWaktu");
        ctrJadwal.LihatJadwal();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("");
    }

    public int getPilihan()
    {
        return pilihan;
    }
}