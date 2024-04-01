import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.forum.DAO.UsuarioDAO;
import com.forum.Model.Usuario;

public class UsuarioDAOTest {

    private JdbcDatabaseTester databaseTester;

    @Before
    public void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:testdb", "sa", "");
        IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("dataset.xml"));
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception {
        databaseTester.onTearDown();
    }

    @Test
    public void testAdicionarUsuario() throws SQLException, Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario("Teste", "teste123", "teste@example.com", "senha123", 0);

        assertTrue(usuarioDAO.adicionarUsuario(usuario));

        IDataSet currentDataSet = databaseTester.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("usuarios");

        IDataSet expectedDataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("expected_dataset.xml"));
        ITable expectedTable = expectedDataSet.getTable("usuarios");

        Assertion.assertEquals(expectedTable, currentTable);
    }
}

public class TesteSelenium {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNavegacaoEntreTelas() {
        driver.get("http://forum-web");

        // Navega para a tela de login
        WebElement linkLogin = driver.findElement(By.linkText("Login"));
        linkLogin.click();

        // Preenche o formulário de login
        WebElement inputUsername = driver.findElement(By.id("username"));
        WebElement inputPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));

        inputUsername.sendKeys("usuario");
        inputPassword.sendKeys("senha");
        btnLogin.click();

        assertEquals("http://forum-web/home", driver.getCurrentUrl());
    }
}

public class ComentarioDAOTest {

    private JdbcDatabaseTester databaseTester;

    @Before
    public void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:testdb", "sa", "");
        IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("dataset.xml"));
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception {
        databaseTester.onTearDown();
    }

    @Test
    public void testAdicionarComentario() throws SQLException, Exception {
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        Comentario comentario = new Comentario("Conteúdo do comentário", "idUsuario", 1);

        comentarioDAO.adicionarComentario(comentario);

        IDataSet currentDataSet = databaseTester.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("comentarios");

        IDataSet expectedDataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("expected_dataset.xml"));
        ITable expectedTable = expectedDataSet.getTable("comentarios");

        Assertion.assertEquals(expectedTable, currentTable);
    }
}
   @Test
    public void testCriarTopico() {
        driver.get("http://forum-web");

        
        WebElement linkLogin = driver.findElement(By.linkText("Login"));
        linkLogin.click();

        WebElement inputUsername = driver.findElement(By.id("username"));
        WebElement inputPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));

        inputUsername.sendKeys("usuario");
        inputPassword.sendKeys("senha");
        btnLogin.click();

       
        WebElement linkCreateTopic = driver.findElement(By.linkText("Create Topic"));
        linkCreateTopic.click();

        
        WebElement inputTitle = driver.findElement(By.id("title"));
        WebElement inputContent = driver.findElement(By.id("content"));
        WebElement btnCreate = driver.findElement(By.id("btnCreate"));

        inputTitle.sendKeys("Título do Tópico");
        inputContent.sendKeys("Conteúdo do Tópico");
        btnCreate.click();

        assertEquals("http://forum-web/viewTopic?id=1", driver.getCurrentUrl());
    }

    @Test
    public void testInserirComentario() {
        driver.get("http://forum-web");

     
        WebElement linkLogin = driver.findElement(By.linkText("Login"));
        linkLogin.click();

        // Preenche o formulário de login
        WebElement inputUsername = driver.findElement(By.id("username"));
        WebElement inputPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));

        inputUsername.sendKeys("usuario");
        inputPassword.sendKeys("senha");
        btnLogin.click();

      
        WebElement linkTopic = driver.findElement(By.linkText("Nome do Tópico"));
        linkTopic.click();

       
        WebElement inputComment = driver.findElement(By.id("comment"));
        WebElement btnComment = driver.findElement(By.id("btnComment"));

        inputComment.sendKeys("Conteúdo do Comentário");
        btnComment.click();

        assertTrue(driver.getPageSource().contains("Conteúdo do Comentário"));
    }
}