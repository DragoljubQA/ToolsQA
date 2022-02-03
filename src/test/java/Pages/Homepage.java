package Pages;

import BaseTest.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage extends Base {

    public Homepage() {
        PageFactory.initElements(driver,this);
    }

    public @FindBy( css = ".card.mt-4.top-card")
    List<WebElement> Cards;

    //----------------------------------------------

    public void clickOnElementsButton() {
        Cards.get(0).click();
    }

    public void clickOnFormsButton() {Cards.get(1).click();}

    public void clickOnAlers() {Cards.get(2).click();}

    public void clickOnWidgetsButton() {Cards.get(3).click();}

    public void clickOnInteractionsButton() {Cards.get(3).click();}



}
