package com.epam.automation.GlaciuserTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    private static String PAGE_URL = "https://mail.ru";

    @FindBy(xpath = "//div[contains(@class, 'b-datalist_letters_from')]")
    WebElement lettersList;

    /*
     * Inputs
     */
    @FindBy(xpath = "//input[@id = 'mailbox:login']")
    WebElement loginInput;
    @FindBy(xpath = "//input[@id = 'mailbox:password']")
    WebElement passwordInput;

    /*
     * Buttons
     */
    @FindBy(xpath = "//*[@id = 'mailbox:submit']/input")
    WebElement loginButton;
    @FindBy(xpath = "//a[text() = 'выход']")
    WebElement logoutButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void setLogin(String login) {
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
        }
    }

    public boolean isPageOpened() {
        return lettersList.isDisplayed();
    }

    public boolean isLogout() {
        return loginInput.isDisplayed();
    }

}
