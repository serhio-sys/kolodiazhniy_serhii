package ex1;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;


/**
 * The class Calc
 *
 * This class just do as a calculating and as a saving and restoring data
 */
public class Calc {
    private static final String FNAME = "ex1.NumberItem.bin";
    private NumberItem result;


    /**
     *
     * Constructor of this class
     *
     */
    public Calc(){

        result = new NumberItem();
    }

    /**
     *
     * Calc
     *
     * @param num  The num for calculating
     * @return Map<Character,Integer>
     */
    private Map<Character,Integer> calc(long num){

        String number = Long.toString(num);
        Map<Character, Integer> results = new TreeMap<>();

        for (int i = 0; i < number.length(); i++) {
            char data = number.charAt(i);

            if (results.containsKey(data)) {
                results.put(data, results.get(data) + 1);
            } else {
                results.put(data, 1);
            }
        }
        return results;
    }

    /**
     *
     * Init
     *
     * @param num  the new initialized num
     * @return Map<Character,Integer>
     */
    public Map<Character,Integer> init(long num){

        result.setNumber(num);
        return result.setResult(calc(num));
    }


    /**
     *
     * Show
     *
     * This method output result
     */
    public void show(){

        System.out.println(result);
    }


    /**
     *
     * Gets the result
     *
     * @return the result
     */
    public NumberItem getResult() {

        return result;
    }


    /**
     *
     * Save
     *
     * This method is saving number and result in .bin file
     * @throws   IOException
     */
    public void save() throws IOException{

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }


    /**
     *
     * Restore
     *
     * This method read data from .bin file
     * @throws   Exception
     */
    public void restore() throws Exception{

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (NumberItem) is.readObject();
        is.close();
    }
}