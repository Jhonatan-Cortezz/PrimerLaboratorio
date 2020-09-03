package com.example.labpractico.ejercicio1;

public class CalcularSalario {
    private String nomre;
    private double sueldo;
    private int qtyMinutos;

    private final double renta = 0.1;

    public CalcularSalario() {
    }

    public CalcularSalario(String nomre, double sueldo, int qytMinutos) {
        this.nomre = nomre;
        this.sueldo = sueldo;
        this.qtyMinutos = qytMinutos;
    }

    public String getNomre() {
        return nomre;
    }

    public void setNomre(String nomre) {
        this.nomre = nomre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getQtyMinutos() {
        return qtyMinutos;
    }

    public void setQtyMinutos(int qtyMinutos) {
        this.qtyMinutos = qtyMinutos;
    }

    //calcular salario por minuto
    public double calcularSuledoPorMinuto(){
        double sueldoDiario;
        double sueldoHora;
        double sueldoMinuto;

        sueldoDiario = (1 * this.sueldo) / 30;//sacamos el sueldo diario
        sueldoHora = (1 * sueldoDiario) / 8;//calculamos el sueldo por hora
        sueldoMinuto = (1 * sueldoHora) / 60;//obtenemos el suedlo por minuto

        return sueldoMinuto;
    }

    //calcular descuentos por llegadas tardes
    public double decuentoPorLlegarTarde(){
        double descuento = 0.0;
        if (this.getQtyMinutos() != 0.0){
            descuento = this.calcularSuledoPorMinuto() * qtyMinutos;
        } else {
            descuento = 0.0;
        }

        return descuento;
    }


    //calcualar decuento sobre la renta mensual
    public double calcularRetencion(){
        return (this.sueldo * renta) - this.decuentoPorLlegarTarde();
    }

    //calculo salario brto
    public double salarioFinal(){
        return (this.sueldo - this.decuentoPorLlegarTarde() - this.calcularRetencion());
    }
}
