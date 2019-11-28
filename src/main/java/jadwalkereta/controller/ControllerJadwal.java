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
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import jadwalkereta.model.Jadwal;
import jadwalkereta.model.Jalur;
import jadwalkereta.model.Kereta;
import jadwalkereta.model.Rute;
import jadwalkereta.model.Tanggal;
import jadwalkereta.view.ViewJadwal;
import java.io.*;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.temporal.ChronoUnit;

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
        LocalDate localDate = LocalDate.now();
        LocalDate JadwalTime = LocalDate.now();
        LocalDate localDateTime;
        if(jadwal.size()>0) {
            int tgl_j = jadwal.get(jadwal.size() - 1).getTanggal().getHari();
            int bln_j = jadwal.get(jadwal.size() - 1).getTanggal().getBulan();
            int thn_j = jadwal.get(jadwal.size() - 1).getTanggal().getTahun();
            JadwalTime = LocalDate.of(thn_j,bln_j,tgl_j);
        }
        
        if(JadwalTime.isAfter(localDate)){
            localDateTime=JadwalTime;
        }
        else{
            localDateTime=localDate;
        }
        
        long selisihHari = ChronoUnit.DAYS.between(localDate,JadwalTime);
        
        if(selisihHari<0) selisihHari=0;
        long k=30-selisihHari;
        long m;
