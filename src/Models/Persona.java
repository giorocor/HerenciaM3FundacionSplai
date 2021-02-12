package Models;

public abstract class Persona {

	protected String nombre;
	protected String apellido;
	protected String fechaNacimiento;
	protected Licencia licencia;
	
	
	public Persona(String nombre, String apellido, String fechaNacimiento, Licencia licencia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.licencia = licencia;
	}


	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Licencia getLicencia() {
		return licencia;
	}


	@Override
	public String toString() {
		return "Persona [nomnbre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", licencia=" + licencia + "]";
	}
	
	
}
