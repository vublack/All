package com.bars.credit;

import com.bars.helperClasses.ConfigProperties;
import com.bars.helperClasses.ReadingFromFile;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AccKdPage {
    private NewCreditPage newCreditPage = page(NewCreditPage.class);
    public void checkAccSSopening(String productStyle){
        String nbsForSS = newCreditPage.getNBSforSS(ConfigProperties.getTestProperty(productStyle));
        String ob22forSS = newCreditPage.getOB22forSS(ConfigProperties.getTestProperty(productStyle));
        $x("//tr[@class='k-alt']/td[4]").shouldHave(text(nbsForSS ));
        String base = ReadingFromFile.read("Polygon.txt" ).replace("DB ", "");
        if( base.equals("OBIBANM")) {
            $x("//tr[@class='k-alt']/td[7]").shouldHave(text(ob22forSS));
        }
        else {
            $x("//tr[@class='k-alt']/td[6]").shouldHave(text(ob22forSS));
        }
    }
}
