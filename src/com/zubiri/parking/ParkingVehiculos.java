package com.zubiri.parking;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingVehiculos {
	
	private static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	
	public ParkingVehiculos() {
		
	}
	
	public ParkingVehiculos(Scanner sc) throws Exception {
		
		int seleccion = -1;
		
		do {
			try {
				System.out.println("Cuantos vehiculos quieres insertar? ");
				seleccion = sc.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Introduce un número");
				sc.nextLine();
			}
		} while (seleccion < 0);
		
		for (int i = 0; i < seleccion; i++) {
			int seleccionvehiculo = 0;
			do {
				try {
					System.out.println("Que quieres insertar?");
					System.out.println("BICICLETA:--------1");
					System.out.println("COCHE:----------2");

					seleccionvehiculo = sc.nextInt();
				
					switch(seleccionvehiculo) {
						case 1:
							Bicicleta bicicleta = new Bicicleta(sc);
							vehiculos.add(bicicleta);
							break;
						case 2:
							Coche coche = new Coche(sc);
							vehiculos.add(coche);
							break;
						default:
							System.out.println("No ha insertado la opcion correcta.");
							break;			
					}
				} catch (InputMismatchException e){
					System.out.println("Eso no es numero");
					sc.nextLine();
				}	
			} while (seleccionvehiculo == 0);
		}		
	}

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
	public static void modificarVehiculo(String matricula) {
		for(int i=0; i<vehiculos.size(); i++) {
			if (vehiculos.get(i).getMatricula().equalsIgnoreCase(matricula)) {
				Scanner sc = new Scanner(System.in);
				Coche coche = new Coche(sc);
				vehiculos.set(i, coche);
			}
		}
	}
	
	// Borrar	
	public static void borrarVehiculo(String matricula){
		for (int b = 0; b < vehiculos.size(); b++) {
			if (vehiculos.get(b).getMatricula().equalsIgnoreCase(matricula)) {
				vehiculos.remove(b);
			}
		}
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
		String parkingStr = "";
		
		for (int i = 0; i < vehiculos.size(); i++) {
			parkingStr += vehiculos.get(i).formatted();
		}

		return parkingStr;
	}
}
