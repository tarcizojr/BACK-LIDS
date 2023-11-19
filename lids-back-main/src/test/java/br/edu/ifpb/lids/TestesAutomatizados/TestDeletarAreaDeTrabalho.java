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

public class TestDeletarAreaDeTrabalho {
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
    public void TestDeletarAreaDeTrabalho() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1936, 1066));

     String urlMenu = driver.getCurrentUrl();
    assertEquals(urlMenu, "http://localhost:3000/");

    driver.findElement(By.cssSelector("a:nth-child(3) .p-button-label")).click();

    String urlListarAreaDeTrabalho = driver.getCurrentUrl();
    assertEquals(urlListarAreaDeTrabalho, "http://localhost:3000/areasDeTrabalho");
    timeSleep();
    driver.findElement(By.cssSelector(".card-butons > .p-button:nth-child(3)")).click();
     timeSleep();
    driver.findElement(By.cssSelector(".p-confirm-dialog-accept > .p-button-label")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".p-confirm-dialog-accept > .p-button-label"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    timeSleep();
  }
}
