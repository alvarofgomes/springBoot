🛒 API de Cadastro de Produtos – Spring Boot

Projeto desenvolvido durante o Bootcamp Java, com foco em:

Arquitetura em camadas

Boas práticas de código

Princípios SOLID

Persistência com JPA/Hibernate

Deploy em Azure App Service

🚀 Acesse a aplicação online

🔗 Aplicação (Azure):
https://rg-bootcamp-alvaro-c0dubph9hzhagrd9.brazilsouth-01.azurewebsites.net/ui/produtos

🔗 Repositório GitHub:
https://github.com/alvarofgomes/springBoot

🧱 Tecnologias utilizadas

Java 21

Spring Boot

Spring Data JPA

Hibernate

Thymeleaf

H2 Database

Maven

Azure App Service

📁 Estrutura do projeto

Organizado seguindo arquitetura em camadas e princípios SOLID:

controller        → Endpoints REST
ui                → Interface web (Thymeleaf)
service           → Regras de negócio
service.impl      → Implementações do serviço
service.rules     → Validações de domínio
repository        → Acesso ao banco (JPA)
dto               → Objetos de transferência de dados
mapper            → Conversão DTO ↔ Entidade
exception         → Exceções personalizadas
model             → Entidades JPA

⚙️ Funcionalidades

✔️ Criar produto
✔️ Listar produtos
✔️ Buscar produto por ID
✔️ Atualizar produto
✔️ Remover produto
✔️ Interface web com Thymeleaf
✔️ Validações de regra de negócio
✔️ Tratamento de exceções
✔️ Testes unitários no service
✔️ Deploy em nuvem (Azure)

🗄️ Banco de dados

O projeto utiliza:

H2 em memória para execução simples

Criação automática das tabelas via Hibernate (ddl-auto)

🧪 Testes

Testes unitários implementados na camada de service, utilizando:

JUnit 5

Mockito

Garantindo:

Validação de regras de negócio

Tratamento de exceções

Persistência correta

☁️ Deploy

Aplicação publicada no Azure App Service, acessível via navegador:

➡️ Interface web funcionando online
➡️ Build automatizado via Maven
➡️ Execução com Java 21

📚 Conceitos aplicados

SOLID

SRP → separação de responsabilidades

OCP → regras extensíveis

LSP → múltiplas implementações de service

DIP → uso de interfaces

DTO Pattern

Mapper Pattern

Exception Handling

Arquitetura em camadas

👨‍💻 Autor

Álvaro Gomes
Back-End Java Developer em formação

GitHub: https://github.com/alvarofgomes
