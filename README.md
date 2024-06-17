# Projeto de Autenticação com Spring Boot e MongoDB

## Visão Geral

Este projeto é uma aplicação de autenticação baseada em Spring Boot que utiliza o MongoDB como banco de dados. Ele inclui autenticação básica e funcionalidades de administração de usuários, com suporte para diferentes tipos de contas (ADMIN, MOD, USER).

## Estrutura do Projeto

- **com.example.Autenticacao**: Classe principal para iniciar a aplicação Spring Boot.
- **com.example.config**: Configurações de segurança, incluindo a configuração da autenticação e autorização com Spring Security.
- **com.example.controller**: Controladores REST para autenticação e gerenciamento de usuários.
- **com.example.entity**: Entidades de domínio, como o `Usuario`.
- **com.example.enums**: Enumerações, como `TipoConta`, que define os tipos de contas de usuário.
- **com.example.repository**: Repositórios para acesso a dados no MongoDB.
- **com.example.security**: Utilitário para geração e extração de tokens JWT.
- **com.example.service**: Serviços que contêm a lógica de negócios para autenticação e gerenciamento de usuários.

## Guia de Instalação

### Pré-requisitos

- Java 11 ou superior
- Maven
- MongoDB

### Passos

1. **Clone o repositório**:
   ```sh
   git clone <URL do repositório>
   cd <nome do diretório>
   ```

2. **Configure o MongoDB**:
   Certifique-se de que o MongoDB está em execução e acessível. A configuração padrão assume que o MongoDB está rodando em `localhost:27017`.

3. **Compile o projeto**:
   ```sh
   mvn clean install
   ```

4. **Execute a aplicação**:
   ```sh
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

### Autenticação

- `POST /auth/login`: Gera um token JWT para o usuário.
  - Parâmetros: `userName` (String)

- `GET /auth/user`: Retorna o nome do usuário autenticado.
  - Autenticação necessária.

- `GET /auth/admin`: Acesso restrito para administradores.
  - Autenticação necessária.

### Gerenciamento de Usuários

- `POST /usuario/salvar`: Salva um novo usuário.
  - Parâmetros: `idUsuario` (String), `nomeUsuario` (String), `senha` (String), `identificadorTipoUsuario` (long)

- `DELETE /usuario/deletar`: Deleta um usuário.
  - Parâmetros: `idUsuario` (String)

- `GET /usuario/obtemTodos`: Obtém todos os usuários.

- `GET /usuario/obtemUsuarioPorId`: Obtém um usuário por ID.
  - Parâmetros: `idUsuario` (String)

## Segurança

A segurança é configurada utilizando Spring Security:

- **Autenticação**: Usuários em memória com senhas codificadas usando `BCryptPasswordEncoder`.
- **Autorização**: 
  - `/login/**` e `/username/**` são acessíveis sem autenticação.
  - `/admin/**` requer papel `ADMIN`.
  - Qualquer outra requisição requer autenticação.

## Token JWT

A aplicação usa JWT (JSON Web Token) para autenticação:

- **Geração de Token**: O token é gerado com base no nome do usuário e possui um tempo de expiração de 10 dias.
- **Extração de Usuário**: O nome do usuário pode ser extraído de um token fornecido.

## Contribuição

1. Faça um fork do projeto.
2. Crie uma nova branch (`git checkout -b feature/NovaFuncionalidade`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`).
4. Faça o push para a branch (`git push origin feature/NovaFuncionalidade`).
5. Abra um Pull Request.



Este README fornece uma visão geral e detalhes necessários para configuração, execução e uso da aplicação de autenticação desenvolvida com Spring Boot e MongoDB.
