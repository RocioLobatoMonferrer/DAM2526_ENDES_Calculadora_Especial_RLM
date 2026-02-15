package calculadora.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de ejecutar el calculo que pida el usuario, crear las
 * funciones de list y reset, crear la operación para poder ser calculada y
 * obtener el resultado actual y el historial de operaciones
 */

public class Calculadora {
	/**
	 * Lista que almacena todas las operaciones realizadas para cuando se llame a
	 * list<br>
	 * Empieza siempre en vacío
	 */

	private List<Operacion> historial;
	/**
	 * Último resultado de la última operación que se haya hecho<br>
	 * Empieza siempre en cero
	 */

	private double resultadoActual;

	/**
	 * Crea una calculadora la cual siempre empieza en cero/vació sus atributos
	 */

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

	/**
	 * Método que añade al historial la operación que entregue el usuario y su
	 * resultado
	 * 
	 * @param operacion Cadena de texto en la cual se puede observar la operación
	 *                  deseada por el usuario
	 */

	private void crearOperacion(String operacion) {
		historial.add(new Operacion(operacion, resultadoActual));
	}

	/**
	 * Método que escoge el primer número de la lista de numeros como resultado para
	 * poder calcular la operación que desee el usuario. Al final crea una operación
	 * para poder añadirse al historial
	 * 
	 * @param numeros    Lista de numeros que introdujo el usuario. Siempre serán
	 *                   pares
	 * @param operadores Lista de operadores que introdujo el usuario. Siempre serán
	 *                   impares
	 * @param operacion  Cadena de texto que tiene la operación del usuario
	 */

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

	/**
	 * Método que que permite el comando 'reset'<br>
	 * Resetea la calculadora, volviendo a cero el resultado y limpiando la Lista
	 * del historial
	 */

	public void reset() {
		resultadoActual = 0;
		historial.clear();
	}

	/**
	 * Método que permite el comando 'list'<br>
	 * Crea una lista en la cual se verá la operación con su resultado ordenados del
	 * primer hasta la última operación.<br>
	 * Si el historial está vacío, soltará un mensaje de error<br>
	 * Si todo es correcto, creará la lista y dará el resultado de la última
	 * operación
	 * 
	 * @return Cadena de texto que da la lista de operaciones y su último resultado
	 */

	public String list() {
		StringBuilder s = new StringBuilder("");
		List<Operacion> listaOperaciones = getHistorial();
		for (int i = 0; i < listaOperaciones.size(); i++) {
			s.append(String.format("%d\t%s\n", i + 1, listaOperaciones.get(i).toString()));
		}
		if (listaOperaciones.isEmpty()) {
			s.append("No hay ninguna operación realizada");
		} else {
			s.append(String.format("Resultado Actual: %.2f", getResultadoActual()));
		}
		return s.toString();
	}

}
