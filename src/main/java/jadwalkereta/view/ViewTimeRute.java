package jadwalkereta.view;

import jadwalkereta.controller.*;

import java.util.Scanner;

public class ViewTimeRute {
    private int pilihan;
    ControllerTimeRute ctrTimeRute;
    Scanner input = new Scanner(System.in);

    public ViewTimeRute(ControllerTimeRute ctrTimeRute) {
        this.ctrTimeRute = ctrTimeRute;
    }

    public void menuTimeRute() {
        System.out.println("#KELOLA WAKTU BERDASARKAN RUTE#");
        System.out.println("1.  Tambah Waktu Pada Rute");
        System.out.println("2.  Lihat Waktu Pada Rute");
        System.out.println("3.  Delete Waktu Pada Rute");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = Integer.valueOf(input.nextLine());
        // input.nextLine();
    }

    public void menuTambah() {
        System.out.println("#TAMBAH DATA WAKTU PADA RUTE#");
        String KodeRute = "";
        int index = -1;
        do{
            System.out.print("Kode Rute: ");
            KodeRute = input.nextLine();
            index = ctrTimeRute.CheckRute(KodeRute);
        }while(index<0);

        int i = 1;
        String kdKereta;
        do {
            System.out.print("WaktuRute "+i+": ");
            kdKereta = input.nextLine();
            if(!kdKereta.equals("99")){
                if(!ctrTimeRute.TambahTimeRute(kdKereta,index)) i--;
            }
            i++;
        }while(!kdKereta.equals("99"));
        System.out.println("--------------------------------------------------------------");
        System.out.println("TimeRute Berhasil Ditambahkan");
        System.out.println("--------------------------------------------------------------");
    }

    // public void menuDelete() {
    //     System.out.println("#DELETE DATA JALUR#");
    //     System.out.print("Delete TimeRute : ");
    //     String kode = input.nextLine().split("_", 2)[1];
    //     // input.nextLine();
    //     int index = ctrTimeRute.CheckTimeRute(kode);
    //     if (index >= 0) {
    //         ctrTimeRute.DeleteTimeRute(index);
    //         System.out.println("--------------------------------------------------------------");
    //         System.out.println("TimeRute Berhasil Dihapus");
    //         System.out.println("--------------------------------------------------------------");
    //     } else {
    //         System.out.println("--------------------------------------------------------------");
    //         System.out.println("TimeRute Gagal Dihapus");
    //         System.out.println("--------------------------------------------------------------");
    //     }
    // }

    public void menuLihat() {
        System.out.println("#LIHAT WAKTU BERDASARKAN RUTE#");
        System.out.print("Kode Rute: ");
        String kode = input.nextLine();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("No\tKode Waktu Rute\t\tKode Rute\tWaktu Tersedia Rute");
        ctrTimeRute.LihatTimeRute(kode);
        System.out.println("--------------------------------------------------------------------------");

    }

    public void menuHapus() {
        System.out.println("#HAPUS WAKTU RUTE#");
        String KodeRute = "";
        int index = -1;
        do {
            System.out.print("Kode Rute: ");
            KodeRute = input.nextLine();
            index = ctrTimeRute.CheckRute(KodeRute);
        } while (index < 0 || KodeRute.equals("-1"));
        if(index<0) System.out.println("Rute Tidak Ditemukan");
        else{
            ctrTimeRute.HapusTimeRute(index);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Waktu Rute Berhasil Dihapus");
            System.out.println("--------------------------------------------------------------");
        }
    }

    // public void menuEdit() {
    //     System.out.println("#EDIT DATA TimeRute#");
    //     System.out.print("Edit TimeRute : ");
    //     String kode = input.nextLine().split("_", 2)[1];
    //     int index = ctrTimeRute.CheckTimeRute(kode);

    //     if (index >= 0) {
    //         ctrTimeRute.DeleteTimeRute(index);
    //         System.out.print("Kota Berangkat : ");
    //         String kotaBerangkat = input.nextLine();
    //         System.out.print("Kota Tujuan : ");
    //         String kotaTujuan = input.nextLine();
    //         System.out.print("Harga Tiket Bisnis : ");
    //         long hargaBisnis = input.nextLong();
    //         System.out.print("Harga Tiket Premium : ");
    //         long hargaPremium = input.nextLong();
    //         input.nextLine();
    //         ctrTimeRute.TambahTimeRute(kotaBerangkat, kotaTujuan, hargaBisnis, hargaPremium);
    //     } else {
    //         System.out.println("--------------------------------------------------------------");
    //         System.out.println("TimeRute Gagal Ditambahkan");
    //         System.out.println("--------------------------------------------------------------");
    //     }
    // }

    public int getPilihan() {
        return pilihan;
    }
}
