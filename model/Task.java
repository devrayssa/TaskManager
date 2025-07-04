package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String title;
    private String description;
    private boolean completed;
    private String createdAt;
    private String completedAt;

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
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.completedAt = null;
    }

    // Construtor para carregar tarefas do arquivo
    public Task(String title, String description, boolean completed, String createdAt, String completedAt) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }

    // Marca a tarefa como concluída
    public void markAsCompleted() {
        this.completed = true;
        this.completedAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    // Marca a tarefa como não concluída
    public void markAsIncomplete() {
        this.completed = false;
        this.completedAt = null;
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

    // Getters para as datas
    public String getCreatedAt() {
        return createdAt;
    }

    public String getCompletedAt() {
        return completedAt;
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

    // Metodo para converter para formato de salvamento
    public String toSaveFormat() {
        return title + "|" + description + "|" + completed + "|" + createdAt + "|" +
                (completedAt != null ? completedAt : "null");
    }

    // Metodo para criar Task a partir do formato de salvamento
    public static Task fromSaveFormat(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 5) {
            String title = parts[0];
            String description = parts[1];
            boolean completed = Boolean.parseBoolean(parts[2]);
            String createdAt = parts[3];
            String completedAt = parts[4].equals("null") ? null : parts[4];
            return new Task(title, description, completed, createdAt, completedAt);
        }
        return null;
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