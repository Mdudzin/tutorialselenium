import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewWindowTest {

  @Test
  public void testNewWindow() {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
    String currentWindow = driver.getWindowHandle();
    driver.findElement(By.id("newPage")).click();
    Set<String> windowNames = driver.getWindowHandles();
    for (String window : windowNames) {
      if (!window.equals(currentWindow)) {
        driver.switchTo().window(window);
      }
    }
//    driver.findElement(By.name("q")).sendKeys("Selenium");
//    driver.switchTo().window(currentWindow);
//    driver.findElement(By.name("fname")).sendKeys("Maciej");
  }
}
