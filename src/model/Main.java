package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		Empresa emp = Empresa.getInstance();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("#######################");
			System.out.println("Cadastrar Empregado(a) (1)");
			System.out.println("Consultar Empregado(a) (2)");
			System.out.println("#######################");
			System.out.print("\n\n\n\n\nEscolha uma opção: ");
			int input=10; // Valor aleatório para inicialização 	
			try{
				input = sc.nextInt();	
			} catch(Exception e){
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
				for(int i=0; i<numTelefones; i++){
					System.out.print("Insira o "+(i+1)+"° número: ");
					telefones.add(sc.next());
					sc.nextLine();
				}
				System.out.print("Insira a quantidade de emails: ");
				int numEmails = sc.nextInt();
				List<String> emails = new ArrayList<>();
				for(int i=0; i<numEmails; i++){
					System.out.print("Insira o "+(i+1)+"° email: ");
					emails.add(sc.next());
					sc.nextLine();
				}
				System.out.print("O empregado possui alguma alergia? (Sim/Não)");
				String alergia = sc.next();
				alergia = alergia.toUpperCase();
				sc.nextLine();
				List<String>  alergias = new ArrayList<>();
				switch(alergia){
					case "SIM":
						System.out.print("Quantas alergias?");
						int numAlergia = sc.nextInt();						
						for(int i=0; i<numAlergia; i++){
							System.out.print("Insira o "+(i+1)+"° alergia: ");
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
				List<String>  problemasMedicos = new ArrayList<>();
				switch(problemaMedico){
					case "SIM":
						System.out.print("Quantos problemas médicos?");
						int numProblemaMedico = sc.nextInt();						
						for(int i=0; i<numProblemaMedico; i++){
							System.out.print("Insira o "+(i+1)+"° problemaMedico: ");
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
				// telefones, emails, (alergias e problemasMedicos) -> não necessariamente passadas!
				SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dataN = sdf.parse(dataNascimento);
				Empregado e1 = new Empregado(nome, CPF, dataN, telefones, emails);
				if (alergias.size()!=0){
					e1.addAlergias(alergias);
				}
				if (problemasMedicos.size()!=0){
					e1.addAlergias(problemasMedicos);
				}
				emp.addEmpregado(e1);
				System.out.print("############################# ");
				e1.toString();
				System.out.print("############################# \n[");
				break;
			case 2:
				System.out.print("Diga o nome do empregado a ser consultado: ");
				String nomeBusca = sc.next();
				sc.nextLine();
				System.out.print( emp.busca(nomeBusca));
				if (emp.busca(nomeBusca)!=null){
					emp.busca(nomeBusca).toString();
				} else{
					System.out.print("Não encontrado!");
				}
				System.out.print("\nO que fazer com esse funcionário? (Update/Delete/Nada)");
				String act = sc.next();
				

				break;
			default:
				System.out.println("Escolha uma opção válida!\n\n\n\n\n");
				break;

			}

		}

	}
}