package ex4;

import Iex2.IView;
import ex3.ViewableTable;
import ex4.Commands.*;


public class Application {
    private static final Application INSTANCE = new Application();
    private Application(){}

    public static Application getInstance(){
        return INSTANCE;
    }
    private final IView view = new ViewableTable().getView();
    private final Menu menu = new Menu();

    public void Start() throws Exception {
        menu.getConsoleCommands().add(new CreateNewNumberCommand(view));
        menu.getConsoleCommands().add(new GenerateCommand(view));
        menu.getConsoleCommands().add(new RestoreDataCommand(view));
        menu.getConsoleCommands().add(new SaveDataCommand(view));
        menu.getConsoleCommands().add(new RemoveCalcHistoryCommand(view));
        menu.getConsoleCommands().add(new RemoveWithIdHistoryCommand(view));
        menu.getConsoleCommands().add(new ViewAllCommand(view));
        menu.getConsoleCommands().add(new ViewLastCommand(view));
        menu.show();
    }

}
