package com._2ntech.news.stepdefinitions;

import com._2ntech.news.page._2ntechPage;
import com._2ntech.news.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Navbar_StepDefinitions {
    com._2ntech.news.page._2ntechPage _2ntechPage = new _2ntechPage();

    @Given("kullanıcı {string} adresine gider")
    public void kullanıcı_adresine_gider(String url) {
        Driver.getDriver().get(url);
    }

    @When("navbar öğelerine tıklar")
    public void navbar_öğelerine_tıklar() {

        for (WebElement link : _2ntechPage.getNavbarLinks()) {
            String expectedTitle = link.getText();
            link.click();
            System.out.println(Driver.getDriver().getTitle().toUpperCase());
            Assert.assertTrue("Sayfa başlığı beklenilen değeri içermiyor!", Driver.getDriver().getTitle().toUpperCase().contains(expectedTitle.toUpperCase()));
            Driver.getDriver().navigate().back();
        }
    }

    @Then("her sayfanın başlığı doğru olmalıdır")
    public void her_sayfanın_başlığı_doğru_olmalıdır() {
        System.out.println("Navbar tıklama işlemi başarıyla tamamlandı.");
    }
}
