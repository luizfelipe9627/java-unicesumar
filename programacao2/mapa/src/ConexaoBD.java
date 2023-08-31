import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
  private static final String url = "jdbc:mysql://localhost:3306/mapa";
  private static final String user = "root";
  private static final String password = "admin";

  private static Connection conexao;

  public static Connection getConexao() {
    try {
      if (conexao == null) {
        conexao = DriverManager.getConnection(url, user, password);
        return conexao;
      } else {
        return conexao;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
