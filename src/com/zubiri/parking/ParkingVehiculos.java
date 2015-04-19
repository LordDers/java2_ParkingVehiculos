package com.zubiri.parking;

import java.util.ArrayList;

public class ParkingVehiculos {
	
	private static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

	public static ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public static void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		ParkingVehiculos.vehiculos = vehiculos;
	}

	// Añadir
	public static void anyadirVehiculo(Vehiculo vehiculo){
		vehiculos.add(vehiculo);
	}
	
	public static void anyadirCoche(Coche coche){
		vehiculos.add(coche);
	}
	
	public static void anyadirBicicleta(Bicicleta bicicleta){
		vehiculos.add(bicicleta);
	}
	
	// Buscar
	public static void buscarVehiculo(String matricula) {
		int i;
		
		for(i =0; i<vehiculos.size(); i++) {
			if (vehiculos.get(i).getMatricula().equalsIgnoreCase(matricula)) {
				System.out.println(vehiculos.get(i).formatted());
				break;
			}
		}
		if (i == vehiculos.size()) {
			System.out.println("No se ha encontrado la matricula");
		}
	}
	
	// Modificar
	public void modificarVehiculo(String matricula) {
		
	}
	
	// Borrar
	public static void borrarVehiculo(String matricula){
		vehiculos.remove(matricula);
	}
	
	// Mostrar
	public static void mostrarParkingVehiculos() {
		if (getVehiculos().size() == 0) {
			System.out.println("No se han cargado los vehículos");
		}
		
		for (int i=0; i<getVehiculos().size(); i++) {
			Vehiculo vehi = getVehiculos().get(i);
			vehi.mostrarVehiculo();
			System.out.println();
		}
	}
	
	public String formattedParkingVehiculos() {
		String parkingStr = null;
		
		for (int i = 0; i < vehiculos.size(); i++) {
			parkingStr += vehiculos.get(i).formatted() + "\n";
		}

		return parkingStr;
	}
}
