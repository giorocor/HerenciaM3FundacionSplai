/**
 * 
 */
package Models;

import java.util.LinkedList;

/**
 * @author Christian Rivas Pottier
 *
 */
public class Moto extends Vehiculo {

	/**
	 * @param matricula
	 * @param color
	 * @param marca
	 * @param ruedas
	 */
	public Moto(String matricula, String color, String marca, Rueda ruedas) {
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
	public Moto(String matricula, String color, String marca, Rueda ruedas, Titular titular,
			LinkedList<Conductor> conductores) {
		super(matricula, color, marca, ruedas, titular, conductores);
	}


}
