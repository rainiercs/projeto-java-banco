
package com.mycompany.com.senai.teste;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

public class cliente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(cliente.class.getName());
    private static final String URL = "jdbc:mariadb://localhost:3306/ricteste";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "senai2025";

    public cliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtCPF = new javax.swing.JTextField();
        txtNOME = new javax.swing.JTextField();
        txtFONE = new javax.swing.JTextField();
        txtDT_NASC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BT_1 = new javax.swing.JButton();
        BT_2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        jLabel1.setText("CPF");

        jLabel2.setText("NOME");

        jLabel3.setText("TELEFONE");

        jLabel4.setText("DATA DE NASCIMENTO");

        BT_1.setText("NEXT");
        BT_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_1ActionPerformed(evt);
            }
        });

        BT_2.setText("VOLTAR");
        BT_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFONE, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDT_NASC, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCPF)
                            .addComponent(txtNOME, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))))
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BT_2)
                .addGap(57, 57, 57)
                .addComponent(BT_1)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(txtFONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDT_NASC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_1)
                    .addComponent(BT_2))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>                        

    public void limparCampos(){
        txtCPF.setText("");
        txtNOME.setText("");
        txtFONE.setText("");
        txtDT_NASC.setText("");
        
    }
    public void inserirDados(String cpf, String nome, String fone, String datanasc){
        String sql = "INSERT INTO clientes(cpf,nome,telefone,data_nascimento) VALUES(?,?,?,?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
             pstmt.setString(1, cpf);
             pstmt.setString(2, nome);
             pstmt.setString(3, fone);
             pstmt.setString(4, datanasc);
           
            int affectedRows = pstmt.executeUpdate();
           
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long id = generatedKeys.getLong(1);
                        System.out.println("User inserted with ID: " + id);
                    }
                }
            }
           
        } catch (SQLException e) {
            System.err.println("Error inserting user: " + e.getMessage());
        }
    }

                
    
    private void BT_1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        String nome = txtNOME.getText();
        String cpf = txtCPF.getText();
        String dataNasc = txtDT_NASC.getText();
        String fone = txtFONE.getText();
        if (nome.isBlank()||cpf.isBlank()||dataNasc.isBlank()||fone.isBlank()) {
            JOptionPane.showMessageDialog(null,"campos obrigatorios tem que ser preenchidos ");
        }else{
            inserirDados(cpf, nome, fone, dataNasc);
            limparCampos();
        }
       
    }                                    

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void BT_2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
    }                                    

    public static void main(String args[]) {
        
        cliente app = new cliente();
        
        app.testConnection();

        java.awt.EventQueue.invokeLater(() -> new cliente().setVisible(true));
    }
    public void testConnection() {
        try (Connection connection = getConnection()) {
            System.out.println("Connected to MariaDB database successfully!");
           
            // Get database metadata
            String sql = "SELECT VERSION(), DATABASE(), USER()";
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
               
                if (rs.next()) {
                    System.out.println("MariaDB Version: " + rs.getString(1));
                    System.out.println("Current Database: " + rs.getString(2));
                    System.out.println("Current User: " + rs.getString(3));
                }
            }
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
//    public void selectAllusers(){
//      String sql ="select id, name, email, created_at from users";
//        
//        try (Connection conn = getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql);
//             ResultSet rs = pstmt.executeQuery()
//    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton BT_1;
    private javax.swing.JButton BT_2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtDT_NASC;
    private javax.swing.JTextField txtFONE;
    private javax.swing.JTextField txtNOME;
    // End of variables declaration                   

}
