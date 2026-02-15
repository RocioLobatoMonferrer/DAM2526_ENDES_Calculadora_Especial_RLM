package calculadora.app;

import calculadora.dominio.Calculadora;
import calculadora.dominio.Operacion;
import calculadora.dominio.ResultadoAnalisis;
import calculadora.dominio.TipoComando;

/**
 * Clase que se encarga de gestionar todo el proceso de la Calculadora,
 * principalmente sus comandos, además de que las clases Analizador,
 * ResultadoAnalisis puedan analizar las operaciones de la Calculadora
 */

public class GestorCalculadora {
	/**
	 * Objeto Consola que se encarga de todo relacionado a la comunicación y entrada
	 * del usuario
	 */
	private Consola consola;
	/**
	 * Objeto Analizador que se encarga de analizar las entradas del usuario y
	 * validar si son correctas o incorrectas
	 */
	private Analizador analiza;
	/**
	 * Objeto ResultadoAnalisis que se encarga de recibir los resultado que obtuvo
	 * la clase Analisis
	 */
	private ResultadoAnalisis resultadoAnalisis;
	/**
	 * Objeto Calculadora que se encarga que se puedan realizar las operaciones que
	 * desee el ussuario
	 */
	private Calculadora calculadora;
	private String operacion;

	public GestorCalculadora() {
		consola = new Consola();
		analiza = new Analizador();
		calculadora = new Calculadora();
	}

	/**
	 * Método que ejecuta el comando que solicite el usuario<br>
	 * Primero se analiza que la entrada del usuario es valida<br>
	 * Después, dependiendo del comando, se eligirá uno de los siguientes casos:<br>
	 * 
	 * LIST: Llama al método de la Calculadora 'list' para pintar la lista <br>
	 * RESET: Llama al método de la Calculadora 'reset' para limpiarla y se le avisa
	 * la usuario de esta limpieza <br>
	 * RESULT: Se le imprime al usuario el último resultado al usuario y en el caso
	 * de que se utilice como operando, sustituirá al valor de 'resultadoActual'<br>
	 * QUIT: Se le imprime un mensaje al usuario avisandole y luego se cierra la
	 * consola<br>
	 * ERROR: Se le imprime un mensaje al usuario que dependerá del error que
	 * encuentre en Analizador<br>
	 * 
	 * Todo esto se repetira en un bucle hasta que se ejecuté la opeción QUIT y
	 * cerrará la consola
	 */
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
		} while (resultadoAnalisis.comando() != TipoComando.QUIT);
		consola.cerrar();

	}

}
