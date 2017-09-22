package com.phptravels.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.phptravels.pages.TestBase;
import com.phptravels.pageobjectlocators.*;


public class LoginPage extends TestBase{
	
	
	/* Initializing WebDriver for the page*/
	public WebDriver driver;
	
	/* Mapping the Object locators to the page*/
	@FindBy(xpath =LoginLocators.email)
	@CacheLookup
	public WebElement email;
	
	@FindBy(xpath =LoginLocators.password)
	@CacheLookup
	public WebElement password;
	
	@FindBy(xpath =LoginLocators.login_button)
	@CacheLookup
	public WebElement login_button;
	
	/* Initializing a constructor and Passing the driver Object*/
	
	@FindBy(xpath =LoginLocators.forget_password)
	@CacheLookup
	public WebElement forget_password;
	
	@FindBy(xpath =LoginLocators.remember_me)
	@CacheLookup
	public WebElement remember_me;
	
	
	@FindBy(xpath =LoginLocators.login_error)
	@CacheLookup
	public WebElement login_error;
	
	@FindBy(xpath =LoginLocators.back_forgot_password)
	@CacheLookup
	public WebElement back_forgot_password;
	
	
	
	public LoginPage(WebDriver dr)
	{
		driver=dr;
	}
	
	public LoginPage enterEmail(String username)
	{
		email.sendKeys(username);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return this;
	}
	public LoginPage enterPassword(String passwordtxt)
	{
		password.sendKeys(passwordtxt);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		letsWait();
		return this;
	}
	public void clickLogin()
	{
		
		login_button.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		letsWait();
	}
	
	public void forgetPassword()
	{
		
		forget_password.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		letsWait();
	}
	
	public void rememberMe()
	{
		
		remember_me.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public String loginError()
	{
		String msg = login_error.getText();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return msg;
		
		
	}
	
	public void clickBackbutton()
	{
		
		back_forgot_password.click();
		letsWait();
	}
	
	public void deleteKey()
	{
		
		password.sendKeys(Keys.BACK_SPACE);	
		letsWait();
		
	}
	
	
	public void letsWait()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
