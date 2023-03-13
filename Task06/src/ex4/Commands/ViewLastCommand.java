package ex4.Commands;

import Iex2.IView;
import Iex4.IConsoleCommand;

public class ViewLastCommand extends CommandDefault implements IConsoleCommand {
    public ViewLastCommand(IView view) {
        super(view);
    }

    @Override
    public String toString() {
        return "|View Last Data|";
    }

    @Override
    public void execute() throws Exception {
        view.viewShowLast();
    }

    @Override
    public Character getKey() {
        return 'l';
    }
}
