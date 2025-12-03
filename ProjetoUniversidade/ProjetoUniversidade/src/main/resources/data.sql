-- Dados iniciais para popular o banco de dados H2
-- Inserções com ids explícitos para garantir referências (IDENTITY permite valores explícitos)

-- Cursos
INSERT INTO curso (id, duracao, nome) VALUES (1, '4 anos', 'Ciência da Computação');
INSERT INTO curso (id, duracao, nome) VALUES (2, '2 anos', 'Tecnologia em Análise e Desenvolvimento de Sistemas');
INSERT INTO curso (id, duracao, nome) VALUES (3, '4 anos', 'Engenharia de Software');

-- Departamentos
INSERT INTO departamento (id, nome) VALUES (1, 'Departamento de Computação');
INSERT INTO departamento (id, nome) VALUES (2, 'Departamento de Matemática');
INSERT INTO departamento (id, nome) VALUES (3, 'Departamento de Engenharia');

-- Endereços
INSERT INTO endereco (id, cidade, estado, rua) VALUES (1, 'São Paulo', 'SP', 'Rua das Flores, 100');
INSERT INTO endereco (id, cidade, estado, rua) VALUES (2, 'Campinas', 'SP', 'Av. Brasil, 200');
INSERT INTO endereco (id, cidade, estado, rua) VALUES (3, 'São Paulo', 'SP', 'Rua Santa Cruz, 150');
INSERT INTO endereco (id, cidade, estado, rua) VALUES (4, 'Santo André', 'SP', 'Av. Paulista, 300');

-- Professores (referenciam departamento e endereco)
INSERT INTO professor (id, especialidade, nome, departamento_id, endereco_id) VALUES (1, 'Sistemas Distribuídos', 'Prof. João Souza', 1, 1);
INSERT INTO professor (id, especialidade, nome, departamento_id, endereco_id) VALUES (2, 'Cálculo', 'Profa. Ana Lima', 2, 2);
INSERT INTO professor (id, especialidade, nome, departamento_id, endereco_id) VALUES (3, 'Programação Web', 'Prof. Carlos Pereira', 1, 3);
INSERT INTO professor (id, especialidade, nome, departamento_id, endereco_id) VALUES (4, 'Engenharia de Requisitos', 'Profa. Isabela Costa', 3, 4);

-- Disciplinas (referenciam curso e professor)
INSERT INTO disciplina (id, carga_horaria, nome, curso_id, professor_id) VALUES (1, 60, 'Algoritmos e Estruturas de Dados', 1, 1);
INSERT INTO disciplina (id, carga_horaria, nome, curso_id, professor_id) VALUES (2, 60, 'Cálculo I', 2, 2);
INSERT INTO disciplina (id, carga_horaria, nome, curso_id, professor_id) VALUES (3, 80, 'Programação Web', 1, 3);
INSERT INTO disciplina (id, carga_horaria, nome, curso_id, professor_id) VALUES (4, 60, 'Engenharia de Requisitos', 3, 4);
INSERT INTO disciplina (id, carga_horaria, nome, curso_id, professor_id) VALUES (5, 60, 'Banco de Dados', 1, 1);

-- Alunos
INSERT INTO aluno (id, matricula, nome) VALUES (1, '20230001', 'Maria Silva');
INSERT INTO aluno (id, matricula, nome) VALUES (2, '20230002', 'Pedro Santos');
INSERT INTO aluno (id, matricula, nome) VALUES (3, '20230003', 'Ana Costa');
INSERT INTO aluno (id, matricula, nome) VALUES (4, '20230004', 'Bruno Martins');
INSERT INTO aluno (id, matricula, nome) VALUES (5, '20230005', 'Carla Oliveira');

-- Matrículas (semestre, aluno_id, disciplina_id) — referenciam aluno e disciplina
INSERT INTO matricula (semestre, aluno_id, disciplina_id) VALUES ('2023.1', 1, 1);
INSERT INTO matricula (semestre, aluno_id, disciplina_id) VALUES ('2023.1', 2, 2);
INSERT INTO matricula (semestre, aluno_id, disciplina_id) VALUES ('2023.1', 3, 1);
INSERT INTO matricula (semestre, aluno_id, disciplina_id) VALUES ('2023.1', 4, 3);
INSERT INTO matricula (semestre, aluno_id, disciplina_id) VALUES ('2023.1', 5, 4);
INSERT INTO matricula (semestre, aluno_id, disciplina_id) VALUES ('2023.2', 1, 3);
INSERT INTO matricula (semestre, aluno_id, disciplina_id) VALUES ('2023.2', 2, 5);
INSERT INTO matricula (semestre, aluno_id, disciplina_id) VALUES ('2023.2', 3, 2);
INSERT INTO matricula (semestre, aluno_id, disciplina_id) VALUES ('2023.2', 4, 5);

-- Avaliações (n1, n2, aluno_id, disciplina_id) — PK (aluno_id, disciplina_id) e FK para matricula
INSERT INTO avaliacao (n1, n2, aluno_id, disciplina_id) VALUES (8.5, 9.0, 1, 1);
INSERT INTO avaliacao (n1, n2, aluno_id, disciplina_id) VALUES (7.0, 6.5, 2, 2);
INSERT INTO avaliacao (n1, n2, aluno_id, disciplina_id) VALUES (9.0, 9.5, 3, 1);
INSERT INTO avaliacao (n1, n2, aluno_id, disciplina_id) VALUES (7.5, 8.0, 4, 3);
INSERT INTO avaliacao (n1, n2, aluno_id, disciplina_id) VALUES (8.0, 8.5, 5, 4);
INSERT INTO avaliacao (n1, n2, aluno_id, disciplina_id) VALUES (8.0, 8.5, 1, 3);
INSERT INTO avaliacao (n1, n2, aluno_id, disciplina_id) VALUES (6.5, 7.0, 2, 5);
INSERT INTO avaliacao (n1, n2, aluno_id, disciplina_id) VALUES (7.5, 7.0, 3, 2);
INSERT INTO avaliacao (n1, n2, aluno_id, disciplina_id) VALUES (9.0, 8.5, 4, 5);

COMMIT;
