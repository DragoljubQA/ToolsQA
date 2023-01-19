package Tests;

import BaseTest.Base;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsTest extends Base {

    ButtonsPage buttonsPage;
    CheckBoxPage checkBoxPage;
    Homepage homepage;
    RadioButtonPage radioButtonPage;
    Sidebar sidebar;
    TextBoxPage textBoxPage;
    WebTablesPage webTablesPage;

    @BeforeMethod
    public void setUpPage() {
        buttonsPage = new ButtonsPage();
        checkBoxPage = new CheckBoxPage();
        homepage = new Homepage();
        radioButtonPage = new RadioButtonPage();
        sidebar = new Sidebar();
        textBoxPage = new TextBoxPage();
        webTablesPage = new WebTablesPage();

        driver.manage().window().maximize();
        driver.navigate().to(homepageURL);
    }

    public void goToElements() {
        scrollIntoView(homepage.Cards.get(0));
        homepage.clickOnElementsButton();
    }

    public void deleteAllEntries() {
        while (!webTablesPage.cellText(0).isBlank()) {
            webTablesPage.clickOnDelete();
        }
    }

    public void addData() {
        for (int i = 1; i <= excelReader.getLastRowNumber(); i++) {
            String firstName = excelReader.getStringData("Users", i, 0);
            String lastName = excelReader.getStringData("Users", i, 1);
            String email = excelReader.getStringData("Users", i, 2);
            int age = excelReader.getIntegerData("Users", i, 3);
            int salary = excelReader.getIntegerData("Users", i, 4);
            String department = excelReader.getStringData("Users", i, 5);
            wait(webTablesPage.AddButton); //Cekanje da dugme Add bude klikabilno, metoda je napravljena u klasi za page
            webTablesPage.clickOnAdd();
            webTablesPage.inputFirstName(firstName);
            webTablesPage.inputLastName(lastName);
            webTablesPage.inputEmail(email);
            webTablesPage.inputAge(age);
            webTablesPage.inputSalary(salary);
            webTablesPage.inputDepartment(department);
            webTablesPage.clickOnSubmit();
        }
    }

    @Test
    public void elementsURL() {
        String validURLHomepage = excelReader.getStringData("URL", 1, 1);
        String validURLTextbox = excelReader.getStringData("URL", 2, 1);
        goToElements();
        Assert.assertEquals(driver.getCurrentUrl(), validURLHomepage);
        sidebar.clickOnTextBoxButton();
        Assert.assertEquals(driver.getCurrentUrl(), validURLTextbox);
    }

    @Test
    public void userCanFillTextboxes() {
        String validFullname = excelReader.getStringData("Textbox",1, 0);
        String validEmail = excelReader.getStringData("Textbox", 1, 1);
        String currentAddress = excelReader.getStringData("Textbox", 1, 2);
        String permanentAddress = excelReader.getStringData("Textbox", 1, 3);

        goToElements();
        sidebar.clickOnTextBoxButton();
        textBoxPage.insertUsername(validFullname);
        textBoxPage.insertEmail(validEmail);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollIntoView(textBoxPage.Submit);
        textBoxPage.clickOnSubmit();
    }

    @Test
    public void checkboxingHomeWillCheckboxAllOthers() {
        goToElements();
        sidebar.clickOnCheckBoxButton();
        for (int i = 0 ; i<=5 ; i++) {
            checkBoxPage.clickOnDropdownButton(i);
            scrollIntoView(checkBoxPage.DropdownButton.get(i));
        }
        scrollIntoView(checkBoxPage.UncheckedCheckbox.get(0));
        Assert.assertEquals(17, checkBoxPage.UncheckedCheckbox); //Provera koliko ima necekiranih boxova
        checkBoxPage.clickOnUnchecked(0); //Ovde smo kliknuli na prvi checkbox "Home" koji ce da cekira sve
        Assert.assertEquals(0, checkBoxPage.UncheckedCheckbox); //Provera da li nema vise necekiranih
        Assert.assertEquals(17, checkBoxPage.UncheckedCheckbox); //Provera da li su svi boxovi cekirani

    }

    @Test
    public void checkboxingSingleCheckbox() {
        goToElements();
        sidebar.clickOnCheckBoxButton();
        for (int i = 0 ; i<=5 ; i++) {
            scrollIntoView(checkBoxPage.DropdownButton.get(i));
            checkBoxPage.clickOnDropdownButton(i);
        }
        Assert.assertEquals("rct-icon rct-icon-uncheck",checkBoxPage.Angular.getAttribute("class"));
        checkBoxPage.clickOnAngular();
        Assert.assertEquals("rct-icon rct-icon-check",checkBoxPage.Angular.getAttribute("class"));
        Assert.assertEquals("angular", checkBoxPage.getNotificationSuccess());
    }

    @Test
    public void clickOnYesRadioButton() {
        goToElements();
        sidebar.clickOnRadioButton();
        clickElementJS(radioButtonPage.No);
        Assert.assertTrue(radioButtonPage.notificationExistenceText(0).isEmpty());
        clickElementJS(radioButtonPage.Yes);
        Assert.assertEquals("Yes", radioButtonPage.notificationText());
        //Ovde bih predlozio svom FE timu da ubaci status da li je dugme izabrano ili ne
        //kako bih mogao da proverim da li biranjem radio buttona drugo dugme nije odabrano
        clickElementJS(radioButtonPage.Impressive);
        Assert.assertEquals("Impressive", radioButtonPage.notificationText());

    }

    @Test
    public void clickOnAllButtons() {
        goToElements();
        sidebar.clickOnButtonsButton();
        actionDoubleClick(buttonsPage.DoubleClick);
        Assert.assertTrue(buttonsPage.DoubleClickNotification.isDisplayed());
        Assert.assertEquals("You have done a double click", buttonsPage.doubleClickNotification());
        actionRightClick(buttonsPage.RightClick);
        Assert.assertTrue(buttonsPage.RightClickNotification.isDisplayed());
        Assert.assertEquals("You have done a right click", buttonsPage.rightClickNotification());
        buttonsPage.clickOnClick();
        Assert.assertTrue(buttonsPage.Notification.isDisplayed());
        Assert.assertEquals("You have done a dynamic click",buttonsPage.clickNotification());
    }

    @Test
    public void userCanAddData() {
        goToElements();
        sidebar.clickOnWebTables();

        deleteAllEntries(); //Posebna metoda koja brise sve postojece podatke (cleanup)

        int j = 0;
        for (int i = 1; i <= excelReader.getLastRowNumber(); i++) {

            String firstName = excelReader.getStringData("Users", i, 0);
            String lastName = excelReader.getStringData("Users", i, 1);
            String email = excelReader.getStringData("Users", i, 2);
            int age = excelReader.getIntegerData("Users", i, 3);
            int salary = excelReader.getIntegerData("Users", i, 4);
            String department = excelReader.getStringData("Users", i, 5);

            wait(webTablesPage.AddButton); //Cekanje da dugme Add bude klikabilno, metoda je napravljena u klasi za page

            webTablesPage.clickOnAdd();
            webTablesPage.inputFirstName(firstName);
            webTablesPage.inputLastName(lastName);
            webTablesPage.inputEmail(email);
            webTablesPage.inputAge(age);
            webTablesPage.inputSalary(salary);
            webTablesPage.inputDepartment(department);
            webTablesPage.clickOnSubmit();

            //Proveru bih ostavio u ovoj metodi uz petlju, a napravio bih prethodno posebno metodu samo za dodavanje podataka
            //Proveravam da li je svaki pojedinaca unos prikazan na FE
            Assert.assertEquals(firstName, webTablesPage.cellText(j));
            Assert.assertEquals(lastName, webTablesPage.cellText(j+1));
            Assert.assertEquals(String.valueOf(age), webTablesPage.cellText(j+2));
            Assert.assertEquals(email, webTablesPage.cellText(j+3));
            Assert.assertEquals(String.valueOf(salary), webTablesPage.cellText(j+4));
            Assert.assertEquals(department, webTablesPage.cellText(j+5));

            j = j + 7;
        }
        //deleteAllEntries();
        //cleanup se moze dodati i na kraju, ali s obzirom da program ne pamti unose onda nema potrebe
    }

    @Test
    public void verifyUserCanDeleteAllEntries() {
        goToElements();
        sidebar.clickOnWebTables();
        deleteAllEntries();
        Assert.assertTrue(webTablesPage.cellText(0).isBlank());
    }

    @Test
    public void verifyUserCanSearchEntries() {
        goToElements();
        sidebar.clickOnWebTables();
        deleteAllEntries();
        addData();
        String search = "John";
        webTablesPage.inputSearch(search);
        boolean contains = false;

        for (int i = 0; i < webTablesPage.RowInfo.size(); i++) {
            if (webTablesPage.rowText(i).isBlank()) {
                break;
            } else {
                if (webTablesPage.rowText(i).toUpperCase().contains(search.toUpperCase())) {
                    contains = true;
                } else {
                    System.out.println(webTablesPage.rowText(i).toUpperCase());
                }
                Assert.assertTrue(contains=true);
            }
        }
    }
    

}
