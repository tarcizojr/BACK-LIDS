package br.edu.ifpb.lids.TestesAutomatizados;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCadastroProjeto {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void timeSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cadastrodeProjeto() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1920, 1080));

        String urlMenu= driver.getCurrentUrl();
        assertEquals(urlMenu, "http://localhost:3000/");

        driver.findElement(By.cssSelector("a:nth-child(1) .p-button-label")).click();

        String urlListarProjeto = driver.getCurrentUrl();
        assertEquals(urlListarProjeto, "http://localhost:3000/projetos");

        driver.findElement(By.cssSelector(".p-button-raised")).click();

        String urlCriarProjeto = driver.getCurrentUrl();
        assertEquals(urlCriarProjeto, "http://localhost:3000/criarProjeto");

        driver.findElement(By.id("nomeDoProjeto")).click();
        driver.findElement(By.id("nomeDoProjeto")).sendKeys("Projeto Fenix 2.0");
        driver.findElement(By.cssSelector(".p-dropdown-trigger")).click();
        driver.findElement(By.cssSelector(".p-dropdown-item:nth-child(2)")).click();
        driver.findElement(By.id("objetivo")).click();
        driver.findElement(By.id("objetivo")).sendKeys(
                "Lorem ipsum dolor sit amet. A optio veritatis ut voluptatem galisum et maiores rerum et vero adipisci ut asperiores dolores. Sit laborum voluptatem ut molestiae tempora ad explicabo aliquam ut voluptate laboriosam.");
        driver.findElement(By.id("dataInicio")).click();
        driver.findElement(By.id("dataInicio")).sendKeys("09042020");
        driver.findElement(By.id("dataFim")).click();
        driver.findElement(By.id("dataFim")).sendKeys("09042023");
        driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();
        WebElement cardValid = driver.findElement(By.className("p-toast-summary"));
        assertEquals(cardValid.getText(), "Confirmado");

    }

    @Test
    public void cadastrodeProjetoComErro() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1920, 1080));

        String urlMenu= driver.getCurrentUrl();
        assertEquals(urlMenu, "http://localhost:3000/");

        driver.findElement(By.cssSelector("a:nth-child(1) .p-button-label")).click();

        String urlListarProjeto = driver.getCurrentUrl();
        assertEquals(urlListarProjeto, "http://localhost:3000/projetos");

        driver.findElement(By.cssSelector(".p-button-raised")).click();

        String urlCriarProjeto = driver.getCurrentUrl();
        assertEquals(urlCriarProjeto, "http://localhost:3000/criarProjeto");

        driver.findElement(By.cssSelector(".p-dropdown-trigger")).click();
        driver.findElement(By.cssSelector(".p-dropdown-item:nth-child(2)")).click();
        driver.findElement(By.id("objetivo")).click();
        driver.findElement(By.id("objetivo")).sendKeys(
                "Lorem ipsum dolor sit amet. A optio veritatis ut voluptatem galisum et maiores rerum et vero adipisci ut asperiores dolores. Sit laborum voluptatem ut molestiae tempora ad explicabo aliquam ut voluptate laboriosam.");
        driver.findElement(By.id("dataInicio")).click();
        driver.findElement(By.id("dataInicio")).sendKeys("09042020");
        driver.findElement(By.id("dataFim")).click();
        driver.findElement(By.id("dataFim")).sendKeys("09042023");
        driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();
        timeSleep();
        WebElement cardValid = driver.findElement(By.className("p-toast-summary"));
        assertEquals(cardValid.getText(), "Corrija os Erros a Baixo");
  timeSleep();
    }
}
