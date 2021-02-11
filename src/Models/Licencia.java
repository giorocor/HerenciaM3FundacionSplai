package Models;


public class Licencia {
	private int id;
	private String tipoLicencia;
	private String nombre;
	private String fechaCaducidad;
	
	public Licencia(int id, String tipoLicencia, String nombre, String fechaCaducidad) {
		this.id = id;
		this.tipoLicencia = tipoLicencia;
		this.nombre = nombre;
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoLicencia() {
		return tipoLicencia;
	}

	public void setTipoLicencia(String tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	
	
	
}
