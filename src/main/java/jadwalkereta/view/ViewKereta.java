package jadwalkereta.view;

import jadwalkereta.controller.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class ViewKereta {
    private int pilihan;
    ControllerKereta ctrKereta;
    Scanner input = new Scanner(System.in);

    public ViewKereta(ControllerKereta ctrKereta) {
        this.ctrKereta = ctrKereta;
    }

    public void menuKereta() {
        System.out.println("#KELOLA DATA KERETA API");
        System.out.println("1.  Tambah Data Kereta");
        System.out.println("2.  Lihat Data Kereta");
        System.out.println("3.  Edit Data Kereta");
        System.out.println("4.  Delete Data Kereta");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = Integer.valueOf(input.nextLine());
		//input.nextLine();
    }

    public void menuTambah() {
	String[] strarray = new String[5];
        System.out.println("#TAMBAH DATA KERETA API#");
        System.out.print("Tambah Kereta : ");
        String tambah;
	do {
            tambah = input.nextLine();
            String regex = "\'([^\"]*)\'|(\\S+)";
            Matcher m = Pattern.compile(regex).matcher(tambah);
            int i=0;
            while (m.find()) {
                    if (m.group(1) != null) {
                            strarray[i] = m.group(1);
                    } else {
                            strarray[i] = m.group(2);
                    }
                    i++;
            }
            if(i==5){
                String kodeKereta = strarray[0];
                String namaKereta = strarray[1];
                String jmlA = strarray[2];
                String jmlB = strarray[3];
                String jmlC = strarray[4];
                ctrKereta.TambahKereta(kodeKereta, namaKereta, jmlA, jmlB, jmlC);
                tambah="99";
            }
            else if(i<5 && !tambah.equals("99")) {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Format Salah");
                System.out.println("--------------------------------------------------------------");
                tambah="99";
            }
            else{
                tambah="99";
                System.out.println("");
            }
        } while(!tambah.equals("99"));
    }

	
	public void menuDelete() {
        System.out.println("#DELETE DATA KERETA API#");
        System.out.print("Delete Kereta : ");
        String kode2 []= input.nextLine().split("_", 2);
        String kode;
        if(kode2.length==2){
            kode=kode2[1];
            int index = ctrKereta.CheckKereta(kode);
            if (index >= 0) {
                int KAterhubung = ctrKereta.CheckKARute(kode);
               if(KAterhubung < 0)
               {
                    ctrKereta.DeleteKereta(index);
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Kereta Berhasil Dihapus");
                    System.out.println("--------------------------------------------------------------");
               }else{
                   System.out.println("----------------------------------------------------------------------");
                   System.out.println("Tidak Bisa di Delete, Karena KA Terhubung dengan KA Berdasarkan Rute");
                   System.out.println("----------------------------------------------------------------------");
               }  
            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Kode Kereta Tidak Ditemukan, Kereta Gagal Dihapus");
                System.out.println("--------------------------------------------------------------");
            }
        }else{
            System.out.println("--------------------------------------------------------------");
            System.out.println("Format Salah, Format : DELETE_KODE KERETA");
            System.out.println("--------------------------------------------------------------");
        }
    }
	
	public void menuLihat()
    {
        System.out.println("#LIHAT DATA KERETA API#");
        System.out.println("Data Lengkap Kereta Api");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("No\tKode Kereta\tNama Kereta\tJumlah Gerbong\tJumlah Gerbong Bisnis\tJumlah Gerbong Premium");
		ctrKereta.LihatKereta();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
	

    public void menuEdit() {
        System.out.println("#EDIT DATA KERETA API#");
        System.out.print("Edit Kereta : ");
        String kode2 []= input.nextLine().split("_", 2);
        String kode;
        if(kode2.length==2){
            kode=kode2[1];
            int index = ctrKereta.CheckKereta(kode);

            if (index >= 0) {
                ctrKereta.DeleteKereta(index);
                System.out.print("Kode Kereta : ");
                String kodeKereta = input.nextLine();
                System.out.print("Nama Kereta : ");
                String namaKereta = input.nextLine();
                System.out.print("Jumlah Gerbong : ");
                int jmlGerbong = input.nextInt();
                System.out.print("Jumlah Gerbong Bisnis: ");
                int jmlBisnis = input.nextInt();
                System.out.print("Jumlah Gerbong Premium: ");
                int jmlPremium = input.nextInt();
                input.nextLine();
                String jmlA="G"+jmlGerbong;
                String jmlB="B"+jmlBisnis;
                String jmlC="P"+jmlPremium;
                ctrKereta.TambahKereta(kodeKereta, namaKereta, jmlA, jmlB, jmlC);
            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Kereta Gagal Ditambahkan");
                System.out.println("--------------------------------------------------------------");
            }
        }else{
            System.out.println("--------------------------------------------------------------");
            System.out.println("Format Salah, Format : EDIT_KODE KERETA");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public int getPilihan() {
        return pilihan;
    }
}