package proyecto.pkg2023_ed;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*import java.util.Timer;
import java.util.TimerTask;
 */
/**
 *
 * @author Joel Lopez
 */
public class Ordenes extends javax.swing.JFrame {

    private int salir;
    private int menuPrincipal;
<<<<<<< HEAD
    private static int segundosTranscurridos = 0;
    private static Timer timer;
    //Aqui van las costantes para los carros y materiales
=======
    ListaMateriales laLista = new ListaMateriales();

>>>>>>> 6f9d8fe37a9d8ba0632d95dd626cb525a2692dfa
    /**
     * Creates new form Ordenes
     */
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

        int cantidadMateriales = 3;
        insertar(cantidadMateriales, 0);
        agregarDatos(cantidadMateriales, 0);

<<<<<<< HEAD
        newOrderTime = new Timer(1000, null);
=======
        NodoMateriales aux;
        aux = laLista.getCabeza();

        //System.out.println(laLista.ImprimirUno(3, aux));

        newOrderTime = new Timer(15000, null);
>>>>>>> 6f9d8fe37a9d8ba0632d95dd626cb525a2692dfa
        newOrderTime.start();
        newOrderTime.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int min = 1;
                int max = 3;
                int randomInt = (int) Math.floor(Math.random() * (max - min + 1)) + min;

                //ColaAutos laCola = new ColaAutos();
                switch (randomInt) {
                    case 1:
                        laCola.encola(new NodoC("Maquinaria Pesada"));
                        break;
                    case 2:
                        laCola.encola(new NodoC("Super Auto"));
                        break;
                    default:
                        laCola.encola(new NodoC("Carro Carga"));
                        break;
                }
                System.out.flush();

                txtTotalDisponible.setText(laCola.frente.getDato());
                //ImprimirColaString();
                //System.out.print(laCola);
                //System.out.println("");
            }

        });

        //crea un grupo de botones para selecicionr solo boton 
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(rbMaterial1);
        grupoBotones.add(rbMaterial2);
        grupoBotones.add(rbMaterial3);
        grupoBotones.add(rbMaterial4);
        grupoBotones.add(rbMaterial5);
        grupoBotones.add(rbMaterial6);

    }

