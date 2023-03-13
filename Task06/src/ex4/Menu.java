package ex4;

import Iex4.IConsoleCommand;
import Iex4.IMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu implements IMenu {

    private final ArrayList<IConsoleCommand> consoleCommands = new ArrayList<>();

    public ArrayList<IConsoleCommand> getConsoleCommands() {
        return consoleCommands;
    }

    @Override
    public String toString() {
        String s = "Enter command...\n";
        for (IConsoleCommand c : consoleCommands) {
            s += "'"+c.getKey() +"'-"+c.toString()+ "\n";
        }
        s += "'q'-|Quit|\n: ";
        return s;
    }

    @Override
    public void show() throws Exception {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            do {
                System.out.print(this);
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.err.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            char key = s.charAt(0);
            if (key == 'q') {
                System.out.println("Exit.");
                break;
            }

            for (IConsoleCommand c : consoleCommands) {
                if (s.charAt(0) == c.getKey()) {
                    c.execute();
                }
            }
        }
    }
}
