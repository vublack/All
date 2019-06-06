package com.bars;

import com.bars.bmd.BmdActionsWithRow;
import com.bars.generalСlasses.FilterBeforFillingTable;
import com.bars.generalСlasses.SearchPage;
import com.bars.generalСlasses.SwitchWindowOrFrame;
import com.bars.helperClasses.DBoperation;
import com.bars.helperClasses.ReadingFromFile;
import com.codeborne.selenide.CollectionCondition;
import org.junit.Test;
import org.openqa.selenium.By;

import java.sql.SQLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MetadatabaseTest extends BaseLoginTest {
    private static SearchPage searchPage = new SearchPage();
    private static SwitchWindowOrFrame switchWindowOrFrame = new SwitchWindowOrFrame();
    private FilterBeforFillingTable filterBeforFillingTable = page(FilterBeforFillingTable.class);
    private BmdActionsWithRow bmdActionsWithRow = page(BmdActionsWithRow.class);

//   @Ignore
    @Test
    public void bmdFilterBefor() {
        searchPage.searchFunction("Портфель РОБОЧИХ кредитів ЮО", "1819");
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
    }

//    @Ignore
    @Test
    public void bmdRows() {
        //Страница поиска
        searchPage.searchFunction("FOREX. Довідник спецпараметрів рахунків", "1679");
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
        }
}

