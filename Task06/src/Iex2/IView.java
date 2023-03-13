package Iex2;

import java.io.IOException;

/** Product
 * (Factory Method)
 */
public interface IView {
    /** Output header */
    public void viewHeader();
    /** Output body */
    public void viewBody();
    /** Removing selected calc history */
    public void viewRemoveWithID(int index);
    /** Removing all calc history */
    public void viewRemoveHistory();
    /** Showing info */
    public void viewShow();
    /** Showing last info */
    public void viewShowLast();
    /** Initialized data */
    public void viewInit(long num);
    /** Save data for restore */
    public void viewSave() throws IOException;
    /** Restore data */
    public void viewRestore() throws Exception;
}
