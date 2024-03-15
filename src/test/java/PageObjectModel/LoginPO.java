package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//path = http://localhost:8080/login.jsp
public class LoginPO extends BasePO {

    @FindBy(id = "login-form-username")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='login-form-password']")
    public WebElement passwordInput;

    @FindBy(id = "login")
    public WebElement loginBtn;

    public void inputUserName(String username) {
        usernameInput.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
