package tests;

import org.testng.annotations.Test;
import pageObjects.CellNumberDialogScreen;
import utils.LocalWebTestBase;

public class CellNumberDialogTests extends LocalWebTestBase {

    public CellNumberDialogTests() {

    }

    @Test
    public void addBookToBask() {
        CellNumberDialogScreen cellNumScreen = new CellNumberDialogScreen(driver);

        cellNumScreen.enterCellNumber("0727184653");
        cellNumScreen.clickOkButton();
        cellNumScreen.verifyCellNumberIsValid();
    }
}
