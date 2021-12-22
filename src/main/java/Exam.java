import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Exam {

    protected WebDriver driver;
    private final By hesap = By.linkText("Hesabım");
    private final By favori = By.linkText("Favorilerim");
    private final By sepetim = By.linkText("Sepetim");

    private final By pantolan  = By.tagName("input");
    private final By dahaFazla = By.id("moreContentButton");
    private final By urunsec = By.className("o-productList__item");

    private final By beden = By.cssSelector("div[class ='m-variation'] span");
    private final By sepeteEkle = By.id("addBasket");

    private final By sepetKontrol = By.linkText("Sepetim");
    private final By alımFiyat = By.id("priceNew");
    private final By sepetFiyat = By.className("m-productPrice__salePrice");


    private final By adet = By.id("quantitySelect0");
    private final By sil = By.id("removeCartItemBtn0");

    public Exam(WebDriver driver){
        this.driver = driver;
    }

    public void setName(){
        WebElement nameSpace = driver.findElement(hesap);
        nameSpace.click();
    }

    public void setFavori(){
        WebElement nameSpace = driver.findElement(favori);
        nameSpace.click();
    }

    public void setSepetim(){
        WebElement nameSpace = driver.findElement(sepetim);
        nameSpace.click();

    }

    public void setText(String text) throws InterruptedException {
        WebElement namespace = driver.findElement(pantolan);
        namespace.click();
        namespace.sendKeys(text);
        namespace.sendKeys(Keys.ENTER);


        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 25000);");

        WebElement namespace2 = driver.findElement(dahaFazla);
        namespace2.click();

        WebElement namespace3 = driver.findElement(urunsec);
        namespace3.click();

        // Beden seçmeden sepete ekletmediği için beden seçiyorum.

        WebElement namespace4 = driver.findElement(beden);
        namespace4.click();

        Thread.sleep(3000);

        WebElement namespace5 = driver.findElement(sepeteEkle);
        namespace5.click();

        WebElement AlımFiyat = driver.findElement(alımFiyat);

        String alımFiyatText = AlımFiyat.getText();

        System.out.println(alımFiyatText);


        WebElement SepetKontrol = driver.findElement(sepetKontrol);
        SepetKontrol.click();


        WebElement SepetFiyat = driver.findElement(sepetFiyat);

        String sepetFiyatText = SepetFiyat.getText();

        System.out.println(sepetFiyatText);

        if (sepetFiyatText.equals(alımFiyatText)){
            System.out.println("Fiyatlar Aynı ");
        }
        else {
            System.out.println("Fiyatlar Farklı");
        }

        WebElement adetDegis = driver.findElement(adet);
        adetDegis.click();

        Select ikiAdetDegis = new Select(driver.findElement(adet));

        ikiAdetDegis.selectByVisibleText("2 adet");

        WebElement Sil = driver.findElement(sil);
        Sil.click();
    }
}
