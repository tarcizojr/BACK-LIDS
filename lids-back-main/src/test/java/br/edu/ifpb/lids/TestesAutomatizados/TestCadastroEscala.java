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

public class TestCadastroEscala {
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
   public void TestCadastroEscala() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1936, 1066));

     String urlMenu = driver.getCurrentUrl();
    assertEquals(urlMenu, "http://localhost:3000/");
    timeSleep();
    driver.findElement(By.cssSelector("a:nth-child(6) > #bt")).click();

    String urlListarEscala = driver.getCurrentUrl();
    assertEquals(urlListarEscala, "http://localhost:3000/escalas");


    driver.findElement(By.cssSelector(".p-button-raised:nth-child(1)")).click();
    
    String urlCriarEscala = driver.getCurrentUrl();
    assertEquals(urlCriarEscala, "http://localhost:3000/cadastrarEscala");
    timeSleep();
    driver.findElement(By.cssSelector(".p-dropdown-trigger")).click();
    driver.findElement(By.cssSelector(".p-dropdown-item:nth-child(2)")).click();
    driver.findElement(By.id("cargaHoraria")).click();
    driver.findElement(By.id("cargaHoraria")).sendKeys("12");
    driver.findElement(By.cssSelector("#horarioEntraday > .p-inputtext")).click();
    driver.findElement(By.cssSelector("#horarioEntraday > .p-inputtext")).sendKeys("04:30");
    driver.findElement(By.cssSelector("#horarioSaida > .p-inputtext")).click();
    driver.findElement(By.cssSelector("#horarioSaida > .p-inputtext")).sendKeys("22:00");
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
