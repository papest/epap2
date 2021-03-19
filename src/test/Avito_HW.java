import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Avito_HW {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/peia/Webdriver/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.avito.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


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

        driver.findElement(By.className("main-text-2PaZG")).click();
        params3=driver.findElement(By.className("suggest-input-3p8yi"));
        params3.sendKeys("Владивосток");
        params3.click();
        driver.findElement(By.cssSelector("[data-marker=\"suggest(0)\"]")).click();
        WebElement checkbox= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[6]/div/div/span/div/div[3]/div[1]/label/span" ));
        if (!checkbox.isSelected()){
            checkbox.click();
        }
        driver.findElement(By.cssSelector("[data-marker=\"popup-location/save-button\"]")).click();

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

