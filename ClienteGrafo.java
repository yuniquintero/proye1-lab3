/**
 *
 */

import java.util.*;

public class ClienteGrafo {
	public static void main(String [] args) {
		GrafoNoDirigido g = new GrafoNoDirigido();

		if (!g.cargarGrafo(args[0])) {
			// si se leyó bien el archivo
			System.out.println("Error al cargar el archivo");
			return;
		}

		System.out.print("Numero de Vertices: ");
		System.out.println(g.numeroDeVertices());

		System.out.print("Vertices: ");
		System.out.println(g.vertices().toString());

		System.out.print("Numero de lados: ");
		System.out.println(g.numeroDeLados());

		System.out.print("Lados: ");
		System.out.println(g.lados().toString());

		Scanner scan = new Scanner(System.in); // para leer input
		String s;
		String[] tok;
		printOpciones();
		while (true) {
			try {
				s = scan.nextLine();
				tok = s.split(" "); // opcion del usuario
				// imprimir grado de id
				if (tok[0].equals("grado")) {
					System.out.println(g.grado(tok[1]));
				}
				// imprimir adyacentes de id
				else if (tok[0].equals("ady")) {
					System.out.println(g.adyacentes(tok[1]).toString());
				}
				// imprimir incidentes de id
				else if (tok[0].equals("inc")) {
					System.out.println(g.incidentes(tok[1]).toString());
				}
				// imprimir grafo
				else if (tok[0].equals("prnt")) {
					System.out.println(g.toString());
				}
				// imprimir opciones
				else if (tok[0].equals("op")) {
					printOpciones();
				}
				// salir
				else if (tok[0].equals("salir")) {
					break;
				}
				else {
					System.out.println("Entrada Inválida " + tok[0] + ". Intente de nuevo.\n");
				}
			}
			catch (NoSuchElementException e) {
				System.out.println("ERROR: No existe tal elemento.");
			}
		}

	}

	public static void printOpciones() {
		// Opciones del usuario
		System.out.println("\n\ngrado <id>\tpara obtener el grado del vertice con identificador <id>");
		System.out.println("ady <id>\tpara obtener los adyacentes del vertice con identificador <id>");
		System.out.println("inc <id>\tpara obtener los incidentes del vertice con identificador <id>");
		System.out.println("prnt\tpara llamar Grafo.toString()");
		System.out.println("op\tpara imprimir las opciones de nuevo");
		System.out.println("salir\tpara salir del programa");
		System.out.println("\n");
	}
}