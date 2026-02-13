package calculadora.dominio;

/**
 * Clase que se encarga de que las operaciones se lleve a acabo y pinte el
 * historial
 */

public class Operacion {

	private String operacion;
	private double resultado;

	public Operacion(String operacion, double resultado) {
		this.operacion = operacion;
		this.resultado = resultado;
	}

	public String toString() {
		return String.format("%s = %.2f\n", operacion, resultado);
	}
}
