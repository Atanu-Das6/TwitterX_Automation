package Project_FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageElements_UnFollw {
    public WebDriver webDriver;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")
    WebElement follow_link;

    public PageElements_UnFollw(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public  void UnFollow_karo() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        List<WebElement> dots = webDriver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));

        for (WebElement element : dots) {
            element.click();
            break;
        }
        follow_link.click();
        Thread.sleep(100);
        for (WebElement element : dots) {
            element.click();
            break;
        }
        follow_link.click();

    }
}
