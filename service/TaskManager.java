package service;

import model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    // Adiciona uma nova tarefa
    public void addTask(String title, String description) {
        try {
            Task newTask = new Task(title, description);
            tasks.add(newTask);
            System.out.println("Tarefa adicionada com sucesso: " + title);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }

    // Adiciona uma tarefa já criada
    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
            System.out.println("Tarefa adicionada com sucesso: " + task.getTitle());
        }
    }

    // Remove uma tarefa pelo título
    public boolean removeTask(String title) {
        Task taskToRemove = findTaskByTitle(title);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Tarefa removida: " + title);
            return true;
        }
        System.out.println("Tarefa não encontrada: " + title);
        return false;
    }

    // Marca uma tarefa como concluída
    public boolean completeTask(String title) {
        Task task = findTaskByTitle(title);
        if (task != null) {
            task.markAsCompleted();
            System.out.println("Tarefa marcada como concluída: " + title);
            return true;
        }
        System.out.println("Tarefa não encontrada: " + title);
        return false;
    }

    // Busca uma tarefa pelo título
    private Task findTaskByTitle(String title) {
        return tasks.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(title.trim()))
                .findFirst()
                .orElse(null);
    }

    // Retorna todas as tarefas
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    // Retorna apenas tarefas pendentes
    public List<Task> getPendingTasks() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    // Retorna apenas tarefas concluídas
    public List<Task> getCompletedTasks() {
        return tasks.stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }

    // Exibe todas as tarefas
    public void displayAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("\n=== TODAS AS TAREFAS ===");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // Exibe apenas tarefas pendentes
    public void displayPendingTasks() {
        List<Task> pendingTasks = getPendingTasks();
        if (pendingTasks.isEmpty()) {
            System.out.println("Nenhuma tarefa pendente.");
            return;
        }

        System.out.println("\n=== TAREFAS PENDENTES ===");
        for (int i = 0; i < pendingTasks.size(); i++) {
            System.out.println((i + 1) + ". " + pendingTasks.get(i));
        }
    }

    // Retorna o número total de tarefas
    public int getTotalTasks() {
        return tasks.size();
    }

    // Retorna o número de tarefas concluídas
    public int getCompletedTasksCount() {
        return getCompletedTasks().size();
    }

    // Retorna o número de tarefas pendentes
    public int getPendingTasksCount() {
        return getPendingTasks().size();
    }

    // Limpa todas as tarefas
    public void clearAllTasks() {
        tasks.clear();
        System.out.println("Todas as tarefas foram removidas.");
    }
}