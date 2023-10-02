package DemoBlaze;

import Utilities.PageObjectModel;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoBlaze2 extends ParameterDriver {
    @Test (priority = 1)
    @Parameters ({"username","password"})
    public void demoBlaze2login(String username, String password){
        driver.get("https://www.demoblaze.com/index.html");
        PageObjectModel pageObjectModel = new PageObjectModel();
        pageObjectModel.loginButton.click();
        pageObjectModel.logUsernameInbox.sendKeys(username);
        pageObjectModel.logPasswordInbox.sendKeys(password);
        pageObjectModel.logButton.click();
        WebElement successMessage = driver.findElement(By.xpath("//a[text()='Welcome JohnSmith9283']"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @Test (priority = 2)
    public void demoBlaze2navigate(){
        PageObjectModel pageObjectModel = new PageObjectModel();
        pageObjectModel.phonesButton.click();
        WebElement phone = driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']"));
        Assert.assertTrue(phone.isDisplayed());
        pageObjectModel.laptopsButton.click();
        WebElement laptop = driver.findElement(By.xpath("//a[text()='Sony vaio i5']"));
        Assert.assertTrue(laptop.isDisplayed());
        pageObjectModel.monitorsButton.click();
        WebElement monitor = driver.findElement(By.xpath("//a[text()='Apple monitor 24']"));
        Assert.assertTrue(monitor.isDisplayed());
        pageObjectModel.logoutButton.click();
        Assert.assertTrue(pageObjectModel.signUpButton.isDisplayed());
    }


}
