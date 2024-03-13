package page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePO extends BasePO{

    @FindBy(xpath = "//span[contains(@class, 'aui-iconfont-configure')]")
    public WebElement dropMenu;

    @FindBy(id = "admin_users_menu")
    public WebElement userManagement;

    @FindBy(xpath = "//input[@name=\"webSudoPassword\"]")
    public WebElement passwordInput;

    @FindBy(id = "login-form-submit")
    public WebElement confirmBtn;

    public void clickDropMenu(){
        dropMenu.click();
    }

    public void clickUserManageBtn(){
        userManagement.click();
    }

    public void enterAdminCredential(String password){
        passwordInput.sendKeys(password);
        confirmBtn.click();
    }
}
