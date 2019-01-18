package com.bars;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BmdDownloadTest extends BaseLoginTest {

    private static SearchPage searchPage = new SearchPage();
    private static SwitchWindow switchWindow = new SwitchWindow();
    private FilterBeforFillingTable filterBeforFillingTable = page(FilterBeforFillingTable.class);
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().to("test-results/reports");
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);

//    @Ignore
    @Test
    public void bmdDowload() throws IOException {
        open("/");
        //Страница поиска
        searchPage.searchFunction("Адміністрування шаблонів", "$RM_MAIN");
        switchWindow.switchToMainFrame();
        //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.furtherButtonClick();
        $x("//*[text()='DPT_STROK_PENS']").shouldBe(visible).click();
        Runtime.getRuntime().exec(".\\DownloadTemplate.exe");
        $(byCssSelector("a[data-qtip='скачати шаблон']")).shouldBe(visible).click();
        switchWindow.switchToDefaultContent();
    }
}

