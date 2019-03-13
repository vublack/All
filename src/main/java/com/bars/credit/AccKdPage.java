package com.bars.credit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class AccKdPage {
    public void checkAccSSopening(String nbs, String ob22){
        $x("//tr[@class='k-alt']/td[4]").shouldHave(text(nbs));
        $x("//tr[@class='k-alt']/td[4]").shouldHave(text(ob22));
    }
}
