package jadwalkereta;

import java.util.*;

import jadwalkereta.controller.*;
import jadwalkereta.model.*;

/**
 * Hello world!
 */
public final class App {
    static int pilihan;
    static Scanner input = new Scanner(System.in);
    
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        // ---------------- SETUP DATA DUMMY --------------
        ArrayList<User> users = new ArrayList<User>();

        User admin = new User("1234567812345678", "Admin", "08986703456","admin", "admin", 1);
        User penumpang = new User("1234567812345679", "Test", "08986703450","test", "test", 2);

        users.add(admin);
        users.add(penumpang);

        // Tambahan Adri

        ArrayList<Station> stations = new ArrayList<Station>();
        ArrayList<Time> times = new ArrayList<Time>();

        Station jkt = new Station("SJK", "Jakarta");
        Station bdg = new Station("SBD", "Bandung");
        Station sby = new Station("SBY", "Surabaya");
        Station bal = new Station("SBL", "Bali");
        Station smg = new Station("SMG", "Semarang");
        
        stations.add(jkt);
        stations.add(bdg);
        stations.add(sby);
        stations.add(bal);
        stations.add(smg);
		
	// Tambahan Husni #20191117
		
	    ArrayList<City> cities = new ArrayList<City>();
        ArrayList<Rute> rute = new ArrayList<Rute>();
		ArrayList<Kereta> kereta = new ArrayList<Kereta>();
		

        //rute.add(new Rute("JKT-BAL",1,2,"Jakarta","Bali"));
        
        City Jakarta = new City("JKT", "Jakarta");
        City Bandung = new City("BDG", "Bandung");
        City Surabaya = new City("SBY", "Surabaya");
        City Bali = new City("BAL", "Bali");
        City Semarang = new City("SMG", "Semarang");

        cities.add(Jakarta);
        cities.add(Bandung);
        cities.add(Surabaya);
        cities.add(Bali);
        cities.add(Semarang);

    // Tambahan salma
        Kereta KA1 = new Kereta("KAI18801", "Kereta1", 6, 2, 4);
        Kereta KA2 = new Kereta("KAI19801", "Kereta2", 6, 2, 4);
        Kereta KA3 = new Kereta("KAI18802", "Kereta2", 6, 2, 4);
        Kereta KA4 = new Kereta("KAI18803", "Kereta2", 6, 2, 4);

        

        kereta.add(KA1);
        kereta.add(KA2);
        kereta.add(KA3);
        kereta.add(KA4);

        Rute R1 = new Rute("JKT-BDG", 400000, 300000, "Jakarta", "Bandung" );
        Rute R2 = new Rute("BDG-JKT", 400000, 300000, "Bandung", "Jakarta" );
        Rute R3 = new Rute("SMG-SBY", 300000, 200000, "Semarang", "Surabaya" );
        Rute R4 = new Rute("SBY-SMG", 300000, 200000, "Surabaya", "Semarang" );
        rute.add(R1);
        rute.add(R2);
        rute.add(R3);
        rute.add(R4);


        /////////////////////////////////////////////////////////////////////////////////
        // Contoh penambahan Jalur Langsung pada rute

        ArrayList<Jalur> jalur = new ArrayList<>();
        ArrayList<KARute> karute = new ArrayList<KARute>();
        ArrayList<TimeRute> timerute = new ArrayList<TimeRute>();
        jalur.add(new Jalur(jkt,bdg, 200)); //jkt, bdg, smg, dan sby adalah variabel tipe station yang sudah di deklarasi diatas
        jalur.add(new Jalur(bdg,smg, 200));
        jalur.add(new Jalur(smg,sby, 200));
        karute.add(new KARute(KA1));
        karute.add(new KARute(KA2));
        karute.add(new KARute(KA3));
        //karute.add(new KARute("KAI18801"));
        Rute R5 = new Rute("JKT-SBY", 2000000, 1000000, "Jakarta", "Surabaya", jalur,timerute,karute);
        rute.add(R5);

        ///////////////////////////////////////////////////////////////////////////////////
        
//        KARute KR1 = new KARute(1, "JKT-BDG", "KAI18801");
//        KARute KR2 = new KARute(1, "JKT-BDG", "KAI19801");
//        KARute KR3 = new KARute(2, "SMG-SBY", "KAI18802");
//        KARute KR4 = new KARute(2, "SMG-SBY", "KAI18803");
        

//        karute.add(KR1);
//        karute.add(KR2);
//        karute.add(KR3);
//        karute.add(KR4);

      
        ///////////////////////////////////////////////////////////

        // ------------------------------------------------
        
        // Tambah Parameter Station

        ControllerMain ctrMain = new ControllerMain(users, stations, cities, rute, times, kereta, timerute);
        ctrMain.run();
    }
}
