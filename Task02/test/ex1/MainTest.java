package ex1;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
public class MainTest {
    private final Random random = new Random();
    @Test
    public void testCalc(){
        Calc calc = new Calc();
        calc.init(0);
        assertEquals(new TreeMap<Character,Integer>(){{
            put('0',1);
        }}, calc.getResult().getResult());
        calc.init(199);
        assertEquals(new TreeMap<>(){{
            put('1',1);
            put('9',2);
        }}, calc.getResult().getResult());
        calc.init(112299);
        assertEquals(new TreeMap<>(){{
            put('1',2);
            put('2',2);
            put('9',2);
        }}, calc.getResult().getResult());
        calc.init(198080);
        assertEquals(new TreeMap<>(){{
            put('1',1);
            put('9',1);
            put('8',2);
            put('0',2);
        }}, calc.getResult().getResult());
    }

    @Test
    public void testRestore(){
        Calc calc = new Calc();
        long number;
        Map<Character,Integer> result;
        for (int i = 0;i<1000; i++){
            number = random.nextLong(0,10000000);
            calc.init(number);
            result = calc.getResult().getResult();
            try {
                calc.save();
            }catch (IOException exception){
                Assert.fail(exception.getMessage());
            }
            calc.init(random.nextLong(0,10000000));
            try{
                calc.restore();
            }catch (Exception exception){
                Assert.fail(exception.getMessage());
            }
            assertEquals(number,calc.getResult().getNumber());
            assertEquals(result,calc.getResult().getResult());
        }
    }
}
