package br.edu.ifpb.lids.TestesAutomatizados;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCadastroComputador {
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
    public void cadastroComputador() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(1936, 1066));

        String urlMenu = driver.getCurrentUrl();
        assertEquals(urlMenu, "http://localhost:3000/");

        driver.findElement(By.cssSelector("a:nth-child(5) .p-button-label")).click();
        String urlListarEquipamentos = driver.getCurrentUrl();
        assertEquals(urlListarEquipamentos, "http://localhost:3000/equipamentos");
        timeSleep();
        driver.findElement(By.cssSelector(".p-button-raised:nth-child(1)")).click();
        String urlListarCriarEquipamentos = driver.getCurrentUrl();
        assertEquals(urlListarCriarEquipamentos, "http://localhost:3000/criarEquipamentos");
        timeSleep();
        driver.findElement(By.cssSelector(".input-texts:nth-child(3) > .input-dois:nth-child(2) .p-dropdown-label")).click();
        timeSleep();
        driver.findElement(By.cssSelector(".p-dropdown-item:nth-child(2)")).click();
        timeSleep();
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("Computador");
        driver.findElement(By.id("codigo")).click();
        driver.findElement(By.id("codigo")).sendKeys("157");
        driver.findElement(By.id("descricao")).click();
        driver.findElement(By.id("descricao")).sendKeys("Uma descrição");
        driver.findElement(By.cssSelector(".input-texts:nth-child(3) .p-placeholder")).click();
        driver.findElement(By.cssSelector(".p-dropdown-item:nth-child(1)")).click();
        driver.findElement(By.id("marca")).click();
        driver.findElement(By.id("marca")).sendKeys("Lenovo");
        driver.findElement(By.id("modelo")).click();
        driver.findElement(By.id("modelo")).sendKeys("AVR-45");
        driver.findElement(By.cssSelector(".input-dois:nth-child(3) .p-placeholder")).click();
        driver.findElement(By.cssSelector(".p-dropdown-item:nth-child(2)")).click();
        driver.findElement(By.id("tamanho")).click();
        driver.findElement(By.id("tamanho")).sendKeys("245gb");
        driver.findElement(By.id("processador")).click();
        driver.findElement(By.id("processador")).sendKeys("i5-3600KF");
        driver.findElement(By.cssSelector(".input-texts:nth-child(5) #seletor-tipo")).click();
        driver.findElement(By.cssSelector(".p-dropdown-item:nth-child(1)")).click();
        driver.findElement(By.id("capacidade")).click();
        driver.findElement(By.id("capacidade")).sendKeys("250gb");
        timeSleep();
        driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();
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
        driver.findElement(By.cssSelector(".p-confirm-dialog-accept")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".p-confirm-dialog-accept"));
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
