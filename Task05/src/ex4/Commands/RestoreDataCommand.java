package ex4.Commands;

import Iex2.IView;
import Iex4.IConsoleCommand;

public class RestoreDataCommand extends CommandDefault implements IConsoleCommand{

    public RestoreDataCommand(IView view) {
        super(view);
    }

    @Override
    public String toString() {
        return "|Restore Data|";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Data is restored!");
        view.viewRestore();
    }

    @Override
    public Character getKey() {
        return 'r';
    }
}
