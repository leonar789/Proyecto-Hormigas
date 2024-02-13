package proyectohormigas.estructuras;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leonardo
 */
public class Arista {
    private int distancia;
    private Ciudad ciudad1;
    private Ciudad ciudad2;
    private double feromona;
    public Arista(Ciudad primeraCiudad,Ciudad segundaCiudad, int d){
        this.ciudad1=primeraCiudad;
        this.ciudad2=segundaCiudad;
        this.distancia=d;
        this.feromona=0.1;
    }
    public Ciudad getC1(){
        return ciudad1;
    }
    public Ciudad getC2(){
        return ciudad2;
    }
    public double getDistancia(){
        return distancia;
    }
    public double getFeromona(){
        return feromona;
    }
    public void setFeromona(double nFeromona){
        this.feromona=nFeromona;
    }
    public void evaporacion(double constanteEv){
        feromona=(1.0-constanteEv)*feromona;
    }
    public void incrementoFeromona(Hormiga hormiga){
        feromona+=1/hormiga.getRecorrido();
    }
}
