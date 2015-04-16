package com.zubiri.parking;

import java.util.Scanner;

public abstract class Vehiculo {

	int numRuedas = 0;
	boolean motor = false;
	String marca = null;

	//Constructores
	public Vehiculo(int numRuedas, boolean motor, String marca) {
		this.numRuedas = numRuedas;
		this.motor = motor;
		this.marca = marca;
	}
	
	public Vehiculo(Scanner sc) {
		System.out.println("Vehículo");
		System.out.print("Número de ruedas: ");
		this.setNumRuedas(sc.nextInt());
		System.out.print("¿Tiene motor? (S/N) ");
		switch(sc.next()) {
			case "S":
				this.setMotor(true);
				break;
			case "N":
				this.setMotor(false);
				break;
			default:
				System.out.println("No ha seleccionado la opción correcta");
		}
		System.out.print("Marca del vehículo: ");
		this.setMarca(sc.next());
	}
	
	//Métodos getter y setter
	public int getNumRuedas() {
		return numRuedas;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}

	public boolean isMotor() {
		return motor;
	}

	public void setMotor(boolean motor) {
		this.motor = motor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	//Otros métodos
	public String formatted() {
		//String formatted = null;
		String formatted =
				"Marca: " + this.marca + "\n" +
				"Número de ruedas: " + this.numRuedas + "\n";
				if (motor) {
					formatted += "Tiene motor\n";
				}
				else {
					formatted += "NO tiene motor\n";
				}
				
		return formatted;
	}
}
