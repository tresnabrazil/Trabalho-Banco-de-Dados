
package trabalhoirahe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;


public class AlunoDAO {
    
        public static void create(Aluno dto) {
            
            Connection conn = Conexao.getConnection();
            String sql = "INSERT INTO aluno " + "(nome,nascimento,curso,telefone,turno,cpf,rg,sexo,status,cidade) " + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, dto.getNome());
                stmt.setString(2, dto.getNascimento());
                stmt.setString(3, dto.getCurso());
                stmt.setString(4, dto.getTelefone());
                stmt.setString(5, dto.getTurno());
                stmt.setString(6, dto.getCpf());
                stmt.setString(7, dto.getRg());
                stmt.setString(8, dto.getSexo());
                stmt.setString(9, dto.getStatus());
                stmt.setString(10, dto.getCidade());
                stmt.execute();
                stmt.close();

            } catch (SQLException ex) {
                
                System.out.print(ex.getMessage());
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro! Por favor verifique os campos e tente inserir novamente.", "DATABASE ERRO", JOptionPane.ERROR_MESSAGE);

            }

        }
        
        public List<Aluno> lista(){
        
            List<Aluno> resultados = new ArrayList<Aluno>();
            Connection conn = Conexao.getConnection();
            String sql = "select * from aluno";
            
            try{
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                
                    Aluno a = new Aluno();
                    a.setId(rs.getInt("id"));
                    a.setNome(rs.getString("nome"));
                    a.setNascimento(rs.getString("nascimento"));
                    a.setCurso(rs.getString("curso"));
                    a.setTelefone(rs.getString("telefone"));
                    a.setTurno(rs.getString("turno"));
                    a.setCpf(rs.getString("cpf"));
                    a.setRg(rs.getString("rg"));
                    a.setSexo(rs.getString("sexo"));
                    a.setStatus(rs.getString("status"));
                    a.setCidade(rs.getString("cidade"));
                    
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

