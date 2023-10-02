package DemoBlaze;

import Utilities.MyMethods;
import Utilities.PageObjectModel;
import Utilities.ParameterDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoBlaze extends ParameterDriver {
    @Test
    @Parameters ({"username","password"})
    public void signUpTest(String username,String password){
        driver.get("https://www.demoblaze.com/index.html");
        PageObjectModel pageObjectModel = new PageObjectModel();
        pageObjectModel.signUpButton.click();
        pageObjectModel.usernameInbox.sendKeys(username);
        pageObjectModel.passwordInbox.sendKeys(password);
        pageObjectModel.signButton.click();
    }
}
