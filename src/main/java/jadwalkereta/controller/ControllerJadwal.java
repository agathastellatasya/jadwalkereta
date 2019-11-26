/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalkereta.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import jadwalkereta.model.Jadwal;
import jadwalkereta.model.Jalur;
import jadwalkereta.model.Kereta;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Tanggal;
import jadwalkereta.model.TimeRute;
import jadwalkereta.view.ViewJadwal;
import java.io.*;
import java.util.Optional;

/**
 *
 * @author ASUS
 */
public class ControllerJadwal {

    ArrayList<Jadwal> jadwal;
	ArrayList<Rute> rute;
    ControllerMain ctrMain;
    ControllerUtil ctrUtil = new ControllerUtil();
    ControllerAdmin ctrAdmin;
    ViewJadwal viewJadwal;
    Scanner input = new Scanner(System.in);

    public ControllerJadwal(ControllerAdmin admin) {
        ctrAdmin = admin;
        ctrMain = ctrAdmin.getControllerMain();
        jadwal = ctrUtil.getJadwal();
		rute = ctrUtil.getRute();
    }

    public void ControlMenuJadwal(){
        if(viewJadwal == null) viewJadwal = new ViewJadwal(this);
        //viewJadwal.menuGenerateJadwal();
        viewJadwal.menuJadwal();
        switch(viewJadwal.getPilihan()){
            case 1: {
                viewJadwal.menuGenerateJadwal();
                ControlMenuJadwal();
                break;
            }
            case 2: {
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
        Tanggal tanggal;
        Date currentDate = new Date();
        int tgl,bln,thn;
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        //ArrayList<Rute> ListRute = ctrUtil.getRute();
        for(int k=0; k<=30; k++){
            localDateTime = localDateTime.plusDays(1);
            bln = localDateTime.getMonthValue();
            tgl = localDateTime.getDayOfMonth();
            thn = localDateTime.getYear();
            tanggal = new Tanggal(tgl, bln, thn);
			for(int i=0;i<rute.size();i++)
			{
				if(rute.get(i).getTime().size()>0 && rute.get(i).getKereta().size()>0)
				{
					String kotaBerangkat = rute.get(i).getKotaBerangkat();
					String kotaTujuan = rute.get(i).getKotaTujuan();
                                        
					int j = 0;
                                        if(rute.get(i).getTime().size() <= rute.get(i).getKereta().size()) {
                                            for(j=0;j<rute.get(i).getTime().size();j++)
                                            {
//                                                    System.out.println(rute.get(i).getTime().get(j).getJam());
    						int jamBerangkat = rute.get(i).getTime().get(j).getJam();
    						int menitBerangkat = rute.get(i).getTime().get(j).getMenit();
    						int[] sampai = rute.get(i).getTime().get(j).addTime(rute.get(i).getDuration()); 
    						Kereta kereta = rute.get(i).getKereta().get(j);
                                                final Tanggal tgal = tanggal;
                                                Optional<Jadwal> keretaBelomSampai = jadwal.stream()
                                                        .filter(x -> x.getKotaTujuan().equals(kotaBerangkat))
                                                        .filter(x -> x.getKereta().getKodeKereta().equals(kereta.getKodeKereta()))
                                                        .filter(x -> x.getTanggal().equals(tgal))
                                                        .filter(x -> x.getJamSampai() <= sampai[0] || x.getMenitSampai() <= sampai[0])
                                                        .reduce((__, curr) -> curr);
                                                if (keretaBelomSampai.isPresent()){
                                                    tanggal = new Tanggal(tanggal.getHari() + 1, tanggal.getBulan(), tanggal.getTahun());
                                                }
                                                
    						long hargaB = rute.get(i).getHargaBisnis();
    						long hargaP = rute.get(i).getHargaPremium();
    						jadwal.add(new Jadwal("JW"+count, tanggal, jamBerangkat, menitBerangkat, sampai[0], sampai[1], kotaBerangkat, kotaTujuan, kereta, hargaB, hargaP));
    						count++;
                                            }
                                        }
                                        else {
                                            for(j=0;j<rute.get(i).getKereta().size();j++)
                                            {
//                                                    System.out.println(rute.get(i).getTime().get(j).getJam());
    						int jamBerangkat = rute.get(i).getTime().get(j).getJam();
    						int menitBerangkat = rute.get(i).getTime().get(j).getMenit();
    						int[] sampai = rute.get(i).getTime().get(j).addTime(rute.get(i).getDuration());
    						Kereta kereta = rute.get(i).getKereta().get(j);
    						long hargaB = rute.get(i).getHargaBisnis();
    						long hargaP = rute.get(i).getHargaPremium();
    						jadwal.add(new Jadwal("JW"+count, tanggal, jamBerangkat, menitBerangkat, sampai[0], sampai[1], kotaBerangkat, kotaTujuan, kereta, hargaB, hargaP));
    						count++;
                                            }
                                        }
                                        ctrUtil.WriteJSONJadwal();
				}
			}
		}
    }

    public void LihatJadwal(){
        jadwal = ctrUtil.getJadwal();
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
            System.out.print("\t\t"+tanggal);
            System.out.print("\t" + waktuBerangkat);
            System.out.print("\t\t" + kotaBerangkat);
            System.out.print("\t\t" + kotaTujuan);
            System.out.print("\t\t" + waktuSampai);
            System.out.print("\t" + keretaapi);
            if(kursi > 0) System.out.print("\tSisa Kursi " + kursi);
            else 
                System.out.print("\tFull");
            System.out.println();
        }
    }

}
