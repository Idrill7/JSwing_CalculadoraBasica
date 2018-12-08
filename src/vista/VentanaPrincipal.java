package vista;


import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.ManejadorEventos;

public class VentanaPrincipal extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3980419735202571197L;
	private JLabel etiqueta1, etiqueta2, etiqueta3,etiqueta4,etiqueta5;
	private JTextField cajaTexto1, cajaTexto2;
	private JButton bSumar, bRestar, bMultiplicar, bDividir;

	public VentanaPrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400,400);
		// Indicamos que el Resizable sea false para que no se pueda modificar el tamanio de la ventana
		setResizable(false);
		setLayout(null);
		setTitle("Calculadora Basica Actividad_3");
		inicializarComponentes();
		setVisible(true);

	}
	/**
	 * En este metodo inicializamos los componentes de la ventana
	 */
	private void inicializarComponentes() {

		etiqueta1 = new JLabel("Numero 1:");
		etiqueta1.setBounds(80, 40, 70, 30);
		
		cajaTexto1 = new JTextField();
		cajaTexto1.setBounds(160, 40, 160, 30);
		
		etiqueta2 = new JLabel("Numero 2 :");
		etiqueta2.setBounds(80, 80, 70, 30);
		
		cajaTexto2 = new JTextField();
		cajaTexto2.setBounds(160, 80, 160, 30);
		
		bSumar = new JButton("Sumar");
		bSumar.setBounds(80, 140, 100, 40);
		
		bRestar = new JButton("Restar");
		bRestar.setBounds(200, 140, 100, 40);
		
		bMultiplicar = new JButton("Multiplicar");
		bMultiplicar.setBounds(80, 200, 100, 40);

		bDividir = new JButton("Dividir");
		bDividir.setBounds(200, 200, 100, 40);
		
		etiqueta3 = new JLabel("Resultado");
		etiqueta3.setBounds(70, 240, 240, 30);
		// Establecemos la fuente Dialog, plana y de tamanio 16 al texto de la etiqueta
		etiqueta3.setFont(new Font("Dialog", Font.PLAIN, 16));
		// Alineamos la etiqueta , al centro del eje horizontal X para asegurarnos que el texto este lo mas centrado
		etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
		
		etiqueta4 = new JLabel();
		etiqueta4.setBounds(70, 270, 250, 30);
		// Establecemos la fuente Dialog, plana y de tamanio 20 al texto de la etiqueta
		etiqueta4.setFont(new Font("Dialog", Font.BOLD, 20));
		// Alineamos la etiqueta , al centro del eje horizontal X para asegurarnos que el texto este lo mas centrado
		etiqueta4.setHorizontalAlignment(SwingConstants.CENTER);
		

		etiqueta5 = new JLabel();
		etiqueta5.setBounds(80, 320, 300, 40);
		// Establecemos la fuente Dialog, plana y de tamanio 15 al texto de la etiqueta
		etiqueta5.setFont(new Font("Dialog", Font.BOLD, 15));
		
		add(etiqueta1);
		add(cajaTexto1);
		add(etiqueta2);
		add(cajaTexto2);
		add(bSumar);
		add(bRestar);
		add(bMultiplicar);
		add(bDividir);
		add(etiqueta3);
		add(etiqueta4);
		add(etiqueta5);
	}
	
	public void establecerManejador(ManejadorEventos manejador) {
		// Ponemos los botones a la escucha  y le pasamos como parametro el manejador de eventos que creamos en el main
		bSumar.addActionListener(manejador);
		bRestar.addActionListener(manejador);
		bMultiplicar.addActionListener(manejador);
		bDividir.addActionListener(manejador);
	}

	public JLabel getEtiqueta4() {
		return etiqueta4;
	}
	
	public JLabel getEtiqueta5() {
		return etiqueta5;
	}
	
	public JTextField getCajaTexto1() {
		return cajaTexto1;
	}

	public JTextField getCajaTexto2() {
		return cajaTexto2;
	}

	public JButton getbSumar() {
		return bSumar;
	}

	public JButton getbRestar() {
		return bRestar;
	}

	public JButton getbMultiplicar() {
		return bMultiplicar;
	}

	public JButton getbDividir() {
		return bDividir;
	}
	
}
