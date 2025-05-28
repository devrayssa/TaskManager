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

    // Atualiza o título da tarefa
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        this.title = title.trim();
    }

    // Atualiza a descrição da tarefa
    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        this.description = description.trim();
    }
}

