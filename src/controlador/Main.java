
package controlador;

import vista.VentanaPrincipal;
/**
 * 
 * @author Alejandro Gonzalez Casado
 *	@version 1.0
 * 
 */
public class Main {

	public static void main(String[] args) {
		// Creamos el objeto de la clase VentanaPrincipal, esto creara la ventana
		VentanaPrincipal miVentana = new VentanaPrincipal();
		// Creamos el objeto de la clase Manejador eventos y le pasamos el objeto miVentana  como parametro
		ManejadorEventos manejador = new ManejadorEventos(miVentana);
		// Mediante el metodo establecerManejador de la clase VentanaPrincipal, le pasamos el objeto manejador como parametro
		miVentana.establecerManejador(manejador);
	}

}
