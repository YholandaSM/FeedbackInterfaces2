/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.feedbackinterfaces2.vista;

import com.mycompany.feedbackinterfaces2.controlador.Funciones;
import static com.mycompany.feedbackinterfaces2.controlador.Funciones.devolverIdEstado;
import static com.mycompany.feedbackinterfaces2.controlador.Funciones.devolverIdSeccion;
import com.mycompany.feedbackinterfaces2.modelo.Incidencia;
import com.mycompany.feedbackinterfaces2.modelo.conexion.ConexionMySql;
import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Hp
 */
public class JFIncidencias extends javax.swing.JFrame {

    /**
     * Creates new form JFIncidencias
     */
    public JFIncidencias() {
        initComponents();
        cargarComboboxClientes();
        cargarComboboxSecciones();
        cargarComboboxEstado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCSeccion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jCEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        rSDateDesde = new rojeru_san.componentes.RSDateChooser();
        jLabel6 = new javax.swing.JLabel();
        rSDateHasta = new rojeru_san.componentes.RSDateChooser();
        jBBuscar = new javax.swing.JButton();
        jBInsertar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jButtonPdf = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableIncidencias = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INCIDENCIAS");

        jLabel2.setText("CLIENTE");

        jCCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Sección");

        jCSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Estado");

        jCEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEstadoActionPerformed(evt);
            }
        });

        jLabel5.setText("F. desde");

        jLabel6.setText("F. hasta");

        jBBuscar.setText("BUSCAR");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBInsertar.setText("INSERTAR");
        jBInsertar.setEnabled(false);
        jBInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsertarActionPerformed(evt);
            }
        });

        jBEliminar.setText("ELIMINAR");
        jBEliminar.setEnabled(false);
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jButtonPdf.setText("Informe");
        jButtonPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPdfActionPerformed(evt);
            }
        });

        jTableIncidencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cliente", "Id.", "Descripción", "Sección", "Fecha", "Importe", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableIncidencias);
        if (jTableIncidencias.getColumnModel().getColumnCount() > 0) {
            jTableIncidencias.getColumnModel().getColumn(1).setResizable(false);
        }

        jBGuardar.setText("Guardar cambios ");
        jBGuardar.setEnabled(false);
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(65, 65, 65)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rSDateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rSDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBBuscar)
                                .addGap(24, 24, 24)
                                .addComponent(jButtonPdf)))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBCancelar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBInsertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(rSDateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBBuscar)
                            .addComponent(jButtonPdf)))
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(jBInsertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEliminar)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBGuardar)
                    .addComponent(jBCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        mostrarIncidencias();

    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jButtonPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPdfActionPerformed
        //http://www.laurafolgado.es/desarrollointerfaces/2017/02/incluir-informes-jasper-en-un-proyecto-de-java-swing/
        try {

            //los parametros a 0 
            Map<String, Object> parameters = new HashMap();
            parameters.put("cliente", txtCliente);
            parameters.put("seccion", txtSeccion);
            parameters.put("estado", txtEstado);
            parameters.put("fechaDesde", txtFechaDesde);
            parameters.put("fechaHasta", txtFechaHasta);
            //1.Obtenemos la conexión

            //2.Obtenemos el objeto JasperPrint
            JasperPrint jasperPrint
                    = JasperFillManager.fillReport("./src/main/java/com/mycompany/feedbackinterfaces2/vista/reports/incidencias.jasper", parameters, c);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            //3.Realizamos la exportación a formato pdf
            //   JasperExportManager
            //  .exportReportToPdfFile(jasperPrint, "./src/main/java/com/mycompany/feedbackinterfaces2/reports/incidencias.pdf");
            //   File path = new File ("./src/main/java/com/mycompany/feedbackinterfaces2/reports/incidencias.pdf");
            //  Desktop.getDesktop().open(path);

            viewer.setVisible(true);
            viewer.setTitle("Informe Incidencias");

        } catch (JRException ex) {
            Logger.getLogger(JFIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPdfActionPerformed

    private void jCEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCEstadoActionPerformed

    private void jBInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInsertarActionPerformed
        accion = 1;
        insertarIncidencia();
        jBGuardar.setEnabled(true);
    }//GEN-LAST:event_jBInsertarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        guardarCambios();   // TODO add your handling code here:
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        eliminarIncidencia();
    }//GEN-LAST:event_jBEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(JFIncidencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFIncidencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFIncidencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFIncidencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFIncidencias().setVisible(true);
            }
        });
    }

    /**
     * Cargamos la lista desplegable de clientes con los datos que hay en la
     * BBDD en la tabla clientes.
     *
     * @param clientes
     */
    public void cargarComboboxClientes() {
        try {
            ConexionMySql con = new ConexionMySql();
            Connection c = con.conectar();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select concat(nombre,'  ',apellidos) as nombre from clientes");
            jCCliente.removeAllItems();
            jCCliente.addItem("**Todos**");
            while (rs.next()) {
                jCCliente.addItem(rs.getString(1));

            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(JFIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     */
    public void cargarComboboxSecciones() {
        try {
            ConexionMySql con = new ConexionMySql();
            Connection c = con.conectar();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select  nombre  from secciones");
            jCSeccion.removeAllItems();
            jCSeccion.addItem("**Todos**");
            while (rs.next()) {
                jCSeccion.addItem(rs.getString(1));

            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(JFIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarComboboxEstado() {
        try {
            ConexionMySql con = new ConexionMySql();
            Connection c = con.conectar();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select concat(codigo,'  ',descripcion) as estado from estado");
            jCEstado.removeAllItems();
            jCEstado.addItem("**Todos**");
            while (rs.next()) {
                jCEstado.addItem(rs.getString(1));

            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(JFIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método que rellena la jTble, una vez que se pulsa el botón BUSCAR.
     */
    public void mostrarIncidencias() {
        /**
         * ***********CONFIGURACIONES********************
         */
        //1.Sólo se puede seleccionar una fila en la tabla
        jTableIncidencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //2.Una vez seleccionada una fila, se habilitará el botón ELIMINAR
        jTableIncidencias.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int cuentaFilasSeleccionadas = jTableIncidencias.getSelectedRowCount();
                if (cuentaFilasSeleccionadas == 1) {
                    jBEliminar.setEnabled(true);
                } else {
                    jBEliminar.setEnabled(false);
                }
            }

        });

        //3.Creamos el modelo que gestionará los datos de la tabla
        //y sobreescribimos el método isCellEditable para hacer que
        //las columnas cliente e Id. NO sean editables
        modelo = new DefaultTableModel() {
            @Override
            //Las columnas cliente e Id. NO son editables
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1) {
                    return false;
                }
                return true;
            }
        };
        /**
         * **VOLCAR DATOS A LA TABLA*************************
         */
        /*1.Recuperamos datos introducidos en los criterios de selección
        por el usuario:
         */
        try {
            //CLIENTE
            txtCliente = Funciones.devolverIdCliente(jCCliente.getSelectedItem().toString());
            //Si hay un cliente seleccionado habilitamos botón de insertar
            if (txtCliente != null) {
                jBInsertar.setEnabled(true);

            } else {
                jBInsertar.setEnabled(false);

            }
            //SECCION
            txtSeccion = Funciones.devolverIdSeccion(jCSeccion.getSelectedItem().toString());
            //ESTADO
            txtEstado = Funciones.devolverIdEstado(jCEstado.getSelectedItem().toString());
            //FECHA DESDE Y HASTA
            if (rSDateDesde.getDatoFecha() != null) {
                txtFechaDesde = Funciones.convert(rSDateDesde.getDatoFecha());
            }
            if (rSDateHasta.getDatoFecha() != null) {
                txtFechaHasta = Funciones.convert(rSDateHasta.getDatoFecha());
            }

            /*2.Con los datos ontroducidos por el usuario hacemos una consulta 
            a BBDD*/
            ResultSet datos = Funciones.consultarIncidencias(txtCliente, txtSeccion, txtEstado, txtFechaDesde, txtFechaHasta);

            /*3.y volcamos los datos en la tabla:*/
            //1º Pintamos los nombres de las columnas
            ResultSetMetaData rsMd = datos.getMetaData();
            int numeroColumnas = rsMd.getColumnCount();
            modelo.addColumn("Cliente");
            modelo.addColumn("Id");
            modelo.addColumn("Descripción");
            modelo.addColumn("Sección");
            modelo.addColumn("Fecha");
            modelo.addColumn("Importe");
            modelo.addColumn("Estado");
            //2º Rellenamos las filas de la columna con los que nos ha
            //devuelto la consulta a BBDD
            while (datos.next()) {
                Object[] filas = new Object[numeroColumnas];
                for (int i = 0; i < numeroColumnas; i++) {
                    filas[i] = datos.getObject(i + 1);

                }

                modelo.addRow(filas);

            }

            //comprobar que se ha seleccionado una fila
            int cuentaFilasSeleccionadas = jTableIncidencias.getSelectedRowCount();

            //4.Hacemos que la columna secciones sea  una lista desplegable
            jTableIncidencias.setModel(modelo);
            setCBSecciones(jTableIncidencias,
                    jTableIncidencias.getColumnModel().getColumn(3));
            //5.Hacemos que la columna estado sea  una lista desplegable
            setCBEstado(jTableIncidencias,
                    jTableIncidencias.getColumnModel().getColumn(6));
            //Limpiamos los campos de fechas
            rSDateDesde.setDatoFecha(null);
            rSDateHasta.setDatoFecha(null);
            txtFechaDesde = null;
            txtFechaHasta = null;

            /**
             * ****MODIFICAR UNA FILA DE LA TABLA******************
             */
            //evento que detecta la modificación de una columa, recoge los 
            //nuevos datos introducidos por el usuario y, con ellos
            //modifica en BBDD
            modelo.addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                  
                    if (e.getType() == TableModelEvent.UPDATE && accion != INSERTAR) {
                  
                        int columna = e.getColumn();
                        int fila = e.getFirstRow();
                        if (columna == 2) {
                            nuevaDes = (String) jTableIncidencias.getValueAt(fila, columna);
                        }
                        if (columna == 3) {
                            nuevaSeccion = (String) jTableIncidencias.getValueAt(fila, columna);
                        }
                        if (columna == 4) {
                            nuevaFecha = (String) jTableIncidencias.getValueAt(fila, columna);
                        }
                        if (columna == 5) {
                            nuevoImporte = (String) jTableIncidencias.getValueAt(fila, columna);
                        }
                        if (columna == 6) {
                            nuevoEstado = (String) jTableIncidencias.getValueAt(fila, columna);
                        }

                        idAmodificar = (Integer) jTableIncidencias.getValueAt(fila, 1);
                        jBGuardar.setEnabled(true);
                        accion=MODIFICAR;
                    }

                }
            });

            //fin 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Método que añade una fila vacía a la tabla
     */
    public void insertarIncidencia() {
        if (contAddRow == 0) {
            modelo.addRow(new Object[]{jCCliente.getSelectedItem().toString(),
                "2", "3", "Elige sección", " ", "6", "Elige estado"});
            contAddRow++;
            jBInsertar.setEnabled(false);
        }

    }

    /**
     *
     * @param tabla
     * @param columna
     */
    public void setCBSecciones(JTable tabla, TableColumn columna) {
        try {
            jCBTablaSecciones = new JComboBox();
            ConexionMySql con = new ConexionMySql();
            Connection connection = con.conectar();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select  nombre  from secciones");
            jCBTablaSecciones.removeAllItems();

            while (rs.next()) {
                jCBTablaSecciones.addItem(rs.getString(1));

            }
            connection.close();

            columna.setCellEditor(new DefaultCellEditor(jCBTablaSecciones));
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            columna.setCellRenderer(renderer);
        } catch (SQLException ex) {
            Logger.getLogger(JFIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setCBEstado(JTable tabla, TableColumn columna) {
        try {
            jCBTablaEstado = new JComboBox();
            ConexionMySql con = new ConexionMySql();
            Connection connection = con.conectar();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select concat(codigo,'  ',descripcion) as estado  from estado");
            jCBTablaEstado.removeAllItems();

            while (rs.next()) {
                jCBTablaEstado.addItem(rs.getString(1));

            }
            connection.close();

            columna.setCellEditor(new DefaultCellEditor(jCBTablaEstado));
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            columna.setCellRenderer(renderer);
        } catch (SQLException ex) {
            Logger.getLogger(JFIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método que elimina la fila seleccionada de la tabla
     */
    public void eliminarIncidencia() {

        int fila = jTableIncidencias.getSelectedRow();
        Integer id = (Integer) modelo.getValueAt(fila, modelo.findColumn("Id"));

        String seccion = jCBTablaSecciones.getSelectedItem().toString();

        if (Funciones.eliminarIncidencia(id)) {;
            JOptionPane.showMessageDialog(null, "Incidencia eliminada correctamente");
            modelo.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar la incidencia");

        }
    }

    public void guardarCambios() {

        //Insertar
        if (accion == INSERTAR) {
            try {
                int fila = modelo.getRowCount();
                int columna = modelo.findColumn("Cliente");
                String cliente = (String) modelo.getValueAt(modelo.getRowCount() - 1, modelo.findColumn("Cliente"));
                String descripcion = (String) modelo.getValueAt(modelo.getRowCount() - 1, modelo.findColumn("Descripción"));
                String seccion = jCBTablaSecciones.getSelectedItem().toString();
                String fecha = (String) modelo.getValueAt(modelo.getRowCount() - 1, modelo.findColumn("Fecha"));
                String importe = (String) modelo.getValueAt(modelo.getRowCount() - 1, modelo.findColumn("Importe"));
                String estado = jCBTablaEstado.getSelectedItem().toString();

                Incidencia inc = new Incidencia(descripcion,
                        Funciones.convertirStringAFecha(fecha),
                        Funciones.devolverIdCliente(cliente),
                        Funciones.devolverIdSeccion(seccion),
                        Funciones.devolverIdEstado(estado),
                        Float.parseFloat(importe));
                if (Funciones.insertar(inc)) {
                    //Inicializamos variables
                    jBInsertar.setEnabled(true);
                    contAddRow = 0;
                    JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido guardar la incidencia");
                }

            } catch (ParseException ex) {
                System.out.println("ParseException " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "No se ha podido guardar la incidencia");
            } catch (SQLException ex) {
                Logger.getLogger(JFIncidencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (accion == MODIFICAR) {

            try {
                //1obtenemos la incidencia a modificar
                Incidencia inc = Funciones.buscaIncidenciaPorId(idAmodificar);
                //Cambiamos a los nuevos valores
                if (nuevaDes != null) {
                    inc.setDescripcion(nuevaDes);
                }
                if (nuevaFecha != null) {
                    inc.setFecha((Date) Funciones.convertirStringAFecha(nuevaFecha));
                }
                if (nuevoImporte != null) {
                    inc.setImporte(Float.parseFloat(nuevoImporte));
                }
                if (nuevoEstado != null) {
                    inc.setIdEstado(devolverIdEstado(nuevoEstado));
                }
                if (nuevaSeccion != null) {
                    inc.setIdSeccion(devolverIdSeccion(nuevaSeccion));
                }

                if (Funciones.modificarIncidencia(inc)) {
                    JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se  ha modificado correctamente");
                }
            } catch (SQLException ex) {
                System.out.println("Error al modificar " + ex.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(JFIncidencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        accion=0;//reiniciamos varible de control .
    }
    //Nuevos valores a modificar
    String nuevaDes;
    String nuevaSeccion;
    String nuevaFecha;
    String nuevoImporte;
    String nuevoEstado;
    Integer idAmodificar;

    //Campo desplegable secciones de la tabla
    JComboBox jCBTablaSecciones;
    JComboBox jCBTablaEstado;

    //Tabla
    DefaultTableModel modelo;

    //Valores recogidos en las listas desplegables
    Integer txtCliente = 0;
    Integer txtSeccion = 0;
    Integer txtEstado = 0;
    java.sql.Date txtFechaDesde = null;
    java.sql.Date txtFechaHasta = null;

    //Conexion
    ConexionMySql con = new ConexionMySql();
    Connection c = con.conectar();

    //Actualizar, modificar o eliminar
    int accion = 0;//Variable de control para saber si estamos actualizando o modificando
    final int INSERTAR = 1;
    final int MODIFICAR = 2;

    //Contador para controlar que sólo se añade una fila a la tabla,
    //cuando se pulsa el botón AÑADIR
    int contAddRow = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBInsertar;
    private javax.swing.JButton jButtonPdf;
    private javax.swing.JComboBox<String> jCCliente;
    private javax.swing.JComboBox<String> jCEstado;
    private javax.swing.JComboBox<String> jCSeccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableIncidencias;
    private rojeru_san.componentes.RSDateChooser rSDateDesde;
    private rojeru_san.componentes.RSDateChooser rSDateHasta;
    // End of variables declaration//GEN-END:variables
}
