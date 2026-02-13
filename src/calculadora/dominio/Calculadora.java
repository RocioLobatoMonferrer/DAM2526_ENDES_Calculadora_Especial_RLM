package calculadora.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de ejecutar las operaciones, devolver el historial y
 * almacenar el resultado
 */

public class Calculadora {
	private List<Operacion> historial;
	private double resultadoActual;

	public Calculadora() {
		this.historial = new ArrayList<>(); // crea lista
		this.resultadoActual = 0;
	}

	/**
	 * Método que devuelve el historial
	 * 
	 * @return historial de todas las operaciones realizadas
	 */
	public List<Operacion> getHistorial() {
		return historial;
	}

	/**
	 * Método que devuelve el resultado actual, es decir, el útlimo que se calculo
	 * 
	 * @return resultadoActual de la última operación y si no, cero
	 */
	public double getResultadoActual() {
		return resultadoActual;
	}
}
