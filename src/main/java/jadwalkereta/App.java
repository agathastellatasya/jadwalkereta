package jadwalkereta;

import java.util.*;

import jadwalkereta.controller.*;
import jadwalkereta.view.*;
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

        // ------------------------------------------------

        ControllerMain ctrMain = new ControllerMain(users);
        ctrMain.run();
    }
    
}
