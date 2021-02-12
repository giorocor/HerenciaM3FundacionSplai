package Models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * @author Miguel Á. Sastre
 * @author Christian Rivas Pottier
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

		/*
		 * Variables de control
		 */

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
				if (esTitular() == 0)
					listaTitulares.add((Titular) crearUsuario(true));
				else
					listaConductores.add((Conductor) crearUsuario(false));
				break;
				
				
			/*
			 * Opcion de crear vehiculos. Luego de crear vehiculos hay que seleccionar el
			 * titular del vehiculo y si tendrá conductores.
			 */
				
			case 1:
				Vehiculo nuevoVehiculo = crearVehiculo(null);
				String[] opcionSiNo = { "Si", "No" };

				/*
				 * Hay que asignar un titular al vehiculo.
				 */

				if (listaTitulares.isEmpty())
					nuevoVehiculo.setTitular((Titular) crearUsuario(true));
				else {
					titularesDisponibles(listaTitulares, nuevoVehiculo.getClass().getSimpleName());
					//TODO Hay que controlar el dato que nos pasa el usuario.
					int titularElegido = solicitarDatosInt("Introduzca el titular seleccionado") - 1;
					nuevoVehiculo.setTitular(listaTitulares.get(titularElegido));

					if (darOpciones(opcionSiNo, "¿Quieres incluirlo como conductor?") == 0) {
						Titular conductor = listaTitulares.get(titularElegido);
						nuevoVehiculo.addConductor(new Conductor(conductor.getNombre(), conductor.getApellido(),
								conductor.getFechaNacimiento(), conductor.getLicencia()));
					}
				}
				
				/*
				 * Ahora se le da la opción al usuario de añadir mas conductores al vehiculo.
				 */
				
				if (darOpciones(opcionSiNo, "¿Quieres incluir más conductores?") == 0) {
					if (!listaConductores.isEmpty()) {
						int conductorElegido;
						boolean exitConductor = false;

						do {
							conductoresDisponibles(listaConductores, nuevoVehiculo.getClass().getSimpleName());
							//TODO Hay que controlar el dato que nos pasa el usuario.
							conductorElegido = solicitarDatosInt("Introduzca el titular seleccionado") - 1;
							nuevoVehiculo.addConductor(listaConductores.get(conductorElegido));

							exitConductor = (darOpciones(opcionSiNo, "¿Agregar más?") == 0) ? false : true;
						} while (!exitConductor);

					} else
						mostrarInfo("No hay conductores disponibles.");
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
		licencia = (String) menuDesplegable(listaLicencias, "Elige tipo de licencia: ");

		if (titular) {
			seguro = (darOpciones(opciones, "¿Tienes seguro?") == 0) ? true : false;
			garaje = (darOpciones(opciones, "¿Tiene garaje?")) == 0 ? true : false;
			nuevoUsuario = new Titular(nombre, apellido, fechaNacimiento,
					new Licencia(this.getId(), licencia, nombre + " " + apellido, fechaNacimiento), seguro, garaje);
		} else
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

		
		/*
		 * Feature que permite solo crear vehiculo cuando la licencia es valida.(Si previamente se ha pasado).
		 * 		Ecc, simplemente mostraramos las 3 posibilidades: Moto, Coche y Camión
		 */
		
		if (licencia == null)
			opcionVehiculo = darOpciones(tipoVehiculo, "Elige un vehiculo");
		else
			opcionVehiculo = darOpciones(tipoLicencia(licencia.getTipoLicencia()), "Elige un vehiculo");

		/*
		 * Pedimos la matricula. Esta matricula debe ser con el formato adecuado
		 * 		Formatos admitidos: "1234ABC" o "1234AB"
		 */
		
		do {
			matricula = solicitarDatosString("Dime tu matricula");
			if (comprobarMatricula(matricula))
				mostrarInfo("Introduzca una matricula valida.");

		} while (comprobarMatricula(matricula));

		
		/*
		 * Pedimos el color y marca.
		 */
		
		marca = menuDesplegable(marcas.get(opcionVehiculo), "Elige una marca: ");
		color = menuDesplegable(colores, "Elige un color");

		/*
		 * Pedimos el diametro de la ruedas y su marca.
		 */
		
		do {
			diamDel = solicitarDatosDouble("Dame el diametro para las ruedas delanteras.(Diametro valido 0.4 al 4)");
			diamTra = solicitarDatosDouble("Dame el diametro para las ruedas traseras.(Diametro valido 0.4 al 4)");

			if (comprobarRueda(diamDel) && comprobarRueda(diamTra)) {
				ruedas = new Rueda((String) menuDesplegable(marcaRueda, "Elige una marca: "), diamDel, diamTra);
				exit = true;
			}
		} while (!exit);
		
		
		/*
		 * Creamos el objeto en función del tipo de vehiculo.
		 */

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

	
	
	/**
	 * Método para obtener ID. Este método no es un "getters" estandar.
	 *  Este método lo primero que hará será incrementar el id y luego devolverlo.
	 * @return Int
	 */
	
	private int getId() {
		return this.setId();
	}

	
	/**
	 * Método para incrementar el ID. No es un "setter" estandar.
	 * @return Int
	 */
	
	private int setId() {
		return this.id += 1;
	}

	


	/**
	 * Método que muestra los conductores disponibles por pantalla.
	 * 
	 * @param listaConductores
	 * @param licencia
	 */
	
	private void conductoresDisponibles(LinkedList<Conductor> listaConductores, String licencia) {
		Iterator<Conductor> it = listaConductores.iterator();
		String opciones = "";
		int i = 0;

		while (it.hasNext()) {
			Conductor pt = it.next();
			if (licenciaValida(pt.getLicencia().getTipoLicencia(), licencia))
				opciones += (i + 1) + ". " + pt.getNombre() + " " + pt.getApellido() + ", Licencia: "
						+ pt.getLicencia().getTipoLicencia() + "\n";
			i++;
		}
		mostrarInfo(opciones);
	}
	
	

	/**
	 * Método que muestra los titulares disponibles por pantalla.
	 * 
	 * @param listaTitulares
	 * @param licencia
	 */
	private void titularesDisponibles(LinkedList<Titular> listaTitulares, String licencia) {
		Iterator<Titular> it = listaTitulares.iterator();
		String opciones = "";
		int i = 0;

		while (it.hasNext()) {
			Titular pt = it.next();
			if (licenciaValida(pt.getLicencia().getTipoLicencia(), licencia))
				opciones += (i + 1) + ". " + pt.getNombre() + " " + pt.getApellido() + ", Licencia: "
						+ pt.getLicencia().getTipoLicencia() + "\n";
			i++;
		}
		mostrarInfo(opciones);
	}

	
	
	/**
	 * Método para comprobar si la licencia formateada es igual a la licencia 
	 * buscada.
	 * El formato de la licencia es: "Letra + ...", Donde la letra puede ser: A,B o C.
	 * Ejemplo: "A+B" sería licencia de moto y coche.
	 * Con este método podemos comprobar si la licencía de los usuarios es la buscada
	 * para un cierto vehiculo.
	 * 
	 * @param formatoLicencia
	 * @param licencia
	 * @return 
	 */
	
	private boolean licenciaValida(String formatoLicencia, String licencia) {
		String[] formLicencia = formatoLicencia.split("\\+");
		int i = 0;
		boolean esValida = false, exit = false;

		switch (licencia) {
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

		while (i < formLicencia.length && !exit) {
			if (formLicencia[i].compareToIgnoreCase(licencia) == 0) {
				esValida = true;
				exit = true;
			}
			i++;
		}

		return esValida;
	}

	
	/**
	 * Método para obtener la lista de los vehiculos  y mostrarla por pantalla
	 * @param listaVehiculos
	 */
	
	@Deprecated
	private void vehiculosDisponibles(LinkedList<Vehiculo> listaVehiculos) {
		Iterator<Vehiculo> it = listaVehiculos.iterator();
		String opciones = "";

		int i = 0;

		while (it.hasNext()) {
			Vehiculo pt = it.next();
			opciones += (i + 1) + "Marca: " + pt.getMarca() + " ,Color: " + pt.getColor() + "\n";
			i++;
		}
		mostrarInfo(opciones);
	}

	
	/**
	 * Método auxiliar para cargar una lista de marcas de cada tipo de vehiculo.
	 * @return LinkedList<String[]> lista de marcas
	 */
	
	private LinkedList<String[]> cargarMarcas() {
		String marcasCoches[] = { "BMW", "Audi", "Renault", "Dacia", "Mercedes", "Seat" };
		String marcasMotos[] = { "BMW", "Kawasaki", "Harley-Davidson", "Ducati", "Suzuki", "Honda" };
		String marcaCamiones[] = { "Scania", "Daf Trucks", "Man", "Mercedes Benz", "Iveco", "Volvo", "Renault",
				"Isuzu" };

		return new LinkedList<String[]>() {
			{
				add(marcasMotos);
				add(marcasCoches);
				add(marcaCamiones);
			}
		};
	}

	/**
	 * Método que devuelve un array con los vehiculos que corresponde
	 * al formatoLicencia pasado
	 * 
	 * @param formatoLicencia
	 * @return String[] Array de licencias
 	 */
	
	private String[] tipoLicencia(String formatoLicencia) {
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
		return lista.get(formatoLicencia).split(":");
	}

	/**
	 * Método que le da la opción de elegir al usuario si quiere
	 * acceder como Titular o Conductor.
	 * @return Int Opcion elegida
	 */
	private int esTitular() {
		return darOpciones(new String[] { "Titular", "Conductor" }, "¿Que quieres crear?");
	}

	/**
	 * Método para comprobar que el diametro pasado es el adecuado.
	 * Diametros admitidos: 0.4 <= Diametro <= 4
	 * 
	 * @param diametro
	 * @return True si es valido el diametro.
	 */
	private boolean comprobarRueda(double diametro) {
		return ((diametro >= 0.4) && (diametro <= 4)) ? true : false;
	}
	
	/**
	 * Método para comprobar si la matrícula pasada es correcta
	 * al formato esperado.
	 * 
	 * @param matricula
	 * @return True si es valida la matrícula 
	 */

	private boolean comprobarMatricula(String matricula) {
		return (matricula.matches("^[0-9]{4}[aA-zZ]{2,3}")) ? false : true;
	}

	/*
	 * Métodos auxiliares para pedir información al usuario.
	 */

	/**
	 * Método para solitar datos de tipo String al usuario.
	 * @param texto
	 * @return String
	 */
	private String solicitarDatosString(String texto) {
		return JOptionPane.showInputDialog(texto);
	}

	/**
	 * Método para solitar datos de tipo double al usuario.
	 * @param texto
	 * @return Double
	 */
	
	private double solicitarDatosDouble(String texto) {
		String strNum = "";
		do {
			strNum = JOptionPane.showInputDialog(texto);
		} while (!esNumero(strNum));
		return Double.parseDouble(strNum);
	}

	/**
	 * Método para solitar datos de tipo int al usuario.
	 * @param texto
	 * @return Int
	 */
	
	private int solicitarDatosInt(String texto) {
		String strNum = "";
		do {
			strNum = JOptionPane.showInputDialog(texto);
		} while (!esNumero(strNum));
		return Integer.parseInt(strNum);
	}

	
	/**
	 * Método para dar opciones mediante botones..
	 * 
	 * @param opciones
	 * @param textoOpciones
	 * @return Int
	 */
	
	private int darOpciones(String[] opciones, String textoOpciones) {
		int opcion = JOptionPane.showOptionDialog(null, textoOpciones, "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		return opcion;
	}

	/**
	 * Método para mostrar información por pantalla al usuario.
	 * @param text
	 */
	private void mostrarInfo(String text) {
		JOptionPane.showMessageDialog(null, text);
	}

	/**
	 * Método para dar opciones mediante un menú desplegable.
	 * @param opciones
	 * @param texto
	 * @return String
	 */
	private String menuDesplegable(String[] opciones, String texto) {
		Object opcion = JOptionPane.showInputDialog(null, texto, "Elegir", JOptionPane.QUESTION_MESSAGE, null, opciones,
				opciones[0]);
		return (String) opcion;
	}

	/**
	 * Método para comprobar que el String pasado es un número valido.
	 * 
	 * @param strNum
	 * @return True si es String pasado corresponde a un número.
	 */
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
