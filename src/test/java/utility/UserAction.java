package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UserAction {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void initialize(WebDriver inputDriver) {
        driver = inputDriver;
        wait = new WebDriverWait(driver, 15);
    }

    private static WebElement waitUntilElementVisibility(By element) {
        return waitUntilElementVisibility(element);
    }

    public static WebDriver driver() {
        return driver;
    }

    // ============== WAIT ==========================-  //
    public static void waitFor(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============== DO ============================== //
    public static void click(By element) {
        waitUntilElementVisibility(element).click();
    }

    public static void doubleClick(By element) {
        new Actions(driver)
                .doubleClick(waitUntilElementVisibility(element))
                .perform();
    }

    public static void clearAndTypeInto(By element, String text) {
        waitUntilElementVisibility(element).clear();
        waitUntilElementVisibility(element).sendKeys(text);
    }

    public static void typeInto(By element, String text) {
        waitUntilElementVisibility(element).sendKeys(text);
    }

    public static void hoverOver(By element) {
        WebElement elementElement = waitUntilElementVisibility(element);
        new Actions(driver).moveToElement(elementElement).perform();
    }

    public static void submit(By element) {
        waitUntilElementVisibility(element).submit();
    }

    public static void switchToFrame(By element) {
        driver.switchTo().frame(waitUntilElementVisibility(element));
    }


    // =============== Perform Mouse =================== //

    public static void mouseDownOn(By element) {
        new Actions(driver)
                .moveToElement(waitUntilElementVisibility(element))
                .clickAndHold().perform();
    }

    public static void mouseUpOn(By element) {
        new Actions(driver).moveToElement(waitUntilElementVisibility(element))
                .release()
                .perform();
    }

    public static void moveTo(By element) {
        new Actions(driver).moveToElement(waitUntilElementVisibility(element))
                .perform();
    }

    public static void mouseOver(By element) {
        new Actions(driver).moveToElement(waitUntilElementVisibility(element))
                .perform();
    }

    public static void mouseOutOf(int offsetX, int offsetY) {
        new Actions(driver).moveByOffset(offsetX, offsetY).perform();
    }

    // =============== GET ============================ //

    public static WebElement getAsWebElement(By element) {
        WebElement elementElement = waitUntilElementVisibility(element);
        return elementElement;
    }

    public static String getText(By element) {
        String elementText = waitUntilElementVisibility(element).getText();
        return elementText;
    }

    public static String getValueAttr(By element) {
        String elementValue = waitUntilElementVisibility(element).getAttribute("value");
        return elementValue;
    }

    public static String getAttrValue(By element, String attribute) {
        String elementAttribute = waitUntilElementVisibility(element).getAttribute(attribute);
        return elementAttribute;
    }

    public static String getOptionLabel(By element, String target) {
        WebElement elementElement = waitUntilElementVisibility(element);
        if (!elementElement.getTagName().equals("select")) {
            throw new IllegalArgumentException("The provided WebElement is not of type select");
        }
        List<WebElement> options = new Select(elementElement).getAllSelectedOptions();
        for (WebElement elem : options) {
            if (elem.getText().equalsIgnoreCase(target)) {
                return elem.getText();
            }
        }
        return null;
    }

    // ================  IS ============================ //

    public static Boolean isChecked(By element) {
        Boolean elementIsChecked = waitUntilElementVisibility(element).isSelected();
        return elementIsChecked;
    }


    public static Boolean isEditable(By element) {
        WebElement elementElement = waitUntilElementVisibility(element);
        Boolean elementIsEditable = elementElement.isEnabled() && elementElement.getAttribute("readonly") == null;
        return elementIsEditable;
    }

    public static Boolean isPresent(By element) {
        Boolean elementIsPresent = driver.findElements(element).size() > 0;
        return elementIsPresent;
    }


    public static Boolean isVisible(By element) {
        Boolean elementIsVisible = waitUntilElementVisibility(element).isDisplayed();
        return elementIsVisible;
    }

    // ================  IS NOT ============================ //

    public static void click_NthElement(By element, int index) {
        waitUntilElementVisibility(element);
        List<WebElement> elementAllElements = driver.findElements(element);

        WebElement elementElementByIdx = elementAllElements.get(index);
        elementElementByIdx.click();
    }

    public static Boolean isUnchecked(By element) {
        Boolean elementIsNotChecked =
                !waitUntilElementVisibility(element).isSelected();
        return elementIsNotChecked;
    }

    public static Boolean isNotEditable(By element) {
        WebElement subjectElement = waitUntilElementVisibility(element);
        Boolean elementIsNotEditable = !subjectElement.isEnabled() || subjectElement.getAttribute("readonly") != null;
        return elementIsNotEditable;
    }

    public static Boolean isNotPresent(By element) {
        Boolean elementIsNotPresent = driver.findElements(element).size() == 0;
        return elementIsNotPresent;
    }

    public static Boolean isInvisible(By element) {
        Boolean elementIsNotVisible = !waitUntilElementVisibility(element).isDisplayed();
        return elementIsNotVisible;
    }

    // ========================= INDEX ===================== //
    public static WebElement get_NthElement(By element, int index) {
        waitUntilElementVisibility(element);
        List<WebElement> elementAllElements = driver.findElements(element);
        WebElement elementElementByIdx = elementAllElements.get(index);
        return elementElementByIdx;
    }

    public static String getNthElementText(By element, int index) {
        waitUntilElementVisibility(element);
        List<WebElement> elementAllElements = driver.findElements(element);
        WebElement elementElementByIdx = elementAllElements.get(index);
        String elementText = elementElementByIdx.getText();
        return elementText;
    }
}
