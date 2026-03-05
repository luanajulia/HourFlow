# 🕒 HourFlow - Gestão de Banco de Horas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

O **HourFlow** é uma solução robusta para o controle e aprovação de banco de horas. O sistema foi desenhado para separar as responsabilidades entre **Colaboradores** (que solicitam) e **Gestores** (que revisam e aprovam), garantindo integridade e transparência nos lançamentos.

---

## 🎯 Objetivo do Projeto

Eliminar o uso de planilhas manuais para o controle de horas extras, oferecendo uma interface centralizada onde o fluxo de aprovação é automatizado e auditável.

## 👥 Perfis de Usuário

### 🛠️ Colaborador
* **Lançamento de Horas:** Registro de entradas/saídas extras com justificativa.
* **Dashboard de Saldo:** Visualização do total de horas acumuladas vs. compensadas.
* **Status em Tempo Real:** Acompanhamento se a hora foi aprovada, reprovada ou se ainda está pendente.

### 👔 Gestor
* **Painel de Aprovação:** Visualização de todas as solicitações pendentes da sua equipe.
* **Fluxo de Decisão:** Aprovação ou reprovação de horas com inserção de comentários/motivações.
* **Relatórios:** Extração de dados consolidados por período ou por colaborador específico.

---

## 🛠️ Stack Tecnológica

O projeto utiliza a interoperabilidade da JVM para unir a estabilidade do Java com a concisão do Kotlin:

* **Backend:** Spring Boot 3 (Java 21 & Kotlin 1.9)
* **Persistência:** Spring Data JPA
* **Segurança:** Spring Security (Controle de acesso por perfis/Roles)
* **Banco de Dados:** PostgreSQL (Produção) / H2 (Desenvolvimento)
* **Documentação:** Swagger UI (OpenAPI 3)

---

## 🏗️ Arquitetura do Sistema

A aplicação segue o padrão **RESTful** e uma arquitetura em camadas para facilitar a manutenção e escalabilidade.

---

## 🚀 Como Executar

### Pré-requisitos
* JDK 21
* Gradle 8.x ou Maven 3.9+

*👩‍💻 Autora Desenvolvido com ❤️ por Luana Julia.*
