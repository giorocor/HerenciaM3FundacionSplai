/**
 * 
 */
package Models;

import java.util.LinkedList;

public abstract class Vehiculo {
	protected String matricula;
	protected String color;
	protected String marca;
	protected Rueda ruedas;
	protected Titular titular;
	protected LinkedList<Conductor> conductores;
	
//CONSTRUCTOR-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @param matricula
	 * @param color
	 * @param marca
	 * @param ruedas
	 */
	public Vehiculo(String matricula, String color, String marca, Rueda ruedas) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.ruedas = ruedas;
		this.titular = new Titular(marca, marca, marca, null, false, false);
		this.conductores = new LinkedList<Conductor>();
	}
	
	
	
	/**
	 * @param matricula
	 * @param color
	 * @param marca
	 * @param ruedas
	 * @param titular
	 * @param conductores
	 */
	public Vehiculo(String matricula, String color, String marca, Rueda ruedas, Titular titular,
			LinkedList<Conductor> conductores) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.ruedas = ruedas;
		this.titular = titular;
		this.conductores = conductores;
	}
	
	
//GETTERS SETTERS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * @param matricula
	 * @param color
	 * @param marca
	 * @param ruedas
	 * @param titular
	 * @param conductores
	 */
	
	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the ruedas
	 */
	public Rueda getRuedas() {
		return ruedas;
	}
	/**
	 * @param ruedas the ruedas to set
	 */
	public void setRuedas(Rueda ruedas) {
		this.ruedas = ruedas;
	}


	/**
	 * @return the titular
	 */
	public Titular getTitular() {
		return titular;
	}


	/**
	 * @param titular the titular to set
	 */
	public void setTitular(Titular titular) {
		this.titular = titular;
	}


	/**
	 * @return the conductores
	 */
	public LinkedList<Conductor> getConductores() {
		return conductores;
	}


	/**
	 * @param conductores the conductores to set
	 */
	public void setConductores(LinkedList<Conductor> conductores) {
		this.conductores = conductores;
	}	
	
	
	/**
	 * @param conductor
	 */
	public void addConductor(Conductor conductor) {
		this.conductores.add(conductor);
	}
	
	
}
