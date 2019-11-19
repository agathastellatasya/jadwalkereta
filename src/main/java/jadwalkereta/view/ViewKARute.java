package jadwalkereta.view;

import jadwalkereta.controller.*;
import jadwalkereta.model.KARute;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewKARute {
    private int pilihan;
    ArrayList<KARute> karute;
    ControllerKARute ctrKARute;
    Scanner input = new Scanner(System.in);

    public ViewKARute(ControllerKARute ctrKARute) {
        this.ctrKARute = ctrKARute;
    }

    public void menuKARute() {
        System.out.println("#KELOLA KERETA API BERDASARKAN RUTE#");
        System.out.println("1.  Tambah Kereta Pada Rute");
        System.out.println("2.  Lihat Kereta Pada Rute");
        System.out.println("3.  Delete Kereta Pada Rute");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = Integer.valueOf(input.nextLine());
    }

    public void menuTambah() {
        int kode = ctrKARute.getKode();
        System.out.println("#TAMBAH KERETA PADA RUTE#");
        System.out.print("Kode Rute : ");
        String kodeRute = input.nextLine();
        System.out.println("Tambah Kereta Api Untuk Rute");
        int indexkode = ctrKARute.CheckRute(kodeRute);
        String kodeKA;
        if(indexkode>=0)
        {
            int isRuteSama = ctrKARute.checkRuteSama(kodeRute);
            if(isRuteSama<0)
            {
                int i = 1;
                do
                {
                    System.out.print("Kereta "+ i +": ");
                    kodeKA = input.nextLine();
                    //pengecekan ada tidaknya di data kereta
                    int index = ctrKARute.CheckKA(kodeKA);
                    if(index>=0) {
                        int isKASama = ctrKARute.checkKAsama(kodeRute, kodeKA);
                        if(isKASama<0)
                        {
                            ctrKARute.TambahKARute(kode, kodeRute, kodeKA);
                            i++;
                        }
                        else
                        {
                            System.out.println("KA sudah diinputkan, Inputkan Kode KA yang Lain !!");
                        }
                        
                    }
                    
                } while (!kodeKA.equals("99"));
               System.out.println("Selesai Menambahkan");
            }else{
                System.out.println("--------------------------------------------------------------");
                System.out.println("Rute Sudah Ada");
                System.out.println("--------------------------------------------------------------");
            }
           
            
        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Rute Tidak Ditemukan");
            System.out.println("--------------------------------------------------------------");
        }
        
    }

    public void menuDelete() {
        System.out.println("#DELETE KERETA PADA RUTE#");
        System.out.print("Delete kereta pada rute : ");
        String kode [] = input.nextLine().split("_", 2);
        String kodeRute;
        if(kode.length==2){
            kodeRute=kode[1];
            int index = ctrKARute.checkRuteSama(kodeRute);
            if (index >= 0) {
                ctrKARute.DeleteKA(kodeRute);
                System.out.println("--------------------------------------------------------------");
                System.out.println("KA pada Rute Berhasil Dihapus");
                System.out.println("--------------------------------------------------------------");
            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("KA pada Rute Tidak Ada / Gagal Dihapus");
                System.out.println("--------------------------------------------------------------");
            }
        }else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Format Salah, Format : DELETE_KODERUTE");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public void menuLihat() {
        System.out.println("#LIHAT KERETA BERDASAR RUTE#");
        System.out.println("Kode Rute : ");
        String kodeRute = input.nextLine();
        int index = ctrKARute.CheckRute(kodeRute);
        if(index >= 0)
        {
            System.out.println("Kereta Api berdasarkan Rute");
            System.out.println("--------------------------------------------------------------");
            System.out.println("No\tKode Kereta Rute\tKode Rute\tKereta Tersedia pada Rute");
		    ctrKARute.LihatKARute(kodeRute);
            System.out.println("--------------------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Kode Rute Tidak Ditemukan");
            System.out.println("--------------------------------------------------------------");
        }

    }

    public int getPilihan() {
        return pilihan;
    }
}