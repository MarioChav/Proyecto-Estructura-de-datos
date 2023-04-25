package proyecto.pkg2023_ed;

public class main {
    
    public static void main(String[] args) {
        Inicio();
    }
    
    //metodo para inicializar el JFrame de inicio del juego
    public static void Inicio() {
        Ingresar inicio = new Ingresar();
        inicio.setTitle("Ingreso del juego");
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
    }

}
