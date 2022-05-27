package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class EducationLoanPage {

    public WebDriver driver;

    public EducationLoanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[13]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]")
    private WebElement edit_LoanAmount;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[13]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/input[1]")
    private WebElement edit_InterestRate;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[13]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/input[1]")
    private WebElement edit_LoanPeriod;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[13]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/input[1]")
    private WebElement edit_EMIStartsAfter;
    @FindBy(how = How.XPATH, using = "/html/body/div[13]/section[1]/div/div/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div[4]/a[1]")
    private WebElement btn_Submit;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[13]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/span[2]")
    private WebElement txt_TotalPayment;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[13]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/span[2]")
    private WebElement txt_InterestChargesPayment;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[13]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/span[2]")
    private WebElement txt_EMI;

    public Map<String, String> GetPaymentInformation(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("TotalPayment", txt_TotalPayment.getText().trim());
        map.put("InterestChargesPayment", txt_InterestChargesPayment.getText().trim());
        map.put("emi", txt_EMI.getText().trim());
        return map;
    }


    public void EnterLoanInformation(String loanAmount, String interestRate, String loanPeriod, String emiStartsAfter) throws InterruptedException {
        edit_LoanAmount.clear();
        Thread.sleep(1000);
        edit_LoanAmount.sendKeys(loanAmount);
        Thread.sleep(1000);
        edit_InterestRate.clear();
        Thread.sleep(1000);
        edit_InterestRate.sendKeys(interestRate);
        Thread.sleep(1000);
        edit_LoanPeriod.clear();
        Thread.sleep(1000);
        edit_LoanPeriod.sendKeys(loanPeriod);
        Thread.sleep(1000);
        edit_EMIStartsAfter.clear();
        Thread.sleep(1000);
        edit_EMIStartsAfter.sendKeys(emiStartsAfter);
        Thread.sleep(3000);
        btn_Submit.click();
    }


}
