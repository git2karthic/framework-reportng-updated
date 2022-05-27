package com.automation.tests;

import com.automation.pages.EducationLoanPage;
import com.automation.pages.HomePage;
import com.automation.utility.TestConfigUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test_Loan {

    WebDriver driver;

    @BeforeMethod
    public void Initialize() throws IOException {
        System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/com/automation/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(TestConfigUtil.GetConfigValue("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void Test_EducationLoanCalculation_1() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.NavigateToEducationLoanPage();
        Reporter.log("im in first test");
        EducationLoanPage educationLoanPage = new EducationLoanPage(driver);
        educationLoanPage.EnterLoanInformation("1000000", "10", "10", "20");
        Map<String, String> map = educationLoanPage.GetPaymentInformation();
        Reporter.log(String.valueOf(map));


    }

    @Test
    public void Test_EducationLoanCalculation_2() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.NavigateToEducationLoanPage();
        Reporter.log("im in second");
        EducationLoanPage educationLoanPage = new EducationLoanPage(driver);
        educationLoanPage.EnterLoanInformation("1000000", "10", "10", "20");
        Map<String, String> map = educationLoanPage.GetPaymentInformation();
        Reporter.log(String.valueOf(map));


    }
    
    @AfterMethod
    public void CloseBrowser() {
    	driver.close();
    }
}
