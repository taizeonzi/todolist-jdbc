# 👩‍💻 Lista de Tarefas em Java com JDBC e MySQL


## Aplicação de lista de tarefas desenvolvida em Java, com conexão ao banco de dados MySQL utilizando JDBC.

🎯 Desenvolvi esse projeto simples, com objetivo de praticar a lógica de programação em Java e integração com banco de dados usando JDBC, além da manipulação de dados com SQL (CRUD), utilizando o MySQL Workbench. A aplicação roda no console e permite gerenciar tarefas com um menu interativo.

### 📌 Menu e Funcionalidades

- **1 - Adicionar tarefa**: o usuário descreve a tarefa, que é então salva no banco de dados.
- **2 - Listar tarefas**: exibe todas as tarefas registradas com seus respectivos IDs e status (concluída ou não concluída).
- **3 - Mostrar status da tarefa**: permite consultar se uma tarefa específica está concluída ou não.
- **4 - Atualizar status da tarefa**: permite atualizar o status de uma tarefa, definindo como concluída ou não concluída.
- **5 - Excluir tarefa**: remove uma tarefa do banco de dados.
- **0 - Sair**: encerra o programa.

### 💾 Estrutura do Banco de Dados

```sql
CREATE DATABASE todolist;

CREATE TABLE tarefas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    concluida BOOLEAN
);
```
### 🛠️ Melhorias:
Alterei a exibição e manipulação das tarefas para usar uma numeração sequencial personalizada, ao invés do ID do banco(os IDs reais no banco podem ser 3, 5, 8....mas o usuário vê 1, 2, 3...). 
Alterei o case 2 (listar tarefas) para mostrar com numeração sequencial.
Alterei o case 3, 4 e 5 para trabalhar com essa numeração sequencial e mapear para o ID real da tarefa.

💻 No futuro, pretendo adicionar mais funcionalidades e desenvolver este projeto como uma API REST com Spring Boot.
