package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocuportWebTableUtilities {
    /**
     * Returns any field from table by given email
     * @param driver
     * @param email
     * @param field
     * @author Ahmad
     */
    public static String returnAnyField(WebDriver driver, String email, String field) {
        WebElement element = null;
        switch (field.toLowerCase()) {
            case "full name":
                element = driver.findElement(By.xpath("//td[2][text()='" + email + "']/preceding-sibling::td//span[2]"));
                break;
            case "username":
                element = driver.findElement(By.xpath("//td[2][text()='" + email + "']/following-sibling::td[1]"));
                break;
            case "inviter":
                element = driver.findElement(By.xpath("//td[2][text()='" + email + "']/following-sibling::td[2]"));
                break;
            case "phone number (extension)":
                element = driver.findElement(By.xpath("//td[2][text()='" + email + "']/following-sibling::td[3]/span"));
                break;
            case "role":
                element = driver.findElement(By.xpath("//td[2][text()='" + email + "']/following-sibling::td[4]/span/span"));
                break;
            case "advisor":
                element = driver.findElement(By.xpath("//td[2][text()='" + email + "']/following-sibling::td[5]"));
                break;
        }
        return element.getText().trim();
    }
}