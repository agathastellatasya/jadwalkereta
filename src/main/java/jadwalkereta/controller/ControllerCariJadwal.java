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
//import jadwalkereta.model.KARute;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Tanggal;
import jadwalkereta.model.TimeRute;
import jadwalkereta.view.ViewCariJadwal;

/**
 *
 * @author ASUS
 */
public class ControllerCariJadwal {

    ArrayList<Jadwal> jadwal;
    ControllerMain ctrMain;
    ControllerPenumpang ctrPenumpang;
    ViewCariJadwal viewCariJadwal;
    Scanner input = new Scanner(System.in);

    public ControllerCariJadwal(ControllerPenumpang penumpang) {
        ctrPenumpang = penumpang;
        ctrMain = ctrPenumpang.getControllerMain();
        jadwal = ctrMain.getJadwal();
    }

    public void ControlMenuCariJadwal() {
        if (viewCariJadwal == null)
            viewCariJadwal = new ViewCariJadwal(this);
        viewCariJadwal.menuCariJadwal();
        ctrPenumpang.ControlMenuPenumpang();
    }

    public void cariJadwal(String keberangkatan, String tujuan, String mtanggal){
        for(int i=0;i<jadwal.size();i++)
        {
            Tanggal tanggal = jadwal.get(i).getTanggal();
            String stanggal = tanggal.getHari()+"-"+tanggal.getBulan()+"-"+tanggal.getTahun();

            
            if(jadwal.get(i).getKotaBerangkat().equals(keberangkatan)&&jadwal.get(i).getKotaTujuan().equals(tujuan)&&stanggal.equals(mtanggal))
            {
                Jadwal mjadwal = jadwal.get(i);
                String kode = mjadwal.getKode();
                String waktuBerangkat = String.format("%02d", mjadwal.getJamBerangkat()) + "."
                        + String.format("%02d", mjadwal.getMenitBerangkat());
                String waktuSampai = String.format("%02d", mjadwal.getJamSampai()) + "."
                        + String.format("%02d", mjadwal.getMenitSampai());
                String kotaBerangkat = mjadwal.getKotaBerangkat();
                String kotaTujuan = mjadwal.getKotaTujuan();
                String keretaapi = mjadwal.getKereta().getKodeKereta();
                int kursi = mjadwal.getKereta().countBangkuKosong();
                System.out.print(kode);
                System.out.print("\t" + stanggal);
                System.out.print("\t" + waktuBerangkat);
                System.out.print("\t" + waktuSampai);
                System.out.print("\t" + kotaBerangkat);
                System.out.print("\t" + kotaTujuan);
                System.out.print("\t" + keretaapi);
                if (kursi > 0)
                    System.out.print("\tSisa Kursi " + kursi);
                else
                    System.out.print("\tFull");
                System.out.println();
            }
        }

    }

}
