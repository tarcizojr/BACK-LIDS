package br.edu.ifpb.lids.TestesAutomatizados;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCadastroColaborador {

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
  @DisplayName("Teste de Cadastro sem erros")
  public void cadastroColaboradorSucesso() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1920, 1080));

    WebDriverWait wait = new WebDriverWait(driver, 20);

    driver.findElement(By.cssSelector("a:nth-child(2) .p-button-label")).click();

    String urlListarColaboradores = driver.getCurrentUrl();
    assertEquals(urlListarColaboradores, "http://localhost:3000/colaboradores");

    driver.findElement(By.cssSelector(".p-button-raised:nth-child(1)")).click();

    String urlCadastrarColaboradores = driver.getCurrentUrl();
    assertEquals(urlCadastrarColaboradores, "http://localhost:3000/criarColaboradores");

    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Guilherme Rodrigues");

    driver.findElement(By.id("endereco")).sendKeys("Av.Carlinhos Maia");
    driver.findElement(By.id("email")).sendKeys("guilherme@gmail.com");
    driver.findElement(By.id("cidade")).sendKeys("Monteiro");

    driver.findElement(By.cssSelector("#seletor-estado > .p-dropdown-label")).click();
    driver.findElement(By.cssSelector(".p-dropdown-item")).click();

    driver.findElement(By.id("matricula")).sendKeys("202015020014");

    driver.findElement(By.id("dataNascimento")).click();
    driver.findElement(By.id("dataNascimento")).sendKeys("09042002");

    driver.findElement(By.cssSelector(".p-placeholder")).click();
    driver.findElement(By.cssSelector(".p-dropdown-item")).click();

    driver.findElement(By.id("linkCurriculo")).sendKeys("https://linklattes");

    driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();

    WebElement cardValid = driver.findElement(By.className("p-toast-summary"));
    assertEquals(cardValid.getText(), "Confirmado");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    WebElement cardValidSucess = driver.findElement(By.className("p-toast-summary"));
    assertEquals(cardValidSucess.getText(), "Sucesso");
    timeSleep();

    String urlListarAposCadastrarColaboradores = driver.getCurrentUrl();
    assertEquals(urlListarAposCadastrarColaboradores, "http://localhost:3000/colaboradores");

  }

  @Test
  @DisplayName("Teste de Cadastro com Campos Vazios")
  public void cadastroColaboradorCamposVazios() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1920, 1080));

    driver.findElement(By.cssSelector("a:nth-child(2) .p-button-label")).click();

    String urlListarColaboradores = driver.getCurrentUrl();
    assertEquals(urlListarColaboradores, "http://localhost:3000/colaboradores");

    driver.findElement(By.cssSelector(".p-button-raised:nth-child(1)")).click();

    String urlCadastrarColaboradores = driver.getCurrentUrl();
    assertEquals(urlCadastrarColaboradores, "http://localhost:3000/criarColaboradores");

    driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();
    WebElement cardValid = driver.findElement(By.className("p-toast-summary"));
    assertEquals(cardValid.getText(), "Corrija os Erros a Baixo");

    String urlListarAposCadastrarColaboradores = driver.getCurrentUrl();
    assertEquals(urlListarAposCadastrarColaboradores, "http://localhost:3000/criarColaboradores");

  }

  @Test
  @DisplayName("Teste de Cadastro com Email invalido")
  public void cadastroColaboradorEmailInvalido() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1920, 1080));

    driver.findElement(By.cssSelector("a:nth-child(2) .p-button-label")).click();

    String urlListarColaboradores = driver.getCurrentUrl();
    assertEquals(urlListarColaboradores, "http://localhost:3000/colaboradores");

    driver.findElement(By.cssSelector(".p-button-raised:nth-child(1)")).click();

    String urlCadastrarColaboradores = driver.getCurrentUrl();
    assertEquals(urlCadastrarColaboradores, "http://localhost:3000/criarColaboradores");

    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Guilherme");

    driver.findElement(By.id("endereco")).sendKeys("Av.Carlinhos Maia");
    driver.findElement(By.id("email")).sendKeys("guilherme2gmail.com");
    driver.findElement(By.id("cidade")).sendKeys("Monteiro");

    driver.findElement(By.cssSelector("#seletor-estado > .p-dropdown-label")).click();
    driver.findElement(By.cssSelector(".p-dropdown-item")).click();

    driver.findElement(By.id("matricula")).sendKeys("202015020014");

    driver.findElement(By.id("dataNascimento")).click();
    driver.findElement(By.id("dataNascimento")).sendKeys("09042002");

    driver.findElement(By.cssSelector(".p-placeholder")).click();
    driver.findElement(By.cssSelector(".p-dropdown-item")).click();

    driver.findElement(By.id("linkCurriculo")).sendKeys("https://linklattes");

    driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();

    WebElement cardValid = driver.findElement(By.className("p-toast-summary"));
    assertEquals(cardValid.getText(), "Corrija os Erros a Baixo");

    String urlListarAposCadastrarColaboradores = driver.getCurrentUrl();
    assertEquals(urlListarAposCadastrarColaboradores, "http://localhost:3000/criarColaboradores");

  }

}
