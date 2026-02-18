package calculadora.app;

import java.util.Scanner;

/**
 * Clase encargada de la entrada y salida por consola
 */

public class Consola implements IEntradaSalida {
	private Scanner sc;

	/**
	 * Crea un objeto Consola e inicializa el lector de entrada estándar.
	 */

	public Consola() {
		this.sc = new Scanner(System.in);
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public void cerrar() {
		this.sc.close();
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public void escribirLinea(String texto) {
		System.out.println(texto);
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public String leerTexto(String mensaje) {
		escribirLinea(mensaje);
		String texto = sc.nextLine();
		return texto.trim();
	}
}
