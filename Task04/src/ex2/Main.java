package ex2;

import Iex2.IView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


/**
 * The class Main
 * This class have a menu of working program
 */
public class Main {

    /**
     * This object realize this interface - {@linkplain IView};
     */
    private IView calc;
    private final Random random = new Random();

    public Main(IView view){
        calc = view;
    }
    /**
     *
     * menu
     * method where you select what you want to do
     */
    protected void menu(){

        String select = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Please Select...");
                System.out.print("'q' - Quit\n'i' - View Last Data\n'v' - View All Data\n'g' - Generate\n" +
                        "'e' - Create new number\n'f' - Remove all calculating history\n'd' - Remove With ID\n's' - Save Data\n"+
                        "'r' - Restore Data:");
                try{
                    select = in.readLine();
                }catch (Exception exception) {
                    System.out.println("Error: " + exception);
                    System.exit(0);
                }
            }while (select.length()!=1);
            switch (select.charAt(0)) {
                case 'q' -> System.out.println("Exit.");
                case 'i' -> calc.viewShowLast();
                case 'v' -> {
                    System.out.println("View All history.");
                    calc.viewShow();
                }
                case 'f' -> calc.viewRemoveHistory();
                case 'e' -> {
                    System.out.println("Enter number");
                    while (true) {
                        try {
                            long num = Long.parseLong(in.readLine());
                            calc.viewInit(num);
                            calc.viewShow();
                            break;
                        } catch (Exception exception) {
                            System.out.println("Error: " + exception);
                        }
                    }
                }
                case 'g' -> {
                    System.out.println("Random generation.");
                    calc.viewInit(random.nextLong(0, 1000000));
                    calc.viewShow();
                }
                case 's' -> {
                    System.out.println("Save current.");
                    try {
                        calc.viewSave();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.viewShow();
                }
                case 'd' -> {
                    System.out.println("Enter ID: ");
                    try {
                        calc.viewRemoveWithID(Integer.parseInt(in.readLine())-1);
                    }catch (Exception exception){
                        System.out.println("Error: "+ exception);
                    }
                }
                case 'r' -> {
                    System.out.println("Restore last saved.");
                    try {
                        calc.viewRestore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.viewShow();
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

        Main main = new Main(new ViewableCalculation().getView());
        main.menu();
    }
}