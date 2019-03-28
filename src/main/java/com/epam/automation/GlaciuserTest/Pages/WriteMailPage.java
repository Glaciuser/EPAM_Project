package com.epam.automation.GlaciuserTest.Pages;

import com.epam.automation.GlaciuserTest.Elements.Mail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class WriteMailPage {

    private WebDriver driver;

    /*
     * Inputs
     */
    @FindBy(xpath = "//textarea[@data-original-name='To']")
    WebElement toInput;
    @FindBy(name = "Subject")
    WebElement subjectInput;
    @FindBy(name = "Body")
    WebElement bodyInput;

    /*
     * Buttons
     */
    @FindBy(xpath = "//span[text() = 'Отправить']/parent::*/parent::*")
    WebElement sendButton;
    @FindBy(xpath = "//span[text() = 'Сохранить']/parent::*/parent::*")
    WebElement draftButton;
    @FindBy(xpath = "//span[text() = 'Убрать оформление']")
    WebElement removeDecorButton;
    @FindBy(xpath = "//span[text() = 'Написать письмо']/ancestor::a")
    WebElement writeMailButton;

    /*
     * Other
     */
    @FindBy(xpath = "//*[@data-mnemo='toolbar-compose']//*[@data-mnemo='saveStatus']")
    WebElement draftStatus;
    @FindBy(className = "message-sent__title")
    WebElement sentStatus;


    public WriteMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillMail(Mail mail) {
        removeDecorButton.click();
        setTo(mail.to());
        setSubject(mail.subject());
        setBody(mail.body());
    }

    private void setTo(String to) {
        toInput.clear();
        toInput.sendKeys(to);
    }

    private void setSubject(String subject) {
        subjectInput.clear();
        subjectInput.sendKeys(subject);
    }

    private void setBody(String body) {
        bodyInput.clear();
        bodyInput.sendKeys(body);
    }

    public void clickOnWriteMailButton() {
        writeMailButton.click();
    }

    public void clickOnSendButton() {
        sendButton.click();
    }

    public void clickOnSaveDraftButton() {
        draftButton.click();
    }

    public boolean isPageOpened() {
        return toInput.isDisplayed();
    }

    public boolean verifyDraftStatus() {
        return draftStatus.isDisplayed();
    }

    public boolean verifySentStatus() {
        return sentStatus.isDisplayed();
    }

}
