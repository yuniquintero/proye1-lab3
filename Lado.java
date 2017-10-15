/**
* 
*/

public abstract class Lado {

	/*
	Atributos:
	id: String, identificador del lado
	peso: double, peso del lado
	*/

	private String id;
	private double peso;

	//Constructor

	public Lado(String id, double peso) { //CREARLADO
		crearLado(id,peso);
	}

	public void crearLado(String id, double peso){
		this.id = id;
		this.peso = peso;
	}

	/*
	Metodo getId: Obtiene el identificador del lado
	Parametros: Lado
	Salida: String con el id
	*/

	public String getId() {
		return this.id;
	}

	/*
	Metodo getPeso: Obtiene el peso del lado
	Parametros: Lado
	Salida: double con el peso
	*/

	public double getPeso() {
		return this.peso;
	}

	/*
	Metodo toString: Retorna la representacion en String del lado
	Parametros: Lado
	Salida: String que representa el lado
	*/

	public String toString(){
		return "id: " + this.id + ", peso: " + String.valueOf(this.peso);
	}

}