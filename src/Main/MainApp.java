package Main;

import Models.*;
import Test.Test;


public class MainApp {
	
	
	public static void main(String [] args) {
		Taller tallerSinDatos = new Taller(null,null,null);
		Taller tallerConDatos = new Taller(Test.cargarVehiculos(),Test.cargarTitular(),Test.cargarConductor());
		int opcion = Test.darOpciones(new String[] {"Test vacio","Test con datos"},"Elige una opción");
		
		switch(opcion) {
		case 0:
			tallerSinDatos.taller();
			break;
		case 1:
			tallerConDatos.taller();
			break;
		}
		
		
	}
	
	
}
 