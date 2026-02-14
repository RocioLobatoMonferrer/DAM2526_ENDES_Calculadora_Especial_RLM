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
		this.historial = new ArrayList<>();
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

	private void crearOperacion(String operacion) {
		historial.add(new Operacion(operacion, resultadoActual));
	}

	public void realizarCalculo(List<Double> numeros, List<TipoOperador> operadores, String operacion) {
		resultadoActual = numeros.get(0);
		for (int i = 0; i < operadores.size(); i++) {
			Double num = numeros.get(i + 1);
			TipoOperador operador = operadores.get(i);
			switch (operador) {
			case SUMA -> {
				resultadoActual = TipoOperador.SUMA.apply(num, resultadoActual);
			}
			case RESTA -> {
				resultadoActual = TipoOperador.RESTA.apply(num, resultadoActual);
			}
			case MULTIPLICACION -> {
				resultadoActual = TipoOperador.MULTIPLICACION.apply(num, resultadoActual);
			}
			case DIVISION -> {
				resultadoActual = TipoOperador.DIVISION.apply(num, resultadoActual);
			}

			}
			;
		}
		crearOperacion(operacion);
	}

	public void reset() {
		resultadoActual = 0;
		historial.clear();
	}
	
	public String list() {
		StringBuilder s = new StringBuilder("");
		List<Operacion> listaOperaciones = getHistorial();
		for (int i = 0; i < listaOperaciones.size(); i++) {
			s.append(String.format("%d\t%s\n", i+1, listaOperaciones.get(i).toString()));
		}
		if(listaOperaciones.isEmpty()) {
			s.append("No hay ninguna operación realizada");
		} else {
			s.append(String.format("Resultado Actual: %.2f", getResultadoActual()));
		}
		return s.toString();
	}
	
}
