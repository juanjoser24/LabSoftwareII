/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 * Intefaz encargada de definir los métodos para almacenar los vehiculos en la base de datos
 *
 * Integrantes:
 * Javier Rojas
 * Juan José Rengifo
 */

public interface IVehicleRepository {
    /**
     * Definicion del método para almacenar un nuevo vehiculo en la base de datos
     * @param newVehicle Nuevo vehiculo que se va a almacenar
     * @return Verdadero si se pudo almacenar correctamente el vehiculo en la base de datos, Falso sino
     */
    public boolean save(Vehicle newVehicle );
    
    /**
     * Método para obtener la lista donde se encuentran todos los vehiculos que hayan sido almacenados
     * @return La lista de los vehiculos almacenados
     */
    public List<Vehicle>list();
    
    
}
