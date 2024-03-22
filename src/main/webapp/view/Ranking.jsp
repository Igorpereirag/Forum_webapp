<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ranking de Usuários</title>
</head>
<body>
    <h1>Ranking de Usuários</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Posição</th>
                <th>Nome</th>
                <th>Login</th>
                <th>Pontos</th>
            </tr>
        </thead>
        <tbody>
            
            <c:forEach var="usuario" items="${rankingUsuarios}">
                <tr>
                    <td>${usuario.posicao}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.login}</td>
                    <td>${usuario.pontos}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
 
    <p><a href="<c:url value='/topicos'/>">Voltar para Tópicos</a></p>
</body>
</html>
