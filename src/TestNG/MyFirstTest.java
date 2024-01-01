package TestNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import TestFramework.java.Pages.loginpage;
import TestFramework.java.Pages.inventorypage;
import TestFramework.java.Pages.cartpage;
import TestFramework.java.Pages.checkoutpage;
import org.testng.annotations.*;

import java.io.IOException;

public class MyFirstTest {

    private static ExtentReports extent;
    private static ExtentTest test;

    static loginpage lp = new loginpage();
    static String username = "standard_user";
    static String password = "secret_sauce";

    static String First_name = "Standard";
    static String Last_name = "User";
    static String Postal_Code = "11234";
    static String Backpack = "Sauce Labs Backpack";
    static String Jacket = "Sauce Labs Fleece Jacket";
    static String T_shirt = "Test.allTheThings() T-Shirt (Red)";

    static Float sum_in_cart;

    @BeforeSuite
    public static void setup() throws IOException {

        //start: ExtentReports initialization
        extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");

        extent.attachReporter(htmlReporter);

        test = extent.createTest("Launch URL in Browser");
        //end: ExtentReports initialization

        lp.setup();
        test.pass("Test Passed");

    }

    @DataProvider(name = "LoginDataProvider")
    public Object [][] LoginData(){
        return new Object[][]{
                {"standard_user", "secret_sauce"}
//                {"locked_out_user", "secret_sauce"}
//                {"problem_user", "secret_sauce"},
//                {"performance_glitch_user", "secret_sauce"},
//                {"error_user", "secret_sauce"},
//                {"visual_user", "secret_sauce"}
        };
    }
    @Test(dataProvider = "LoginDataProvider")
    public static void validate_login(String username, String password) throws IOException, InterruptedException {

        test = extent.createTest("Validate Login");

        loginpage.set_username(username);
        loginpage.set_password(password);
        loginpage.click_login_button();
        Thread.sleep(5000);
        test.pass("Test Passed");
    }

    @Test
    public static void validate_add_items_to_cart() throws InterruptedException {

        test = extent.createTest("Validate Add Items To Cart");

        inventorypage.click_add_to_cart(Backpack);
        inventorypage.click_add_to_cart(Jacket);
        inventorypage.click_add_to_cart(T_shirt);
        Thread.sleep(5000);
        inventorypage.click_on_cart();
        test.pass("Test Passed");
    }

    @Test
    public static void validate_cart() throws InterruptedException {

        test = extent.createTest("Validate Cart");

        cartpage.check_if_cart_item_is_displayed(Backpack);
        Float backpack_price = cartpage.get_item_price(Backpack);

        cartpage.check_if_cart_item_is_displayed(Jacket);
        Float jacket_price = cartpage.get_item_price(Jacket);


        cartpage.check_if_cart_item_is_displayed(T_shirt);
        Float t_shirt_price = cartpage.get_item_price(T_shirt);

        sum_in_cart = backpack_price + jacket_price + t_shirt_price;
        Thread.sleep(5000);
        cartpage.click_on_checkout_button();
        test.pass("Test Passed");
    }

    @Test
    public static void validate_checkout_page() throws InterruptedException {

        test = extent.createTest("Validate Cart");

        checkoutpage.setFirstname_text_field_xpath(First_name);
        checkoutpage.setLastname_field_xpath(Last_name);
        checkoutpage.setZip_postal_code_field_xpath(Postal_Code);
        Thread.sleep(5000);
        checkoutpage.click_on_continue();

        checkoutpage.check_if_item_is_displayed_in_checkout(Backpack);
        checkoutpage.check_if_item_is_displayed_in_checkout(Jacket);
        checkoutpage.check_if_item_is_displayed_in_checkout(T_shirt);

        Float total_item_price = checkoutpage.get_item_total_price();

        if (sum_in_cart.equals(total_item_price)) {
            Thread.sleep(5000);
            checkoutpage.click_on_finish_button();
        }
        Thread.sleep(5000);
        checkoutpage.check_if_completed_text_is_displayed();
        test.pass("Test Passed");

    }

    @AfterSuite
    public static void teardown(){

        test = extent.createTest("Validate Teardown");

        lp.teardown();
        test.pass("Test Passed");
        extent.flush();
    }
}
