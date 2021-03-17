package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CellNumberDialogScreen {

    public CellNumberDialogScreen(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    public WebDriver ldriver;
    public int TIMEOUT = 10;
    public String validMessage = "Cellphone number is valid =)";

    @FindBy(id = "cellNumTextField")
    WebElement cellNumTextField;

    @FindBy(id = "okButton")
    WebElement okButton;

    @FindBy(id = "cancelButton")
    WebElement cancelButton;

    @FindBy(id = "messageText")
    WebElement messageText;

    public void enterCellNumber(String text) {
        waitForElementVisible(cellNumTextField);
        cellNumTextField.sendKeys(text);
    }

    public void clickOkButton() {
        okButton.click();
    }

    public void verifyCellNumberIsValid() {
        waitForElementVisible(messageText);
        String extractedText = messageText.getText();
        Assert.assertEquals(extractedText, validMessage, "PASSED: The cell number entered is a valid number!");
        okButton.click();
    }

    public void waitForElementVisible(WebElement locator) {
        new WebDriverWait(ldriver, TIMEOUT).until(ExpectedConditions.visibilityOf(locator));
    }
}
