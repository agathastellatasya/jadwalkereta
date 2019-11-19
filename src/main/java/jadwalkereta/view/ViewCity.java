package jadwalkereta.view;

import jadwalkereta.controller.*;

import java.util.Scanner;

public class ViewCity {
    private int pilihan;
    ControllerCity ctrCity;
    Scanner input = new Scanner(System.in);

    public ViewCity(ControllerCity ctrCity) {
        this.ctrCity = ctrCity;
    }

    public void menuCity() {
        System.out.println("#KELOLA DATA KOTA#");
        System.out.println("1.  Tambah Data Kota");
        System.out.println("2.  Lihat Data Kota");
        System.out.println("3.  Edit Data Kota");
        System.out.println("4.  Delete Data Kota");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = Integer.valueOf(input.nextLine());
    }

    public void menuTambah() {
        System.out.println("#TAMBAH DATA KOTA#");
        System.out.print("Tambah Kota : ");
        String request = input.nextLine();
        String kode = request.substring(0,request.indexOf(' '));
        String nama = request.substring(request.indexOf(' ')+1);
        ctrCity.TambahCity(kode, nama);
    }

    public void menuDelete() {
        System.out.println("#DELETE DATA KOTA#");
        System.out.print("Delete Kota : ");
        String kode2 []= input.nextLine().split("_", 2);
        String kode;
        if(kode2.length==2){
            kode=kode2[1];	
            int index = ctrCity.CheckCity(kode);
            if (index >= 0) {
                ctrCity.DeleteCity(index);
                System.out.println("--------------------------------------------------------------");
                System.out.println("Kota Berhasil Dihapus");
                System.out.println("--------------------------------------------------------------");
            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Kota Gagal Dihapus");
                System.out.println("--------------------------------------------------------------");
            }
        }else{
            System.out.println("--------------------------------------------------------------");
            System.out.println("Format Salah, Format : DELETE_KODE KOTA");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void menuLihat() {
        System.out.println("#LIHAT DATA KOTA#");
        System.out.println("Data Lengkap Kota");
        System.out.println("--------------------------------------------------------------");
        System.out.println("No\tKode\t\tNama");
        ctrCity.LihatCity();
        System.out.println("--------------------------------------------------------------");
    }

    public void menuEdit() {
        System.out.println("#EDIT DATA KOTA#");
        System.out.print("Edit Kota : ");
        String kode2 []= input.nextLine().split("_", 2);
        String kode;
        if(kode2.length==2){
            kode=kode2[1];	
            int index = ctrCity.CheckCity(kode);

            if (index >= 0) {
                ctrCity.DeleteCity(index);
                System.out.print("Kode Kota : ");
                kode = input.nextLine();
                System.out.print("Nama Kota : ");
                String nama = input.nextLine();
                ctrCity.TambahCity(kode, nama);

            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Kota Gagal Ditambahkan");
                System.out.println("--------------------------------------------------------------");
            }
        }else{
            System.out.println("--------------------------------------------------------------");
            System.out.println("Format Salah, Format : EDIT_KODE KOTA");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public int getPilihan() {
        return pilihan;
    }
}