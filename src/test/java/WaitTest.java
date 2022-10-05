import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class WaitTest {

  WebDriver driver;

  @Test
  public void waitTest() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
    driver.findElement(By.id("clickOnMe")).click();
//    Thread.sleep(5000);
    FluentWait<WebDriver> wait = new FluentWait<>(driver);
    wait.ignoring(NoSuchElementException.class);
    wait.withTimeout(Duration.ofSeconds(10));
    wait.pollingEvery(Duration.ofSeconds(1));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
    driver.findElement(By.cssSelector("p"));
  }
}
