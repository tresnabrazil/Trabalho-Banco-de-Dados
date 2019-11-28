
package trabalhoirahe.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import trabalhoirahe.Conexao;


public class FuncionarioDAO {
    
        public static void create(Funcionario funcionario) {
            
            Connection conn = Conexao.getConnection();
            String sql = "INSERT INTO funcionarios " + "(nome,cpf,dataNascimento,idEmpresa,situacao) " + "values (?,?,?,?,?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getCpf());
                stmt.setString(3, funcionario.getDataNascimento());
                stmt.setString(4, funcionario.getSituacao());
                stmt.execute();
                stmt.close();

            } catch (SQLException ex) {
                
                System.out.print(ex.getMessage());
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro! Por favor verifique os campos e tente inserir novamente.", "DATABASE ERRO", JOptionPane.ERROR_MESSAGE);

            }

        }
        
//         public List<?> listaEmpresas(){
//        
//            List<?> empresas = new ArrayList<>();
//            Connection conn = Conexao.getConnection();
//            String sql = "select * from empresa";
//            
//            try{
//                
//                PreparedStatement stmt = conn.prepareStatement(sql);
//                ResultSet rs = stmt.executeQuery();
//                
//                while(rs.next()){
//                
//                    Empresa empresa = new Empresa();
//                    empresa.setId(rs.getInt("id"));
//                    empresa.setNome(rs.getString("nome"));   
//                    empresas.add(empresa);
//                }
//                
//            
//            } catch (SQLException ex) {
//                
//                JOptionPane.showMessageDialog(null, "Erro! Por favor verificar o codigo antes de inserir novamente.", "DATABASE ERROR", JOptionPane.ERROR_MESSAGE);
//            }
//            return empresas;
//         }
        
        public List<Funcionario> lista(){
        
            List<Funcionario> resultados = new ArrayList<Funcionario>();
            Connection conn = Conexao.getConnection();
            String sql = "select * from funcionarios";
            
            try{
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                
                    Funcionario a = new Funcionario();
                    a.setId(rs.getInt("id"));
                    a.setNome(rs.getString("nome"));   
                    resultados.add(a);
                }
                
            
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Erro! Por favor verificar o codigo antes de inserir novamente.", "DATABASE ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            return resultados;
            
        } 
        
        public ResultSet listaPorCidade(String cidade){
        
            ResultSet rs = null;
            Connection conn = Conexao.getConnection();
            String sql = "select nome as 'Nome', curso as 'Curso', turno as 'Turno', cidade as 'Cidade' from aluno where cidade = ?";
            
            try{
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, cidade);
                rs = stmt.executeQuery();             
                return rs;
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "listaPorCidade error: " + ex.getMessage(), "DATABASE ERROR", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
            
            return rs;        
        } 
        
        public ResultSet listaPorStatus(String status){
        
            ResultSet rs = null;
            Connection conn = Conexao.getConnection();
            String sql = "select nome as 'Nome', curso as 'Curso', turno as 'Turno ', status as 'Status' from aluno where status = ?";                
            
            try{
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, status);                
                rs = stmt.executeQuery();                
                return rs;
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "listaPorStatus error: " + ex.getMessage(), "DATABASE ERROR", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
            
            return rs;            
        }
        
        public ResultSet listaPorCurso(String curso){
        
            ResultSet rs = null;
            Connection conn = Conexao.getConnection();
            String sql = "select nome as 'Nome', curso as 'Curso', turno as 'Turno', cidade as 'Cidade' from aluno where curso = ?";                
            
            try{
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, curso);                
                rs = stmt.executeQuery();                
                return rs;
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "listaPorCurso error: " + ex.getMessage(), "DATABASE ERROR", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
            
            return rs;            
        }
            
}

