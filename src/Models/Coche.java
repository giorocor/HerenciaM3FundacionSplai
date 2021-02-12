/**
 * 
 */
package Models;

import java.util.LinkedList;

public class Coche extends Vehiculo {

	
	/**
	 * @param matricula
	 * @param color
	 * @param marca
	 * @param ruedas
	 */
	public Coche(String matricula, String color, String marca, Rueda ruedas) {
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
	public Coche(String matricula, String color, String marca, Rueda ruedas, Titular titular,
			LinkedList<Conductor> conductores) {
		super(matricula, color, marca, ruedas, titular, conductores);
	}


}
