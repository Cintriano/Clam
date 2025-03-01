package clam;

public class Math {
	public static String mathing(String msg) {
		Integer coeficiente_angular = Integer.parseInt(msg);
		Integer coeficiente_linear = 6;
		Integer variavel_independente = 3;
		Integer variavel_dependente = (coeficiente_angular * variavel_independente) + coeficiente_linear;
		return Integer.toString(variavel_dependente);
	}
	
	public static String anmath(String msg) {
		Integer coeficiente_angular = Integer.parseInt(msg);
		Integer coeficiente_linear = 6;
		Integer variavel_independente = 3;
		Integer variavel_dependente = (coeficiente_angular - coeficiente_linear) / variavel_independente;
		return Integer.toString(variavel_dependente);
	}
}
