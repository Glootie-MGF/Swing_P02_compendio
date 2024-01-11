/**
 * PanelDatosCliente.java
 * 22 nov 2023 18:32:03
 * @author Marta García Fernández
 */
package swing_c_p02_GarciaFernandezMarta;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * 
 */
public class PanelDatosCliente extends JPanel implements FocusListener{

	MaskFormatter mascaraTelf, mascaraDni;
	static JFormattedTextField dniCliente, telfCliente;
    static JTextField nombreCliente, apellidosCliente;
    JLabel tituloCliente, nombre, apellidos, dni, telf;
    
    public PanelDatosCliente() {
    	
    	this.setLayout(new GridLayout());
    	
    	try {
    		// Configuración de máscaras
    		mascaraTelf = new MaskFormatter("#########");
    		telfCliente = new JFormattedTextField(mascaraTelf);
    		telfCliente.setFocusLostBehavior(telfCliente.COMMIT);
    		
    		mascaraDni = new MaskFormatter("########U");
            dniCliente = new JFormattedTextField(mascaraDni);
            dniCliente.setFocusLostBehavior(dniCliente.COMMIT);
            
    	} catch (ParseException e1){
    		e1.printStackTrace();
    	}
    	
        Box cajaH1 = Box.createHorizontalBox();
        Box cajaH2 = Box.createHorizontalBox();
        Box cajaH3= Box.createHorizontalBox();
        Box cajaVertical = Box.createVerticalBox();
        
        tituloCliente = new JLabel(" Datos del Cliente ");
        tituloCliente.setFont(new Font("Serif", 1, 20)); 

        nombre = new JLabel("Nombre: ");
        nombreCliente = new JTextField(50);

        apellidos = new JLabel("Apellidos: ");
        apellidosCliente = new JTextField(50);

        dni = new JLabel("DNI: ");

        telf = new JLabel("Nº Teléfono: ");

        // Añadimos los componentes a las cajas correspondientes
        cajaVertical.add(Box.createVerticalStrut(10));
        cajaH1.add(tituloCliente);

        cajaVertical.add(cajaH1);
        cajaVertical.add(Box.createVerticalStrut(30));
        
        cajaH2.add(Box.createHorizontalStrut(10));
        cajaH2.add(nombre);
        cajaH2.add(nombreCliente);
        cajaH2.add(Box.createHorizontalStrut(20));
        cajaH2.add(apellidos);
        cajaH2.add(apellidosCliente);
        cajaH2.add(Box.createHorizontalStrut(10));

        cajaVertical.add(cajaH2);
        cajaVertical.add(Box.createVerticalStrut(10));

        cajaH3.add(Box.createHorizontalStrut(10));
        cajaH3.add(dni);
        cajaH3.add(dniCliente);
        cajaH3.add(Box.createHorizontalStrut(20));
        cajaH3.add(telf);
        cajaH3.add(telfCliente);
        cajaH3.add(Box.createHorizontalStrut(10));

        cajaVertical.add(cajaH3);
        
        this.add(cajaVertical);

        this.setBackground(new Color(209, 205, 224)); // Color #d1cde0
        /*
         * Por ser complementario de #dce0cd - PanelTitulo
         */
    }
	
	@Override
	public void focusGained(FocusEvent e) {
		// No es necesario implementar nada aquí
	}

	@Override
	public void focusLost(FocusEvent e) {
		// No es necesario implementar nada aquí
	}
}
