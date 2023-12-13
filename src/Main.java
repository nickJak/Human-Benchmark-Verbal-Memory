import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static WebDriver driver = new FirefoxDriver();
    static Actions actions = new Actions(driver);

    public static void main(String[] args) throws InterruptedException {
        String username = "username";
        String password = "password";

        driver.get("https://humanbenchmark.com/");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/a[2]")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/form/p[3]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/tests/verbal-memory']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Start']")).click(); //Click Start Button

        //Initialize List
        List<String> wordList = new ArrayList<>();
        String currentWord = "";

        for(int i = 0; i < 1000; i++)
        {
            currentWord = driver.findElement(By.xpath("/html/body/div/div/div[4]/div[1]/div/div/div/div[2]/div")).getText();

            if(!wordList.contains(currentWord))
            {
                wordList.add(currentWord);
                actions.moveToElement(driver.findElement(By.xpath("//*[text()='NEW']"))).click().perform();
            } else if (wordList.contains(currentWord))
            {
                actions.moveToElement(driver.findElement(By.xpath("//*[text()='SEEN']"))).click().perform();
            }
        }




    }
}