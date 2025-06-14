package model;

public class Task {
    private String title;
    private String description;
    private boolean completed;

    // Construtor que inicializa uma tarefa com título e descrição
    public Task(String title, String description) {
        // Validação para evitar título ou descrição vazios
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }

        this.title = title.trim();
        this.description = description.trim();
        this.completed = false;
    }

    // Marca a tarefa como concluída
    public void markAsCompleted() {
        this.completed = true;
    }

    // Marca a tarefa como não concluída
    public void markAsIncomplete() {
        this.completed = false;
    }

    // Retorna o título da tarefa
    public String getTitle() {
        return title;
    }

    // Retorna a descrição da tarefa
    public String getDescription() {
        return description;
    }

    // Retorna se a tarefa está concluída
    public boolean isCompleted() {
        return completed;
    }

    // Permite alterar o título da tarefa
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        this.title = title.trim();
    }

    // Permite alterar a descrição da tarefa
    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        this.description = description.trim();
    }

    // Metodo toString para facilitar a exibição da tarefa
    @Override
    public String toString() {
        String status = completed ? "[✓]" : "[ ]";
        return String.format("%s %s - %s", status, title, description);
    }

    // Metodo equals para comparar tarefas
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Task task = (Task) obj;
        return completed == task.completed &&
                title.equals(task.title) &&
                description.equals(task.description);
    }

    // Metodo hashCode
    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (completed ? 1 : 0);
        return result;
    }
}
