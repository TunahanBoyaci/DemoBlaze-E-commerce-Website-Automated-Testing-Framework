package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObjectModel {

    public PageObjectModel(){
        PageFactory.initElements(ParameterDriver.driver,this);
    }

    @FindBy (id = "signin2")
    public WebElement signUpButton;

    @FindBy (id = "sign-username")
    public WebElement usernameInbox;

    @FindBy (id = "sign-password")
    public WebElement passwordInbox;

    @FindBy (xpath = "//button[text()='Sign up']")
    public WebElement signButton;

    @FindBy (id = "login2")
    public WebElement loginButton;

    @FindBy (id = "loginusername")
    public WebElement logUsernameInbox;

    @FindBy (id = "loginpassword")
    public WebElement logPasswordInbox;

    @FindBy (xpath = "//button[text()='Log in']")
    public WebElement logButton;

    @FindBy (xpath = "//a[text()='Phones']")
    public WebElement phonesButton;

    @FindBy (xpath = "//a[text()='Laptops']")
    public WebElement laptopsButton;

    @FindBy (xpath = "//a[text()='Monitors']")
    public WebElement monitorsButton;

    @FindBy (id = "logout2")
    public WebElement logoutButton;

    @FindBy (xpath = "//a[text()='Add to cart']")
    public WebElement addToCart;

    @FindBy (id = "cartur")
    public WebElement cartButton;

    @FindBy (xpath = "//button[text()='Place Order']")
    public WebElement placeOrderButton;

    @FindBy (css = "input[id='name']")
    public WebElement name2Inbox;

    @FindBy (css = "input[id='card']")
    public WebElement card2Inbox;

    @FindBy (xpath = "//button[text()='Purchase']")
    public WebElement purchaseButton;

    @FindBy (css = "a[id='nava']")
    public WebElement homePage;


}
