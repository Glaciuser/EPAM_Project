package com.epam.automation.GlaciuserTest.Setup;

import com.epam.automation.GlaciuserTest.Elements.Mail;
import com.epam.automation.GlaciuserTest.Enums.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Setup {

    private WebDriver webdriver;
    public String login = "epamtestglaciuser";
    public String password = "epam2019autotest";
    private Mail mail;

    public Setup(Driver driver) {
        System.setProperty("webdriver.firefox.marionette", "C:\\Projects and other\\WebDriver 4\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Projects and other\\WebDriver 4\\drivers\\chromedriver.exe");

        switch (driver) {
            case CHROME:
                webdriver = new ChromeDriver();
                break;
            case FIREFOX:
                webdriver = new FirefoxDriver();
                break;
            default:
                webdriver = new ChromeDriver();
                break;
        }

        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        mail = new Mail("test@mail.ru", "Test message", "Test automation sends hi! :)");
    }

    public WebDriver getDriver() {
        return webdriver;
    }

    public Mail getMail() {
        return mail;
    }

}
