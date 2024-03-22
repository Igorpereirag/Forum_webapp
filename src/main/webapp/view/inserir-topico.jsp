<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir Tópico</title>
</head>
<body>
    <h1>Inserir Tópico</h1>
    <form action="${pageContext.request.contextPath}/inserir-topico" method="post">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" required>
        <br>
        <label for="content">Texto:</label>
        <textarea id="content" name="content" required></textarea>
        <!-- Corrigido o nome do campo para 'content' -->
        <br>
        <label for="user_id">ID do Usuário:</label>
        <input type="text" id="user_id" name="user_id" required>
        <br>
        <input type="submit" value="Inserir Tópico">
    </form>
</body>
</html>
