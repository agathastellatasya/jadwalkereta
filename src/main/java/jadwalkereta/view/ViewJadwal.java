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
        System.out.println("#GENERATE JADWAL#");
        System.out.print("Apakah anda yakin untuk generate Jadwal (Y/N)? ");
        String pilihan  = input.next();
        if(pilihan.equals("Y") || pilihan.equals("y")){
            ctrJadwal.GenerateJadwal();
        }
        else{
            ctrJadwal.ControlMenuJadwal();
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Generate Jadwal Berhasil!"); 
        System.out.println("--------------------------------------------------------------------------");
    }

    public void menuLihatJadwal(){
        System.out.println("#LIHAT JADWAL KERETA API#");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Kode\t\tTanggal\t\tWaktu\t\tKeberangkatan\tTujuan\t\tWaktu \tKAI\t\tStatus");
        System.out.println("Jadwal\t\t\t\tKeberangkatan\t\t\t\t\t Tiba");
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