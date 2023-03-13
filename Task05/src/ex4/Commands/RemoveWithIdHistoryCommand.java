package ex4.Commands;

import Iex2.IView;
import Iex4.IConsoleCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoveWithIdHistoryCommand extends CommandDefault implements IConsoleCommand {
    public RemoveWithIdHistoryCommand(IView view) {
        super(view);
    }

    @Override
    public String toString() {
        return "|Remove Data With ID|";
    }

    @Override
    public void execute() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id:");
        view.viewRemoveWithID(Integer.parseInt(in.readLine()));
    }

    @Override
    public Character getKey() {
        return 'i';
    }
}
