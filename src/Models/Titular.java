package Models;

public class Titular extends Persona {
	private boolean seguro;
	private boolean garaje;
	
	
	public Titular(String nomnbre, String apellido, String fechaNacimiento, Licencia licencia, boolean seguro,
			boolean garaje) {
		super(nomnbre, apellido, fechaNacimiento, licencia);
		this.seguro = seguro;
		this.garaje = garaje;
	}
	
	
}
