package ex5;

import ex2.ViewCalculation;

import java.util.TreeMap;

public class MinCommand extends MultiThreadCommand{

    public MinCommand(ViewCalculation view) {
        super(view);
    }
    public int index = 1;
    public boolean isRun(){
        return index<=viewCalculation.getItems().size();
    }

    @Override
    public void execute() throws Exception {
        result = new TreeMap<>();
        System.out.println("Min Count executed...");
        int size = viewCalculation.getItems().size();
        index = 1;
        for (var numberitem : viewCalculation.getItems()){
            int finalMin = 0;
            Character finalC = '0';
            for (var number_item_result : numberitem.getResult().entrySet()){
                if (number_item_result.getValue()>0||number_item_result.getValue()<finalMin){
                    finalMin=number_item_result.getValue();
                    finalC = number_item_result.getKey();
                }
            }
            Character finalC1 = finalC;
            int finalMax1 = finalMin;
            result.put(numberitem.getNumber(),new TreeMap<>(){{put(finalC1, finalMax1);}});
            System.out.printf("Index %d/%d is Done!\n",index++,size);
        }
        System.out.println("\tResults (min):");
        showResult();
    }
}
