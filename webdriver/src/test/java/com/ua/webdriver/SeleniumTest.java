package com.ua.webdriver;

import com.ua.webdriver.manager.WebDriverHolder;
import com.ua.webdriver.model.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.ua.webdriver.Common.baseUrl;
import static com.ua.webdriver.Common.generateFile;
import static com.ua.webdriver.Common.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
@Disabled
class SeleniumTest {

    private final String url = "https://www.pureexample.com/jquery-ui/basic-droppable.html";
    private final By frame = byCssSelector("iframe[id^='ExampleFrame-']");
    private final By draggableElement = byCssSelector(".square.ui-draggable");
    private final By dragToElement =
            byCssSelector(".squaredotted.ui-droppable");
    private final By infoElement = By.id("info");

    WebDriver driver;

    private static final String EXTENSION_PATH =
            "src/main/resources/MultiPass-for-HTTP-basic-authentication.crx";
    private static final String EXTENSION_URL =
            "chrome-extension://enhldmjbphoeibbpdhmjkchohnidgnah/options.html";

    @BeforeEach
    public void setup() {
//        driver = WebDriverHolder.getInstance().getDriver();
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File(EXTENSION_PATH));

        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        driver = new ChromeDriver(chromeOptions);
        //        driver.get(EXTENSION_URL);
    }

    @AfterEach
    public void tearDown() {
        WebDriverHolder.getInstance(Browsers.CHROME).quitDriver();
    }

    @Test
    void testGoogleSearch() {
        driver.get(baseUrl);
    }

    @Test
    void takeScreenshotTest()
            throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File("SCREEN.png");
        FileUtils.copyFile(file, screenshotFile);
        assertTrue(screenshotFile.exists());
        BufferedImage bufferedImage = ImageIO.read(screenshotFile);
        assertNotNull(bufferedImage);
    }

    @Test
    void inputLoginElementTest() {
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();
        assertTrue(driver.findElement(By.cssSelector("#flash.success"))
                         .isDisplayed());
    }

    @Test
    void dropDownTest() {
        driver.get(baseUrl + "/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        String value =
                select.getAllSelectedOptions().get(0).getAttribute("value");
        assertEquals("1", value);
    }

    @Test
    void uploadTest() {
        File file = generateFile();
        upload(file);
        By selector = By.cssSelector("#uploaded-files");
        String text = driver.findElement(selector).getText();
        assertEquals(text.trim(), file.getName());
    }

    @Test
    void downloadTest()
            throws IOException {
        File file = generateFile();
        upload(file);
        File downloadedFile = getDownloadedFile(Objects.requireNonNull(file));
        assertTrue(FileUtils.contentEquals(downloadedFile, file));
    }

    private File getDownloadedFile(File file) {
        driver.get(baseUrl + "/download");
        driver.findElement(By.linkText(file.getName())).click();
        sleep(3000L);
        return new File("downloads", file.getName());
    }

    private void upload(File file) {
        driver.get(baseUrl + "/upload");
        String path = Objects.requireNonNull(file).getAbsolutePath();
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.cssSelector("#file-submit")).click();
    }

    @Test
    void tableTest() {
        driver.get(baseUrl + "/tables");

        WebElement table = driver.findElement(By.cssSelector("#table1"));
        List<WebElement> headers =
                table.findElements(By.cssSelector("thead tr th"));
        assertEquals(headers.size(), 6);
        assertTrue(headers.stream()
                          .map(WebElement::getText)
                          .toList()
                          .contains("Email"));
        List<String> headersText =
                headers.stream().map(WebElement::getText).toList();
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        assertTrue(rows.size() > 3);
        List<Map<String, String>> result = rows.stream()
                                               .map(row -> IntStream.range(0,
                                                                           headers.size())
                                                                    .boxed()
                                                                    .collect(
                                                                            Collectors.toMap(
                                                                                    headersText::get,
                                                                                    row.findElements(
                                                                                               By.cssSelector(
                                                                                                       "td"))
                                                                                       .stream()
                                                                                       .map(WebElement::getText)
                                                                                       .toList()::get,
                                                                                    (a, b) -> b)))
                                               .toList();
        result.forEach(r -> System.out.println(r));
    }

    @Test
    void waitersTest() {
        driver.get(baseUrl + "/dynamic_controls");

        WebElement element =
                driver.findElement(By.cssSelector("#checkbox input"));
        assertTrue(element.isDisplayed());
        assertFalse(element.isSelected());
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait webDriverWait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(visibilityOfElementLocated(By.id("loading")));
        webDriverWait.until(invisibilityOfElementLocated(By.id("loading")));
        assertEquals(driver.findElements(By.cssSelector("#checkbox input"))
                           .size(), 0);
    }

    @Test
    void drugAndProp() {
        driver.get(url);
        driver.switchTo().frame(driver.findElement(frame));

        WebElement draggable = driver.findElement(draggableElement);
        WebElement dragTo = driver.findElement(dragToElement);

        Actions actions = new Actions(driver);
        actions.moveToElement(draggable)
               .clickAndHold(draggable)
               .moveToElement(dragTo)
               .release(dragTo)
               .build()
               .perform();

        assertEquals(driver.findElement(infoElement).getText(), "dropped!");
    }

    @Test
    void dropTest() {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement From1 = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement To1 = driver.findElement(By.xpath("//*[@id='bank']/li"));
        WebElement From2 = driver.findElement(By.xpath("//*[@id='credit1']/a"));
        WebElement To2 = driver.findElement(By.xpath("//*[@id='loan']/li"));
        WebElement From3 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement To3 = driver.findElement(By.xpath("//*[@id='amt7']/li"));
        WebElement From4 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement To4 = driver.findElement(By.xpath("//*[@id='amt8']/li"));

        Actions act = new Actions(driver);

        act.dragAndDrop(From1, To1).build().perform();
        act.dragAndDrop(From2, To2).build().perform();
        act.dragAndDrop(From3, To3).build().perform();
        act.dragAndDrop(From4, To4).build().perform();

        if (driver.findElement(By.xpath("//a[contains(text(),'Perfect')]"))
                  .isDisplayed()) {
            System.out.println("Perfect Displayed !!!");
        } else {
            System.out.println("Perfect not Displayed !!!");
        }
    }
}
