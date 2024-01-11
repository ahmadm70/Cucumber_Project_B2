package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportUtilities {
    /**
     * Logs in to the docuport application
     * @parameter driver, which initialized in TestBase class
     * @parameter role, comes from DocuportConstants
     * @author Ahmad
     */
    public static void login(WebDriver driver, String role) throws InterruptedException {
        //driver.get("https://beta.docuport.app/");
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Username or email')]//following-sibling::input"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'Password')]//following-sibling::input"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        switch(role.toLowerCase()) {
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_FOR_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_FOR_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_FOR_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_FOR_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            default: throw new InputMismatchException("There isn't such a role: " + role);
        }
        loginButton.click();
        Thread.sleep(2000);
        if (role.equalsIgnoreCase("client")) {
            WebElement continueButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
            continueButton.click();
        }
    }

    /**
     * Logs out from the docuport application
     * @parameter driver
     * @author Ahmad
     */
    public static void logout(WebDriver driver) {
        WebElement userIcon = Driver.getDriver().findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        WebElement logOutButton = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOutButton.click();
    }
}