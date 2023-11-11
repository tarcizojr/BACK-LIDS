package br.edu.ifpb.lids.TestesAutomatizados;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEditarEquipamento {
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
  public void editarEquipamento() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1936, 1066));
    String urlMenu = driver.getCurrentUrl();
    assertEquals(urlMenu, "http://localhost:3000/");
    driver.findElement(By.cssSelector("a:nth-child(5) .p-button-label")).click();
    String urlListarEquipamentos = driver.getCurrentUrl();
    assertEquals(urlListarEquipamentos, "http://localhost:3000/equipamentos");
    timeSleep();
    driver.findElement(By.cssSelector(".card:nth-child(1) .p-button:nth-child(1) path")).click();
    timeSleep();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("2");
    driver.findElement(By.cssSelector(".p-button-raised > .p-button-label")).click();
    timeSleep();
    driver.findElement(By.cssSelector(".p-confirm-dialog-accept > .p-button-label")).click();
    timeSleep();
  }

}
