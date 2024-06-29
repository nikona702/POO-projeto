package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Empregado extends Pessoa {
	private List<String> alergias = new ArrayList<>();
	private List<String> problemasMedicos = new ArrayList<>();
	private List<String> telefone = new ArrayList<>();
	private List<String> emailsContato = new ArrayList<>();

	public Empregado(String nome, String CPF, Date dataNascimento, String telefone, String email) {
		super(nome, CPF, dataNascimento);
		this.telefone.add(telefone);
		this.emailsContato.add(email);
	}
	public Empregado(String nome, String CPF, Date dataNascimento, List<String> telefones, List<String> emails) {
		super(nome, CPF, dataNascimento);
		this.telefone.addAll(telefones);
		this.emailsContato.addAll(emails);
	}
	public Empregado(String nome, String CPF, Date dataNascimento, String alergia, String problemaMedico, String telefone, String email){
		super(nome, CPF, dataNascimento);
		this.alergias.add(alergia);
		this.problemasMedicos.add(problemaMedico);
		this.telefone.add(telefone);
		this.emailsContato.add(email);
	}
	

	public void addAlergias(List<String> alergias) {
		for (String A : alergias) {
			this.alergias.add(A);

		}
	}

	public void addProblemasMedicos(List<String> problemasMedicos) {
		for (String B : problemasMedicos) {
			this.problemasMedicos.add(B);
		}

	}

	public void addTelefones(List<String> telefones) {
		for (String C : telefones) {
			this.problemasMedicos.add(C);
		}
	}

	public void addEmailsContato(List<String> emailsContato) {
		for (String D : emailsContato) {
			this.emailsContato.add(D);
		}
	}

	public void removeAlergias(List<String> alergias) {
		for (String A : alergias) {
			this.alergias.remove(A);

		}
	}

	public void removeProblemasMedicos(List<String> problemasMedicos) {
		for (String B : problemasMedicos) {
			this.problemasMedicos.remove(B);
		}

	}

	public void removeTelefones(List<String> telefones) {
		for (String C : telefones) {
			this.problemasMedicos.remove(C);
		}
	}

	public void removeEmailsContato(List<String> emailsContato) {
		for (String D : emailsContato) {
			this.emailsContato.remove(D);
		}
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			return "Nome: "+getNome()+", CPF: "+getCPF()+ ", Data de Nascimento: "+sdf.parse(getDataNascimento().toString())
			+"\n Lista de telefones: "+getTelefone().toString()
			+"\n Lista de emails: "+getEmailsContato().toString()
			+"\n Lista de alergias :"+ getAlergias().toString()
			+"\n Lista de problemasMedicos:"+ getProblemasMedicos().toString();
			
		} catch(Exception e){
			return "Nome: "+getNome()+", CPF: "+getCPF()+ ", Data de Nascimento: "+getDataNascimento()
			+"\n Lista de telefones: "+getTelefone().toString()
			+"\n Lista de emails: "+getEmailsContato().toString()
			+"\n Lista de alergias :"+ getAlergias().toString()
			+"\n Lista de problemasMedicos:"+ getProblemasMedicos().toString();
		}	
	}

	public List<String> getAlergias() {
		return alergias;
	}

	public List<String> getProblemasMedicos() {
		return problemasMedicos;
	}

	public List<String> getTelefone() {
		return telefone;
	}

	public List<String> getEmailsContato() {
		return emailsContato;
	}

}
