import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Avito_HW {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/webdriver/chromedriver");
        // Драйвер для Windows
        //  System.setProperty("webdriver.chrome.driver","src/test/resources/webdriver/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.avito.ru/");

        String id="category";
        Select category= new Select(driver.findElement(By.id(id)));
        String Value="99";
        category.selectByValue(Value);



        String printer= "[type=\"text\"][data-marker=\"search-form/suggest\"]";
        WebElement search=driver.findElement(By.cssSelector(printer));
        String sendKeys="Принтер";
        search.sendKeys(sendKeys);

        String searchForm="[data-marker=\"search-form/region\"]";
        WebElement param=driver.findElement(By.cssSelector(searchForm));
        param.click();


        String city="[placeholder=\"Город, регион или Россия\"]";
        WebElement params3=driver.findElement(By.cssSelector(city));
        sendKeys="Владивосток";
        params3.sendKeys(sendKeys);
        params3.click();
        sleep(1000);
        String cssSelector="[data-marker=\"suggest(0)\"]";
        WebElement region=driver.findElement(By.cssSelector(cssSelector));
        region.click();
        cssSelector="[data-marker=\"popup-location/save-button\"]";
        driver.findElement(By.cssSelector(cssSelector)).click();


        String xpath="//*[text()=\"С Авито Доставкой\"]";
        WebElement checkbox= driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        if (!checkbox.isSelected()){
                checkbox.click();
        }
        cssSelector="[data-marker=\"search-filters/submit-button\"]";
        WebElement saveButton=driver.findElement(By.cssSelector(cssSelector));
        saveButton.click();

        xpath="//div[2]/select";
        Select price= new Select(driver.findElement(By.xpath(xpath)));
        String selectVisibleText="Дороже";
        price.selectByVisibleText(selectVisibleText);

        cssSelector="[data-marker=\"item\"]";
        List<WebElement> items= driver.findElements(By.cssSelector(cssSelector));
        String printerName="h3[itemprop=\"name\"]";
        String printerPrice="[data-marker=\"item-price\"]";
        int i=items.size();
        int k=3;
        if (k>i){ k=i; }

        for (int j=0;j<k;j++){
            System.out.println("Название принтера "
                    +items.get(j).findElement(By.cssSelector(printerName)).getText()+
                    " Цена:"+items.get(j).findElement(By.cssSelector(printerPrice)).getText());
        }

        driver.quit();
    }
    }

