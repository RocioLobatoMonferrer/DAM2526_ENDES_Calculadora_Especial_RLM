package calculadora.app;

/**
 * Interfaz exclusivamente para Consola
 */
public interface IEntradaSalida {
	/**
	 * Método que se encarga de cerrar la consola al final del programa.
	 */
	public void cerrar();

	/**
	 * Muestra un texto por consola seguido de un salto de línea.
	 *
	 * @param texto Texto que se desea mostrar.
	 */
	public void escribirLinea(String texto);

	/**
	 * Muestra un mensaje por consola y lee una línea de texto introducida por el
	 * usuario.
	 *
	 * @param mensaje Mensaje que se muestra antes de la lectura.
	 * @return Texto introducido por el usuario, sin espacios iniciales ni finales.
	 */
	public String leerTexto(String mensaje);
}
