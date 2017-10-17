/**
 *
 */

import java.util.*;

public class ClienteGrafo {
	public static void main(String [] args) {
		GrafoNoDirigido g = new GrafoNoDirigido(), G = new GrafoNoDirigido();

		if (args.length > 0 && !G.cargarGrafo(args[0])) {
			// si se leyó bien el archivo
			System.out.println("Error al cargar el archivo");
			return;
		}
		// si no se le fue cargado un grafo 
		if (args.length > 0) {
			System.out.print("\n\nNumero de Vertices: ");
			System.out.println(G.numeroDeVertices());

			System.out.print("Vertices: ");
			System.out.println(G.vertices().toString());

			System.out.print("Numero de lados: ");
			System.out.println(G.numeroDeLados());

			System.out.print("Lados: ");
			System.out.println(G.lados().toString());
		}
		try {
			g = (GrafoNoDirigido)G.clone();
		}
		catch (Exception e) {
			System.out.println("Error Clonando");
			return;
		}
		Scanner scan = new Scanner(System.in); // para leer input
		String s;
		String[] tok;
		printOpciones();
		while (true) {
			try {
				s = scan.nextLine();
				tok = s.split(" "); // opcion del usuario
				// agregar vertice
				if (tok[0].equals("+") && !tok[1].equals("")) {
					if(g.agregarVertice(tok[1], Double.parseDouble(tok[2]))) {
						System.out.println("\tVertice agregado exitosamente");
					}
					else {
						System.out.println("\tEl vertice ya existe");
					}
				}
				// eliminar vertice
				else if (tok[0].equals("-") && !tok[1].equals("")) {
					if(g.eliminarVertice(tok[1])) {
						System.out.println("\tVertice eliminado exitosamente");
					}
					else {
						System.out.println("\tEl vertice no existe");
					}
				}
				// agregar arista
				else if (tok[0].equals("add") && !tok[1].equals("") && !tok[2].equals("") && !tok[3].equals("")) {
					if (g.agregarArista(tok[1], Double.parseDouble(tok[4]), tok[2], tok[3])) {
						System.out.println("\tLado agregado exitosamente");
					}
					else {
						System.out.println("\tEl lado ya existe");
					}
				}
				// eliminar arista
				else if (tok[0].equals("del") && !tok[1].equals("")) {
					if (g.eliminarArista(tok[1])) {
						System.out.println("\tLado eliminado exitosamente");
					}
					else {
						System.out.println("\tEl lado no existe");
					}
				}
				// imprimir grado de id
				else if (tok[0].equals("grado")) {
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
					System.out.println(G.toString());
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
					System.out.println("Entrada Inválida " + tok[0] + ". Intente de nuevo.");
				}
			}
			catch (NoSuchElementException e) {
				System.out.println("ERROR: No existe tal elemento.");
			}
			catch (Exception e) {
				System.out.println("ERROR: Entrada Inválida.");
			}
		}

	}

	public static void printOpciones() {
		// Opciones del usuario
		System.out.println("\n\n+ <id> <p>\tagrega un vertice de identificador <id> y peso <p>");
		System.out.println("- <id>\telimina el vertice con identificador <id>");
		System.out.println("add <idLado> <id1> <id2> <pesoLado>\tagrega un lado de identificador <idLado>, con los vertices de identificadores <id1> y <id2> como extremos y <pesoLado> como peso");
		System.out.println("del <idLado>\telimina el lado de identificador <idLado>");
		System.out.println("grado <id>\tpara obtener el grado del vertice con identificador <id>");
		System.out.println("ady <id>\tpara obtener los adyacentes del vertice con identificador <id>");
		System.out.println("inc <id>\tpara obtener los incidentes del vertice con identificador <id>");
		System.out.println("prnt\tpara llamar Grafo.toString()");
		System.out.println("op\tpara imprimir las opciones de nuevo");
		System.out.println("salir\tpara salir del programa");
		System.out.println("\n");
	}
}