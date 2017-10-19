/**
* 
*/
import java.lang.Exception;
import java.util.*;
import java.io.*;




//PRE Y POST



public class Digrafo implements Grafo{
    /*
    Atributos:
    -. n: entero, numero de vertices, m: entero, numero de arcos
    -. adyList: Hashtable, tabla de hash con keys igual al id del vertice, 
    el valor siendo una lista arcos adyacentes
    -. vList: Hashtable, tabla de hash con keys igual al id del vertice,
    el valor siendo un Vertice
    -. aList: Hashtable, tabla de hash con keys igual al id del arco,
    el valor siendo un Arco
    */
    private int n, m; 
    private Hashtable <String,Vector<Arco>> adyList;             
    private Hashtable <String, Vertice> vList;
    private Hashtable <String, Arco> aList;

    // Constructor del Digrafo

    public Digrafo() {
        this.adyList = new Hashtable<String,Vector<Arco>>();
        this.vList = new Hashtable<String,Vertice>();
        this.aList = new Hashtable<String, Arco>();
        this.n = 0;
        this.m = 0;
    }

    /* 
    Metodo cargarGrafoDirigido: Carga en un grafo la informacion almacenada 
    en el archivo de texto
    Parametros: Digrafo, direccion del archivo de texto
    Salida: true si se logro cargar el grafo de manera exitosa, false si no
    Orden: O(n+m) (n: cantidad de vertices, m: cantidad de arcos)
    */

    public boolean cargarGrafo(String dirArchivo){
        try{
            BufferedReader in = new BufferedReader(new FileReader(dirArchivo));
            int numV, numA;
            // leemos cantidad de vertices y arcos
            numV = Integer.parseInt(in.readLine());
            numA = Integer.parseInt(in.readLine());
            //leemos vertices
            for(int i=0;i<numV;i++){
                String line = in.readLine();
                String[] tok = line.split(" ");
                if(tok.length!=2){
                    return false;
                }
                String id = tok[0];
                double p = Double.parseDouble(tok[1]);
                agregarVertice(id, p);
            }
            //leemos arcos
            for (int i=0;i<numA;i++) {
                String line = in.readLine();
                String[] tok = line.split(" ");
                if(tok.length!=4){
                    return false;
                }
                String id, u, v;
                double p;
                id = tok[0];
                u = tok[1];
                v = tok[2];
                p = Double.parseDouble(tok[3]);
                agregarArco(id, p, u, v);
            }

            return true;//return false?
        }
        catch (IOException e) {
            return false;
        }
    }

    /*
    Metodo numeroDeVertices: Indica el numero de vertices que posee el grafo
    Parametros: Digrafo
    Salida: entero n, cantidad de vertices en el grafo
    Orden: O(1)
    */

    public int numeroDeVertices() {
        return this.n;
    }

    /*
    Metodo numeroDeLados: Indica el numero de lados que posee el grafo
    Parametros: Digrafo
    Salida: entero m, cantidad de lados en el grafo
    Orden: O(1)
    */

    public int numeroDeLados() {
        return this.m;
    }

    /*
    Metodo agregarVertice: Agrega el vertice v al grafo
    Parametros: Digrafo, Vertice v que sera agregado
    Salida: true si el vertice no se encuentra en el grafo y se agrega con exito, 
    false si lo contrario
    Orden: O(1)
    */

    public boolean agregarVertice(Vertice v) {
        if(!estaVertice(v.getId())){ //si el grafo no contiene ya al vertice
            this.vList.put(v.getId(), v);
            this.adyList.put(v.getId(),new Vector<Arco>());
            this.n++;
            return true;
        }
        return false;
    }

    /*
    Metodo agregarVertice: Agrega el vertice v al grafo
    Parametros: Digrafo, String id (identificador del vertice), 
    double peso (peso del vertice)
    Salida: true si el vertice no se encuentra en el grafo y se agrega con exito, 
    false si lo contrario
    Orden: O(1)
    */

