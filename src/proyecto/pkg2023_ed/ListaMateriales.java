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
    
    //metodo para ingresar materiales a la lista
    public void inserta(String p, int id) {
        if (cabeza == null) {
            cabeza = new NodoMateriales(p, id);
            ultimo = cabeza;
            ultimo.setNext(cabeza);
            cabeza.setBack(ultimo);
        } else {
            NodoMateriales aux = cabeza;

            while (aux.getNext().getDato() != cabeza.getDato()) {
                aux = aux.getNext();
            }

            NodoMateriales temp = new NodoMateriales(p, id);
            temp.setNext(aux.getNext());
            temp.setBack(aux);
            aux.setNext(temp);
            temp.getNext().setBack(temp);
            ultimo = temp;
        }
    }

    //metodo para eliminar un material
    public void elminarMaterial(String nombre, int id) {
        if (cabeza != null) {
            if (cabeza.getDato()== nombre) {
                NodoMateriales aux = cabeza.getNext();
                cabeza = aux;
                ultimo.setNext(cabeza);
                cabeza.setBack(ultimo);
            } else {
                NodoMateriales aux = cabeza;
                while (aux.getNext() != cabeza && aux.getNext().getId() < id) {
                    aux = aux.getNext();
                }
                if (aux.getNext() != cabeza && aux.getNext().getDato()== nombre) {
                    aux.setNext(aux.getNext().getNext());
                    if (id == ultimo.getId()) {
                        ultimo = aux;
                        ultimo.setNext(cabeza);
                    } else {
                        ultimo.setNext(cabeza);
                        cabeza.setBack(ultimo);
                    }
                }
            }
        }
    }
    
    //to String
    @Override
    public String toString() {
        NodoMateriales aux = cabeza;
        String s = "";
        if (aux != null) {
            s += aux.getDato() + ", ";
            aux = aux.getNext();
            while (aux != cabeza) {
                s += aux.getDato() + ", ";
                aux = aux.getNext();
            }
        } else {
            s += "Lista vacia";
        }
        return s;
    }

    //metodo para imprimir un unico material
    public String ImprimirUno(int x, NodoMateriales aux) {
        if (x == 0) {
            return "";
        } else {
            
            System.out.println(aux);

            return ImprimirUno(x - 1, aux.getNext());
        }
    }

    public NodoMateriales getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoMateriales cabeza) {
        this.cabeza = cabeza;
    }

}
