package day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

    public class day_2 {
        WebDriver driver;

        @BeforeTest
        public void setUpBrowser() throws Exception {
            String projectPath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectPath +"\\src\\test\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        @AfterMethod
        public void closeBrowser() throws Exception {
            driver.quit();
        }


        @Test
        public void testName() throws Exception {
            String searchText ="portnov school academy";
            navigateToURL();
            enterQuery(searchText);
            submitQuery();
            assertResults();
            waitForElement();
            closeBrowser();
            //closeBrowser();


        }

        private void waitForElement() {
            WebDriverWait wait=new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("compPagination")));
        }

        private void assertResults() throws InterruptedException {

            WebElement results=driver.findElement(By.className("compPagination"));

            assertTrue(results.isDisplayed());



        }

        private void submitQuery() {
            driver.findElement(By.id("uh-search-button")).click();
        }

        private void enterQuery(String text) {
            WebElement searchBar=driver.findElement(By.id("uh-search-box"));
            searchBar.sendKeys(text);
        }

        private void navigateToURL() {
            String BaseUrl= "https://www.yahoo.com/";
            driver.get(BaseUrl);
        }
    }


