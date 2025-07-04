# 📝 TaskManager - Gerenciador de Tarefas em Java 

Um projeto simples e funcional de terminal feito em Java puro para gerenciar tarefas do dia a dia. Você pode adicionar, listar, marcar como concluída e remover tarefas — tudo direto do terminal.

## 🚀 Funcionalidades

- ✅ Adicionar tarefas
- 📋 Listar tarefas pendentes e concluídas
- ✏️ Marcar tarefas como concluídas
- ❌ Remover tarefas

## 🛠️ Tecnologias usadas

- Java 17
- IntelliJ IDEA
- Git + GitHub

## 🎯 Objetivo do projeto

Este projeto foi feito para fins de estudo e prática com:
- Estruturação de classes e métodos
- Manipulação de listas em Java
- Boas práticas de terminal
- Git e versionamento de código

## Fluxograma do Sistema
flowchart TD
A[Iniciar Sistema] --> B[Menu Principal]

    B --> C[Criar Tarefa]
    B --> D[Listar Tarefas]
    B --> E[Atualizar Tarefa]
    B --> F[Remover Tarefa]
    B --> G[Buscar Tarefa]
    B --> H[Sair]
    
    C --> I[Validar Dados]
    I --> J{Dados Válidos?}
    J -->|Não| K[Exibir Erro]
    J -->|Sim| L[Salvar Tarefa]
    K --> B
    L --> M[Confirmar Criação]
    M --> B
    
    D --> N[Carregar Lista]
    N --> O[Exibir Tarefas]
    O --> B
    
    E --> P[Selecionar Tarefa]
    P --> Q{Tarefa Existe?}
    Q -->|Não| R[Tarefa Não Encontrada]
    Q -->|Sim| S[Editar Campos]
    R --> B
    S --> T[Validar Alterações]
    T --> U{Alterações Válidas?}
    U -->|Não| V[Erro de Validação]
    U -->|Sim| W[Atualizar Registro]
    V --> S
    W --> X[Confirmar Atualização]
    X --> B
    
    F --> Y[Selecionar Tarefa]
    Y --> Z{Tarefa Existe?}
    Z -->|Não| AA[Tarefa Não Encontrada]
    Z -->|Sim| BB[Confirmar Exclusão]
    AA --> B
    BB --> CC{Confirmar?}
    CC -->|Não| B
    CC -->|Sim| DD[Remover Tarefa]
    DD --> EE[Confirmar Remoção]
    EE --> B
    
    G --> FF[Inserir Critério]
    FF --> GG[Executar Busca]
    GG --> HH[Exibir Resultados]
    HH --> B
    
    H --> II[Finalizar Sistema]
    
    style A fill:#e3f2fd
    style II fill:#ffebee
    style B fill:#f3e5f5
    style K fill:#fff3e0
    style R fill:#fff3e0
    style V fill:#fff3e0
    style AA fill:#fff3e0




## 🧑‍💻 Autor

Feito com 💜 por [Rayssa Inocencio](https://www.linkedin.com/in/rayssa-souza-inocencio-9bb059303/)  
🔗 Repositório: [github.com/devrayssa/TaskManager](https://github.com/devrayssa/TaskManager)

---

> "Cada linha de código é um passo mais perto do futuro que eu quero construir."
