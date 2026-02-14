package calculadora.app;

public class Main {
	public void main() {
		GestorCalculadora gestor = new GestorCalculadora();
		gestor.ejecutarComando();
	}
	public static void main(String[] args) {
		new Main().main();
	}

}
