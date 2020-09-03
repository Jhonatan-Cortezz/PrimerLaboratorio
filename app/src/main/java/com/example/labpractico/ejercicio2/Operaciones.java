package com.example.labpractico.ejercicio2;

public class Operaciones {
    private double num1;
    private double num2;
    private double num3;

    public Operaciones() {
    }

    public Operaciones(double num1, double num2, double num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getNum3() {
        return num3;
    }

    public void setNum3(double num3) {
        this.num3 = num3;
    }

    public String numeroMayor(double n1, double n2, double n3){
        String rst = "";
        if (n1 > n2 && n1 > n3){
            rst = "" + n1;
        } else if (n2 > n3 && n2 > n1){
            rst = "" + n2;
        } else  if (n1 == n2 && n2 == n3 && n3 == n1){
            rst = "todos son iguales";
        } else if ((n3 > n1) && (n3 > n2)){
            rst = "" + n3;
        }

        return rst;
    }

    public double media(double n1, double n2, double n3){
        double media = (n1 + n2 + n3) / 3;
        return media;
    }
}
