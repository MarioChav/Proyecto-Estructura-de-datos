package proyecto.pkg2023_ed;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Joel Lopez
 */
public class Ordenes extends javax.swing.JFrame {

    //Variables
    private int salir;
    private int menuPrincipal;
    private static int segundosTranscurridos = 0;
    private int saldoDisponible = 15000;

    //Aqui van las costantes para los carros y materiales
    private String Maquinaria_pesada = "Maquinaria Pesada";
    private String Super_auto = "Super Auto";
    private String Carro_carga = "Carro Carga";

    private final String Motor_carga = "Motor de carga";
    private final String Carroceria = "Carroceria";
    private final String Motor_deportivo = "Motor especial deportivo";
    private final String Carroceria_especial = "Carroceria especial";
    private final String Llantas_trabajo = "Llantas unicas de trabajo";

    ListaMateriales laLista = new ListaMateriales();

    /**
     * Creates new form Ordenes
     */
    //Saldo
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

        int cantidadMateriales = 3;
        insertar(cantidadMateriales, 0);
        agregarDatos(cantidadMateriales, 0);

        NodoMateriales aux;
        aux = laLista.getCabeza();

        newOrderTime = new Timer(15000, null);
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
                //ImprimirColaString();
                //System.out.print(laCola);
                //System.out.println("");
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

