
package trabalhoirahe;

import trabalhoirahe.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import trabalhoirahe.Conexao;


public class EmpresaDAO {
    
        public static void create(Empresa dto) {
            
            Connection conn = Conexao.getConnection();
            String sql = "INSERT INTO Empresa " + "(razaoSocial,endereco,telefone,cnpj) " + "values (?, ?, ?, ?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, dto.getRazaoSocial());
                stmt.setString(2, dto.getEndereco());
                stmt.setString(3, dto.getTelefone());
                stmt.setString(4, dto.getCnpj());
                stmt.execute();
                stmt.close();

            } catch (SQLException ex) {
                
                System.out.print(ex.getMessage());
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro! Por favor verifique os campos e tente inserir novamente.", "DATABASE ERRO", JOptionPane.ERROR_MESSAGE);

            }

        }
        
        
      
}

