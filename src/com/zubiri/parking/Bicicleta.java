package com.zubiri.parking;

import java.util.Scanner;

public final class Bicicleta extends Vehiculo {

	int numPinyones = 0;
	String tipo = null; //Donde los tipos posibles son "montanya", "paseo" o "carreras"

	//Constructores
	public Bicicleta(int numRuedas, boolean motor, String marca, int numPinyones, String tipo) {
		super(numRuedas, motor, marca);
		this.numPinyones = numPinyones;
		this.tipo = tipo;
	}
	
	public Bicicleta(Scanner sc) {
		super(sc);
		System.out.println("Bicicleta");
		System.out.print("Número de pinyones: ");
		this.setNumPinyones(sc.nextInt());
		System.out.print("Tipo (montanya, paseo, carreras): ");
		try {
			this.setTipo(sc.next());
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	//Métodos getter y setter
	public int getNumPinyones() {
		return numPinyones;
	}
	
	public void setNumPinyones(int numPinyones) {
		this.numPinyones = numPinyones;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) throws Exception {
			switch(tipo) {
				case "montanya":
				case "paseo":
				case "carreras":
					this.tipo = tipo;
					break;
				default:
					throw new Exception("Tipo de bicicleta permitido: montanya, paseo y carreras");
			}
	}
	
	//Otros métodos
	@Override
    public String formatted() {
		String formatted = 
		super.formatted() + "\n" +
		"Tipo bicicleta: " + this.tipo + "\n" + 
		"Número de pinyones: " + this.numPinyones + "\n";
				
		return formatted;
	}
}
