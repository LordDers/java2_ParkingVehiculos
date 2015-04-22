import com.zubiri.parking.ParkingVehiculos;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		int seleccion = -1;
		Scanner sc = new Scanner(System.in);
		
		ParkingVehiculos pv = new ParkingVehiculos();
		
		do {
			System.out.println("Añadir vehiculo----------------------------------1");
			System.out.println("Mostrar vehiculos--------------------------------2");
			System.out.println("Buscar vehiculo----------------------------------3");
			System.out.println("Borrar vehiculo----------------------------------4");
			System.out.println("Modificar vehiculo-------------------------------5");
			System.out.println("SALIR DEL PROGRAMA-------------------------------6");
			   
			seleccion = sc.nextInt();
			switch (seleccion) {
				
				case 1: // Añadir vehículos
					ParkingVehiculos pv2 = new ParkingVehiculos(sc);
					break;
				case 2: // Mostrar vehículos
					System.out.println(pv.formattedParkingVehiculos());
					break;
				case 3: // Buscar vehículo
					System.out.print("Matricula a buscar: ");
					ParkingVehiculos.buscarVehiculo(sc.next());
					break;
				case 4: // Borrar vehículo
					System.out.print("Introduce la matricula del coche a borrar: ");
					ParkingVehiculos.borrarVehiculo(sc.next());
					break;
				case 5: // Modificar vehículo
					System.out.print("Introduce la matricula del coche a modificar: ");
					ParkingVehiculos.modificarVehiculo(sc.next());
					break;
				case 6: //Salimos
					break;
				default:
					System.out.println("No ha insertado la opción correcta");
			}
		} while (seleccion != 0);
	}
}