/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectohormigas.estructuras;

/**
 *
 * @author Leonardo
 * @param <T>
 */
public class ListaDoble<T> {
    private NodoDoble<T> pFirst;
    private NodoDoble<T> pLast;
    private int len;
    public ListaDoble(){
        this.pFirst=null;
        this.len=0;
        this.pLast=null;
    }

    
    public boolean esVacia() {
        return this.pFirst==null;
    }
    public NodoDoble<T> getFirstNodo(){
        return pFirst;
    }

    
    public T getPrimero() {
        return pFirst.get();
    }


    public T getFinal() {
        return pLast.get();
    }

 
    public T Ultimo() {
         return null;
    }


    public void append(T nuevo) {
        NodoDoble<T> nNodo=new NodoDoble(nuevo);
        if (pFirst==Ultimo()){
            pFirst=nNodo;
            pLast=nNodo;
         
        }
        else{
            pLast.setNext(nNodo);
            nNodo.setPrev(pLast);
            pLast=nNodo;

           
        }
        len++;
    }


    public void print() {
        NodoDoble<T> value=pFirst;
        while (value!=Ultimo()){
            System.out.print(value.get()+" ");
            value=value.nNext();
            
        }
        System.out.println("("+this.len+")");
    }



    public NodoDoble<T> searchByIndex(int n) {
        if (len-1<n){
            return null;
            
        }
        else{
            int i=0;
            NodoDoble<T> valor;
            if (n<=this.getLen()-1){
                valor= pFirst;
                while (i!=n){
                valor=valor.nNext();
                i++;
                }
            }
            else{
                n=this.getLen()-1-n;
                valor= pLast;
                while (i!=n){
                valor=valor.nPrev();
                i++;
                }
            }
            return valor;
        }
    }


   
    public Boolean isPresent(T key) {
        NodoDoble<T> aux= pFirst;
        Boolean presente=false;
        while (aux!=Ultimo()){

            if(aux.get()==key){
                presente=true;
            }
            aux=aux.nNext();
        }
        return presente;
    }


    public NodoDoble<T> searchByKey(T key) {
        if (this.isPresent(key)){
            NodoDoble<T> valor= pFirst;
            while (valor.get()!=key){
                valor=valor.nNext();
            }
            return valor;
        }
        return null;
    }


    public T getByIndex(int n) {
        if (n>=0 && n<this.getLen()){
            return this.searchByIndex(n).get();
        }
        else{
            System.out.println("Fuera de rango");
            return null;
        }
    }


    public void deleteLastone() {
        if(this.pFirst == this.pLast && this.pFirst != null){
            this.pFirst = null;
            this.pLast = null;
            this.len--;
        }
        else if (!this.esVacia()){
            NodoDoble<T> aux= pLast.nPrev();
            aux.setNext(null);
            this.pLast=aux;
            len--;    
            }
    }


    public void insertFirst(T info) {
        NodoDoble <T> newNodo= new NodoDoble(info);
        if (this.esVacia()){
            this.pFirst=newNodo;
            this.pLast=newNodo;
            len++;
        }
        else{
            newNodo.setNext(pFirst);
            pFirst.setPrev(newNodo);
            pFirst=newNodo;
            len++;
        }
    }


    public void reverse() {
        NodoDoble<T> aux;
        if(!this.esVacia()){
            aux = pLast;
            this.deleteLastone();
            this.reverse();
            this.insertFirst(aux.get());
        }
    }


    public void insertByIndex(T info, int index) {
        if (index>=0 && index<=len){
            if (index==0){
                this.insertFirst(info);
            }
            else if (index==len){
                this.append(info);
            }
            else{
                NodoDoble <T> newNodo= new NodoDoble(info);
                NodoDoble <T> aux= this.searchByIndex(index-1);
                newNodo.setNext(aux.nNext());
                newNodo.setPrev(aux);
                aux.nNext().setPrev(newNodo);
                aux.setNext(newNodo);
                this.len++;
                
            }
           
        }
    }


    public void insertByKey(T info, T key) {
        NodoDoble<T> aux=this.searchByKey(key);
        if (aux!=null){
            if (aux==pLast){
                this.append(info);
            }
            else{
            NodoDoble<T> newNodo;
            newNodo = new NodoDoble(info);
            newNodo.setNext(aux.nNext());
            newNodo.setPrev(aux);
            aux.nNext().setPrev(newNodo);
            aux.setNext(newNodo);
            this.len++;
            }
             
        }  
    }



    public void delete(NodoDoble<T> pNodo){
        if (pNodo==pFirst){
            deleteFirst();
        }
        else if (pNodo==pLast){
            deleteLastone();
        }
        else{
            pNodo.nNext().setPrev(pNodo.nPrev());
            pNodo.nPrev().setNext(pNodo.nNext());
            this.len--;
        }
        
    }

    public void deleteFirst() {
        if (!esVacia()){
            if (pFirst.nNext()==null){
                pFirst=null;
                pLast=null;
            }
            else{
                pFirst.nNext().setPrev(null);
                this.pFirst=pFirst.nNext();
            }
            this.len--;
        }
    }


    public void deleteByIndex(int index) {
        if (index==0){
            this.deleteFirst();
        }
        else if (index==len-1){
            this.deleteLastone();
        }
        else if (index<len-1){
            NodoDoble<T> aux=this.searchByIndex(index-1);
            this.delete(aux);
        }
    }


    public void deleteByKey(T key) {
        NodoDoble <T> aux= pFirst;
        
        while (aux!=null){
            if (aux.get()==key){
                this.delete(aux);
                }
            aux=aux.nNext();
            }
                
    }
            
           
            
        
    


    public int getLen() {
        return this.len;
    }


    public void arrayToList(T[] array) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public int count(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public int suma() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void eliminarRepetidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void replace(T oldKey, T newKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
