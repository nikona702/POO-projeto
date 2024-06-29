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

	public Empregado(String nome, String CPF, Date dataNascimento, String alergia, String problemaMedico,
			String telefone, String email) {
		super(nome, CPF, dataNascimento);
		this.alergias.add(alergia);
		this.problemasMedicos.add(problemaMedico);
		this.telefone.add(telefone);
		this.emailsContato.add(email);
	}

	public void addAlergias(String alergia) {

		
		this.alergias.add(alergia);

	}

	public void addAlergias(List<String> alergias) {

		this.alergias.addAll(alergias);

	}

	public void addProblemasMedicos(String problemaMedico) {

		this.problemasMedicos.add(problemaMedico);

	}

	public void addProblemasMedicos(List<String> problemaMedico) {

		this.problemasMedicos.addAll(problemaMedico);

	}

	public void addTelefones(String telefone) {

		this.telefone.add(telefone);

	}

	public void addEmailsContato(String emailsContato) {

		this.emailsContato.add(emailsContato);

	}

	public void removeAlergias(String alergias) {
		this.alergias.remove(alergias);

	}

	public void removeProblemasMedicos(String problemaMedico) {

		this.problemasMedicos.remove(problemaMedico);

	}

	public void removeTelefone(String telefone) {
		this.telefone.remove(telefone);
	}

	public void removeEmailsContato(String emailContato) {
		this.emailsContato.remove(emailContato);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return "Nome: " + getNome() + ", CPF: " + getCPF() + ", Data de Nascimento: "
					+ sdf.parse(getDataNascimento().toString()) + "\n Lista de telefones: " + getTelefone().toString()
					+ "\n Lista de emails: " + getEmailsContato().toString() + "\n Lista de alergias :"
					+ getAlergias().toString() + "\n Lista de problemasMedicos:" + getProblemasMedicos().toString();

		} catch (Exception e) {
			return "Nome: " + getNome() + ", CPF: " + getCPF() + ", Data de Nascimento: " + getDataNascimento()
					+ "\n Lista de telefones: " + getTelefone().toString() + "\n Lista de emails: "
					+ getEmailsContato().toString() + "\n Lista de alergias :" + getAlergias().toString()
					+ "\n Lista de problemasMedicos:" + getProblemasMedicos().toString();
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
