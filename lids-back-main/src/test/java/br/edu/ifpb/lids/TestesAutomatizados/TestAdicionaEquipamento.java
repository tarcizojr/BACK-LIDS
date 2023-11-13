package br.edu.ifpb.lids.TestesAutomatizados;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAdicionaEquipamento {
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
    driver.findElement(By.cssSelector("a:nth-child(3) .p-button-label")).click();
    timeSleep();
    driver.findElement(By.cssSelector(".p-button:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".p-button-raised:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".card-butons > .p-button")).click();
      timeSleep();
    driver.findElement(By.cssSelector(".p-menuitem:nth-child(5) .p-menuitem-text")).click();
      timeSleep();

}
}
