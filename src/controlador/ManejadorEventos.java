package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import vista.VentanaPrincipal;

public class ManejadorEventos implements ActionListener {

	private VentanaPrincipal ventana;
	private JLabel etiquetaResultado;
	private JLabel etiquetaResto;
	private String cajaNumero1;
	private String cajaNumero2;

	public ManejadorEventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		etiquetaResultado = ventana.getEtiqueta4();
		etiquetaResto = ventana.getEtiqueta5();
		cajaNumero1 = ventana.getCajaTexto1().getText();
		cajaNumero2 = ventana.getCajaTexto2().getText();

		/**
		 * Antes de entrar en el try/catch para que se hagan las operaciones comprobamos
		 * si las cajetillas donde van los numeros estan vacias ambas, si no estan
		 * ambas, comprueba cual esta vacia y hace el focus en ella.
		 * 
		 * Si ambas estan rellenas, entrara en el try y podra hacer las operaciones con
		 * numeros, o capturar la excepcion con el catch si se introducen letras
		 */

		if (cajaNumero1.isEmpty() && (cajaNumero2.isEmpty())) {
			etiquetaResultado.setForeground(Color.RED);
			etiquetaResto.setForeground(Color.RED);
			etiquetaResultado.setText("Faltan ambos numeros");
			etiquetaResto.setText("Recuerde insertar numeros validos");
			ventana.getCajaTexto1().requestFocus();
		} else if (cajaNumero1.isEmpty()) {
			etiquetaResultado.setForeground(Color.RED);
			etiquetaResto.setForeground(Color.RED);
			etiquetaResultado.setText("Falta el numero 1");
			etiquetaResto.setText("Recuerde insertar numeros validos");
			ventana.getCajaTexto1().requestFocus();

		} else if (cajaNumero2.isEmpty()) {
			etiquetaResultado.setForeground(Color.RED);
			
			etiquetaResultado.setText("Falta el numero2");
			etiquetaResto.setText("Recuerde insertar numeros validos");
			ventana.getCajaTexto2().requestFocus();
		} else {

			try {

				float resultado = 0, resto;
				// Hacemos un parseo a Float ya que el texto que recogemos del getter es un
				// String
				float numero1 = Float.parseFloat(ventana.getCajaTexto1().getText());
				float numero2 = Float.parseFloat(ventana.getCajaTexto2().getText());

				/**
				 * Dentro de los if, excepto el de dividir, ponemos la etiqueta del resto en
				 * blanco para que a la hora de dividir, si se quiere sumar esos mismos numeros
				 * esta sea borrada
				 */

				if (e.getSource() == ventana.getbSumar()) {
					resultado = numero1 + numero2;
					etiquetaResto.setText("");

				}
				if (e.getSource() == ventana.getbRestar()) {
					resultado = numero1 - numero2;
					etiquetaResto.setText("");

				}
				if (e.getSource() == ventana.getbMultiplicar()) {
					resultado = numero1 * numero2;
					etiquetaResto.setText("");

				}
				if (e.getSource() == ventana.getbDividir()) {
					resultado = numero1 / numero2;
					resto = numero1 % numero2;
					etiquetaResto.setText("Resto = " + resto);
					etiquetaResto.setForeground(Color.GREEN);

					// Controlamos la excepcion del resultado infinito al dividir entre 0 con el
					// metodo isInfinite()
					if (Float.isInfinite(resultado)) {
						etiquetaResto.setForeground(Color.RED);
						// En Character.toString se le introduce el codigo del simbolo de infinito
						etiquetaResto.setText("ERROR: El resultado es " + Character.toString('\u221E'));
					}

					// Controlamos la excepcion del resultado infinito al dividir 0 entre 0 con el
					// metodo isNaN()
					if (Float.isNaN(resultado)) {
						etiquetaResto.setForeground(Color.RED);
						// Se indica que la division 0 entre 0 tiene un resultado indeterminado
						etiquetaResto.setText("ERROR: El resultado es indeterminado");
					}

				}

				etiquetaResultado.setForeground(Color.green);
				// imprimimos en la etiqueta el valor del resultado obtenido como String
				etiquetaResultado.setText(String.valueOf(resultado));
				// le damos el foco a la primera caja
				ventana.getCajaTexto1().requestFocus();

				/**
				 * Si se introducen letras en vez de numeros en la cajas de texto salta esta
				 * excepcion, e indica al usuario que se inserten numeros validos
				 */
			} catch (NumberFormatException nfe) {
				etiquetaResto.setText("");
				etiquetaResultado.setForeground(Color.RED);
				etiquetaResultado.setText("Inserte numeros validos");
				ventana.getCajaTexto1().requestFocus();
			}
		}
	}
}
