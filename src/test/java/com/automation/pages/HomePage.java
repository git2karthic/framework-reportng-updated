package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div[1]/div[3]/nav/div/ul/li[9]/a")
    private WebElement link_PersonalFinance;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/header/div[1]/div[3]/nav/div/ul/li[9]/div/div[1]/ul/li[2]/ul[3]/li[5]/a")
    private WebElement link_EducationLoanCalculator;

    public void NavigateToEducationLoanPage(){
        Actions actions = new Actions(this.driver);
        actions.moveToElement(link_PersonalFinance).build().perform();
        link_EducationLoanCalculator.click();

    }


}