    public void saldoActual() {
        Saldo.setText("$" + saldoDisponible);
    }

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
                    if (rbMaterial1.getText().equals(Motor_carga) || rbMaterial1.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 4000;
                        saldoActual();
                        valido=validacion(valido);
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial2.isSelected()) {
                    if (rbMaterial2.getText().equals(Motor_carga) || rbMaterial2.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 5000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial3.isSelected()) {
                    if (rbMaterial3.getText().equals(Motor_carga) || rbMaterial3.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 6000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                        
                    }
                }
                if (rbMaterial4.isSelected()) {
                    if (rbMaterial4.getText().equals(Motor_carga) || rbMaterial4.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 7000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial5.isSelected()) {
                    if (rbMaterial5.getText().equals(Motor_carga) || rbMaterial5.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 8000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial6.isSelected()) {
                    if (rbMaterial6.getText().equals(Motor_carga) || rbMaterial6.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 9000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                break;
            case "Super Auto":
                if (rbMaterial1.isSelected()) {
                    if (rbMaterial1.getText().equals(Motor_deportivo) || rbMaterial1.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 4000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial2.isSelected()) {
                    if (rbMaterial2.getText().equals(Motor_deportivo) || rbMaterial2.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 5000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial3.isSelected()) {
                    if (rbMaterial3.getText().equals(Motor_deportivo) || rbMaterial3.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 6000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial4.isSelected()) {
                    if (rbMaterial4.getText().equals(Motor_deportivo) || rbMaterial4.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 7000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial5.isSelected()) {
                    if (rbMaterial5.getText().equals(Motor_deportivo) || rbMaterial5.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 8000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial6.isSelected()) {
                    if (rbMaterial6.getText().equals(Motor_deportivo) || rbMaterial6.getText().equals(Carroceria)) {
                        valido = true;
                        saldoDisponible -= 9000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                break;
            case "Maquinaria Pesada":
                if (rbMaterial1.isSelected()) {
                    if (rbMaterial1.getText().equals(Motor_carga) || rbMaterial1.getText().equals(Llantas_trabajo) || rbMaterial1.getText().equals(Carroceria_especial)) {
                        valido = true;
                        saldoDisponible -= 4000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial2.isSelected()) {
                    if (rbMaterial2.getText().equals(Motor_carga) || rbMaterial2.getText().equals(Llantas_trabajo) || rbMaterial2.getText().equals(Carroceria_especial)) {
                        valido = true;
                        saldoDisponible -= 5000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial3.isSelected()) {
                    if (rbMaterial3.getText().equals(Motor_carga) || rbMaterial3.getText().equals(Llantas_trabajo) || rbMaterial3.getText().equals(Carroceria_especial)) {
                        valido = true;
                        saldoDisponible -= 6000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial4.isSelected()) {
                    if (rbMaterial4.getText().equals(Motor_carga) || rbMaterial4.getText().equals(Llantas_trabajo) || rbMaterial4.getText().equals(Carroceria_especial)) {
                        valido = true;
                        saldoDisponible -= 7000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial5.isSelected()) {
                    if (rbMaterial5.getText().equals(Motor_carga) || rbMaterial5.getText().equals(Llantas_trabajo) || rbMaterial5.getText().equals(Carroceria_especial)) {
                        valido = true;
                        saldoDisponible -= 8000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }
                if (rbMaterial6.isSelected()) {
                    if (rbMaterial6.getText().equals(Motor_carga) || rbMaterial6.getText().equals(Llantas_trabajo) || rbMaterial6.getText().equals(Carroceria_especial)) {
                        valido = true;
                        saldoDisponible -= 9000;
                        saldoActual();
                        valido=validacion(valido);

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR" + "\n" + "el material seleccionado no coincide con las especificaciones del auto");
                        valido = false;
                    }
                }

        }
        return valido;
    }
    
    public boolean validacion(boolean pValido){
        if (rbMaterial2.isSelected()){
            
           if (txtMaterial1.getText().equals(rbMaterial2.getText())||txtMaterial2.equals(rbMaterial2.getText())) {
               
             pValido=false; 
             
            }else{
               pValido=true;
              
           }
        }
        if (rbMaterial3.isSelected()){
            
           if (txtMaterial1.getText().equals(rbMaterial3.getText())||txtMaterial2.equals(rbMaterial3.getText())) {
               
             pValido=false; 
             
            }else{
               pValido=true;
              
           }
        }
        if (rbMaterial4.isSelected()){
            
           if (txtMaterial1.getText().equals(rbMaterial4.getText())||txtMaterial2.equals(rbMaterial4.getText())) {
               
             pValido=false; 
             
            }else{
               pValido=true;
              
           }
        }
        if (rbMaterial5.isSelected()){
            
           if (txtMaterial1.getText().equals(rbMaterial5.getText())||txtMaterial2.equals(rbMaterial5.getText())) {
               
             pValido=false; 
             
            }else{
               pValido=true;
              
           }
        }
        if (rbMaterial6.isSelected()){
            
           if (txtMaterial1.getText().equals(rbMaterial6.getText())||txtMaterial2.equals(rbMaterial6.getText())) {
               
             pValido=false; 
             
            }else{
               pValido=true;
              
           }
        }
        
    
    
        return pValido;
    }


    public int insertar(int x, int y) {
        if (x == y) {
            return x;
        } else {
            //ListaMateriales laLista = new ListaMateriales();
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

            /*Solo le muetra el texto donde esta el contador, se necesita agregar un ID para cuando tengamos 
            que elimiar un material de la lista*/
 /*  if (x == 1) {
                rbMaterial1.setText(laLista.toString());

            }
            if (x == 2) {
                rbMaterial2.setText(laLista.toString());
            }
            if (x == 3) {
                rbMaterial3.setText(laLista.toString());
            }
            if (x == 4) {
                rbMaterial4.setText(laLista.toString());
            }
            if (x == 5) {
                rbMaterial5.setText(laLista.toString());
            }
            if (x == 6) {
                rbMaterial6.setText(laLista.toString());
            }*/
        }

        return insertar(x - 1, 0);

    }

    public void eliminarMaterial() {
        //ListaMateriales laListaM = new ListaMateriales();
        //laLista.eliminar(pMaterial);

    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SecConstruccion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtAuto = new javax.swing.JLabel();
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
        SecBasurero = new javax.swing.JPanel();
        Basurero = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SecConstruccion.setBackground(new java.awt.Color(82, 163, 111));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Contruccion de Auto Emblema Actual:");

        txtMaterial1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterial1.setToolTipText("");

        txtMaterial2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterial2.setToolTipText("");

        txtMaterial3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaterial3.setToolTipText("");

        ProximaOrden.setBackground(new java.awt.Color(255, 255, 0));
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
            .addGroup(SecConstruccionLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(SecConstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecConstruccionLayout.createSequentialGroup()
                        .addGroup(SecConstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAuto)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(195, Short.MAX_VALUE))
                    .addGroup(SecConstruccionLayout.createSequentialGroup()
                        .addGroup(SecConstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaterial3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(txtMaterial2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaterial1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecConstruccionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProximaOrden)
                .addGap(18, 18, 18))
        );
        SecConstruccionLayout.setVerticalGroup(
            SecConstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecConstruccionLayout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(ProximaOrden)
                .addGap(27, 27, 27))
        );

        getContentPane().add(SecConstruccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 490, 380));

        SecOrdenes.setBackground(new java.awt.Color(255, 153, 51));

        TituloOrdenes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloOrdenes.setText("Orden entrante:");

        Ordenes.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout SecOrdenesLayout = new javax.swing.GroupLayout(SecOrdenes);
        SecOrdenes.setLayout(SecOrdenesLayout);
        SecOrdenesLayout.setHorizontalGroup(
            SecOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloOrdenes)
                .addGap(50, 50, 50)
                .addComponent(Ordenes, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        SecOrdenesLayout.setVerticalGroup(
            SecOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SecOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Ordenes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TituloOrdenes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(SecOrdenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 24, 340, 40));

        SecSaldo.setBackground(new java.awt.Color(0, 255, 102));

        TituloSaldo.setBackground(new java.awt.Color(255, 0, 0));
        TituloSaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloSaldo.setText("Saldo Actual:");

        Saldo.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout SecSaldoLayout = new javax.swing.GroupLayout(SecSaldo);
        SecSaldo.setLayout(SecSaldoLayout);
        SecSaldoLayout.setHorizontalGroup(
            SecSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloSaldo)
                .addGap(28, 28, 28)
                .addComponent(Saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        SecSaldoLayout.setVerticalGroup(
            SecSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SecSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TituloSaldo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(SecSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 85, 240, 40));

        SecMateriales.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Espacios Disponibles en");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("la cinta transportadora");

        rbMaterial1.setBackground(new java.awt.Color(0, 153, 153));

        rbMaterial2.setBackground(new java.awt.Color(0, 153, 153));

        rbMaterial3.setBackground(new java.awt.Color(0, 153, 153));
        rbMaterial3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMaterial3ActionPerformed(evt);
            }
        });

        rbMaterial4.setBackground(new java.awt.Color(0, 153, 153));

        rbMaterial5.setBackground(new java.awt.Color(0, 153, 153));

        rbMaterial6.setBackground(new java.awt.Color(0, 153, 153));

        btnSelectMaterial.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        btnSelectMaterial.setText("Seleccionar");
        btnSelectMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectMaterialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SecMaterialesLayout = new javax.swing.GroupLayout(SecMateriales);
        SecMateriales.setLayout(SecMaterialesLayout);
        SecMaterialesLayout.setHorizontalGroup(
            SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecMaterialesLayout.createSequentialGroup()
                .addGroup(SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SecMaterialesLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SecMaterialesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbMaterial1)
                            .addComponent(rbMaterial2)
                            .addComponent(rbMaterial3)
                            .addComponent(rbMaterial4)
                            .addGroup(SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rbMaterial6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbMaterial5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnSelectMaterial))
                        .addGap(22, 22, 22)))
                .addGap(20, 20, 20))
            .addGroup(SecMaterialesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SecMaterialesLayout.setVerticalGroup(
            SecMaterialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecMaterialesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
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
                .addGap(19, 19, 19)
                .addComponent(btnSelectMaterial)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(SecMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        SecBasurero.setBackground(new java.awt.Color(153, 0, 0));

        Basurero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Basurero.setText("Basurero");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Seleccione la parte");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("del carro para eliminar");

        btnEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
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
                        .addGap(34, 34, 34)
                        .addComponent(Basurero))
                    .addGroup(SecBasureroLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(SecBasureroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(SecBasureroLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnEliminar)))))
                .addContainerGap(10, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(SecBasurero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 150, 120));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpeg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 640));

        Menu.setBackground(new java.awt.Color(102, 102, 102));
        Menu.setForeground(new java.awt.Color(186, 186, 186));

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

        Menu.add(jMenu1);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProximaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProximaOrdenActionPerformed


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
            //eliminarMaterial(material);
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

    private void rbMaterial3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMaterial3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMaterial3ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
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
            //agrega
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

    }//GEN-LAST:event_btnEliminarActionPerformed

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
    private javax.swing.JPanel SecBasurero;
    private javax.swing.JPanel SecConstruccion;
    private javax.swing.JPanel SecMateriales;
    private javax.swing.JPanel SecOrdenes;
    private javax.swing.JPanel SecSaldo;
    private javax.swing.JLabel TituloOrdenes;
    private javax.swing.JLabel TituloSaldo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSelectMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
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
    // End of variables declaration//GEN-END:variables
}
