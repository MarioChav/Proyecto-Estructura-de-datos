package proyecto.pkg2023_ed;

/**
 *
 * @author Joel Lopez
 */
public class ListaOrdenes {

    private Nodo cabeza;

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
    }
}
