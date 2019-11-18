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
        
        stations.add(jkt);
        stations.add(bdg);
        stations.add(sby);
        stations.add(bal);
		
	// Tambahan Husni #20191117
		
	    ArrayList<City> cities = new ArrayList<City>();
        ArrayList<Rute> rute = new ArrayList<Rute>();
		ArrayList<Kereta> kereta = new ArrayList<Kereta>();
		ArrayList<TimeRute> timerute = new ArrayList<TimeRute>();

        rute.add(new Rute("JKT-BAL",1,2,"Jakarta","Bali"));
        
        City Jakarta = new City("JKT", "Jakarta");
        City Bandung = new City("BDG", "Bandung");
        City Surabaya = new City("SBY", "Surabaya");
        City Bali = new City("BAL", "Bali");

        cities.add(Jakarta);
        cities.add(Bandung);
        cities.add(Surabaya);
        cities.add(Bali);

    // Tambahan salma
        Kereta KA1 = new Kereta("KAI18801", "Kereta1", 6, 2, 4);
        Kereta KA2 = new Kereta("KAI19801", "Kereta2", 6, 2, 4);
        

        kereta.add(KA1);
        kereta.add(KA2);

        Rute R1 = new Rute("JKT-BDG", 400000, 300000, "Jakarta", "Bandung" );
        Rute R2 = new Rute("BDG-JKT", 400000, 300000, "Bandung", "Jakarta" );

        rute.add(R1);
        rute.add(R2);

        ArrayList<KARute> karute = new ArrayList<KARute>();
        KARute KR1 = new KARute("JKT-BDG", "KAI18801");
        KARute KR2 = new KARute("JKT-BDG", "KAI19801");
        //KARute KR3 = new KARute("JKT-BDG", "KAI18801");
        //KARute KR4 = new KARute("JKT-BDG", "KAI19801");
        

        karute.add(KR1);
        karute.add(KR2);
        //karute.add(KR3);
        //karute.add(KR4);

        ///////////////////////////////////////////////////////////

        // ------------------------------------------------
        
        // Tambah Parameter Station

        ControllerMain ctrMain = new ControllerMain(users, stations, cities, rute, times, kereta, timerute, karute);
        ctrMain.run();
    }
}
