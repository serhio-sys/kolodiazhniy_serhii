package ex4.Commands;

import Iex2.IView;
import Iex4.IConsoleCommand;

public class SaveDataCommand extends CommandDefault implements IConsoleCommand {
    public SaveDataCommand(IView view) {
        super(view);
    }

    @Override
    public String toString() {
        return "|Save ALL Data|";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("All Data Saved");
        view.viewSave();
    }

    @Override
    public Character getKey() {
        return 's';
    }
}
