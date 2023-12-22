package Project_FrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElements_Like {
    public  WebDriver webDriver;
    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/span[1]/span[1]/span[1]")
    WebElement love;

   public PageElements_Like(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public  void Like_karo() {
       love.click();
    }
}
