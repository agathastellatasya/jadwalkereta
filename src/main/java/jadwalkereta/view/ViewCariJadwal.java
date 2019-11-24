package jadwalkereta.view;

import jadwalkereta.controller.*;

import java.util.Scanner;

public class ViewCariJadwal {
    private int pilihan;
    ControllerCariJadwal ctrCariJadwal;
    Scanner input = new Scanner(System.in);

    public ViewCariJadwal(ControllerCariJadwal ctr) {
        this.ctrCariJadwal = ctr;
    }

    public void menuCariJadwal() {
        System.out.println("#CARI JADWAL KERETA API#");
        System.out.print("Keberangkatan: ");
        String keberangkatan = input.next();
        System.out.print("Tujuan: ");
        String tujuan = input.next();
        System.out.print("Tanggal: ");
        String tanggal = input.next();
        ctrCariJadwal.cariJadwal(keberangkatan, tujuan, tanggal);
    }
}