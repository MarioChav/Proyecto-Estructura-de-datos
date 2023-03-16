
package proyecto.pkg2023_ed;

/**
 *
 * @author mfsv_
 */
public class Cola {
    //atributos
    NodoC frente;
    NodoC ultimo;

    //metodo queue 
    public void encola(NodoC d) {
        if (frente == null) {
            frente = d;
            ultimo = d;
        } else {
            ultimo.setAtras(d);
            ultimo = d;
        }
    }

    public String toString(){
        String s ="";
        NodoC aux = frente;
        while (aux!=null){
            s += aux+"\n";
            aux = aux.getAtras();
        }
        return s;
        
    }
}
