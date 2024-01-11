/**
 * PanelFicha.java
 * 24 nov 2023 18:15:58
 * @author Marta García Fernández
 */
package swing_c_p02_GarciaFernandezMarta;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * 
 */
public class PanelFicha extends JTabbedPane{
	
	private JPanel panelCliente, panelAlojamiento;
	private JLabel etiqCliente, etiqAlojamiento;
	private String datos;
	static JTextArea datosCliente, datosAlojamiento;
	
	public PanelFicha() {
        
        this.setBackground(new Color(240, 240, 240)); // Color fondo #F0F0F0

        informacionCliente();
        informacionAlojamiento();

        this.add("Datos del Cliente", panelCliente);
        this.add("Datos del Alojamiento", panelAlojamiento);

        // Cambia el color de fondo de la segunda pestaña
        this.setBackgroundAt(1, new Color(51, 153, 153)); // Color #339999
    }

    private void informacionCliente() {
    	
        panelCliente = new JPanel();
        panelCliente.setBackground(new Color(255, 255, 255)); // Blanco
        panelCliente.setBorder(new EmptyBorder(10, 10, 10, 10)); // Borde vacío para separar los componentes del borde del panel

        etiqCliente = new JLabel("Datos del Cliente:");
        etiqCliente.setForeground(new Color(51, 153, 153)); // Color de texto #339999

        datos = "";
        datosCliente = new JTextArea(datos);
        datosCliente.setEditable(false);

        panelCliente.add(etiqCliente);
        panelCliente.add(datosCliente);
        this.add(panelCliente);
    }

    private void informacionAlojamiento() {
    	
        panelAlojamiento = new JPanel();
        panelAlojamiento.setBackground(new Color(255, 255, 255)); 
        panelAlojamiento.setBorder(new EmptyBorder(10, 10, 10, 10));

        etiqAlojamiento = new JLabel("Datos del Alojamiento:");
        etiqAlojamiento.setForeground(new Color(51, 153, 153));

        datos = "";
        datosAlojamiento = new JTextArea(datos);
        datosAlojamiento.setEditable(false);

        panelAlojamiento.add(etiqAlojamiento);
        panelAlojamiento.add(datosAlojamiento);
        this.add(panelAlojamiento);
    }
}
