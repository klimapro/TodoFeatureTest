import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class TestTodoFeature {
    WebDriver driver;
    MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/TechTask/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://angularjs.org/");
    }

    @After
    public void setOff() {
        driver.close();
    }

    @Test
    public void test() {
        mainPage = new MainPage(driver);
        List<String> tasks = Arrays.asList(new String[]{"task1", "task2", "task3"});
        mainPage.clearDefaultTasks();
        mainPage.createTasks(tasks);
        Assert.assertThat("Tasks list is wrong", tasks, is(mainPage.getTasksList()));
    }
}
