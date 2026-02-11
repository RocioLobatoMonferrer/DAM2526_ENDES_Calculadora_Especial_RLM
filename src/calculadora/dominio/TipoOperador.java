package calculadora.dominio;

public enum TipoOperador {
	SUMA("+"), RESTA("-"), MULTIPLICACION("*"), DIVISION("/");

	private String simbolo;

	TipoOperador(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}
}
