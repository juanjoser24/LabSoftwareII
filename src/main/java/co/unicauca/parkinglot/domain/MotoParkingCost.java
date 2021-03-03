/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Clase que calcula el valor a pagar para el vehiculo de tipo: moto
 *
 * Integrantes:
 * Javier Rojas
 * Juan José Rengifo
 */
public class MotoParkingCost implements IParkingCost {
    
    /**
     * Calcula el costo que debe pagar un vehiculo de tipo MOTO en un parqueadero
     * 
     * @param veh Vehiculo que estuvo en el parqueadero
     * @param input Hora de entrada del vehiculo
     * @param output Hora de salida del vehiculo
     * @return Devuelve el valor a pagar en el parqueadero
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long valor;
        long tiempoParqueado = Duration.between(input, output).toMinutes();
        double pago = 0;
        if (tiempoParqueado <= 60) {
            pago = 1000;
        } else if (tiempoParqueado > 60) {
            pago = 1000 + (((tiempoParqueado - 60) * 500) / 60);
        }
        return Utilities.redondear((int) pago);
    }
    
}
