/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Leonardo
 */
public class Grafo<T> {
    private int tamañoMaximo;
    private int tamaño;
    private ListaDoble vertices;
    private ListaDoble todasAristas;
    private Ciudad inicio;
    private Ciudad meta;
    
    public Grafo(int n){
       tamañoMaximo=n;
       tamaño=0;
       vertices= new ListaDoble();
       todasAristas= new ListaDoble();
    }
    public void agregarVertice(){
        Ciudad nCiudad=new Ciudad();
        vertices.append(nCiudad);
        tamaño+=1;
    }
    public ListaDoble getTodasAristas(){
        return this.todasAristas;
    }
    public void agregarArista(int ciudad1, int ciudad2,double distancia){
        Ciudad seleccion1=(Ciudad) vertices.searchByIndex(ciudad1).get();
        Ciudad seleccion2=(Ciudad) vertices.searchByIndex(ciudad2).get();
        Arista nArista= new Arista(seleccion1,seleccion2,distancia);
        seleccion1.getAristas().append(nArista);
        seleccion2.getAristas().append(nArista);
        todasAristas.append(nArista);
    }
    public void eliminarVertice(int indiceVertice){
       Ciudad pCiudad=(Ciudad)vertices.searchByIndex(indiceVertice).get();
       NodoDoble aux1=pCiudad.getAristas().getFirstNodo();
       
       while (aux1!=null){
           eliminarArista((Arista)aux1.get());
           aux1=aux1.nNext();
       }
       vertices.deleteByIndex(indiceVertice);
       
    }
    public void eliminarArista(Arista eArista){
       Ciudad c1=eArista.getC1();
       Ciudad c2=eArista.getC2();
       c1.getAristas().deleteByKey(eArista);
       c2.getAristas().deleteByKey(eArista);
       
    }
    public void cerrarCiclo(Hormiga hormiga){
        
    }
    public void iniciarEvaporacion(double coeficienteEv){
        NodoDoble aux=todasAristas.getFirstNodo();
        while(aux!=null){
            ((Arista)aux.get()).evaporacion(coeficienteEv);
            aux=aux.nNext();
        }
    }
    public Ciudad getInicio(){
        return this.inicio; 
        
    }
    public Ciudad getMeta(){
        return this.meta;
    }
    public void setInicio(int index){
        inicio=(Ciudad)vertices.searchByIndex(index).get();
    }
    public void setMeta(int index){
        meta=(Ciudad)vertices.searchByIndex(index).get();
    }
    
    
    
    
}
