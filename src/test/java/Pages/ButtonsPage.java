package Pages;

import BaseTest.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage extends Base {

    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy( xpath = "//*[text()='Click Me']")
    WebElement ClickMe;

    public @FindBy( id = "doubleClickBtn")
    WebElement DoubleClick;

    public @FindBy( id = "rightClickBtn")
    WebElement RightClick;

    public @FindBy( id = "dynamicClickMessage")
    WebElement Notification;

    public @FindBy( id = "doubleClickMessage")
    WebElement DoubleClickNotification;

    public @FindBy( id = "rightClickMessage")
    WebElement RightClickNotification;

    //-----------------------------------------------

    public void clickOnClick() {
        ClickMe.click();
    }

    public void clickOnDoubleClick() {
        DoubleClick.click();
    }

    public void clickOnRightClick() {
        RightClick.click();
    }

    public String clickNotification() {
        return Notification.getText();
    }

    public String doubleClickNotification() {
        return DoubleClickNotification.getText();
    }

    public String rightClickNotification() {
        return RightClickNotification.getText();
    }

}
