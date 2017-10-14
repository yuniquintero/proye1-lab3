/**
* 
*/

public abstract class Lado {
	private String id;
	private double peso;

	public Lado(String id, double peso) {
		this.id = id;
		this.peso = peso;
	}

	public String getId() {
		return this.id;
	}

	public double getPeso() {
		return this.peso;
	}

	public String toString(){
		return "id: " + this.id + ", peso: " + String.valueOf(this.peso);
	}

}