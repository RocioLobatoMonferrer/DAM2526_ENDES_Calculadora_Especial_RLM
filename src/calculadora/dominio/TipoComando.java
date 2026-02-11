package calculadora.dominio;

/**
 * Clase encargada de analizar la entrada del usuario. Detecta comandos o
 * interpreta operaciones aritméticas (sin prioridad). Indica los tipos de
 * comandos: - mostrar una lista de las operaciones (list), - borrar las
 * operaciones (reset), - guardar el resultado de la última operación (result) -
 * salir del programa (quit) - realizar el cálculo (calculo) - marcar un error
 * (error)
 */
public enum TipoComando {
	LIST("list"), RESET("reset"), RESULT("result"), QUIT("quit"), CALCULO("calculo"), ERROR("error");

	private String comando;

	TipoComando(String comando) {
		this.comando = comando;
	}

	public String getComando() {
		return comando;
	}
}
