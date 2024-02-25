/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */


//Estructura principal donde se ubican las ciudades y sus conexiones
//Se encuentra estructurado por listas de adyacencia 
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
    
    //agrega un vertice
    public void agregarVertice(){
        Ciudad nCiudad=new Ciudad();
        vertices.append(nCiudad);
        tamaño+=1;
    }
    
    //devuelve una lista con las aristas del grafo
    public ListaDoble getTodasAristas(){
        return this.todasAristas;
    }
    
    //devuelve una lista con los vertices del grafo
    public ListaDoble getVertices(){
        return vertices;
    }
    
    //retorna el tamaño del grafo
    public int getTamaño(){
        return tamaño;
    }
    
    //agrega una arista entre ciudades dados sus indices en la lista
    public void agregarArista(int ciudad1, int ciudad2,double distancia){
        //se seleccionan las ciudades a través de su índice
        Ciudad seleccion1=(Ciudad) vertices.searchByIndex(ciudad1).get();
        Ciudad seleccion2=(Ciudad) vertices.searchByIndex(ciudad2).get();
        NodoDoble aux= todasAristas.getFirstNodo();
        Boolean yaExistente=false;
        
        while (aux!=null ){
            //si la arista ya existe, se cambia su distancia
            if ((((Arista)aux.get()).getC1()==seleccion1 && ((Arista)aux.get()).getC2()==seleccion2 )|| (((Arista)aux.get()).getC1()==seleccion2 && ((Arista)aux.get()).getC2()==seleccion1)){
                ((Arista)aux.get()).setDistancia(distancia);
                yaExistente=true;
                break;
            }
            aux= aux.nNext();    
        }
        if (!yaExistente){
            //si no existe se crea
            Arista nArista= new Arista(seleccion1,seleccion2,distancia);
            seleccion1.getAristas().append(nArista);
            seleccion2.getAristas().append(nArista);
            todasAristas.append(nArista);
        }
        
    }
    
    //elimina un vertice dado su indice
    public void eliminarVertice(int indiceVertice){
       Ciudad pCiudad=(Ciudad)vertices.searchByIndex(indiceVertice).get();
       if (pCiudad.getAristas().getLen()!=1){
           // no se pueden eliminar ciudades que sirvan como puente, solo exteriores, para evitar que se parta el grafo
            JOptionPane.showMessageDialog(null , "Para evitar ciudades flotantes, no puede eliminar una ciudad con más de un camino. Proceda a eliminar caminos hasta que la ciudad quede aislada", "Error", JOptionPane.ERROR_MESSAGE );    
            
       }
       else{
           NodoDoble aux1=pCiudad.getAristas().getFirstNodo();
           while (aux1!=null){
               //se eliminan todas las aristas del vertice dentro del grafo
                eliminarArista((Arista)aux1.get());
                aux1=aux1.nNext();
            }
           //se elimina el vertice de, grafo
            vertices.deleteByIndex(indiceVertice);
            tamaño-=1;
       }
       
       
    }
    
    //elimina una arista
    public void eliminarArista(Arista eArista){
       //se toman las ciudades que conecta la arista y se elimina en ambas la arista
       Ciudad c1=eArista.getC1();
       Ciudad c2=eArista.getC2();
       c1.getAristas().deleteByKey(eArista);
       c2.getAristas().deleteByKey(eArista);
       todasAristas.deleteByKey(eArista);
       
    }
    
    //ejecuta la evaporación al final de cada ciclo
    public void iniciarEvaporacion(double coeficienteEv){
        //se recorren todas las aritas y se ejecuta la evaporacion
        NodoDoble aux=todasAristas.getFirstNodo();
        while(aux!=null){
            ((Arista)aux.get()).evaporacion(coeficienteEv);
            aux=aux.nNext();
        }
    }
    
    
    //los siguiente métodos devuelven el inicio y el final del recorrido respectivamente
    public Ciudad getInicio(){
        return this.inicio; 
    }
    public Ciudad getMeta(){
        return this.meta;
    }
    
    
    //los siguiente métodos permiten indicar cual es el inicio y el final del recorrido
    public void setInicio(int index){
        inicio=(Ciudad)vertices.searchByIndex(index).get();
    }
    public void setMeta(int index){
        meta=(Ciudad)vertices.searchByIndex(index).get();
    }
    
}