    public boolean agregarVertice(String id, double peso) {
        Vertice u = new Vertice(id, peso); //creamos un nuevo Vertice
        return agregarVertice(u);
    }

    /*
    Metodo obtenerVertice: Retorna el vertice contenido en el grafo que 
    posee el identificador id
    Parametros: Digrafo, String id (identificador del vertice que se retornara)
    Salida: Vertice
    Orden: O(1)
    */
    
    public Vertice obtenerVertice(String id) throws NoSuchElementException{
        if(this.vList.containsKey(id)){
            return this.vList.get(id);
        }
        throw new NoSuchElementException();
    }

    /*
    Metodo estaVertice: Se indica si un vertice con el identificador id, 
    se encuentra o no en el grafo
    Parametros: Digrafo, String id (identificador del vertice a buscar)
    Salida: true si el grafo posee el vertice, false si no
    Orden: O(1)
    */

    public boolean estaVertice(String id) {
        if(this.vList.containsKey(id)){
            return true;
        }
        return false;
    }

    /*
    Metodo estaLado: Determina si un lado pertenece a un grafo
    Parametros: Digrafo, String u (identificador del extremo inicial del lado), 
                String v (identificador del extremo final del lado)
    Salida: true si el grafo posee el lado, false si no
    Orden: O(m) (m: cantidad de arcos)
    */

    public boolean estaLado(String u, String v){
        Iterator<Lado> it = this.lados().iterator();
        while(it.hasNext()){ //iteramos sobre la lista lados() para buscar el lado (u,v)
            Lado l = it.next();
            Arco a = this.aList.get(l.getId());
            if(u.equals(a.getExtremoInicial().getId()) && v.equals(a.getExtremoFinal().getId())){
                return true;
            }
        }
        return false;
    }
    
    /*
    Metodo eliminarVertice: Elimina el vertice del grafo
    Parametros: Digrafo, String id (identificador del vertice a eliminar)
    Salida: true si el vertice se encuentra en el grafo y fue eliminado 
    con exito, false si no
    */

    public boolean eliminarVertice(String id) {
        if(estaVertice(id)){
            this.vList.remove(id);
            this.n--;
            this.adyList.remove(id);
            Iterator<Lado> it = this.lados().iterator();
            while(it.hasNext()){ //eliminamos arcos adyacentes al vertice eliminado
                Lado l = it.next();
                Arco a = this.aList.get(l.getId());
                Vertice u = a.getExtremoInicial(), v = a.getExtremoFinal();
                if(id.equals(u.getId()) || id.equals(v.getId())){
                    if(id.equals(v.getId())){
                        this.adyList.get(u.getId()).remove(a);
                    }
                    this.aList.remove(a.getId());
                    this.m--;
                }
            }
            return true;
        }
        return false;
    }

    /*
    Metodo vertices: Retorna una lista con los v ́ertices del grafo
    Parametros: Digrafo
    Salida: lista que contiene los vertices del grafo
    */

    public List<Vertice> vertices() {
        ArrayList<Vertice> arr = new ArrayList<Vertice>(this.vList.values());
        return arr;
    }

    /*
    Metodo lados: Retorna una lista con los lados del grafo
    Parametros: Digrafo
    Salida: lista que contiene los lados del grafo
    */

    public List<Lado> lados() {
        ArrayList<Lado> arr = new ArrayList<Lado>(this.aList.values());
        return arr;
    }

    /*
    Metodo grado: Calcula el grado del vertice identificado por id en el grafo
    Parametros: Digrafo, String id (identificador del vertice al que se le calculara el grado)
    Salida: entero, grado del vertice
    Orden: O(m) (m: cantidad de arcos)
    */

    public int grado(String id) throws NoSuchElementException{
        if(estaVertice(id)){
            return gradoInterior(id) + gradoExterior(id);
        }
        throw new NoSuchElementException();
    }

    /*
    Metodo adyacentes: Obtiene los vertices adyacentes al vertice identicado por id en el grafo
    Parametros: Digrafo, String id (identificador del vertice)
    Salida: lista que contiene los vertices adyacentes
    */

