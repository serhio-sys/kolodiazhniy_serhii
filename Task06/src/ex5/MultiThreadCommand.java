package ex5;

import Iex2.IView;
import Iex4.IConsoleCommand;
import ex2.ViewCalculation;

import java.util.Map;

public class MultiThreadCommand implements IConsoleCommand {
    protected ViewCalculation viewCalculation;

    public MultiThreadCommand(ViewCalculation view){
        viewCalculation = view;
    }

    protected Map<Long,Map<Character,Integer>> result;

    public void showResult(){
        for (var item : result.entrySet()){
            System.out.println(item);
        }
    }
    @Override
    public void execute() throws Exception {
    }

    @Override
    public Character getKey() {
        return null;
    }
}
