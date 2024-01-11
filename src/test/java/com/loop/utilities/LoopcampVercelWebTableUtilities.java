package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoopcampVercelWebTableUtilities {
    /**
     * @param driver
     * @param name
     * @param field
     * @return field's text
     * @author Ahmad
     */
    public static String returnAnyField(WebDriver driver, String name, String field) {
        String index = null;
        switch (field.toLowerCase()) {
            case "pizza type":
                index = "[1]";
                break;
            case "amount":
                index = "[2]";
                break;
            case "date":
                index = "[3]";
                break;
            case "street":
                index = "[4]";
                break;
            case "city":
                index = "[5]";
                break;
            case "state":
                index = "[6]";
                break;
            case "zip":
                index = "[7]";
                break;
            case "card":
                index = "[8]";
                break;
            case "card number":
                index = "[9]";
                break;
            case "exp":
                index = "[10]";
                break;
        }
        WebElement element = driver.findElement(By.xpath("//td[text()='" + name + "']/following-sibling::td" + index));
        return element.getText().trim();
    }
}