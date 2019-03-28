package com.epam.automation.GlaciuserTest;

import com.epam.automation.GlaciuserTest.Enums.Driver;
import com.epam.automation.GlaciuserTest.Elements.Mail;
import com.epam.automation.GlaciuserTest.Setup.Setup;
import com.epam.automation.GlaciuserTest.Pages.DraftMailPage;
import com.epam.automation.GlaciuserTest.Pages.HomePage;
import com.epam.automation.GlaciuserTest.Pages.WriteMailPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MailDraftTest {
    private WebDriver driver;
    private String login;
    private String password;
    private Mail mail;

    @Before
    public void setUp() throws Exception {
		//Setup all things
        Setup setup = new Setup(Driver.CHROME);
        driver = setup.getDriver();
        mail = setup.getMail();
        this.login = setup.login;
        this.password = setup.password;
    }

    @Test
    public void testAutomationDraft() throws Exception {
		//Login
        HomePage home = new HomePage(driver);
        home.setLogin(login);
        home.setPassword(password);
        home.clickOnLoginButton();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Assert.assertTrue(home.isPageOpened());

		//Write mail and verify status
        WriteMailPage write = new WriteMailPage(driver);
        write.clickOnWriteMailButton();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Assert.assertTrue(write.isPageOpened());
        write.fillMail(mail);
        write.clickOnSaveDraftButton();
        Thread.sleep(5000);
        Assert.assertTrue(write.verifyDraftStatus());

		//Verify mail in drafts
        DraftMailPage draft = new DraftMailPage(driver);
        draft.clickOnDraftButton();
        Assert.assertTrue(draft.verifyDraftMail(mail));

		//Logout
        home.clickOnLogoutButton();
        Thread.sleep(5000);
        Assert.assertTrue(home.isLogout());
    }

    @After
    public void stopDriver() throws Exception {
        driver.quit();
    }

}
