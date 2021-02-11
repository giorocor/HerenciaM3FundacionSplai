package Models;



public class Licencia {
	private int id;
	private String tipoLicencia;
	private String nombre;
	private String fechaCaducidad;
	
	public Licencia(int id, String tipoLicencia, String nombre, String fechaCaducidad) {
		super();
		this.id = id;
		this.tipoLicencia = tipoLicencia;
		this.nombre = nombre;
		this.fechaCaducidad = fechaCaducidad;
	}
	
	
}