<<<<<<< HEAD
    private void ImprimirColaString() {

        System.out.println("Desde boton");
        System.out.print(laCola);
        System.out.println("");

    }

    private boolean ValidarOrdenMateriales() {
        boolean valido = false;
        switch (laCola.frente.getDato()) {
            case "Carro Carga":
                if (rbMaterial1.isSelected()) {
                    if (rbMaterial1.getText().equals("Motor de carga") || rbMaterial1.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial1.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial2.isSelected()) {
                    if (rbMaterial2.getText().equals("Motor de carga") || rbMaterial2.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial2.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial3.isSelected()) {
                    if (rbMaterial3.getText().equals("Motor de carga") || rbMaterial3.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial3.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial4.isSelected()) {
                    if (rbMaterial4.getText().equals("Motor de carga") || rbMaterial4.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial4.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial5.isSelected()) {
                    if (rbMaterial5.getText().equals("Motor de carga") || rbMaterial5.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial5.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial6.isSelected()) {
                    if (rbMaterial6.getText().equals("Motor de carga") || rbMaterial6.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial6.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                break;
            case "Super Auto":
                if (rbMaterial1.isSelected()) {
                    if (rbMaterial1.getText().equals("Motor especial deportivo") || rbMaterial1.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial1.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial2.isSelected()) {
                    if (rbMaterial2.getText().equals("Motor especial deportivo") || rbMaterial2.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial2.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial3.isSelected()) {
                    if (rbMaterial3.getText().equals("Motor especial deportivo") || rbMaterial3.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial3.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial4.isSelected()) {
                    if (rbMaterial4.getText().equals("Motor especial deportivo") || rbMaterial4.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial4.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial5.isSelected()) {
                    if (rbMaterial5.getText().equals("Motor especial deportivo") || rbMaterial5.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial5.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial6.isSelected()) {
                    if (rbMaterial6.getText().equals("Motor especial deportivo") || rbMaterial6.getText().equals("Carroceria")) {
                        valido = true;
                    } else {
                        errorMaterial6.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                break;
            case "Maquinaria Pesada":
                if (rbMaterial1.isSelected()) {
                    if (rbMaterial1.getText().equals("Motor de carga") || rbMaterial1.getText().equals("Llantas Unicas de trabajo") || rbMaterial1.getText().equals("Carroceria especial")) {
                        valido = true;
                    } else {
                        errorMaterial1.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial2.isSelected()) {
                    if (rbMaterial2.getText().equals("Motor de carga") || rbMaterial2.getText().equals("Llantas Unicas de trabajo") || rbMaterial2.getText().equals("Carroceria especial")) {
                        valido = true;
                    } else {
                        errorMaterial2.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial3.isSelected()) {
                    if (rbMaterial3.getText().equals("Motor de carga") || rbMaterial3.getText().equals("Llantas Unicas de trabajo") || rbMaterial3.getText().equals("Carroceria especial")) {
                        valido = true;
                    } else {
                        errorMaterial3.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial4.isSelected()) {
                    if (rbMaterial4.getText().equals("Motor de carga") || rbMaterial4.getText().equals("Llantas Unicas de trabajo") || rbMaterial4.getText().equals("Carroceria especial")) {
                        valido = true;
                    } else {
                        errorMaterial4.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial5.isSelected()) {
                    if (rbMaterial5.getText().equals("Motor de carga") || rbMaterial5.getText().equals("Llantas Unicas de trabajo") || rbMaterial5.getText().equals("Carroceria especial")) {
                        valido = true;
                    } else {
                        errorMaterial5.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                if (rbMaterial1.isSelected()) {
                    if (rbMaterial6.getText().equals("Motor de carga") || rbMaterial6.getText().equals("Llantas Unicas de trabajo") || rbMaterial6.getText().equals("Carroceria especial")) {
                        valido = true;
                    } else {
                        errorMaterial6.setText("Error material no coincide con el auto");
                        valido = false;
                    }
                }
                
        }
        return valido;
    }

=======
>>>>>>> 6f9d8fe37a9d8ba0632d95dd626cb525a2692dfa
    public int insertar(int x, int y) {
        if (x == y) {
            return x;
        } else {
            //ListaMateriales laLista = new ListaMateriales();
            int mini = 1;
            int maxi = 5;
            int randomIn = (int) Math.floor(Math.random() * (maxi - mini + 1)) + mini;

            if (randomIn == 1) {
                laLista.inserta("Motor especial deportivo", 1);
            } else if (randomIn == 2) {
                laLista.inserta("Motor de carga", 2);
            } else if (randomIn == 3) {
                laLista.inserta("Carroceria", 3);
            } else if (randomIn == 4) {
                laLista.inserta("Carroceria especial", 4);
            } else if (randomIn == 5) {
                laLista.inserta("Llantas Unicas de trabajo", 5);
            }
            /*Solo le muetra el texto donde esta el contador, se necesita agregar un ID para cuando tengamos 
            que elimiar un material de la lista*/
<<<<<<< HEAD
            if (x == 1) {
                rbMaterial1.setText(laLista.toString());
            }
            if (x == 2) {
                rbMaterial2.setText(laLista.toString());
            }
            if (x == 3) {
                rbMaterial3.setText(laLista.toString());
            }
            if (x == 4) {
                rbMaterial4.setEnabled(true);
                rbMaterial4.setText(laLista.toString());
            }
            if (x == 5) {
                rbMaterial5.setEnabled(true);
                rbMaterial5.setText(laLista.toString());
            }
            if (x == 6) {
                rbMaterial6.setEnabled(true);
                rbMaterial6.setText(laLista.toString());
            }
=======

>>>>>>> 6f9d8fe37a9d8ba0632d95dd626cb525a2692dfa
        }

        return insertar(x - 1, 0);

    }
<<<<<<< HEAD
    /*hay que enviar un id para identificar que hay que eliminar porque pueden 
    haber varios nombres iguales */
    public void eliminarMaterial(String pMaterial) {
        ListaMateriales laListaM = new ListaMateriales();
        //laListaM.eliminar(pMaterial);
    }
=======

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

>>>>>>> 6f9d8fe37a9d8ba0632d95dd626cb525a2692dfa
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtTotalDisponible = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtAuto = new javax.swing.JLabel();
        txtMaterial1 = new javax.swing.JLabel();
        txtMaterial2 = new javax.swing.JLabel();
        txtMaterial3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        rbMaterial1 = new javax.swing.JRadioButton();
        rbMaterial2 = new javax.swing.JRadioButton();
        rbMaterial3 = new javax.swing.JRadioButton();
        rbMaterial4 = new javax.swing.JRadioButton();
        rbMaterial5 = new javax.swing.JRadioButton();
        rbMaterial6 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSelectMaterial = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        errorMaterial1 = new javax.swing.JLabel();
        errorMaterial2 = new javax.swing.JLabel();
        errorMaterial3 = new javax.swing.JLabel();
        errorMaterial4 = new javax.swing.JLabel();
        errorMaterial5 = new javax.swing.JLabel();
        errorMaterial6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jButton1.setText("Proxima Orden");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Terminar");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Contruccion de Auto Emblema Actual:");

        txtMaterial1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterial1.setToolTipText("");

        txtMaterial2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterial2.setToolTipText("");

        txtMaterial3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterial3.setToolTipText("");

        jButton3.setText("Imprimir Lista");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(40, 40, 40)
                .addComponent(jButton2)
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAuto)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMaterial3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(txtMaterial2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaterial1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAuto)
                .addGap(36, 36, 36)
                .addComponent(txtMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMaterial2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMaterial3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Espacios Disponibles en");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("la cinta transportadora");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnSelectMaterial.setText("Seleccionar");
        btnSelectMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectMaterialActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Basurero");

        jLabel5.setText("Seleccione la parte");

        jLabel6.setText("del carro para eliminar");

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setForeground(new java.awt.Color(186, 186, 186));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/opciones.png"))); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/hogar.png"))); // NOI18N
        jMenuItem2.setText("Menu Principal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(txtTotalDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorMaterial1)
                            .addComponent(errorMaterial2)
                            .addComponent(errorMaterial3)
                            .addComponent(errorMaterial4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errorMaterial5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errorMaterial6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
=======
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
>>>>>>> 6f9d8fe37a9d8ba0632d95dd626cb525a2692dfa
                            .addComponent(jLabel6)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSelectMaterial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbMaterial1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbMaterial2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbMaterial3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbMaterial4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbMaterial5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbMaterial6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4)
<<<<<<< HEAD
                            .addComponent(jLabel5))))
                .addGap(23, 23, 23))
=======
                            .addComponent(jLabel5)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
>>>>>>> 6f9d8fe37a9d8ba0632d95dd626cb525a2692dfa
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(rbMaterial1)
                                                                    .addComponent(errorMaterial1))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(rbMaterial2))
                                                            .addComponent(errorMaterial2))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rbMaterial3))
                                                    .addComponent(errorMaterial3))
                                                .addGap(16, 16, 16)
                                                .addComponent(rbMaterial4))
                                            .addComponent(errorMaterial4))
                                        .addGap(18, 18, 18)
                                        .addComponent(rbMaterial5))
                                    .addComponent(errorMaterial5))
                                .addGap(18, 18, 18)
                                .addComponent(rbMaterial6))
                            .addComponent(errorMaterial6))
                        .addGap(29, 29, 29)
                        .addComponent(btnSelectMaterial)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotalDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Ingresar inicio = new Ingresar();
        inicio.setTitle("Ingreso del juego");
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSelectMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectMaterialActionPerformed
        if (ValidarOrdenMateriales() == true) {
            String material="";
            if (rbMaterial1.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial1.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial1.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial1.getText());
                }
                material = rbMaterial1.getText();
            } else if (rbMaterial2.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial2.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial2.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial2.getText());
                }
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
            } else if (rbMaterial4.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial4.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial4.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial4.getText());
                }
                material = rbMaterial4.getText();
            } else if (rbMaterial5.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial5.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial5.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial5.getText());
                }
                material = rbMaterial5.getText();
            } else if (rbMaterial6.isSelected()) {
                if (txtMaterial1.getText().isEmpty()) {
                    txtMaterial1.setText(rbMaterial6.getText());
                } else if (txtMaterial2.getText().isEmpty()) {
                    txtMaterial2.setText(rbMaterial6.getText());
                } else if (txtMaterial3.getText().isEmpty()) {
                    txtMaterial3.setText(rbMaterial6.getText());
                }
                material = rbMaterial6.getText();
            }
            eliminarMaterial(material);
        }
    }//GEN-LAST:event_btnSelectMaterialActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        menuPrincipal = JOptionPane.showConfirmDialog(null, "¿Desea ir al menú principal?",
                "Menú principal", JOptionPane.YES_NO_OPTION);
        if (menuPrincipal == 0) {
            new Ingresar().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        salir = JOptionPane.showConfirmDialog(null, "¿Desea salir?",
                "Salir del Sistema", JOptionPane.YES_NO_OPTION);
        if (salir == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

<<<<<<< HEAD
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ImprimirColaString();
    }//GEN-LAST:event_jButton3ActionPerformed
=======
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed
>>>>>>> 6f9d8fe37a9d8ba0632d95dd626cb525a2692dfa

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
    private javax.swing.JButton btnSelectMaterial;
    private javax.swing.JLabel errorMaterial1;
    private javax.swing.JLabel errorMaterial2;
    private javax.swing.JLabel errorMaterial3;
    private javax.swing.JLabel errorMaterial4;
    private javax.swing.JLabel errorMaterial5;
    private javax.swing.JLabel errorMaterial6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbMaterial1;
    private javax.swing.JRadioButton rbMaterial2;
    private javax.swing.JRadioButton rbMaterial3;
    private javax.swing.JRadioButton rbMaterial4;
    private javax.swing.JRadioButton rbMaterial5;
    private javax.swing.JRadioButton rbMaterial6;
    private javax.swing.JLabel txtAuto;
    private javax.swing.JLabel txtMaterial1;
    private javax.swing.JLabel txtMaterial2;
    private javax.swing.JLabel txtMaterial3;
    private javax.swing.JLabel txtTotalDisponible;
    // End of variables declaration//GEN-END:variables
}
