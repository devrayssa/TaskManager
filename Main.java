import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluida");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    manager.addTask(new Task(titulo, descricao));
                    break;

                case 2:
                    manager.listTasks();
                    break;

                case 3:
                    manager.listTasks();
                    System.out.print("Digite o número da tarefa para marcar como concluída: ");
                    int numero = Integer.parseInt(scanner.nextLine());
                    manager.markTaskAsCompleted(numero - 1); // índice começa em 0
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
