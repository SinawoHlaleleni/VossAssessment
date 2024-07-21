package PageObjects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Login_pageObject {

    WebDriver driver;

    // Define web elements using @FindBy
    @FindBy(xpath = "//h2[@class='page__heading']")
    private WebElement welcomeBackHeader;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    //text verification after logged
    @FindBy(xpath = "//p[@class='message-text']")
    private WebElement loggedInMessage;
    @FindBy(xpath = "//h2[contains(text(),' Products')]")
    private WebElement productsHeader;

    //logout session
    @FindBy(xpath = "//header[@class='header']//li[@class='dropdown header__nav-item']//button")
    private WebElement dropDownButton;
    @FindBy(xpath = "//a[contains(@href,'sign_out')]")
    private WebElement signOutButton;

    //verify after singed out text
    @FindBy(xpath = "(//h2[contains(@class,'section__heading-ornament')])[2]")
    private WebElement allCoursesHeader;

//Constructor
    public Login_pageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this); // initialize web elements

    }
    public void Screenshot(){
        try {
            // Take a screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Specify the location to save the screenshot
            File destination = new File("target/screenshot.png");
            // Save the screenshot
            FileHandler.copy(screenshot, destination);
            System.out.println("Screenshot taken and saved at: " + destination.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Screenshot was not captured");;
        } }

    // Define methods to interact with elements
    public void LogIn_and_welcomeBackText(String email, String password) {
        welcomeBackHeader.getText();
        usernameField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();

    }

    public void verifyTextAfterLoggedIn() {
//        loggedInMessage.getText();
        productsHeader.getText();
    }

    public void signOut_and_verify() {
        dropDownButton.click();
        signOutButton.click();
        allCoursesHeader.getText();
    }

}
