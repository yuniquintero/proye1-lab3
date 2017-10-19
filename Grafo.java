
import java.util.*;
/**
 * Interfaz Grafo, la cual será implementada por las clases concretas Digrafo y GrafoNoDirigido.
 *
 * @author  Gustavo Castellanos
 * @author  Yuni Quintero
 */
public interface Grafo
{   
    /**
     * Carga en un grafo la información almacenada en el archivo de texto cuya dirección, incluyendo el 
     * nombre del archivo. Este método maneja los casos en los que haya problemas al
     * abrir un archivo y el caso en el que el formato del archivo sea incorrecto.
     * @param dirArchivo Dirección del archivo fuente.
     * @return true si los datos del archivo son cargados satisfactoriamente en el grafo, y false en caso contrario.
     */
    public boolean cargarGrafo(String dirArchivo);
    
    /**
     * Indica el numero de vertices.
     * @return Número de vértices.
     */
    public int numeroDeVertices();

    /**
     * Indica el número de lados.
     * @return Número de lados.
     */
    public int numeroDeLados();
    
    /**
     * Agrega el vértice <i>v</i> al grafo.
     * @param v Vértice a agregar.
     * @return true si en el grafo no hay vértice con el mismo identificador que el vértice, de lo contrario retorna false.
     */
    public boolean agregarVertice(Vertice v);

    /**
     * Agrega el vértice con identificador <i>id</i> y peso <i>peso</i> al grafo.
     * @param id Identificador del vértice a agregar
     * @param peso Peso del vértice a agregar.
     * @return true si en el grafo no hay vértice con identificador id, de lo contrario retorna false.
     */
    public boolean agregarVertice(String id, double peso);
    
    /**
     * Retorna el vértice contenido en el grafo que posee el identificador <i>id</i>.
     * @param id Identificador del vértice a obtener.
     * @return Vértice con identificador id.
     * @throws NoSuchElementException Si no existe en el grafo un vértice con el identificador pasado como parametro.
     */
    public Vertice obtenerVertice(String id) throws NoSuchElementException;

    /**
     * Se indica si un vértice con el identificador id, se encuentra o no en el grafo.
     * @param id Identificador del vértice.
     * @return true en caso de que el vértice pertenezca al grafo, false en caso contrario.
     */
    public boolean estaVertice(String id);

    /**
     * Determina si un lado pertenece a un grafo. La entrada son los identificadores de los vértices que
     * son los extremos del lado. En caso de ser aplicada esta función con un grafo dirigido, se tiene que u
     * corresponde al extermo inicial y v al extermo final.
     * @param u Identificador de un extremo del lado.
     * @param v Identificador de un extremo del lado.
     * @return true si se encuentra el lado en el grafo, false en caso contrario.
     */
    public boolean estaLado(String u, String v);

    /**
     * Elimina el vértice del grafo g.
     * @param id Identificador del vértice.
     * @return  Si existe un vértice identificado con id y éste es eliminado exitosamente del grafo se retorna true, 
     * en caso contrario false
     */
    public boolean eliminarVertice(String id);

    /**
     * Retorna una lista con los vértices del grafo.
     * @return Lista con los vértice del grafo.
     */
    public List<Vertice> vertices();

    /**
     * Retorna una lista con los lados del grafo.
     * @return Lista con los lados del grafo.
     */
    public List<Lado> lados();

    /**
     * Cálcula el grado de un vertice del grafo.
     * @param id Identificador del vértice.
     * @return Grado del vértice con identificador id.
     * @throws NoSuchElementException Si el grafo no contiene al vértice con identificador id.
     */
    public int grado(String id) throws NoSuchElementException;

    /**
     * Obtiene los vértices adyacentes a un vértice con identificador <i>id</i>.
     * @param id Identificador del vértice.
     * @return Lista con los vértices adyacentes al vértice.
     * @throws NoSuchElementException Si el grafo no contiene al vértice con identificador id.
     */
    public List<Vertice> adyacentes(String id) throws NoSuchElementException;
 
    /**
     * Obtiene los vértices incidentes a un vértice con identificador <i>id</i>.
     * @param id Identificador del vértice.
     * @return Lista con los lados incidentes al vértice con identificador id.
     * @throws NoSuchElementException Si el grafo no contiene el vértice con identificador id.
     */
    public List<Lado> incidentes(String id) throws NoSuchElementException;

    /**
     * Realiza una copia profunda del grafo.
     * @return Nuevo grafo con la misma composición que el grafo.
     * @throws CloneNotSupportedException [description]
     */
    public Object clone() throws CloneNotSupportedException;

    /**
     * Devuelve una representación del contenido del grafo como una cadena de caracteres en el mismo formato en el
     * que está el archivo a cargar en {@link Grafo#cargarGrafo}.
     * @return String con la información del contenido del grafo.
     */
    public String toString();
    
}