package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePO extends BasePO {

    @FindBy(xpath = "//span[contains(@class, 'aui-iconfont-configure')]")
    public WebElement dropMenu;

    @FindBy(id = "admin_users_menu")
    public WebElement userManagement;

    @FindBy(xpath = "//a[@id='browse_link']")
    public WebElement projectBtn;

    @FindBy(id = "admin_main_proj_link_lnk")
    public WebElement JiraTestBtn;

    @FindBy(xpath = "//input[@name=\"webSudoPassword\"]")
    public WebElement passwordInput;

    @FindBy(id = "login-form-submit")
    public WebElement confirmBtn;

    public void clickDropMenu() {
        dropMenu.click();
    }

    public void clickUserManageBtn() {
        userManagement.click();
    }

    public void clickProjectsBtn(){projectBtn.click();}

    public void clickJiraTestProject()
    {
        JiraTestBtn.click();
    }

    public void enterAdminCredential(String password) {
        passwordInput.sendKeys(password);
        confirmBtn.click();
    }
}
