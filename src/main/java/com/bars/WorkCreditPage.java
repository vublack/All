package com.bars;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.StringContains.containsString;


class WorkCreditPage {

    void chooseCredit(String refCredit){
        $(byXpath("//*[text()='"+refCredit+"']")).shouldBe(visible).click();
    }
    void buildRepaymentSchedule(){
        $(byXpath("//a[@data-qtip='КД: Побудова ГПК для обраного КД']")).shouldBe(visible).click();
    }
    void getTableName(){
        System.out.println($("#mainReferenceGrid_header_hd").shouldBe(visible).getText());
    }
    void matchingSumInGPK(String sumCredit){
        String repaymentOfDebt = $(byXpath("(//tfoot/tr/td/div)[5]")).shouldBe(visible).shouldHave(text(sumCredit)).getText();
        System.out.println("Сума погашення осн. боргу: " + repaymentOfDebt);
    }
    void eventsTimetableOfBriefcaseButton(){
        $(byXpath("//a[@data-qtip='Події в КП']")).shouldBe(visible).click();
    }
    void chooseInterval(String day){
        $(byXpath("//input[@name ='B']")).shouldBe(visible).setValue(day);
        $(byXpath("//input[@name ='E']")).shouldBe(visible).setValue(day);
        $(byXpath("(//*[@class= 'x-btn-inner x-btn-inner-center'])[text()='Виконати']")).shouldBe(visible).click();
    }
    void progressBar(){
        $(byXpath("//*[@class = 'x-mask-msg-text']")).shouldNotBe(visible);
    }
    void checkEventsTimetableOfBriefcase(String expectedNum){
        List<SelenideElement> eventsTimetable = $$(byXpath("//div[@class='x-grid-cell-inner ']")).filter(visible).shouldHaveSize(54);
        List<String> eventsTimetableList = eventsTimetable.stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat("None of elements contains sub-string", eventsTimetableList, hasItem(containsString(expectedNum)));
        System.out.println("Графік подій по портфелю" + eventsTimetableList);
    }
}
