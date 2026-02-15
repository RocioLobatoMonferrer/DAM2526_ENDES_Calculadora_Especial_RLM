package calculadora.dominio;

/**
 * Clase que se encarga almacenar en el historial la operación y su resultado
 */

public class Operacion {

	private String operacion;
	private double resultado;

	/**
	 * Crea un objeto Operación en el que se debe entregar la operación y un
	 * resultado para esa operación
	 * 
	 * @param operacion  Operación compuesta por operadores y operandos
	 * @param resultadob Resultado de la operación en si
	 */
	public Operacion(String operacion, double resultado) {
		this.operacion = operacion;
		this.resultado = resultado;
	}

	/**
	 * Método qeu devuelve la operación más su resultado
	 * 
	 * @return cadena de texto en el que indica la operación y su resultado
	 */
	public String toString() {
		return String.format("%s = %.2f\n", operacion, resultado);
	}
}
