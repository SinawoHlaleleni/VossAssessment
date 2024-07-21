package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillOutForm_pageObject {

    WebDriver driver;

    // Define web elements using @FindBy
    @FindBy(xpath = "//input[@id='et_pb_contact_name_0']")
    private WebElement nameField;
    @FindBy(xpath = "//textarea[@id='et_pb_contact_message_0']")
    private WebElement messageField;
    @FindBy(xpath = "(//button[@class='et_pb_contact_submit et_pb_button'])[1]")
    private WebElement submitButton;
    @FindBy(xpath = "(//div[@class='et-pb-contact-message'])[1]")
    private WebElement verify_AfterSubmission;

    @FindBy(xpath = "//input[@id='et_pb_contact_name_1']")
    private WebElement name1Field;
    @FindBy(xpath = "//textarea[@id='et_pb_contact_message_1']")
    private WebElement message1Field;

    @FindBy(xpath = "//span[@class='et_pb_contact_captcha_question']")
    private WebElement numbers;

    @FindBy(xpath = "//input[@class='input et_pb_contact_captcha']")
    private WebElement captchaBox;
    @FindBy(xpath = "(//button[@class='et_pb_contact_submit et_pb_button'])[2]")
    private WebElement submit1Button;
    @FindBy(xpath = "(//div[@class='et-pb-contact-message'])[2]")
    private WebElement verify_AfterSubmission1;

    //Constructor
    public FillOutForm_pageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this); // initialize web elements
    }

    // Define methods to interact with elements
    public void FillOutForm_and_submit(String name, String message) {
        nameField.sendKeys(name);
        messageField.sendKeys(message);
        submitButton.click();
        verify_AfterSubmission.getText();

    }

    public void FillOutForm_and_submit2(String name, String message) {
        name1Field.sendKeys(name);
        message1Field.sendKeys(message);
//split the text numbers
        String numbersText = numbers.getText();
        String[] parts = numbersText.split("\\+");
        int number1 = Integer.parseInt(parts[0].trim());
        int number2 = Integer.parseInt(parts[1].trim());

        //calculate sum of the captcha
        int sum = number1 + number2;

        captchaBox.sendKeys(String.valueOf(sum));

        submit1Button.click();
        verify_AfterSubmission1.getText();

    }
}
