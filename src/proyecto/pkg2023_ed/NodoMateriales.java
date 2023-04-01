/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2023_ed;

/**
 *
 * @author mfsv_
 */
public class NodoMateriales {
    //atributos
    private String dato;
    private int id;
    private NodoMateriales next;
    private NodoMateriales back;
            
    //contructor parametrizado
    public NodoMateriales(String dato, int id){
        this.dato = dato;
        this.id=id;
    }
    
    //Setter y Getter
    public String getDato(){
        return dato;
    }
    public void setDato(String dato){
        this.dato=dato;
    }
    
    public NodoMateriales getNext(){
        return next;
    }
    public void setNext(NodoMateriales next){
        this.next=next;
    }
    
    public NodoMateriales getBack(){
        return back;
    }
    public void setBack(NodoMateriales back){
        this.back=back;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    @Override
    public String toString(){
        return "" + dato ;
    }      
            
}
