package calculadora.app;

/**
 * Clase Main que simplemente se encarga de crear un objeto de tipo gestor de la
 * calculadora y que ese gestor ejecute el método ejecutarComando para así el
 * usuario pueda utilizar el programa
 */
public class Main {
	public void main() {
		GestorCalculadora gestor = new GestorCalculadora();
		gestor.ejecutarComando();
	}

	public static void main(String[] args) {
		new Main().main();
	}

}
