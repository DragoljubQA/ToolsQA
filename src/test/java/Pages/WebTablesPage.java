package Pages;

import BaseTest.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends Base {

    public WebTablesPage() {
        PageFactory.initElements(driver,this);
    }

    public @FindBy( id = "addNewRecordButton")
    WebElement AddButton;

    public @FindBy( id = "searchBox")
    WebElement SearchBox;

    public @FindBy( id = "mr-2")
    List<WebElement> EditButton;

    public @FindBy( xpath = "//span[@title='Delete']")
    WebElement DeleteButton;

    public @FindBy( id = "firstName")
    WebElement FirstName;

    public @FindBy( id = "lastName")
    WebElement LastName;

    public @FindBy( id = "userEmail")
    WebElement Email;

    public @FindBy( id = "age")
    WebElement Age;

    public @FindBy( id = "salary")
    WebElement Salary;

    public @FindBy( id = "department")
    WebElement Department;

    public @FindBy( id = "submit")
    WebElement SubmitButton;

    public @FindBy( className = "rt-td")
    List<WebElement> CellInfo;

    public @FindBy( className = "rt-tr-group")
    List<WebElement> RowInfo;

    //------------------------------------------------------

    public void clickOnDelete() {
        DeleteButton.click();
    }

    public void clickOnAdd() {
        AddButton.click();
    }

    public void clickOnEdit(int i) {
        EditButton.get(i).click();
    }

    public void inputFirstName(String fname) {
        FirstName.clear();
        FirstName.sendKeys(fname);
    }

    public void inputLastName(String lname) {
        LastName.clear();
        LastName.sendKeys(lname);
    }

    public void inputEmail(String email) {
        Email.clear();
        Email.sendKeys(email);
    }

    public void inputAge(int age) {
        Age.clear();
        Age.sendKeys(String.valueOf(age));
    }

    public void inputSalary(int salary) {
        Salary.clear();
        Salary.sendKeys(String.valueOf(salary));
    }

    public void inputDepartment(String department) {
        Department.clear();
        Department.sendKeys(department);
    }

    public void clickOnSubmit() {
        SubmitButton.click();
    }

    public String cellText(int i) {
        return CellInfo.get(i).getText();
    }

    public String rowText(int i) {
        return RowInfo.get(i).getText();
    }

    public void inputSearch(String input) {
        SearchBox.clear();
        SearchBox.sendKeys(input);
    }





}
