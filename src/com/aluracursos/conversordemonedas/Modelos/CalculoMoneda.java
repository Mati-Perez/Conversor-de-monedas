package com.aluracursos.conversordemonedas.Modelos;

public class CalculoMoneda {
    //recibir un valor base, un valor por el que va a multiplicar, un resultado
    private String base;
    private String objetivo;
    private double valorBase;
    private double valorObjetivo;
    private double resultado;

    public CalculoMoneda() {
    }

    public CalculoMoneda(String base, String objetivo,double valorBase, double valorObjetivo) {
        this.base=base;
        this.objetivo=objetivo;
        this.valorBase = valorBase;
        this.valorObjetivo=valorObjetivo;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public void calcularValorFinal(){
        this.resultado=valorBase*valorObjetivo;
    }

    @Override
    public String toString() {
        return "Moneda: \n" +base+": "+valorBase+
                "\na "+objetivo+": "+resultado;
    }
}
