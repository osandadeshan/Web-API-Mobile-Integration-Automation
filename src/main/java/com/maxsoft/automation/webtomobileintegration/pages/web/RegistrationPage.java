package com.maxsoft.automation.webtomobileintegration.pages.web;

import com.maxsoft.automation.webtomobileintegration.common.Base;
import com.maxsoft.automation.webtomobileintegration.common.WebBase;
import com.maxsoft.automation.webtomobileintegration.util.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Osanda on 02/09/2018.
 */


public class RegistrationPage extends WebBase {

    private static final String REGISTRATION_PAGE_URL = URL.concat("/signup");
    private WebDriver webDriver = WebDriverSetup.webDriver;
    private static Base baseObj = new Base();

    public RegistrationPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='emailInput']")
    private WebElement TXT_EMAIL_ADDRESS;
    @FindBy(xpath = "//input[@id='reenterEmailInput']")
    private WebElement TXT_CONFIRM_EMAIL_ADDRESS;
    @FindBy(xpath = "//input[@id='usernameInput2']")
    private WebElement TXT_USERNAME;
    @FindBy(xpath = "//input[@id='passwordInput2']")
    private WebElement TXT_PASSWORD;
    @FindBy(xpath = "//input[@id='firstNameInput']")
    private WebElement TXT_FIRST_NAME;
    @FindBy(xpath = "//input[@id='lastNameInput']")
    private WebElement TXT_LAST_NAME;
    @FindBy(xpath = "//label[@for='privacyTermsInput']")
    private WebElement CHK_BOX_PRIVACY_POLICY;
    @FindBy(xpath = "//label[@for='minAgeInput']")
    private WebElement CHK_BOX_AGE_POLICY;
    @FindBy(xpath = "//button[@id='createMyAccountButton']")
    private WebElement BTN_CREATE_ACCOUNT;
    @FindBy(xpath = "//*[@id='mainForm']/h1")
    private WebElement FORM_HEADER;

    public void navigateToRegistration(){
        webDriver.get(REGISTRATION_PAGE_URL);
    }

    public void register(String emailAddress, String confirmEmailAddress, String username, String password, String firstName,
                         String lastName, String role){
        setTextAs(TXT_EMAIL_ADDRESS, emailAddress);
        setTextAs(TXT_CONFIRM_EMAIL_ADDRESS, confirmEmailAddress);
        clearText(TXT_USERNAME);
        setTextAs(TXT_USERNAME, username);
        setTextAs(TXT_PASSWORD, password);
        setTextAs(TXT_FIRST_NAME, firstName);
        setTextAs(TXT_LAST_NAME, lastName);
        selectFromDropdown("//select[@id='roleSelect']", role);
        clickElement(CHK_BOX_PRIVACY_POLICY);
        clickElement(CHK_BOX_AGE_POLICY);
        clickElement(BTN_CREATE_ACCOUNT);
    }

    public void registerByDataStoreValues(String emailAddress, String confirmEmailAddress, String usernameVariableName, String passwordVariableName, String firstName,
                         String lastName, String role){
        setTextAs(TXT_EMAIL_ADDRESS, emailAddress);
        setTextAs(TXT_CONFIRM_EMAIL_ADDRESS, confirmEmailAddress);
        clearText(TXT_USERNAME);
        setTextAs(TXT_USERNAME, baseObj.getSpecificationDataStoreValue(usernameVariableName));
        setTextAs(TXT_PASSWORD, baseObj.getSpecificationDataStoreValue(passwordVariableName));
        setTextAs(TXT_FIRST_NAME, firstName);
        setTextAs(TXT_LAST_NAME, lastName);
        selectFromDropdown("//select[@id='roleSelect']", role);
        clickElement(CHK_BOX_PRIVACY_POLICY);
        clickElement(CHK_BOX_AGE_POLICY);
        clickElement(BTN_CREATE_ACCOUNT);
    }

    public String formHeaderTitle(){
        return getText(FORM_HEADER);
    }


}
