/**
 * 
 */
package Test;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Models.*;


public class Test {
	
	public static int darOpciones(String[] opciones, String textoOpciones) {
		int opcion = JOptionPane.showOptionDialog(null, textoOpciones, "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		return opcion;
	}
	
	public static LinkedList<Vehiculo> cargarVehiculos() {
		LinkedList<Vehiculo> vehiculos = new LinkedList<>() {{
			add(new Coche("1234ABC","Rojo","BMW", new Rueda("Michellin",1,1)));
			add(new Moto("3234BC","Amarillo","Kawasaki", new Rueda("Goodyear",1,1)));
			add(new Camion("4321ZBQ","Azul","Man", new Rueda("Dunlop",1,1)));
			add(new Coche("6534QZ","Blanco","Audi", new Rueda("Firestone",1,1)));
			add(new Moto("1654QZQ","Verde","Ducati", new Rueda("Bridgestone",1,1)));
			add(new Moto("0000ZZZ","Negro","Suzuki", new Rueda("Hankook",1,1)));
			add(new Coche("6421TOP","Rojo","Seat", new Rueda("Kumho",1,1)));	
		}};
		
		return vehiculos;
	}
	
	public static LinkedList<Titular> cargarTitular() {
		LinkedList<Titular> titular = new LinkedList<>() {{
			add(new Titular("Miguel","Sastre","18021993",new Licencia(1,"A","Miguel","2021"),false,false));
			add(new Titular("Geralt","De Rivia","1874",new Licencia(1,"B","Geralt","2021"),false,false));
			add(new Titular("Yennefer","Vengerberg","18021993",new Licencia(1,"C","Yennefer","2021"),false,false));
			add(new Titular("Cirilla"," Fiona Elen Riannon","18021993",new Licencia(1,"A+B","Cirilla","2021"),false,false));
		}};
		
		return titular;
	}
	
	public static LinkedList<Conductor> cargarConductor() {
		LinkedList<Conductor> conductor = new LinkedList<>() {{
			add(new Conductor("Miguel","Sastre","18021993",new Licencia(1,"A","Miguel","2021")));
			add(new Conductor("Geralt","De Rivia","1874",new Licencia(1,"B","Geralt","2021")));
			add(new Conductor("Yennefer","Vengerberg","18021993",new Licencia(1,"C","Yennefer","2021")));
			add(new Conductor("Cirilla"," Fiona Elen Riannon","18021993",new Licencia(1,"A+B","Cirilla","2021")));
		}};
		
		return conductor;
	}
}
