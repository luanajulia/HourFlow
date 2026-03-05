🕒 HourFlow - Sistema de Aprovação de Banco de Horas
O HourFlow é uma aplicação desenvolvida para simplificar a gestão de horas extras e compensações. O sistema permite que colaboradores registrem suas solicitações e que gestores revisem, aprovem ou reprovem essas horas de forma centralizada e eficiente.

🚀 Funcionalidades
Para Colaboradores
Registro de Horas: Lançamento de horas extras com descrição da atividade.

Histórico Pessoal: Visualização do status de todas as solicitações enviadas (Pendente, Aprovado, Reprovado).

Saldo de Banco: Consulta em tempo real do saldo acumulado de horas.

Para Gestores
Dashboard de Aprovação: Lista consolidada de todas as solicitações pendentes da equipe.

Ações de Gestão: Botões rápidos para aprovar ou reprovar com campo de feedback.

Relatórios: Visualização do total de horas aprovadas por colaborador/período.

🛠️ Tecnologias Utilizadas
O projeto utiliza uma arquitetura moderna aproveitando o melhor do ecossistema JVM:

Linguagens: Java 21 & Kotlin 1.9 (Interoperabilidade total).

Framework: Spring Boot 3.x (Spring Data JPA, Spring Security).

Banco de Dados: PostgreSQL / H2 (para ambiente de desenvolvimento).

Gerenciador de Dependências: Gradle (ou Maven).

Documentação da API: Swagger/OpenAPI.

🏗️ Estrutura do Projeto

Shutterstock
O projeto segue o padrão de Arquitetura em Camadas:

Controller: Exposição dos endpoints REST.

Service: Lógica de negócio (regras de aprovação, cálculos de banco).

Repository: Interface de comunicação com o banco de dados.

Model/Entity: Definição das tabelas e objetos de domínio.

📋 Pré-requisitos
Antes de começar, você precisará ter instalado em sua máquina:

JDK 21 ou superior.

Android Studio.

PostgreSQL (opcional, caso não use o banco H2 em memória).

🔧 Instalação e Execução
Clone o repositório:

Bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
Configure as propriedades:
No arquivo src/main/resources/application.properties, ajuste as credenciais do banco de dados.

Execute a aplicação:

Bash
./gradlew bootRun
Acesse a documentação:
Acesse http://localhost:8080/swagger-ui.html para visualizar e testar os endpoints.

🛣️ Roadmap de Desenvolvimento
[x] CRUD básico de usuários e perfis (Colaborador/Gestor).

[x] Lógica de submissão de horas em Kotlin.

[ ] Implementação de notificações por e-mail para o gestor.

[ ] Geração de relatório em PDF.
