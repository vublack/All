package com.bars.generalСlasses;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FilterBeforFillingTable {
    public void clearFilter(){
        $x("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Скасувати фільтри']").shouldBe(visible).click();
    }
    public void setUserFilter(String creditREF, String tagName){
        $x("(//*[@class='x-tab-inner x-tab-inner-center'])[text()='Звичайні']").shouldBe(visible).click();
        $x("//input[@name='"+tagName+"']").shouldBe(visible).setValue(creditREF);
    }
    public void saveUserFilter(String filterName){
        $x("(//*[@class='x-btn-icon-el save_brown '])[2]").shouldBe(visible).click();
        $x("//*[@name='filterName']").shouldBe(visible).setValue(filterName);
        $x("(//*[text()='Зберегти']/following-sibling::*[@class='x-btn-icon-el save '])[2]").shouldBe(visible).click();
        $x("//*[text()='Фільтр успішно додано']/following::*[text()='OK']").shouldBe(visible).click();
    }
    public void userFilterTab(){
        $x("(//*[@class='x-tab-inner x-tab-inner-center'])[text()='Користувача']").shouldBe(visible).click();
    }
    public void chooseUserFilter(String cooseRowByFilterName){
        $x("(//*[@class='x-grid-cell-inner '])[text()='"+cooseRowByFilterName+"']").shouldBe(visible).click();
    }
    public void editButton(){
        $x("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='редагувати фільтр']").shouldBe(visible).click();
    }
    public void editUserFilter(String filterValue){
        $x("(//*[@class='x-grid-cell-inner '])[text()='=']").shouldBe(visible).click();
        $x("//*[text()='=']/following::*[@class ='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first']").shouldBe(visible).click();
        $x("//li[text()='СХОЖИЙ']").shouldBe(visible).click();
        $x("(//*[@class='x-btn-icon-el save_brown '])[1]").shouldBe(visible).click();
        $x("(//*[text()='Зберегти']/following-sibling::*[@class='x-btn-icon-el save '])[2]").shouldBe(visible).click();
        $x("//*[text()='Параметри фільтра успішно змінено']/following::*[text()='OK']").shouldBe(visible).click();
    /*

        SelenideElement value = $x("(//*[@class='x-grid-cell-inner '])[text()='"+filterValue+"'][2]").shouldBe(visible);
        executeJavaScript("arguments[0].textContent('style', 'display: inline-block')",value);
        rateValue.shouldBe(visible).setValue(rate);

        value.click();
        value.sendKeys("qewr");*/
    }
    public void deleteUserFilter(){
        $x("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Видалити']").shouldBe(visible).click();
        $x("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Так']").shouldBe(visible).click();
        $x("//*[text()='Рядок успішно видалено']").shouldBe(visible).click();
        $x("//*[@class='x-tool x-box-item x-tool-default x-tool-before-title']").shouldBe(visible).click();
    }
    public void furtherButtonClick(){
        $x("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Далі']").shouldBe(visible).click();
    }
}
