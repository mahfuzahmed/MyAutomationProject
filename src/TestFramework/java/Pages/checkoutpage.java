package TestFramework.java.Pages;

public class checkoutpage extends basepage {

    static String firstname_text_field_xpath = "//input[@placeholder='First Name']";
    static String lastname_field_xpath = "//input[@placeholder='Last Name']";
    static String zip_postal_code_field_xpath = "//input[@placeholder='Zip/Postal Code']";
    static String continue_button_xpath = "//input[@value='Continue']";
    static String finish_button_xpath = "//button[contains(text(), 'Finish')]";


    public static void setFirstname_text_field_xpath(String input) {
        set_text(firstname_text_field_xpath, input);
    }

    public static void setLastname_field_xpath(String input) {
        set_text(lastname_field_xpath, input);
    }

    public static void setZip_postal_code_field_xpath(String input) {
        set_text(zip_postal_code_field_xpath, input);
    }

    public static void click_on_continue() {
        click(continue_button_xpath);
    }

    public static void check_if_item_is_displayed_in_checkout(String item_name) {
        String f_xpath = "//div[@class='inventory_item_name' and contains(text(), '" + item_name + "')]";
        check_if_item_is_displayed(f_xpath);
    }

    public static Float get_item_total_price() {
        String xpath = "//div[@class='summary_subtotal_label']";
        String price_string = get_text(xpath);
        String[] price_array = price_string.split("\\$");
        String price = price_array[1].trim();
        String priceOnly = price.replaceAll("[^0-9]", "");
        return Float.parseFloat(priceOnly);
    }

    public static Float get_tax() {
        String xpath = "//div[@class='summary_tax_label']";
        String price_string = get_text(xpath);
        String[] price_array = price_string.split("\\$");
        String price = price_array[1].trim();
        String priceOnly = price.replaceAll("[^0-9]", "");
        return Float.parseFloat(priceOnly);
    }

    public static void click_on_finish_button() {
        click(finish_button_xpath);
    }

    public static void check_if_completed_text_is_displayed() {
        String xpath = "//h2[@class='complete-header' and text()='Thank you for your order!']";
        check_if_item_is_displayed(xpath);
    }
}
