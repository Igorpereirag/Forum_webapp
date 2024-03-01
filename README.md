# Fórum Web App

Este é um projeto de uma aplicação web de fórum onde os usuários podem criar tópicos de discussão e interagir por meio de comentários. A aplicação permite que os usuários se cadastrem, façam login, visualizem tópicos, adicionem novos tópicos e comentários, além de exibir um ranking dos usuários com base na pontuação obtida pela participação na plataforma.

## Tecnologias Utilizadas

- Java
- Servlets
- JSP (JavaServer Pages)
- JSTL (JavaServer Pages Standard Tag Library)
- JDBC (Java Database Connectivity)
- HTML
- CSS
- Banco de Dados MySQL

## Funcionalidades

1. **Cadastro de Usuários:** Os usuários podem se cadastrar fornecendo informações básicas como nome, login, email e senha.

2. **Login de Usuários:** Os usuários podem fazer login em suas contas para acessar as funcionalidades da aplicação.

3. **Visualização de Tópicos:** Os usuários podem visualizar os tópicos existentes na plataforma.

4. **Criação de Tópicos:** Os usuários autenticados podem criar novos tópicos de discussão.

5. **Exibição de Tópico:** Os usuários podem visualizar os detalhes de um tópico, incluindo seu título, autor e conteúdo, bem como os comentários associados a ele.

6. **Adição de Comentários:** Os usuários podem adicionar comentários aos tópicos existentes.

7. **Ranking de Usuários:** A aplicação exibe um ranking dos usuários com base na pontuação obtida pela participação na plataforma, como criar novos tópicos e adicionar comentários.

## Execução do Projeto

Para executar o projeto, basta implantá-lo em um servidor web compatível com Java EE, como Apache Tomcat ou Jetty. Depois de implantado, acesse a aplicação pelo navegador web.

Além disso, certifique-se de configurar as credenciais do banco de dados no arquivo `DatabaseUtil.java` localizado no pacote `com.forum.Util`.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.
