/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Leonardo
 */
public class App {
    Grafo grafo;
    Graph visualizador;
    ListaDoble hormigas;
    public App(){
        grafo=new Grafo(20);
        grafo.agregarVertice();
        visualizador= new SingleGraph("view");
        visualizador.setAutoCreate( true );
        visualizador.setAttribute("ui.stylesheet", styleSheet);
        System.setProperty("org.graphstream.ui", "swing"); 
        visualizador.setStrict(false);
        hormigas=new ListaDoble();
    }
    public void iniciarCiclo(int cHormigas, double a,double b, double q){
        NodoDoble hormi;
        hormigas=new ListaDoble();
            
        for (int j=0;j<cHormigas;j++){
            hormigas.append(new Hormiga());
        }
        hormi=hormigas.getFirstNodo();
        while(hormi!=null){
            System.out.println("Nueva hormiga");
            ((Hormiga)hormi.get()).iniciarRecorrido(grafo, a, b, q);
            hormi=hormi.nNext();
        }
        hormi=hormigas.getFirstNodo();
        NodoDoble aux;
        while(hormi!=null){
            aux=((Hormiga)hormi.get()).getCiudadesVisitadas().getFirstNodo();
            while(aux!=null){
                System.out.print(((Ciudad)aux.get()).getId());
                aux=aux.nNext();
            }
            System.out.print(" "+((Hormiga)hormi.get()).getRecorrido());
            System.out.println();
            hormi=hormi.nNext();
        }
        grafo.iniciarEvaporacion(0.5);
        NodoDoble aux1=grafo.getTodasAristas().getFirstNodo();
        while(aux1!=null){
            hormi=hormigas.getFirstNodo();
            while(hormi!=null){
                if(((Hormiga)hormi.get()).getAristasVisitadas().isPresent(aux1.get())){
                    ((Arista)aux1.get()).incrementoFeromona((Hormiga)hormi.get(),q);
                    //System.out.println("actualizando feromona, arista: "+((Ciudad)((Arista)aux1.get()).getC1()).getId()+((Ciudad)((Arista)aux1.get()).getC2()).getId()+" Nuevo valor: "+((Arista)aux1.get()).getFeromona());
                }
                hormi=hormi.nNext();
            }
            aux1=aux1.nNext();
        }
    }
    public void cargarVisualizador(){
        visualizador= new SingleGraph("view");
        visualizador.setAutoCreate( true );
        visualizador.setAttribute("ui.stylesheet", styleSheet);
        System.setProperty("org.graphstream.ui", "swing"); 
        visualizador.setStrict(false);
        NodoDoble aux1=grafo.getTodasAristas().getFirstNodo();
        while (aux1!=null){
        visualizador.addEdge(""+(int)((Arista)aux1.get()).getC1().getId()+""+(int)((Arista)aux1.get()).getC2().getId(), ""+(int)((Arista)aux1.get()).getC1().getId(), ""+(int)((Arista)aux1.get()).getC2().getId());
        
        aux1=aux1.nNext();
        }
        for (Node node : visualizador) {
        node.setAttribute("ui.label", node.getId());
        }
    }
    protected static String styleSheet =
            "node {" +
            "	fill-color: blue;" +
            "   text-alignment: under;"+
            "}" +
            "node.marked {" +
            "	fill-color: red;" +
            "}";
        
    
}
