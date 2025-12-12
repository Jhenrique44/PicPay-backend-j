# 💰 PicPay-backend

API REST simplificada inspirada no desafio técnico do **PicPay Backend**.  
Esta aplicação backend foi construída com **Java & Spring Boot** para gerenciar usuários e transferências financeiras com regras de negócio típicas de uma plataforma de pagamentos. :contentReference[oaicite:1]{index=1}

---

## 🧠 Overview

Esse projeto implementa:

✔ Cadastro de usuários (CPF/email únicos)  
✔ Transferências entre usuários  
✔ Validação de saldo antes de transferências  
✔ Integração com serviços externos de autorização e notificação (mock)  
✔ Persistência via JPA e banco de dados configurado  
✔ API RESTful com endpoints intuitivos

---

## 📌 Tecnologias

| Tecnologia        | Uso |
|------------------|-----|
| Java 17          | Linguagem principal |
| Spring Boot      | Framework backend |
| Spring Data JPA  | Persistência ORM |
| Maven            | Build tool |
| H2 / RDBMS       | Banco de dados |  
| Docker           | Containerização |

---

## 📂 Estrutura do Projeto

```bash
PicPay-backend-j/
├── src/
│   ├── main/
│   │   ├── java/com/jhenrique44/
│   │   │   ├── controller/     # API REST controllers
│   │   │   ├── service/        # Regras de negócio
│   │   │   ├── repository/     # JPA repositories
│   │   │   ├── model/          # Entidades e DTOs
│   │   │   └── config/         # Configurações do Spring
│   │   └── resources/
│   │       ├── application.yml # Configs
│   │       └── data.sql        # Dados iniciais (se houver)
├── docker-compose.yml          # Orquestra contêineres
├── Dockerfile                  # Build da aplicação
├── pom.xml                     # Dependências Maven
└── README.md

