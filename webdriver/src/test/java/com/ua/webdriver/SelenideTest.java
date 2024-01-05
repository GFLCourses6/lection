package com.ua.webdriver;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.ua.webdriver.manager.WebDriverHolder;
import com.ua.webdriver.model.Browsers;
import com.ua.webdriver.model.Row;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.ua.webdriver.Common.baseUrl;
import static com.ua.webdriver.Common.generateFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class SelenideTest {

    WebDriver webDriver;

    @BeforeEach
    public void setup(){
        webDriver = WebDriverHolder.getInstance(Browsers.CHROME).getDriver();
    }

    @AfterEach
    public void tearDown() {
        WebDriverHolder.getInstance(Browsers.CHROME).quitDriver();
        Selenide.closeWebDriver();
    }


    @Test
    void takeScreenshotTest()
            throws IOException {
        open(baseUrl);
        File file =
                ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File("SCREEN.png");
        FileUtils.copyFile(file, screenshotFile);
        assertTrue(screenshotFile.exists());
        BufferedImage bufferedImage = ImageIO.read(screenshotFile);
        assertNotNull(bufferedImage);
        assertEquals(BufferedImage.TYPE_INT_ARGB, bufferedImage.getType());
        closeWebDriver();
    }

    @Test
    void inputElementTest() {
        open(baseUrl + "/login");
        $(byId("username")).setValue("tom-smith");
        $("#password").setValue("SuperSecretPassword!");
        $("button.radius").click();
        $("#flash.success").shouldBe(Condition.visible);
    }

    @Test
    void dropDownTest() {
        open(baseUrl + "/dropdown");
        SelenideElement dropdown = $("#dropdown");
        dropdown.selectOption("Option 1");
        dropdown.getSelectedOption().shouldHave(Condition.value("1"));
    }

    @Test
    void uploadTest() {
        File file = generateFile();
        open(baseUrl + "/upload");
        $(byId("file-upload")).uploadFile(file);
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(Condition.text(file.getName()));
    }

    @Test
    void downloadTest()
            throws IOException {
        File file = generateFile();
        open(baseUrl + "/upload");
        $("#file-upload").uploadFile(file);
        $("#file-submit").click();

        open(baseUrl + "/download");
        String linkText = Objects.requireNonNull(file).getName();
        File downloadedFile = $(byLinkText(linkText)).download();
        assertTrue(FileUtils.contentEquals(downloadedFile, file));
    }

    @Test
    void tableParseTest() {
        open(baseUrl + "/tables");
        SelenideElement table = $("#table1");

        List<String> headers = table.$$("thead tr th")
                                    .shouldHave(CollectionCondition.size(6))
                                    .shouldHave(CollectionCondition.itemWithText(
                                            "Email"))
                                    .texts();

        List<Row> result = new ArrayList<>();

        for (SelenideElement row : table.$$("tbody tr").shouldHave(sizeGreaterThan(3))) {
            Map<String, String> rowDataMap = new HashMap<>();
            for (int i = 0; i < headers.size(); i++) {
                rowDataMap.put(headers.get(i), row.$$("td").texts().get(i));
            }
            result.add(new Row(rowDataMap));
        }
        System.out.println(result);
    }

    @Test
    void waitersTest() {
        open(baseUrl + "/dynamic_controls");
        $("#checkbox input").shouldBe(Condition.visible, Condition.not(Condition.checked));
        $$("button").find(Condition.exactText("Remove")).click();
        $(byText("loading")).shouldBe(Condition.visible);
        $(byText("loading")).shouldBe(Condition.hidden);
        $("#checkbox input").shouldNotBe(Condition.visible);
    }

//    @Test
    void dragAndDropTest() {
        open("https://www.pureexample.com/jquery-ui/basic-droppable.html");
        switchTo().frame($("iframe[id^='ExampleFrame-']"));
        actions().clickAndHold($(".square.ui-draggable"))
                 .moveToElement($(".squaredotted.ui-droppable"))
                 .release()
                 .build()
                 .perform();
        $("#info").shouldHave(Condition.text("dropped!"));
    }
}
