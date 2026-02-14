package calculadora.app;

import calculadora.dominio.Calculadora;
import calculadora.dominio.Operacion;
import calculadora.dominio.ResultadoAnalisis;
import calculadora.dominio.TipoComando;

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

	public void ejecutarComando() {
		do {
			operacion = consola.leerTexto(">");
			resultadoAnalisis = analiza.analizar(operacion, calculadora.getResultadoActual());
			switch (resultadoAnalisis.comando()) {
			case LIST -> {
				consola.escribirLinea(calculadora.list());
			}
			case RESET -> {
				calculadora.reset();
				consola.escribirLinea("Se han borrado correctamente los datos");
			}
			case RESULT -> {
				consola.escribirLinea(String.format("%.2f", calculadora.getResultadoActual()));
			}
			case QUIT -> {
				consola.escribirLinea("Cerrando...");
			}
			case CALCULO -> {
				calculadora.realizarCalculo(resultadoAnalisis.numeros(), resultadoAnalisis.operadores(), operacion);
				consola.escribirLinea(String.format("%.2f", calculadora.getResultadoActual()));
			}
			case ERROR -> {
				consola.escribirLinea(resultadoAnalisis.mensajeError());
			}
			}
		} while(resultadoAnalisis.comando() != TipoComando.QUIT);
		consola.cerrar();
		
	}

}
