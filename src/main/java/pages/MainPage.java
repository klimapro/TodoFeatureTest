package pages;

import Widgets.ToDoWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@placeholder='add new todo here']")
    private WebElement inputField;

    @FindBy(xpath = "//*[@value='add']")
    private WebElement addButton;

    @FindBy(xpath = "//*[@ng-click='todoList.archive()']")
    private WebElement archiveButton;

    @FindBy(xpath = "//li[@ng-repeat='todo in todoList.todos']")
    private List<WebElement> taskList;

    @FindBy(xpath = "//span[@class='done-false']")
    private List<WebElement> uncheckedTaskList;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createTasks(List<String> tasks) {
        for (String str : tasks) {
            inputField.sendKeys(str);
            addButton.click();
        }
    }

    public List<String> getTasksList() {
        List<String> tasks = new ArrayList<String>();
        for (WebElement element : taskList) {
            tasks.add(element.getText());
        }
        return tasks;
    }

    public void clearDefaultTasks() {
        if (!uncheckedTaskList.isEmpty()) {
            for (int i = 0; i < uncheckedTaskList.size(); i++) {
                uncheckedTaskList.get(i).click();
            }
        }
        archiveButton.click();
    }
}
