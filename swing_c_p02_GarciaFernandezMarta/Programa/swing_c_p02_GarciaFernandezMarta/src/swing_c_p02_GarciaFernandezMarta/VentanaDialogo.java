/**
 * VentanaDialogo.java
 * 18 nov 2023 22:04:51
 * @author Marta García Fernández
 */
package swing_c_p02_GarciaFernandezMarta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

/**
 * 
 */
public class VentanaDialogo extends JDialog implements ActionListener {

	private PanelTitulo panelTitulo;
	private PanelDatosCliente panelDatosCliente;
	private PanelDatosAlojamiento panelDatosAlojamiento;
	private PanelFicha panelFicha; // panelImprimirDatos
	private JButton btnImprimir, btnLimpiar, btnGuardar;
	private Box cajaDatos, cajaHorizontal;
	private JScrollPane scrollPane;
	
	public VentanaDialogo(Ventana miVentana, boolean modal) {

		super(miVentana, modal);

		configPantalla();
		this.setTitle("Alta de Reservas");

		iniciarComponentes();
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

		// Queremos que la ventana sea igual a la resolución de la pantalla
		this.setSize(anchoPantalla, altoPantalla);

		// Ventana en el centro de la pantalla
		setLocationRelativeTo(null);

		// Añadimos Logo
		Image miIcono = miPantalla.getImage(getClass().getResource("/recursos/logo.png"));
		this.setIconImage(miIcono);
	}

	private void iniciarComponentes() {

		cajaDatos = Box.createVerticalBox();
		cajaHorizontal = Box.createHorizontalBox();

		panelTitulo = new PanelTitulo();
		Color colorBorde1 = new Color(180, 184, 165); // Creamos un borde con tonalidad más oscura que el color de fondo
		panelTitulo.setBorder(BorderFactory.createLineBorder(colorBorde1, 4));

		panelDatosCliente = new PanelDatosCliente();
		Color colorBorde2 = new Color(177, 169, 211);
		panelDatosCliente.setBorder(BorderFactory.createLineBorder(colorBorde2, 4));

		panelDatosAlojamiento = new PanelDatosAlojamiento();
		Color colorBorde3 = new Color(139, 159, 151);
		panelDatosAlojamiento.setBorder(BorderFactory.createLineBorder(colorBorde3, 4));

		panelFicha = new PanelFicha();
		Color colorBorde4 = new Color(63, 176, 178);
		panelFicha.setBorder(BorderFactory.createDashedBorder(colorBorde4));

		ImageIcon imagenImprimir = new ImageIcon(getClass().getResource("/recursos/impresora.png"));
		btnImprimir = new JButton(imagenImprimir);
		btnImprimir.setToolTipText("Imprimir Datos"); // Muestra el texto al pasar por encima del componente
		btnImprimir.addActionListener(this);
		btnImprimir.setOpaque(true);
		btnImprimir.setBackground(colorBorde1);

		ImageIcon imagenLimpiar = new ImageIcon(getClass().getResource("/recursos/limpiar.png"));
		btnLimpiar = new JButton(imagenLimpiar);
		btnLimpiar.setToolTipText("Limpiar Datos");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBackground(colorBorde2);

		ImageIcon imagenGuardar = new ImageIcon(getClass().getResource("/recursos/guardar.png"));
		btnGuardar = new JButton(imagenGuardar);
		btnGuardar.setToolTipText("Guardar Datos");
		btnGuardar.addActionListener(this);
		btnGuardar.setOpaque(true);
		btnGuardar.setBackground(colorBorde3);

		// Añadimos paneles
		cajaDatos.add(panelTitulo);
		cajaDatos.add(panelDatosCliente);
		cajaDatos.add(panelDatosAlojamiento);
		cajaDatos.add(panelFicha);

		// Añadimos botones
		cajaHorizontal.add(btnImprimir);
		cajaHorizontal.add(Box.createHorizontalStrut(5));
		cajaHorizontal.add(btnLimpiar);
		cajaHorizontal.add(Box.createHorizontalStrut(5));
		cajaHorizontal.add(btnGuardar);

		cajaDatos.add(cajaHorizontal);

		//this.add(cajaDatos);
		
		// Al scrollPane le asignamos la vista a nuestra cajaDatos y lo añadimos a la ventana
		scrollPane = new JScrollPane(cajaDatos);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnImprimir) {

			String devuelve = "";
			devuelve += "Nombre: " + PanelDatosCliente.nombreCliente.getText() + "\n";
			devuelve += "Apellidos: " + PanelDatosCliente.apellidosCliente.getText() + "\n";
			devuelve += "DNI: " + PanelDatosCliente.dniCliente.getText() + "\n";
			devuelve += "Telefono: " + PanelDatosCliente.telfCliente.getText() + "\n";

			PanelFicha.datosCliente.setText(devuelve);

			devuelve = "";
			devuelve += "Provincia: " + (PanelDatosAlojamiento.provincia.getSelectedItem()) + "\n";
			devuelve += "Tipo de camas: " + (PanelDatosAlojamiento.tipoCamas.getSelectedItem()) + "\n";
			devuelve += "¿Tiene niños?: ";

			if (PanelDatosAlojamiento.tieneNinios.isSelected()) {

				devuelve += "Si \n";
				devuelve += "Edad de los niños: " + PanelExtrasNinios.edadNinios.getValue() + "\n";
				devuelve += "Extra: " + PanelExtrasNinios.extras.getText() + "\n";

			} else {

				devuelve += "No \n";

			}

			devuelve += "Precio Mínimo: " + PanelDatosAlojamiento.precioMinimo.getText() + "\n";

			PanelFicha.datosAlojamiento.setText(devuelve);

		}

		if (e.getSource() == btnLimpiar) {

			PanelDatosCliente.nombreCliente.setText("");
			PanelDatosCliente.apellidosCliente.setText("");
			PanelDatosCliente.dniCliente.setText("");
			PanelDatosCliente.telfCliente.setText("");

			PanelDatosAlojamiento.direccion.setText("");
			PanelDatosAlojamiento.provincia.setSelectedIndex(0);
			PanelDatosAlojamiento.tipoCamas.setSelectedIndex(0);
			PanelDatosAlojamiento.numCamas.setValue(0);
			PanelDatosAlojamiento.numHuespedes.setValue(0);
			PanelDatosAlojamiento.numDormitorios.setValue(0);
			PanelDatosAlojamiento.numBanios.setValue(0);
			PanelDatosAlojamiento.tieneNinios.setSelected(false);

			PanelExtrasNinios.edadNinios.setValue(0);
			PanelExtrasNinios.extras.setText("");
		}

		if (e.getSource() == btnGuardar) {

			JOptionPane.showMessageDialog(this, "¡Datos guardados correctamente!", "Confirmación",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}
}
