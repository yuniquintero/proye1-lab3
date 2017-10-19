/**
 * Implementacion de la clase abstracta Lado, la cual representa
 * a los pares del conjunto E del grafo.
 *
 * @author  Gustavo Castellanos
 * @author  Yuni Quintero
 */

public abstract class Lado {

	/**
	 * Identificador del lado.
	 */
	private String id;

	/**
	 * Peso del lado.
	 */
	private double peso;

	/**
	 * Constructor.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @param id Identificador del lado.
	 * @param peso Peso del lado.
	 */
	public Lado(String id, double peso) { //CREARLADO
		crearLado(id,peso);
	}

	/**
	 * Asigna valores a los atributos del lado.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @param id Identificador del lado.
	 * @param peso Peso del lado.
	 */
	public void crearLado(String id, double peso){
		this.id = id;
		this.peso = peso;
	}

	/**
	 * Obtiene el identificador del lado.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return Identificador del lado.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Obtiene el peso del lado.
	 * <br><br><h5 style="display: inline;">Complejidad:</h5>
	 * <br><i>O(1)</i>.
	 * @return Peso del lado.
	 */
	public double getPeso() {
		return this.peso;
	}

	/**
	 * Retorna la representacion en String del arco.
	 * @return Cadena de caracteres con la informacion del ado.
	 */
	public abstract String toString();

}