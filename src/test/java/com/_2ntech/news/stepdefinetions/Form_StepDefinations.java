package com._2ntech.news.stepdefinetions;
import com._2ntech.news.page.formPage;
import com._2ntech.news.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class Form_StepDefinations {
    formPage formPage = new formPage();

    @Given("kullanıcı {string} adresine gitsin")
    public void kullanıcı_adresine_gitsin(String url) {
        Driver.getDriver().get(url);
    }
    @When("kullanıcı aşağıdaki bilgileri girer:")
    public void kullanıcı_aşağıdaki_bilgileri_girer(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap(String.class, String.class);

        formPage.nameField.sendKeys(formData.get("Ad Soyad"));
        formPage.birthDateField.sendKeys(formData.get("Doğum Tarihi"));
        formPage.tcKimlikNo.sendKeys(formData.get("T.C. Kimlik Numarası"));
        formPage.phoneField.sendKeys(formData.get("Cep Telefonu"));
        formPage.emailField.sendKeys(formData.get("Mail Adresi"));
    }

    @When("kullanıcı CV dosyasını yükler")
    public void kullanıcı_cv_dosyasını_yükler() {
        formPage.cvUploadField.sendKeys("C:\\Users\\haluk\\IdeaProjects\\_2ntech_Test\\src\\HalukUral CV.pdf");
    }

    @When("kullanıcı {string} eğitim seviyesini seçer")
    public void kullanıcı_eğitim_seviyesini_seçer(String educationLevel) {
        formPage.selectEducationLevel(educationLevel);
    }

    @When("kullanıcı KVKK metnini kabul eder")
    public void kullanıcı_kvkk_metnini_kabul_eder() {
       // formPage.kvkkCheckbox.click();
    }

    @When("kullanıcı formun ilk adımını tamamlar")
    public void kullanıcı_formun_ilk_adımını_tamamlar() {
        formPage.nextStepButton.click();
    }

    @Then("formun 2.adımı geçtiği kontrol edilir")
    public void formun_adıma_geçtiği_kontrol_edilir() {
        Assert.assertTrue("Form 2. adımı geçmedi!", formPage.ikinciAdim.isDisplayed());
    }

    @Then("kullanıcı Test Engineer pozisyonunu seçer")
    public void kullanıcıTestEngineerPozisyonunuSeçer() {
       formPage.testEngineer.click();
    }

    @And("kullanıcı formu gönderir")
    public void kullanıcıFormuGönderir() {
        formPage.formGonder.click();
    }
}
