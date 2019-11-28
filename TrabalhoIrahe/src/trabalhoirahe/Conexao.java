
package trabalhoirahe;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexao {
    private static Connection conn;
    
    public static Connection getConnection() {
        
        if (conn != null) {
            try {
                if (conn.isClosed()) {
                    conn = null;
                }
            } catch (Exception e) {
            }
        }
        if (conn == null) {
             try {
                    String sDriverName = "org.sqlite.JDBC";
                    Class.forName(sDriverName);
                    String sJDBCURL = "jdbc:sqlite:" + getArquivoDoBanco();
                    conn = DriverManager.getConnection(sJDBCURL);
                    System.out.println("Conectado");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados", "ERRO", JOptionPane.ERROR_MESSAGE);

                }

                return conn;
            
        }

        return conn;
        
    }
    
    public static String getArquivoDoBanco(){  
        String caminho = new File("").getAbsolutePath();
        caminho+="\\db.db";
        return caminho;
        
}

    
}