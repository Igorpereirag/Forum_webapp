<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exibe Tópico</title>
</head>
<body>
    <h1>${topico.titulo}</h1>
    <p>Criado por: ${topico.userId}</p>
    <p>${topico.content}</p>
    
    <h2>Comentários</h2>
    <ul>
        <c:forEach var="comentario" items="${comentarios}">
            <li>${comentario.texto} (Por: ${comentario.userId})</li>
        </c:forEach>
    </ul>
    
    <h3>Adicionar Comentário</h3>
    <form action="adicionarComentario" method="post">
        <textarea name="texto" rows="4" cols="50"></textarea><br>
        <input type="submit" value="Adicionar Comentário">
        <input type="hidden" name="topicoId" value="${topico.id}">
    </form>
    
    <!-- Link para voltar para a Tela Tópicos -->
    <p><a href="<c:url value='/topicos'/>">Voltar para Tópicos</a></p>
</body>
</html>
