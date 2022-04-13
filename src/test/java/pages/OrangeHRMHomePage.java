package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHRMHomePage {

    public OrangeHRMHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminButton;

    @FindBy(id = "searchSystemUser_userName")
    public WebElement userName;

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    @FindBy(id="searchSystemUser_userName")
    public WebElement OmkarName;
}