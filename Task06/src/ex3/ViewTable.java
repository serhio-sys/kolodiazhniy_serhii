package ex3;

import ex2.NumberItem;
import ex2.ViewCalculation;

/** ConcreteProduct
 * (Factory Method)<br>
 * Output in table format
 * @author xone
 * @version 1.0
 * @see ex2.ViewCalculation
 */
public class ViewTable extends ex2.ViewCalculation{
    /** Default width */
    private static final int STATIC_WIDTH = 60;

    public ViewTable(){
    }

    /** Output vertical divider {@linkplain ViewTable#STATIC_WIDTH} symbols */
    private void outLine() {
        for(int i = STATIC_WIDTH; i > 0; i--) {
            System.out.print('-');
        }
        System.out.println();
    }
    /** Output title table width {@linkplain ViewTable#STATIC_WIDTH} symbols */
    private void outHeader() {
        System.out.printf("ID | %"+(STATIC_WIDTH)/5+"s"+"%"+(STATIC_WIDTH-2)/6+"s"+"%"+(STATIC_WIDTH)/3+"s", " Number ",
                "|", "Result \n");
    }

    /** Overloading methods superclass;
     * Call method {@linkplain ex2.ViewCalculation#init()} () init()}
     */
    @Override
    public void init() {
        System.out.print("Initialization... ");
        super.init();
        System.out.println("done. ");
    }

    /** Output table element<br>{@inheritDoc} */
    @Override
    public void viewHeader() {
        outHeader();
        outLine();
    }
    /** Override {@linkplain ViewCalculation#viewBody()} in table format
     * <br>{@inheritDoc} */
    @Override
    public void viewBody() {
        int i = 1;
        for(NumberItem item : getItems()) {
            if (String.valueOf(item.getNumber()).length()<10){
                System.out.printf(String.format("%d | %"+12+"d "+"%"+8+"s%s\n",i,item.getNumber(),"| ",item.getResult().toString()));
            }
            else {
                System.out.printf(String.format("%d | %"+8+"d | %s\n",i,item.getNumber(),item.getResult().toString()));
            }
            outLine();
            i++;
        }
    }
    /** Override {@linkplain ViewCalculation#viewShowLast()} in table format
     * <br>{@inheritDoc} */
    @Override
    public void viewShowLast(){
        viewHeader();
        NumberItem item = getItems().get(getItems().size()-1);
        if (String.valueOf(item.getNumber()).length()<10){
            System.out.printf(String.format("%d | %"+12+"d "+"%"+8+"s%s\n",getItems().size(),item.getNumber(),"| ",item.getResult().toString()));
        }
        else {
            System.out.printf(String.format("%d | %"+8+"d | %s\n",getItems().size(),item.getNumber(),item.getResult().toString()));
        }
        outLine();
    }


}
