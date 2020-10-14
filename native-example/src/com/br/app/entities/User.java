package com.br.app.entities;

public class User {
	
	private Long id;
	private String userFirstName;
	private String userLastName;
	private String userCpf;
	private String uuid;
	private String passPhrase;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserCpf() {
		return userCpf;
	}
	public void setUserCpf(String userCpf) {
		this.userCpf = userCpf;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPassPhrase() {
		return passPhrase;
	}
	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}
}
