package ex2;

import Iex2.IView;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


/**
 * The class ViewCalculation realize - {@linkplain IView};
 *
 * This class just do as a calculating and as a saving and restoring data
 */
public class ViewCalculation implements IView {
    private final Random random = new Random();
    private static final String FNAME = "ex4.NumberItem.bin";
    private static final int DEFAULT_NUM = 10;
    private ArrayList<NumberItem> items = new ArrayList<>();

    /**
     *
     * Init
     * auto initialize
     */
    public void init() {
        for(var item : items) {
            item.setNumber(random.nextLong(0,Long.MAX_VALUE));
            item.setResult();
        }
    }
    /**
     *
     * Get Items
     *
     * @return ArrayList<NumberItem>
     */
    public ArrayList<NumberItem> getItems() {
        return items;
    }
    /**
     *
     * View Header
     *
     * A part of showing info
     */
    @Override
    public void viewHeader() {
        System.out.println("\tResults:");
    }
    /**
     *
     * View Body
     *
     * Output all Array with Numbers and Results
     */
    @Override
    public void viewBody() {
        int i = 1;
        for (var item : items){
            System.out.println("---------------"+i+"----------------");
            System.out.println("Number: "+item.getNumber());
            for (var itemMap:item.getResult().entrySet()){
                System.out.println(itemMap.getKey()+":"+itemMap.getValue());
            }
            System.out.println("---------------"+i+"----------------");
            i++;
        }
        System.out.println();
    }

    /**
     *
     * View Show
     *
     * This method output result
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
    }
    /**
     *
     * View Remove History
     *
     * Remove history
     */
    @Override
    public void viewRemoveHistory() {
        items.clear();
    }
    /**
     *
     * View Init
     *
     * @param index  the new initialized num
     * @return Map<Character,Integer>
     */
    @Override
    public void viewRemoveWithID(int index) {
        try {
            items.remove(index);
            System.out.println("Successfully removed with index - "+index);
        }catch (Exception exception){
            System.out.println("Exception: "+exception);
        }
    }
    /**
     *
     * View Last
     *
     * Output last element
     */
    @Override
    public void viewShowLast() {
        viewHeader();
        NumberItem last = items.get(items.size()-1);
        System.out.println("--------------------------------");
        System.out.println("Number: "+last.getNumber());
        for (var itemMap:last.getResult().entrySet()){
            System.out.println(itemMap.getKey()+":"+itemMap.getValue());
        }
        System.out.println("--------------------------------");
    }

    /**
     *
     * View Init
     *
     * @param num  the new initialized num
     * @return Map<Character,Integer>
     */
    @Override
    public void viewInit(long num) {
        items.add(new NumberItem(num));
    }
    /**
     *
     * View Save
     *
     * This method is saving number and result in .bin file
     * @throws   IOException
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }
    /**
     *
     * View Restore
     *
     * This method read data from .bin file
     * @throws   Exception
     */
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<NumberItem>) is.readObject();
        is.close();
    }

    /**
     *
     * Constructor of this class
     *
     */
    public ViewCalculation(){
        for (int i = 0;i<DEFAULT_NUM;i++){
            items.add(new NumberItem());
        }
        init();
    }
}