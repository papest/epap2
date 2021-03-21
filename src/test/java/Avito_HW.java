import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Avito_HW {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/Webdriver/chromedriver");
        // Драйвер для Windows
        //  System.setProperty("webdriver.chrome.driver","src/test/resources/Webdriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.avito.ru/");


        Select category= new Select(driver.findElement(By.id("category")));
        category.selectByValue("99");

        WebElement params1=driver.findElement(By.id("search"));
        params1.sendKeys("Принтер");

        WebElement params2= driver.findElement(By.className("main-text-2PaZG"));
        params2.click();

        WebElement params3=driver.findElement(By.className("suggest-input-3p8yi"));
        params3.sendKeys("Владивосток");
        params3.click();
        WebElement region=driver.findElement(By.cssSelector("[data-marker=\"suggest(0)\"]"));
        region.click();
        driver.findElement(By.cssSelector("[data-marker=\"popup-location/save-button\"]")).click();


        WebElement checkbox= driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[1]/div/div[2]/div[1]/form/div[8]/div/div/div/div/div/div/label" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        if (!checkbox.isSelected()){
                checkbox.click();
        }
        WebElement saveButton=driver.findElement(By.cssSelector("[data-marker=\"search-filters/submit-button\"]"));
        saveButton.click();

        Select price= new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div[1]/div[2]/select")));
        price.selectByVisibleText("Дороже");

        List<WebElement> items= driver.findElements(By.cssSelector("[data-marker=\"item\"]"));
        int i=items.size();
        int k=3;
        if (k>i){ k=i; }

        for (int j=0;j<k;j++){
            System.out.println("Название принтера "+items.get(j).findElement(By.className("iva-item-titleStep-2bjuh")).getText()+" Цена:"+items.get(j).findElement(By.className("iva-item-priceStep-2qRpg")).getText());
        }

        driver.quit();
    }
    }

