package calculadora.dominio;

/**
 * Clase encargada de enumerar las distintas operaciones que se utilizarán en la
 * calculadora.<br>
 * SUMA: Sumará todos los datos que se le den<br>
 * RESTA: Restará todos los datos que se le den<br>
 * MULTIPLICACION: Multiplicará todos los datos que se le den<br>
 * DIVISION: Dividirá todos los datos que se le den<br>
 */

public enum TipoOperador {
	/**
	 * Atributos de TipoOperador que contienen cada un método que les permite
	 * calcular su operación en concreto
	 */
	SUMA("+") {
		@Override
		public double apply(double x, double y) {
			return x + y;
		}
	},
	RESTA("-") {
		@Override
		public double apply(double x, double y) {
			return y - x;
		}
	},
	MULTIPLICACION("*") {
		@Override
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVISION("/") {
		@Override
		public double apply(double x, double y) {
			return x / y;
		}
	};

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

	/**
	 * Método abstracto para poder calcular la suma, resta, multiplicación y
	 * división
	 * 
	 * @param x número 1 para la operación
	 * @param y número 2 para la operación
	 * @return el calculo en concreto
	 */

	public abstract double apply(double x, double y);
}
