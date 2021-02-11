package Main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

import Models.*;
/**
 * @author Christian Rivas Pottier
 *
 */
public class Taller {

	
	static void taller() {
		LinkedList<Vehiculo> listaVehiculos = new LinkedList<Vehiculo>();
		LinkedList<Conductor> listaConductores = new LinkedList<Conductor>();
		
		boolean exit = false;
		String [] opciones = {""};
		int opcionElegida;
 		
		/*
		 * A. Opcion crear nuevo usuario.
		 *  
		 *  1. Crear Titular
		 * 
		 *  2. Crear vehiculo
		 * 
		 *  3. ¿Vas a ser conductor del vehiculo?
		 * 	 A. Si. Nuevo conductor con datos del titular
		 * 	 B. No. Crear nuevo conductor.
		 * 
		 * B. Opcion crear nuevo vehiculo.
		 * 
		 *  1. Crea vehiculo
		 * 
		 *  2. Crear Titular
		 * 
		 */
		do {
			opcionElegida = darOpciones(opciones,"Elige un vehiculo");	
			
		}while(!exit);
	}
	
	
	
	/**
	 * 
	 */
	
	static Conductor crearConductor() {
		String nombre, apellido, fechaNacimiento,licencia;
		String [] listaLicencias = {"A","B","C","A+B","B+C","A+B+C"}; 
		String [] opciones = {"Si","No"};
		
		nombre = solicitarDatosString("Nombre: ");
		apellido = solicitarDatosString("Apellido: ");
		fechaNacimiento = solicitarDatosString("Fecha de Nacimiento: ");
		licencia = (String) menuDesplegable("Elige tipo de licencia: ", listaLicencias);
		
		return new Conductor(nombre,apellido,fechaNacimiento, new Licencia(new Random().nextInt(1000),
				licencia,nombre + " " + apellido,fechaNacimiento ));
	}
	
	/**
	 * 
	 */
	
	static Titular crearTitular() {
		String nombre, apellido, fechaNacimiento,licencia;
		boolean seguro, garaje;
		String [] listaLicencias = {"A","B","C","A+B","B+C","A+B+C"}; 
		String [] opciones = {"Si","No"};
		
		nombre = solicitarDatosString("Nombre: ");
		apellido = solicitarDatosString("Apellido: ");
		fechaNacimiento = solicitarDatosString("Fecha de Nacimiento: ");
		licencia = (String) menuDesplegable("Elige tipo de licencia: ", listaLicencias);
		seguro = (darOpciones(opciones,"¿Tienes seguro?") == 0) ? true:false;	
		garaje = (darOpciones(opciones,"¿Tiene garaje?")) == 0 ? true:false;	
		
		
		return new Titular(nombre,apellido,fechaNacimiento, new Licencia(new Random().nextInt(1000),
				licencia,nombre + " " + apellido,fechaNacimiento ),seguro,garaje);
	}
	
	/**
	 * 
	 */
	
	static Vehiculo crearVehiculo(Licencia licencia) {
		int opcionVehiculo;
		double diamDel,diamTra;
		boolean exit = false;
		String matricula,marca,color;
		String marcaRueda [] = {"Michellin","Goodyear","Dunlop","Firestone","Bridgestone","Hankook","Kumho"};
		String tipoVehiculo [] = {"Moto", "Coche","Camión"};
		String marcasCoches [] = {"BMW","Audi","Renault", "Dacia", "Mercedes", "Seat"};
		String colores [] = {"Azul","Amarillo","Rojo","Blanco","Negro","Fucsia","Morado","Verde"};
		
		// Tipo de motos
		String marcasMotos [] = {"BMW","Kawasaki","Harley-Davidson", "Ducati", "Suzuki", "Honda"};
		
		Vehiculo nuevoVehiculo = null;
		Rueda ruedas = null;

		opcionVehiculo = darOpciones(tipoLicencia(licencia.getTipoLicencia()),"Elige un vehiculo");		
		
		do {
			matricula = solicitarDatosString("Dime tu matricula");
			if(comprobarMatricula(matricula)) {
				mostrarInfo("Introduzca una matricula valida.");
			}
		}while(comprobarMatricula(matricula));
		
		
		marca =  menuDesplegable("Elige una marca: ", marcasCoches);
		color =  menuDesplegable("Elige un color", colores);
		
		
		do {
			diamDel = solicitarDatosDouble("Dame el diametro para las ruedas delanteras.(Diametro valido 0.4 al 4)");
			diamTra = solicitarDatosDouble("Dame el diametro para las ruedas traseras.(Diametro valido 0.4 al 4)");
			
			if(comprobarRueda(diamDel) && comprobarRueda(diamTra)) {
				ruedas = new Rueda((String) menuDesplegable("Elige una marca: ", marcaRueda),
						diamDel,diamTra);
				exit = true;
			}
		}while(!exit);
		
		
		switch(opcionVehiculo) {
		case 0: // coche
			nuevoVehiculo = new Coche(matricula,color,marca,ruedas);
			break;
		case 1: // moto
			nuevoVehiculo = new Moto(matricula,color,marca,ruedas);
			break;	
		case 2: // camion
			nuevoVehiculo = new Camion(matricula,color,marca,ruedas);
			break;	
		}
		
		return nuevoVehiculo;
	}
	
	
	
	/**
	 * Métodos Auxiliares.
	 */
	
	public static String [] tipoLicencia(String licencia) {
		HashMap<String, String> lista = new HashMap<>() {{
			put("A","Moto");
			put("B","Moto:Coche");
			put("C","Moto:Coche");
			put("A+B","Moto:Coche");
			put("B+C","Moto:Coche");
			put("A+B+C","Moto:Coche");
		}};
		
		return lista.get(licencia).split(":");
	}
	
	public static boolean comprobarRueda(double diametro) {
		return ((diametro >= 0.4) && (diametro <= 4)) ? true:false;
	}
	
	public static boolean comprobarMatricula(String matricula) {
		return (matricula.matches("^[0-9]{4}[aA-zZ]{2,3}")) ? false:true;
	}
	
	public static String solicitarDatosString(String texto) {
		return JOptionPane.showInputDialog(texto);
	}
	
	public static double solicitarDatosDouble(String texto) {
		String strNum = "";
		do {
			strNum = JOptionPane.showInputDialog(texto);
		} while (!esNumero(strNum));
		return Double.parseDouble(strNum);
	}
	
	public static int darOpciones(String [] opciones, String textoOpciones) {
		int opcion = JOptionPane.showOptionDialog(
				   null,
				   textoOpciones, 
				   "Selector de opciones",
				   JOptionPane.YES_NO_CANCEL_OPTION,
				   JOptionPane.QUESTION_MESSAGE,
				   null, 
				   opciones,   
				   opciones[0]);
		return opcion;
	}
	
	public static void mostrarInfo(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	
	public static String menuDesplegable(String texto, String [] opciones) {
		Object opcion = JOptionPane.showInputDialog(null, texto, "Elegir",
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		return (String) opcion;
	}
	
	public static boolean esNumero(String strNum) {
		boolean esNum = true;

		if (strNum == null) 
			esNum = false;
		else
			try {
				Double.parseDouble(strNum);
			} catch (NumberFormatException e) {
				esNum = false;
			}

		return esNum;
	}
	
	

}
