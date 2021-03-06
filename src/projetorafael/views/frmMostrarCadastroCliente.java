/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorafael.views;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import projetorafael.conexao.ConexaoMyDB;
import projetorafael.model.CadastroCliente;

/**
 *
 * @author Rafael
 */
public class frmMostrarCadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form frmMostrarCadastroCliente
     */
    public frmMostrarCadastroCliente() {
        initComponents();
        
        //modificar header
        JTableHeader jth = jTableCliente.getTableHeader();
        jth.setBackground(new Color(51,51,51));
        jth.setForeground(Color.WHITE);
        jth.setFont(new Font("Century Ghotic", Font.BOLD, 18));
        jTableCliente.setRowHeight(24);
    }
    
     public Connection conn = null;
    
    public void preencherJtable(String sql){
    
       conn = ConexaoMyDB.getConexao();
       
        try {
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) jTableCliente.getModel();
            model.setNumRows(0);
            
            DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            
            while (rs.next()) {                
                model.addRow(new Object[]{
                    rs.getString("codigo_cliente"),
                    rs.getString("nome"), 
                    rs.getString("sobrenome"),
                    rs.getString("cpf"),
                    data.format(rs.getDate("data_nascimento")),
                    rs.getInt("idade"),
                    rs.getString("sexo"),
                    rs.getString("id_tb_cadastro")
                        
                });
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Não foi possivel obter os dados do banco. ERRO: " + e);
        }
        
        ConexaoMyDB.fecharConexao(conn);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisarPorNome = new javax.swing.JTextField();
        txtPesquisarPorCpf = new javax.swing.JFormattedTextField();
        btnAtualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        txtNControle = new javax.swing.JTextField();
        txtNomeControle = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 700));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMaximumSize(new java.awt.Dimension(1034, 763));
        jPanel1.setMinimumSize(new java.awt.Dimension(1034, 763));

        jTableCliente.setBackground(new java.awt.Color(51, 51, 51));
        jTableCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTableCliente.setForeground(new java.awt.Color(255, 255, 255));
        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Cliente", "Nome", "Sobrenome", "CPF", "Data Nascimento", "Idade", "Sexo", "Numero de Controle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCliente);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Pesquisar por Nome");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Pesquisa por CPF");

        txtPesquisarPorNome.setBackground(new java.awt.Color(102, 102, 102));
        txtPesquisarPorNome.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPesquisarPorNome.setForeground(new java.awt.Color(255, 255, 255));
        txtPesquisarPorNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisarPorNomeKeyTyped(evt);
            }
        });

        txtPesquisarPorCpf.setBackground(new java.awt.Color(102, 102, 102));
        txtPesquisarPorCpf.setForeground(new java.awt.Color(255, 255, 255));
        txtPesquisarPorCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtPesquisarPorCpf.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPesquisarPorCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarPorCpfActionPerformed(evt);
            }
        });
        txtPesquisarPorCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisarPorCpfKeyTyped(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(51, 51, 255));
        btnAtualizar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.setBorder(null);
        btnAtualizar.setFocusPainted(false);
        btnAtualizar.setPreferredSize(new java.awt.Dimension(77, 23));
        btnAtualizar.setRequestFocusEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnDeletar.setBackground(new java.awt.Color(255, 51, 51));
        btnDeletar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnDeletar.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletar.setText("DELETAR");
        btnDeletar.setBorder(null);
        btnDeletar.setFocusPainted(false);
        btnDeletar.setMaximumSize(new java.awt.Dimension(77, 23));
        btnDeletar.setMinimumSize(new java.awt.Dimension(77, 23));
        btnDeletar.setRequestFocusEnabled(false);

        txtNControle.setBackground(new java.awt.Color(102, 102, 102));
        txtNControle.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNControle.setForeground(new java.awt.Color(255, 255, 255));
        txtNControle.setMaximumSize(new java.awt.Dimension(6, 25));

        txtNomeControle.setBackground(new java.awt.Color(102, 102, 102));
        txtNomeControle.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNomeControle.setForeground(new java.awt.Color(255, 255, 255));
        txtNomeControle.setMaximumSize(new java.awt.Dimension(6, 25));
        txtNomeControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeControleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPesquisarPorCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addComponent(txtPesquisarPorNome, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
                .addGap(138, 138, 138)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNControle, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeControle, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisarPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtNControle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNomeControle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesquisarPorCpf, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String sql = "SELECT * FROM tb_cadastro ORDER BY id_tb_cadastro ASC";
        
        preencherJtable(sql);
    }//GEN-LAST:event_formWindowOpened

    private void txtPesquisarPorNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarPorNomeKeyTyped
        String sql = "SELECT * FROM tb_cadastro WHERE nome LIKE '%" + txtPesquisarPorNome.getText() + "%' ORDER BY id_tb_cadastro DESC";
        
        
        this.preencherJtable(sql);
    }//GEN-LAST:event_txtPesquisarPorNomeKeyTyped

    private void txtPesquisarPorCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarPorCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarPorCpfActionPerformed

    private void txtPesquisarPorCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarPorCpfKeyTyped
        String sql = "SELECT * FROM tb_cadastro WHERE cpf LIKE '%" + txtPesquisarPorCpf.getText() + "%'";
        this.preencherJtable(sql);
    }//GEN-LAST:event_txtPesquisarPorCpfKeyTyped

    private void txtNomeControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeControleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeControleActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        //Abrir a Tela frmAtualizar
        if (txtNControle.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Não Foi Selecionado Linha para atualizar");
        }else {
            frmAtualizarCadastro frmat = new frmAtualizarCadastro();
            frmat.setVisible(true);
            CadastroCliente.id_tb_cadastro = Integer.parseInt(txtNControle.getText());
        }
        
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void jTableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClienteMouseClicked
        // Evento CLicque Mouse
        int linha = jTableCliente.getSelectedRow();
        txtNControle.setText(jTableCliente.getValueAt(linha, 7).toString());
        txtNomeControle.setText(jTableCliente.getValueAt(linha, 1).toString());
        
    }//GEN-LAST:event_jTableClienteMouseClicked

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
            java.util.logging.Logger.getLogger(frmMostrarCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMostrarCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMostrarCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMostrarCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMostrarCadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTextField txtNControle;
    private javax.swing.JTextField txtNomeControle;
    private javax.swing.JFormattedTextField txtPesquisarPorCpf;
    private javax.swing.JTextField txtPesquisarPorNome;
    // End of variables declaration//GEN-END:variables
}
