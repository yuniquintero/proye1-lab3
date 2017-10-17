/**
 * 
 */

import java.util.*;

public interface Grafo
{
    public boolean cargarGrafo(String dirArchivo);
    
    public int numeroDeVertices();

    public int numeroDeLados();
    
    public boolean agregarVertice(Vertice v);

    public boolean agregarVertice(String id, double peso);
    
    public Vertice obtenerVertice(String id) throws NoSuchElementException;

    public boolean estaVertice(String id);

    public boolean estaLado(String u, String v);

    public boolean eliminarVertice(String id);

    public List<Vertice> vertices();

    public List<Lado> lados();

    public int grado(String id) throws NoSuchElementException;

    public List<Vertice> adyacentes(String id) throws NoSuchElementException;
 
    public List<Lado> incidentes(String id) throws NoSuchElementException;

    public Object clone() throws CloneNotSupportedException;

    public String toString();
    
}