package calculadora.dominio;

/**
 * Clase encargada de enumerar los disntinos comandos que se utilizarán en la
 * calculadora.<br>
 * LIST: mostrar una lista de las operaciones<br>
 * RESET: borrar las operaciones<br>
 * RESULT: guardar el resultado de la última operación<br>
 * QUIT: salir del programa<br>
 * CALCULO: realizar el cálculo<br>
 * ERROR: marcar un error<br>
 */

/**
 * Método que define los tipos de comando que se usarán en la calculadora
 */

public enum TipoComando {
	LIST("list"), RESET("reset"), RESULT("result"), QUIT("quit"), CALCULO("calculo"), ERROR("error");

	private String comando;

	/**
	 * Método que crea el tipo de comando que se utilizará en la calculadora
	 * 
	 * @param comando Comando que se debe demostrar
	 */

	TipoComando(String comando) {
		this.comando = comando;
	}

	/**
	 * Método que devuelve el comando
	 * 
	 * @return comando de la operación
	 */

	public String getComando() {
		return comando;
	}
}
