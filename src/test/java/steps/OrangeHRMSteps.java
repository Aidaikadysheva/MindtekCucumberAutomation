package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class OrangeHRMSteps {

    WebDriver driver= Driver.getDriver();
    OrangeHRMLoginPage orangeHRMLoginPage=new OrangeHRMLoginPage();
    OrangeHRMHomePage orangeHRMHomePage = new OrangeHRMHomePage();


    @Given("user navigates to orangeHRM application")
    public void user_navigates_to_orangeHRM_application() {
        driver.get(ConfigReader.getProperty("OrangeHRM"));


    }
    @When("user provide username {string} and password {string}")
    public void userProvideUsernameAndPassword(String username, String password) {
        orangeHRMLoginPage.username.sendKeys(username);
        orangeHRMLoginPage.password.sendKeys(password);
        orangeHRMLoginPage.loginButton.click();
    }

    @When("user search for {string}")
    public void user_search_for(String name) {
        orangeHRMHomePage.adminButton.click();
        orangeHRMHomePage.userName.sendKeys(name);
        orangeHRMHomePage.searchButton.click();

    }

    @Then("validates if the user is listed")
    public void validates_if_the_user_is_listed() {
        String actualListedUser=orangeHRMHomePage.OmkarName.getText();
        System.out.println(actualListedUser);
                String expectedListedName="Omkar";
        Assert.assertEquals(actualListedUser,expectedListedName);

    }



}
