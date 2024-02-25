/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Leonardo
 */
//clase empleada para llevar el control de las hormigas y realizar la simulación de su recorrido
public class Hormiga {
    private double recorrido;
    private ListaDoble aristasVisitadas;
    private ListaDoble ciudadesVisitadas;
    private Boolean destinoAlcanzado;
    public Hormiga(){
        recorrido=0;
        aristasVisitadas=new ListaDoble();
        ciudadesVisitadas=new ListaDoble();
        destinoAlcanzado=false;
    }
    
    //retorna las ciudades visitadas por la hormiga
    public ListaDoble getCiudadesVisitadas(){
        return ciudadesVisitadas;
    }
    
    //indica si la hormiga ha alcanzado su destino
    public Boolean getAlcanzado(){
        return destinoAlcanzado;
    }
    
    //retorna una lista con las aristas que visitó la hormiga
    public ListaDoble getAristasVisitadas(){
        return aristasVisitadas;
    }
    
    //se encarga de simular el recorrido de la hormiga
    public void iniciarRecorrido(Grafo grafo, double alfa,double beta, double q){
        
        Ciudad ciudadActual=grafo.getInicio(); //se setea la ciudad de inicio
        while (true){
            ciudadesVisitadas.append((ciudadActual)); //se registra la ciudad actual como visitada
            if (ciudadActual==grafo.getMeta()){
                destinoAlcanzado=true; //si se alcanza el destino se interrumpe el recorrido
                break;
            }
            
            //se crea una lista auxiliar con las posibles aristas que puede visitar la hormiga
            ListaDoble listaAuxiliar=new ListaDoble();
            NodoDoble nodoAuxiliar=ciudadActual.getAristas().getFirstNodo();
            while(nodoAuxiliar!=null){
                //se descartan las que no pueden ser visitadas
                if(!ciudadesVisitadas.isPresent(((Arista)nodoAuxiliar.get()).getC1()) || !ciudadesVisitadas.isPresent(((Arista)nodoAuxiliar.get()).getC2())){
                    listaAuxiliar.append(nodoAuxiliar.get());
                }
                nodoAuxiliar=nodoAuxiliar.nNext();
            }
            if (listaAuxiliar.getLen()==0){
                break; //si la hormiga no puede visitar ninguna ciudad, se interrumpe el ciclo
            }
            else{
                
                //se calcula la probablidad de ir por cada camino teniendo en cuenta la fórmula del AS
                double parcial=0;
                double total=0;
                nodoAuxiliar=listaAuxiliar.getFirstNodo();
                while (nodoAuxiliar!=null){
                    //para cada camino se calcula la probabilidad conociendo la cantidad de feromona, su distancia y los parámetros de simulación
                    total+=Math.pow(((Arista)(nodoAuxiliar.get())).getFeromona(),alfa)*Math.pow(calcularN((Arista)(nodoAuxiliar.get()),q),beta);

                    nodoAuxiliar=nodoAuxiliar.nNext();
                }
                
                //se escoge un numero al alzar entre 0 y 1
                double aleatorio=Math.random();
                nodoAuxiliar=listaAuxiliar.getFirstNodo();

                while (nodoAuxiliar!=null){
                    
                    //para cada arista se verifica si el numero es menor a su probabilidad más la probabilidad de las aristas anteriores
                    //con esto se escoge un solo camino por el que ir
                    if(aleatorio<=parcial+(Math.pow(((Arista)(nodoAuxiliar.get())).getFeromona(),alfa)*Math.pow(calcularN((Arista)(nodoAuxiliar.get()),q),beta)/total)){
                        
                        //si se elige el camino, se actualizan las aristas visitadas y su distancia recorrida
                        recorrido+=((Arista)nodoAuxiliar.get()).getDistancia();
                        aristasVisitadas.append(nodoAuxiliar.get());
                        
                        //se establece como ciudad actual la dictada por la arista escogida
                        if (((Arista)nodoAuxiliar.get()).getC1()!=ciudadActual){
                            ciudadActual=((Arista)nodoAuxiliar.get()).getC1();
                        }
                        else{
                            ciudadActual=((Arista)nodoAuxiliar.get()).getC2();
                        }
                        break;
                        
                    }
                    else{
                        //si no es menor, se suma su probabilidad con la de la siguiente arista
                        parcial+=(Math.pow(((Arista)nodoAuxiliar.get()).getFeromona(),alfa)*Math.pow(calcularN((Arista)nodoAuxiliar.get(),q),beta)/total);
                    }
                    nodoAuxiliar=nodoAuxiliar.nNext();
                    
                }
            }
        }
    }
    //calcula el parámetro N
    public double calcularN(Arista arista, double q){
        
        return q/(arista.getDistancia());
    }
    
    //retorna el recorrido de la hormiga
    public double getRecorrido(){
        return recorrido;
    }
}
