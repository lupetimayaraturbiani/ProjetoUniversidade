# 🎓 Sistema Universitário – Spring Boot

## 🧠 Objetivo
Projeto desenvolvido para o **Trabalho Prático de Modelagem e Implementação de Relacionamentos em Aplicações Spring Boot**.  
O sistema representa o domínio de uma **universidade**, incluindo alunos, professores, cursos, departamentos, disciplinas, matrículas e avaliações.

---

## 🏗️ Estrutura da Aplicação

### 📁 Pacotes
```
com.universidade
 ┣ 📂 controller
 ┣ 📂 model
 ┣ 📂 repository
 ┣ 📂 service
 ┗ 📜 UniversidadeApplication.java
```

---

## 🔗 Relacionamentos Implementados

| Entidade | Relacionamento | Tipo | Descrição |
|-----------|----------------|------|------------|
| Departamento → Curso | 1:N | Um departamento possui vários cursos |
| Curso → Disciplina | 1:N | Um curso possui várias disciplinas |
| Curso → Professor Coordenador | 1:1 | Cada curso tem um professor coordenador |
| Professor → Departamento | N:1 | Cada professor pertence a um departamento |
| Professor → Disciplina | 1:N | Um professor ministra várias disciplinas |
| Aluno → Endereço | 1:1 | Um aluno possui um endereço |
| Aluno → Curso | N:1 | Muitos alunos estão em um curso |
| Aluno ↔ Disciplina (Matricula) | N:N | Realizado via entidade associativa `Matricula` |
| Matricula → Avaliação | 1:1 | Cada matrícula possui uma avaliação |

---

## 🧩 Dependências Importantes

No arquivo `pom.xml`, inclua:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## 🚀 Como Executar o Projeto

1. Clone o repositório ou importe o projeto no IntelliJ / Eclipse.  
2. Garanta que o **JDK 17 ou superior** esteja instalado.  
3. Execute o método `main()` da classe `UniversidadeApplication.java`.  
4. O projeto rodará em:  
   👉 **http://localhost:8080**

5. Acesse o console do banco H2:  
   🔗 **http://localhost:8080/h2-console**  
   - JDBC URL: `jdbc:h2:mem:universidadeDB`  
   - Usuário: `sa`  
   - Senha: *(vazio)*

---

## 📡 Endpoints REST

### 🎓 Cursos
| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| GET | `/cursos` | Lista todos |
| GET | `/cursos/{id}` | Busca por ID |
| POST | `/cursos` | Cria ou atualiza |
| DELETE | `/cursos/{id}` | Remove |

### 🧑‍🏫 Professores
| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| GET | `/professores` | Lista todos |
| POST | `/professores` | Adiciona novo |

### 👩‍🎓 Alunos
| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| GET | `/alunos` | Lista todos |
| POST | `/alunos` | Adiciona novo |

### 📘 Disciplinas
| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| GET | `/disciplinas` | Lista todas |
| POST | `/disciplinas` | Cria nova |

### 🧾 Matrículas
| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| GET | `/matriculas` | Lista todas |
| GET | `/matriculas/{alunoId}/{disciplinaId}` | Busca matrícula |
| POST | `/matriculas` | Registra matrícula |
| DELETE | `/matriculas/{alunoId}/{disciplinaId}` | Remove matrícula |

### 🧮 Avaliações
| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| GET | `/avaliacoes` | Lista todas |
| GET | `/avaliacoes/media-geral` | Calcula média geral |

---

## 🧭 Exemplo de JSON – Criação de Aluno
```json
{
  "nome": "João Silva",
  "matricula": "2025001",
  "curso": { "id": 1 },
  "endereco": {
    "rua": "Rua das Flores",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01000-000"
  }
}
```

---

## 🧩 Diagrama Conceitual (Resumo)

```
[Departamento] 1───N [Curso] 1───N [Disciplina]
                     │             │
                     │             └── N───1 [Professor]
                     │
                     └── N───1 [Aluno] 1──1 [Endereco]
                              │
                              └── N───N [Disciplina] via [Matricula] 1──1 [Avaliacao]
```

---

## ✨ Tecnologias Utilizadas
- Java 17  
- Spring Boot 3.x  
- Spring Data JPA  
- Banco de Dados H2  
- Maven  
- RESTful API

---

## 👩‍💻 Autoria
Projeto desenvolvido por **integrantes do projeto**  
Para o Trabalho Prático – **Modelagem e Implementação de Relacionamentos em Aplicações Spring Boot**  
💡 Disciplina: *Desenvolvimento de Sistemas Web*  
📅 Ano: 2025
