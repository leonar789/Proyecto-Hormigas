package estructuras;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leonardo
 */
public class Arista {
    private double distancia;
    private Ciudad ciudad1;
    private Ciudad ciudad2;
    private double feromona;
    private String resumen;
    public Arista(Ciudad primeraCiudad,Ciudad segundaCiudad, double d){
        this.ciudad1=primeraCiudad;
        this.ciudad2=segundaCiudad;
        this.distancia=d;
        this.feromona=0.1;
        this.resumen=""+primeraCiudad.getId()+segundaCiudad.getId();
    }
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
    public void setFeromona(int ciclos){
        this.feromona=1/Double.valueOf(ciclos);
    }
    public void evaporacion(double constanteEv){
        System.out.println("Antes de evaporar "+feromona);
        feromona=(1.0-constanteEv)*feromona;
        System.out.println("Despues de evaporar "+feromona);
    }
    public void incrementoFeromona(Hormiga hormiga, double q){
        feromona+=q/hormiga.getRecorrido();
        System.out.println("recorrido de la hormiga "+hormiga.getRecorrido());
        System.out.println("feromona incrementada "+feromona);
    }
    public String toString(){
        return ""+ciudad1.getId()+" - "+ciudad2.getId();
    }
    public void setDistancia(double dist){
        distancia=dist;
    }
}
