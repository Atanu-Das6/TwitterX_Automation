package Project_FrameWork;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElements_Bookmark {
    public WebDriver webDriver;
    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]")
    WebElement bookmark;

    public PageElements_Bookmark(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public  void Bookmark_karo() {
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("arguments[0].click();", bookmark);
    }
}
