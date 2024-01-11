/**
 * Main.java
 * 15 nov 2023 19:27:59
 * @author Marta García Fernández
 */
package swing_c_p02_GarciaFernandezMarta;

import java.awt.Dimension;


/**
 * 
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Añadimos lo siguiente debido a un mensaje de advertencia específico de Java en macOS
		System.setProperty("apple.awt.application.supportsSecureRestorableState", "true");

		Ventana miVentana = new Ventana();

		// Establecemos un tamaño mínimo para la ventana
		miVentana.setMinimumSize(new Dimension(miVentana.getWidth(), miVentana.getHeight()));
	}
}