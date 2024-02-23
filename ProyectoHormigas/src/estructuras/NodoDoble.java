/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Leonardo
 * @param <T>
 */
public class NodoDoble<T> {
    private T contenido;
    private NodoDoble<T> next;
    private NodoDoble<T> prev;
    
    public NodoDoble(T contenido){
        this.contenido=contenido;
        this.next=null;
        this.prev=null;
    }
    public NodoDoble<T> nNext (){
        return this.next;
    }
    public NodoDoble<T> nPrev(){
        return this.prev;
    }
    public void setData(T data){
        this.contenido=data;
    }
    public void setNext(NodoDoble<T> pNext){
        this.next=pNext;
    }
    public void setPrev(NodoDoble<T> pPrev){
        this.prev=pPrev;
    }
    public T get(){
        return this.contenido;
    }
}
