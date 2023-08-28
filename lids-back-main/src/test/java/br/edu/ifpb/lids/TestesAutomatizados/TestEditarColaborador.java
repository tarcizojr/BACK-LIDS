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
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestEditarColaborador {

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
    public void editarColaboradorSucesso () {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1920, 1080));

        WebDriverWait wait = new WebDriverWait(driver, 20); 

        driver.findElement(By.cssSelector("a:nth-child(2) .p-button-label")).click();

        String urlListarColaboradores = driver.getCurrentUrl();  
        assertEquals(urlListarColaboradores, "http://localhost:3000/colaboradores");

        driver.findElement(By.cssSelector(".card-butons > .p-button:nth-child(1)")).click();

        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("Guilherme Rodrigues");
        driver.findElement(By.id("dataNascimento")).click();
        driver.findElement(By.id("dataNascimento")).sendKeys("09042002");
        timeSleep();
        driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();
        driver.findElement(By.cssSelector(".p-confirm-dialog-accept")).click();
        WebElement cardValid = driver.findElement(By.className("p-toast-summary"));
        assertEquals(cardValid.getText(), "Confirmado");
        timeSleep();


        
    }
    
}
