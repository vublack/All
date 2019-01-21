package com.bars;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MetadatabaseTest extends BaseLoginTest {
    private static LoginPage loginPage = new LoginPage();
    private static SearchPage searchPage = new SearchPage();
    private static SwitchWindow switchWindow = new SwitchWindow();
    private FilterBeforFillingTable filterBeforFillingTable = page(FilterBeforFillingTable.class);
    private BmdActionsWithRow bmdActionsWithRow = page(BmdActionsWithRow.class);
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().to("test-results/reports");
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(false);

//   @Ignore
    @Test
    public void bmdFilterBefor(){
//        open("/");
        searchPage.searchFunction("Портфель РОБОЧИХ кредитів ЮО", "$RM_UCCK");
        switchWindow.switchToMainFrame();
        //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter("564", "ND");
        filterBeforFillingTable.saveUserFilter("564");
        filterBeforFillingTable.userFilterTab();
        filterBeforFillingTable.chooseUserFilter("564");
        filterBeforFillingTable.editButton();
        filterBeforFillingTable.editUserFilter("564");
        filterBeforFillingTable.userFilterTab();
        filterBeforFillingTable.chooseUserFilter("564");
        filterBeforFillingTable.deleteUserFilter();
//        switchWindow.switchToDefaultContent();
    }

//    @Ignore
    @Test
    public void bmdRows() {
//        open("/");

        //Страница поиска
        searchPage.searchFunction("FOREX. Довідник спецпараметрів рахунків", "$RM_WFRX");
        switchWindow.switchToMainFrame();

            //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.furtherButtonClick();
        // !!!!Довідник спецпараметрів!!!!-!!!!Додавання рядка!!!!!

        bmdActionsWithRow.addRow();
        bmdActionsWithRow.changeRow("99A");

        // !!!!Довідник спецпараметрів!!!!-!!!!!Редагування рядка!!!!!
        bmdActionsWithRow.chooseRow("99A");
        bmdActionsWithRow.changeRow("98A");

        //!!!!Довідник спецпараметрів!!!!-!!!!Видалення рядка!!!!
        bmdActionsWithRow.DelRow("98A");
//        switchWindow.switchToDefaultContent();
        }

//    @Ignore
    @Test
    public void bmdChko()  {
//        open("/");
        //Страница поиска
        searchPage.searchFunction("Ліміти.", "$RM_OVRW");
        switchWindow.switchToMainFrame();

        $(By.xpath("(//*[@class='x-grid-cell-inner x-grid-cell-inner-row-numberer'])[text()='2']")).shouldBe(visible).click();
        String OverdraftLimWindow = getWebDriver().getWindowHandle();
        $(By.xpath("//*[@class='x-btn-icon-el INSERT ']")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(By.xpath("//input[@name='X']")).shouldBe(visible).setValue("01.01.2018");
        $(byText("Виконати")).click();
        $(byText("Далі")).click();
        String netCreditTurnover = getWebDriver().getWindowHandle();
        $$(By.xpath("//*[@class='x-grid-cell-inner ']")).shouldBe(CollectionCondition.sizeGreaterThanOrEqual(12));
        String Result = $(By.xpath("(//tfoot/tr/td/div)[10]")).shouldHave(text("41")).getText();
        System.out.println("Ркзультат: " + Result);
        switchWindow.closeWindow(netCreditTurnover );
        switchWindow.switchToOldWindow(OverdraftLimWindow);
//        switchWindow.switchToDefaultContent();
     }
}

