package calculadora.app;

import calculadora.dominio.Calculadora;
import calculadora.dominio.Operacion;
import calculadora.dominio.ResultadoAnalisis;

public class GestorCalculadora {
	private Consola consola;
	private Analizador analiza;
	private ResultadoAnalisis resultadoAnalisis;
	private Calculadora calculadora;
	private String operacion;

	public GestorCalculadora() {
		consola = new Consola();
		analiza = new Analizador();
		calculadora = new Calculadora();
	}

	public void ejecutarComandos() {
		switch (resultadoAnalisis.comando()) {
		case LIST -> {

		}
		case RESET -> {
			calculadora.reset();
		}
		case RESULT -> {

		}
		case QUIT -> {
			consola.escribirLinea("");
		}
		case CALCULO -> {

		}
		case ERROR -> {

		}
		}
		;
	}

}
