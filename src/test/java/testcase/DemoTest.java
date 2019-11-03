package testcase;

import base.TestBase;
import org.testng.annotations.Test;
import pageobject.HomePage;

public class DemoTest extends TestBase {

    @Test
    public void someTestCase() {
        HomePage home = new HomePage();
        home.open().login("numhetare", "Amina1990!");
    }
}
