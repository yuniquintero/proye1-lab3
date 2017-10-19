/**
 * Implementacion de la clase Arco, la cual
 * corresponde a los lados de un grafo
 * dirigido.
 *
 * @author  Gustavo Castellanos
 * @author  Yuni Quintero
 */
public class Arco extends Lado {
	/**
	 * extremo inicial del arco.
	 */
	private Vertice extremoInicial;
	/**
	 * extremo final del arco
	 */
	private Vertice extremoFinal;

	/**
	 * Constructor.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @param id Identificador del arco
	 * @param peso Peso del arco
	 * @param extremoInicial extremo inicial del arco
	 * @param extremoFinal extremo final del arco
	 */
	public Arco(String id, double peso, Vertice extremoInicial, Vertice extremoFinal){
		super(id,peso);
		crearArco(id,peso,extremoInicial,extremoFinal);
	}

	/**
	 * Da valores a los atributos de arco.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @param id Identificador del arco
	 * @param peso Peso del arco
	 * @param extremoInicial extremo inicial del arco
	 * @param extremoFinal extremo final del arco
	 */
	public void crearArco(String id, double peso, Vertice extremoInicial, Vertice extremoFinal) {
		this.extremoInicial = extremoInicial;
		this.extremoFinal = extremoFinal;
	}

	/**
	 * Obtiene el vertice que es el extremo inicial del arco.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return Extremo inicial del arco.
	 */
	public Vertice getExtremoInicial() {
		return this.extremoInicial;
	}

	/**
	 * Obtiene el vertice que es el extremo final del arco.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return Extremo final del arco.
	 */
	public Vertice getExtremoFinal() {
		return this.extremoFinal;
	}

	/*
	Metodo toString: Retorna la representacion en String del arco
	Parametros: Arco
	Salida: String que representa el arco
	Orden: O(1)
	*/
	/**
	 * Retorna la representacion en String del arco con el siguiente formato: <i>identificador</i> 
	 * <i>extremoInicial</i> <i>extremoFinal</i> <i>peso</i>.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return Cadena de caracteres con la informacion del arco.
	 */
	public String toString() {
		return getId() + " " + getExtremoInicial().getId() + " " + getExtremoFinal().getId() + " " + String.valueOf(getPeso());
	}
}