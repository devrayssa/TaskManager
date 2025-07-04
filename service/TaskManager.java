package service;

import model.Task;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks;
    private final String DATA_FOLDER = "data";
    private final String SAVE_FILE = DATA_FOLDER + File.separator + "tasks.txt";

    public TaskManager() {
        this.tasks = new ArrayList<>();
        loadTasks(); // Carrega tarefas ao inicializar
    }

    // Adiciona uma nova tarefa
    public void addTask(String title, String description) {
        try {
            Task newTask = new Task(title, description);
            tasks.add(newTask);
            System.out.println("Tarefa adicionada com sucesso: " + title);
            saveTasks(); // Salva automaticamente
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }

    // Adiciona uma tarefa já criada
    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
            System.out.println("Tarefa adicionada com sucesso: " + task.getTitle());
            saveTasks(); // Salva automaticamente
        }
    }

    // Remove uma tarefa pelo título
    public boolean removeTask(String title) {
        Task taskToRemove = findTaskByTitle(title);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Tarefa removida: " + title);
            saveTasks(); // Salva automaticamente
            return true;
        }
        System.out.println("Tarefa não encontrada: " + title);
        return false;
    }

    // Marca uma tarefa como concluída pelo título
    public boolean completeTask(String title) {
        Task task = findTaskByTitle(title);
        if (task != null) {
            task.markAsCompleted();
            System.out.println("Tarefa marcada como concluída: " + title);
            saveTasks(); // Salva automaticamente
            return true;
        }
        System.out.println("Tarefa não encontrada: " + title);
        return false;
    }

    // NOVA FUNCIONALIDADE: Marca uma tarefa como concluída pelo número
    public boolean completeTaskByNumber(int taskNumber) {
        List<Task> pendingTasks = getPendingTasks();

        if (taskNumber >= 1 && taskNumber <= pendingTasks.size()) {
            Task taskToComplete = pendingTasks.get(taskNumber - 1);
            taskToComplete.markAsCompleted();
            System.out.println("Tarefa marcada como concluída: " + taskToComplete.getTitle());
            saveTasks(); // Salva automaticamente
            return true;
        }

        System.out.println("Número de tarefa inválido: " + taskNumber);
        return false;
    }

    // NOVA FUNCIONALIDADE: Permite marcar por número ou título
    public boolean completeTaskByNumberOrTitle(String input) {
        // Tenta primeiro como número
        try {
            int taskNumber = Integer.parseInt(input.trim());
            return completeTaskByNumber(taskNumber);
        } catch (NumberFormatException e) {
            // Se não é número, tenta como título
            return completeTask(input);
        }
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
        saveTasks(); // Salva automaticamente
    }

    // NOVA FUNCIONALIDADE: Salva tarefas em arquivo
    private void saveTasks() {
        // Cria a pasta data se não existir
        File dataDir = new File(DATA_FOLDER);
        if (!dataDir.exists()) {
            if (dataDir.mkdirs()) {
                System.out.println("📁 Pasta 'data' criada com sucesso!");
            } else {
                System.out.println("❌ Erro ao criar pasta 'data'!");
                return;
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_FILE))) {
            for (Task task : tasks) {
                writer.println(task.toSaveFormat());
            }
            System.out.println("💾 Tarefas salvas em: " + SAVE_FILE);
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    // NOVA FUNCIONALIDADE: Carrega tarefas do arquivo
    private void loadTasks() {
        File file = new File(SAVE_FILE);
        if (!file.exists()) {
            System.out.println("📝 Arquivo de tarefas não encontrado em: " + SAVE_FILE);
            System.out.println("📝 Iniciando com lista vazia. As tarefas serão salvas na pasta 'data'.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String line;
            int loadedCount = 0;

            while ((line = reader.readLine()) != null) {
                Task task = Task.fromSaveFormat(line);
                if (task != null) {
                    tasks.add(task);
                    loadedCount++;
                }
            }

            if (loadedCount > 0) {
                System.out.println("📂 " + loadedCount + " tarefa(s) carregada(s) de: " + SAVE_FILE);
            }

        } catch (IOException e) {
            System.out.println("❌ Erro ao carregar tarefas: " + e.getMessage());
        }
    }

    // NOVA FUNCIONALIDADE: Salva manualmente (para quando o usuário sair)
    public void saveTasksManually() {
        saveTasks();
    }
}