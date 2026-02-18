package calculadora.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de ejecutar el calculo que pida el usuario, crear las
 * funciones de list y reset, crear la operación para poder ser calculada y
 * obtener el resultado actual y el historial de operaciones
 */

public class Calculadora implements ICalculadora {
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
	 * {@inheritDoc}
	 */

	@Override
	public List<Operacion> getHistorial() {
		return historial;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
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
	 * {@inheritDoc}
	 */

	@Override
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
	 * {@inheritDoc}
	 */

	@Override
	public void reset() {
		resultadoActual = 0;
		historial.clear();
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
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
