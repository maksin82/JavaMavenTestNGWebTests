import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebTest {

    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

    //TC_11_01
    @Test
    public void testHead() {
        // WebDriver driver = new FirefoxDriver();
        driver.get("http://www.99-bottles-of-beer.net/");

        WebElement header = driver.findElement(By.xpath("/html/body/div/div[1]/h1"));
        //String header1 = header.getText();
        Assert.assertEquals(header.getText(), "99 Bottles of Beer");

        //driver.quit();
    }

    //TC_11_02
    @Test
    public void testSubLanguage() {
        driver.get("http://www.99-bottles-of-beer.net/");

        WebElement lastItem = driver.findElement(By.xpath
                ("/html/body/div/div[2]/ul[1]/li[6]/a"));
        String value = lastItem.getText();
        Assert.assertEquals(value, ("Submit new Language").toUpperCase());
    }

    //TC_11_03
    @Test
    public void testMenuSubLang() {
        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");

        WebElement lastItem = driver.findElement(By.xpath
                ("/html/body/div/div[2]/ul[2]/li/a"));
        String value = lastItem.getText();
        Assert.assertEquals(value, "Submit New Language");
    }

    //TC_11_04
    @Test
    public void testMenuItem() {
        driver.get("http://www.99-bottles-of-beer.net/abc.html");

        WebElement header = driver.findElement(By.xpath
                ("/html/body/div/div[2]/ul[2]/li[1]/a"));
        String item = header.getText();
        Assert.assertEquals(item, "0-9");
    }

    //TC_11_06
    @Test
    public void testConfirmNames() {

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
    }

    //TC_11_07 что надпись об исключении красным цветом и с маленькой буквы
    @Test
    public void testInactive() {
        driver.get("http://www.99-bottles-of-beer.net/team.html");
        WebElement header = driver.findElement(By.xpath
                ("/html/body/div/div[3]/p[7]/font/b"));
        Assert.assertEquals(header.getText(), header.getText().toLowerCase());
        Assert.assertEquals(header.getCssValue("color"), "rgb(255, 0, 0)");
    }

    //TC_11_11
    @Test
    public void testErrorFild() {

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
    }

    //TC_11_12

    @Test
    public void testPrecondition() {

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
    }

    //TC_11_13
    @Test
    public void testText() {

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
    }

    //TC_11_14
    @Test
    public void testTable() {

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
    }

    //TC_11_15
    @Test
    public void testNoNewComments() {

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


    }

    //TC_11_21
    @Test
    public void testRedFontWiteBold() {
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
    }

    //TC_12_08
    /*Подтвердите, что решение на языке Shakespeare входит в топ 20 всех решений, в топ 10 решений на Esoteric Languages и в топ 6 решений-хитов. Но решение на языке Shakespeare не входит в список топовых решений на реальных языках программирования.
(Можно написать одним тестом, но так, чтобы все Asserts были в конце теста. Или можно написать отдельные тесты на каждый requirenment.)
    */
    @Test
    public void testTopShakespeare() {
        driver.get("http://www.99-bottles-of-beer.net/toplist.html");
        String shakespeare = "Shakespeare";

        driver.findElement(By.xpath("//a[text() = 'Top Rated']")).click();
        List<WebElement> topRated = driver.findElements(By.xpath("//tr//a"));
        List<String> listRated = new ArrayList<>();
        for (WebElement element : topRated) {
            listRated.add(element.getText());
        }
        boolean isExists20 = (listRated.subList(0, 20)).contains(shakespeare);

        driver.findElement(By.xpath
                ("//a[text() = 'Top Rated Esoteric']")).click();
        List<WebElement> esotericLanguages = driver.findElements(By.xpath("//tr//a"));
        List<String> listEsoteric = new ArrayList<>();
        for (WebElement element : esotericLanguages) {
            listEsoteric.add(element.getText());
        }
        boolean isExists10 = (listEsoteric.subList(0, 10)).contains(shakespeare);

        driver.findElement(By.xpath
                ("//a[text() = 'Top Hits']")).click();
        List<WebElement> topHits = driver.findElements(By.xpath("//tr//a"));
        List<String> listHits = new ArrayList<>();
        for (WebElement element : topHits) {
            listHits.add(element.getText());
        }
        boolean isExists6 = (listHits.subList(0, 6)).contains(shakespeare);

        Assert.assertTrue(isExists20);
        Assert.assertTrue(isExists10);
        Assert.assertTrue(isExists6);
    }
    // TC_12_10
       /*
    Подтвердите, что самое большое количество комментариев для решений на языке Java имеет версия “object-oriented version”
      */

    @Test
    public void testJavaComments() {
        driver.get("http://www.99-bottles-of-beer.net/j.html");

        List<WebElement> languageName = driver.findElements(By.xpath("//tr//a"));
        List<String> languageNames = new ArrayList<>();
        for (WebElement element : languageName) {
            languageNames.add(element.getText());
        }
        List<WebElement> numberOfComment = driver.findElements(By.xpath("//tr//td[4]"));
        List<Integer> numberOfComments = new ArrayList<>();
        for (WebElement element : numberOfComment) {
            numberOfComments.add(Integer.valueOf(element.getText()));
        }

        List<Integer> numberOfCommentsForSort = new ArrayList<>(numberOfComments);

        Collections.sort(numberOfCommentsForSort);
        int max = numberOfCommentsForSort.get(numberOfCommentsForSort.size() - 1);
        int n = numberOfComments.indexOf(max);

        Assert.assertEquals(languageNames.get(n), "Java");
    }
}


