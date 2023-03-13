package ex3;

import Iex2.IView;
/** Calculating and output results <br>
 * Contains realize method main()
 * @author Serhii
 * @version 3.0
 * @see Main#main
 */
public class Main extends ex2.Main {
    /** Initialize field */
    public Main(IView view){
        super(view);
    }
    /** In runtime program;
     * call method {@linkplain ex2.Main#menu menu()}
     * @param args - params for starting program
     */
    public static void main(String[] args){
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
