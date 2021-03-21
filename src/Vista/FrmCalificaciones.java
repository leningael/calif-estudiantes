/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Aplicacion.EstudiantesCSVInicio.listaAlumnos;
import Modelo.Excepciones.EntradaInvalidaExcepcion;
import Modelo.TbCalifs;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenin
 */
public class FrmCalificaciones extends javax.swing.JFrame {
    public TbCalifs modelo = new TbCalifs();
    /**
     * Creates new form FrmCalificaciones
     */
    public FrmCalificaciones() {
        initComponents();
        iniciaTabla();
    }
    public void iniciaTabla(){
        modelo.inicializaTabla(tblCalifs);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCalifs = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnCSV = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        lbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 100));
        setMaximumSize(new java.awt.Dimension(580, 550));
        setMinimumSize(new java.awt.Dimension(580, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(580, 550));
        getContentPane().setLayout(null);

        tblCalifs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCalifs);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 150, 480, 280);

        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(50, 460, 140, 40);

        btnCSV.setBorder(null);
        btnCSV.setBorderPainted(false);
        btnCSV.setContentAreaFilled(false);
        btnCSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSVActionPerformed(evt);
            }
        });
        getContentPane().add(btnCSV);
        btnCSV.setBounds(220, 460, 140, 40);

        btnPDF.setBorder(null);
        btnPDF.setBorderPainted(false);
        btnPDF.setContentAreaFilled(false);
        btnPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });
        getContentPane().add(btnPDF);
        btnPDF.setBounds(390, 460, 140, 40);

        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FrmCalificaciones.png"))); // NOI18N
        getContentPane().add(lbFondo);
        lbFondo.setBounds(0, 0, 580, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSVActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnCSVActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String calif;
        int flag = 0;
        DefaultTableModel tb = (DefaultTableModel) tblCalifs.getModel();
            for(int i = 0; i < this.tblCalifs.getRowCount();i++){
                calif = String.valueOf(tb.getValueAt(i,3));
                try{
                    if(Integer.parseInt(calif)<0 || Integer.parseInt(calif)>100)
                        throw new EntradaInvalidaExcepcion("Debe ingresar un número positivo como calificación");
                }catch(NumberFormatException e1){
                    calif = "0";
                }catch(EntradaInvalidaExcepcion e2){
                    flag = 1;
                    JOptionPane.showMessageDialog(rootPane, e2.getMessage());
                }
            }
            if(flag == 0){
                for(int i = 0; i < this.tblCalifs.getRowCount();i++){
                    calif = String.valueOf(tb.getValueAt(i,3));
                    listaAlumnos.get(i).setCalif(Integer.parseInt(calif));
                }  
                JOptionPane.showMessageDialog(rootPane, "Las calificaciones han sido registradas");
            }
            /*for(int i = 0; i < this.tblCalifs.getRowCount();i++)
                System.out.println("calif "+ i + " es: " + listaAlumnos.get(i).getCalif());*/
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPDFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCSV;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPDF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFondo;
    private javax.swing.JTable tblCalifs;
    // End of variables declaration//GEN-END:variables
}