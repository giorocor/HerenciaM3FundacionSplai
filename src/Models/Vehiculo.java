/**
 * 
 */
package Models;

/**
 * @author User
 *
 */
public abstract class Vehiculo {
	protected String matricula;
	protected String color;
	protected String marca;
	protected Rueda ruedas;
	
//CONSTRUCTOR-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public Vehiculo(String matricula, String color, String marca, Rueda ruedas) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.ruedas = ruedas;
	}
	
	
//METODOS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	

		
	
//GETTERS SETTERS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}
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
	
}
