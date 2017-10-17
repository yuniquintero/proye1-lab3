public class Vertice {
	private String id;
	private double p;

	public Vertice(String id, double p) {
		this.id = id;
		this.p = p;
	}

	public double getPeso() {
		return p;
	}

	public String getId() {
		return id;
	}

	public String toString() {
		return "{id: " + this.id + ", peso: " + String.valueOf(this.p) + "}";
	}

	public Object clone() {
		return (new Vertice(this.id, this.p));
	}
}