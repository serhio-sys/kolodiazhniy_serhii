package ex4.Commands;

import Iex2.IView;
import Iex4.IConsoleCommand;

public class RemoveCalcHistoryCommand extends CommandDefault implements IConsoleCommand {
    public RemoveCalcHistoryCommand(IView view) {
        super(view);
    }

    @Override
    public String toString() {
        return "|Remove All History|";
    }

    @Override
    public void execute(){
        view.viewRemoveHistory();
        System.out.println("All history have removed!");
    }

    @Override
    public Character getKey() {
        return 'h';
    }
}
