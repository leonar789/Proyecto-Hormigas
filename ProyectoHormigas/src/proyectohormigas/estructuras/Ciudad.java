/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohormigas.estructuras;

/**
 *
 * @author Leonardo
 */
public class Ciudad<T> {
    private static int autoincremental=0;
    private int id =0;
    private ListaDoble aristas;
    private String nombre;
    public Ciudad(String nNombre){
        this.id=autoincremental;
        this.aristas=new ListaDoble();
        this.nombre=nNombre;
        autoincremental++;
    }
    public ListaDoble getAristas(){
        return this.aristas;
    }
    public int getId(){
        return id;
    }
}
