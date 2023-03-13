package ex5;

import Iex2.IView;
import Iex4.IConsoleCommand;
import ex2.ViewCalculation;
import ex4.Commands.CommandDefault;

import java.util.concurrent.TimeUnit;

public class ExecuteMultiThreadCommand extends CommandDefault implements IConsoleCommand {

    public ExecuteMultiThreadCommand(IView view) {
        super(view);
    }

    @Override
    public String toString() {
        return "|MultiExecute (MIN/MAX)|";
    }

    @Override
    public void execute() throws Exception {
        CommandQueue queue = new CommandQueue();
        MaxCommand maxCommand = new MaxCommand((ViewCalculation) view);
        MinCommand minCommand = new MinCommand((ViewCalculation) view);
        System.out.println("All executed!");
        queue.put(maxCommand);
        queue.put(minCommand);
        try {
            while (maxCommand.isRun()|| minCommand.isRun()){
                TimeUnit.MILLISECONDS.sleep(300);
            }
            queue.setShutdown();
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException ie){
            System.err.println(ie);
        }
        System.out.println("Done");
    }

    @Override
    public Character getKey() {
        return 'm';
    }
}
