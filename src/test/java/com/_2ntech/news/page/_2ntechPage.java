package com._2ntech.news.page;

import com._2ntech.news.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _2ntechPage {
    public _2ntechPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath="//div[@class='elementor-widget-cmsmasters-search__popup-trigger-inner']")
    public WebElement searchLink;

    @FindBy(xpath = "//input[@placeholder='Keşfet...']")
    public WebElement searchInput;

    @FindBy(tagName = "article")
    public List<WebElement> articles;

    @FindBy(css="#menu-1-5dc673f1 > li") // CSS Selector
    public List<WebElement> navbarLinks;
    public List<WebElement> getNavbarLinks() {
        return navbarLinks;
    }


}
