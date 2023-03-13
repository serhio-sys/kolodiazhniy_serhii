package ex3;

import Iex2.IView;
/** ConcreteCreator
 * (Factory Method)<br>
 * @author xone
 * @version 1.0
 * @see ex2.ViewableCalculation
 * @see ViewableTable#getView()
 */
public class ViewableTable extends ex2.ViewableCalculation{
    /** Create object {@linkplain ViewTable} */
    @Override
    public IView getView() {
        return new ViewTable();
    }
}
