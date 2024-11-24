package com._2ntech.news.page;

import com._2ntech.news.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class formPage {

    public formPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id = "birth")
    public WebElement birthDateField;

    @FindBy(id = "tcKimlik")
    public WebElement tcKimlikNo;

    @FindBy(id = "phone")
    public WebElement phoneField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "cv_field")
    public WebElement cvUploadField;

    @FindBy(xpath = "//button[contains(text(), 'Lisans')]")
    public WebElement lisansButton;

    @FindBy(css = "input[type='checkbox']")
    public WebElement kvkkCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement nextStepButton;

    @FindBy(xpath = "//h2[text()='2. Adım']")
    public WebElement ikinciAdim;
    @FindBy(xpath = "//span[text()='Test Engineer']")
    public WebElement testEngineer;

    @FindBy(xpath = "//div[text()='Gönder']")
    public WebElement formGonder;

    public void selectEducationLevel(String educationLevel) {
        System.out.println(educationLevel);
        Driver.getDriver().findElement(By.xpath("//button[contains(text(), '"+educationLevel+"')]")).click();
    }
}
