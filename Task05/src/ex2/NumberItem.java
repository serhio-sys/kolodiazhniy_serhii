package ex2;
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
     * Sets the result
     *
     * This method in one time as a setter result and as a getter result
     * Parameter is a new result
     * @param
     * @return Map<Character, Integer>
     */
    public void setResult() {
        result = calc(number);
    }
    /**
     *
     * Based Constructor
     *
     */
    public NumberItem(){ this.number=0; setResult(); }
    /**
     *
     * Constructor
     *
     * Create linked new number and set result
     */
    public NumberItem(long num){ this.number = num; setResult(); }

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
    /**
     *
     * equals
     *
     * @return Boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NumberItem other = (NumberItem) obj;
        if (Double.doubleToLongBits(number) != Double.doubleToLongBits(other.number))
            return false;
        return true;
    }
}
