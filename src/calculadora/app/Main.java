package calculadora.app;

import calculadora.dominio.Calculadora;

/**
 * Clase principal donde ejecutará el gestor de calculadora
 */
public class Main {
	public void main() {
		/**
		 * Creación de los objetos consola, analizador, calculadora y gestor de la
		 * calculadora
		 */
		Consola consola = new Consola();
		Analizador analiza = new Analizador();
		Calculadora calculadora = new Calculadora();
		GestorCalculadora gestor = new GestorCalculadora(consola, analiza, calculadora);

		gestor.ejecutarComando();
	}

	public static void main(String[] args) {
		new Main().main();
	}

}
