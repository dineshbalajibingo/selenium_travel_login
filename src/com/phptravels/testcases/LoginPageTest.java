package com.phptravels.testcases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.phptravels.pages.TestBase;
import com.phptravels.pages.LoginPage;
import com.phptravels.util.TestUtil;

public class LoginPageTest extends TestBase{
	
LoginPage loginPage;
	
	@BeforeSuite
	public void init()
	{
		initDriver();
		navigatePage();
	
	}
	
	@BeforeTest
	public void beforeTest()
	{
		loginPage=PageFactory.initElements(driver, LoginPage.class);
			
	}
	
	@Test(dataProvider = "getLoginData")
	public void login(Hashtable<String,String> data) throws Exception
	{

		loginPage.enterEmail(data.get("Username"));
		loginPage.enterPassword(data.get("wrong_Password"));
		loginPage.clickLogin();
		
		//Validate Login Error Message on bad password

		System.out.println("System Error Message: " + loginPage.loginError());
		String expError = data.get("Error");
		
		//Test Case: Check if bad Password is provided, it did not get you into the system
		
	
		//Test Case 2: Validate Forgot Password is working
		loginPage.forgetPassword();
		loginPage.clickBackbutton();
		
		//Test Case 3: Login Workign as expected
		loginPage.deleteKey();
		//loginPage.enterPassword(data.get("correct_Password"));
		loginPage.rememberMe();
		loginPage.clickLogin();
		log.info("User Logged In successfully ");
		//Assert.assertEquals(loginPage.loginError(), expError);
	
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		return TestUtil.getData("Login_Test","Login",xls);
	}
	
	@AfterSuite
	public void tearDown()
	{
		
	}
	
	

}
