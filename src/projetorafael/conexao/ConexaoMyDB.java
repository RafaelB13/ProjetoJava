/*
 * classe para conectar ao banco de dados
 */
package projetorafael.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fschi
 */
public class ConexaoMyDB {
    
    //atributos static para a conexao e serão final = uma constante
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "123489";
    
    public static Connection getConexao()
    {
        try
        {
            Class.forName(DRIVER);
            
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            throw new RuntimeException("Algo aconteceu de errado com a conexão com o banco, veja: " + ex);
        }
    }
    
    public static void fecharConexao(Connection conn)
    {
        if(conn != null)//se estiver conectado
        {
            try
            {
                conn.close();
            }
            catch(SQLException ex)
            {
                throw new RuntimeException("Algo aconteceu de errado com o fechamento da conexão com o banco, veja: " + ex);
            }
        }
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement stmt)
    {
        if(stmt != null)
        {
            try
            {
                stmt.close();
            }
            catch(SQLException ex)
            {
                throw new RuntimeException("Algo aconteceu de errado com o fechamento da conexão com o banco, veja: " + ex);
            }
        }
        
        fecharConexao(conn);
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement stmt, ResultSet rs)
    {
        if(rs != null)
        {
            try
            {
                rs.close();
            }
            catch(SQLException ex)
            {
                throw new RuntimeException("Algo aconteceu de errado com o fechamento da conexão com o banco, veja: " + ex);
            }
        }
        
        fecharConexao(conn,stmt);
    }
    


}
