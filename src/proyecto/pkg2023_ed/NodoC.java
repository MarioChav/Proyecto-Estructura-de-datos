/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2023_ed;

/**
 *
 * @author mfsv_
 */
public class NodoC {
    //atributos
    private String dato;
    private NodoC atras; 

    public String getDato() {
        return dato;
    }

    //get y set 
    public void setDato(String Dato) {
        this.dato = dato;
    }

    public NodoC getAtras() {
        return atras;
    }

    public void setAtras(NodoC atras) {
        this.atras = atras;
    }

    public NodoC(String dato) {
        this.dato = dato;
    }

    @Override 
    public String toString() {
        return dato;
    }
}
