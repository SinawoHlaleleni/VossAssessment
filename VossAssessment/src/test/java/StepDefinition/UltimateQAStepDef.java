package StepDefinition;
import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import runners.TestRunner;

public class UltimateQAStepDef {
    private final WebDriver driver = TestRunner.getDriver();
    Login_pageObject login_pageObject;
    FillOutForm_pageObject fillOutFormPageObject;
    PurchaseBasicPackage_pageObject purchaseBasicPackagePageObject;

    @Given("user opens UltimateQA UI")
    public void userOpensUltimateQAUI() {
        driver.navigate().to("https://www.ultimateqa.com/automation/");
        //initialize page object
        login_pageObject = new Login_pageObject(driver);
        fillOutFormPageObject = new FillOutForm_pageObject(driver);
        purchaseBasicPackagePageObject = new PurchaseBasicPackage_pageObject(driver);
    }

    //verify Title, took screenshot and maximise page
    @Then("user verifies page title then take screenshot and maximize page")
    public void userVerifiesPageTitleThenTakeScreenshot() {
        //Verify title
        String title = driver.getTitle();
        String expectedTitle = "Automation Practice - Ultimate QA";
        Assert.assertEquals(title, expectedTitle);
        //take screenshot
        login_pageObject.Screenshot();
        //Maximize window
        driver.manage().window().maximize();
    }

    //login and verify
    @Then("the user login to UltimateQA test")
    public void theUserLoginToUltimateQATest() {
        //login
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        login_pageObject.LogIn_and_welcomeBackText("sinawo.hlaleleni@gmail.com", "Alu#1998");
        driver.get("https://courses.ultimateqa.com/collections");
        login_pageObject.verifyTextAfterLoggedIn();
    }

    //logout and verify
    @And("the user sign out and verify")
    public void theUserSignOutAndVerify() {
        //logout
        login_pageObject.signOut_and_verify();
    }

    //Fill out the forms
    @Then("the user clicks on fill out form and submit")
    public void the_user_clicks_on_fill_out_form_and_submit() {
        driver.get("https://ultimateqa.com/filling-out-forms/");
        fillOutFormPageObject.FillOutForm_and_submit("Sinawo","We are hear for Testing to test test test and test QA work!");
        fillOutFormPageObject.FillOutForm_and_submit2("Hlaleleni","We are hear for Testing to test test test and test QA work!");
    }

    //purchase basic package
    @And("the user purchased the basic package")
    public void theUserPurchasedTheBasicPackage() {
        driver.get("https://ultimateqa.com/automation/fake-pricing-page/");
        purchaseBasicPackagePageObject.Purchase_basic_package();

    }


}



