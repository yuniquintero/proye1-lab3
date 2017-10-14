/**
* 
*/
import java.lang.Exception;
import java.util.*;
import java.io.*;


public class Digrafo {

    private int n=0, m=0;
    private Hashtable <String,Vector<Arco>> adyList;
    private Hashtable <String, Vertice> vList;
    private Hashtable <String, Arco> aList;

    public Digrafo() {
        this.adyList = new Hashtable<String,Vector<Arco>>();
        this.vList = new Hashtable<String,Vertice>();
        this.aList = new Hashtable<String, Arco>();
    }

    /*public boolean cargarGrafo(String dirArchivo) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader(dirArchivo));
        String linea;
        String[] tok;
        linea = in.readLine();
        this.n = (new Integer(linea)).intValue();
        linea = in.readLine();
        this.m = (new Integer(linea)).intValue();
    }*/

    public int numeroDeVertices() {
        return this.n;
    }

    public int numeroDeLados() {
        return this.m;
    }

    public boolean agregarVertice(Vertice v) {
        if(!estaVertice(v.getId())){
            this.vList.put(v.getId(), v);
            this.adyList.put(v.getId(),new Vector<Arco>());
            //this.n++
            return true;
        }
        return false;
    }

    public boolean agregarVertice(String id, double peso) {
        if(!estaVertice(id)){
            Vertice u = new Vertice(id, peso);
            this.vList.put(u.getId(), u);
            this.adyList.put(u.getId(),new Vector<Arco>());
            //this.m++
            return true;
        }
        return false;
        
    }
    
    public Vertice obtenerVertice(String id) {
        return this.vList.get(id);
    }

    public boolean estaVertice(String id) {
        if(this.vList.containsKey(id)){
            return true;
        }
        return false;
    }

    /*public boolean estaLado(String u, String v){

    }*/
    
    public boolean eliminarVertice(String id) {
        if(estaVertice(id)){
            this.vList.remove(id);
            this.adyList.remove(id);
            Iterator<Lado> it = this.lados().iterator();
            while(it.hasNext()){
                Arco a = this.aList.get(it.next().getId());
                Vertice v = a.getExtremoFinal();
                if(v.getId() == id){
                    Vertice u = a.getExtremoInicial();
                    this.adyList.get(u.getId()).remove(a);
                    this.aList.remove(it.next().getId());
                }
            }
            //this.n--
            //this.m--
            return true;
        }
        return false;
    }

    public List<Vertice> vertices() {
        ArrayList<Vertice> arr = new ArrayList<Vertice>(this.vList.values());
        return arr;
    }

    public List<Lado> lados() {
        ArrayList<Lado> arr = new ArrayList<Lado>(this.aList.values());
        return arr;
    }
/*
    public int grado(String id) {
        if(estaVertice(id)){
            return gradoInterior(id) + gradoExterior(id);
        }
    }

    public List<Vertice> adyacentes(String id) {
        if(estaVertice(id)){
            Vector<Vertice> ady = new Vector<Vertice>();
            Vector<Vertice> suc = sucesores(id);
            Iterator<Vertice> it1 = suc.iterator();
            while(it1.hasNext()){
                ady.add(it1.next());
            }
            Vector<Vertice> pre = predecesores(id);
            Iterator<Vertice> it2 = pre.iterator();
            while(it2.hasNext()){
                ady.add(it2.next());
            }
            return ady;
        }
    }

    public List<Lado> incidentes(String id) {
    }*/

    public Object clone() {
        Digrafo g = new Digrafo();
        g.adyList = this.adyList;
        g.vList = this.vList;
        g.aList = this.aList;
        return g;
    }
    
    public String toString() {
        return this.adyList.toString() + this.vList.toString() + this.aList.toString();
    }

    public boolean agregarArco(Arco a) {
         if(!this.aList.containsKey(a.getId())){
            this.aList.put(a.getId(),a);
            this.adyList.get(a.getExtremoInicial().getId()).add(a);
            return true;
        }
        return false;
    } 

    public boolean agregarArco(String id, double peso, String eInicial, String eFinal){
        Vertice u = this.vList.get(eInicial), v = this.vList.get(eFinal);
        Arco a = new Arco(id,peso,u,v);
        if(!this.aList.containsKey(id)){
            this.aList.put(id,a);
            this.adyList.get(eInicial).add(a);
            return true;
        }
        return false;
    }
    /*
    public int gradoInterior(String id) {
        if(estaVertice(id)){
            return predecesores(id).size();
        }
    }

    public int gradoExterior(String id) {
        if(estaVertice(id)){
            return sucesores(id).size();
        }
    }

    public List<Vertice> sucesores(String id) {
        if(estaVertice(id)){
            Vector<Arco> vec = this.adyList.get(id);
            Iterator<Arco> it = vec.iterator();
            Vector<Vertice> suc = new Vector<Vertice>();
            while(it.hasNext()){
                suc.add(it.next().getExtremoFinal());
            }
            return suc;
        }
    }

    public List<Vertice> predecesores(String id) {
    }

    public boolean eliminarArco(String id) {
    }*/

    public Arco obtenerArco(String id) {
        return this.aList.get(id);
    }
}