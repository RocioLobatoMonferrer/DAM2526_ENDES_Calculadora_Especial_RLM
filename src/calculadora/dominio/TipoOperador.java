package calculadora.dominio;

/**
 * Clase encargada de enumerar las disntinas operaciones que se utilizarán en la
 * calculadora.<br>
 * SUMA: Sumará todos los datos que se le den<br>
 * RESTA: Restará todos los datos que se le den<br>
 * MULTIPLICACION: Multiplicará todos los datos que se le den<br>
 * DIVISION: Dividirá todos los datos que se le den<br>
 */

/**
 * Método que define los tipos de operadores que se usarán en la calculadora
 */

public enum TipoOperador {
	SUMA("+"), RESTA("-"), MULTIPLICACION("*"), DIVISION("/");

	private String simbolo;

	/**
	 * Método que crea el tipo de operador que se utilizará en la operación para
	 * calcular el resultado
	 * 
	 * @param simbolo Simbolo que se debe demostrar
	 */

	TipoOperador(String simbolo) {
		this.simbolo = simbolo;
	}

	/**
	 * Método que devuelve el simbolo
	 * 
	 * @return simbolo de la operación
	 */
	public String getSimbolo() {
		return simbolo;
	}
}
