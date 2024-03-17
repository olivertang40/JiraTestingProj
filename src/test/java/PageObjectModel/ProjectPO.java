package PageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPO extends BasePO {

    @FindBy(xpath = "//button[contains(@class,'js-add-sprint')]")
    public WebElement createSprintBtn;

    @FindBy(xpath = "//button[@class='aui-button aui-button-primary ghx-add-sprint-button']")
    public WebElement createConfirmBtn;

    ///div[@class='iic-trigger'][1]
    @FindBy(xpath = "//span[@data-fieldname='sprintName']")
    public WebElement sprintTitle;

    @FindBy(xpath = "(//button[@class='aui-button aui-button-subtle'])[1]")
    public WebElement backlogIssue;

    @FindBy(xpath = "(//textarea[@name='summary'])[1]")
    public WebElement issueInput;

    public void clickCreateSprint() {
        createSprintBtn.click();
    }

    public void clickConfirm() {
        createConfirmBtn.click();
    }

    public void clickBacklogIssue(){
        backlogIssue.click();
    }

    public void inputIssue(){
        issueInput.sendKeys("template issue");
        issueInput.sendKeys(Keys.ENTER);
    }

}
