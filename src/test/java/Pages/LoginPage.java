package Pages;

import BaseTest.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy ( id = "userName")
    WebElement Username;

    @FindBy ( id = "password")
    WebElement Password;

    @FindBy ( id = "login")
    WebElement Login;

    //---------------------------------

    public void inputUsername(String name) {
        Username.clear();
        Username.sendKeys(name);
    }

    public void inputPassword(String pass) {
        Password.clear();
        Password.sendKeys(pass);
    }

    public void clickLogin() {
        Login.click();
    }


}
