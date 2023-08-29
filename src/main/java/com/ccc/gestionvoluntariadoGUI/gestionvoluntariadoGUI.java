/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ccc.gestionvoluntariadoGUI;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/*
 * @author Ermes
 */
public final class gestionvoluntariadoGUI extends javax.swing.JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
     * Creates new form gestionvoluntariadoGUI
     */
    public gestionvoluntariadoGUI() {
        initComponents();
        mostrarContenidoTabla();
    }
    
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        
        panelVol = new javax.swing.JPanel();
        panelBen = new javax.swing.JPanel();
        panelAcc = new javax.swing.JPanel();
        panelReg = new javax.swing.JPanel();
        panelPro = new javax.swing.JPanel();
        
        tablaVol = new javax.swing.JTable();
        tablaBen = new javax.swing.JTable();
        tablaAcc = new javax.swing.JTable();
        tablaReg = new javax.swing.JTable();
        tablaPro = new javax.swing.JTable();
        tablaNumCol = 4;
        
        scrollBen = new javax.swing.JScrollPane();
        scrollVol = new javax.swing.JScrollPane();
        scrollPro = new javax.swing.JScrollPane();
        scrollAcc = new javax.swing.JScrollPane();
        scrollReg = new javax.swing.JScrollPane();

        nomColVol = new String[]{"Nombre","Apellidos", "Titulación"};
        nomColBen = new String[]{"Nombre","Apellidos", "Nacionalidad"};
        nomColAcc = new String[]{"Fecha","Participantes", "Area"};
        nomColReg = new String[]{"id_ben","id_pro", "Estado"};
        nomColPro = new String[]{"Nombre","AnnoEjecucion", "NumPlazas"};
        
        tablaVol = createTable(nomColVol);
        tablaBen = createTable(nomColBen);
        tablaAcc = createTable(nomColAcc);
        tablaReg = createTable(nomColReg);
        tablaPro = createTable(nomColPro);
        
        btnCreaVol  = createButton("Crear voluntario", evt -> btnCreaVolActionPerformed(evt));
        btnEditVol  = createButton("Editar voluntario", evt -> btnEditVolActionPerformed(evt));
        btnElimVol  = createButton("Eliminar voluntario", evt -> btnElimVolActionPerformed(evt));
        btnBuscVol  = createButton("Buscar voluntario", evt -> btnBuscVolActionPerformed(evt));
        
        btnCreaBen  = createButton("Crear usuario", evt -> btnCreaBenActionPerformed(evt));
        btnEditBen  = createButton("Editar usuario", evt -> btnEditBenActionPerformed(evt));
        btnElimBen  = createButton("Eliminar usuario", evt -> btnElimBenActionPerformed(evt));
        btnBuscBen  = createButton("Buscar usuario", evt -> btnBuscBenActionPerformed(evt));
        
        btnCreaAcc  = createButton("Crear acción", evt -> btnCreaAccActionPerformed(evt));
        btnEditAcc  = createButton("Editar acción", evt -> btnEditAccActionPerformed(evt));
        btnElimAcc  = createButton("Eliminar acción", evt -> btnElimAccActionPerformed(evt));
        btnBuscAcc  = createButton("Buscar acción", evt -> btnBuscAccActionPerformed(evt));
                
        btnCreaReg  = createButton("Crear registro", evt -> btnCreaRegActionPerformed(evt));
        btnEditReg  = createButton("Editar registro", evt -> btnEditRegActionPerformed(evt));
        btnElimReg  = createButton("Eliminar registro", evt -> btnElimRegActionPerformed(evt));
        btnBuscReg  = createButton("Buscar registro", evt -> btnBuscRegActionPerformed(evt));
        
        btnMostInfo  = createButton("Mostrar informe", evt -> btnMostInfoActionPerformed(evt));      
        btnCreaPro  = createButton("Crear proyecto", evt -> btnCreaProActionPerformed(evt));
        btnEditPro  = createButton("Editar voluntario", evt -> btnEditProActionPerformed(evt));
        btnElimPro  = createButton("Eliminar proyecto", evt -> btnElimProActionPerformed(evt));
        btnBuscPro  = createButton("Buscar proyecto", evt -> btnBuscProActionPerformed(evt));
        
        //btnRefresca  = createButton("\u27B2", evt -> btnRefrescaActionPerformed(evt));      
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Voluntariado");

        scrollVol.setViewportView(tablaVol);
        scrollBen.setViewportView(tablaBen);
        scrollAcc.setViewportView(tablaAcc);
        scrollReg.setViewportView(tablaReg);
        scrollPro.setViewportView(tablaPro);
        
        jTabbedPane1.addTab("Voluntarios", panelVol);
        jTabbedPane1.addTab("Usuarios", panelBen);
        jTabbedPane1.addTab("Acciones", panelAcc);
        jTabbedPane1.addTab("Altas-Bajas", panelReg);
        jTabbedPane1.addTab("Proyectos", panelPro);
                
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelVol);
        panelVol.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCreaVol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditVol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElimVol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscVol)
                .addContainerGap(77, Short.MAX_VALUE))
            .addComponent(scrollVol)
        );
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreaVol)
                    .addComponent(btnEditVol)
                    .addComponent(btnElimVol)
                    .addComponent(btnBuscVol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollVol, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panelBen);
        panelBen.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnCreaBen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditBen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElimBen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscBen)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(scrollBen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );
        
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditBen)
                        .addComponent(btnElimBen)
                        .addComponent(btnBuscBen))
                        .addComponent(btnCreaBen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollBen, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(panelAcc);
        panelAcc.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnCreaAcc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditAcc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElimAcc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscAcc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrollAcc)
        );
        
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreaAcc)
                    .addComponent(btnEditAcc)
                    .addComponent(btnElimAcc)
                    .addComponent(btnBuscAcc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(panelReg);
        panelReg.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnCreaReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElimReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscReg)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(scrollReg, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );
        
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreaReg)
                    .addComponent(btnEditReg)
                    .addComponent(btnElimReg)
                    .addComponent(btnBuscReg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollReg, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(panelPro);
        panelPro.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnMostInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreaPro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditPro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElimPro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscPro)
                .addGap(0, 11, Short.MAX_VALUE))
            .addComponent(scrollPro)
        );
        
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostInfo)
                    .addComponent(btnCreaPro)
                    .addComponent(btnEditPro)
                    .addComponent(btnElimPro)
                    .addComponent(btnBuscPro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPro, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }                        
    private void btnCreaVolActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        v.ventanasEmergentesCrear(nomColVol, v::creaVol);
        mostrarContenidoTabla();
    }                                        

    private void btnCreaBenActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaEmergente v = new VentanaEmergente();
        v.ventanasEmergentesCrear(nomColBen,v::creaBen);
        mostrarContenidoTabla();
    }
    
    private void btnCreaAccActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        v.ventanasEmergentesCrear(nomColAcc,v::creaAcc);
        mostrarContenidoTabla();
    }                                        
    
    private void btnCreaRegActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        v.ventanasEmergentesCrearReg(nomColReg,v::creaReg);
        mostrarContenidoTabla();
    }                                        
    
    private void btnCreaProActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        v.ventanasEmergentesCrear(nomColPro,v::creaPro);
        mostrarContenidoTabla();
    }
    
    private void btnBuscVolActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        v.ventanasEmergentesCrear(nomColVol, (String[] valores) -> {
        tablaVol.setModel(v.buscVol(valores));
        });
    }                                        

    private void btnBuscProActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.buscPro(v.ventanasEmergentes(nomColPro));
        
    }                                         
    
    private void btnEditRegActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.editReg(v.ventanasEmergentes(nomColReg));
    }                                        
    
    private void btnElimVolActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.elimVol(v.ventanasEmergentes(nomColVol));
    }                                        

    private void btnEditVolActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.editVol(v.ventanasEmergentes(nomColVol));
    }                                        
    
    private void btnElimBenActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.elimBen(v.ventanasEmergentes(nomColBen));
    }
    
    private void btnEditBenActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.editBen(v.ventanasEmergentes(nomColBen));
    }

    private void btnBuscBenActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.buscBen(v.ventanasEmergentes(nomColBen));
    }                                         

    private void btnEditAccActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.editAcc(v.ventanasEmergentes(nomColAcc));
    }                                         
    
    private void btnElimAccActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.elimAcc(v.ventanasEmergentes(nomColAcc));
    }                                        

    private void btnBuscAccActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.buscAcc(v.ventanasEmergentes(nomColAcc));
    }                                         

    private void btnElimRegActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.elimReg(v.ventanasEmergentes(nomColReg));
    }                                         

    private void btnBuscRegActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.buscReg(v.ventanasEmergentes(nomColReg));
    }                                         

    private void btnEditProActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.editPro(v.ventanasEmergentes(nomColPro));
    }                                         

    private void btnElimProActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.elimPro(v.ventanasEmergentes(nomColPro));
    }                                         

    private void btnMostInfoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.mostInfo(v.ventanasEmergentes(nomColPro));
    }
    
    private void btnRefrescaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        VentanaEmergente v = new VentanaEmergente();
        enConstruccion(); //v.mostInfo(v.ventanasEmergentes(nomColPro));
    }                                         
    
    void mostrarContenidoTabla()
    {
        LogicaRellenado logica = new LogicaRellenado();
        
        DefaultTableModel modeloVol = logica.mostrarContenidoTabla(nomColVol,tablaNumCol,"Voluntarios" );
        DefaultTableModel modeloBen = logica.mostrarContenidoTabla(nomColBen,tablaNumCol,"Beneficiarios" );
        DefaultTableModel modeloAcc = logica.mostrarContenidoTablaAcc(nomColAcc,tablaNumCol,"AccionVoluntariado" );
        DefaultTableModel modeloRbp = logica.mostrarContenidoTabla(nomColReg,tablaNumCol,"RelacionBeneficiariosProyectos" );
        DefaultTableModel modeloPro = logica.mostrarContenidoTabla(nomColPro,tablaNumCol,"Proyectos" );
        
        tablaVol.setModel(modeloVol);
        tablaBen.setModel(modeloBen);
        tablaAcc.setModel(modeloAcc);
        tablaReg.setModel(modeloRbp);
        tablaPro.setModel(modeloPro);
    }
    
    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }
    
    private JTable createTable(String[] columnNames) {
        DefaultTableModel tableModel = new DefaultTableModel(null, columnNames);
        JTable table = new JTable(tableModel);
        return table;
}
    
