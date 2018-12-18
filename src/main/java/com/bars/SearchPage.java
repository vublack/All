package com.bars;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchPage {
    public void h1() {
        $(By.tagName("h1")).shouldHave(text("Оголошення"));
    }

    void searchFunction(String functionName) {
        $("#findOpersText").shouldBe(visible).setValue(functionName).pressEnter();
        String Opername = String.format("//*[@class='oper-name']/span[text()='%s']", functionName);
        $(byXpath(Opername)).shouldBe(visible).click();
    }
    void chooseBranch(){
        $(".btn_branches").shouldBe(visible).click();
        $(byXpath("//div[@id='treeview']/ul/li/ul/li/div/span[2]/span")).shouldBe(visible).shouldHave(text("300465")).click();
        getWebDriver().navigate().refresh();
    }
}
