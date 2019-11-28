package jadwalkereta.view;

import jadwalkereta.controller.*;

import java.util.Scanner;

public class ViewKARute {
    private int pilihan;
    ControllerKARute ctrKARute;
    Scanner input = new Scanner(System.in);

    public ViewKARute(ControllerKARute ctrKARute) {
        this.ctrKARute = ctrKARute;
    }

    public void menuKARute() {
        System.out.println("#KELOLA KERETA BERDASARKAN RUTE#");
        System.out.println("1.  Tambah Kereta Pada Rute");
        System.out.println("2.  Lihat Kereta Pada Rute");
        System.out.println("3.  Delete Kereta Pada Rute");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = Integer.valueOf(input.nextLine());
        // input.nextLine();
    }

    public void menuTambah() {
        System.out.println("#TAMBAH KERETA BERDASARKAN RUTE#");
        String KodeRute = "";
        int index = -1;
        do{
            System.out.print("Kode Rute: ");
            KodeRute = input.nextLine();
            index = ctrKARute.CheckRute(KodeRute);
        }while(index<0);

        int i = 1;
        String kdKereta;
        do {
            System.out.print("Kereta "+i+": ");
            kdKereta = input.nextLine();
            if(!kdKereta.equals("99")){
                if(!ctrKARute.TambahKARute(kdKereta,index)) i--;
            }
            i++;
        }while(!kdKereta.equals("99"));
    }

    // public void menuDelete() {
    //     System.out.println("#DELETE DATA JALUR#");
    //     System.out.print("Delete KARute : ");
    //     String kode = input.nextLine().split("_", 2)[1];
    //     // input.nextLine();
    //     int index = ctrKARute.CheckKARute(kode);
    //     if (index >= 0) {
    //         ctrKARute.DeleteKARute(index);
    //         System.out.println("--------------------------------------------------------------");
    //         System.out.println("KARute Berhasil Dihapus");
    //         System.out.println("--------------------------------------------------------------");
    //     } else {
    //         System.out.println("--------------------------------------------------------------");
    //         System.out.println("KARute Gagal Dihapus");
    //         System.out.println("--------------------------------------------------------------");
    //     }
    // }

    public void menuLihat() {
        System.out.println("#LIHAT KERETA BERDASARKAN RUTE#");
        System.out.print("Kode Rute: ");
        String kode = input.nextLine();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("No\tKode Kereta Rute\tKode Rute\tKereta Tersedia Pada Rute");
        ctrKARute.LihatKARute(kode);
        System.out.println("--------------------------------------------------------------------------");

    }

    public void menuHapus() {
        System.out.println("#HAPUS KERETA BERDASARKAN RUTE#");
        String KodeRute = "";
        int index = -1;
        do {
            System.out.print("Kode Rute: ");
            KodeRute = input.nextLine();
            index = ctrKARute.CheckRute(KodeRute);
        } while (index < 0 || KodeRute.equals("-1"));
        if(index<0) System.out.println("Rute Tidak Ditemukan");
        else{
            ctrKARute.HapusKARute(index);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Kereta Berhasil Dihapus");
            System.out.println("--------------------------------------------------------------");
        }
    }

    // public void menuEdit() {
    //     System.out.println("#EDIT DATA KARute#");
    //     System.out.print("Edit KARute : ");
    //     String kode = input.nextLine().split("_", 2)[1];
    //     int index = ctrKARute.CheckKARute(kode);

    //     if (index >= 0) {
    //         ctrKARute.DeleteKARute(index);
    //         System.out.print("Kota Berangkat : ");
    //         String kotaBerangkat = input.nextLine();
    //         System.out.print("Kota Tujuan : ");
    //         String kotaTujuan = input.nextLine();
    //         System.out.print("Harga Tiket Bisnis : ");
    //         long hargaBisnis = input.nextLong();
    //         System.out.print("Harga Tiket Premium : ");
    //         long hargaPremium = input.nextLong();
    //         input.nextLine();
    //         ctrKARute.TambahKARute(kotaBerangkat, kotaTujuan, hargaBisnis, hargaPremium);
    //     } else {
    //         System.out.println("--------------------------------------------------------------");
    //         System.out.println("KARute Gagal Ditambahkan");
    //         System.out.println("--------------------------------------------------------------");
    //     }
    // }

    public int getPilihan() {
        return pilihan;
    }
}
