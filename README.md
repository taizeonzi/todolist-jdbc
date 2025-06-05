# 👩‍💻 To-Do List em Java com JDBC e MySQL

## **Aplicação de lista de tarefas (To-Do List)** desenvolvida em **Java**, com conexão ao banco de dados **MySQL** utilizando **JDBC**.

## ✏️ Criei esse projeto simples, com execução no terminal, com objetivo de praticar lógica de programação Java e integração com banco de dados usando JDBC, além da manipulação de dados com SQL (CRUD), utilizando o MySQL Workbench.

## 🛠️ Funcionalidades
A aplicação roda no terminal e permite gerenciar tarefas com um menu interativo, que permite:
- Adicionar tarefas
- Listar tarefas existentes e seus status
- Mostrar status da tarefa (concluída ou não concluída)
- Atualizar status da tarefa
- Excluir tarefas


### 📋 Explicando as opções:

- **1 - Adicionar tarefa:** o usuário descreve a tarefa, que é então salva no banco de dados.
- **2 - Listar tarefas:** exibe todas as tarefas registradas com seus respectivos IDs e status.
- **3 - Mostrar status da tarefa:** permite consultar se uma tarefa específica está concluída ou não.
- **4 - Atualizar status da tarefa:** permite atualizar se uma tarefa foi concluída ou não.
- **5 - Excluir tarefa:** remove uma tarefa do banco de dados.
- **0 - Sair:** encerra o programa.

### 🎯💻 No futuro pretendo adicionar mais funcionalidades e desenvolver este projeto como uma API REST com Spring Boot.

### 💾 Estrutura do Banco de Dados (utilizado MySQL Workbench)

```sql
CREATE DATABASE todolist;

CREATE TABLE tarefas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    concluida BOOLEAN
);
