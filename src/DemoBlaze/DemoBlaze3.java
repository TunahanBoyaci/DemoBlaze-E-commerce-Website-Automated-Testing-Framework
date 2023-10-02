package DemoBlaze;

import Utilities.MyMethods;
import Utilities.PageObjectModel;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DemoBlaze3 extends ParameterDriver {
    @Test(priority = 1)
    @Parameters({"username","password"})
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
    public void demoBlaze2BuyProduct(){
        PageObjectModel pageObjectModel = new PageObjectModel();
        pageObjectModel.phonesButton.click();
        WebElement phone = driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']"));
        phone.click();
        pageObjectModel.addToCart.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        pageObjectModel.cartButton.click();
        WebElement phoneInTheCart = driver.findElement(By.xpath("//td[text()='Samsung galaxy s6']"));
        Assert.assertTrue(phoneInTheCart.isDisplayed());
        pageObjectModel.homePage.click();

        WebElement phone2 = driver.findElement(By.xpath("//a[text()='Nexus 6']"));
        phone2.click();
        pageObjectModel.addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        pageObjectModel.cartButton.click();
        WebElement phone2InTheCart = driver.findElement(By.xpath("//td[text()='Nexus 6']"));
        Assert.assertTrue(phone2InTheCart.isDisplayed());
        pageObjectModel.homePage.click();

        pageObjectModel.cartButton.click();
        List<WebElement> priceList = driver.findElements(By.xpath("//tr[@class=\"success\"]//td[3]"));
        int manualSum = 0;
        for (WebElement p : priceList){
            manualSum += Integer.parseInt(p.getText());
        }
        MyMethods.myWait(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalp")));
        WebElement total = driver.findElement(By.id("totalp"));
        Assert.assertTrue(manualSum == Integer.parseInt(total.getText()));

        pageObjectModel.placeOrderButton.click();
        pageObjectModel.name2Inbox.sendKeys("John");
        pageObjectModel.card2Inbox.sendKeys("789797998");
        pageObjectModel.purchaseButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("p[class='lead text-muted ']"));
        Assert.assertTrue(successMessage.getText().contains("Id"));

        String pText = successMessage.getText();

        String[] lines = pText.split("\n");
        for (String line : lines) {
            if (line.startsWith("Amount:")) {
                int amount = Integer.parseInt(line.substring(8,12));
                System.out.println(amount);
                Assert.assertTrue(amount == manualSum);
                break;
            }
            if (line.startsWith("Card ")){
                int cardNumber = Integer.parseInt(line.substring(13,9));
                Assert.assertTrue(cardNumber == 789797998);
            }
            if (line.startsWith("Name")){
                String nameOnPurchase = line.substring(6,10);
                Assert.assertTrue(nameOnPurchase.equals("John"));
            }
            if (line.startsWith("Date")){
                String dateOnPurchase = line.substring(6,14);
                LocalDate localDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
                String formattedDate = localDate.format(formatter);
                Assert.assertTrue(dateOnPurchase.equals(formattedDate));
            }
        }

        WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
        okButton.click();
    }
}
