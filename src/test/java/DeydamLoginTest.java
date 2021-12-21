import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeydamLoginTest {

    //Import web browser
    private ChromeDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //Locate where chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open chrome browser
        driver = new ChromeDriver();
        Thread.sleep(3000);
        //2. Input url
        driver.get("https://www.deydam.com/");
        //3. Maximize window
        driver.manage().window().maximize();
        //4. Get page title
        //5. Click on Sign-in button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div[6]/a")).click();
        Thread.sleep(3000);
    }

    @Test
    public void login() throws InterruptedException {
        //6. Input email address
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("kehinde20");
        Thread.sleep(2000);
        //7. Input password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password");
        Thread.sleep(2000);
        //8. Click on sign-in button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        //9. Click on drop-down arrow to access logout button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        Thread.sleep(2000);
        //9. Logout
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/div/div/a[3]/p")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        //10. Quit browser
        driver.quit();
    }
}
