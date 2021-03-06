package sistemaCadastro.simulacaoview;

import java.util.Date;

import sistemaCadastro.dao.UsuarioDAO;
import sistemaCadastro.model.Usuario;

public class Main {
	
	public static void main(String[] args) {
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		// CREATE
		Usuario usuario = new Usuario();
		usuario.setEmail("adminteste@gmail.com");
		usuario.setSenha("12383545&*%");
		usuario.setData_cadastro(new Date());
		
		usuariodao.cadastrar(usuario);
		
		// READ
		for (Usuario user : usuariodao.listar()) {
			
			System.out.println("\nNome de usuario: "+user.getEmail());
			System.out.println("Senha: "+user.getSenha());
			System.out.println("Data de cadastro: "+user.getData_cadastro());} 
		
		// UPDATE 
		Usuario usuario2 = new Usuario();
		usuario2.setEmail("adminsuper@gmail.com");
		usuario2.setSenha("12345&*%");
		usuario2.setData_cadastro(new Date());
		usuario2.setId(2);
		
		usuariodao.alterar(usuario2);
		
		// DELETE
		usuariodao.deletar("admin@gmail.com");  
	}
}

