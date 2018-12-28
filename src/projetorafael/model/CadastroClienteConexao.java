/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorafael.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projetorafael.conexao.ConexaoMyDB;
import projetorafael.views.frmTelaPrincipal;

/**
 *
 * @author Rafael
 */
public class CadastroClienteConexao {
     
    public void InserirCliente()
    {
         
        Connection conn = null;
        
        String sql = "INSERT INTO tb_cadastro (nome, sobrenome, idade, data_nascimento, sexo, cpf, codigo_cliente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        conn = ConexaoMyDB.getConexao();//conectar ao banco de dados
        
        PreparedStatement stmt = null;
       
        
        try
        {
            
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, CadastroCliente.nome_cliente);
            stmt.setString(2, CadastroCliente.sobrenome_cliente);
            stmt.setInt(3, CadastroCliente.idade_cliente);
            stmt.setDate(4, CadastroCliente.data_nascimento_cliente);
            stmt.setString(5, CadastroCliente.sexo_cliente);
            stmt.setString(6, CadastroCliente.cpf_cliente);
            stmt.setString(7, CadastroCliente.codigo_cliente);
            
            stmt.executeUpdate();
            
            System.out.println("Cliente Inserido");
            
            
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
    
    public void verificarUsuario(){
        
         
        Connection conn = null;
        
        String sql = "SELECT * FROM tb_login WHERE usuario = '" + Login.usuario + "'" ;
        
        conn = ConexaoMyDB.getConexao();//conectar ao banco de dados
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
       
        
        try
        {
            
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            rs.next();
            
            String usuario1 = rs.getString("usuario");
            String senha1 = rs.getString("senha");
            
            System.out.println("Verificado");
            
            
            
            if(usuario1.equals(Login.usuario)   && senha1.equals( Login.senha) ){
                
                frmTelaPrincipal tp = new frmTelaPrincipal();
                tp.setVisible(true);
            }else {
                
                JOptionPane.showMessageDialog(null, "Usuario Negado !!!");
            }
            
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar no banco de dados. Erro: " + ex);
        }
        finally
        {
            ConexaoMyDB.fecharConexao(conn, stmt);
        }
    }
 
}
