package com.aluracursos.conversordemonedas.Principal;

import com.aluracursos.conversordemonedas.Modelos.ConsultaMoneda;
import com.aluracursos.conversordemonedas.Modelos.CalculoMoneda;
import com.aluracursos.conversordemonedas.Modelos.Monedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion;
        boolean repetir=true;
        Scanner lectura=new Scanner(System.in);

        while(repetir){
            System.out.println("*******************************************");
            System.out.println("Sea bienvenido al Conversor de Monedas :)");

            System.out.println("1) Dólar -->> Peso Argentino");
            System.out.println("2) Peso Argentino --> Dólar");
            System.out.println("3) Dólar --> Real brasileño");
            System.out.println("4) Real Brasileño --> Dólar");
            System.out.println("5) Dólar --> Peso Colombiano");
            System.out.println("6) Peso Colombiano --> Dolar");
            System.out.println("7) Convertir de forma personalizada");
            System.out.println("0) Salir");
            System.out.println("Elija una opción válida: ");
            opcion=lectura.nextInt();

            System.out.println("*******************************************");


            switch(opcion){
                case 1:
                    convertirMoneda("USD","ARS");
                    break;
                case 2:
                    convertirMoneda("ARS","USD");
                    break;
                case 3:
                    convertirMoneda("USD","BRL");
                    break;
                case 4:
                    convertirMoneda("BRL","USD");
                    break;
                case 5:
                    convertirMoneda("USD","COP");
                    break;
                case 6:
                    convertirMoneda("COP","USD");
                    break;
                case 0:
                    repetir=false;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        }
        System.out.println("Gracias por usar nuestro software :)");
    }

    public static void convertirMoneda(String origen, String destino){
        Scanner leer=new Scanner(System.in);
        ConsultaMoneda consulta=new ConsultaMoneda();
        CalculoMoneda calculoMoneda=new CalculoMoneda();
        calculoMoneda.setBase(origen);
        calculoMoneda.setObjetivo(destino);
        System.out.println("Ingrese una cantidad ("+origen+") : ");

        try{
            double cantidad=leer.nextDouble();

            Monedas moneda=consulta.buscarMoneda(origen,destino);
            calculoMoneda.setValorBase(cantidad);
            calculoMoneda.setValorObjetivo(moneda.conversion_rate());
            calculoMoneda.calcularValorFinal();

            System.out.println(calculoMoneda);
/*
            GeneradorDeArchivo generador=new GeneradorDeArchivo();
            generador.guardarJson(moneda);

 */
        }catch(NumberFormatException e){
            System.out.println("Moneda no encontrada: "+e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion...");
        }

    }
}