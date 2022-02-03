package Pages;

import BaseTest.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sidebar extends Base {

    public Sidebar() {
        PageFactory.initElements(driver,this);
    }

    public @FindBy( id = "item-0")
    WebElement Textbox;

    public @FindBy( id = "item-1")
    WebElement Checkbox;

    public @FindBy( id = "item-2")
    WebElement RadioButton;

    public @FindBy( id = "item-3")
    WebElement WebTables;

    public @FindBy( id = "item-4")
    WebElement Buttons;

    public @FindBy( id = "item-5")
    WebElement Links;

    public @FindBy( id = "item-6")
    WebElement BrokenLinks;

    public @FindBy( id = "item-7")
    WebElement UploadDownload;

    public @FindBy( id = "item-8")
    WebElement DynamicProperties;

    //------------------------------------------

    public void clickOnTextBoxButton() {
        Textbox.click();
    }

    public void clickOnCheckBoxButton() {
        Checkbox.click();
    }

    public void clickOnRadioButton() {
        RadioButton.click();
    }

    public void clickOnWebTables() {
        WebTables.click();
    }

    public void clickOnButtonsButton() {
        Buttons.click();
    }

    public void clickOnLinks() {
        Links.click();
    }

    public void clickOnBrokenLinks() {
        BrokenLinks.click();
    }

    public void clickOnUploadDownload() {
        UploadDownload.click();
    }

    public void clickOnDynamicProperties() {
        DynamicProperties.click();
    }


}
