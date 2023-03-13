package Iex2;
/** Creator
 * (Factory Method)<br>
 * @see ex2.ViewableCalculation#getView()
 */
public interface IViewable {
    /** Создаёт объект, реализующий {@linkplain IView} */
    public IView getView();
}
