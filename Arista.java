/**
 * Implementacion de la clase Arista, la cual
 * corresponde a los lados de un grafo
 * no dirigido.
 *
 * @author  Gustavo Castellanos
 * @author  Yuni Quintero
 */
public class Arista extends Lado {
	/**
	 * Primer vertice incidente a la arista.
	 */
	private Vertice u;
	/**
	 * Segundo vertice incidente a la arista.
	 */
	private Vertice v;
	/**
	 * Identificador de la arista.
	 */
	private String id;
	/**
	 * Peso de la arista.
	 */
	private double peso;

	/**
	 * Metodo constructor.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @param id Identificador de la arista 
	 * @param peso Peso de la arista
	 * @param u Primer vertice incidente a la arista
	 * @param v Segundo vertice incidente a la arista
	 */
	public Arista(String id, double peso, Vertice u, Vertice v) {
		super(id, peso);
		this.u = u;
		this.v = v;
	}

	/**
	 * Metodo que obtiene el primer vertice incidente a la arista.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return Primer vertice incidente a la arista
	 */
	public Vertice getExtremo1() {
		return u;
	}

	/**
	 * Metodo que obtiene el segundo vertice incidente a la arista.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return Segundo vertice incidente a la arista
	 */
	public Vertice getExtremo2() {
		return v;
	}

	/**
	 * Metodo que devuelve una cadena de caracteres conteniendo
	 * la informacion de la arista con el siguiente formato: <i>identificador</i> 
	 * <i>extremo1</i> <i>extremo2</i> <i>peso</i>.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return Cadena de caracteres con la informacion de la arista.
	 */
	public String toString() {
		return getId() + " " + getExtremo1().getId() + " " + getExtremo2().getId() + " " + String.valueOf(getPeso());
	}
}