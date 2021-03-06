package sistemaCadastro.model;

import java.util.Date;

public class Usuario {

	private int id;
	private String email;
	private String senha;
	private Date data_cadastro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data) {
		this.data_cadastro = data;
	}
}
