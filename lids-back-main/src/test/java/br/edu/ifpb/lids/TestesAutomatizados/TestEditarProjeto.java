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

public class TestEditarProjeto {
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
    public void editarProjeto() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1936, 1066));
     String urlMenu = driver.getCurrentUrl();
    assertEquals(urlMenu, "http://localhost:3000/");
    timeSleep();
    driver.findElement(By.cssSelector("a:nth-child(1) .p-button-label")).click();
    String urlListarProjeto = driver.getCurrentUrl();
    assertEquals(urlListarProjeto, "http://localhost:3000/projetos");
    timeSleep();
    driver.findElement(By.cssSelector(".p-button:nth-child(1) > svg")).click();
    driver.findElement(By.id("nomeDoProjeto")).click();
    driver.findElement(By.id("nomeDoProjeto")).sendKeys("2.0");
    driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();
    driver.findElement(By.cssSelector(".p-confirm-dialog-accept")).click();
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

