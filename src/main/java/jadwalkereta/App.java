package jadwalkereta;

import java.util.Scanner;
import jadwalkereta.controller.ControllerMain;

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
        ControllerMain ctrMain = new ControllerMain();
//        System.out.println("#Menu Utama#");
//        System.out.println("1.  Register");
//        System.out.println("2.  Login");
//        System.out.print("Pilih Menu : ");
//        pilihan = input.nextInt();
//        switch(pilihan){
//            case 1 :
//                break;
//            case 2 :
//                break;
//            
//        }

        ctrMain.run();
    }
    
}
