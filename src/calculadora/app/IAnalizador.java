package calculadora.app;

import calculadora.dominio.ResultadoAnalisis;

/**
 * Interfaz exclusivamente para Analizador
 */
public interface IAnalizador {
	/**
	 * Analiza la entrada del usuario.
	 *
	 * @param entrada         Línea introducida por el usuario.
	 * @param resultadoActual Último resultado de la calculadora (para sustituir
	 *                        "result").
	 * @return Resultado del análisis.
	 */
	public ResultadoAnalisis analizar(String entrada, double resultadoActual);

}