//        System.out.println(localDateTime);
//        System.out.println(JadwalTime);
//        System.out.println(localDate);
//        System.out.println(selisihHari);
        //System.out.println(JadwalTime);
        if(k>0){
        //ArrayList<Rute> ListRute = ctrUtil.getRute();
        for(m=0; m<k; m++){
            localDateTime = localDateTime.plusDays(1);
            bln = localDateTime.getMonthValue();
            tgl = localDateTime.getDayOfMonth();
            thn = localDateTime.getYear();
			for(int i=0;i<rute.size();i++)
			{
				if(rute.get(i).getTime().size()>0 && rute.get(i).getKereta().size()>0)
				{
					String kotaBerangkat = rute.get(i).getKotaBerangkat();
					String kotaTujuan = rute.get(i).getKotaTujuan();
                                        
					int j = 0;
//                                        if(rute.get(i).getTime().size() <= rute.get(i).getKereta().size()) {
                                            for(j=0;j<rute.get(i).getTime().size();j++)
                                            {
                                                tanggal = new Tanggal(tgl, bln, thn);
//                                                    System.out.println(rute.get(i).getTime().get(j).getJam());
    						int jamBerangkat = rute.get(i).getTime().get(j).getJam();
    						int menitBerangkat = rute.get(i).getTime().get(j).getMenit();
    						int[] sampai = rute.get(i).getTime().get(j).addTime(rute.get(i).getDuration()); 
//    						Kereta kereta = rute.get(i).getKereta().get(j);
//                                                final Tanggal tgal = tanggal;
//                                                Optional<Jadwal> keretaBelomSampai = jadwal.stream()
//                                                    .filter(x -> x.getKotaTujuan().equals(kotaBerangkat))
//                                                    .filter(x -> x.getKereta().getKodeKereta().equals(kereta.getKodeKereta()))
//                                                    .filter(x -> x.getTanggal().equals(tgal))
//                                                    .filter(x -> x.getJamSampai() <= sampai[0] || x.getMenitSampai() <= sampai[0])
//                                                    .reduce((__, curr) -> curr);
//                                                if (keretaBelomSampai.isPresent()){
//                                                    tanggal = new Tanggal(tanggal.getHari() + 1, tanggal.getBulan(), tanggal.getTahun());
//                                                }

                                                Kereta kereta = getKeretaAvailable(rute.get(i), tanggal, jamBerangkat, menitBerangkat, sampai[0], sampai[1]);
                                                
                                                int maxDays = localDateTime.getMonth().length(localDateTime.getYear() % 4 == 0);
                                                if (tanggal.getHari() > maxDays){
                                                    tanggal = new Tanggal(1, tanggal.getBulan() + 1, tanggal.getTahun());
                                                    localDateTime = localDateTime.plusMonths(1);
                                                    localDateTime = localDateTime.withDayOfMonth(1);
                                                }
                                                
    						long hargaB = rute.get(i).getHargaBisnis();
    						long hargaP = rute.get(i).getHargaPremium();
                                                
                                                int lastCode = jadwal.size();
                                                if (lastCode > 0){
                                                    lastCode = Integer.valueOf(jadwal.get(jadwal.size() - 1).getKode().substring("JW".length()));
                                                }
                                                if(kereta != null){
                                                    Jadwal jadwalKereta = new Jadwal(GetCodeJW(lastCode + 1), tanggal, jamBerangkat, menitBerangkat, sampai[0], sampai[1], kotaBerangkat, kotaTujuan, kereta, hargaB, hargaP);
                                                    jadwal.add(jadwalKereta);
                                                }
    						count++;
                                            }
//                                        }
//                                        else {
//                                            for(j=0;j<rute.get(i).getKereta().size();j++)
//                                            {
////                                                    System.out.println(rute.get(i).getTime().get(j).getJam());
//    						int jamBerangkat = rute.get(i).getTime().get(j).getJam();
//    						int menitBerangkat = rute.get(i).getTime().get(j).getMenit();
//    						int[] sampai = rute.get(i).getTime().get(j).addTime(rute.get(i).getDuration());
//    						Kereta kereta = rute.get(i).getKereta().get(j);
//                                                 final Tanggal tgal = tanggal;
//                                                Optional<Jadwal> keretaBelomSampai = jadwal.stream()
//                                                        .filter(x -> x.getKotaTujuan().equals(kotaBerangkat))
//                                                        .filter(x -> x.getKereta().getKodeKereta().equals(kereta.getKodeKereta()))
//                                                        .filter(x -> x.getTanggal().equals(tgal))
//                                                        .filter(x -> x.getJamSampai() <= sampai[0] || x.getMenitSampai() <= sampai[0])
//                                                        .reduce((__, curr) -> curr);
//                                                if (keretaBelomSampai.isPresent()){
//                                                    tanggal = new Tanggal(tanggal.getHari() + 1, tanggal.getBulan(), tanggal.getTahun());
//                                                }
//    						long hargaB = rute.get(i).getHargaBisnis();
//    						long hargaP = rute.get(i).getHargaPremium();
//                                                int lastCode = jadwal.size();
//                                                if (lastCode > 0){
//                                                    lastCode = Integer.valueOf(jadwal.get(jadwal.size() - 1).getKode().substring("JW".length()));
//                                                }
//    						jadwal.add(new Jadwal(GetCodeJW(lastCode + 1), tanggal, jamBerangkat, menitBerangkat, sampai[0], sampai[1], kotaBerangkat, kotaTujuan, kereta, hargaB, hargaP));
//    						count++;
//                                            }
//                                        }
                                        ctrUtil.WriteJSONJadwal();
				}
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
    
    private String GetCodeJW(int count){
        String code = "JW";
        for(int i=0; i < 5 - String.valueOf(count).length(); i++){
            code=code+"0";
            
        }
        code = code + count;
        return code;
    }
    
    private Kereta getKeretaAvailable(Rute rute, Tanggal tanggal, int jamBerangkat, int menitBerangkat, int jamSampai, int menitSampai){
        Kereta kereta = null;
        for(int l=0;l<rute.getKereta().size();l++){
            kereta = rute.getKereta().get(l);
            final Tanggal tgal = tanggal;
            final Kereta krt = kereta;
            boolean jadwalOpt = jadwal.stream()
                .filter(x -> x.getTanggal().equals(tgal))
                .filter(x -> x.getKereta().equals(krt))
//                .filter(x -> x.getKotaTujuan().equals(rute.getKotaBerangkat()) || x.getKotaBerangkat().equals(rute.getKotaBerangkat()))
                .anyMatch(x -> {
                    if (x.getKotaTujuan().equals(rute.getKotaTujuan()) && x.getKotaBerangkat().equals(rute.getKotaBerangkat())){
                        int jamDuration = x.getJamSampai() - x.getJamBerangkat();
                        int menitDuration = x.getMenitSampai() - x.getMenitBerangkat();

                        int jamKeretaBalik = x.getJamSampai()+ jamDuration;
                        int menitKeretaBalik = x.getMenitSampai()+ menitDuration;
                        
                        return jamKeretaBalik > jamBerangkat || (jamKeretaBalik == jamBerangkat && menitKeretaBalik > menitBerangkat);
//                        int jamDuration = rute.getDuration() / 60;
//                        int menitDuration = rute.getDuration() % 60;
//
//                        int jamKeretaBalik = x.getJamSampai()+ jamDuration;
//                        int menitKeretaBalik = x.getMenitSampai()+ menitDuration;
//
//                        return jamKeretaBalik > jamBerangkat || (jamKeretaBalik == jamBerangkat && menitKeretaBalik > menitBerangkat);
//                        return x.getJamSampai() >= jamBerangkat || x.getMenitSampai() >= menitBerangkat;
                    } else if (x.getKotaTujuan().equals(rute.getKotaBerangkat())){
                        return x.getJamSampai() > jamBerangkat || (x.getJamSampai() == jamBerangkat && x.getMenitSampai() > menitBerangkat);
                    }
                    return true;
//                    return x.getJamSampai() > jamBerangkat || (x.getJamSampai() == jamBerangkat && x.getMenitSampai() > menitBerangkat);
//                    int jamDuration = rute.getDuration() / 60;
//                    int menitDuration = rute.getDuration() % 60;
//                    
//                    int jamKeretaBalik = x.getJamSampai()+ jamDuration;
//                    int menitKeretaBalik = x.getMenitSampai()+ menitDuration;
//                    
//                    return jamKeretaBalik > jamBerangkat || (jamKeretaBalik == jamBerangkat && menitKeretaBalik > menitBerangkat);
//                    return x.getJamSampai() >= jamBerangkat || x.getMenitSampai() >= menitBerangkat;
                });
//                .filter(x -> x.getJamSampai() <= jamSampai || x.getMenitSampai() <= menitSampai)
//                .reduce((__, curr) -> curr);
            if(!jadwalOpt){
                return kereta;
//                kereta = krt;
            }
            
//            String kotaBerangkat = rute.getKotaBerangkat();
//            Optional<Jadwal> keretaBelomSampai = jadwal.stream()
//                .filter(x -> x.getTanggal().equals(tgal))
//                .filter(x -> x.getKotaTujuan().equals(kotaBerangkat))
//                .filter(x -> x.getKereta().getKodeKereta().equals(krt.getKodeKereta()))
//                .filter(x -> x.getJamSampai() <= jamSampai || x.getMenitSampai() <= menitSampai)
//                .reduce((__, curr) -> curr);
//            if (keretaBelomSampai.isPresent()){
//                tanggal = new Tanggal(tanggal.getHari() + 1, tanggal.getBulan(), tanggal.getTahun());
//            }
//            int duration = rute.getDuration();
//            int jamDuration = duration / 60;
//            int menitDuration = duration % 60;
//            Jadwal jadwalKereta = jadwalOpt.get();
//            int jamKosongKereta = jadwalKereta.getJamBerangkat() + jamDuration;
//            int menitKosongKereta = jadwalKereta.getMenitBerangkat() + menitDuration;
//            if(jamKosongKereta <= jamBerangkat || (jamKosongKereta == jamBerangkat && menitKosongKereta <= menitBerangkat)){
////                    kereta = krt;
//                return kereta;
//            }
        }
        int hari = tanggal.getHari() + 1;
        tanggal.setHari(hari);
        return rute.getKereta().get(0);
    }
}
