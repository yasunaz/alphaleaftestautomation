package pageobject;

import org.openqa.selenium.By;
import static utility.UserAction.*;

public class HomePage {
    // ==== Elements ====== //
    By username_input = By.xpath("//input[@name='username']");
    By password_input = By.xpath("//input[@name='password']");
    By submit_button = By.xpath("//input[@value='Log In']");

    // ==== Actions ======= //
    public HomePage open() {
        driver().get("https://parabank.parasoft.com/parabank/index.htm");
        return this;
    }

    public void login(String user, String pass) {
        clearAndTypeInto(username_input, user);
        clearAndTypeInto(password_input, pass);
        click(submit_button);
    }
}