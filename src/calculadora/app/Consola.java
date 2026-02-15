package calculadora.app;

import java.util.Scanner;

/**
 * Clase encargada de la entrada y salida por consola
 */

public class Consola {
	private Scanner sc;

	/**
	 * Crea un objeto Consola e inicializa el lector de entrada estándar.
	 */

	public Consola() {
		this.sc = new Scanner(System.in);
	}

	/**
	 * Método que se encarga de cerrar la consola al final del programa.
	 */

	public void cerrar() {
		this.sc.close();
	}

	/**
	 * Muestra un texto por consola seguido de un salto de línea.
	 *
	 * @param texto Texto que se desea mostrar.
	 */

	public void escribirLinea(String texto) {
		System.out.println(texto);
	}

	/**
	 * Muestra un mensaje por consola y lee una línea de texto introducida por el
	 * usuario.
	 *
	 * @param mensaje Mensaje que se muestra antes de la lectura.
	 * @return Texto introducido por el usuario, sin espacios iniciales ni finales.
	 */

	public String leerTexto(String mensaje) {
		escribirLinea(mensaje);
		String texto = sc.nextLine();
		return texto.trim();
	}
}
