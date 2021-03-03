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
 * Clase que calcula el valor a pagar para el vehiculo de tipo: truck
 * 
 * Integrantes:
 * Javier Rojas
 * Juan José Rengifo
 */
public class TruckParkingCost implements IParkingCost {

    /**
     * Calcula el costo que debe pagar un vehiculo de tipo MOTO en un
     * parqueadero
     *
     * @param veh Vehiculo que estuvo en el parqueadero
     * @param input Hora de entrada del vehiculo
     * @param output Hora de salida del vehiculo
     * @return Devuelve el valor a pagar en el parqueadero
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long valor, residuo;
        int dias = 0, horas = 0;
        long tiempoParqueado = Duration.between(input, output).toMinutes();
        double pago = 0;
        if (tiempoParqueado <= 1440 && tiempoParqueado > 720) {
            pago = 15000;
        } else if (tiempoParqueado <= 720) {
            pago = 10000;
        } else if (tiempoParqueado > 1440) {
            // pago=15000+(((tiempoParqueado-1440)*15000)/1440);

            dias = (int) (tiempoParqueado / 1440);
            tiempoParqueado = tiempoParqueado - (dias * 1440);

            horas = (int) (tiempoParqueado / 60);
            tiempoParqueado = tiempoParqueado - (horas * 60);

            dias = dias * 15000;
            horas = horas * 625;
            pago = dias + horas;

        }
        return Utilities.redondear((int) pago);
    }

}
