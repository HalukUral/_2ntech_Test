package com._2ntech.news.stepdefinitions;

import com._2ntech.news.page._2ntechPage;
import com._2ntech.news.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Search_StepDefinitions {
    com._2ntech.news.page._2ntechPage _2ntechPage = new _2ntechPage();
    String articleTitle;
    private String articlePageTitle;


    @Given("kullanıcı {string} adresine git")
    public void kullanıcı_adresine_git(String url) {
        Driver.getDriver().get(url);
    }

    @When("arama kutusuna {string} yazıp arama yapar")
    public void arama_kutusuna_yazıp_arama_yapar(String searchQuery) {
        _2ntechPage.searchLink.click();
        _2ntechPage.searchInput.sendKeys(searchQuery);
        _2ntechPage.searchInput.submit();
    }

   @Then("arama sonuçlarından {int}. habere gider")
    public void arama_sonuçlarından_habere_gider(int articleIndex) {
       WebElement article=_2ntechPage.articles.get(articleIndex-1);
       WebElement linkElement = article.findElement(By.tagName("a"));
       articleTitle=article.findElement(By.tagName("h3")).getText();
       JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
       executor.executeScript("arguments[0].click();", linkElement);
       articlePageTitle=Driver.getDriver().getTitle();


    }

    @And("haberin başlığı doğru olmalıdır")
    public void haberinBaşlığıDoğruOlmalıdır() {

        Assert.assertTrue("Sayfa başlığı beklenilen değeri içermiyor!", articlePageTitle.toUpperCase().contains(articleTitle.toUpperCase()));
    }

    }


