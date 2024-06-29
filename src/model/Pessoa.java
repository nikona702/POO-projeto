package model;

import java.util.Date;

public class Pessoa { 
	private String nome;
	private String CPF;
	private Date dataNascimento;
	public Pessoa (String nome, String CPF, Date dataNascimento) {
		this.nome = nome;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	//public abstract String toString(); 
}
