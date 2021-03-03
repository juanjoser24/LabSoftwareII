/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 * * Interfaz para calcular el costo del parqueadero de cualquier tipo de vehiculo:
 * carro, moto, camion
 *
 * Integrantes:
 * Javier Rojas
 * Juan José Rengifo
 */

    
public interface IParkingCost {
    /**
     * Calcula el costo del parqueadero de un vehiculo dependiendo su tipo: MOTO, CAR, TRUCK
     * 
     * @param veh vehiculo que estuvo en el parqueadero
     * @param input hora de entrada del vehiculo
     * @param output hora de salida del vehiculo
     * @return Devuelve el valor a pagar por el parqueadero del vehiculo
     */
    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
    
    
    

