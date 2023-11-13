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
import org.openqa.selenium.interactions.Actions;

public class TestCadastroAreaDeTrabalho {
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
    public void TestCadastroAreaDeTrabalho() {
    
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1936, 1066));

    String urlMenu = driver.getCurrentUrl();
    assertEquals(urlMenu, "http://localhost:3000/");

    driver.findElement(By.cssSelector("a:nth-child(3) > #bt")).click();
    
    String urlListarAreaDeTrabalho = driver.getCurrentUrl();
    assertEquals(urlListarAreaDeTrabalho, "http://localhost:3000/areasDeTrabalho");

    driver.findElement(By.cssSelector(".p-button-raised:nth-child(1)")).click();

    String urlCriarAreaDeTrabalho = driver.getCurrentUrl();
    assertEquals(urlCriarAreaDeTrabalho, "http://localhost:3000/criarAreaDeTrabalho");
    timeSleep();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Area 1");
    driver.findElement(By.id("codigo")).click();
    driver.findElement(By.id("codigo")).sendKeys("123");
    driver.findElement(By.id("descricao")).click();
    driver.findElement(By.id("descricao")).sendKeys("uma descrição");
    timeSleep();
    driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();
    timeSleep();
    driver.findElement(By.cssSelector(".p-confirm-dialog-accept > .p-button-label")).click();
    timeSleep();
        {
            WebElement element = driver.findElement(By.cssSelector(".p-button-raised > .p-button-label"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        timeSleep();
    }
}
