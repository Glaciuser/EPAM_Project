package com.epam.automation.GlaciuserTest.Pages;

import com.epam.automation.GlaciuserTest.Elements.Mail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DraftMailPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Черновики']/ancestor::a")
    WebElement draftButton;
    @FindBy(xpath = "//span[text() = 'Убрать оформление']")
    WebElement removeDecorButton;
    @FindBy(xpath = "//*[contains(@class, 'b-datalist_letters_to')]//*[@data-bem='b-datalist__item']//a")
    List<WebElement> lettersList;


    @FindBy(xpath = "//*[@data-blockid = 'compose_to']")
    WebElement to;
    @FindBy(name = "Subject")
    WebElement subject;
    @FindBy(name = "Body")
    WebElement body;

    public DraftMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyDraftMail(Mail mail) throws Exception {
        lettersList.get(0).click();
        Thread.sleep(3000);
        removeDecorButton.click();

        return (mail.to().equals(to.getText())) && (mail.subject().equals(subject.getAttribute("value"))) && (mail.body().equals(body.getAttribute("value").trim()));
    }

    public void clickOnDraftButton() {
        draftButton.click();
    }
}
