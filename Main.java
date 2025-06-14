package util;

import service.TaskManager;
import model.Task;
import java.util.Scanner;

public class Main {
    private static TaskManager taskManager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== BEM-VINDO AO TASK MANAGER ===\n");

        // Adiciona algumas tarefas de exemplo
        addSampleTasks();

        // Menu principal
        while (true) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    taskManager.displayAllTasks();
                    break;
                case 3:
                    taskManager.displayPendingTasks();
                    break;
                case 4:
                    completeTask();
                    break;
                case 5:
                    removeTask();
                    break;
                case 6:
                    showStatistics();
                    break;
                case 0:
                    System.out.println("Obrigado por usar o Task Manager!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Adicionar nova tarefa");
        System.out.println("2. Listar todas as tarefas");
        System.out.println("3. Listar tarefas pendentes");
        System.out.println("4. Marcar tarefa como concluída");
        System.out.println("5. Remover tarefa");
        System.out.println("6. Estatísticas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int getChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addNewTask() {
        System.out.print("Digite o título da tarefa: ");
        String title = scanner.nextLine();

        System.out.print("Digite a descrição da tarefa: ");
        String description = scanner.nextLine();

        taskManager.addTask(title, description);
    }

    private static void completeTask() {
        taskManager.displayPendingTasks();
        if (taskManager.getPendingTasksCount() == 0) {
            return;
        }

        System.out.print("Digite o título da tarefa a ser concluída: ");
        String title = scanner.nextLine();
        taskManager.completeTask(title);
    }

    private static void removeTask() {
        taskManager.displayAllTasks();
        if (taskManager.getTotalTasks() == 0) {
            return;
        }

        System.out.print("Digite o título da tarefa a ser removida: ");
        String title = scanner.nextLine();
        taskManager.removeTask(title);
    }

    private static void showStatistics() {
        System.out.println("\n=== ESTATÍSTICAS ===");
        System.out.println("Total de tarefas: " + taskManager.getTotalTasks());
        System.out.println("Tarefas concluídas: " + taskManager.getCompletedTasksCount());
        System.out.println("Tarefas pendentes: " + taskManager.getPendingTasksCount());

        if (taskManager.getTotalTasks() > 0) {
            double completionRate = (double) taskManager.getCompletedTasksCount() / taskManager.getTotalTasks() * 100;
            System.out.printf("Taxa de conclusão: %.1f%%\n", completionRate);
        }
    }

    private static void addSampleTasks() {
        taskManager.addTask("Estudar Java", "Revisar conceitos de POO e estruturas de dados");
        taskManager.addTask("Fazer exercícios", "Completar lista de exercícios de programação");
        taskManager.addTask("Ler documentação", "Ler documentação oficial do Spring Boot");

        // Marca uma tarefa como concluída para demonstração
        taskManager.completeTask("Estudar Java");

        System.out.println("Tarefas de exemplo adicionadas!");
    }
}