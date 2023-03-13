package ex4.Commands;

import Iex2.IView;
import Iex4.IConsoleCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateNewNumberCommand extends CommandDefault implements IConsoleCommand {
    @Override
    public String toString() {
        return "|Add new Calculating|";
    }

    public CreateNewNumberCommand(IView view) {
        super(view);
    }

    @Override
    public void execute() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        view.viewInit(Long.parseLong(in.readLine()));
        System.out.println("Num is created!");
        view.viewShow();
    }

    @Override
    public Character getKey() {
        return 'a';
    }
}
