
package proyecto.pkg2023_ed;

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Joel Lopez
 */
public class Ordenes extends javax.swing.JFrame {
    //Variables
    private static int segundosTranscurridos = 0;
    private int saldoDisponible = 15000;//cantidad de dinero disponible para el usuario
    private int radioB4 = 70000;//precio del 4to radio button 
    private int radioB5 = 80000;//precio del 5to radio button 
    private int radioB6 = 90000;//precio del 6to radio button 
    int cantidadMateriales = 3;//cantidad de materiales que se despliega inicialmente
    private boolean habilitar = false;
    private boolean habilitar2 = false;
    private int pend = 0;
    private int real = 0;
    
    private int gananciaMaquinaria_pesada = 18000;//ganacia por la maquinaria pesada para el usuario
    private int gananciaSuper_auto = 15000;//ganacia por el Super Auto para el usuario
    private int gananciaCarro_carga = 10000;//ganacia por el Carro de carga para el usuario
    

    //Costantes para los carros
    private String Maquinaria_pesada = "Maquinaria Pesada";
    private String Super_auto = "Super Auto";
    private String Carro_carga = "Carro Carga";
    //Costantes para los materiales
    private final String Motor_carga = "Motor de carga";
    private final String Carroceria = "Carroceria";
    private final String Motor_deportivo = "Motor especial deportivo";
    private final String Carroceria_especial = "Carroceria especial";
    private final String Llantas_trabajo = "Llantas unicas de trabajo";

    //lista para generar los materiales de la cinta transportadora
    ListaMateriales laLista = new ListaMateriales();

    /**
     * Creates new form Ordenes
     */
    
    private static Timer timer;
    public Timer newOrderTime, newMaterial;
    public Timer endGame;
    ColaAutos laCola = new ColaAutos();

