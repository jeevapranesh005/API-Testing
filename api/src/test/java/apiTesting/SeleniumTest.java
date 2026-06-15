package apiTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {
	@Test
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://jsonplaceholder.typicode.com/");

            String currentURL = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentURL);

            Assert.assertTrue(currentURL.contains("jsonplaceholder"));
        }
        finally {
            driver.quit();
        }
    }
}