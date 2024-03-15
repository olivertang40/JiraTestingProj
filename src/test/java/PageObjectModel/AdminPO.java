package PageObjectModel;

import Drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Set;

public class AdminPO extends BasePO {

    @FindBy(id = "group_browser")
    public WebElement groupsBtn;

    @FindBy(name = "addName")
    public WebElement nameInput;

    @FindBy(name = "add_group")
    public WebElement addGroupBtn;

    @FindBy(id = "edit_members_of_test")
    public WebElement editGroupMemberBtn;

    @FindBy(xpath = "//span[@title='Select a user(s)']")
    public WebElement editIcon;

    @FindBy(xpath = "//input[@value = 'test']")
    public WebElement user;

    @FindBy(id = "multiselect-submit")
    public WebElement saveSelection;

    @FindBy(id = "add-users-to-selected-groups")
    public WebElement addSelectedUsersBtn;

    @FindBy(xpath = "//option[@value= 'test,test']")
    public WebElement addedGroupMember;


    public void groupsBtnClick() {
        groupsBtn.click();
    }

    public void inputGroupName(String groupName) {
        nameInput.sendKeys(groupName);
    }

    public void addGroupBtnClick() {
        addGroupBtn.click();
    }

    public void editGroupMember() {
        editGroupMemberBtn.click();
        editIcon.click();

        WebDriver driver = DriverFactory.getDriver();
        String originalWindow = driver.getWindowHandle();
        System.out.println(originalWindow);

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!originalWindow.equals(handle)) {
                driver.switchTo().window(handle);
                System.out.println(handle);
            }
        }

        user.click();
        saveSelection.click();
        driver.switchTo().window(originalWindow);
        addSelectedUsersBtn.click();
    }

    public void verifyGroupMemberName(String username) {
        Assert.assertEquals(addedGroupMember.getText(), username);
    }
}
