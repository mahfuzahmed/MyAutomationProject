package TestFramework.java.Pages;

public class inventorypage extends basepage {

    public static void click_add_to_cart(String item_name){
        String f_xpath = "//div[contains(text(), '"+item_name+"')]/../../../div[@class='pricebar']/button[contains(text(), 'Add to cart')]";
        click(f_xpath);
    }

    public static void click_remove_from_cart(String item_name){
        String f_xpath = "//div[contains(text(), '"+item_name+"')]/../../../div[@class='pricebar']/button[contains(text(), 'Remove')]";
        click(f_xpath);
    }

    public static void click_on_cart(){
        String xpath = "//div[@class='shopping_cart_container']/a";
        click(xpath);
    }

}
