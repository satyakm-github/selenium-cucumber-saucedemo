package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    WebDriver driver;
    double maxPrice;
    WebElement highestItem;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void url(String url) {

        driver.get(url);
    }

    public void login(String username, String password) {

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

    }

    public void loginButton() {

        driver.findElement(By.cssSelector("#login-button")).click();
    }

    public String getTitle() {

        return driver.findElement(By.cssSelector(".title")).getText();

    }
    public void addHighestItemsToCart(){

        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
        highestItem = null;
        maxPrice = 0;

        for (WebElement product : products) {

                String priceText = product.findElement(By.cssSelector("div.inventory_item_price")).getText();
                double price = Double.parseDouble(priceText.replace("$", "").trim());
                if (price > maxPrice) {
                    maxPrice = price;
                    highestItem = product;
                }
        }

        System.out.println(maxPrice);

        if (highestItem != null) {
            System.out.println(highestItem.getText());
           //highestItem.findElement(By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory \"]")).click();
            highestItem.findElement(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket")).click();
            System.out.println("Added item with price $" + maxPrice + " to cart");
        } else {
            throw new RuntimeException("No products found on page!");
        }
    }

    public void cartButton(){

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

    }
    public boolean isHighestItemInCart() {

        List<WebElement> cartItems = driver.findElements(By.cssSelector("div.inventory_item_price"));
        for (WebElement item : cartItems) {
            String priceText = item.getText();
            if (priceText.contains(String.valueOf(maxPrice))) {
                return true;
            }
        }
        return false;
    }
}
