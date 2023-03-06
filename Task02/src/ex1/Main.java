package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


/**
 * The class Main
 * This class have a menu of working program
 */
public class Main {
    private final Calc calc = new Calc();
    private final Random random = new Random();

    /**
     *
     * Menu
     * method where you select what you want to do
     */
    private void menu(){

        String select = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Please Select...");
                System.out.print("'q' - Quit\n'v' - View Number\n'g' - Generate\n'e' - Enter your number\n's' - Save Data\n'r' - Restore Data:");
                try{
                    select = in.readLine();
                }catch (Exception exception) {
                    System.out.println("Error: " + exception);
                    System.exit(0);
                }
            }while (select.length()!=1);
            switch (select.charAt(0)) {
                case 'q' -> System.out.println("Exit.");
                case 'v' -> {
                    System.out.println("View current.");
                    calc.show();
                }
                case 'e' -> {
                    System.out.println("Enter number");
                    while (true) {
                        try {
                            calc.init(Long.parseLong(in.readLine()));
                            calc.show();
                            break;
                        } catch (Exception exception) {
                            System.out.println("Error: " + exception);
                        }
                    }
                }
                case 'g' -> {
                    System.out.println("Random generation.");
                    calc.init(random.nextLong(0, 1000000));
                    calc.show();
                }
                case 's' -> {
                    System.out.println("Save current.");
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                case 'r' -> {
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                default -> System.out.print("Wrong command. ");
            }
        }while (select.charAt(0)!='q');
    }

    /**
     *
     * Main
     * Program start main method
     * @param args  the args that you can write in start program
     */
    public static void main(String[] args){

        Main main = new Main();
        main.menu();
    }
}