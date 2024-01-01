package TestFramework.java.Pages;

public class loginpage extends basepage {


    //locators
    static String username_text_field_xpath = "//input[@placeholder='Username']";
    static String password_field_xpath = "//input[@placeholder='Password']";
    static String login_button_xpath = "//input[@value='Login']";

    public static void set_username(String username) {
        set_text(username_text_field_xpath, username);
    }

    public static void set_password(String password) {
        set_text(password_field_xpath, password);
    }

    public static void click_login_button() {
        click(login_button_xpath);
    }

}
