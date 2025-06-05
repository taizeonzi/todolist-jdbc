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
					for (Tarefa l : lista) {
						System.out.println(
								l.getId() + " - Tarefa: " + l.getDescricao() + " - Status da tarefa: " + (l.isConcluida() ? "Concluída" : "Não concluída"));
					}
				
				}
				System.out.println();
				break;
				
			case 3:
				System.out.print("Digite o ID da tarefa: ");
				int idBusca = sc.nextInt();
				sc.nextLine();
				
				Tarefa buscada = dao.buscarPorId(idBusca);
				System.out.println("--------------------");
				if (buscada != null) {
					System.out.println("Tarefa: " + buscada.getDescricao());
					System.out.println("Status: " + (buscada.isConcluida() ? "Concluída" : "Não concluída"));
				}else {
					System.out.println("Tarefa não encontrada.");
				}
				System.out.println();
				break;
				
			case 4: 
				System.out.print("Digite o ID da tarefa a ser atualizada: ");
				int idStatus = sc.nextInt();
				sc.nextLine();
				
				System.out.println("A tarefa foi concluída? [digite true para sim, false para não]: ");
				boolean novoStatus = sc.nextBoolean();
				sc.nextLine();
				
				Tarefa statusAtualizado = new Tarefa();
				statusAtualizado.setId(idStatus);
				statusAtualizado.setConcluida(novoStatus);
				
				dao.atualizar(statusAtualizado);
				System.out.println("Status atualizado com sucesso!");
				System.out.println();
				break;
				
			case 5:
				System.out.print("Digite o ID da tarefa a ser excluída: ");
				int idExcluir = sc.nextInt();
				sc.nextLine();

				dao.deletar(idExcluir);
				System.out.println("Tarefa excluída com sucesso!");
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
