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

    @FindBy(xpath = "//a[@data-label='Backlog']")
    public WebElement backlogBtn;

    @FindBy(xpath = "//a[@data-label='Active sprints']")
    public WebElement activeSprintBtn;

    @FindBy(xpath = "(//button[@class='aui-button aui-button-subtle'])[2]")
    public WebElement backlogIssue;

    @FindBy(xpath = "(//button[@class='aui-button aui-button-subtle'])[1]")
    public WebElement sprintIssue;

    @FindBy(xpath = "(//textarea[@name='summary'])[2]")
    public WebElement backlogIssueInput;

    @FindBy(xpath = "(//textarea[@name='summary'])[1]")
    public WebElement sprintIssueInput;

    public void clickCreateSprint() {
        createSprintBtn.click();
    }

    public void clickConfirm() {
        createConfirmBtn.click();
    }

    public void clickBacklogBtn(){
        backlogBtn.click();
    }

    public void clickActiveSprintBtn(){
        activeSprintBtn.click();
    }

    public void clickCreateBacklogIssue(){
        backlogIssue.click();
    }

    public void inputBacklogIssue(String message){
        backlogIssueInput.sendKeys(message);
        backlogIssueInput.sendKeys(Keys.ENTER);
    }

}
