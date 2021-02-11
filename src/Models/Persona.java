package Models;

public abstract class Persona {

	protected String nomnbre;
	protected String apellido;
	protected String fechaNacimiento;
	protected String licencia;
	
	
	public Persona(String nomnbre, String apellido, String fechaNacimiento, String licencia) {
		super();
		this.nomnbre = nomnbre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.licencia = licencia;
	}


	public String getNomnbre() {
		return nomnbre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getLicencia() {
		return licencia;
	}


	@Override
	public String toString() {
		return "Persona [nomnbre=" + nomnbre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", licencia=" + licencia + "]";
	}
	
	
}
