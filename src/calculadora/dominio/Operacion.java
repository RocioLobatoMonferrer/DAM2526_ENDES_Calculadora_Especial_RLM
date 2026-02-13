package calculadora.dominio;

import java.util.List;

/**
 * Clase que se encarga de que las operaciones se lleve a acabo y pinte el
 * historial
 */

public class Operacion {

	private List<Double> numeros;
	private List<TipoOperador> operadores;

	public Operacion(List<Double> numeros, List<TipoOperador> operadores) {
		this.numeros = numeros;
		this.operadores = operadores;
	}

	// TODO: preguntar como se supone que agarre los numeros y los operadores
	public double calculo() {

	}

	// TODO: historial
	public String toString() {
		return String.format("");
	}
}
