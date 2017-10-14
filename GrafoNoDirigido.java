/**
 * 
 */

import java.util.*;
import java.io.*;

public class GrafoNoDirigido
{
    private int n, // numero de vertices
                m; // numero de aristas
    private Hashtable<String, Vector<Arista>> adyList;
    private Hashtable<String, Vertice> vertices;

    public GrafoNoDirigido() {
        adyList = new Hashtable< String, Vector<Arista> >();
        vertices = new Hashtable<String, Vertice>();
    }

    public boolean cargarGrafo(String dirArchivo) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(dirArchivo));
        this.n = Integer.parseInt(in.readLine());
        this.m = Integer.parseInt(in.readLine());

        // Leer vertices
        for (int i=0; i<n; i++) {
            String line = in.readLine();
            String[] tok = line.split(" ");
            String id = tok[0];
            int p = Integer.parseInt(tok[1]);
            agregarVertice(id, p);
        }

        // Leer aristas
        for (int i=0; i<m; i++) {
            String line = in.readLine();
            String[] tok = line.split(" ");
            String id, u, v;
            int p;
            id = tok[0];
            u = tok[1];
            v = tok[2];
            p = Integer.parseInt(tok[3]);
            agregarArista(id, p, u, v);
        }

        return true;
    }
    
    public int numeroDeVertices() {
        return n;
    }

    public int numeroDeLados() {
        return m;
    }
   
    public boolean agregarVertice(Vertice v) {
        if (estaVertice(v.getId())) {
            return false;
        }
        else {
            vertices.put(v.getId(), v);
            adyList.put(v.getId(), new Vector <Arista>());
            return true;
        }
    }

    public boolean agregarVertice(String id, double peso) {
        return agregarVertice(new Vertice(id, peso));
    }
    /*
    public Vertice obtenerVertice(String id) {
    }
    */

    public boolean estaVertice(String id) {
        return vertices.containsKey(id);
    }
    /*
    public boolean estaLado(String u, String v){
    }

    public boolean eliminarVertice(String id) {
    }

    public List<Vertice> vertices() {
    }

    public List<Lado> lados() {
    }

    public int grado(String id) {
    }

    public List<Vertice> adyacentes(String id) {
    }
 
    public List<Lado> incidentes(String id) {
    }

    public Object clone() {
    }

    */
    public String toString() {
        return adyList.toString();
    }

    public boolean agregarArista(Arista a) {
        String id = a.getId();
        double peso = a.getPeso();
        Vertice u = a.getExtremo1(), v = a.getExtremo2();
        adyList.get(u.getId()).add(a);
        adyList.get(v.getId()).add(a);
        return true;
    }
    public boolean agregarArista(String id, double peso, String u, String v) {
        return agregarArista(new Arista(id, peso, vertices.get(u), vertices.get(v)));
    }
    /*
    public boolean eliminarArista(String id) {
    }

    public Arista obtenerArista(String id) {
    }
    */
}