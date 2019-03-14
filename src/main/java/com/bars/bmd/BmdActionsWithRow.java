package com.bars.bmd;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BmdActionsWithRow {
    public void addRow(){
        $x("(//*[@class='x-grid-cell x-grid-td x-grid-cell-gridcolumn-1090 x-unselectable '])[2]").shouldBe(visible).click();
        $("a[data-qtip='Додати новий рядок']").shouldBe(visible).click();
        $x("(//*[@class='x-grid-cell-inner x-grid-cell-inner-row-numberer'])[text()='*']").shouldBe(visible).doubleClick();
        $x("(//*[@class = 'x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first'])[1]").shouldBe(visible).click();
        $(".x-boundlist-item").shouldBe(visible).click();

    }
    public void changeRow(String param){
        $x("(//*[@class = 'x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first'])[2]").shouldBe(visible).click();
        $x("(//*[@class='x-boundlist-list-ct x-unselectable'])[2]/div[4]").shouldBe(visible).click();
        $(byName("VALUE")).shouldBe(visible).setValue(param);
        $x("//*[text()='Зберегти']/ancestor::span[2]").shouldBe(visible).click();
        $x(".//*[text()='Оновлення даних']").shouldNotBe(visible);
        $x("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='OK']").shouldBe(visible).click();
    }
    public void chooseRow(String searchParam){
        $x("(//*[@class='x-grid-cell-inner '])[text()='"+searchParam+"']").shouldBe(visible).doubleClick();
    }
    public void DelRow(String searchParam){
        $x("(//*[@class='x-grid-cell-inner '])[text()='"+searchParam+"']").shouldBe(visible).click();
        $(by("data-qtip" , "Видалити вибраний рядок" )).shouldBe(visible).click();
        $x(".//*[text()='Видалення рядка']").shouldBe(visible).click();
        $x("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Так']").shouldBe(visible).click();
        $x("(//*[@class='x-header-text x-window-header-text x-window-header-text-default'])[text()='Видалення']").shouldBe(visible).click();
        $x("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='OK']").shouldBe(visible).click();
    }

}
