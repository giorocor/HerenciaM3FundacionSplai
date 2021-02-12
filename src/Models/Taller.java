package Models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * @author Christian Rivas Pottier
 *
 */
public class Taller {
	
	protected LinkedList<Vehiculo> listaVehiculos;
	protected LinkedList<Titular> listaTitulares;
	protected LinkedList<Conductor> listaConductores;
	protected int id;
	protected final int INITIAL_ID = 0;
	
	/**
	 * @param listaVehiculos
	 * @param listaTitulares
	 * @param listaConductores
	 */
	public Taller(LinkedList<Vehiculo> listaVehiculos, LinkedList<Titular> listaTitulares,
			LinkedList<Conductor> listaConductores) {
		this.listaVehiculos = listaVehiculos;
		this.listaTitulares = listaTitulares;
		this.listaConductores = listaConductores;
		this.id = INITIAL_ID;
	}



	public void taller() {
		
		boolean exit = false;
		String[] opciones = { "Crear usuario", "Crear vehiculo" };
		int opcionElegida;
		
		do {
			opcionElegida = darOpciones(opciones, "¿Que quieres hacer?");
			
			switch (opcionElegida) {
			/*
			 * Opcion de crear titulares y conductores, simplemente.
			 */
			case 0:
				if(esTitular() == 0)
					listaTitulares.add((Titular) crearUsuario (true));
				else
					listaConductores.add((Conductor) crearUsuario(false));
				break;
			/*
			 * Opcion de crear vehiculos.
			 * Luego de crear vehiculos hay que seleccionar el titular del vehiculo
			 * y si tendrá conductores. 
			*/
			case 1:
				Vehiculo nuevoVehiculo = crearVehiculo(null);
				String [] opcionSiNo  = {"Si","No"};

				if(listaTitulares.isEmpty()) 
					nuevoVehiculo.setTitular((Titular) crearUsuario (true));
				else {
					titularesDisponibles(listaTitulares, nuevoVehiculo.getClass().getSimpleName());
					int titularElegido = solicitarDatosInt("Introduzca el titular seleccionado") - 1;
					nuevoVehiculo.setTitular(listaTitulares.get(titularElegido));
					
					if(darOpciones(opcionSiNo , "¿Quieres incluirlo como conductor?") == 0 ) {
						Titular conductor = listaTitulares.get(titularElegido);
						nuevoVehiculo.addConductor(new Conductor(conductor.getNombre(), 
								conductor.getApellido(), conductor.getFechaNacimiento(), conductor.getLicencia()));
					}
					
					if(darOpciones(opcionSiNo, "¿Quieres incluir más conductores?") == 0 ) {
						if(!listaConductores.isEmpty()) {
							int conductorElegido;
							boolean exitConductor = false;
							
							do {
								conductoresDisponibles(listaConductores,nuevoVehiculo.getClass().getSimpleName());
								conductorElegido = solicitarDatosInt("Introduzca el titular seleccionado") - 1;
								nuevoVehiculo.addConductor(listaConductores.get(conductorElegido));
								
								exitConductor = (darOpciones(opcionSiNo, "¿Agregar más?") == 0) ? false : true;
							}while(!exitConductor);
					
						} else
							mostrarInfo("No hay conductores disponibles.");
					}	
					
					
				}
				listaVehiculos.add(nuevoVehiculo);
				break;
			default:
				exit = true;
				break;
			}
			
		} while (!exit);
	}

	
	
	/**
	 * Método para crear un nuevo usuario
	 */
	
	private Persona crearUsuario(boolean titular) {
		Persona nuevoUsuario = null;
		String nombre, apellido, fechaNacimiento, licencia;
		boolean seguro, garaje;
		String[] listaLicencias = { "A", "B", "C", "A+B", "B+C", "A+B+C" };
		String[] opciones = { "Si", "No" };

		nombre = solicitarDatosString("Nombre: ");
		apellido = solicitarDatosString("Apellido: ");
		fechaNacimiento = solicitarDatosString("Fecha de Nacimiento: ");
		licencia = (String) menuDesplegable(listaLicencias,"Elige tipo de licencia: ");
		
		if(titular) {
			seguro = (darOpciones(opciones, "¿Tienes seguro?") == 0) ? true : false;
			garaje = (darOpciones(opciones, "¿Tiene garaje?")) == 0 ? true : false;
			nuevoUsuario = new Titular(nombre, apellido, fechaNacimiento, 
					new Licencia(this.getId(), licencia, nombre + " " +
							apellido, fechaNacimiento), seguro,garaje);
		}else
			nuevoUsuario = new Conductor(nombre, apellido, fechaNacimiento,
					new Licencia(this.getId(), licencia, nombre + " " + apellido, fechaNacimiento));
			
		return nuevoUsuario;
	}
	