    public List<Vertice> adyacentes(String id) throws NoSuchElementException{
        if(estaVertice(id)){
            ArrayList<Vertice> ady = new ArrayList<Vertice>();
            List<Vertice> suc = sucesores(id);
            Iterator<Vertice> it1 = suc.iterator();
            int c=0;
            while(it1.hasNext()){
                Vertice u = it1.next();
                if(!ady.contains(u)){
                    ady.add(u); //insertamos vertices sucesores
                }
            }
            List<Vertice> pre = predecesores(id);
            Iterator<Vertice> it2 = pre.iterator();
           while(it2.hasNext()){
                Vertice u = it2.next();
                if(!ady.contains(u)){
                    ady.add(u); //insertamos vertices predecesores
                }
            }
            return ady;
        }
        throw new NoSuchElementException();
    }

    /*
    Metodo: incidentes: Obtiene los lados incidentes al vertice identificado por id en el grafo
    Parametros: Digrafo, String id (identificador del vertice)
    Salida: lista que contiene los lados incidentes al vertice
    Orden: O(m) (m: cantidad de vertices)
    */

    public List<Lado> incidentes(String id) throws NoSuchElementException{
         if(estaVertice(id)){
            Vector<Lado> in = new Vector<Lado>();
            Iterator<Lado> it = this.lados().iterator();
            while(it.hasNext()){ //buscamos arcos con extremo final v
                Lado l = it.next();
                Arco a = this.aList.get(l.getId());
                Vertice v = a.getExtremoFinal();
                if(id.equals(v.getId())){
                    in.add(l);
                }
            }
            return in;
        }
        throw new NoSuchElementException();

    }

    /*
    Metodo clone: Retorna un nuevo grafo con la misma composici ́on que el grafo de entrada
    Parametros: Digrafo
    Salida: Digrafo
    */

    public Object clone() {
        Digrafo g = new Digrafo();
        Set<String> keys = this.adyList.keySet();
        Iterator<String> itr = keys.iterator();
        while(itr.hasNext()){
            String k = itr.next();
            g.adyList.put(k, this.adyList.get(k));
        }
        keys = this.vList.keySet();
        itr = keys.iterator();
        while(itr.hasNext()){
            String k = itr.next();
            g.aList.put(k, this.aList.get(k));
        }
        return g;
    }
    
    /*
    Metodo toString: Devuelve una representacion del contenido del grafo como una cadena de caracteres
    Parametros: Digrafo
    Salida: representacion del grafo como un String
    */

    public String toString() {
        String ret = new String();
        Set<String> keys = adyList.keySet();
        Iterator<String> itr = keys.iterator();
        while(itr.hasNext()) {
            String k = itr.next();
            ret += k + ": ";
            ret += adyList.get(k).toString(); 
        }

        return ret; 
    }

    /*
    Metodo agregarArco: Agrega un nuevo arco al grafo
    Parametros: Digrafo, Arco a que sera agregado
    Salida: true si el arco no pertenecia al grafo y fue agregado con exito,
    false si no
    Orden: O(1)
    */

    public boolean agregarArco(Arco a) {
        if(!this.aList.containsKey(a.getId())){
            this.aList.put(a.getId(),a);
            this.adyList.get(a.getExtremoInicial().getId()).add(a);
            this.m++;
            return true;
        }
        return false;
    } 

    /*
    Metodo agregarArco: Agrega un nuevo arco al grafo
    Parametros: Digrafo, String id (identificador del arco), double peso (peso del arco),
    String eInicial (identificador del extremo inicial del arco),
    String eFinal (identificador del extremo final del arco) 
    Salida: true si el arco no pertenecia al grafo y fue agregado con exito,
    false si no
    Orden: O(1)
    */

    public boolean agregarArco(String id, double peso, String eInicial, String eFinal){
        if (estaVertice(eInicial) && estaVertice(eFinal)) {
            Vertice u = this.vList.get(eInicial), v = this.vList.get(eFinal);
            Arco a = new Arco(id,peso,u,v);//creamos nuevo arco
            return agregarArco(a);
        }
        else {
            return false;
        }
    }
    
