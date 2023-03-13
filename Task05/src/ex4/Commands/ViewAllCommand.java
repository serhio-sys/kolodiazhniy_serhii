package ex4.Commands;

import Iex2.IView;
import Iex4.IConsoleCommand;

public class ViewAllCommand extends CommandDefault implements IConsoleCommand {
    public ViewAllCommand(IView view) {
        super(view);
    }

    @Override
    public String toString() {
        return "|View All Data|";
    }

    @Override
    public void execute() throws Exception {
        view.viewShow();
    }

    @Override
    public Character getKey() {
        return 'v';
    }
}
