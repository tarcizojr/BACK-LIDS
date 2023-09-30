package br.edu.ifpb.lids.TestesAutomatizados;

import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {
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
    public void login() {
        driver.get("http://localhost:3000/login");
        driver.manage().window().setSize(new Dimension(1936, 1066));
        driver.findElement(By.cssSelector(".p-button-warning > .p-button-label")).click();
        String urlMenu = driver.getCurrentUrl();

        assertNotEquals(urlMenu, "http://localhost:3000/");
    }

}
