package com.bars;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

class FilterBeforFillingTable {
    void clearFilter(){
        $(byXpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Скасувати фільтри']")).shouldBe(visible).click();
    }
    void setUserFilter(String creditREF){
        $(byXpath("(//*[@class='x-tab-inner x-tab-inner-center'])[text()='Звичайні']")).shouldBe(visible).click();
        $(byXpath("//input[@name='ND']")).shouldBe(visible).setValue(creditREF);
    }
    void saveUserFilter(String filterName){
        $(byXpath("(//*[@class='x-btn-icon-el save_brown '])[2]")).shouldBe(visible).click();
        $(byXpath("//*[@name='filterName']")).shouldBe(visible).setValue(filterName);
        $(byXpath("(//*[text()='Зберегти']/following-sibling::*[@class='x-btn-icon-el save '])[2]")).shouldBe(visible).click();
        $(byXpath("//*[text()='Фільтр успішно додано']/following::*[text()='OK']")).shouldBe(visible).click();
    }
    void deleteUserFilter(String CooseRowByFilterName){
        $(byXpath("(//*[@class='x-tab-inner x-tab-inner-center'])[text()='Користувача']")).shouldBe(visible).click();
        String searchRowByFilterName = String.format("(//*[@class='x-grid-cell-inner '])[text()='%s']", CooseRowByFilterName);
        $(byXpath(searchRowByFilterName)).shouldBe(visible).click();
        $(byXpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Видалити']")).shouldBe(visible).click();
        $(byXpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Так']")).shouldBe(visible).click();
        $(byXpath("//*[text()='Рядок успішно видалено']")).shouldBe(visible).click();
        $(byXpath("//*[@class='x-tool x-box-item x-tool-default x-tool-before-title']")).shouldBe(visible).click();
    }
    void furtherButtonClick(){
        $(byXpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Далі']")).shouldBe(visible).click();
    }
}
