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
        String tambah = input.nextLine();
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
		String kodeKereta = strarray[0];
		String namaKereta = strarray[1];
        String jmlA = strarray[2];
		String jmlB = strarray[3];
		String jmlC = strarray[4];
		//input.nextLine();
        ctrKereta.TambahKereta(kodeKereta, namaKereta, jmlA, jmlB, jmlC);
    }

	
	public void menuDelete() {
        System.out.println("#DELETE DATA KERETA API#");
        System.out.print("Delete Kereta : ");
        String kode = input.nextLine().split("_", 2)[1];
		//input.nextLine();
        int index = ctrKereta.CheckKereta(kode);
        if (index >= 0) {
            ctrKereta.DeleteKereta(index);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Kereta Berhasil Dihapus");
            System.out.println("--------------------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Kode Kereta Tidak Ditemukan, Kereta Gagal Dihapus");
            System.out.println("--------------------------------------------------------------");
        }
    }
	
	public void menuLihat()
    {
        System.out.println("#LIHAT DATA KERETA API#");
        System.out.println("Data Lengkap Kereta Api");
        System.out.println("--------------------------------------------------------------");
        System.out.println("No\tKode Kereta\t\tNama Kereta\t\tJumlah Gerbong\t\tJumlah Gerbong Bisnis\t\tJumlah Gerbong Premium");
		ctrKereta.LihatKereta();
        System.out.println("--------------------------------------------------------------");
    }
	

    public void menuEdit() {
        System.out.println("#EDIT DATA KERETA API#");
        System.out.print("Edit Kereta : ");
        String kode = input.nextLine().split("_", 2)[1];
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
    }

    public int getPilihan() {
        return pilihan;
    }
}