static void enConstruccion(){
    JOptionPane.showMessageDialog(null, "Actualmente la funcionalidad de este botón no está disponible. Disculpe las molestias", "Aplicativo en construcción", 1);
}

    // Variables declaration - do not modify                     

    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelVol,panelBen,panelAcc,panelReg,panelPro;
    private javax.swing.JScrollPane scrollBen,scrollVol,scrollAcc,scrollReg,scrollPro;
    private javax.swing.JTable tablaVol,tablaBen,tablaAcc,tablaReg,tablaPro;
    static String[] nomColVol,nomColBen,nomColAcc,nomColReg,nomColPro;
    private javax.swing.JButton btnCreaVol,btnEditVol,btnElimVol,btnBuscVol;
    private javax.swing.JButton btnCreaBen,btnEditBen,btnElimBen,btnBuscBen;
    private javax.swing.JButton btnCreaAcc,btnEditAcc,btnElimAcc,btnBuscAcc;
    private javax.swing.JButton btnCreaReg,btnEditReg,btnElimReg,btnBuscReg;
    private javax.swing.JButton btnCreaPro,btnEditPro,btnElimPro,btnBuscPro;
    @SuppressWarnings("unused")
	private javax.swing.JButton btnMostInfo, btnRefresca;
    private int tablaNumCol;
    // End of variables declaration                   
}