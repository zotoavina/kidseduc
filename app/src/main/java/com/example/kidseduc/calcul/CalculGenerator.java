package com.example.kidseduc.calcul;

import java.util.ArrayList;
import java.util.List;

public class CalculGenerator {

    private List<Unit> calculList = new ArrayList<>();
    private static final String OPERATIONS = "*+-";
    private int exact = 0;

    private int generateNumber(int limit){
        return new Double(Math.random() * limit).intValue() ;
    }

    private String generateOperations(){
        int a = generateNumber(3);
        char operation = OPERATIONS.charAt(a);
        return operation + "";
    }

    public void generateCalcul(int limit){
        for(int i = 0; i < 5; i++){
            int a = generateNumber(limit);
            String operate = generateOperations();
            int b =  (operate.compareTo("-")==0)?  generateNumber(a) : generateNumber(limit);
            calculList.add(new Unit(a, operate, b) );
        }
    }

    public void display(){
        for(int i = 0 ; i < calculList.size(); i++){
            System.out.println(calculList.get(i));
        }
    }

    public static void main(String[] args) {
        CalculGenerator cg = new CalculGenerator();
        cg.generateCalcul(11);
        cg.display();
    }


}
