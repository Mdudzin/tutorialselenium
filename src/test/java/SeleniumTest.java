import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

  @Test
  public void openGooglePage() {

    WebDriver driver = getDriver("chrome");
    driver.manage().window().maximize();
    driver.get("https://www.google.com");
    // znalezienie przycisku
    WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Accept all']"));
    // klikniecie przycisku
    agreeButton.click();
    // znajdz pole wyszukiwania
    WebElement searchField = driver.findElement(By.name("q"));
    // wprowadz wartosc Selenium do pola
    searchField.sendKeys("Selenium");
    // zasymuluj nacisniecie przycisku Enter
    searchField.sendKeys(Keys.ENTER);
    // znalezc rezultat
    WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

    Assert.assertTrue(result.isDisplayed());
  }

  public WebDriver getDriver(String browser) {
    switch (browser) {
      case "chrome":
        String chromePath = "/home/dudzin/Projekty/tutorialselenium/src/main/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        return new ChromeDriver();
      case "firefox":
        String firefoxPath = "/home/dudzin/Projekty/tutorialselenium/src/main/resources/geckodriver";
        System.setProperty("webdriver.gecko.driver", firefoxPath);
        return new FirefoxDriver();
      default:
        throw new InvalidArgumentException("Invalid browser name");
    }
  }
}
