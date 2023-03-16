
package proyecto.pkg2023_ed;


public class main {
 
    public static void main(String[] args) {
       //Inicio();
       lista();
    }
    
    public static void Inicio(){
        Ingresar inicio = new Ingresar();
        inicio.setTitle("Ingreso del juego");
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
    }
    
    public static void lista(){
        ListaMateriales laLista = new ListaMateriales();
        laLista.inserta( "Juan");
        laLista.inserta( "Pedro");
        
        System.out.println(laLista);
    }
    

}
