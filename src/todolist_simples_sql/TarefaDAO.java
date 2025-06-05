package todolist_simples_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

	public void inserir(Tarefa tarefa) {
		String sql = "INSERT INTO tarefas (descricao, concluida) VALUES (?, ?)";
		
		try (Connection conn = Conexao.Conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isConcluida());
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();	
		}
	}
	public List<Tarefa> listar() {
		List<Tarefa> lista = new ArrayList<>();
		String sql = "SELECT * FROM tarefas";
		try (Connection conn = Conexao.Conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				Tarefa t = new Tarefa();
				t.setId(rs.getInt("id"));
				t.setDescricao(rs.getString("descricao"));
				t.setConcluida(rs.getBoolean("concluida"));
				lista.add(t);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Tarefa buscarPorId(int id) {
		String sql = "SELECT * FROM tarefas WHERE id = ?";
		try (Connection conn = Conexao.Conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Tarefa t = new Tarefa();
				t.setId(rs.getInt("id"));
				t.setDescricao(rs.getString("descricao"));
				t.setConcluida(rs.getBoolean("concluida"));
				return t;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void atualizar(Tarefa tarefa) {
		String sql = "UPDATE tarefas SET concluida = ? WHERE id = ?";
		try (Connection conn = Conexao.Conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setBoolean(1, tarefa.isConcluida());
			stmt.setInt(2, tarefa.getId());
			stmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deletar(int id) {
		String sql = "DELETE FROM tarefas WHERE id = ?";
		try (Connection conn = Conexao.Conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	