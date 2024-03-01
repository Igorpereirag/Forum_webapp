<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tópicos</title>
</head>
<body>
    <h1>Tópicos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Título</th>
                <th>Criado por</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="topico" items="${topicos}">
                <tr>
                    <td><a href="<c:url value='/exibeTopico?id='/>${topico.getId()}">${topico.getTitulo()}</a></td>
                    <td>${topico.getUserId()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <!-- Links para as outras telas -->
    <p><a href="<c:url value='/ranking'/>">Ver Ranking</a></p>
    <p><a href="<c:url value='/inserir-topico.jsp'/>">Inserir Tópico</a></p>
</body>
</html>
