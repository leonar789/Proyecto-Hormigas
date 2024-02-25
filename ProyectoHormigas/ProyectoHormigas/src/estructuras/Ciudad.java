/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Leonardo
 */


//clase auxiliar que se encarga de guardar los caminos que existen desde una ciudad hasta las demás
public class Ciudad<T> {
    public static int autoincremental=0;
    private int id =0;
    private ListaDoble aristas;
    
    //el id de cada ciudad se genera automaticamente
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
    
    //este método se emplea para mostrar informacion en los combobox
    public String toString(){
        return "Ciudad"+" "+this.getId();
    }
    
    //este se emplea al cargar la informacion de un txt
    public void setId(int nId){
        id=nId;
    }
    
}
