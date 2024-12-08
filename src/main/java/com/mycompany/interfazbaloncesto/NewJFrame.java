package com.mycompany.interfazbaloncesto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
/**
 *
 * @author walth
 */
public class NewJFrame extends javax.swing.JFrame {
    
    WritingToExcel wte;
    
    
    
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        this.wte = new WritingToExcel();
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/images/logoCalBal.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PantallaPrincipal = new javax.swing.JPanel();
        PantallaDatos = new javax.swing.JPanel();
        cabeceraDatos = new javax.swing.JLabel();
        panelFormulario = new javax.swing.JPanel();
        txtNombre = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        txtTca = new javax.swing.JLabel();
        txtT3a = new javax.swing.JLabel();
        txtTci = new javax.swing.JLabel();
        spinnerTca = new javax.swing.JSpinner();
        spinnerT3a = new javax.swing.JSpinner();
        spinnerTci = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spinnerTli = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spinnerP = new javax.swing.JSpinner();
        fondoDatos = new javax.swing.JLabel();
        PantallaResultados = new javax.swing.JPanel();
        cabeceraResultados = new javax.swing.JLabel();
        ContenedorCajasResultados = new javax.swing.JPanel();
        ContendorEfg = new javax.swing.JPanel();
        resultadoEFG = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ContenedorFg = new javax.swing.JPanel();
        resultadoFG = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ContenedorTs = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        resultadoTs = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botonCalcular = new javax.swing.JButton();
        botonExportar = new javax.swing.JButton();
        botonGlosario = new javax.swing.JButton();
        botonResetear = new javax.swing.JButton();
        botonExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de Estadisticas de la NBA");

        PantallaPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        PantallaDatos.setBackground(new java.awt.Color(255, 255, 255));
        PantallaDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cabeceraDatos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cabeceraDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconoDatos.png"))); // NOI18N
        cabeceraDatos.setText("Datos:");
        PantallaDatos.add(cabeceraDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, 50));

        panelFormulario.setBackground(new java.awt.Color(0, 93, 53));
        panelFormulario.setLayout(new java.awt.GridBagLayout());

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtNombre.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 15;
        panelFormulario.add(txtNombre, gridBagConstraints);

        inputNombre.setForeground(new java.awt.Color(204, 204, 204));
        inputNombre.setText("texto");
        inputNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputNombreFocusLost(evt);
            }
        });
        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 80;
        panelFormulario.add(inputNombre, gridBagConstraints);

        txtTca.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTca.setText("TCA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 3, 0);
        panelFormulario.add(txtTca, gridBagConstraints);

        txtT3a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtT3a.setText("T3A:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 3, 0);
        panelFormulario.add(txtT3a, gridBagConstraints);

        txtTci.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTci.setText("TCI:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 3, 0);
        panelFormulario.add(txtTci, gridBagConstraints);

        spinnerTca.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelFormulario.add(spinnerTca, gridBagConstraints);

        spinnerT3a.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelFormulario.add(spinnerT3a, gridBagConstraints);

        spinnerTci.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelFormulario.add(spinnerTci, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("TLI:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 3, 0);
        panelFormulario.add(jLabel4, gridBagConstraints);

        spinnerTli.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelFormulario.add(spinnerTli, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("P:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 3, 0);
        panelFormulario.add(jLabel5, gridBagConstraints);

        spinnerP.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelFormulario.add(spinnerP, gridBagConstraints);

        PantallaDatos.add(panelFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, 280));

        fondoDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoRedondeadoDatosPruebaNose2.png"))); // NOI18N
        PantallaDatos.add(fondoDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 310));

        PantallaResultados.setBackground(new java.awt.Color(255, 255, 255));
        PantallaResultados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cabeceraResultados.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cabeceraResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconoResultado.png"))); // NOI18N
        cabeceraResultados.setText("Resultados:");
        PantallaResultados.add(cabeceraResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, -1));

        ContenedorCajasResultados.setBackground(new java.awt.Color(255, 255, 255));
        ContenedorCajasResultados.setLayout(new java.awt.GridBagLayout());

        ContendorEfg.setBackground(new java.awt.Color(255, 255, 255));
        ContendorEfg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resultadoEFG.setBackground(new java.awt.Color(255, 255, 255));
        resultadoEFG.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        resultadoEFG.setForeground(new java.awt.Color(255, 255, 255));
        resultadoEFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultadoEFG.setText("-%");
        ContendorEfg.add(resultadoEFG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 60));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("%eFG:");
        ContendorEfg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoResultados2.png"))); // NOI18N
        ContendorEfg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ContenedorCajasResultados.add(ContendorEfg, new java.awt.GridBagConstraints());

        ContenedorFg.setBackground(new java.awt.Color(255, 255, 255));
        ContenedorFg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resultadoFG.setBackground(new java.awt.Color(255, 255, 255));
        resultadoFG.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        resultadoFG.setForeground(new java.awt.Color(255, 255, 255));
        resultadoFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultadoFG.setText("-%");
        ContenedorFg.add(resultadoFG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 60));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("%FG:");
        ContenedorFg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoResultados1.png"))); // NOI18N
        ContenedorFg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ContenedorCajasResultados.add(ContenedorFg, new java.awt.GridBagConstraints());

        ContenedorTs.setBackground(new java.awt.Color(255, 255, 255));
        ContenedorTs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("%TS");
        ContenedorTs.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, -1));

        resultadoTs.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        resultadoTs.setForeground(new java.awt.Color(255, 255, 255));
        resultadoTs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultadoTs.setText("-%");
        ContenedorTs.add(resultadoTs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 280, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoTs.png"))); // NOI18N
        jLabel6.setToolTipText("");
        ContenedorTs.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        ContenedorCajasResultados.add(ContenedorTs, gridBagConstraints);

        PantallaResultados.add(ContenedorCajasResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 300, 300));

        jPanel2.setBackground(new java.awt.Color(0, 93, 53));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logtipoNBA.png"))); // NOI18N
        jLabel1.setText("Jugador");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        botonCalcular.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        botonExportar.setText("Exportar");
        botonExportar.setToolTipText("");
        botonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExportarActionPerformed(evt);
            }
        });

        botonGlosario.setText("Glosario");

        botonResetear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonResetear.setText("Resetear");
        botonResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonResetearActionPerformed(evt);
            }
        });

        botonExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoExcel.png"))); // NOI18N
        botonExcel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botonExcelFocusGained(evt);
            }
        });
        botonExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PantallaPrincipalLayout = new javax.swing.GroupLayout(PantallaPrincipal);
        PantallaPrincipal.setLayout(PantallaPrincipalLayout);
        PantallaPrincipalLayout.setHorizontalGroup(
            PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PantallaPrincipalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PantallaPrincipalLayout.createSequentialGroup()
                        .addComponent(botonGlosario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PantallaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PantallaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PantallaPrincipalLayout.createSequentialGroup()
                        .addComponent(botonResetear)
                        .addGap(70, 70, 70)
                        .addComponent(botonExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonExportar)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PantallaPrincipalLayout.setVerticalGroup(
            PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PantallaPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PantallaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PantallaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonGlosario)
                            .addComponent(botonExportar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PantallaPrincipalLayout.createSequentialGroup()
                        .addGroup(PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botonResetear, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PantallaPrincipalLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(botonExcel)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PantallaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PantallaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void focusGainedInput(javax.swing.JTextField input ){
        String texto = input.getText();
        if (texto.equals("texto")){
            input.setText("");
            input.setForeground(new java.awt.Color(0,0,0));
        }
    }
    
    private void focusLostInput(javax.swing.JTextField input){
        String texto = input.getText();
        if (texto.equals("")){
            input.setText("texto");
            input.setForeground(new java.awt.Color(204,204,204));
        }
    }
    
    private ArrayList<String> obtenerDatos(){
        String nombre = inputNombre.getText();
        String tca = spinnerTca.getValue().toString();
        String t3a = spinnerT3a.getValue().toString();
        String tci = spinnerTci.getValue().toString();
        String tli = spinnerTli.getValue().toString();
        String p = spinnerP.getValue().toString();
        String fg = resultadoFG.getText();
        String efg = resultadoEFG.getText();
        String ts = resultadoTs.getText();
        
        return new ArrayList<>(Arrays.asList(
                nombre, 
                tca, 
                t3a, 
                tci, 
                tli, 
                p, 
                fg.substring(0,fg.length() - 1), 
                efg.substring(0,efg.length() - 1), 
                ts.substring(0,ts.length()-1)
        ));
    }    
    
   
    
    private void botonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExportarActionPerformed
            
        ArrayList<String> datosPantalla = obtenerDatos();
        ArrayList<String> claves = new ArrayList<>(Arrays.asList(wte.getCabecera()));
        HashMap<String,String> mapDatos= new HashMap<>();
        
        for (int i = 0; i < datosPantalla.size();i++){
            mapDatos.put(claves.get(i),datosPantalla.get(i));
        }
            
        try {
            wte.escribirDatosInforme(mapDatos);
        } catch (IOException e) {
            System.out.println("Error exportando datos: " + e.getMessage());
        }

        
        
    }//GEN-LAST:event_botonExportarActionPerformed

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed
        
    }//GEN-LAST:event_inputNombreActionPerformed

    private void inputNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNombreFocusGained
        focusGainedInput(inputNombre);
    }//GEN-LAST:event_inputNombreFocusGained

    private void inputNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNombreFocusLost
        focusLostInput(inputNombre);
    }//GEN-LAST:event_inputNombreFocusLost

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed

    // Obtener valores de los tres JTextFields
    int tca = (int) spinnerTca.getValue();
    int t3a = (int) spinnerT3a.getValue();
    int tci = (int) spinnerTci.getValue();
    int tli = (int) spinnerTli.getValue();
    int p = (int) spinnerP.getValue();

    // hacer las respectivas operaiones
    double fg = ((double)tca/tci) * 100;
    double efg = ((double)(tca + (0.5 * t3a)) / tci) * 100;
    double ts = ((double) p / (2* (tci + 0.44 * tli))) * 100;
    // Mostrar el resultado en un JLabel
    resultadoFG.setText(String.format("%.2f",fg) + "%");
    resultadoEFG.setText(String.format("%.2f",efg) + "%");
    resultadoTs.setText(String.format("%.2f",ts) + "%");
      
    }//GEN-LAST:event_botonCalcularActionPerformed

    private void botonResetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonResetearActionPerformed
        resultadoEFG.setText("-%");
        resultadoFG.setText("-%");
        resultadoTs.setText("-%");
        inputNombre.setText("texto");
        inputNombre.setForeground(new java.awt.Color(204,204,204));
        spinnerTca.setValue((int)0);
        spinnerT3a.setValue((int)0);
        spinnerTci.setValue((int)0);
        spinnerTli.setValue((int)0);
        spinnerP.setValue((int)0);
        
    }//GEN-LAST:event_botonResetearActionPerformed

    private void botonExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExcelActionPerformed
        wte.abrirExcel();
    }//GEN-LAST:event_botonExcelActionPerformed

    private void botonExcelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonExcelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_botonExcelFocusGained
    
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContendorEfg;
    private javax.swing.JPanel ContenedorCajasResultados;
    private javax.swing.JPanel ContenedorFg;
    private javax.swing.JPanel ContenedorTs;
    private javax.swing.JPanel PantallaDatos;
    private javax.swing.JPanel PantallaPrincipal;
    private javax.swing.JPanel PantallaResultados;
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonExcel;
    private javax.swing.JButton botonExportar;
    private javax.swing.JButton botonGlosario;
    private javax.swing.JButton botonResetear;
    private javax.swing.JLabel cabeceraDatos;
    private javax.swing.JLabel cabeceraResultados;
    private javax.swing.JLabel fondoDatos;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JLabel resultadoEFG;
    private javax.swing.JLabel resultadoFG;
    private javax.swing.JLabel resultadoTs;
    private javax.swing.JSpinner spinnerP;
    private javax.swing.JSpinner spinnerT3a;
    private javax.swing.JSpinner spinnerTca;
    private javax.swing.JSpinner spinnerTci;
    private javax.swing.JSpinner spinnerTli;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtT3a;
    private javax.swing.JLabel txtTca;
    private javax.swing.JLabel txtTci;
    // End of variables declaration//GEN-END:variables
}
