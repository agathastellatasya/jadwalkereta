package jadwalkereta.view;

import jadwalkereta.controller.*;

import java.util.Scanner;
import java.io.*;

public class ViewRute {
    private int pilihan;
    ControllerRute ctrRute;
    ControllerUtil ctrUtil = new ControllerUtil();
    Scanner input = new Scanner(System.in);

    public ViewRute(ControllerRute ctrRute) {
        this.ctrRute = ctrRute;
    }

    public void menuRute() {
        System.out.println("#KELOLA DATA RUTE");
        System.out.println("1.  Tambah Data Rute");
        System.out.println("2.  Lihat Data Rute");
        System.out.println("3.  Edit Data Rute");
        System.out.println("4.  Delete Data Rute");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = Integer.valueOf(input.nextLine());
		//input.nextLine();
    }

    public void menuTambah(){
        ctrUtil.ReadJSONRute();
        System.out.println("#TAMBAH DATA RUTE#");
        System.out.print("Tambah Rute : ");
        String kotaBerangkat = input.next();
		String kotaTujuan = input.next();
        long hargaBisnis = input.nextLong();
		long hargaPremium = input.nextLong();
		input.nextLine();
        ctrRute.TambahRute(kotaBerangkat, kotaTujuan, hargaBisnis, hargaPremium);
        ctrUtil.WriteJSONRute();
        System.out.println(ctrUtil.getRute().size());
        System.out.println(ctrRute.rute.size());
		
    }

	
	public void menuDelete(){
        ctrUtil.ReadJSONRute();
        System.out.println("#DELETE DATA RUTE#");
        System.out.print("Delete Rute : ");
        String kode2 []= input.nextLine().split("_", 2);
        String kode;
        if(kode2.length==2){
            kode=kode2[1];	
            int index = ctrRute.CheckRute(kode);
            if (index >= 0) {
                ctrRute.DeleteRute(index);
                System.out.println("--------------------------------------------------------------");
                System.out.println("Rute Berhasil Dihapus");
                System.out.println("--------------------------------------------------------------");
            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Rute Gagal Dihapus");
                System.out.println("--------------------------------------------------------------");
            }
        }else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Format Salah, Format : DELETE_KODERUTE");
            System.out.println("--------------------------------------------------------------");
        }
    }
	
	public void menuLihat()
    {
        ctrUtil.ReadJSONRute();
        System.out.println("#LIHAT DATA KOTA#");
        System.out.println("Data Lengkap Rute");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("No\tKeberangkatan\t\tTujuan\t\tKode Rute\tBisnis\tPremium");
        ctrRute.LihatRute();
        System.out.println("-------------------------------------------------------------------------------------");
    }
	

    public void menuEdit()
    {
        System.out.println("#EDIT DATA RUTE#");
        System.out.print("Edit Rute : ");
        String kode2 []= input.nextLine().split("_", 2);
        String kode;
        if(kode2.length==2){
            kode=kode2[1];	
            int index = ctrRute.CheckRute(kode);
            if (index >= 0) {
                ctrRute.DeleteRute(index);
                System.out.print("Kota Berangkat : ");
                String kotaBerangkat = input.nextLine();
                System.out.print("Kota Tujuan : ");
                String kotaTujuan = input.nextLine();
                System.out.print("Harga Tiket Bisnis : ");
                long hargaBisnis = input.nextLong();
                System.out.print("Harga Tiket Premium : ");
                long hargaPremium = input.nextLong();
                input.nextLine();
                ctrRute.TambahRute(kotaBerangkat, kotaTujuan, hargaBisnis, hargaPremium);
            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Rute Gagal Ditambahkan");
                System.out.println("--------------------------------------------------------------");
            }
        }else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Format Salah, Format : EDIT_KODERUTE");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public int getPilihan() {
        return pilihan;
    }
}