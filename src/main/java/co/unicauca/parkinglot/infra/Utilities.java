/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

/**
 * Clase que tiene los métodos que serán utilizados en las demás clases
 * 
 * Integrantes:
 * Javier Rojas
 * Juan José Rengifo
 */
public class Utilities {
    
    /**
     * Método que redondea un número a la sentena más cercana 
     * 
     * @param numero Número que será redondeado
     * @return El número redondeado
     */
    public static int redondear(int numero){
        int residuo=numero%100;
        if (residuo!=0) {
            numero+=100-residuo;
        }
        return numero;
    }
}
