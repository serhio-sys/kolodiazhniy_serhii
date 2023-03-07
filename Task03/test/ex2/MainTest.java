package ex2;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class MainTest {
    private final Random random = new Random();
    @Test
    public void testCalc(){
        ViewCalculation calc = new ViewCalculation();
        calc.viewInit(10009999);
        NumberItem item = new NumberItem(10009999);
        assertEquals("Expected:" + item + "\nbut was: ", item, calc.getItems().get(calc.getItems().size() - 1));
        calc.viewInit(100992233);
        item.setNumber(100992233);
        item.setResult();
        assertEquals("Expected:" + item + "\nbut was: ", item, calc.getItems().get(calc.getItems().size() - 1));
    }

    @Test
    public void testRestore(){
        ViewCalculation view1 = new ViewCalculation();
        ViewCalculation view2 = new ViewCalculation();
        view1.viewInit(random.nextLong(0,100000000));
        try {
            view1.viewSave();
        }catch (IOException exception){
            Assert.fail(exception.getMessage());
        }
        try{
            view2.viewRestore();
            view2.viewRestore();
        }catch (Exception exception){
            Assert.fail(exception.getMessage());
        }
        assertEquals(view1.getItems().size(),view2.getItems().size());
        assertTrue(view1.getItems().containsAll(view2.getItems()));
        assertTrue(view1.getItems().get(0).toString().equals(view2.getItems().get(0).toString()));

    }
}
