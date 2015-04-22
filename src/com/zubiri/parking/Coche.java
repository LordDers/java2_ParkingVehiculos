package com.zubiri.parking;

import java.util.Scanner;

public class Coche extends Vehiculo {

	boolean automatico = false;
	int consumo100km = 0;
	
	//Constructores
	public Coche() {
		
	}
	
	public Coche(int numRuedas, boolean motor, String marca, String matricula, boolean automatico, int consumo100km) {
		super(numRuedas, motor, marca, matricula);
		this.automatico = automatico;
		this.consumo100km = consumo100km;
	}
	
	public Coche(Scanner sc) {
		super(sc);
		//System.out.println("Coche");
		System.out.print("¿Es automático? (S/N) ");
		switch(sc.next()) {
			case "S":
				this.setAutomatico(true);
				break;
			case "N":
				this.setAutomatico(false);
				break;
			default:
				System.out.println("No ha seleccionado la opción correcta");
		}
		System.out.print("Consumo en 100km: ");
		this.setConsumo100km(sc.nextInt());
	}
	
	//Métodos getter y setter
	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	public int getConsumo100km() {
		return consumo100km;
	}

	public void setConsumo100km(int consumo100km) {
		this.consumo100km = consumo100km;
	}

	//Otros métodos
	double calcConsumo(int numKm, double precioGasoil) {
		double consumoTotal = 0;
		
		consumoTotal = (numKm * precioGasoil);    	
    	
		return consumoTotal;
	}
    
	@Override
	public String formatted() {
		String formatted = 
		super.formatted() + "\n";
		if (automatico) {
			formatted += "Es automático\n";
		} else {
			formatted += "NO es automático\n";
		}
		formatted += "Consumo en 100km: " + this.consumo100km + "\n";
				
		return formatted;
	}
	
	@Override
	public void mostrarVehiculo() {
		super.mostrarVehiculo();
		if (automatico) {
			System.out.println("Es automático");
		} else {
			System.out.println("NO es automático");
		}
		System.out.println("Consumo en 100km: " + this.consumo100km + "\n");
	}
}
