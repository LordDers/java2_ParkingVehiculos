package com.zubiri.parking;

import java.util.ArrayList;
import java.util.Scanner;

public class ParkingVehiculos {
	
	private static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

	public static ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public static void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		ParkingVehiculos.vehiculos = vehiculos;
	}

	public static ArrayList<Vehiculo> introducirVehiculos(Scanner sc){
		System.out.println("¿Cuántos vehículos desea introducir?");
		int numVehiculo=sc.nextInt();
		for (int i = 0; i < numVehiculo; i++) {
			System.out.println("¿Qué quieres introducir? (coche/vehiculo)");
			switch (sc.next()) {
			case "coche":
				vehiculos.add(new Coche(sc));
				break;

			case "bicicleta":
				vehiculos.add(new Bicicleta(sc));
				break;
			}
		}
		
		return vehiculos;
	}
	
	public void anyadirCoche(Coche coche) {
		vehiculos.add(coche);
	}
	
	public void anyadirBicicleta(Bicicleta bicicleta) {
		vehiculos.add(bicicleta);
	}
	
	public static void borrarVehiculo(String vehiculo){
		vehiculos.remove(vehiculo);
	}
	
	public static Vehiculo buscarArtista(String nombre){
		Artista artista = null;
		if (artistas == null) {
			System.out.println("No se han cargado artistas en la lista....");
		}else {
			for (int i = 0; i < artistas.size(); i++) {
				if (artistas.get(i).getNombre().equalsIgnoreCase(nombre)) {
					artista = artistas.get(i);
				}
			}
		}
		return artista;
	}
}
