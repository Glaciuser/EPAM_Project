package com.epam.automation.GlaciuserTest.Pages;

import com.epam.automation.GlaciuserTest.Elements.Mail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SentMailPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Отправленные']/ancestor::a")
    WebElement sentButton;
    @FindBy(xpath = "//*[contains(@class, 'b-datalist_letters_to')]//*[@data-bem='b-datalist__item']//a")
    List<WebElement> lettersList;

    @FindBy(className = "b-letter__head__addrs__value")
    WebElement to;
    @FindBy(className = "b-letter__head__subj__text")
    WebElement subject;
    @FindBy(xpath = "//*[contains(@class, 'b-letter__body__wrap')]")
    WebElement body;

    public SentMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifySentMail(Mail mail) throws Exception {
        lettersList.get(0).click();
        Thread.sleep(3000);

        return (mail.to().equals(to.getText())) && (mail.subject().equals(subject.getText())) && (mail.body().equals(body.getText()));
    }

    public void clickOnSentButton() {
        sentButton.click();
    }
}
