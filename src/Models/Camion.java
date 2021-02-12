/**
 * 
 */
package Models;

import java.util.LinkedList;

public class Camion extends Vehiculo {

	/**
	 * @param matricula
	 * @param color
	 * @param marca
	 * @param ruedas
	 */
	
	public Camion(String matricula, String color, String marca, Rueda ruedas) {
		super(matricula, color, marca, ruedas);
	}
	
	
	/**
	 * @param matricula
	 * @param color
	 * @param marca
	 * @param ruedas
	 * @param titular
	 * @param conductores
	 */
	public Camion(String matricula, String color, String marca, Rueda ruedas, Titular titular,
			LinkedList<Conductor> conductores) {
		super(matricula, color, marca, ruedas, titular, conductores);
	}
	
	
}
