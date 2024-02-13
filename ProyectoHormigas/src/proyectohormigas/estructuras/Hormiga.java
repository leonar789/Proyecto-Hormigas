/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohormigas.estructuras;

/**
 *
 * @author Leonardo
 */
public class Hormiga {
    private double recorrido;
    private ListaDoble aristasVisitadas;
    private ListaDoble ciudadesVisitadas;
    public Hormiga(){
        recorrido=0;
        aristasVisitadas=new ListaDoble();
        ciudadesVisitadas=new ListaDoble();
    }
    public ListaDoble getCiudadesVisitadas(){
        return ciudadesVisitadas;
    }
    public ListaDoble getAristasVisitadas(){
        return aristasVisitadas;
    }
    public void iniciarRecorrido(Grafo grafo, int alfa,int beta, int q){
        Ciudad ciudadActual=grafo.getInicio();
        while (true){
            ciudadesVisitadas.append((ciudadActual));
            if (ciudadActual==grafo.getMeta()){
                break;
            }
            ListaDoble listaAuxiliar=new ListaDoble();
            NodoDoble nodoAuxiliar=ciudadActual.getAristas().getFirstNodo();
            while(nodoAuxiliar!=null){
                if(!ciudadesVisitadas.isPresent(((Arista)nodoAuxiliar.get()).getC1()) || !ciudadesVisitadas.isPresent(((Arista)nodoAuxiliar.get()).getC2())){
                    listaAuxiliar.append(nodoAuxiliar.get());
                }
                nodoAuxiliar=nodoAuxiliar.nNext();
            }
            if (listaAuxiliar.getLen()==0){
                break;
            }
            else{
                double parcial=0;
                double total=0;
                nodoAuxiliar=listaAuxiliar.getFirstNodo();
                while (nodoAuxiliar!=null){
                    
                    total+=Math.pow(((Arista)(nodoAuxiliar.get())).getFeromona(),alfa)*Math.pow(calcularN((Arista)(nodoAuxiliar.get()),q),beta);

                    nodoAuxiliar=nodoAuxiliar.nNext();
                }
                double aleatorio=Math.random();
                nodoAuxiliar=listaAuxiliar.getFirstNodo();
                while (nodoAuxiliar!=null){
                    if(aleatorio<=parcial+(Math.pow(((Arista)(nodoAuxiliar.get())).getFeromona(),alfa)*Math.pow(calcularN((Arista)(nodoAuxiliar.get()),q),beta)/total)){
                        recorrido+=((Arista)nodoAuxiliar.get()).getDistancia();
                        aristasVisitadas.append(nodoAuxiliar.get());
                        if (((Arista)nodoAuxiliar.get()).getC1()!=ciudadActual){
                            ciudadActual=((Arista)nodoAuxiliar.get()).getC1();
                        }
                        else{
                            ciudadActual=((Arista)nodoAuxiliar.get()).getC2();
                        }
                        break;
                        
                    }
                    else{
                        parcial+=(Math.pow(((Arista)nodoAuxiliar.get()).getFeromona(),alfa)*Math.pow(calcularN((Arista)nodoAuxiliar.get(),q),beta)/total);
                    }
                    nodoAuxiliar=nodoAuxiliar.nNext();
                    
                }
            }
        }
    }
    
    public double calcularN(Arista arista, int q){

        return q/(arista.getDistancia());
    }
    public double getRecorrido(){
        return recorrido;
    }
}
