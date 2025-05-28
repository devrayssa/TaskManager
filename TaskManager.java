import java.util.ArrayList;

public class TaskManager {
    private static ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println("Tarefa " + (i + 1));
                System.out.println("Título: " + task.getTitle());
                System.out.println("Descrição: " + task.getDescription());
                System.out.println("Concluída: " + (task.isCompleted() ? "Sim" : "Não"));
                System.out.println("-------------------------");
            }
        }
    }
    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            System.out.println("Tarefa marcada como concluída.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
    public static void editTask(int index, String newTitle, String newDescription) {
        if (index >= 0 & index < tasks.size()) {
           Task task = tasks.get(index);
           task.setTitle(newTitle);
           task.setDescription(newDescription);
           System.out.println(" Tarefa Atualizada com sucesso. ");
        } else  {
            System.out.println("Indice Invalido");
        }
    }
}

