package com.zubiri.parking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
 
public class Prueba {
 
  public static void main(String args[]) throws UnsupportedEncodingException, FileNotFoundException, IOException {
	  
	  ParkingVehiculos.borrarVehiculosFichero("0000AAA");
  }
}