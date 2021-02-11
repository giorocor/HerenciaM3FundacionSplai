package Main;

/**
 * @author User
 *
 */
public class Taller {

	/**
	 * 
	 */
	static void taller() {
		System.out.println("El taller");
	}
	
	public boolean comprovarMatricula(String matricula) {
		return (matricula.matches("^[0-9]{4}[aA-zZ]{2,3}"))?true:false;
	}

}
