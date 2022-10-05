import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectCheck {

  public boolean checkOption(String optionText, WebElement element) {
    Select select = new Select(element);
    List<WebElement> options = select.getOptions();
    for (WebElement option : options) {
      if (option.getText().equals(optionText)) {
        return true;
      }
    }
    return false;
  }
}
