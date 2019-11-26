package jadwalkereta.view;

import jadwalkereta.controller.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;


/**
 *
 * @author ASUS
 */

public class ViewLaporan {
    private int pilihan;
    ControllerLaporan ctrLaporan;
    Scanner input = new Scanner(System.in);

    public ViewLaporan(ControllerLaporan ctrLaporan) {
        this.ctrLaporan = ctrLaporan;
    }

    public void menuLaporan() {
        System.out.println("#MENU LAPORAN PEMASUKAN");
        System.out.println("1.  Laporan Harian");
        System.out.println("2.  Laporan Bulanan");
        System.out.println("3.  Laporan Tahunan");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = Integer.valueOf(input.nextLine());
		//input.nextLine();
    }
    
    public void menuHarian() {
        System.out.println("#LAPORAN HARIAN PEMASUKAN#");
        System.out.print("Masukkan Tanggal Pencarian: ");
        String tanggal = input.nextLine();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("No\tTanggal\tPendapatan");
        ctrLaporan.MenuHarian(tanggal);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public void menuBulanan() {
        System.out.println("#LAPORAN BULANAN PEMASUKAN#");
        System.out.print("Masukkan Bulan Pencarian: ");
        String bulan = input.nextLine();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("No\tBulan\tPendapatan");
        ctrLaporan.MenuHarian(bulan);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public void menuTahunan() {
        System.out.println("#LAPORAN TAHUNAN PEMASUKAN#");
        System.out.print("Masukkan Tahun Pencarian: ");
        String tahun = input.nextLine();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("No\tTahun\tPendapatan");
        ctrLaporan.MenuHarian(tahun);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    
    public int getPilihan() {
        return pilihan;
    }
}