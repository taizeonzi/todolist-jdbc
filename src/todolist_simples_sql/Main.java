package todolist_simples_sql;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TarefaDAO dao = new TarefaDAO();
		int opcao = -1;
		
		while (opcao != 0) {
			System.out.println("\n************* MENU *************");
			System.out.println("1 - Adicionar tarefa");
			System.out.println("2 - Listar tarefas");
			System.out.println("3 - Mostrar status da tarefa");
			System.out.println("4 - Atualizar status da tarefa");
			System.out.println("5 - Excluir tarefa");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				Tarefa nova = new Tarefa();
				System.out.print("Descreva a tarefa: ");
				nova.setDescricao(sc.nextLine());
				nova.setConcluida(false);
				
				dao.inserir(nova);
				System.out.println("Tarefa cadastrada com sucesso!");
				System.out.println();
				break;
				
			case 2:
				List<Tarefa> lista = dao.listar();
				
				if (lista.isEmpty()) {
					System.out.println("Nenhuma tarefa cadastrada.");
				}else {
					System.out.println("\n--- Lista de Tarefas ---");
					for (int i = 0; i < lista.size(); i++) {
						Tarefa t = lista.get(i);
						System.out.println(
								(i + 1) + " - Tarefa: " + t.getDescricao() + " - Status da tarefa: " + (t.isConcluida() ? "Concluída" : "Não concluída"));
					}
				
				}
				System.out.println();
				break;
				
			case 3:
				lista = dao.listar();
				if (lista.isEmpty()) {
					System.out.println("Nenhuma tarefa cadastrada.");
					break;
				}
				System.out.print("Digite o número da tarefa: ");
				int numStatus = sc.nextInt();
				sc.nextLine();
				
				System.out.println("--------------------");
				if (numStatus >= 1 && numStatus <= lista.size()) {
					Tarefa t = lista.get(numStatus -1);
					System.out.println("Tarefa: " + t.getDescricao());
					System.out.println("Status: " + (t.isConcluida() ? "Concluída" : "Não concluída"));
				}else {
					System.out.println("Tarefa não encontrada.");
				}
				System.out.println();
				break;
				
			case 4:
				lista = dao.listar();
				if (lista.isEmpty()) {
					System.out.println("Nenhuma tarefa cadastrada.");
				}
				System.out.print("Digite o número da tarefa a ser atualizada: ");
				int numAtualizar = sc.nextInt();
				sc.nextLine();
				
				if (numAtualizar >= 1 && numAtualizar <= lista.size()) {
					Tarefa t = lista.get(numAtualizar -1);
					
				System.out.println("A tarefa foi concluída? [digite true para sim, false para não]: ");
				boolean novoStatus = sc.nextBoolean();
				sc.nextLine();
				
				t.setConcluida(novoStatus);
				dao.atualizar(t);
				
				System.out.println("Status atualizado com sucesso!");
				
				}else {
					System.out.println("Número inválido.");
				}
				System.out.println();
				break;
				
				
			case 5:
				lista = dao.listar();
				if (lista.isEmpty()) {
					System.out.println("Nenhuma tarefa cadastrada.");
					break;
				}
				System.out.print("Digite o número da tarefa a ser excluída: ");
				int numExcluir = sc.nextInt();
				sc.nextLine();
				
				if (numExcluir >= 1 && numExcluir <= lista.size()) {
					Tarefa t = lista.get(numExcluir -1);
					dao.deletar(t.getId());
				System.out.println("Tarefa excluída com sucesso!");
				}else {
					System.out.println("Número inválido.");
				}
				System.out.println();
				break;

			case 0:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida.");
			}
		}

		sc.close();
	}
}
