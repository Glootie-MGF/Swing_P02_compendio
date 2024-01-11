/**
 * Ventana.java
 * 15 nov 2023 19:28:11
 * @author Marta García Fernández
 */
package swing_c_p02_GarciaFernandezMarta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * 
 */
public class Ventana extends JFrame implements ActionListener {

	private JMenuBar miBarra;
	private JMenu archivo, registro, ayuda;
	private JMenuItem salir, altaPiso, bajaPiso, acercaDe;
	private JButton btnAltaPiso, btnBajaPiso;
	private JLabel panda, etiquetaAutor;
	private JPanel panelAutor;

	public Ventana() {

		// Parámetros para crear la ventana
		super("Swing Práctica02 Compendio - Marta García Fernández");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		configPantalla();
		this.setTitle("PandAccommodation");
		this.setLayout(new BorderLayout());

		iniciarComponentes();
		this.setVisible(true);
	}

	private void configPantalla() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla;
		try {
			tamanoPantalla = miPantalla.getScreenSize();
		} catch (HeadlessException e) {
			e.printStackTrace();
			tamanoPantalla = new Dimension(800, 600); // Tamaño por defecto
		}

		// Guardamos en dos variables el alto y ancho de nuestra pantalla
		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		// Creamos un marco que tenga la mitad de mi pantalla
		this.setSize(anchoPantalla / 2, altoPantalla / 2);
		// Para que aparezca en el centro de la pantalla
		this.setLocation(anchoPantalla / 4, altoPantalla / 4);

		// Añadimos Logo
		Image miIcono = miPantalla.getImage(getClass().getResource("/recursos/logo.png"));
		this.setIconImage(miIcono);
	}

	private void iniciarComponentes() {

		miBarra = new JMenuBar();

		archivo = new JMenu("Archivo");

		registro = new JMenu("Registro");
		registro.setMnemonic(KeyEvent.VK_A);

		ayuda = new JMenu("Ayuda");

		salir = new JMenuItem("Salir");
		salir.addActionListener(this);

		altaPiso = new JMenuItem("Alta Reservas");
		altaPiso.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		altaPiso.addActionListener(this);

		bajaPiso = new JMenuItem("Baja Reservas");
		bajaPiso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		bajaPiso.addActionListener(this);

		acercaDe = new JMenuItem("Acerca de...");
		acercaDe.addActionListener(this);

		ImageIcon imagenAlta = new ImageIcon(getClass().getResource("/recursos/alta.png"));
		btnAltaPiso = new JButton(imagenAlta);
		btnAltaPiso.setToolTipText("Alta Reservas"); // Muestra el texto al pasar por encima del componente
		btnAltaPiso.addActionListener(this);

		ImageIcon imagenBaja = new ImageIcon(getClass().getResource("/recursos/baja.png"));
		btnBajaPiso = new JButton(imagenBaja);
		btnBajaPiso.setToolTipText("Baja Reservas");
		btnBajaPiso.addActionListener(this);

		// Logo de nuestro negocio
		ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/panda.png"));
		panda = new JLabel(new ImageIcon(imagen.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		panda.setToolTipText("PandAccommodation");
		
		// Creamos un panel para la etiqueta del autor
	    panelAutor = new JPanel();
	    etiquetaAutor = new JLabel("Por Marta García Fernández");
	    etiquetaAutor.setFont(new Font("Serif", Font.ITALIC, 14));
	    etiquetaAutor.setForeground(new Color(70, 70, 70)); // Gris oscuro
	    panelAutor.add(etiquetaAutor);
	    
		// Añadimos elementos a la barra de menú
		archivo.add(salir);
		registro.add(altaPiso);
		registro.add(bajaPiso);
		ayuda.add(acercaDe);

		miBarra.add(archivo);
		miBarra.add(registro);
		miBarra.add(ayuda);

		// Añadimos la barra de menú y los botones a nuestra interfaz
		this.setJMenuBar(miBarra);

		configurarColores();

		this.add(btnAltaPiso, BorderLayout.WEST);
		this.add(btnBajaPiso, BorderLayout.EAST);
		this.add(panda, BorderLayout.CENTER);
		this.add(panelAutor, BorderLayout.SOUTH);

	}

	private void configurarColores() {
		// Configura el color de fondo de la ventana
		this.getContentPane().setBackground(new Color(220, 224, 205)); // Color #dce0cd

		// Configura el color del botón para las altas
		btnAltaPiso.setOpaque(true);
		btnAltaPiso.setBackground(new Color(204, 219, 134)); // Color #ccdb86
		btnAltaPiso.setForeground(Color.BLACK); // Color del texto

		// Configura el color del botón para las bajas
		btnBajaPiso.setOpaque(true);
		btnBajaPiso.setBackground(new Color(103, 160, 48)); // Color #67a030
		btnBajaPiso.setForeground(Color.BLACK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == acercaDe) {

			JOptionPane.showMessageDialog(this,
					"Aplicación para crear altas y bajas de reservas en la plataforma de pisos de alquiler turístico PandAccommodation.",
					"Acerca De...", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == salir) {

			System.exit(0);
		}
		if (e.getSource() == altaPiso || e.getSource() == btnAltaPiso) {

			VentanaDialogo miVentanaDialog = new VentanaDialogo(this, true);
			miVentanaDialog.setVisible(true);
		}
		if (e.getSource() == bajaPiso || e.getSource() == btnBajaPiso) {

			JOptionPane.showMessageDialog(this, "Esta funcion todavia NO está implementada.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
