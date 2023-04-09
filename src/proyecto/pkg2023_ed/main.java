package proyecto.pkg2023_ed;

public class main {
    
    public static void main(String[] args) {
        Inicio();
        //insertar();
    }
    
    public static void Inicio() {
        Ingresar inicio = new Ingresar();
        inicio.setTitle("Ingreso del juego");
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
    }
    
    public static void insertar() {
        ListaMateriales laLista = new ListaMateriales();
        laLista.inserta("Motor especial deportivo", 1);
        
        laLista.inserta("Motor de carga", 2);
        
        laLista.inserta("Carroceria", 3);
        
        laLista.inserta("Carroceria especial", 4);
        
        laLista.inserta("Llantas Unicas de trabajo", 5);
        
        System.out.println(laLista.toString());
        laLista.elminarMaterial(1);
        System.out.println(laLista.toString());   
    }
}