	/**
	 * Método para crear un nuevo vehiculo.
	 */


	private Vehiculo crearVehiculo(Licencia licencia) {
		
		/*
		 * Variables de control
		 */
		
		boolean exit = false;
		int opcionVehiculo;
		
		/*
		 * Variables para datos del usuario
		 */
		
		double diamDel, diamTra;
		String matricula, marca, color;
		
		Vehiculo nuevoVehiculo = null;
		Rueda ruedas = null;
		
		/*
		 * Datos preestablecidos
		 */
		
		LinkedList<String[]> marcas = cargarMarcas();
		String marcaRueda[] = { "Michellin", "Goodyear", "Dunlop", "Firestone", "Bridgestone", "Hankook", "Kumho" };
		String tipoVehiculo[] = { "Moto", "Coche", "Camión" };
		String colores[] = { "Azul", "Amarillo", "Rojo", "Blanco", "Negro", "Fucsia", "Morado", "Verde" };

		
		
		if(licencia == null)
			opcionVehiculo = darOpciones(tipoVehiculo, "Elige un vehiculo");
		else
			opcionVehiculo = darOpciones(tipoLicencia(licencia.getTipoLicencia()), "Elige un vehiculo");

		do {
			matricula = solicitarDatosString("Dime tu matricula");
			if (comprobarMatricula(matricula))
				mostrarInfo("Introduzca una matricula valida.");
			
		} while (comprobarMatricula(matricula));

		marca = menuDesplegable(marcas.get(opcionVehiculo),"Elige una marca: ");
		color = menuDesplegable(colores, "Elige un color");

		do {
			diamDel = solicitarDatosDouble("Dame el diametro para las ruedas delanteras.(Diametro valido 0.4 al 4)");
			diamTra = solicitarDatosDouble("Dame el diametro para las ruedas traseras.(Diametro valido 0.4 al 4)");

			if (comprobarRueda(diamDel) && comprobarRueda(diamTra)) {
				ruedas = new Rueda((String) menuDesplegable(marcaRueda, "Elige una marca: "), diamDel, diamTra);
				exit = true;
			}
		} while (!exit);

		switch (opcionVehiculo) {
		case 0: // Moto
			nuevoVehiculo = new Moto(matricula, color, marca, ruedas);
			break;
		case 1: // Coche
			nuevoVehiculo = new Coche(matricula, color, marca, ruedas);
			break;
		case 2: // Camión
			nuevoVehiculo = new Camion(matricula, color, marca, ruedas);
			break;
		}

		return nuevoVehiculo;
	}

	
	
	/**
	 * Métodos Auxiliares.
	 */
	
	private int getId() {
		return this.setId();
	}
	
	private int setId() {
		return this.id += 1;
	}
	
	private void conductoresDisponibles(LinkedList<Conductor> listaConductores, String licencia ) {
		Iterator<Conductor> it = listaConductores.iterator();
		String opciones = "";
		int i = 0;
				
		while(it.hasNext()) {
			Conductor pt = it.next();
			if(licenciaValida(pt.getLicencia().getTipoLicencia(), licencia))
				opciones += (i+1)+". " + pt.getNombre() + " " + pt.getApellido() + ", Licencia: "
						+ pt.getLicencia().getTipoLicencia() +"\n";	
			i++;
		}
		mostrarInfo(opciones);
	}
	
	
	private void titularesDisponibles(LinkedList<Titular> listaTitulares, String licencia ) {
		Iterator<Titular> it = listaTitulares.iterator();
		String opciones = "";
		int i = 0;
				
		while(it.hasNext()) {
			Titular pt = it.next();
			if(licenciaValida(pt.getLicencia().getTipoLicencia(), licencia))
				opciones += (i+1)+". " + pt.getNombre() + " " + pt.getApellido() + ", Licencia: "
						+ pt.getLicencia().getTipoLicencia() +"\n";	
			i++;
		}
		mostrarInfo(opciones);
	}
	
