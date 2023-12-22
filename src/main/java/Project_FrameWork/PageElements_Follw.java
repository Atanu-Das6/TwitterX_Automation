package Project_FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageElements_Follw {

    public WebDriver webDriver;
    @FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement share;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")
    WebElement follow_link;

    public PageElements_Follw(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public  void Share_karo() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        List<WebElement> dots =  webDriver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));

        for (WebElement element : dots) {
            element.click();
            break;
        }
        follow_link.click();
        /*
        List<WebElement> dots_list=  webDriver.findElements(By.xpath("//div[@class='css-175oi2r r-16y2uox r-1wbh5a2']"));

        for (WebElement elements : dots_list) {
            System.out.println(elements.getText());
            if(elements.getText().matches("Follow @\\\\w+"))

            {
                WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(200)); // Set the timeout as needed
                 wait.until(ExpectedConditions.elementToBeClickable(elements));
                //elements.click();
                //js.executeScript("arguments[0].click();", elements);

                break;

            }
            break;
        }

        ////input[@dir='ltr']
        //copy_link.click();

         */
    }
}
