/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase encargada de la conexión entre las diferentes capas del proyecto
 *
 * Integrantes:
 * Javier Rojas
 * Juan José Rengifo
 */
public class Service {

    private IVehicleRepository repository;

    /**
     * Modifica el repositorio 
     * @param repo Nuevo repositorio
     */
    public Service(IVehicleRepository repo) {
        this.repository = repo;

    }

    /**
     * Calcula el valor a pagar del vehiculo usando metodos de capas inferiores
     * @param veh Vehiculo al cual se le va a calcular el valor a pagar
     * @param input hora de entreda del vehiculo
     * @param output hora de salida del vehiculo
     * @return El valor a pagar para el respectivo vehiculo
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
         long pago=0;
      
      
      if(veh.getType()==TypeEnum.TRUCK)  {
        if (Sorteo()) {
            return 0;
        }
      }
            IParkingCost parkingCost = ParkingCostFactory.getInstance().getParkingCost(veh.getType());
            pago=parkingCost.calculateCost(veh,input,output);
        
        return  pago;

    }

    /**
     * Realiza el sorteo para el vehiculo camión que va a salir del parqueadero
     * @return Verdadero si gano el sorteo, Falso sino
     */
    public boolean Sorteo() {
        int numParticipante=0;
        try {
        String num =JOptionPane.showInputDialog("ingrese el numero  entre 1 y 1000");    
        numParticipante= Integer.parseInt(num);
        } catch (Exception e) {
            
        }
        int numeroGanador = (int) (Math.random() * 1000);
        System.out.println(" el numero ganador es :"+numeroGanador+"\n el numero que ingresaste es: "+numParticipante);
        if (numParticipante == numeroGanador) {
            
            return true;
        }
        return false;
    }

    /**
     * Guarda un vehiculo en la base de datos
     * @param veh vehiculo que será almacenado
     * @return Verdadero si se almaceno el vehiculo correctamente, Falso sino
     */
    public boolean saveVehicle(Vehicle veh) {

        return repository.save(veh);
    }

    /**
     * Obtiene la lista de vehiculos almacenados
     * @return Lista de vehiculos almacenaods
     */
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = repository.list();
        return vehicles;
    }

}
