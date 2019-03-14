package com.bars.credit;

import com.bars.ConfigProperties;
import com.bars.NewCreditPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AccKdPage {
    private NewCreditPage newCreditPage = page(NewCreditPage.class);
    public void checkAccSSopening(String productStyle){
        String nbsForSS = newCreditPage.getNBSforSS(ConfigProperties.getTestProperty(productStyle));
        String ob22forSS = newCreditPage.getOB22forSS(ConfigProperties.getTestProperty(productStyle));
        $x("//tr[@class='k-alt']/td[4]").shouldHave(text(nbsForSS ));
        $x("//tr[@class='k-alt']/td[6]").shouldHave(text(ob22forSS));
    }
}
