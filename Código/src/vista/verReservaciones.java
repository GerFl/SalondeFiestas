package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class verReservaciones extends javax.swing.JFrame {
    /* CONEXIÓN */
    public static final String URL = "jdbc:mysql://localhost:3306/salon de fiestas";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    PreparedStatement ps;
    ResultSet rs;
    
    public static Connection getConnection(){
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"No hay conexión con la base de datos.");
        }
        return con;
    }
    /* CONEXIÓN */
    
    /**
     * Creates new form verReservaciones
     */
    public verReservaciones() {
        initComponents();
        Connection con = null;
        
        try{
            con = getConnection();
            DefaultTableModel modelo = new DefaultTableModel();
            reservaciones.setModel(modelo);
            DefaultTableModel tablaclientes = new DefaultTableModel();
            clientes.setModel(tablaclientes);
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            ps=con.prepareStatement("SELECT * FROM evento");
            rs=ps.executeQuery();
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("Tipo de evento");
            modelo.addColumn("Fecha");
            modelo.addColumn("Duración");
            modelo.addColumn("Costo");
            modelo.addColumn("Servicios");
            modelo.addColumn("Paquete");
            modelo.addColumn("ID del cliente");
            int[] anchos={50,250,250,200,200,400,100,150};
            for(int x=0;x<cantidadColumnas;x++){
                reservaciones.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }
            while(rs.next()){
                Object[] filas=new Object[cantidadColumnas];
                for(int i=0;i<cantidadColumnas;i++){
                    filas[i]=rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }
            
            ps=con.prepareStatement("SELECT * FROM cliente");
            rs=ps.executeQuery();
            ResultSetMetaData ressetmetadata = rs.getMetaData();
            int cantcolumnas = ressetmetadata.getColumnCount();
            tablaclientes.addColumn("ID");
            tablaclientes.addColumn("Nombre");
            tablaclientes.addColumn("Apellido");
            tablaclientes.addColumn("Edad");
            tablaclientes.addColumn("Teléfono");
            tablaclientes.addColumn("Dirección");
            tablaclientes.addColumn("Correo electrónico");
            int[] widths={50,250,250,50,200,200,300,300};
            for(int x=0;x<cantcolumnas;x++){
                clientes.getColumnModel().getColumn(x).setPreferredWidth(widths[x]);
            }
            while(rs.next()){
                Object[] rows=new Object[cantcolumnas];
                for(int i=0;i<cantcolumnas;i++){
                    rows[i]=rs.getObject(i+1);
                }
                tablaclientes.addRow(rows);
            }
        } catch(SQLException ex){
            System.err.println("No hay conexión con la base de datos.");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservaciones = new javax.swing.JTable();
        eliminarEvento = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        clientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        reservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reservaciones);

        eliminarEvento.setBackground(new java.awt.Color(217, 64, 50));
        eliminarEvento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        eliminarEvento.setForeground(new java.awt.Color(255, 255, 255));
        eliminarEvento.setText("Eliminar evento");
        eliminarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEventoActionPerformed(evt);
            }
        });

        regresar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        regresar.setText("Regresar al menú principal");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(clientes);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel1.setText("EVENTOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel2.setText("CLIENTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(406, 406, 406))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(eliminarEvento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(regresar)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarEvento)
                    .addComponent(regresar))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        menuPrincipal second = new menuPrincipal();
        second.setVisible(true);
        setVisible(false);   
    }//GEN-LAST:event_regresarActionPerformed

    private void eliminarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEventoActionPerformed
        Connection con = null;
        
        try{
            con = getConnection();
            int Fila = reservaciones.getSelectedRow();
            String codigo = reservaciones.getValueAt(Fila, 0).toString();
            ps=con.prepareStatement("DELETE FROM evento WHERE id_evento=?");
            ps.setString(1, codigo);
            ps.execute();
            verReservaciones second = new verReservaciones();
            second.setVisible(true);
            setVisible(false);   
        } catch(SQLException ex){
            System.err.println("No hay conexión con la base de datos.");
        }
    }//GEN-LAST:event_eliminarEventoActionPerformed
    
    
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(verReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verReservaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTable clientes;
    private javax.swing.JButton eliminarEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton regresar;
    private javax.swing.JTable reservaciones;
    // End of variables declaration//GEN-END:variables
}
