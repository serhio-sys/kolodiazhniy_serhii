package ex4.Commands;

import Iex2.IView;
import Iex4.IConsoleCommand;

import java.util.Random;

public class GenerateCommand extends CommandDefault implements IConsoleCommand {
    public GenerateCommand(IView view) {
        super(view);
    }

    @Override
    public String toString() {
        return "|Generate Random|";
    }

    @Override
    public void execute(){
        System.out.println("Random generated!");
        view.viewInit(new Random().nextLong(0,Long.MAX_VALUE));
        view.viewShow();
    }

    @Override
    public Character getKey() {
        return 'g';
    }
}
