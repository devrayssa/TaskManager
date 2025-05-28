import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    // Construtor que inicializa a lista de tarefas
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    // Adiciona uma nova tarefa à lista
    public void addTask(String title, String description) {
        Task task = new Task(title, description);
        tasks.add(task);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    // Lista todas as tarefas
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("\n=== Lista de Tarefas ===");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println("Tarefa " + (i + 1) + ":");
                System.out.println("Título: " + task.getTitle());
                System.out.println("Descrição: " + task.getDescription());
                System.out.println("Status: " + (task.isCompleted() ? "Concluída" : "Pendente"));
                System.out.println();
            }
        }
    }
    public boolean hasTasks() {
        return !tasks.isEmpty();
    }

    // Marca uma tarefa como concluída com base no índice
    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            if (tasks.get(index).isCompleted()) {
                System.out.println("Essa tarefa já está concluída!");
            } else {
                tasks.get(index).markAsCompleted();
                System.out.println("Tarefa marcada como concluída!");
            }
        } else {
            System.out.println("Índice inválido!");
        }
    }

    // Edita uma tarefa existente com base no índice
    public void editTask(int index, String newTitle, String newDescription) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setTitle(newTitle);
            task.setDescription(newDescription);
            System.out.println("Tarefa atualizada com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    // Remove uma tarefa da lista com base no índice
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index);
            System.out.println("Tarefa '" + removedTask.getTitle() + "' removida com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
}
