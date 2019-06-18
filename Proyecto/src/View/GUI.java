
package View;

public class GUI extends javax.swing.JFrame {

    private static GUI INSTANCE = null;
    /**
     * Creates new form Panel
     */
    public GUI() {
        //this.setUndecorated(true);
        initComponents();
    }
    
        /*Patron de diseño Singleton*/
    private synchronized static void createInstance(){
        if(INSTANCE == null){
            INSTANCE = new GUI();
        }
    }
    
    public static GUI getInstance(){
        createInstance();
        return INSTANCE;
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        TabProyecto = new javax.swing.JTabbedPane();
        TabPanelTickets = new javax.swing.JPanel();
        btnTicketsVerde = new javax.swing.JButton();
        ScrollPaneTicketsAmarillo = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaTickets = new javax.swing.JList<>();
        TabPanelConsultas = new javax.swing.JPanel();
        PanelConsultas = new javax.swing.JPanel();
        labelEncargado = new javax.swing.JLabel();
        ComboBoxEncargados = new javax.swing.JComboBox<>();
        labelFiltroFecha = new javax.swing.JLabel();
        labelFiltroEstado = new javax.swing.JLabel();
        ComboBoxFiltroEstado = new javax.swing.JComboBox<>();
        labelFiltroCategoria = new javax.swing.JLabel();
        ComboBoxFiltroCategoria = new javax.swing.JComboBox<>();
        labelDesde = new javax.swing.JLabel();
        labelHasta = new javax.swing.JLabel();
        ScrollPaneTickets = new javax.swing.JScrollPane();
        PanelConsultasTickets = new javax.swing.JPanel();
        labelTiquetico = new javax.swing.JLabel();
        labelServidor = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelServidor1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        PanelPrincipal.setBackground(new java.awt.Color(0, 204, 204));
        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TabProyecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TabProyecto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        TabPanelTickets.setBackground(new java.awt.Color(255, 255, 255));

        btnTicketsVerde.setBackground(new java.awt.Color(102, 153, 0));
        btnTicketsVerde.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTicketsVerde.setText("Agregar Avance");
        btnTicketsVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketsVerdeActionPerformed(evt);
            }
        });

        ListaTickets.setToolTipText("");
        jScrollPane1.setViewportView(ListaTickets);

        javax.swing.GroupLayout TabPanelTicketsLayout = new javax.swing.GroupLayout(TabPanelTickets);
        TabPanelTickets.setLayout(TabPanelTicketsLayout);
        TabPanelTicketsLayout.setHorizontalGroup(
            TabPanelTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabPanelTicketsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnTicketsVerde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(ScrollPaneTicketsAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabPanelTicketsLayout.setVerticalGroup(
            TabPanelTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabPanelTicketsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTicketsAmarillo)
                .addContainerGap())
            .addGroup(TabPanelTicketsLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnTicketsVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabPanelTicketsLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        TabProyecto.addTab("Proyectos", TabPanelTickets);

        TabPanelConsultas.setBackground(new java.awt.Color(255, 255, 255));

        labelEncargado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEncargado.setText("Encargado:");

        ComboBoxEncargados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        labelFiltroFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelFiltroFecha.setText("Fitro por fecha ");

        labelFiltroEstado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelFiltroEstado.setText("Filtro por Miembro");

        ComboBoxFiltroEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Satisfactorios", "Pendientes", "En Proceso" }));

        labelFiltroCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelFiltroCategoria.setText("Filtro por Fecha");

        ComboBoxFiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Verdes", "Amarillos", "Rojos" }));

        labelDesde.setText("Desde: ");

        labelHasta.setText("Hasta: ");

        ScrollPaneTickets.setBackground(new java.awt.Color(255, 255, 255));
        ScrollPaneTickets.setAutoscrolls(true);

        PanelConsultasTickets.setBackground(new java.awt.Color(255, 255, 255));
        PanelConsultasTickets.setAutoscrolls(true);

        javax.swing.GroupLayout PanelConsultasTicketsLayout = new javax.swing.GroupLayout(PanelConsultasTickets);
        PanelConsultasTickets.setLayout(PanelConsultasTicketsLayout);
        PanelConsultasTicketsLayout.setHorizontalGroup(
            PanelConsultasTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        PanelConsultasTicketsLayout.setVerticalGroup(
            PanelConsultasTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        ScrollPaneTickets.setViewportView(PanelConsultasTickets);

        javax.swing.GroupLayout PanelConsultasLayout = new javax.swing.GroupLayout(PanelConsultas);
        PanelConsultas.setLayout(PanelConsultasLayout);
        PanelConsultasLayout.setHorizontalGroup(
            PanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConsultasLayout.createSequentialGroup()
                .addGroup(PanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelConsultasLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(labelEncargado)
                        .addGap(29, 29, 29)
                        .addComponent(ComboBoxEncargados, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelConsultasLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(PanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelFiltroEstado)
                                .addComponent(labelFiltroFecha)
                                .addComponent(ComboBoxFiltroEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelFiltroCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComboBoxFiltroCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelConsultasLayout.createSequentialGroup()
                                .addComponent(labelDesde)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelHasta)
                                .addGap(134, 134, 134)))))
                .addComponent(ScrollPaneTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        PanelConsultasLayout.setVerticalGroup(
            PanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConsultasLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(PanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPaneTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelConsultasLayout.createSequentialGroup()
                        .addGroup(PanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEncargado)
                            .addComponent(ComboBoxEncargados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelFiltroFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDesde)
                            .addComponent(labelHasta))
                        .addGap(25, 25, 25)
                        .addComponent(labelFiltroEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxFiltroEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(labelFiltroCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TabPanelConsultasLayout = new javax.swing.GroupLayout(TabPanelConsultas);
        TabPanelConsultas.setLayout(TabPanelConsultasLayout);
        TabPanelConsultasLayout.setHorizontalGroup(
            TabPanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabPanelConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabPanelConsultasLayout.setVerticalGroup(
            TabPanelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabPanelConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabProyecto.addTab("Consultas", TabPanelConsultas);

        labelTiquetico.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        labelTiquetico.setText("ASACOM");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(labelTiquetico, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TabProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTiquetico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        labelServidor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelServidor.setForeground(new java.awt.Color(0, 0, 204));
        labelServidor.setText("USUARIO:");

        btnCerrar.setFont(new java.awt.Font("Arial", 2, 8)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconCerrar.jpg"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.setBorder(null);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        labelServidor1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelServidor1.setForeground(new java.awt.Color(0, 0, 204));
        labelServidor1.setText("Tipo usuario:");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelServidor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelServidor1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelServidor)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelServidor1)
                            .addComponent(jLabel3)))
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnTicketsVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketsVerdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTicketsVerdeActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxEncargados;
    private javax.swing.JComboBox<String> ComboBoxFiltroCategoria;
    private javax.swing.JComboBox<String> ComboBoxFiltroEstado;
    private javax.swing.JList<String> ListaTickets;
    private javax.swing.JPanel PanelConsultas;
    private javax.swing.JPanel PanelConsultasTickets;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JScrollPane ScrollPaneTickets;
    private javax.swing.JScrollPane ScrollPaneTicketsAmarillo;
    private javax.swing.JPanel TabPanelConsultas;
    private javax.swing.JPanel TabPanelTickets;
    private javax.swing.JTabbedPane TabProyecto;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnTicketsVerde;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDesde;
    private javax.swing.JLabel labelEncargado;
    private javax.swing.JLabel labelFiltroCategoria;
    private javax.swing.JLabel labelFiltroEstado;
    private javax.swing.JLabel labelFiltroFecha;
    private javax.swing.JLabel labelHasta;
    private javax.swing.JLabel labelServidor;
    private javax.swing.JLabel labelServidor1;
    private javax.swing.JLabel labelTiquetico;
    // End of variables declaration//GEN-END:variables
}
