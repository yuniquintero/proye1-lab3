public class Arista extends Lado {
	private Vertice u;
	private Vertice v;
	private String id;
	private double peso;

	public Arista(String id, double peso, Vertice u, Vertice v) {
		super(id, peso);
		this.u = u;
		this.v = v;
	}

	public Vertice getExtremo1() {
		return u;
	}

	public Vertice getExtremo2() {
		return v;
	}

	public String toString() {
		return "{id: " + this.getId() + ", peso: " + String.valueOf(this.getPeso()) + 
			", extremos: (" + u.getId() + ", " + v.getId() + ")}";
	}

	public Object clone() {
		return (new Arista(this.id, this.peso, this.u, this.v));
	}
}