	private boolean licenciaValida(String formatoLicencia, String licencia) {
		String [] formLicencia = formatoLicencia.split("\\+");
		int i = 0;
		boolean esValida = false, exit = false;
		
		switch(licencia) {
		case "Moto":
			licencia = "A";
			break;
		case "Coche":
			licencia = "B";
			break;
		case "Camion":
			licencia = "C";
			break;
		}
		
		while(i < formLicencia.length && !exit) {
			if(formLicencia[i].compareToIgnoreCase(licencia) == 0) {
				esValida = true;
				exit = true;
			}
			i++;
		}
		
		return esValida;
	}
	
	
	
	private void vehiculosDisponibles(LinkedList<Vehiculo> listaVehiculos) {
		Iterator<Vehiculo> it = listaVehiculos.iterator();
		String opciones = "";

		int i = 0;
		
		while(it.hasNext()) {
			Vehiculo pt = it.next();
			opciones += (i+1) + "Marca: " + pt.getMarca() + " ,Color: " + pt.getColor() +"\n";	
			i++;
		}
	}
	
	
	private LinkedList<String[]> cargarMarcas(){
		String marcasCoches[] ={ "BMW", "Audi", "Renault", "Dacia", "Mercedes", "Seat" } ;
		String marcasMotos[] = { "BMW", "Kawasaki", "Harley-Davidson", "Ducati", "Suzuki", "Honda" };
		String marcaCamiones[] = {"Scania", "Daf Trucks","Man","Mercedes Benz","Iveco","Volvo","Renault","Isuzu"};
		
		return new LinkedList<String[]>() {{
			add(marcasMotos);
			add(marcasCoches);
			add(marcaCamiones);
		}};
	}

	private String[] tipoLicencia(String licencia) {
		HashMap<String, String> lista = new HashMap<>() {
			{
				put("A", "Moto");
				put("B", "Coche");
				put("C", "Camión");
				put("A+B", "Moto:Coche");
				put("B+C", "Coche:Camión");
				put("A+B+C", "Moto:Coche:Camión");
			}
		};
		return lista.get(licencia).split(":");
	}
	
	private int esTitular() {
		return darOpciones(new String[]{"Titular","Conductor"} ,"¿Que quieres crear?");
	}

	private boolean comprobarRueda(double diametro) {
		return ((diametro >= 0.4) && (diametro <= 4)) ? true : false;
	}

	private boolean comprobarMatricula(String matricula) {
		return (matricula.matches("^[0-9]{4}[aA-zZ]{2,3}")) ? false : true;
	}

	
	/*
	 * Métodos auxiliares para pedir información al usuario.
	 */
	
	private String solicitarDatosString(String texto) {
		return JOptionPane.showInputDialog(texto);
	}

	private double solicitarDatosDouble(String texto) {
		String strNum = "";
		do {
			strNum = JOptionPane.showInputDialog(texto);
		} while (!esNumero(strNum));
		return Double.parseDouble(strNum);
	}
	
	private int solicitarDatosInt(String texto) {
		String strNum = "";
		do {
			strNum = JOptionPane.showInputDialog(texto);
		} while (!esNumero(strNum));
		return Integer.parseInt(strNum);
	}

	private int darOpciones(String[] opciones, String textoOpciones) {
		int opcion = JOptionPane.showOptionDialog(null, textoOpciones, "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		return opcion;
	}

	private void mostrarInfo(String text) {
		JOptionPane.showMessageDialog(null, text);
	}

	private String menuDesplegable(String[] opciones, String texto) {
		Object opcion = JOptionPane.showInputDialog(null, texto, "Elegir", JOptionPane.QUESTION_MESSAGE, null, opciones,
				opciones[0]);
		return (String) opcion;
	}
	
	private boolean esNumero(String strNum) {
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
