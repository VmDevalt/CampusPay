package com.churrasqueiro.entities;

public class Usuario {
	int id;
	String login;
	String senhaHash;
	String tipo;
	
	public Usuario(int id, String login, String senhaHash, String tipo) {
		this.id = id;
		this.login = login;
		this.senhaHash = senhaHash;
		this.tipo = tipo;
	}
	
	int getId() {
		return id;
	}
	
	void setId(int id) {
		this.id = id;
	}
	
	String getLogin() {
		return login;
	}
	
	void setLogin(String login) {
		this.login = login;
	}
	
	String getSenhaHash() {
		return senhaHash;
	}
	
	void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}
	
	String getTipo() {
		return tipo;
	}
	
	void setTipo(String tipo) {
		this.tipo = tipo;
	}
}




