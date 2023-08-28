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

public class TestDeletarColaborador {

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
  
  public void timeSleep(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    @Test
    public void deletarColaboradorSucesso() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1920, 1080));

    driver.findElement(By.cssSelector("a:nth-child(2) .p-button-label")).click();
    timeSleep();
    String urlListarColaboradores = driver.getCurrentUrl();  
    assertEquals(urlListarColaboradores, "http://localhost:3000/colaboradores");

    driver.findElement(By.cssSelector(".p-button:nth-child(2) path")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".p-button:nth-child(2) path"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    timeSleep();
    driver.findElement(By.cssSelector(".p-confirm-dialog-accept > .p-button-label")).click();

    WebElement cardValid = driver.findElement(By.className("p-toast-summary"));
    assertEquals(cardValid.getText(), "Confirmado");


    }

}
