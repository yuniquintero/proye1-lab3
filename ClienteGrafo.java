/**
 *
 */

import java.util.*;

public class ClienteGrafo {
	public static void main(String [] args) throws NoSuchElementEception {
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
		String[] tok;
		while (true) {
			try {
				s = scan.nextLine();
				tok = s.split(" ");
				// imprimir grado de id
				if (tok[0] == "grado") {
					System.out.println(g.grado(tok[1]));
				}
				else if (tok[0] == "ady") {
					System.out.println(g.adyacentes(tok[1]).toString());
				}
				else if (tok[0] == "inc") {
					SYstem.out.println(g.incidentes(tok[1]).toString());
				}
				else if (tok[0] == "prnt") {
					System.out.println(g.toString());
				}
				else if (tok[0] == "op") {
					printOpciones();
				}
				else {
					System.out.println("Entrada Inválida. Intente de nuevo.\n");
				}
			}
			catch (NoSuchElementEception e) {
				System.out.println("ERROR: No existe tal elemento.");
			}
		}

	}

	public void printOpciones() {
		System.out.println("grado <id> para obtener el grado del vertice con identificador <id>");
		System.out.println("ady <id> para obtener los adyacentes del vertice con identificador <id>");
		System.out.println("inc <id> para obtener los incidentes del vertice con identificador <id>");
		System.out.println("prnt para llamar Grafo.toString()");
		System.out.println("op para imprimir las opciones de nuevo");
		System.out.println("\n\n");
	}
}