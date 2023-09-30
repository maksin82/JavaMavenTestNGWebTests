import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {

    //TC_11_01
    @Test
    public void testHead() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/");

        WebElement header = driver.findElement(By.xpath("/html/body/div/div[1]/h1"));
        String header1 = header.getText();
        Assert.assertEquals(header1, "99 Bottles of Beer");

        driver.quit();
    }

    //TC_11_02
    @Test
    public void testSubLanguage() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/");

        WebElement lastItem = driver.findElement(By.xpath
                ("/html/body/div/div[2]/ul[1]/li[6]/a"));
        String value = lastItem.getText();
        Assert.assertEquals(value, ("Submit new Language").toUpperCase());

        driver.quit();
    }

    //TC_11_03
    @Test
    public void testMenuSubLang() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

        WebElement lastItem = driver.findElement(By.xpath
                ("/html/body/div/div[2]/ul[2]/li/a"));
        String value = lastItem.getText();
        Assert.assertEquals(value, "Submit New Language");

        driver.quit();
    }

    //TC_11_04
    @Test
    public void testMenuItem() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/abc.html");

        WebElement header = driver.findElement(By.xpath
                ("/html/body/div/div[2]/ul[2]/li[1]/a"));
        String item = header.getText();
        Assert.assertEquals(item, "0-9");

        driver.quit();
    }

    //TC_11_06
    @Test
    public void testConfirmNames() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/team.html");

        WebElement headerName1 = driver.findElement(By.xpath
                ("/html/body/div/div[3]/h3[1]"));
        String name1 = headerName1.getText();
        Assert.assertEquals(name1, "Oliver Schade");
        WebElement headerName2 = driver.findElement(By.xpath
                ("/html/body/div/div[3]/h3[2]"));
        String name2 = headerName2.getText();
        Assert.assertEquals(name2, "Gregor Scheithauer");
        WebElement headerName3 = driver.findElement(By.xpath
                ("/html/body/div/div[3]/h3[3]"));
        String name3 = headerName3.getText();
        Assert.assertEquals(name3, "Stefan Scheler");

        driver.quit();
    }

    //TC_11_07 что надпись об исключении красным цветом


    //TC_11_11
    @Test
    public void testErrorFild() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

        WebElement serchButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/p/input[8]"));
        serchButton.click();

        WebElement header1 = driver.findElement(By.xpath
                ("/html/body/div/div[3]/p/b/u"));
        String item1 = header1.getText();
        Assert.assertEquals(item1, "Error:");

        WebElement header = driver.findElement(By.xpath
                ("/html/body/div/div[3]/p"));
        String item = header.getText();
        Assert.assertEquals(item, "Error: Precondition failed - Incomplete Input.");

        driver.quit();
    }

    //TC_11_12

    @Test
    public void testPrecondition() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

        WebElement serchButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/p/input[8]"));
        serchButton.click();


        WebElement header = driver.findElement(By.xpath
                ("/html/body/div/div[3]/p"));
        String item = header.getText();
        String punct = "";
        String word = "";
        if (item.contains(":") && item.contains("-") && item.contains(".")) {
            punct = "true";
        }
        Assert.assertEquals(punct, "true");


        if (item.contains("Error") && item.contains("Precondition")
                && item.contains("Incomplete") && item.contains("Input") && item.contains("failed")) {
            word = "true";
        }
        Assert.assertEquals(word, "true");
        driver.quit();
    }

    //TC_11_13
    @Test
    public void testText() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

        WebElement text = driver.findElement(By.xpath
                ("/html/body/div/div[3]/ul/li[1]"));
        String text1 = text.getText();
        Assert.assertEquals(text1, "IMPORTANT: Take your time! The more " +
                "carefully you fill out this form (especially the language name " +
                "and description), the easier it will be for us and the faster " +
                "your language will show up on this page. We don't have the time" +
                " to mess around with fixing your descriptions etc. Thanks for " +
                "your understanding.");

        driver.quit();
    }

    //TC_11_14
    @Test
    public void testTable() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/");

        WebElement button = driver.findElement(By.xpath
                ("/html/body/div/div[2]/ul[1]/li[2]/a"));
        button.click();
        WebElement element1 = driver.findElement(By.xpath
                ("/html/body/div/div[3]/table/tbody/tr[1]/th[1]"));
        String elementLang = element1.getText();
        Assert.assertEquals(elementLang, "Language");

        WebElement element2 = driver.findElement(By.xpath
                ("/html/body/div/div[3]/table/tbody/tr[1]/th[2]"));
        String elementAuthor = element2.getText();
        Assert.assertEquals(elementAuthor, "Author");

        driver.quit();

    }

    //TC_11_15
    @Test
    public void testNoNewComments() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/");

        WebElement buttonTopList = driver.findElement(By.xpath
                ("/html/body/div/div[2]/ul[1]/li[4]/a"));
        buttonTopList.click();
        WebElement buttonNewComm = driver.findElement(By.xpath
                ("/html/body/div/div[2]/ul[2]/li[7]/a"));
        buttonNewComm.click();

        WebElement header = driver.findElement(By.xpath
                ("/html/body/div/div[3]/p"));
        String value = header.getText();
        Assert.assertEquals(value, "");

        driver.quit();
    }

    //TC_11_21
    @Test
    public void testRedFontWiteBold() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

        WebElement header = driver.findElement(By.xpath
                ("/html/body/div/div[3]/ul/li[1]/span/b"));
        String color = header.getCssValue("background-color");
        String fontColor = header.getCssValue("color");
        String fontBold = header.getTagName();
        String letterCapital = header.getText();

        Assert.assertEquals(fontColor, "rgb(255, 255, 255)");
        Assert.assertEquals(fontBold, "b");
        Assert.assertEquals(letterCapital, letterCapital.toUpperCase());
        Assert.assertEquals(color, "rgba(0, 0, 0, 0)");

        driver.quit();
    }
}


