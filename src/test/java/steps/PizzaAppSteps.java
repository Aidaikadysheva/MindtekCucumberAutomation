package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Map;

public class PizzaAppSteps {
    WebDriver driver = Driver.getDriver();
    Map<String, Object> data;
    PizzaAppPage pizzaAppPage = new PizzaAppPage();
    String cost;


    @Given("user navigates to pizza application")
    public void user_navigates_to_pizza_apllication() {
        driver.get(ConfigReader.getProperty("PizzaAppURL"));

        // }

        // @Then("user validates that order is  created with succes message {string} {string}")
        // public void user_validates_that_order_is_created_with_succes_message(String string, String string2) {
        //  // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }


    @When("user creates pizza order with data")
    public void userCreatesPizzaOrderWithData(DataTable dataTable) {
        data = dataTable.asMap(String.class, Object.class);
        //  for (Object object : data.values()) {
        //     System.out.println(object);
        //  }
        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizza1Box, data.get("Pizza").toString());
        BrowserUtils.selectDropdownByValue(pizzaAppPage.toppings1Box, data.get("Topping 1").toString());
        BrowserUtils.selectDropdownByValue(pizzaAppPage.toppings2Box, data.get("Topping 2").toString());
        pizzaAppPage.pizza1QtyBox.sendKeys(Keys.BACK_SPACE);
        pizzaAppPage.pizza1QtyBox.sendKeys(data.get("Quantity").toString());
        pizzaAppPage.nameBox.sendKeys(data.get("Name").toString());
        pizzaAppPage.emailBox.sendKeys(data.get("Email").toString());
        pizzaAppPage.phoneBox.sendKeys(data.get("Phone").toString());


        if (data.get("Payment Type").toString().equalsIgnoreCase("Cash on Pickup")) {
            pizzaAppPage.cashPaymentRadio.click();

        } else if (data.get("Payment Type").toString().equalsIgnoreCase("Credit card")) {
            pizzaAppPage.ccPaymentRadio.click();
        }
        cost = pizzaAppPage.pizza1Cost.getAttribute("value");
        pizzaAppPage.placeOrderButton.click();
    }


    @Then("user validates that order is  created with success message {string} {string}")
    public void userValidatesThatOrderIsCreatedWithSuccessMessage(String success, String pizza) {
        String expectedSuccessMessage = success + cost + pizza;
        String actualSuccessMessage = pizzaAppPage.dialogWindow.getText();
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }

}
