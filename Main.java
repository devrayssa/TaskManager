import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static TaskManager manager = new TaskManager();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcaoMenu();
            executarOpcao(opcao);
        } while (opcao != 0);

        scanner.close();
        System.out.println("Programa encerrado. Até logo!");
    }

    // Exibe o menu principal
    private static void exibirMenu() {
        System.out.println("\n=== Gerenciador de Tarefas ===");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Listar tarefas");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("4. Editar tarefa");
        System.out.println("5. Remover tarefa");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Lê a opção do menu com validação
    private static int lerOpcaoMenu() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite um número válido!");
            scanner.nextLine(); // Limpar entrada inválida
            return -1; // Retorna um valor inválido para ser tratado
        }
    }

    // Executa a opção escolhida pelo usuário
    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarTarefa();
                break;
            case 2:
                manager.listTasks();
                break;
            case 3:
                marcarTarefaConcluida();
                break;
            case 4:
                editarTarefa();
                break;
            case 5:
                removerTarefa();
                break;
            case 0:
                // Sair é tratado no loop do main
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    // Adiciona uma nova tarefa
    private static void adicionarTarefa() {
        System.out.print("Título: ");
        String title = scanner.nextLine();
        System.out.print("Descrição: ");
        String description = scanner.nextLine();
        try {
            manager.addTask(title, description);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void marcarTarefaConcluida() {
        if (manager.hasTasks()) {
            manager.listTasks();
            System.out.print("Digite o número da tarefa para marcar como concluída: ");
            try {
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                manager.markTaskAsCompleted(index);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
            }
        } else {
            System.out.println("Nenhuma tarefa cadastrada.");
        }
    }

    private static void editarTarefa() {
        if (manager.hasTasks()) {
            manager.listTasks();
            System.out.print("Digite o número da tarefa para editar: ");
            try {
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                System.out.print("Novo título: ");
                String newTitle = scanner.nextLine();
                System.out.print("Nova descrição: ");
                String newDescription = scanner.nextLine();
                manager.editTask(index, newTitle, newDescription);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhuma tarefa cadastrada.");
        }
    }

    private static void removerTarefa() {
        if (manager.hasTasks()) {
            manager.listTasks();
            System.out.print("Digite o número da tarefa para remover: ");
            try {
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                manager.removeTask(index);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
            }
        } else {
            System.out.println("Nenhuma tarefa cadastrada.");
        }
    }
}
