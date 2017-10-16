/**
 *
 */

import java.util.*;

public class ClienteGrafo {
	public static void main(String [] args) {
		GrafoNoDirigido g = new GrafoNoDirigido();
		g.cargarGrafo(test1.txt);
		System.out.print("Numero de Vertices: ");
		System.out.println(g.numeroDeVertices());

		System.out.print("Vertices: ");
		System.out.println(g.vertices().toString());

		System.out.print("Numero de lados: ");
		System.out.println(g.numeroDeLados());

		System.out.print("Lados: ");
		System.out.println(g.lados().toString());

		Scanner scan = new Scanner(System.in);
		String s;
		while (true) {
			s = scan.
		}

	}

	public void printOpciones() {
		System.out.println("grado <id> para obtener el grado del vertice con identificador <id>");
		System.out.println("ady <id> para obtener los adyacentes del vertice con identificador <id>");
		System.out.println("inc <id> para obtener los incidentes del vertice con identificador <id>");
		System.out.println("prnt para llamar Grafo.toString()");
		System.out.println("op para imprimir las opciones de nuevo");
	}
}