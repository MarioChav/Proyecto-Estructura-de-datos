package proyecto.pkg2023_ed;

/**
 *
 * @author Joel Lopez
 */
public class ListaMateriales {

    //atributos
    private NodoMateriales cabeza;
    private NodoMateriales ultimo;

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

    /*private Nodo cabeza;

    public void inserta(int tipo) {
        if (cabeza == null) { //caso 1    
            switch (tipo) {
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
//            cabeza = new Nodo(tipo);
        } else if (cabeza.getNext() == null) { //caso 3            
//            cabeza.setNext(new Nodo(tipo));
        }
    }*/
    public NodoMateriales getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoMateriales cabeza) {
        this.cabeza = cabeza;
    }

}
