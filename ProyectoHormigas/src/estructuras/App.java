/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import Frames.EditarMapa;
import Frames.PrincipalFrame;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.text.View;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.*;
import org.graphstream.ui.view.Viewer;






/**
 *
 * @author Leonardo
 */
public class App {
    public static Grafo grafo;
    public static int cicloActual;
    public static int cicloFinal;
    public static Graph visualizador;
    public static ListaDoble hormigas;
    public static Hormiga mejorRecorridoSimulacion;
    public static Hormiga mejorRecorridoCiclo;
    public App(){
        
        
        hormigas=new ListaDoble();
    }
    public static void iniciarGrafo(){
        grafo=new Grafo(20);
        grafo.agregarVertice();
        grafo.setInicio(0);

    }
    public static void iniciarVisualizador(){
        visualizador= new SingleGraph("view");
        visualizador.setAutoCreate( true );
        visualizador.setAttribute("ui.stylesheet", styleSheet);
        System.setProperty("org.graphstream.ui", "swing"); 
        visualizador.setStrict(false);
    }
 
    public static ViewPanel verGrafo(){
        Viewer viewer = new Viewer(visualizador, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD) {};
        viewer.enableAutoLayout();
        ViewPanel view = viewer.addDefaultView(false);   // false indicates "no JFrame".
        
        //Viewer viewer2 = visualizador.display();
        return view;
    }
    public static void indicarCiclos(int ciclos){
        cicloActual=0;
        cicloFinal=ciclos;
    }
    public static void finalizarRestantes(int cHormigas, double a,double b, double q, double p){
        for (int i=cicloActual;cicloActual<cicloFinal;i++){
            App.iniciarCiclo(cHormigas, a, b, q, p);
        }
        cicloActual=cicloFinal;
    }
    public static void iniciarCiclo(int cHormigas, double a,double b, double q, double p){
        NodoDoble hormi;
        hormigas=new ListaDoble();
        
        for (int j=0;j<cHormigas;j++){
            hormigas.append(new Hormiga());
        }
        mejorRecorridoCiclo=(Hormiga)hormigas.getFirstNodo().get();
        hormi=hormigas.getFirstNodo();
        while(hormi!=null){
            //System.out.println("Nueva hormiga");
            ((Hormiga)hormi.get()).iniciarRecorrido(grafo, a, b, q);
            if (((Hormiga)(hormi.get())).getAlcanzado()){
                if (((Hormiga)hormi.get()).getRecorrido()<mejorRecorridoCiclo.getRecorrido() || !mejorRecorridoCiclo.getAlcanzado()){
                    mejorRecorridoCiclo=((Hormiga)hormi.get());
                }
                if (mejorRecorridoSimulacion==null){
                    mejorRecorridoSimulacion=((Hormiga)hormi.get());
                }
                else if (((Hormiga)hormi.get()).getRecorrido()<mejorRecorridoSimulacion.getRecorrido()){
                    mejorRecorridoSimulacion=((Hormiga)hormi.get());
                }
            }
            
            
            hormi=hormi.nNext();
        }
        
        
        grafo.iniciarEvaporacion(p);
        NodoDoble aux1=grafo.getTodasAristas().getFirstNodo();
        while(aux1!=null){
            hormi=hormigas.getFirstNodo();
            while(hormi!=null){
                if(((Hormiga)hormi.get()).getAristasVisitadas().isPresent(aux1.get()) && ((Hormiga)(hormi.get())).getAlcanzado()){
                    System.out.println("hormiga alcanzo destino");
                    ((Arista)aux1.get()).incrementoFeromona((Hormiga)hormi.get(),q);
                    //System.out.println("actualizando feromona, arista: "+((Ciudad)((Arista)aux1.get()).getC1()).getId()+((Ciudad)((Arista)aux1.get()).getC2()).getId()+" Nuevo valor: "+((Arista)aux1.get()).getFeromona());
                }
                hormi=hormi.nNext();
            }
            aux1=aux1.nNext();
        }
        App.actualizarFeromonasVisualizador();
        App.reiniciarMarcados();
        App.cicloActual++;
        
    }
    public static void cargarVisualizador(){
        visualizador= new SingleGraph("view");
        visualizador.setAutoCreate( true );
        DecimalFormat formato = new DecimalFormat("0.00E00");
        visualizador.setAttribute("ui.stylesheet", styleSheet);
        System.setProperty("org.graphstream.ui", "swing"); 
        visualizador.setStrict(false);
        NodoDoble aux1=grafo.getTodasAristas().getFirstNodo();
        while (aux1!=null){
   
        visualizador.addEdge(""+(int)((Arista)aux1.get()).getC1().getId()+""+(int)((Arista)aux1.get()).getC2().getId(), ""+(int)((Arista)aux1.get()).getC1().getId(), ""+(int)((Arista)aux1.get()).getC2().getId());
        visualizador.getEdge(""+(int)((Arista)aux1.get()).getC1().getId()+""+(int)((Arista)aux1.get()).getC2().getId()).addAttribute("distancia",((Arista)aux1.get()).getDistancia() );
        visualizador.getEdge(""+(int)((Arista)aux1.get()).getC1().getId()+""+(int)((Arista)aux1.get()).getC2().getId()).addAttribute("feromona","F: "+formato.format(((Arista)aux1.get()).getFeromona()) );
        aux1=aux1.nNext();
        }
        for (Node node : visualizador) {
            node.setAttribute("ui.label", node.getId());

            if (node.getId().equals(""+grafo.getInicio().getId())){
                node.setAttribute("ui.class", "inicio");
            }
            if (grafo.getMeta()!=null){
                if (node.getId().equals(""+grafo.getMeta().getId())){
                    node.setAttribute("ui.class", "final");
                }
            }
           
        }

        
        for(Edge e:visualizador.getEachEdge()) {
            //e.setAttribute("ui.class", "marcado");
            e.addAttribute("ui.label", ""+e.getAttribute("distancia"));
        }
    }
    protected static String styleSheet =
            "node {" +
            "	fill-color: black;" +
            "   text-alignment: under;"+
            "}" +
            "node.inicio {" +
            "	fill-color: green;" +
            "}"+
            "node.final {" +
            "	fill-color: red;" +
            "}"+
            "edge.marcado {" +
            "	fill-color: red;" +
            "}"+
            "edge.noMarcado {" +
            "	fill-color: black;" +
            "}";
    
