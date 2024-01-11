/**
 * PanelExtrasNinios.java
 * 23 nov 2023 20:28:40
 * @author Marta García Fernández
 */
package swing_c_p02_GarciaFernandezMarta;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */
public class PanelExtrasNinios extends JPanel implements ChangeListener, FocusListener {

	private JLabel edadNiniosText, extrasText;
	static JSpinner edadNinios;
	static JTextField extras;
	private SpinnerModel valores;

	public PanelExtrasNinios() {

		edadNiniosText = new JLabel("Edad de los Niños: ");
		valores = new SpinnerNumberModel(0, 0, 10, 1);
		edadNinios = new JSpinner(valores);
		edadNinios.addChangeListener(this);

		extrasText = new JLabel("Extras: ");
		extras = new JTextField();
		extras.setEditable(false);

		Box cajaH1 = Box.createHorizontalBox();
		Box cajaH2 = Box.createHorizontalBox();
		Box cajaVertical = Box.createVerticalBox();

		cajaH1.add(edadNiniosText);
		cajaH1.add(edadNinios);

		cajaVertical.add(cajaH1);
		cajaVertical.add(Box.createVerticalStrut(10));

		cajaH2.add(extrasText);
		cajaH2.add(extras);

		cajaVertical.add(cajaH2);
		cajaVertical.add(Box.createVerticalStrut(10));

		this.add(cajaVertical);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// No es necesario implementar nada aquí

	}

	@Override
	public void focusLost(FocusEvent e) {
		// No es necesario implementar nada aquí

	}

	@Override
	public void stateChanged(ChangeEvent e) {

		if (e.getSource() == edadNinios) {

			if ((int) edadNinios.getValue() >= 0 && (int) edadNinios.getValue() <= 3) {
				extras.setText("Cuna");
			} else if ((int) edadNinios.getValue() >= 4 && (int) edadNinios.getValue() <= 10) {
				extras.setText("Cama supletoria pequeña");
			}
		}
	}

}
