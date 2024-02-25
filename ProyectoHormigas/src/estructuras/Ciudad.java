/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Leonardo
 */
public class Ciudad<T> {
    public static int autoincremental=0;
    private int id =0;
    private ListaDoble aristas;

    public Ciudad(){
        this.id=autoincremental;
        this.aristas=new ListaDoble();
        autoincremental++;
    }
    public ListaDoble getAristas(){
        return this.aristas;
    }
    public int getId(){
        return id;
    }
    public String toString(){
        return "Ciudad"+" "+this.getId();
    }
    public void setId(int nId){
        id=nId;
    }
    
}
