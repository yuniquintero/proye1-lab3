/**
 * Implementacion de la clase Vertice, la cual representa
 * a los elementos del grafo.
 *
 * @author  Gustavo Castellanos
 * @author  Yuni Quintero
 */
public class Vertice {
	private String id;
	private double p;

	/**
	 * Metodo constructor.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @param id Identificador
	 * @param p Peso
	 */
	public Vertice(String id, double p) {
		this.id = id;
		this.p = p;
	}

	/**
	 * Devuelve el peso.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return peso del vertice.
	 */
	public double getPeso() {
		return p;
	}

	/**
	 * Devuelve el identificador.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return identificador del vertice.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo que devuelve una cadena de caracteres conteniendo
	 * la informacion del vertice con el siguiente formato: <i>identificador</i> <i>peso</i>.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return Cadena de caracteres con la informacion del vertice.
	 */
	public String toString() {
		return getId() + " " + getPeso();
	}
}