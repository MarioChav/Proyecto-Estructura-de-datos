package proyecto.pkg2023_ed;

/**
 *
 * @author Joel Lopez
 */
public class ListaMateriales {

    //atributos
    private NodoMateriales cabeza;
    private NodoMateriales ultimo;

    public boolean estaVacia() {
        return cabeza == null;
    }
    
    //metodo para ingresar personas a la lista
    public void inserta(String p) {
        if (cabeza == null) {//si esta vacia
            cabeza = new NodoMateriales(p);
            ultimo = cabeza;
            ultimo.setNext(cabeza);
            cabeza.setBack(ultimo);
        } else {
            NodoMateriales aux = cabeza;

            while (aux.getNext().getDato() != cabeza.getDato()) {
                aux = aux.getNext();
            }

            NodoMateriales temp = new NodoMateriales(p);
            temp.setNext(aux.getNext());
            temp.setBack(aux);
            aux.setNext(temp);
            temp.getNext().setBack(temp);
        }
    }
    
    //eliminar material de la cinta
    /*public void eliminar(int dato) {
        if (!estaVacia()) {
            Nodo actual = inicio;
            Nodo anterior = inicio.anterior;
            while (actual != anterior) {
                if (actual.dato == dato) {
                    if (actual == inicio) {
                        inicio = inicio.siguiente;
                    }
                    actual.siguiente.anterior = actual.anterior;
                    actual.anterior.siguiente = actual.siguiente;
                    return;
                }
                actual = actual.siguiente;
            }
            if (actual.dato == dato) {
                actual.siguiente.anterior = actual.anterior;
                actual.anterior.siguiente = actual.siguiente;
            }
        }
    }*/

    //to String
    @Override
    public String toString() {
        NodoMateriales aux = cabeza;
        String s = "";
        if (aux != null) {
            s += aux + "";
            aux = aux.getNext();
            while (aux != cabeza) {
                s += aux + ", ";
                aux = aux.getNext();
            }
        } else {
            s += "Lista vacia";
        }
        return s;
    }

    public NodoMateriales getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoMateriales cabeza) {
        this.cabeza = cabeza;
    }

}
