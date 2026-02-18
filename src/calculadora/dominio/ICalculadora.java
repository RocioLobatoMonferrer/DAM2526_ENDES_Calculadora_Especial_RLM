package calculadora.dominio;

import java.util.List;

/**
 * Interfaz exclusivamente para Calculadora
 */
public interface ICalculadora {
	/**
	 * Método que devuelve el historial
	 * 
	 * @return historial de todas las operaciones realizadas
	 */
	public List<Operacion> getHistorial();

	/**
	 * Método que devuelve el resultado actual, es decir, el útlimo que se calculo
	 * 
	 * @return resultadoActual de la última operación y si no, cero
	 */
	public double getResultadoActual();

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
	public void realizarCalculo(List<Double> numeros, List<TipoOperador> operadores, String operacion);

	/**
	 * Método que que permite el comando 'reset'<br>
	 * Resetea la calculadora, volviendo a cero el resultado y limpiando la Lista
	 * del historial
	 */
	public void reset();

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
	public String list();
}
