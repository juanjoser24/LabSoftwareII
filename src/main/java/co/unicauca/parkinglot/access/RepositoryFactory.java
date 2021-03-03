/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

/**
 * Fábrica que utiliza el patrón de diseño Singleton para generar una instancia
 * de la interfaz IVehicleRepository
 *
 * Integrantes:
 * Javier Rojas
 * Juan José Rengifo
 */
public class RepositoryFactory {
    
    // Singleton
    private static RepositoryFactory instance;
    
    /**
     * Constructor por Defecto de RepositoryFactory
     */
    private RepositoryFactory(){
        
    }
    
    /**
     * Método que obtiene la instancia de la clase RepositoryFactory
     * @return Devuelve la instancia unica de ParkingCostFactory 
     */
    public static RepositoryFactory getInstance(){
        
        if (instance==null) {
            instance=new RepositoryFactory();
        }
        return instance;
    }
    
    /**
     * Determina la clase que se encargara de guardar el vehiculo en la base de datos
     * @param type El tipo de almacenamiento que se usara para guardar el vehiculo
     * @return La clase encarga de guardar el vehiculo en la base de datos
     */
    public IVehicleRepository getRepository(String type){
        
        IVehicleRepository vehicleRepository=null;
        
        switch (type){
            case "default":
                vehicleRepository = new VehicleRepository();
                break;
        }
        return vehicleRepository;
    }
}
