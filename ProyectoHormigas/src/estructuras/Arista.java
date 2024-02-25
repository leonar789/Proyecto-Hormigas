package estructuras;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leonardo
 */

//es la clase que representa el camino entre ciudades
public class Arista {
    private double distancia;
    private Ciudad ciudad1;
    private Ciudad ciudad2;
    private double feromona;
    private String resumen;
    
    //se almacenan las ciudades que coneecta, la feromona y la distancia.
    public Arista(Ciudad primeraCiudad,Ciudad segundaCiudad, double d){
        this.ciudad1=primeraCiudad;
        this.ciudad2=segundaCiudad;
        this.distancia=d;
        this.feromona=0.1;
        this.resumen=""+primeraCiudad.getId()+segundaCiudad.getId();
    }
    
    //a continuación los getters de la clase
    public Ciudad getC1(){
        return ciudad1;
    }
    public Ciudad getC2(){
        return ciudad2;
    }
    public String getResumen(){
        return resumen;
    }
    public double getDistancia(){
        return distancia;
    }
    public double getFeromona(){
        return feromona;
    }
    
    
    //este método se encarga de iniciar la feromona a partir de la cantidad de ciclos
    public void setFeromona(int ciclos){
        this.feromona=1/Double.valueOf(ciclos);
    }
    
    //ejecuta la evaporación de la feromona
    public void evaporacion(double constanteEv){  
        feromona=(1.0-constanteEv)*feromona;
    }
    
    //ejecuta el incremento de la feromona dada la hormiga que pasó por esta arista
    public void incrementoFeromona(Hormiga hormiga, double q){
        feromona+=q/hormiga.getRecorrido();
    }
    
    //permite mostrar el texto ordenado en los combobox
    public String toString(){
        return ""+ciudad1.getId()+" - "+ciudad2.getId();
    }
    
    //permite settear la distancia de un camino
    public void setDistancia(double dist){
        distancia=dist;
    }
}
