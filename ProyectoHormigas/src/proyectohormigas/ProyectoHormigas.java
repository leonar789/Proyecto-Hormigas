/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectohormigas;
import proyectohormigas.estructuras.ListaDoble;
import proyectohormigas.estructuras.NodoDoble;
import proyectohormigas.estructuras.Hormiga;
import proyectohormigas.estructuras.Grafo;
import proyectohormigas.estructuras.Ciudad;
import proyectohormigas.estructuras.Arista;
 import java.util.Iterator;
 import org.graphstream.graph.*;
 import org.graphstream.graph.implementations.*;
/**
 *
 * @author Leonardo
 */
public class ProyectoHormigas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Graph graph = new SingleGraph("tutorial 1");
        Grafo g= new Grafo(20);
        
        
        
        for (int i=0;i<9;i++){
            g.agregarVertice(""+i);
   
        }
        g.setInicio(0);
        g.setMeta(6);
        g.agregarArista(0, 2, 23);
        g.agregarArista(0, 4, 14);
        g.agregarArista(0, 3, 15);
        g.agregarArista(3, 4, 4);
        g.agregarArista(2, 1, 12);
        g.agregarArista(2, 5, 9);
        g.agregarArista(4, 6, 24);
        g.agregarArista(3, 6, 16);
        g.agregarArista(1, 0, 18);
        g.agregarArista(1, 6, 26);
        g.agregarArista(5, 6, 4);
        ListaDoble hormigas;
        NodoDoble hormi;
        for (int i=0;i<9;i++){
            System.out.println("Nueva iteracion");
            hormigas=new ListaDoble();
            
            for (int j=0;j<11;j++){
            hormigas.append(new Hormiga());
            }
            hormi=hormigas.getFirstNodo();
            while(hormi!=null){
            ((Hormiga)hormi.get()).iniciarRecorrido(g, 1, 2, 1);
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
            g.iniciarEvaporacion(0.2);
            NodoDoble aux1=g.getTodasAristas().getFirstNodo();
            while(aux1!=null){
                hormi=hormigas.getFirstNodo();
                while(hormi!=null){
                    if(((Hormiga)hormi.get()).getAristasVisitadas().isPresent(aux1.get())){
                        ((Arista)aux1.get()).incrementoFeromona((Hormiga)hormi.get());
                    }
                    hormi=hormi.nNext();
                }
                aux1=aux1.nNext();
            }
        }
            
        for (int i=0;i<9;i++){
            g.agregarVertice(""+i);
   
        }
        
        
        
        
        
        
        graph.setAutoCreate( true );
        graph.setAttribute("ui.stylesheet", styleSheet);
        System.setProperty("org.graphstream.ui", "swing"); 
        graph.setStrict(false);
        //graph.setAutoCreate(true);
        graph.display(); 
        NodoDoble aux1=g.getTodasAristas().getFirstNodo();
        while (aux1!=null){
        graph.addEdge(""+(int)((Arista)aux1.get()).getC1().getId()+""+(int)((Arista)aux1.get()).getC2().getId(), ""+(int)((Arista)aux1.get()).getC1().getId(), ""+(int)((Arista)aux1.get()).getC2().getId());
        
        aux1=aux1.nNext();
        }
        for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
        }
       
        
    }
    protected static String styleSheet =
            "node {" +
            "	fill-color: red;" +
            "   text-alignment: under;"+
            "}" +
            "node.marked {" +
            "	fill-color: red;" +
            "}";
        
}
    

