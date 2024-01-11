/**
 * PanelTitulo.java
 * 22 nov 2023 18:54:42
 * @author Marta García Fernández
 */
package swing_c_p02_GarciaFernandezMarta;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */
public class PanelTitulo extends JPanel {

	private JLabel titulo, icono;
	private ImageIcon imagen;
	private Image logo, imagenModificada;
	
	public PanelTitulo() {
		
		titulo = new JLabel(" ~ PandAccommodation ~ ");
		titulo.setFont(new Font("Kokonor", Font.BOLD, 48)); // Funte MacOS pero disponible en Windows
		
		imagen = new ImageIcon(getClass().getResource("/recursos/logo2.png"));
		logo = imagen.getImage();
		imagenModificada = logo.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		imagen = new ImageIcon(imagenModificada);
		icono = new JLabel(imagen);
		
		this.add(titulo);
		this.add(icono);
		
		this.setBackground(new Color(220, 224, 205)); // Color #dce0cd
	}
}
