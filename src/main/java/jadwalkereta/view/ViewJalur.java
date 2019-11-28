package jadwalkereta.view;

import jadwalkereta.controller.*;

import java.util.Scanner;

public class ViewJalur {
    private int pilihan;
    ControllerJalur ctrJalur;
    Scanner input = new Scanner(System.in);

    public ViewJalur(ControllerJalur ctrJalur) {
        this.ctrJalur = ctrJalur;
    }

    public void menuJalur() {
        System.out.println("#KELOLA STASIUN BERDASARKAN RUTE#");
        System.out.println("1.  Tambah Jalur Stasiun Pada Rute");
        System.out.println("2.  Lihat Jalur Stasiun Pada Rute");
        System.out.println("3.  Delete Jalur Stasiun Pada Rute");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = Integer.valueOf(input.nextLine());
        // input.nextLine();
    }

    public void menuTambah(ControllerUtil ctrUtil) {
        ctrJalur.setRute(ctrUtil.getRute());
        System.out.println("#TAMBAH DATA JALUR#");
        String KodeRute = "";
        int index = -1;
        do{
            System.out.print("Kode Rute: ");
            KodeRute = input.nextLine();
            index = ctrJalur.CheckRute(KodeRute);
            if(index<0) System.out.println("Rute Tidak Ditemukan");
        }while(index<0);

        int i = 1;
        String injalur;
        do {
            System.out.print("Jalur "+i+": ");
            injalur = input.nextLine();
            if(!injalur.equals("99"))
            {
                String stasiunAwal = injalur.split("\\s+")[0];
                String stasiunAkhir = injalur.split("\\s+")[1];
                int menit = Integer.valueOf(injalur.split("\\s+")[2]);
                if(!ctrJalur.TambahJalur(stasiunAwal, stasiunAkhir, menit, index)) i--;
		System.out.println("Jalur Berhasil Ditambahkan");
            }
            i++;
        }while(!injalur.equals("99"));
        ctrUtil.WriteJSONRute();
    }

    // public void menuDelete() {
    //     System.out.println("#DELETE DATA JALUR#");
    //     System.out.print("Delete Jalur : ");
    //     String kode = input.nextLine().split("_", 2)[1];
    //     // input.nextLine();
    //     int index = ctrJalur.CheckJalur(kode);
    //     if (index >= 0) {
    //         ctrJalur.DeleteJalur(index);
    //         System.out.println("--------------------------------------------------------------");
    //         System.out.println("Jalur Berhasil Dihapus");
    //         System.out.println("--------------------------------------------------------------");
    //     } else {
    //         System.out.println("--------------------------------------------------------------");
    //         System.out.println("Jalur Gagal Dihapus");
    //         System.out.println("--------------------------------------------------------------");
    //     }
    // }

    public void menuLihat() {
        System.out.println("#LIHAT STASIUN BERDASARKAN RUTE#");
        System.out.print("Kode Rute: ");
        String kode = input.nextLine();
        System.out.println("No\tKode Jalur\tKode Rute\tJalur Yang Dilewati\tMenit");
        System.out.println("--------------------------------------------------------------------------");
        ctrJalur.LihatJalur(kode);
        System.out.println("--------------------------------------------------------------------------");

    }

    public void menuHapus() {
        System.out.println("#HAPUS RUTE STASIUN#");
        String KodeRute = "";
        int index = -1;
        do {
            System.out.print("Kode Rute: ");
            KodeRute = input.nextLine();
            index = ctrJalur.CheckRute(KodeRute);
            if(index<0) System.out.println("Rute Tidak Ditemukan");
        } while (index < 0 || KodeRute.equals("-1"));
        //if(index<0) System.out.println("Rute Tidak Ditemukan");
        
            ctrJalur.HapusJalur(index);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Jalur Berhasil Dihapus");
            System.out.println("--------------------------------------------------------------");
        
    }

    // public void menuEdit() {
    //     System.out.println("#EDIT DATA Jalur#");
    //     System.out.print("Edit Jalur : ");
    //     String kode = input.nextLine().split("_", 2)[1];
    //     int index = ctrJalur.CheckJalur(kode);

    //     if (index >= 0) {
    //         ctrJalur.DeleteJalur(index);
    //         System.out.print("Kota Berangkat : ");
    //         String kotaBerangkat = input.nextLine();
    //         System.out.print("Kota Tujuan : ");
    //         String kotaTujuan = input.nextLine();
    //         System.out.print("Harga Tiket Bisnis : ");
    //         long hargaBisnis = input.nextLong();
    //         System.out.print("Harga Tiket Premium : ");
    //         long hargaPremium = input.nextLong();
    //         input.nextLine();
    //         ctrJalur.TambahJalur(kotaBerangkat, kotaTujuan, hargaBisnis, hargaPremium);
    //     } else {
    //         System.out.println("--------------------------------------------------------------");
    //         System.out.println("Jalur Gagal Ditambahkan");
    //         System.out.println("--------------------------------------------------------------");
    //     }
    // }

    public int getPilihan() {
        return pilihan;
    }
}
