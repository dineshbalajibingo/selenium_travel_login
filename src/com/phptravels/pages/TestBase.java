package com.phptravels.pages;

import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.phptravels.util.Xls_Reader;

public class TestBase {

	public static Properties CONFIG = new Properties();
	public static WebDriver driver = null;
	protected Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\phptravels\\testdata\\TestData.xlsx");
	String environment = xls.getCellData("Environment", 0, 2);
	String Status=xls.getCellData("Environment", 1, 2);
	String itUrl = xls.getCellData("Environment", 1, 6);
	String uatURL = xls.getCellData("Environment", 1, 10);
	protected Logger log = Logger.getLogger("devpinoyLogger");
	
	public void initDriver()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\com\\phptravels\\drivers\\geckodriver.exe");
		ProfilesIni profile = new ProfilesIni();

		FirefoxProfile myprofile = profile.getProfile("etmtesting");
		driver = new FirefoxDriver(myprofile);
	
	}
	
	public void navigatePage()
	{
	if(environment.equals("IT") && Status.equals("Y"))
	{	
	driver.get(itUrl);
	}
	else
	{
		driver.get(uatURL);
	}
		driver.manage().window().maximize();	
	}
	
	public void closeDriver(){
		
		driver.close();
	}
	
	
	
	
}
