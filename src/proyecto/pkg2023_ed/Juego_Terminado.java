/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.pkg2023_ed;

/**
 *
 * @author jenni
 */
public class Juego_Terminado extends javax.swing.JFrame {

    /**
     * Creates new form Juego_Terminado
     */
    public Juego_Terminado() {
        initComponents();
        setTitle("Car-Factory/¡GANASTE!");
        setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TituloResultado = new javax.swing.JLabel();
        Resultado = new javax.swing.JLabel();
        TituloSaldo = new javax.swing.JLabel();
        PresupuestoFinal = new javax.swing.JLabel();
        TituloOrdenes = new javax.swing.JLabel();
        txtCantOrdenes = new javax.swing.JLabel();
        TituloOrdenesRealizadas = new javax.swing.JLabel();
        txtOrdenesRealizadas = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Reintentar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(35, 31, 32));

        TituloResultado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloResultado.setForeground(new java.awt.Color(250, 210, 1));
        TituloResultado.setText("Resultado: ");
        TituloResultado.setToolTipText("");

        Resultado.setForeground(new java.awt.Color(51, 255, 51));

        TituloSaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloSaldo.setForeground(new java.awt.Color(250, 210, 1));
        TituloSaldo.setText("Saldo Final:  ");
        TituloSaldo.setToolTipText("");

        PresupuestoFinal.setForeground(new java.awt.Color(51, 255, 51));

        TituloOrdenes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloOrdenes.setForeground(new java.awt.Color(250, 210, 1));
        TituloOrdenes.setText("Total de ordenes:  ");
        TituloOrdenes.setToolTipText("");

        txtCantOrdenes.setForeground(new java.awt.Color(51, 255, 51));

        TituloOrdenesRealizadas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TituloOrdenesRealizadas.setForeground(new java.awt.Color(250, 210, 1));
        TituloOrdenesRealizadas.setText("Ordenes realizadas:  ");
        TituloOrdenesRealizadas.setToolTipText("");

        txtOrdenesRealizadas.setForeground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TituloResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TituloSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PresupuestoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TituloOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TituloOrdenesRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrdenesRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloResultado)
                    .addComponent(Resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloSaldo)
                    .addComponent(PresupuestoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloOrdenes)
                    .addComponent(txtCantOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloOrdenesRealizadas)
                    .addComponent(txtOrdenesRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 260, 220));

        Titulo.setBackground(new java.awt.Color(35, 31, 32));
        Titulo.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(10, 220, 10));
        Titulo.setText("¡GANASTE!");
        Titulo.setOpaque(true);
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 260, 50));

        MenuPrincipal.setBackground(new java.awt.Color(10, 220, 10));
        MenuPrincipal.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        MenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        MenuPrincipal.setText("Menu Principal");
        MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(MenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        Salir.setBackground(new java.awt.Color(230, 50, 20));
        Salir.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        Reintentar.setBackground(new java.awt.Color(10, 220, 10));
        Reintentar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        Reintentar.setForeground(new java.awt.Color(255, 255, 255));
        Reintentar.setText("Jugar de nuevo");
        Reintentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReintentarActionPerformed(evt);
            }
        });
        getContentPane().add(Reintentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpeg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReintentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReintentarActionPerformed
        new Ordenes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReintentarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        new Salir().setVisible(true);
    }//GEN-LAST:event_SalirActionPerformed

    private void MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPrincipalActionPerformed
        // TODO add your handling code here:
        new Ingresar().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuPrincipalActionPerformed

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
            java.util.logging.Logger.getLogger(Juego_Terminado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego_Terminado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego_Terminado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego_Terminado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego_Terminado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton MenuPrincipal;
    public static javax.swing.JLabel PresupuestoFinal;
    private javax.swing.JButton Reintentar;
    public static javax.swing.JLabel Resultado;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel TituloOrdenes;
    private javax.swing.JLabel TituloOrdenesRealizadas;
    private javax.swing.JLabel TituloResultado;
    private javax.swing.JLabel TituloSaldo;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel txtCantOrdenes;
    public static javax.swing.JLabel txtOrdenesRealizadas;
    // End of variables declaration//GEN-END:variables
}