    /*
    Metodo gradoInterior: Calcula el grado interior del vertice identificado por id en el grafo
    Parametros: Digrafo, String id (identificador del vertice)
    Salida: entero, grado interior del vertice
    Orden: O(m) (m: cantidad de arcos)
    */

    public int gradoInterior(String id) throws NoSuchElementException{
        if(estaVertice(id)){
            int c=0;
            Iterator<Lado> it = this.lados().iterator();
            while(it.hasNext()){ //buscamos en lista() arcos que tengan como entremo final v
                Lado l = it.next();
                Arco a = this.aList.get(l.getId());
                Vertice u = a.getExtremoInicial(), v = a.getExtremoFinal();
                if(id.equals(v.getId())){
                    c++;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    /*
    Metodo gradoExterior: Calcula el grado exterior del vertice identificado por id en el grafo
    Parametros: Digrafo, String id (identificador del vertice)
    Salida: entero, grado exterior del vertice
    Orden: O(1)
    */

    public int gradoExterior(String id) throws NoSuchElementException{
        if(estaVertice(id)){
            return adyList.get(id).size();
        }
        throw new NoSuchElementException();
    }

    /*
    Metodo sucesores: Devuelve una lista con los vertices que son sucesores 
    del vertice con identificador id
    Parametros: Digrafo, String id (identificador del vertice)
    Salida: lista que contiene los vertices sucesores
    Orden: O(n) (n: cantidad de vertices)
    */

    public List<Vertice> sucesores(String id) throws NoSuchElementException  {
        if(estaVertice(id)){
            Vector<Arco> vec = this.adyList.get(id);
            Iterator<Arco> it = vec.iterator();
            Vector<Vertice> suc = new Vector<Vertice>();
            while(it.hasNext()){ //insertamos elementos de la lista de adyacencia
                Arco a = it.next();
                if(!suc.contains(a.getExtremoFinal())){
                    suc.add(a.getExtremoFinal());
                }
            }
            return suc;
        }
        throw new NoSuchElementException();
    }

    /*
    Metodo predecesores: Devuelve una lista con los vertices que son predecesores 
    del vertice con identificador id
    Parametros: Digrafo, String id (identificador del vertice)
    Salida: lista que contiene los vertices predecesores
    */

    public List<Vertice> predecesores(String id) throws NoSuchElementException{
        if(estaVertice(id)){
            Vector<Vertice> pre = new Vector<Vertice>();
            Iterator<Lado> it = this.lados().iterator();
            while(it.hasNext()){ //buscamos en lista() arcos que tengan como entremo final v
                Lado l = it.next();
                Arco a = this.aList.get(l.getId());
                Vertice u = a.getExtremoInicial(), v = a.getExtremoFinal();
                if(id.equals(v.getId())){
                    if(!pre.contains(u)){
                        pre.add(u);
                    }
                }
            }
            return pre;
        }
        throw new NoSuchElementException();
    }

    /*
    Metodo eliminarArco: Elimina el arco en el grafo que este identificado con id
    Parametros: Digrafo, String id (identificador del arco)
    Salida: true si el arco fue eliminado con exito, false si no
    Orden: 
    */

    public boolean eliminarArco(String id) {
        if(this.aList.containsKey(id)){
            Arco a = aList.get(id);
            Vertice u = a.getExtremoInicial(), v = a.getExtremoFinal();
            this.adyList.get(u.getId()).remove(a);
            this.aList.remove(id);
            this.m--;
            return true;
        }
        return false;
    }

    /*
    Metodo obtenerArco: Devuelve el arco que tiene como identificador id
    Parametros: Digrafo, String id (identificador del arco)
    Salida: arco
    Orden: O(1)
    */

    public Arco obtenerArco(String id) throws NoSuchElementException{
        if(this.aList.containsKey(id)){
            return this.aList.get(id);
        }
        throw new NoSuchElementException();
    }
}