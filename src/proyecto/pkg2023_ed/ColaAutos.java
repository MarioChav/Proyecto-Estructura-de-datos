
package proyecto.pkg2023_ed;

/**
 *
 * @author mfsv_
 */
public class ColaAutos {
    //atributos
    NodoC frente;
    NodoC ultimo;

    //metodo queue para encolar los autos
    public void encola(NodoC d) {
        if (frente == null) {
            frente = d;
            ultimo = d;
        } else {
            ultimo.setAtras(d);
            ultimo = d;
        }
    }

    //metodo de toString
    public String toString(){
        String s ="";
        NodoC aux = frente;
        while (aux!=null){
            s += aux+"\n";
            aux = aux.getAtras();
        }
        return s;     
    }
    
    //metodo para enviar la sigueinte orden
    public NodoC nextOrder(){
        NodoC aux = frente; 
        if(frente!=null){ 
            frente=frente.getAtras(); 
            aux.setAtras(null); 
            aux.setAtras(null); 
        }
        return aux; 
    }
}
