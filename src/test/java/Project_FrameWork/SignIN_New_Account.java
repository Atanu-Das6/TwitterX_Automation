package Project_FrameWork;

import Utill.ExtentReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners(ExtentReporter.class)


public class SignIN_New_Account  {
    public WebDriver webDriver;
    public  PageElements_SignInAccount pageElementsSignInAccount;

    public  String string;
    public Properties properties;




    @BeforeClass()
    public void Invoke_Broswer() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("Setup.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        string= properties.getProperty("url");
        String broswer = properties.getProperty("broswername");

        if (broswer.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote--allow-origins=*");
            webDriver = new ChromeDriver(chromeOptions);
            webDriver.get(string);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            String name = webDriver.getTitle();
            System.out.println("Title of the SITE " +name);


        }
        else {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver() ;
            webDriver.get(string);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String name = webDriver.getTitle();
            System.out.println("Title of the SITE " +name);
        }
    }


    @DataProvider (name = "data-provider")
    public Object[][] getUserData() {
        return new Object[][]{
                {"TestAutoma69", "JavaSelenium_Testng"},
                // Add more sets of data as needed
        };
    }
        //dataProvider = "data-provider"
        @Test (dataProvider = "data-provider",groups = "loginSetup")
          void Sign_in_accotn(String user,String pwd)  {
            pageElementsSignInAccount = new PageElements_SignInAccount(webDriver);
            pageElementsSignInAccount.Sign_CreateAccount(user,pwd);

        }
        @AfterClass
            void  End_session() throws IOException {

            Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(webDriver);

            ImageIO.write(Screenshot.getImage(), "jpg", new File(System.getProperty("user.dir")+"\\screenshots\\fullscreenLogin.jpg"));

           webDriver.close();

        }
}
