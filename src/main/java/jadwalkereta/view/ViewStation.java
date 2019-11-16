package jadwalkereta.view;

import java.util.Scanner;

public class ViewStation {
    private int pilihan;
    Scanner input = new Scanner(System.in);

    public ViewStation() {

    }

    public void menuStation() {
        System.out.println("#KELOLA DATA Stasiun#");
        System.out.println("1.  Tambah Data Stasiun");
        System.out.println("2.  Lihat Data Stasiun");
        System.out.println("3.  Edit Data Stasiun");
        System.out.println("4.  Delete Data Stasiun");
        System.out.println("99. Menu Utama");
        System.out.print("Pilih Menu : ");
        pilihan = input.nextInt();
    }

    public int getPilihan() {
        return pilihan;
    }
}