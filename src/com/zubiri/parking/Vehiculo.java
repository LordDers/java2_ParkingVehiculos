package com.zubiri.parking;

import java.util.Scanner;

public abstract class Vehiculo {

	int numRuedas = 0;
	boolean motor = false;
	String marca = null;
	String matricula = null;

	//Constructores
	public Vehiculo() {
		
	}
	
	public Vehiculo(int numRuedas, boolean motor, String marca, String matricula) {
		this.numRuedas = numRuedas;
		this.motor = motor;
		this.marca = marca;
		this.matricula = matricula;
	}
	
	public Vehiculo(Scanner sc) {
		System.out.println("Vehículo");
		System.out.print("Matricula: ");
		this.setMatricula(sc.next());
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
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	//Otros métodos
	public String formatted() {
		//String formatted = null;
		String formatted =
			"Matricula: " + this.matricula + "\n" +
			"Marca: " + this.marca + "\n" +
			"Número de ruedas: " + this.numRuedas + "\n";
			if (motor) {
				formatted += "Tiene motor";
			}
			else {
				formatted += "NO tiene motor";
			}
				
		return formatted;
	}
	
	public void mostrarVehiculo() {
		System.out.println("Matricula: " + this.getMatricula());
		System.out.println("Marca: " + this.getMarca());
		System.out.println("Número de ruedas: " + this.getNumRuedas());
		if (motor) {
			System.out.println("Tiene motor");
		} else {
			System.out.println("NO tiene motor");
		}
	}
}