    //JOptionPane.showMessageDialog(null , "Debe ingresar formato valido.", "yyy-MM-dd", JOptionPane.ERROR_MESSAGE );    
    public static void agregarCiudad(int enlace, double distancia){
        grafo.agregarVertice();
        App.enlazarCiudades(grafo.getTamaño()-1,enlace,distancia);
        
    }
    public static void enlazarCiudades(int ciudad1, int ciudad2, double distancia){
        grafo.agregarArista(ciudad1, ciudad2, distancia);
    }
    public static void eliminarArista(int arista){
        Arista eArista=(Arista)grafo.getTodasAristas().searchByIndex(arista).get();
        grafo.eliminarArista(eArista);
    }
    public static void eliminarCiudad(int ciudad){
        grafo.eliminarVertice(ciudad);
    }
    public static void setRecorrido(int inicio, int meta){
        grafo.setInicio(inicio);
        grafo.setMeta(meta);
    }
    public static void iniciarFeromonas(int ciclos){
        NodoDoble aux=grafo.getTodasAristas().getFirstNodo();
        while (aux!=null){
            ((Arista)aux.get()).setFeromona(ciclos);
            aux=aux.nNext();
            System.out.println("inicio feromona");
        }
    }
    public static void verRecorridoHormiga(int index){
        Hormiga hormiga=(Hormiga)hormigas.searchByIndex(index).get();
        App.alumbrarRecorrido(hormiga);
    }
    public static void reiniciarMarcados(){
        for(Edge e:visualizador.getEachEdge()) {
            e.setAttribute("ui.class", "noMarcado");
            e.addAttribute("ui.label", ""+e.getAttribute("distancia")+" "+e.getAttribute("feromona"));
        }
    }
    public static void actualizarFeromonasVisualizador(){
        DecimalFormat formato = new DecimalFormat("0.00E00");
        NodoDoble aux=grafo.getTodasAristas().getFirstNodo();
        while (aux!=null){
            visualizador.getEdge(((Arista)aux.get()).getResumen()).addAttribute("feromona","F: "+formato.format(((Arista)aux.get()).getFeromona()));
            aux=aux.nNext();
        }
    }
    public static void alumbrarRecorrido(Hormiga hormi){
        NodoDoble aux=hormi.getAristasVisitadas().getFirstNodo();
        App.reiniciarMarcados();
        while (aux!=null){
            visualizador.getEdge(((Arista)aux.get()).getResumen()).addAttribute("ui.class", "marcado");
            aux=aux.nNext();
        }
    }
    
}
