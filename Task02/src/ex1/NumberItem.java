package ex1;
import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;


/**
 * The class Number item implements serializable
 *
 * This class will be Serializable
 */
public class NumberItem implements Serializable {
    private long number;
    @Serial
    private static final long serialVersionUID = 1L;

    private Map<Character,Integer> result = new TreeMap<>();


    /**
     *
     * Gets the result
     *
     * The method is getting result
     * @return
     */
    public Map<Character, Integer> getResult() {

        return result;
    }


    /**
     *
     * Sets the result
     *
     * This method in one time as a setter result and as a getter result
     * Parameter is a new result
     * @param
     * @return Map<Character, Integer>
     */
    public Map<Character, Integer> setResult(Map<Character, Integer> result) {

        return this.result = result;
    }

    public NumberItem(){ this.number=0; }


    /**
     *
     * Gets the number
     *
     * @return the method is get number
     */
    public long getNumber() {

        return number;
    }


    /**
     *
     * Sets the number
     *
     * @param number  The setter of number
     */
    public void setNumber(long number) {

        this.number = number;
    }

    @Override

/**
 *
 * To string
 *
 * @return String
 */
    public String toString() {

        return "Number: "+ number + "\n" + result;
    }

}
