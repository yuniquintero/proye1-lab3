/**
 * 
 */

import java.util.*;
import java.io.*;
import java.lang.Cloneable;

public class GrafoNoDirigido implements Cloneable
{
    /*
        ATRIBUTOS
    */
    private int n, // numero de vertices
                m; // numero de aristas
    private Hashtable<String, Vector<Arista>> adyList;
    private Hashtable<String, Vertice> vertices;
    private Hashtable<String, Arista> aristas;

    /*
        METODOS
    */

    // CONSTRUCTOR
    public GrafoNoDirigido() {
        adyList = new Hashtable< String, Vector<Arista> >();
        vertices = new Hashtable<String, Vertice>();
        aristas = new Hashtable<String, Arista>();
        n = 0; 
        m = 0;
    }

    public boolean cargarGrafo(String dirArchivo) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(dirArchivo));
            int N = Integer.parseInt(in.readLine());
            int M = Integer.parseInt(in.readLine());

            // Leer vertices
            for (int i=0; i<N; i++) {
                String line = in.readLine();
                String[] tok = line.split(" ");
                // si el formato es incorrecto
                if (tok.length != 2) {
                    return false;
                }
                String id = tok[0];
                double p = Double.parseDouble(tok[1]);
                agregarVertice(id, p);
            }

            // Leer aristas
            for (int i=0; i<M; i++) {
                String line = in.readLine();
                String[] tok = line.split(" ");
                // si el formato es incorrecto
                if (tok.length != 4) {
                    return false;
                }
                String id, u, v;
                Double p;
                id = tok[0];
                u = tok[1];
                v = tok[2];
                p = Double.parseDouble(tok[3]);
                agregarArista(id, p, u, v);
            }

            return true;
        }
        catch (Exception e) {
            return false;
        }
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
            this.n += 1;
            return true;
        }
    }

    public boolean agregarVertice(String id, double peso) {
        return agregarVertice(new Vertice(id, peso));
    }

    public Vertice obtenerVertice(String id) throws NoSuchElementException {
        if (vertices.containsKey(id)) {
            return vertices.get(id);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public boolean estaVertice(String id) {
        return vertices.containsKey(id);
    }
    public boolean estaLado(String u, String v) {
        // Busco en los adyacentes de u
        Vector<Arista> adyU = adyList.get(u);
        Iterator<Arista> itr = adyU.iterator();
        while (itr.hasNext()) {
            Arista e = itr.next();
            if (e.getExtremo2().getId().equals(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean eliminarVertice(String id) {
        if (vertices.containsKey(id)) {
            vertices.remove(id); // lo removemos del diccionario de vertices
            adyList.remove(id); // lo eliminamos de la lista de adyacencias

            // iteramos sobre los lados para encontrar los incidentes a id
            Set<String> keys = aristas.keySet();
            Iterator<String> itr = keys.iterator();
            while (itr.hasNext()) {
                String s = itr.next(); // identificador del lado
                Arista e = aristas.get(s); // lado correspondiente
                Vertice u = e.getExtremo1(), v = e.getExtremo2(); // extremos de la arista
                if (u.getId().equals(id) || v.getId().equals(id)) { // si uno de los extremos es id
                    if (u.getId().equals(id)) { // si u es id
                        // remuevo la arista e de la lista de adyacencias de v
                        adyList.get(v.getId()).remove(e);
                    }
                    else { // si v es id
                        // remuevo la arista e de la lista de adyacencias de u
                        adyList.get(u.getId()).remove(e);
                    }
                    itr.remove(); // eliminamos el lado del diccionario aristas
                }
            }

            return true;
        }
        else {
            return false;
        }
    }

    public List<Vertice> vertices() {
        Vector<Vertice> vList = new Vector<Vertice>(vertices.values());
        return vList;
    }

    public List<Lado> lados() {
        Vector<Lado> aList = new Vector<Lado>(aristas.values());
        return aList;
    }

    public int grado(String id) throws NoSuchElementException {
        if (adyList.containsKey(id)) {
            return adyList.get(id).size();
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public List<Vertice> adyacentes(String id) throws NoSuchElementException {
        Vector<Vertice> adyacentes = new Vector<Vertice>();
        // iteramos sobre la lista de adyacencia del vertice de identificador id
        if (adyList.containsKey(id)) {
            Vector<Arista> adyU = adyList.get(id);
            Iterator<Arista> itr = adyU.iterator();
            while(itr.hasNext()) {
                Arista a = itr.next();
                Vertice v = ((a.getExtremo1().getId().equals(id)) ? a.getExtremo2() : a.getExtremo1());
                adyacentes.add(v);
            }

            return adyacentes;
        }
        else {
            throw new NoSuchElementException();
        }
    }
 
    public List<Lado> incidentes(String id) throws NoSuchElementException {
        if (vertices.containsKey(id)) {
            Vector<Lado> ret = new Vector<Lado>(); // lista a retornar
            // Iteramos sobre las aristas
            Set<String> keys = aristas.keySet();
            Iterator<String> itr = keys.iterator();
            while (itr.hasNext()) {
                String k = itr.next();
                Arista a = aristas.get(k);
                Vertice u = a.getExtremo1(), v = a.getExtremo2();
                // si uno de los vertices tiene identificador id
                if (u.getId().equals(id) || v.getId().equals(id)) {
                    ret.add(a);
                }
            }
            return ret;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        String ret = new String();
        Set<String> keys = adyList.keySet();
        Iterator<String> itr = keys.iterator();
        while(itr.hasNext()) {
            String k = itr.next();
            ret += "Vertice con id " + k + ": ";
            ret += adyList.get(k).toString() + "\n"; // Aristas Incidentes del vertice con identificador k
        }

        return ret; 
    }

    public boolean agregarArista(Arista a) {
        if (!aristas.containsKey(a.getId())) {
            this.m += 1;
            String id = a.getId(); // identificador de a
            double peso = a.getPeso(); // peso de a
            Vertice u = a.getExtremo1(), v = a.getExtremo2(); // extremos de a
            adyList.get(u.getId()).add(a); // agregamos a en la lista de adyacencias de u
            if (!u.getId().equals(v.getId())) {
                adyList.get(v.getId()).add(a); // agregams a en la lista de adyacencias de v
            }
            aristas.put(a.getId(), a); // agregamos a al diccionario de aristas
            return true;
        }
        else {
            return false;
        }
    }
    public boolean agregarArista(String id, double peso, String u, String v) {
        return agregarArista(new Arista(id, peso, vertices.get(u), vertices.get(v)));
    }

    public boolean eliminarArista(String id) {
        if (aristas.containsKey(id)) {
            Arista a = aristas.get(id);
            Vertice u = a.getExtremo1(), v = a.getExtremo2();
            adyList.get(u.getId()).remove(a); // la eliminamos de la lista de adyaencia de u
            adyList.get(v.getId()).remove(a); // la eliminamos de la lista de adyacencia de v
            // la eliminamos del diccionario
            aristas.remove(id);
            return true;
        }
        else {
            return false;
        }
    }

    public Arista obtenerArista(String id) throws NoSuchElementException {
        if (aristas.containsKey(id)) {
            return aristas.get(id);
        }
        else {
            throw new NoSuchElementException();
        }
    }
}