package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseBasicPackage_pageObject {

    WebDriver driver;

    // Define web elements using @FindBy
    @FindBy(xpath = "//div[@class='et_pb_text_inner']/h1")
    private WebElement pickAPlan;
    @FindBy(xpath = "(//div[@class='et_pb_button_wrapper']/a)[2]")
    private WebElement basicPackagePlanButton;


    //Constructor
    public PurchaseBasicPackage_pageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this); // initialize web elements
    }

    // Define methods to interact with elements
    public void Purchase_basic_package() {
        pickAPlan.getText();
        basicPackagePlanButton.click();



    }


}
