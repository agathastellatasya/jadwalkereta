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
		//input.nextLine();
    }

    public void menuTambah() {
        System.out.println("#TAMBAH WAKTU PADA RUTE#");
		System.out.print("Kode Rute : ");
		String kode=input.nextLine();
		int indexKodeRute = ctrTimeRute.CheckRute(kode);
        int indexKodeTime;
		//System.out.println(indexKodeRute + " " + kode);
        String kodeTime;
		if(indexKodeRute>=0){
			int i=1;
			do {
				System.out.print("Time" + i + ": ");
				kodeTime=input.nextLine();
				indexKodeTime = ctrTimeRute.CheckTimeRute(kodeTime);
				if(indexKodeTime > 0) {
					ctrTimeRute.TambahTimeRute(kode,kodeTime);
					i++;
				}
				//System.out.println(indexKodeTime );
			}
			while (!kodeTime.equals("99"));
		}
		else {
			System.out.println("--------------------------------------------------------------");
            System.out.println("Rute Tidak Ditemukan");
            System.out.println("--------------------------------------------------------------");
		}
    }

	
	public void menuDelete() {
        System.out.println("#DELETE WAKTU PADA RUTE#");
        System.out.print("Delete Waktu Pada Kode Rute : ");
        String kode = input.nextLine().split("_", 2)[1];
		//input.nextLine();
        int index = ctrTimeRute.CheckRute(kode);
        if (index >= 0) {
            ctrTimeRute.DeleteTimeRute(kode);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Waktu Pada Rute Berhasil Dihapus");
            System.out.println("--------------------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Waktu Pada Rute Gagal Dihapus");
            System.out.println("--------------------------------------------------------------");
        }
    }
	
	public void menuLihat()
    {
        System.out.println("#LIHAT WAKTU BERDASARKAN RUTE#");
        System.out.println("Kode Rute :");
		String kode=input.nextLine();
		int index = ctrTimeRute.CheckRute(kode);
		if(index >= 0){
			System.out.println("--------------------------------------------------------------");
			System.out.println("No\tKode Waktu Rute\tKode Rute\tWaktu Tersedia Rute");
			ctrTimeRute.LihatRute();
			System.out.println("--------------------------------------------------------------");		
		}
		else {
			System.out.println("--------------------------------------------------------------");
            System.out.println("Kode Rute Tidak Ditemukan");
            System.out.println("--------------------------------------------------------------");
		}
        
    }

    public int getPilihan() {
        return pilihan;
    }
}