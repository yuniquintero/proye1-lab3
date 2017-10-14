/**
*
*/

public class Arco extends Lado {
	private Vertice extremoInicial;
	private Vertice extremoFinal;

	public Arco(String id, double peso, Vertice extremoInicial, Vertice extremoFinal) {
		super(id,peso);
		this.extremoInicial = extremoInicial;
		this.extremoFinal = extremoFinal;
	}

	public Vertice getExtremoInicial() {
		return this.extremoInicial;
	}

	public Vertice getExtremoFinal() {
		return this.extremoFinal;
	}

	public String toString() {
		return "id: " + this.getId() + ", peso: " + String.valueOf(this.getPeso()) + ", extremo inicial: " + this.extremoInicial.getId() + ", extremo final: " + this.extremoFinal.getId();
	}
}