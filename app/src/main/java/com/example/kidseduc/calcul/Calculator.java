package com.example.kidseduc.calcul;

public class Calculator {
    public static final String SOUSTRACTION = "-";
    public static final String ADDITION = "+";
    public static final String MULTIPLICATION = "*";

    /**
     *
     * @param a
     * @param b
     * @return
     */
    private static int addition(int a, int b){
        return a+b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    private static int multiply(int a, int b){
       return a * b;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    private static int minus(int a, int b){
        return a - b;
    }

    /**
     * @param a
     * @param b
     * @param operation
     * @return
     */
    public static int calculate(int a, int b, String operation){
        if(operation.compareTo(ADDITION) == 0) return addition(a, b);
        if(operation.compareTo(SOUSTRACTION) == 0) return minus(a, b);
        if(operation.compareTo(MULTIPLICATION) == 0) return multiply(a, b);
        return 0;
    }

}
