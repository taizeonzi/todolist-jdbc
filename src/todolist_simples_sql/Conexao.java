package todolist_simples_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection Conectar() {
		String CLASSE_DRIVER = "com.mysql.cj.jdbc.Driver";
		String USUARIO = "root";
		String SENHA = "root";
		String URL_SERVIDOR = "jdbc:mysql://localhost:3306/todolist?useSSL=false";
		
		try {
			Class.forName(CLASSE_DRIVER);
			return DriverManager.getConnection(URL_SERVIDOR, USUARIO, SENHA);
		}catch (Exception e) {
			if (e instanceof ClassNotFoundException) {
				System.out.println("Verifique o driver de conexão." + e.getMessage());
			}else {
				System.out.println("Verifique se o servidor está ativo.");
			}
			e.printStackTrace();
			return null;
		}
	}
	public static void desconectar(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println("Não foi possível fechar a conexão.");
				e.printStackTrace();
			}
		}
	}
}