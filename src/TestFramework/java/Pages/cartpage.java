package TestFramework.java.Pages;

public class cartpage extends basepage {

    public static void check_if_cart_item_is_displayed(String item_name) {
        String f_xpath = "//div[@class='inventory_item_name' and contains(text(), '" + item_name + "')]";
        check_if_item_is_displayed(f_xpath);
    }

    public static Float get_item_price(String item_name) {
        String f_xpath = "//div[@class='inventory_item_name' and contains(text(), '" + item_name + "')]/../..//div[@class='item_pricebar']/div";
        String price_string = get_text(f_xpath);
        String[] price_array = price_string.split("\\$");
        String price = price_array[1].trim();
        String priceOnly = price.replaceAll("[^0-9]", "");
        return Float.parseFloat(priceOnly);
    }

    public static void click_on_cart() {
        String xpath = "//div[@class='shopping_cart_container']/a";
        click(xpath);
    }

    public static void click_on_continue_shopping_button() {
        String xpath = "//button[contains(text(), 'Continue Shopping')]";
        click(xpath);
    }

    public static void click_on_checkout_button() {
        String xpath = "//button[contains(text(), 'Checkout')]";
        click(xpath);
    }
}
