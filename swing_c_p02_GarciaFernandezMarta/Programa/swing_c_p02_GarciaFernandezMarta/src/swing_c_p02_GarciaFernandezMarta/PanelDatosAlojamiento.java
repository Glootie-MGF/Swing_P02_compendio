/**
 * PanelDatosAlojamiento.java
 * 23 nov 2023 12:42:54
 * @author Marta García Fernández
 */
package swing_c_p02_GarciaFernandezMarta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class PanelDatosAlojamiento extends JPanel implements ActionListener, FocusListener {

	private JLabel tituloAlojamiento, direccionText, provinciaText, fechaAltaText, fechaDispText, numHuespedesText,
			numDormitoriosText, numBaniosText, numCamasText, tipoCamasText, tieneNiniosText, precioMinimoText;

	static JTextField direccion, precioMinimo;

	static JComboBox<String> provincia, tipoCamas;

	static JSpinner fechaAlta, fechaDisponibilidad, numHuespedes, numDormitorios, numBanios, numCamas, edadNinios;

	static JCheckBox tieneNinios;

	Box cajaH6 = Box.createHorizontalBox();

	private PanelExtrasNinios panelExtrasNinios;

	private SpinnerModel valores;

	private ImageIcon imagen;

	private Image imagenModificada, apoyoImagen;

	private JLabel imagen1, imagen2, imagen3;

	public PanelDatosAlojamiento() {
		
		this.setLayout(new GridLayout());

		tituloAlojamiento = new JLabel(" Datos del Alojamiento ");
		tituloAlojamiento.setFont(new Font("Serif", 1, 20));

		direccionText = new JLabel("Dirección: ");
		direccion = new JTextField();

		provinciaText = new JLabel("Provincia: ");
		provincia = new JComboBox<>(getProvincias());

		fechaAltaText = new JLabel("Fecha de alta: ");
		fechaAlta = new JSpinner();
		fechaAlta.setModel(new SpinnerDateModel());
		fechaAlta.setValue(new Date());

		fechaDispText = new JLabel("Fecha final de disponibilidad: ");
		fechaDisponibilidad = new JSpinner();
		fechaDisponibilidad.setModel(new SpinnerDateModel());
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 1);
		fechaDisponibilidad.setValue(calendar.getTime());

		valores = new SpinnerNumberModel(0, 0, 8, 1);
		numHuespedesText = new JLabel("Nº de huéspedes: ");
		numHuespedes = new JSpinner(valores);

		valores = new SpinnerNumberModel(0, 0, 4, 1);
		numDormitoriosText = new JLabel("Nº de dormitorios: ");
		numDormitorios = new JSpinner(valores);

		valores = new SpinnerNumberModel(0, 0, 2, 1);
		numBaniosText = new JLabel("Nº de baños: ");
		numBanios = new JSpinner(valores);

		valores = new SpinnerNumberModel(0, 0, 4, 1);
		numCamasText = new JLabel("Nº de camas: ");
		numCamas = new JSpinner(valores);

		tipoCamasText = new JLabel("Tipo de camas: ");
		tipoCamas = new JComboBox<>(getTiposCamas());

		tieneNiniosText = new JLabel("¿Niños?");
		tieneNinios = new JCheckBox();
		tieneNinios.addActionListener(this);

		panelExtrasNinios = new PanelExtrasNinios();

		precioMinimoText = new JLabel("Precio Mínimo: ");
		precioMinimo = new JTextField(25);
		precioMinimo.addFocusListener(this);
		precioMinimo.setEditable(false);

		imagen = new ImageIcon(getClass().getResource("/recursos/alojamiento.png"));
		apoyoImagen = imagen.getImage();
		imagenModificada = apoyoImagen.getScaledInstance(250, 150, Image.SCALE_SMOOTH);
		imagen = new ImageIcon(imagenModificada);
		imagen1 = new JLabel(imagen);

		imagen = new ImageIcon(getClass().getResource("/recursos/habitacion.png"));
		apoyoImagen = imagen.getImage();
		imagenModificada = apoyoImagen.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		imagen = new ImageIcon(imagenModificada);
		imagen2 = new JLabel(imagen);

		imagen = new ImageIcon(getClass().getResource("/recursos/banio.png"));
		apoyoImagen = imagen.getImage();
		imagenModificada = apoyoImagen.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
		imagen = new ImageIcon(imagenModificada);
		imagen3 = new JLabel(imagen);

		Box cajaH1 = Box.createHorizontalBox();
		Box cajaH2 = Box.createHorizontalBox();
		Box cajaH3 = Box.createHorizontalBox();
		Box cajaH4 = Box.createHorizontalBox();
		Box cajaH5 = Box.createHorizontalBox();
		Box cajaH7 = Box.createHorizontalBox();
		Box cajaH8 = Box.createHorizontalBox();
		Box cajaVertical = Box.createVerticalBox();

		cajaVertical.add(Box.createVerticalStrut(10));
		cajaH1.add(tituloAlojamiento);

		cajaVertical.add(cajaH1);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH2.add(direccionText);
		cajaH2.add(direccion);
		cajaH2.add(Box.createHorizontalStrut(10));
		cajaH2.add(provinciaText);
		cajaH2.add(provincia);

		cajaVertical.add(cajaH2);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH3.add(fechaAltaText);
		cajaH3.add(fechaAlta);
		cajaH3.add(Box.createHorizontalStrut(10));
		cajaH3.add(fechaDispText);
		cajaH3.add(fechaDisponibilidad);

		cajaVertical.add(cajaH3);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH4.add(numHuespedesText);
		cajaH4.add(numHuespedes);
		cajaH4.add(Box.createHorizontalStrut(10));
		cajaH4.add(numDormitoriosText);
		cajaH4.add(numDormitorios);
		cajaH4.add(Box.createHorizontalStrut(10));
		cajaH4.add(numBaniosText);
		cajaH4.add(numBanios);
		cajaH4.add(Box.createHorizontalStrut(10));
		cajaH4.add(numCamasText);
		cajaH4.add(numCamas);
		cajaH4.add(Box.createHorizontalStrut(10));
		cajaH4.add(tipoCamasText);
		cajaH4.add(tipoCamas);

		cajaVertical.add(cajaH4);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH5.add(tieneNiniosText);
		cajaH5.add(tieneNinios);

		cajaVertical.add(cajaH5);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH6.add(panelExtrasNinios);
		cajaH6.setVisible(false); // Inicialmente a falso porque solo debe aparecer si se selecciona el extra

		cajaVertical.add(cajaH6);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH7.add(Box.createHorizontalStrut(30));
		cajaH7.add(precioMinimoText);
		cajaH7.add(precioMinimo);
		
		cajaVertical.add(cajaH7);
		cajaVertical.add(Box.createVerticalStrut(10));
		
		cajaH8.add(imagen1);
		cajaH8.add(Box.createHorizontalStrut(15));
		cajaH8.add(imagen2);
		cajaH8.add(Box.createHorizontalStrut(15));
		cajaH8.add(imagen3);

		cajaVertical.add(cajaH8);

		this.add(cajaVertical);

		this.setBackground(new Color(168, 195, 188)); // Color #a8c3bc
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (tieneNinios.isSelected()) {
			cajaH6.setVisible(true);
		} else {
			cajaH6.setVisible(false);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {

		precioMinimo.setText(String.valueOf(importeMinimo((int) numBanios.getValue(), (int) numCamas.getValue(),
				String.valueOf(tipoCamas.getSelectedItem()), null)) + "€");
	}

	@Override
	public void focusLost(FocusEvent e) {
		// No es necesario implementar nada aquí
	}

	private String[] getProvincias() {
		return new String[] { "Selecciona", "Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz",
				"Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "Cuenca",
				"Gerona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Balears", "Jaén",
				"La Coruña", "La Rioja", "Las Palmas", "León", "Lérida", "Lugo", "Madrid", "Málaga", "Murcia",
				"Navarra", "Orense", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia",
				"Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora",
				"Zaragoza" };
	}

	private String[] getTiposCamas() {
		return new String[] { "Selecciona", "Simple", "Doble", "Sofá Cama" };
	}

	private int importeMinimo(int numBanios, int numCamas, String tipoCama, ActionEvent ninios) {

		int importe = 0;

		if (numBanios > 0) {
			importe = Math.multiplyExact(numBanios, 25);
		} else {
			importe = Math.addExact(importe, 25);
		}

		if ("Simple".equals(tipoCama)) {
			importe = importe + Math.multiplyExact(numCamas, 15);

		} else if ("Doble".equals(tipoCama)) {
			importe = importe + Math.multiplyExact(numCamas, 20);

		} else {
			importe = importe + Math.multiplyExact(numCamas, 15);
		}

		if (tieneNinios.isSelected()) {
			importe = Math.addExact(importe, 12);
		}

		return importe;
	}

}