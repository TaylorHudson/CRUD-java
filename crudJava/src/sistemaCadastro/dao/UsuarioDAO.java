package sistemaCadastro.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

import sistemaCadastro.fabrica.FabricaConexao;
import sistemaCadastro.model.Usuario;

public class UsuarioDAO {
	
	public void cadastrar(Usuario usuario) {
		
		String sql = "INSERT INTO usuarios(email, senha, data_cadastro) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = FabricaConexao.conectarComMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getEmail());
			pstm.setString(2, usuario.getSenha());
			pstm.setDate(3, (java.sql.Date) new java.sql.Date(usuario.getData_cadastro().getTime()));
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Usuário cadastrado");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
		
	}

	public void deletar(String email) {
		
		String sql = "DELETE FROM usuarios WHERE email = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = FabricaConexao.conectarComMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, email);
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Usuário deletado");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
	}

	public List<Usuario> listar(){
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM usuarios";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			conn = FabricaConexao.conectarComMySQL();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setData_cadastro(rs.getDate("data_cadastro"));
				
				listaUsuarios.add(usuario);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (rs != null) {
					rs.close();
				}
				
 			} catch (Exception e2) {
				
				e2.printStackTrace();
				
			}
		}
		
		return listaUsuarios;
	}

	public void alterar(Usuario usuario){
		
		String sql = "UPDATE usuarios SET email = ?, senha = ?, data_cadastro = ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = FabricaConexao.conectarComMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getEmail());
			pstm.setString(2, usuario.getSenha());
			pstm.setDate(3, new java.sql.Date(usuario.getData_cadastro().getTime()));
			pstm.setInt(4, usuario.getId());
			
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Alteração feita");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
	}

	
}
