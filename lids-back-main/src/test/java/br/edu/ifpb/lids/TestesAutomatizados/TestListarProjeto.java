package br.edu.ifpb.lids.TestesAutomatizados;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestListarProjeto {

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
  public void listarProjetoSucesso() {
     driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1920, 1080));

        String urlMenu= driver.getCurrentUrl();
        assertEquals(urlMenu, "http://localhost:3000/");

        driver.findElement(By.cssSelector("a:nth-child(1) .p-button-label")).click();
        timeSleep();

        String urlListarProjeto = driver.getCurrentUrl();
        assertEquals(urlListarProjeto, "http://localhost:3000/projetos");
  }
    
}