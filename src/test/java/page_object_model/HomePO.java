package page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePO extends BasePO{

    @FindBy(xpath = "//span[contains(@class, 'aui-iconfont-configure')]")
    private WebElement userManagement;

    public void clickUserManageBtn(){
        userManagement.click();
    }
}
