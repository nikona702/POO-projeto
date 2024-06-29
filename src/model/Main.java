package model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException, InterruptedException, IOException {
		Empresa emp = Empresa.getInstance();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("#######################");
			System.out.println("Cadastrar Empregado(a) (1)");
			System.out.println("Consultar Empregado(a) (2)");
			System.out.println("#######################");
			System.out.print("\n\n\n\n\nEscolha uma opção: ");
			int input = 10; // Valor aleatório para inicialização
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				System.out.print("OPÇÃO INVÁLIDA!!!");
				System.exit(0);
			}
			switch (input) {
			case 1:
				System.out.print("Insira o nome do(a) empregado(a): ");
				String nome = sc.next();
				sc.nextLine();
				System.out.print("Insira o CPF:");
				String CPF = sc.next();
				sc.nextLine();
				System.out.print("Insira a Data de Nascimento: ");
				String dataNascimento = sc.next();
				sc.nextLine();
				System.out.print("Insira a quantidade de telefones: ");
				int numTelefones = sc.nextInt();
				List<String> telefones = new ArrayList<>();
				for (int i = 0; i < numTelefones; i++) {
					System.out.print("Insira o " + (i + 1) + "° número: ");
					telefones.add(sc.next());
					sc.nextLine();
				}
				System.out.print("Insira a quantidade de emails: ");
				int numEmails = sc.nextInt();
				List<String> emails = new ArrayList<>();
				for (int i = 0; i < numEmails; i++) {
					System.out.print("Insira o " + (i + 1) + "° email: ");
					emails.add(sc.next());
					sc.nextLine();
				}
				System.out.print("O empregado possui alguma alergia? (Sim/Não)");
				String alergia = sc.next();
				alergia = alergia.toUpperCase();
				sc.nextLine();
				List<String> alergias = new ArrayList<>();
				switch (alergia) {
				case "SIM":
					System.out.print("Quantas alergias?");
					int numAlergia = sc.nextInt();
					for (int i = 0; i < numAlergia; i++) {
						System.out.print("Insira o " + (i + 1) + "° alergia: ");
						alergias.add(sc.next());
						sc.nextLine();
					}
					break;
				case "NÃO":
					System.out.print("OK! Prossiga para o próximo passo.  :)");
					break;
				default:
					System.out.print("Selecione uma opção válida!");
					System.exit(0);
				}
				System.out.print("O empregado possui algum problema médico? (Sim/Não)");
				String problemaMedico = sc.next();

				sc.nextLine();
				problemaMedico = problemaMedico.toUpperCase();
				List<String> problemasMedicos = new ArrayList<>();
				switch (problemaMedico) {
				case "SIM":
					System.out.print("Quantos problemas médicos?");
					int numProblemaMedico = sc.nextInt();
					for (int i = 0; i < numProblemaMedico; i++) {
						System.out.print("Insira o " + (i + 1) + "° problemaMedico: ");
						problemasMedicos.add(sc.next());
						sc.nextLine();
					}
					break;
				case "NÃO":
					System.out.print("OK! Prossiga para o próximo passo.  :)");
					break;
				default:
					System.out.print("Selecione uma opção válida!");
					System.exit(0);
				}
				// Cadastro efetivo das informações!
				// nome, CPF, dataNascimento -> Pessoa
				// telefones, emails, (alergias e problemasMedicos) -> não necessariamente
				// passadas!
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dataN = sdf.parse(dataNascimento);
				Empregado e1 = new Empregado(nome, CPF, dataN, telefones, emails);
				if (alergias.size() != 0) {
					e1.addAlergias(alergias);
				}
				if (problemasMedicos.size() != 0) {
					e1.addProblemasMedicos(problemasMedicos);
				}
				emp.addEmpregado(e1);
				System.out.println("############################# ");
				System.out.println("DADOS DO EMPREGADO:");
				System.out.println(e1.toString());
				System.out.println("############################# \n");
				break;
			case 2:
				System.out.print("Diga o nome do empregado a ser consultado: ");
				String nomeBusca = sc.next();
				sc.nextLine();
				while (emp.busca(nomeBusca) == null) {
					System.out.println("Não encontrado!");
					System.out.print("Insira novamente: ");
					nomeBusca = sc.next();
					sc.nextLine();
				}
				System.out.println("############################# ");
				System.out.println("DADOS DO EMPREGADO:");
				System.out.println(emp.busca(nomeBusca).toString());
				System.out.println("############################# \n");

				System.out.print("\nO que fazer com esse funcionário? (Update/Delete/Nada): ");
				String act = sc.next();
				sc.nextLine();
				act = act.toUpperCase();
				switch (act) {
				case "UPDATE":
					System.out.println("O que será atualizado?");
					System.out.println("Opções: Adicionar telefone | Remover telefone");
					System.out.println("Adicionar email | Remover email");
					System.out.println("Adicionar alergia | Remover alergia");
					System.out.println("Adicionar problema médico | Remover problema médico");
					String opcao = sc.nextLine();
					System.out.print(opcao);
					sc.nextLine();
					opcao = opcao.toUpperCase();
					switch (opcao) {
					case "ADICIONAR TELEFONE":
						System.out.print("Digite o novo número: ");
						String novoNum = sc.next();
						sc.nextLine();
						emp.busca(nomeBusca).addTelefones(novoNum);
						System.out.println("Atualizado!");
						System.out.println("###################################");
						System.out.println(emp.busca(nomeBusca).toString());
						System.out.println("###################################");
						break;
					case "REMOVER TELEFONE":
						System.out.print("Digite o número a ser removido: ");
						String numRemov = sc.next();

						sc.nextLine();
						emp.busca(nomeBusca).removeTelefone(numRemov);
						System.out.println("Atualizado!");
						System.out.println("###################################");
						System.out.println(emp.busca(nomeBusca).toString());
						System.out.println("###################################");
						break;
					case "ADICIONAR EMAIL":
						System.out.print("Digite o novo email: ");
						String novoEmail = sc.next();
						sc.nextLine();
						emp.busca(nomeBusca).addEmailsContato(novoEmail);
						System.out.println("Atualizado!");
						System.out.println("###################################");
						System.out.println(emp.busca(nomeBusca).toString());
						System.out.println("###################################");
						break;
					case "REMOVER EMAIL":
						System.out.print("Digite o email a ser removido: ");
						String emailRemov = sc.next();
						sc.nextLine();
						emp.busca(nomeBusca).removeEmailsContato(emailRemov);
						System.out.println("Atualizado!");
						System.out.println("###################################");
						System.out.println(emp.busca(nomeBusca).toString());
						System.out.println("###################################");
						break;
					case "ADICIONAR ALERGIA":
						System.out.print("Digite a alergia a ser adicionada: ");
						String novaAlergia = sc.next();
						sc.nextLine();
						emp.busca(nomeBusca).addAlergias(novaAlergia);
						System.out.println("Atualizado!");
						System.out.println("###################################");
						System.out.println(emp.busca(nomeBusca).toString());
						System.out.println("###################################");
						break;
					case "REMOVER ALERGIA":
						System.out.print("Digite a alergia a ser adicionada: ");
						String alergiaRemov = sc.next();
						sc.nextLine();
						emp.busca(nomeBusca).removeAlergias(alergiaRemov);
						System.out.println("Atualizado!");
						System.out.println("###################################");
						System.out.println(emp.busca(nomeBusca).toString());
						System.out.println("###################################");
						break;
					case "ADICIONAR PROBLEMA MÉDICO":
						System.out.print("Digite problema médico: ");
						String novoProb = sc.next();
						sc.nextLine();
						emp.busca(nomeBusca).addProblemasMedicos(novoProb);
						System.out.println("Atualizado!");
						System.out.println("###################################");
						System.out.println(emp.busca(nomeBusca).toString());
						System.out.println("###################################");
						break;
					case "REMOVER PROBLEMA MÉDICO":
						System.out.print("Digite o problema a ser removido: ");
						String removProb = sc.next();
						sc.nextLine();
						emp.busca(nomeBusca).removeProblemasMedicos(removProb);
						System.out.println("Atualizado!");
						System.out.println("###################################");
						System.out.println(emp.busca(nomeBusca).toString());
						System.out.println("###################################");
						break;
					default:
						System.out.print("Selecione uma opção válida!");
						System.exit(0);
					}
					break;
				case "DELETE":
					System.out.println("Certo! Deletando funcionário da base de dados.");
					emp.removeEmpregado(emp.busca(nomeBusca));
					System.out.println("Removido! Voltando a tela inicial.");
					break;
				case "NADA":
					break;
				default:
					System.out.print("Selecione uma opção válida!");
					System.exit(0);
				}

				break;
			default:
				System.out.println("Escolha uma opção válida!\n\n\n\n\n");
				break;

			}

		}

	}
}