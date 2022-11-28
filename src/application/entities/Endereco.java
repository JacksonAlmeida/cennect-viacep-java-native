package application.entities;

import java.io.Serializable;

public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String cep;
	private String logradouro;
	private String bairro;
	private String home;
	
	public Endereco() {
		
	}

	public Endereco(String cep, String logradouro, String bairro, String home) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.home = home;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", home="
				+ home + "]";
	}

}
