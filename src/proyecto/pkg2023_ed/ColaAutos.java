
package proyecto.pkg2023_ed;

/**
 *
 * @author mfsv_
 */
public class ColaAutos {
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
    
    public NodoC nextOrder(){
        NodoC aux = frente; // asignar un nodo auxiliar igual al frente de la cola
        if(frente!=null){ //reviso si la cola no esta vacia
            frente=frente.getAtras(); // frente de la cola tome el valor del siguiente nodo que sigue en cola o que esta atras
            aux.setAtras(null); // al nodo aux lo desligo de la cola seteando el siguiente nodo como null
        }
        return aux; //retorno el nodo auxiliar
    }
}
