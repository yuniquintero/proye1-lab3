/**
*
*/

public class Arco extends Lado {

	/*
	Atributos:
	extremoInicial: Vertice, extremo inicial del arco
	extremoFinal: Vertice, extremo final del arco
	*/

	private Vertice extremoInicial;
	private Vertice extremoFinal;


	// Constructor

	public Arco(String id, double peso, Vertice extremoInicial, Vertice extremoFinal){
		super(id,peso);
		crearArco(id,peso,extremoInicial,extremoFinal);
	}

	public void crearArco(String id, double peso, Vertice extremoInicial, Vertice extremoFinal) {
		this.extremoInicial = extremoInicial;
		this.extremoFinal = extremoFinal;
	}

	/*
	Metodo getExtremoInicial: Obtiene el vertice que es el extremo inicial del arco
	Parametros: Arco
	Salida: Vertice (extremo inicial del arco)
	*/

	public Vertice getExtremoInicial() {
		return this.extremoInicial;
	}

	/*
	Metodo getExtremoFinal: Obtiene el vertice que es el extremo final del arco
	Parametros: Arco
	Salida: Vertice (extremo final del arco)
	*/

	public Vertice getExtremoFinal() {
		return this.extremoFinal;
	}

	/*
	Metodo toString: Retorna la representacion en String del arco
	Parametros: Arco
	Salida: String que representa el arco
	*/

	public String toString() {
		return "id: " + this.getId() + ", peso: " + String.valueOf(this.getPeso()) + ", extremo inicial: " + this.extremoInicial.getId() + ", extremo final: " + this.extremoFinal.getId();
	}
}