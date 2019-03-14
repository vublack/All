package com.bars.credit;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.StringContains.containsString;


public class BriefcaseWorkCreditPage {

    public static void chooseCredit(String refCredit){
        $x("//*[text()='"+refCredit+"']").shouldBe(visible).click();
    }
    public static void buildRepaymentSchedule(){
        $x("//a[@data-qtip='КД: Побудова ГПК для обраного КД']").shouldBe(visible).click();
    }
    public static void getTableName(){
        System.out.println($("#mainReferenceGrid_header_hd").shouldBe(visible).getText());
    }
    public static void matchingSumInGpkFo(String sumCredit){
        String repaymentOfDebt = $x("(//tfoot/tr/td/div)[6]").shouldBe(visible).shouldHave(text(sumCredit)).getText();
        System.out.println("Сума погашення осн. боргу: " + repaymentOfDebt);
    }
    public static void matchingSumInGpkUo(String sumCredit){
        String repaymentOfDebt = $x("(//tfoot/tr/td/div)[5]").shouldBe(visible).shouldHave(text(sumCredit)).getText();
        System.out.println("Сума погашення осн. боргу: " + repaymentOfDebt);
    }
    public static void eventsTimetableOfBriefcaseButtonUo(){
        $x("//a[@data-qtip='Події в КП']").shouldBe(visible).click();
    }
    public static void eventsTimetableOfBriefcaseButtonFo(){
        $x("//a[@data-qtip='КП: Графік подій по портфелю']").shouldBe(visible).click();
    }
    public static void AccountsUoButton(){
        $x("//a[@data-qtip='КД: Рахунки та операції по КД']").shouldBe(visible).click();
    }
    public static void AccountsFoButton(){
        $x("//a[@data-qtip=\"КД: Рахунки та операції,пов'язані з КД\"]").shouldBe(visible).click();
    }
    public static void chooseInterval(String day){
        $x("//input[@name ='B']").shouldBe(visible).setValue(day);
        $x("//input[@name ='E']").shouldBe(visible).setValue(day);
        $x("(//*[@class= 'x-btn-inner x-btn-inner-center'])[text()='Виконати']").shouldBe(visible).click();
    }
    public static void progressBar(){
        $x("//*[@class = 'x-mask-msg-text']").shouldNotBe(visible);
    }
    public static void checkEventsTimetableOfBriefcase(String expectedNum, int size){
        List<SelenideElement> eventsTimetable = $$x("//div[@class='x-grid-cell-inner ']").filter(visible).shouldHaveSize(size);
        List<String> eventsTimetableList = eventsTimetable.stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat("None of elements contains sub-string", eventsTimetableList, hasItem(containsString(expectedNum)));
        System.out.println("Графік подій по портфелю" + eventsTimetableList);
    }

}
