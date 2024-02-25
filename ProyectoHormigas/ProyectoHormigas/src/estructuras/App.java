/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import Frames.EditarMapa;
import static Frames.IniciarSimulacion.recorridoHormiga;
import Frames.PrincipalFrame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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

//clase auxiliar que se encarga de realizar todo el procedimiento lógico global
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
    
    //inicia el grafo y crea una ciudad
    public static void iniciarGrafo(){
        grafo=new Grafo(20);
        grafo.agregarVertice();
        grafo.setInicio(0);

    }
    
    //permite crear el visualizador del grafo
    public static void iniciarVisualizador(){
        visualizador= new SingleGraph("view");
        visualizador.setAutoCreate( true );
        visualizador.setAttribute("ui.stylesheet", styleSheet);
        System.setProperty("org.graphstream.ui", "swing"); 
        visualizador.setStrict(false);
    }
    
    
    //crea un panel para poder ver el grafo en miniatura mientras se ejecuta el programa
    public static ViewPanel verGrafo(){
        Viewer viewer = new Viewer(visualizador, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD) {};
        viewer.enableAutoLayout();
        ViewPanel view = viewer.addDefaultView(false);   
        
        return view;
    }
    
    //establece los ciclos al inicio de cada simulacion
    public static void indicarCiclos(int ciclos){
        cicloActual=0;
        cicloFinal=ciclos;
    }
    
    //al darle al boton finalizar, se ejecutan los ciclos restantes
    public static void finalizarRestantes(int cHormigas, double a,double b, double q, double p){
        for (int i=cicloActual;cicloActual<cicloFinal;i++){
            App.iniciarCiclo(cHormigas, a, b, q, p);
        }
        cicloActual=cicloFinal;
    }
    
    //ejecuta el codigo necesario para cada ciclo
    public static void iniciarCiclo(int cHormigas, double a,double b, double q, double p){
        NodoDoble hormi;
        hormigas=new ListaDoble();
        //se crea una lista de hormigas
        for (int j=0;j<cHormigas;j++){
            hormigas.append(new Hormiga());
        }
        //se reinicia el mejor camino por ciclo
        mejorRecorridoCiclo=null;
        hormi=hormigas.getFirstNodo();
        while(hormi!=null){
            //se realiza la simulacion del recorrido para cada hormiga
            ((Hormiga)hormi.get()).iniciarRecorrido(grafo, a, b, q);
            if (((Hormiga)(hormi.get())).getAlcanzado()){
                
                //si la hormiga alcanzó el destino, se establece si fue el mejor recorrido por ciclo o en la simulación
                if (mejorRecorridoCiclo==null){
                    mejorRecorridoCiclo=((Hormiga)hormi.get());
                }
                else if (((Hormiga)hormi.get()).getRecorrido()<mejorRecorridoCiclo.getRecorrido()){
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
        
        //se ejecuta la actualización de feromonas por evaporacion
        grafo.iniciarEvaporacion(p);
        NodoDoble aux1=grafo.getTodasAristas().getFirstNodo();
        
        //se realiza la actualización por incremento, si la hormiga visitó el camino y llegó a su destino entonces se incrementa
        while(aux1!=null){
            hormi=hormigas.getFirstNodo();
            while(hormi!=null){
                if(((Hormiga)hormi.get()).getAristasVisitadas().isPresent(aux1.get()) && ((Hormiga)(hormi.get())).getAlcanzado()){
                    ((Arista)aux1.get()).incrementoFeromona((Hormiga)hormi.get(),q);
                    //System.out.println("actualizando feromona, arista: "+((Ciudad)((Arista)aux1.get()).getC1()).getId()+((Ciudad)((Arista)aux1.get()).getC2()).getId()+" Nuevo valor: "+((Arista)aux1.get()).getFeromona());
                }
                hormi=hormi.nNext();
            }
            aux1=aux1.nNext();
        }
        
        //se actualiza el miniGrafo de la interfaz
        App.actualizarFeromonasVisualizador();
        App.reiniciarMarcados();
        App.cicloActual++;
        
    }
    
    //cada vez que se hacen cambios en el grafo, es necesario visualizarlos en la interfaz
    public static void cargarVisualizador(){
        //se crea el grafo con la libreria GraphStream
        visualizador= new SingleGraph("view");
        visualizador.setAutoCreate( true );
        DecimalFormat formato = new DecimalFormat("0.00E00");
        visualizador.setAttribute("ui.stylesheet", styleSheet);
        System.setProperty("org.graphstream.ui", "swing"); 
        visualizador.setStrict(false);
        NodoDoble aux1=grafo.getTodasAristas().getFirstNodo();
        while (aux1!=null){
        //se agregan las aristas para contruir el visualizador
        visualizador.addEdge(""+(int)((Arista)aux1.get()).getC1().getId()+""+(int)((Arista)aux1.get()).getC2().getId(), ""+(int)((Arista)aux1.get()).getC1().getId(), ""+(int)((Arista)aux1.get()).getC2().getId());
        visualizador.getEdge(""+(int)((Arista)aux1.get()).getC1().getId()+""+(int)((Arista)aux1.get()).getC2().getId()).addAttribute("distancia","D: "+((Arista)aux1.get()).getDistancia() );
        visualizador.getEdge(""+(int)((Arista)aux1.get()).getC1().getId()+""+(int)((Arista)aux1.get()).getC2().getId()).addAttribute("feromona","F: "+formato.format(((Arista)aux1.get()).getFeromona()) );
        aux1=aux1.nNext();
        }
        
        //se muestra la información de distancia y ciudades
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
    
    //define la apariencia del visualizador
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
    
    //se emplea para agregar una ciudad al grafo, siempre y cuando no hayan más de 20 ciudades
    public static void agregarCiudad(int enlace, double distancia){
        if (grafo.getTamaño()<20){
            grafo.agregarVertice();
            App.enlazarCiudades(grafo.getTamaño()-1,enlace,distancia);
        }
        else{
            JOptionPane.showMessageDialog(null , "El mapa no puede tener más de 20 ciudades", "Error", JOptionPane.ERROR_MESSAGE );    

        }
        
        
    }
    
    //se encarga de validar si todos los datos de la simulación son válidos para comenzar
    public static Boolean validarInicio(int ciclos,int hormigas,double alfa, double beta, double q, double p){
        if (ciclos>0 && alfa>0 && hormigas>0  && beta>0 && q>0 && p>=0 && p<1){
            if (grafo.getTamaño()>3){
                if (grafo.getMeta()!=null){
                    //solo se puede iniciar si los parametros son positivos, P menor que 1 y existe una ciudad meta
                    App.indicarCiclos(ciclos);
                    App.iniciarFeromonas(ciclos);
                    App.reiniciarMejorCamino();
                    App.iniciarCiclo(hormigas, alfa, beta, q, p);
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null , "Debe indicarse una ciudad de destino", "Error", JOptionPane.ERROR_MESSAGE );    
                    return false;
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null , "El mapa debe tener al menos 4 ciudades", "Error", JOptionPane.ERROR_MESSAGE );    
                return false;
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null , "Los valores de simulación deben ser positivos y P menor que 1", "Error", JOptionPane.ERROR_MESSAGE );    
            return false;
        }
       
    }
    
    //enlaza ciudades del grafo
    public static void enlazarCiudades(int ciudad1, int ciudad2, double distancia){
        grafo.agregarArista(ciudad1, ciudad2, distancia);
    }
    
    //elimina aristas del grafo, solo si no existe posibilidad de que queden ciudades flotando
    public static void eliminarArista(int arista){
        Arista eArista=(Arista)grafo.getTodasAristas().searchByIndex(arista).get();
        if (eArista.getC1().getAristas().getLen()==1 ||eArista.getC2().getAristas().getLen()==1){
            JOptionPane.showMessageDialog(null , "Para evitar ciudades flotantes, no puede eliminar una arista que sea la única conexión a una ciudad. Proceda a eliminar la ciudad", "Error", JOptionPane.ERROR_MESSAGE );    

        }
        else{
            grafo.eliminarArista(eArista);
        }
        
    }
    
    //elimina una ciudad siempre y cuando esto no rompa el grafo en dos partes
    public static void eliminarCiudad(int ciudad){
        grafo.eliminarVertice(ciudad);
    }
    
    //establece el inicio y la meta del recorrido
    public static void setRecorrido(int inicio, int meta){
        grafo.setInicio(inicio);
        grafo.setMeta(meta);
    }
    
    //carga el valor inicial de las feromonas
    public static void iniciarFeromonas(int ciclos){
        NodoDoble aux=grafo.getTodasAristas().getFirstNodo();
        while (aux!=null){
            ((Arista)aux.get()).setFeromona(ciclos);
            aux=aux.nNext();
 
        }
    }
    
    //actualiza el visualizador para poder ver el camino que siguió una hormiga
    public static void verRecorridoHormiga(int index){
        Hormiga hormiga=(Hormiga)hormigas.searchByIndex(index).get();
        recorridoHormiga.setText(""+hormiga.getRecorrido());
        App.alumbrarRecorrido(hormiga);
    }
    
    //permite reiniciar el mejor camino para cada simulación
    public static void reiniciarMejorCamino(){
        mejorRecorridoSimulacion=null;
    }
    
    //quita los caminos marcados en el visualizador
    public static void reiniciarMarcados(){
        for(Edge e:visualizador.getEachEdge()) {
            e.setAttribute("ui.class", "noMarcado");
            e.addAttribute("ui.label", ""+e.getAttribute("distancia")+" "+e.getAttribute("feromona"));
        }
    }
    
    //por cada iteración se actualiza en el visualizador las feronomas
    public static void actualizarFeromonasVisualizador(){
        DecimalFormat formato = new DecimalFormat("0.00E00");
        NodoDoble aux=grafo.getTodasAristas().getFirstNodo();
        while (aux!=null){
            visualizador.getEdge(((Arista)aux.get()).getResumen()).addAttribute("feromona","F: "+formato.format(((Arista)aux.get()).getFeromona()));
            aux=aux.nNext();
        }
    }
    
    //hace que se pueda ver el camino recorrido por una hormiga en el visualizador coloreando las aristas
    public static void alumbrarRecorrido(Hormiga hormi){
        NodoDoble aux=hormi.getAristasVisitadas().getFirstNodo();
        App.reiniciarMarcados();
        while (aux!=null){
            visualizador.getEdge(((Arista)aux.get()).getResumen()).addAttribute("ui.class", "marcado");
            aux=aux.nNext();
        }
    }
    
    //se encarga de guardar el grafo
    public static void cargarGrafo(PrincipalFrame a){
        App.grafo = new Grafo(20);
        Ciudad.autoincremental=0;
        
        //se inicializa el JFileChooser para cargar el archivo
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
        fc.setFileFilter(filtro);
        int res = fc.showOpenDialog(a);
        //se contemplan posibles errores
        if(res != JFileChooser.CANCEL_OPTION){
            File name = fc.getSelectedFile();
            if((name == null) || name.getName().equals("")){
                JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
        }else{
            try {
                FileReader archive = new FileReader(name.getAbsolutePath());
                if(archive.ready()){
                    BufferedReader lector = new BufferedReader(archive); 
                    String cadena = lector.readLine();
                    cadena = lector.readLine();
                    while(!(cadena.equals("Aristas"))){
                        //por cada ciudad se crea un vertice y se le asigna el id registrado en el txt
                        grafo.agregarVertice();
                        ((Ciudad)grafo.getVertices().getFinal()).setId(Integer.parseInt(cadena));
                        Ciudad.autoincremental=Integer.parseInt(cadena)+1;
                        cadena = lector.readLine();           
                    }
                    cadena = lector.readLine(); 
                    while(true){
                        //por cada arista, se toma el id de las ciudades y la distancia y se contruye la arista en el grafo
                        double dist;
                        if(cadena==null){
                           break; 
                        }else{
                            dist = Double.parseDouble(cadena);
                        }
                        int c1 = Integer.parseInt(lector.readLine());
                        int c2 = Integer.parseInt(lector.readLine());
                        
                        grafo.agregarArista(grafo.getVertices().buscarIndiceCiudad(c1),grafo.getVertices().buscarIndiceCiudad(c2), dist);
                        cadena=lector.readLine();
                    }
                    grafo.setInicio(0);
                }
                
            } catch (IOException e){
                    
            }
        }
        }
        //si el grafo cargado está vacío se crea una ciudad inicial
        if (grafo.getTamaño()==0){
            grafo.agregarVertice();
            grafo.setInicio(0);
        }
        
    }
    
    //metodo para guardar un grafo
    public static void guardarGrafo(PrincipalFrame a){
        
        //se inicializa el JFileChooser
        JFileChooser gComo = new JFileChooser();
        gComo.showSaveDialog(a);
        File archivo = new File(gComo.getSelectedFile() + ".txt");
        try {
            //para cada ciudad se guarda su id
            BufferedWriter salida = new BufferedWriter(new FileWriter(archivo));
            salida.write("ciudades");
            for(int i = 0; i<grafo.getTamaño(); i++){
                salida.newLine();
                Ciudad city = (Ciudad)grafo.getVertices().getByIndex(i);
                salida.write(String.valueOf(city.getId()));
            }
            salida.newLine();
            salida.write("Aristas");
            for(int i = 0; i<grafo.getTodasAristas().getLen(); i++){
                
                //para cada arista se guarda en lineas diferentes el id de las ciudades que conecta y su distancia
                //se guarda cada dato uno seguido del otro
                Arista ar = (Arista)grafo.getTodasAristas().getByIndex(i);
                salida.newLine();
                salida.write(String.valueOf(ar.getDistancia()));
                salida.newLine();
                salida.write(String.valueOf(ar.getC1().getId()));
                salida.newLine();
                salida.write(String.valueOf(ar.getC2().getId()));
            }
            salida.newLine();
            salida.write("");
            salida.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }
}
