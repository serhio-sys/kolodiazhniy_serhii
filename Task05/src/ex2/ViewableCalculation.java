package ex2;

import Iex2.IView;
import Iex2.IViewable;
/** ConcreteCreator
 * (Factory Method)<br>
 * @author xone
 * @version 1.0
 * @see IViewable
 * @see ex2.ViewableCalculation#getView()
 */
public class ViewableCalculation implements IViewable {
    /** Создаёт отображаемый объект {@linkplain ex2.ViewCalculation} */
    @Override
    public IView getView() {
        return new ViewCalculation();
    }
}
