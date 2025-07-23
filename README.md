# 📝 TaskManager - Gerenciador de Tarefas em Java 

Um projeto simples e funcional de terminal feito em Java puro para gerenciar tarefas do dia a dia. Você pode adicionar, listar, marcar como concluída e remover tarefas — tudo direto do terminal. Futuramente vai ter uma aplicação dele.

## 🚀 Funcionalidades

- ✅ Adicionar tarefas
- 📋 Listar tarefas pendentes e concluídas
- ✏️ Marcar tarefas como concluídas
- Listar todas as tarefas.
- Estaticas das tarefas, como mostrar a porcentagem de cada tarefa.
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

```mermaid
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
    L --> B
    
    D --> N[Carregar Lista]
    N --> B
    
    E --> P[Selecionar Tarefa]
    P --> Q{Tarefa Existe?}
    Q -->|Não| R[Erro]
    Q -->|Sim| S[Editar Campos]
    R --> B
    S --> T[Validar Alterações]
    T --> U{Válidas?}
    U -->|Não| S
    U -->|Sim| W[Atualizar]
    W --> B
    
    F --> Y[Selecionar Tarefa]
    Y --> Z{Existe?}
    Z -->|Não| B
    Z -->|Sim| BB[Confirmar Exclusão]
    BB --> CC{Confirmar?}
    CC -->|Não| B
    CC -->|Sim| DD[Remover]
    DD --> B
    
    G --> FF[Buscar]
    FF --> B
    
    H --> II[Finalizar]
    
  

