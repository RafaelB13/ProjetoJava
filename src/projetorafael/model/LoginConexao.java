/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorafael.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetorafael.conexao.ConexaoMyDB;

/**
 *
 * @author Rafael
 */
public class LoginConexao {
    
    public void InserirUsuario()
    {
         
        Connection conn = null;
        
        String sql = "INSERT INTO tb_login (usuario, senha) VALUES (?, ?)";
        
        conn = ConexaoMyDB.getConexao();//conectar ao banco de dados
        
        PreparedStatement stmt = null;
       
        
        try
        {
            
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, Login.usuario);
            stmt.setString(2, Login.senha);
            
            stmt.executeUpdate();
            
            System.out.println("Conectado");
            
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados. Erro: " + ex);
        }
        finally
        {
            ConexaoMyDB.fecharConexao(conn, stmt);
        }
    }
    
}