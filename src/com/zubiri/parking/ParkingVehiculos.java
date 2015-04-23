package com.zubiri.parking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	public static void buscarVehiculoVoid(String matricula) {
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
	
	public static Vehiculo buscarVehiculo(String matricula) {
		int i;
		int posicion=-1;
		for(i =0; i<vehiculos.size(); i++) {
			if (vehiculos.get(i).getMatricula().equalsIgnoreCase(matricula)) {
				posicion=i;
				break;
			}
		}
		if (i == vehiculos.size()) {
			System.out.println("No se ha encontrado la matricula");
		}
		return vehiculos.get(posicion);
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
		}
	}
	
	public static String formattedParkingVehiculos() {
		String parkingStr = "";
		
		for (int i = 0; i < vehiculos.size(); i++) {
			parkingStr += vehiculos.get(i).formatted();
		}

		return parkingStr;
	}
	
	
	// Ficheros
	public static final void leerVehiculos() {
		// Leer "vehiculos.txt"
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("ficheros/vehiculos.txt"));

			String linea2 = br2.readLine();
			String [] camposSeparados2 = null;

			while (linea2 != null) {

				Coche coche = new Coche();

				camposSeparados2 = linea2.split(", ");

				coche.setNumRuedas(Integer.parseInt(camposSeparados2[0]));
				coche.setMotor(Boolean.parseBoolean(camposSeparados2[1]));
				coche.setMarca(camposSeparados2[2]);
				coche.setMatricula(camposSeparados2[3]);
				coche.setAutomatico(Boolean.parseBoolean(camposSeparados2[4]));
				coche.setConsumo100km(Integer.parseInt(camposSeparados2[5]));
				
				vehiculos.add(coche);

				linea2 = br2.readLine();
			}
			br2.close();
			
		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}
	}
	
	public static final ArrayList<Vehiculo> leerVehiculos2() {
		// Leer "vehiculos.txt"
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("/home/zubiri/ProyectosJava/GestionesParking/WebContent/ficheros/vehiculos.txt"));

			String linea2 = br2.readLine();
			String [] camposSeparados2 = null;

			while (linea2 != null) {

				Coche coche = new Coche();

				camposSeparados2 = linea2.split(", ");

				coche.setNumRuedas(Integer.parseInt(camposSeparados2[0]));
				coche.setMotor(Boolean.parseBoolean(camposSeparados2[1]));
				coche.setMarca(camposSeparados2[2]);
				coche.setMatricula(camposSeparados2[3]);
				coche.setAutomatico(Boolean.parseBoolean(camposSeparados2[4]));
				coche.setConsumo100km(Integer.parseInt(camposSeparados2[5]));
				
				vehiculos.add(coche);

				linea2 = br2.readLine();
			}
			br2.close();
			
		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}
		
		return vehiculos;
	}
	
	public final static void anyadirVehiculosFichero(Coche vehiculo) throws IOException {		
		File TextFile = new File("ficheros/vehiculos.txt"); 
		FileWriter TextOut = new FileWriter(TextFile, true);
		
		TextOut.write(vehiculo.getNumRuedas() + ", ");
		if (vehiculo.isMotor()) {
			TextOut.write("true" + ", ");
		} else {
			TextOut.write("false" + ", ");
		}
		TextOut.write(vehiculo.getMarca() + ", ");
		TextOut.write(vehiculo.getMatricula() + ", ");
		if (vehiculo.isAutomatico()) {
			TextOut.write("true" + ", ");
		} else {
			TextOut.write("false, ");
		}
		TextOut.write(vehiculo.getConsumo100km() + "\n");
		TextOut.close();
	}
	
	public final static void borrarVehiculosFichero(String matricula) throws IOException {		
		try {
			String line1 = "";
			
			String file = "/home/zubiri/ProyectosJava/java2_ParkingVehiculos/ficheros/vehiculos.txt";
			File inFile = new File(file);
			
			if (!inFile.isFile()) {
				System.out.println("No existe el fichero");
				return;
			}
			
			//Construct the new file that will later be renamed to the original filename. 
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			//Read from the original file and write to the new 
			//unless content matches data to be removed.
			while ((line1 = br.readLine()) != null) {
				if(line1.indexOf(matricula)!= -1) {
					// Sólo escribiría la línea de la matrícula encontrada
					//pw.println(line1);
					//pw.flush();
				} else {
					// Esto escribe en el fichero
					pw.println(line1);
					pw.flush();
				}
			}
			pw.close();
			br.close();
					   
			//Delete the original file
			if (!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}
			
			//Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile)) {
				System.out.println("Could not rename file");
			}
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public final static void modificarVehiculosFichero(String matricula) throws IOException {		
		try {
			String line1 = "";
			
			String file = "/home/zubiri/ProyectosJava/java2_ParkingVehiculos/ficheros/vehiculos.txt";
			File inFile = new File(file);
			
			if (!inFile.isFile()) {
				System.out.println("No existe el fichero");
				return;
			}
			
			//Construct the new file that will later be renamed to the original filename. 
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			//Read from the original file and write to the new 
			//unless content matches data to be removed.
			
			int cantMatricula = 1;
			
			while ((line1 = br.readLine()) != null) {
				if(line1.indexOf(matricula)!= -1) {
					// Sólo escribiría la línea de la matrícula encontrada
					//pw.println(line1);
					//pw.flush();
				} else {
					// Esto escribe en el fichero
					
					if (cantMatricula == 1) {
						Scanner sc2 = new Scanner(System.in);
						Coche coche = new Coche(sc2);
						anyadirVehiculosFichero(coche);
						cantMatricula++;
					}
					
					pw.println(line1);
					pw.flush();
				}
			}
			pw.close();
			br.close();
					   
			//Delete the original file
			if (!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}
			
			//Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile)) {
				System.out.println("Could not rename file");
			}
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}