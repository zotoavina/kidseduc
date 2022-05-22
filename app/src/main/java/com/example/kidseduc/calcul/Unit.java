package com.example.kidseduc.calcul;

public class Unit {
    private int a;
    private int b;
    private String operation;
    private int answer;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public Unit(int a, String operation, int b){
        setA(a);
        setOperation(operation);
        setB(b);
    }

    @Override
    public String toString(){
        return a + operation + b;
    }

    public int calculate(){
        return Calculator.calculate(a,b, operation);
    }
}
