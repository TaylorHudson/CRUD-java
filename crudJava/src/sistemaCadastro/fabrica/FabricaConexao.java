package sistemaCadastro.fabrica;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
		
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306/sistemalogin";
	
	public static Connection conectarComMySQL() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return connection;

	}
}
