/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.ArrayList;
import java.util.Scanner;

import jadwalkereta.model.Jadwal;
import jadwalkereta.model.Jalur;
import jadwalkereta.model.Kereta;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Tanggal;
import jadwalkereta.model.TimeRute;
import jadwalkereta.view.ViewJadwal;
import java.io.*;

/**
 *
 * @author ASUS
 */
public class ControllerJadwal {

    ArrayList<Jadwal> jadwal;
    ControllerMain ctrMain;
    ControllerAdmin ctrAdmin;
    ViewJadwal viewJadwal;
    Scanner input = new Scanner(System.in);

    public ControllerJadwal(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        jadwal = ctrMain.getJadwal();
    }

    public void ControlMenuJadwal(){
        if(viewJadwal == null) viewJadwal = new ViewJadwal(this);
        if(jadwal.size()<=0) viewJadwal.menuGenerateJadwal();
        viewJadwal.menuJadwal();
        switch(viewJadwal.getPilihan()){
            case 1: {
                viewJadwal.menuLihatJadwal();
                ControlMenuJadwal();
                break;
            }
            case 99:{
                ctrAdmin.ControlMenuAdmin();
                break;
            }
        }
    }

    public void GenerateJadwal(){
        int count = 1;
        Tanggal tanggal = new Tanggal(29, 12, 2019);
        ArrayList<Rute> ListRute = ctrMain.getRute();
        for(int i=0;i<ListRute.size();i++)
        {
            Rute rute = ListRute.get(i);
            if(rute.getTime().size()>0 && rute.getKereta().size()>0)
            {
                String kotaBerangkat = rute.getKotaBerangkat();
                String kotaTujuan = rute.getKotaTujuan();
                int j = 0;
                for(j=0;j<rute.getKereta().size();j++)
                {
                    int jamBerangkat = rute.getTime().get(j).getJam();
                    int menitBerangkat = rute.getTime().get(j).getMenit();
                    int[] sampai = rute.getTime().get(j).addTime(rute.getDuration());
                    Kereta kereta = rute.getKereta().get(j);
                    long hargaB = rute.getHargaBisnis();
                    long hargaP = rute.getHargaPremium();
                    jadwal.add(new Jadwal("JW"+count, tanggal, jamBerangkat, menitBerangkat, sampai[0], sampai[1], kotaBerangkat, kotaTujuan, kereta, hargaB, hargaP));
                    count++;
                }
                // perlu ditambahin untuk kereta yang bisa balik lagi
                // int k = 0;
                // if(rute.getTimeRute().size()>rute.getKARute().size())
                // {
                //     for(;j<rute.getTimeRute().size();j++)
                //     {
                //         if(rute.getTimeRute().get(j).isGreaterThan(jadwal.get())){

                //             int jamBerangkat = rute.getTimeRute().get(j).getJam();
                //             int menitBerangkat = rute.getTimeRute().get(j).getJam();
                //             int[] sampai = rute.getTimeRute().get(j).addTime(rute.getDuration());
                //             KARute kereta = rute.getKARute().get(k);
                //             jadwal.add(new Jadwal("JW" + count, tanggal, jamBerangkat, menitBerangkat, sampai[0],
                //                     sampai[1], kotaBerangkat, kotaTujuan, kereta));
                //             count++;
                //             k++;
                //         }
                //     }
                // }
            }
        }
        // ArrayList<TimeRute> timerute = ctrMain.getTimeRute();
        // ArrayList<KARute> karute = ctrMain.getKARute();
        // int i,j,k,jam,menit;
	    // String kdKereta,kdWaktu,koderute,kotaBerangkat,kotaTujuan = "";
        // ArrayList<Rute> rute = ctrMain.getRute();
        // for (i=0; i < rute.size(); i++) {
        //     koderute = rute.get(i).getKodeRute();
        //     kotaBerangkat = rute.get(i).getKotaBerangkat();
        //     kotaTujuan = rute.get(i).getKotaTujuan();
        //     ArrayList<KARute> karute = rute.get(i).getKARute();
        //     ArrayList<TimeRute> timerute = rute.get(i).getTimeRute();
        //     ArrayList<Jalur> jalur = rute.get(i).getJalur();
        //     int wktTempuh = 0;
        //     for (int l = 0; l < jalur.size(); l++) {
        //         Jalur temp_jalur = jalur.get(l);
        //         wktTempuh += temp_jalur.getMenit();
        //     }
        //     //cek apakah timerute > karute
        //     if(karute.size()>=timerute.size()) {
        //         for(j=0; j < timerute.size(); j++){
        //             jam = timerute.get(j).getJam();
        //             menit = timerute.get(j).getMenit();
        //             kdWaktu = String.format("%02d", jam) +"."+ String.format("%02d", menit);
        //             kdKereta = karute.get(j).getKdKereta().getKodeKereta();
        //             System.out.println(koderute + "\t" + kotaBerangkat + "\t" + kotaTujuan + "\t" + kdWaktu + "\t" + kdKereta + "\t" + wktTempuh);
        //         }
        //     }
        //     else {
        //         for(j=0; j < timerute.size(); j++){
        //             k=j%karute.size();
        //             jam = timerute.get(j).getJam();
        //             menit = timerute.get(j).getMenit();
        //             kdWaktu = String.format("%02d", jam) +"."+ String.format("%02d", menit);
        //             kdKereta = karute.get(k).getKdKereta().getKodeKereta();
        //             System.out.println(koderute + "\t" + kotaBerangkat + "\t" + kotaTujuan + "\t" + kdWaktu + "\t" + kdKereta + "\t" + wktTempuh);
        //         }
        //     }
        // }
    }

    public void LihatJadwal(){
        jadwal = ctrMain.getJadwal();
        for(int i=0;i<jadwal.size();i++)
        {
            Jadwal mjadwal = jadwal.get(i);
            String kode = mjadwal.getKode();
            String tanggal = mjadwal.getTanggal().getHari()+"-"+mjadwal.getTanggal().getBulan()+"-"+mjadwal.getTanggal().getTahun();
            String waktuBerangkat =  String.format("%02d", mjadwal.getJamBerangkat())+"."+ String.format("%02d", mjadwal.getMenitBerangkat());
            String waktuSampai = String.format("%02d", mjadwal.getJamSampai()) + "."+ String.format("%02d", mjadwal.getMenitSampai());
            String kotaBerangkat = mjadwal.getKotaBerangkat();
            String kotaTujuan = mjadwal.getKotaTujuan();
            String keretaapi = mjadwal.getKereta().getKodeKereta();
            int kursi = mjadwal.getKereta().countBangkuKosong();
            System.out.print(kode);
            System.out.print("\t"+tanggal);
            System.out.print("\t" + waktuBerangkat);
            System.out.print("\t" + waktuSampai);
            System.out.print("\t" + kotaBerangkat);
            System.out.print("\t" + kotaTujuan);
            System.out.print("\t" + keretaapi);
            if(kursi > 0) System.out.print("\tSisa Kursi " + kursi);
            else 
                System.out.print("\tFull");
            System.out.println();
        }
    }

}
