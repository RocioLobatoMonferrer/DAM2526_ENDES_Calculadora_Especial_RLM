package calculadora.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {
	private Scanner sc;

	public Consola() {
		this.sc = new Scanner(System.in);
	}

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
	 * Muestra un texto por consola sin salto de línea.
	 *
	 * @param texto Texto que se desea mostrar.
	 */

	public void escribir(String texto) {
		System.out.print(texto);
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

	/**
	 * Muestra un mensaje por consola y lee un texto no vacío. Si el usuario
	 * introduce una cadena vacía o solo con espacios, se vuelve a pedir el dato.
	 *
	 * @param mensaje Mensaje que se muestra antes de la lectura.
	 * @return Texto no vacío introducido por el usuario.
	 */

	public String leerTextoNoVacio(String mensaje) {
		String texto = "";
		while (texto.isBlank()) {
			escribirLinea(mensaje);
			texto = sc.nextLine();
			texto = texto.trim();
			if (texto.isBlank()) {
				escribirLinea("ERROR - No puede estar vacío.");
			}
		}
		return texto;
	}

	/**
	 * Muestra un mensaje por consola y lee un número entero. Si el valor
	 * introducido no es un entero válido, se vuelve a pedir.
	 *
	 * @param mensaje Mensaje que se muestra antes de la lectura.
	 * @return Número entero introducido por el usuario.
	 */

	public int leerEntero(String mensaje) {
		escribirLinea(mensaje);
		int num = 0;
		boolean error;
		do {
			try {
				error = false;
				num = sc.nextInt();
			} catch (InputMismatchException e) {
				error = true;
				escribir(String.format("Error: El valor introducido no es correcto o sale del rango %d -- %d",
						Integer.MIN_VALUE, Integer.MAX_VALUE));
			} finally {
				sc.nextLine();
			}
		} while (error);
		return num;
	}

	/**
	 * @param mensaje Mensaje que se muestra antes de la lectura.
	 * @param min     Valor mínimo permitido (incluido).
	 * @param max     Valor máximo permitido (incluido).
	 * @return Número entero dentro del rango indicado.
	 */

	public int leerEnteroRango(String mensaje, int min, int max) {
		int numero = leerEntero(mensaje);
		while (numero < min || numero > max) {
			escribirLinea("ERROR - Debe estar entre " + min + " y " + max + ".");
			numero = leerEntero(mensaje);
		}
		return numero;
	}
}