    public Ordenes() {
        //Formato de pagina
        initComponents();
        setTitle("Car-Factory/Ordenes");
        setResizable(false);
        this.setLocationRelativeTo(null);
        rbMaterial4.setEnabled(false);
        rbMaterial5.setEnabled(false);
        rbMaterial6.setEnabled(false);

        insertar(cantidadMateriales, 0);//ingreso de los materiales a la cinta
        agregarDatos(cantidadMateriales, 0);//metodo que ingrese los materiales a los radio button
        encolaPrimero();//metodo que encola sin timer la cola de autos

        NodoMateriales aux;
        aux = laLista.getCabeza();

        //metodo para que aparezcan cada 15 seg autos
        newOrderTime = new Timer(15000, null);
        newOrderTime.start();
        newOrderTime.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int min = 1;
                int max = 3;
                int randomInt = (int) Math.floor(Math.random() * (max - min + 1)) + min;

                switch (randomInt) {
                    case 1:
                        laCola.encola(new NodoC(Maquinaria_pesada));
                        break;
                    case 2:
                        laCola.encola(new NodoC(Super_auto));
                        break;
                    default:
                        laCola.encola(new NodoC(Carro_carga));
                        break;
                }
                System.out.flush();

                Ordenes.setText(laCola.frente.getDato());
                pend =+1;
            }

        });
        //metodo para terminar el juego
        endGame = new Timer(480000, null);//timer de 8 minutos (480000 milisegundos) para terminar el tiempo
        endGame.start();
        endGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (saldoDisponible > 0 && real == pend) {
                    new Juego_Terminado().setVisible(true);
                    Juego_Terminado.Resultado.setText(" Ganaste ");
                    Juego_Terminado.PresupuestoFinal.setText(" " + saldoDisponible);
                    Juego_Terminado.txtCantOrdenes.setText(" "+ pend );
                    Juego_Terminado.txtOrdenesRealizadas.setText(" "+ real);
                } else {
                    new Juego_TerminadoPerdido().setVisible(true);
                    Juego_TerminadoPerdido.ResultadoPerdida.setText(" Perdiste ");
                    Juego_TerminadoPerdido.PresupuestoFinalPerdida.setText(" " + saldoDisponible);
                    Juego_TerminadoPerdido.txtCantOrdenesPerdida.setText(" "+ pend );
                    Juego_TerminadoPerdido.txtOrdenesRealizadasPerdida.setText(" "+ real);
                }
                dispose();
                endGame.stop();
            }

        });
        saldoActual();

        //crea un grupo de botones para selecicionr solo boton 
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(rbMaterial1);
        grupoBotones.add(rbMaterial2);
        grupoBotones.add(rbMaterial3);
        grupoBotones.add(rbMaterial4);
        grupoBotones.add(rbMaterial5);
        grupoBotones.add(rbMaterial6);

    }

    //metodo que envia al jFrame el saldo del usuario
    public void saldoActual() {
        Saldo.setText("$" + saldoDisponible);
    }

    //Metodo para que inicie la primera orden con un dato
    public void encolaPrimero() {
        int min = 1;
        int max = 3;
        int randomInt = (int) Math.floor(Math.random() * (max - min + 1)) + min;

        switch (randomInt) {
            case 1:
                laCola.encola(new NodoC(Maquinaria_pesada));
                break;
            case 2:
                laCola.encola(new NodoC(Super_auto));
                break;
            default:
                laCola.encola(new NodoC(Carro_carga));
                break;
        }
        Ordenes.setText(laCola.frente.getDato());
        pend =+1;
    }

    //metodo para validar que el usuario no seleccione un material incorrecto segun corrresponda cada auto
    private boolean ValidarOrdenMateriales() {
        boolean valido = false;

        switch (laCola.frente.getDato()) {
            case "Carro Carga":
                if (rbMaterial1.isSelected()) {
                    if (rbMaterial1.getText().equals(Motor_carga) || rbMaterial1.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);
                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial2.isSelected()) {
                    if (rbMaterial2.getText().equals(Motor_carga) || rbMaterial2.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);
                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial3.isSelected()) {
                    if (rbMaterial3.getText().equals(Motor_carga) || rbMaterial3.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial4.isSelected()) {
                    if (rbMaterial4.getText().equals(Motor_carga) || rbMaterial4.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);
                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                    
                }
                if (rbMaterial5.isSelected()) {
                    if (rbMaterial5.getText().equals(Motor_carga) || rbMaterial5.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                if (rbMaterial6.isSelected()) {
                    if (rbMaterial6.getText().equals(Motor_carga) || rbMaterial6.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                break;
                
            case "Super Auto":
                if (rbMaterial1.isSelected()) {
                    if (rbMaterial1.getText().equals(Motor_deportivo) || rbMaterial1.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                if (rbMaterial2.isSelected()) {
                    if (rbMaterial2.getText().equals(Motor_deportivo) || rbMaterial2.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial3.isSelected()) {
                    if (rbMaterial3.getText().equals(Motor_deportivo) || rbMaterial3.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial4.isSelected()) {
                    if (rbMaterial4.getText().equals(Motor_deportivo) || rbMaterial4.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial5.isSelected()) {
                    if (rbMaterial5.getText().equals(Motor_deportivo) || rbMaterial5.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial6.isSelected()) {
                    if (rbMaterial6.getText().equals(Motor_deportivo) || rbMaterial6.getText().equals(Carroceria)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                break;
                
            case "Maquinaria Pesada":
                if (rbMaterial1.isSelected()) {
                    if (rbMaterial1.getText().equals(Motor_carga) || rbMaterial1.getText().equals(Llantas_trabajo) || rbMaterial1.getText().equals(Carroceria_especial)) {
                        valido = true;
                        valido = verficarRepetido(valido);
                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial2.isSelected()) {
                    if (rbMaterial2.getText().equals(Motor_carga) || rbMaterial2.getText().equals(Llantas_trabajo) || rbMaterial2.getText().equals(Carroceria_especial)) {
                        valido = true;
                        valido = verficarRepetido(valido);
                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial3.isSelected()) {
                    if (rbMaterial3.getText().equals(Motor_carga) || rbMaterial3.getText().equals(Llantas_trabajo) || rbMaterial3.getText().equals(Carroceria_especial)) {
                        valido = true;
                        valido = verficarRepetido(valido);
                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial4.isSelected()) {
                    if (rbMaterial4.getText().equals(Motor_carga) || rbMaterial4.getText().equals(Llantas_trabajo) || rbMaterial4.getText().equals(Carroceria_especial)) {
                        valido = true;
                        valido = verficarRepetido(valido);
                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial5.isSelected()) {
                    if (rbMaterial5.getText().equals(Motor_carga) || rbMaterial5.getText().equals(Llantas_trabajo) || rbMaterial5.getText().equals(Carroceria_especial)) {
                        valido = true;
                        valido = verficarRepetido(valido);
                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }
                
                if (rbMaterial6.isSelected()) {
                    if (rbMaterial6.getText().equals(Motor_carga) || rbMaterial6.getText().equals(Llantas_trabajo) || rbMaterial6.getText().equals(Carroceria_especial)) {
                        valido = true;
                        valido = verficarRepetido(valido);

                    } else {
                        valido = false;
                        new Fallo().setVisible(true);
                    }
                }

        }
        return valido;
    }

    //metodo para que el usuario no pueda ingresar dos veces el mismo material
    public boolean verficarRepetido(boolean pValido) {
        if (rbMaterial2.isSelected()) {
            if (txtMaterial1.getText().equals(rbMaterial2.getText()) || txtMaterial2.equals(rbMaterial2.getText())) {
                pValido = false;
            } else {
                pValido = true;
            }
        }
        
        if (rbMaterial3.isSelected()) {
            if (txtMaterial1.getText().equals(rbMaterial3.getText()) || txtMaterial2.equals(rbMaterial3.getText())) {
                pValido = false;
            } else {
                pValido = true;
            }
        }
        
        if (rbMaterial4.isSelected()) {
            if (txtMaterial1.getText().equals(rbMaterial4.getText()) || txtMaterial2.equals(rbMaterial4.getText())) {
                pValido = false;
            } else {
                pValido = true;
            }
        }
        
        if (rbMaterial5.isSelected()) {
            if (txtMaterial1.getText().equals(rbMaterial5.getText()) || txtMaterial2.equals(rbMaterial5.getText())) {
                pValido = false;
            } else {
                pValido = true;
            }
        }
        
        if (rbMaterial6.isSelected()) {
            if (txtMaterial1.getText().equals(rbMaterial6.getText()) || txtMaterial2.equals(rbMaterial6.getText())) {
                pValido = false;
            } else {
                pValido = true;
            }
        }

        return pValido;
    }

    //metodo para ingresar de forma recursiva los datos de los materiales
    public int insertar(int x, int y) {
        if (x == y) {
            return x;
        } else {
            int mini = 1;
            int maxi = 5;
            int randomIn = (int) Math.floor(Math.random() * (maxi - mini + 1)) + mini;

            if (randomIn == 1) {
                laLista.inserta(Motor_deportivo, 1);
            } else if (randomIn == 2) {
                laLista.inserta(Motor_carga, 2);
            } else if (randomIn == 3) {
                laLista.inserta(Carroceria, 3);
            } else if (randomIn == 4) {
                laLista.inserta(Carroceria_especial, 4);
            } else if (randomIn == 5) {
                laLista.inserta(Llantas_trabajo, 5);
            }
        }
        
        return insertar(x - 1, 0);
    }

    //metodo para agregar los datos a los Radio button
    public int agregarDatos(int x, int y) {
        if (x == y) {
            return x;
        } else {
            NodoMateriales aux;
            aux = laLista.getCabeza();
            if (x == 1) {
                rbMaterial1.setText(aux.getDato());
            }
            if (x == 2) {
                rbMaterial2.setText(aux.getNext().getDato());
            }
            if (x == 3) {
                rbMaterial3.setText(aux.getNext().getNext().getDato());
            }
            if (x == 4) {
                rbMaterial4.setText(aux.getNext().getNext().getNext().getDato());
            }
            if (x == 5) {
                rbMaterial5.setText(aux.getNext().getNext().getNext().getNext().getDato());
            }
            if (x == 6) {
                rbMaterial6.setText(aux.getNext().getNext().getNext().getNext().getNext().getDato());
            }
        }
        return agregarDatos(x - 1, 0);

    }
    
    //metodo para que el usuario pueda eliminar materiales no necesitados
    //tmabien para limpiar los radio button cuando se selecciona un material
    private void eliminarMateriales() {
        NodoMateriales aux;
        aux = laLista.getCabeza();
        if (rbMaterial1.isSelected()) {
            laLista.elminarMaterial(rbMaterial1.getText(), aux.getId());
            insertar(1, 0);
            agregarDatos(1, 0);
        } else if (rbMaterial2.isSelected()) {
            laLista.elminarMaterial(rbMaterial2.getText(), aux.getNext().getId());
            insertar(1, 0);
            rbMaterial2.setText(aux.getNext().getDato());
        } else if (rbMaterial3.isSelected()) {
            laLista.elminarMaterial(rbMaterial3.getText(), aux.getNext().getNext().getId());
            insertar(1, 0);
            rbMaterial3.setText(aux.getNext().getNext().getDato());
        } else if (rbMaterial4.isSelected()) {
            laLista.elminarMaterial(rbMaterial4.getText(), aux.getNext().getNext().getNext().getId());
            insertar(1, 0);
            rbMaterial4.setText(aux.getNext().getNext().getNext().getDato());
        } else if (rbMaterial5.isSelected()) {
            laLista.elminarMaterial(rbMaterial5.getText(), aux.getNext().getNext().getNext().getNext().getId());
            insertar(1, 0);
            rbMaterial5.setText(aux.getNext().getNext().getNext().getNext().getDato());
        } else if (rbMaterial6.isSelected()) {
            laLista.elminarMaterial(rbMaterial6.getText(), aux.getNext().getNext().getNext().getNext().getNext().getId());
            insertar(1, 0);
            rbMaterial6.setText(aux.getNext().getNext().getNext().getNext().getNext().getDato());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SecConstruccion = new javax.swing.JPanel();
        TituloConstruccion = new javax.swing.JLabel();
        txtMaterial1 = new javax.swing.JLabel();
        txtMaterial2 = new javax.swing.JLabel();
        txtMaterial3 = new javax.swing.JLabel();
        ProximaOrden = new javax.swing.JButton();
        SecOrdenes = new javax.swing.JPanel();
        TituloOrdenes = new javax.swing.JLabel();
        Ordenes = new javax.swing.JLabel();
        SecSaldo = new javax.swing.JPanel();
        TituloSaldo = new javax.swing.JLabel();
        Saldo = new javax.swing.JLabel();
        SecMateriales = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbMaterial1 = new javax.swing.JRadioButton();
        rbMaterial2 = new javax.swing.JRadioButton();
        rbMaterial3 = new javax.swing.JRadioButton();
        rbMaterial4 = new javax.swing.JRadioButton();
        rbMaterial5 = new javax.swing.JRadioButton();
        rbMaterial6 = new javax.swing.JRadioButton();
        btnSelectMaterial = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        SecBasurero = new javax.swing.JPanel();
        Basurero = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        menuPrincipal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SecConstruccion.setBackground(new java.awt.Color(35, 31, 32));

        TituloConstruccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloConstruccion.setForeground(new java.awt.Color(250, 210, 1));
        TituloConstruccion.setText("Contruccion de Auto Emblema Actual:");

        txtMaterial1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterial1.setForeground(new java.awt.Color(0, 153, 153));
        txtMaterial1.setToolTipText("");

        txtMaterial2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterial2.setForeground(new java.awt.Color(0, 153, 153));
        txtMaterial2.setToolTipText("");

        txtMaterial3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterial3.setForeground(new java.awt.Color(0, 153, 153));
        txtMaterial3.setToolTipText("");

        ProximaOrden.setBackground(new java.awt.Color(250, 210, 1));
        ProximaOrden.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        ProximaOrden.setText("Proxima Orden");
        ProximaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProximaOrdenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SecConstruccionLayout = new javax.swing.GroupLayout(SecConstruccion);
        SecConstruccion.setLayout(SecConstruccionLayout);
        SecConstruccionLayout.setHorizontalGroup(
            SecConstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecConstruccionLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(SecConstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecConstruccionLayout.createSequentialGroup()
                        .addComponent(txtMaterial3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProximaOrden)
                        .addGap(24, 24, 24))
                    .addGroup(SecConstruccionLayout.createSequentialGroup()
                        .addGroup(SecConstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TituloConstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaterial2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        SecConstruccionLayout.setVerticalGroup(
            SecConstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecConstruccionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(TituloConstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtMaterial2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(SecConstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecConstruccionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtMaterial3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecConstruccionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProximaOrden)
                        .addGap(18, 18, 18))))
        );

        getContentPane().add(SecConstruccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 430, 220));

        SecOrdenes.setBackground(new java.awt.Color(35, 31, 32));

        TituloOrdenes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloOrdenes.setForeground(new java.awt.Color(250, 210, 1));
        TituloOrdenes.setText("Orden entrante:");

        Ordenes.setBackground(new java.awt.Color(0, 0, 0));
        Ordenes.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout SecOrdenesLayout = new javax.swing.GroupLayout(SecOrdenes);
        SecOrdenes.setLayout(SecOrdenesLayout);
        SecOrdenesLayout.setHorizontalGroup(
            SecOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloOrdenes)
                .addGap(18, 18, 18)
                .addComponent(Ordenes, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        SecOrdenesLayout.setVerticalGroup(
            SecOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SecOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ordenes, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(TituloOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(SecOrdenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 340, 40));

        SecSaldo.setBackground(new java.awt.Color(35, 31, 32));

        TituloSaldo.setBackground(new java.awt.Color(0, 0, 0));
        TituloSaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloSaldo.setForeground(new java.awt.Color(250, 210, 1));
        TituloSaldo.setText("Saldo Actual:");

        Saldo.setBackground(new java.awt.Color(0, 0, 0));
        Saldo.setForeground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout SecSaldoLayout = new javax.swing.GroupLayout(SecSaldo);
        SecSaldo.setLayout(SecSaldoLayout);
        SecSaldoLayout.setHorizontalGroup(
            SecSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloSaldo)
                .addGap(18, 18, 18)
                .addComponent(Saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        SecSaldoLayout.setVerticalGroup(
            SecSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SecSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Saldo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(TituloSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(SecSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 240, 40));

        SecMateriales.setBackground(new java.awt.Color(35, 31, 32));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 210, 1));
        jLabel1.setText("Espacios Disponibles en");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 210, 1));
        jLabel2.setText("la cinta transportadora");

        rbMaterial1.setBackground(new java.awt.Color(35, 31, 32));
        rbMaterial1.setForeground(new java.awt.Color(0, 153, 153));

        rbMaterial2.setBackground(new java.awt.Color(35, 31, 32));
        rbMaterial2.setForeground(new java.awt.Color(0, 153, 153));

        rbMaterial3.setBackground(new java.awt.Color(35, 31, 32));
        rbMaterial3.setForeground(new java.awt.Color(0, 153, 153));
        rbMaterial3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMaterial3ActionPerformed(evt);
            }
        });

        rbMaterial4.setBackground(new java.awt.Color(35, 31, 32));
        rbMaterial4.setForeground(new java.awt.Color(0, 153, 153));

        rbMaterial5.setBackground(new java.awt.Color(35, 31, 32));
        rbMaterial5.setForeground(new java.awt.Color(0, 153, 153));

        rbMaterial6.setBackground(new java.awt.Color(35, 31, 32));
        rbMaterial6.setForeground(new java.awt.Color(0, 153, 153));

        btnSelectMaterial.setBackground(new java.awt.Color(10, 220, 10));
        btnSelectMaterial.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnSelectMaterial.setForeground(new java.awt.Color(255, 255, 255));
        btnSelectMaterial.setText("Seleccionar");
        btnSelectMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectMaterialActionPerformed(evt);
            }
        });

        btnCompra.setBackground(new java.awt.Color(10, 180, 110));
        btnCompra.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnCompra.setText("Comprar Espacio");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SecMaterialesLayout = new javax.swing.GroupLayout(SecMateriales);
        SecMateriales.setLayout(SecMaterialesLayout);
        SecMaterialesLayout.setHorizontalGroup(
            SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecMaterialesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SecMaterialesLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SecMaterialesLayout.createSequentialGroup()
                        .addGroup(SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCompra)
                            .addGroup(SecMaterialesLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnSelectMaterial))
                            .addComponent(rbMaterial1)
                            .addComponent(rbMaterial2)
                            .addComponent(rbMaterial3)
                            .addComponent(rbMaterial4)
                            .addGroup(SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rbMaterial6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbMaterial5, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SecMaterialesLayout.setVerticalGroup(
            SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecMaterialesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbMaterial1)
                .addGap(18, 18, 18)
                .addComponent(rbMaterial2)
                .addGap(18, 18, 18)
                .addComponent(rbMaterial3)
                .addGap(18, 18, 18)
                .addComponent(rbMaterial4)
                .addGap(18, 18, 18)
                .addComponent(rbMaterial5)
                .addGap(18, 18, 18)
                .addComponent(rbMaterial6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnSelectMaterial)
                .addGap(18, 18, 18)
                .addComponent(btnCompra)
                .addGap(20, 20, 20))
        );

        getContentPane().add(SecMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 90, 190, 390));

        SecBasurero.setBackground(new java.awt.Color(35, 31, 32));

        Basurero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Basurero.setForeground(new java.awt.Color(250, 210, 1));
        Basurero.setText("Basurero");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 210, 1));
        jLabel5.setText("Seleccione la parte");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 210, 1));
        jLabel6.setText("del carro para eliminar");

        btnEliminar.setBackground(new java.awt.Color(230, 50, 20));
        btnEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SecBasureroLayout = new javax.swing.GroupLayout(SecBasurero);
        SecBasurero.setLayout(SecBasureroLayout);
        SecBasureroLayout.setHorizontalGroup(
            SecBasureroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecBasureroLayout.createSequentialGroup()
                .addGroup(SecBasureroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecBasureroLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(SecBasureroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(SecBasureroLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5))))
                    .addGroup(SecBasureroLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnEliminar))
                    .addGroup(SecBasureroLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Basurero)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        SecBasureroLayout.setVerticalGroup(
            SecBasureroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecBasureroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Basurero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(SecBasurero, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 150, 130));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpeg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 500));

        Menu.setBackground(new java.awt.Color(204, 204, 204));
        Menu.setForeground(new java.awt.Color(186, 186, 186));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/opciones.png"))); // NOI18N

        Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jMenu1.add(Salir);

        menuPrincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/hogar.png"))); // NOI18N
        menuPrincipal.setText("Menu Principal");
        menuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(menuPrincipal);

        Menu.add(jMenu1);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProximaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProximaOrdenActionPerformed
        if (Ordenes.getText().equals(Super_auto)) {
            saldoDisponible = saldoDisponible + gananciaSuper_auto;
            saldoActual();
        }
        else if (Ordenes.getText().equals(Maquinaria_pesada)) {
            saldoDisponible = saldoDisponible + gananciaMaquinaria_pesada;
            saldoActual();
        }else if (Ordenes.getText().equals(Carro_carga)) {
            saldoDisponible = saldoDisponible + gananciaCarro_carga;
            saldoActual();
        }

        if(txtMaterial1.getText() != "" && txtMaterial2.getText() != "") {
            txtMaterial1.setText("");
            txtMaterial2.setText("");
            txtMaterial3.setText("");
            Ordenes.setText("");
            laCola.nextOrder();
            real =+1;
        } else {
            new Fallo_Orden().setVisible(true);
        }
        
    }//GEN-LAST:event_ProximaOrdenActionPerformed

    private void btnSelectMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectMaterialActionPerformed
        if (ValidarOrdenMateriales() == true) {
            String material = "";
            if (rbMaterial1.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial1.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial1.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial1.getText());
                }
                material = rbMaterial1.getText();
                eliminarMateriales();
            } else if (rbMaterial2.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial2.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial2.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial2.getText());
                }
                eliminarMateriales();
                material = rbMaterial2.getText();
            } else if (rbMaterial3.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial3.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial3.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial3.getText());
                }
                material = rbMaterial3.getText();
                eliminarMateriales();
            } else if (rbMaterial4.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial4.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial4.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial4.getText());
                }
                material = rbMaterial4.getText();
                eliminarMateriales();
            } else if (rbMaterial5.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial5.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial5.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial5.getText());
                }
                material = rbMaterial5.getText();
                eliminarMateriales();
            } else if (rbMaterial6.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial6.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial6.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial6.getText());
                }
                material = rbMaterial6.getText();
                eliminarMateriales();
            }
        }
    }//GEN-LAST:event_btnSelectMaterialActionPerformed

    private void menuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPrincipalActionPerformed
        new Ingresar().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuPrincipalActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        new Salir().setVisible(true);
    }//GEN-LAST:event_SalirActionPerformed

    private void rbMaterial3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMaterial3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMaterial3ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarMateriales();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        if (radioB4 < saldoDisponible && habilitar == false) {
            cantidadMateriales += 1;
            insertar(cantidadMateriales, 0);
            agregarDatos(4, 0);
            habilitar = true;
            rbMaterial4.setEnabled(true);
            saldoDisponible = saldoDisponible - radioB4;
            saldoActual();

        } else if (radioB5 < saldoDisponible && habilitar2 == false) {
            cantidadMateriales += 1;
            insertar(cantidadMateriales, 0);
            agregarDatos(5, 0);
            habilitar2 = true;
            rbMaterial5.setEnabled(true);
            saldoDisponible -= radioB5;
            saldoActual();

        } else if (radioB6 < saldoDisponible) {
            cantidadMateriales += 1;
            insertar(cantidadMateriales, 0);
            agregarDatos(6, 0);
            rbMaterial6.setEnabled(true);
            saldoDisponible -= radioB6;
            saldoActual();
            btnCompra.setEnabled(false);
        }

    }//GEN-LAST:event_btnCompraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Ordenes().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Basurero;
    private javax.swing.JLabel Fondo;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JLabel Ordenes;
    private javax.swing.JButton ProximaOrden;
    private javax.swing.JLabel Saldo;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JPanel SecBasurero;
    private javax.swing.JPanel SecConstruccion;
    private javax.swing.JPanel SecMateriales;
    private javax.swing.JPanel SecOrdenes;
    private javax.swing.JPanel SecSaldo;
    private javax.swing.JLabel TituloConstruccion;
    private javax.swing.JLabel TituloOrdenes;
    private javax.swing.JLabel TituloSaldo;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSelectMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem menuPrincipal;
    private javax.swing.JRadioButton rbMaterial1;
    private javax.swing.JRadioButton rbMaterial2;
    private javax.swing.JRadioButton rbMaterial3;
    private javax.swing.JRadioButton rbMaterial4;
    private javax.swing.JRadioButton rbMaterial5;
    private javax.swing.JRadioButton rbMaterial6;
    private javax.swing.JLabel txtMaterial1;
    private javax.swing.JLabel txtMaterial2;
    private javax.swing.JLabel txtMaterial3;
    // End of variables declaration//GEN-END:variables
}
