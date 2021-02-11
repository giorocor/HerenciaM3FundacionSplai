/**
 * 
 */
package Main;

/**
 * @author Christian Rivas Pottier
 *
 */
public class Taller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	public boolean comprovarMatricula(String matricula) {
		return (matricula.matches("^[0-9]{4}[aA-zZ]{2,3}"))?true:false;
	}

}
