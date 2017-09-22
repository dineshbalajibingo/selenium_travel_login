package com.phptravels.util;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	static String name;
	
	public static boolean isTestSuiteExecutable(String testSuite, Xls_Reader xls){
		  
		  
		  for(int rNum=2;rNum<=xls.getRowCount("Test Suite");rNum++){
		  
		   if(testSuite.equals(xls.getCellData("Test Suite", "TestSuite", rNum))){
		    // check runmode
		     if(xls.getCellData("Test Suite", "RunMode", rNum).equals("Y"))
		     return true;
		    else
		     return false;
		   }
		    
		  }
		  
		  return false;
		  
		 }
		 
		 
		 public static boolean isTestFunctionExecutable(String testCase, Xls_Reader xls){

		  for(int rNum=2;rNum<=xls.getRowCount("TestFunction");rNum++){
		  
		   if(testCase.equals(xls.getCellData("TestFunction", "TestCases", rNum)))
		   { 
			   //System.out.println("Row Number ------->" +rNum+"" +testCase);
			  // System.out.println("Run Mode is " +xls.getCellData("TestFunction", "RunMode", rNum));
			   
		    // check runmode
		     if(xls.getCellData("TestFunction", "RunMode", rNum).equals("Y"))
		     return true;
		      else
		     return false;
		   }
		    
		  }
		  
		  return false;
		  
		 }
		 
		 public static boolean checkCarddropOptions(String cardName, Xls_Reader xls){
			  
			  
			  for(int rNum=2;rNum<=xls.getRowCount("FeePaytermOptions");rNum++){
			  
			   if(cardName.equals(xls.getCellData("FeePaytermOptions", "CreatePackage", rNum))){
			    // check runmode
			     if(xls.getCellData("FeePaytermOptions", "RunMode", rNum).equals("Y"))
			     return true;
			    else
			     return false;
			   }
			    
			  }
			  
			  return false;
			  
			 }
		 
/*		 
		 public static void takeScreenShot(String fileName) {
		  File srcFile = ((TakesScreenshot)(TestBase.driver)).getScreenshotAs(OutputType.FILE);
		     try {
		      FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".jpg"));
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		    
		   
		 }
		 
		 public static String captureScreenshot(WebDriver driver, String screenShotName)
		 {
		  
		  try
		  {
		   TakesScreenshot ts = (TakesScreenshot)driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
		   String dest = System.getProperty("user.dir")+"\\screenshots\\"+screenShotName+".jpg";
		   
		   File destination = new File(dest);
		   FileUtils.copyFile(source, destination);
		   System.out.println("Screen Shot Taken");
		   return dest;
		  }
		  catch(Exception e)
		  {
		   System.out.println("Exception While Taking Screen Shot " + e.getMessage());
		   return e.getMessage();
		  }
		  
		  
		  
		  
		 }
		 */
		//Getting the current Methid Name
		 
		 
		 public static void getCurrentMethodName()
		 {
		  
		 }
		 
		 
		 public static Object[][] getData(String sheetName ,String testCase,Xls_Reader xls){
		  System.out.println("*******sheetName******"+ sheetName);
		  // find the test in xls
		  // find number of cols in test
		  // number of rows in test
		  // put the data in hashtable and put hashtable in object array
		  // return object array
		  
		  int testCaseStartRowNum=0;
		  for(int rNum=1;rNum<=xls.getRowCount(sheetName);rNum++){
		   if(testCase.equals(xls.getCellData(sheetName, 0, rNum))){
		    testCaseStartRowNum = rNum;
		    break;
		   }
		  }
		  //System.out.println("Test Starts from row -> "+ testCaseStartRowNum);
		  
		  
		  // total cols
		  int colStartRowNum=testCaseStartRowNum+1;
		  //System.out.println("ColumSTart Row Number is " +colStartRowNum);
		  int cols=0;
		  while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
		   cols++;
		  }
		  //System.out.println("Total cols in test -> "+ cols);
		  

		  // rows
		  int rowStartRowNum=testCaseStartRowNum+2;
		  //System.out.println("Row Start Row Number is " +rowStartRowNum);
		  int rows=0;
		  while(!xls.getCellData(sheetName, 0, (rowStartRowNum+rows)).equals("")){
		   rows++;
		  }
		 // System.out.println("Total rows in test -> "+ rows);
		  Object[][] data = new Object[rows][1];
		  Hashtable<String,String> table=null;
		  
		  // print the Login_SignUp_TestData
		  for(int rNum=rowStartRowNum;rNum<(rows+rowStartRowNum);rNum++){
		  table=new Hashtable<String,String>();
		   for(int cNum=0;cNum<cols;cNum++){
		    table.put(xls.getCellData(sheetName, cNum, colStartRowNum),xls.getCellData(sheetName, cNum, rNum));
		    //System.out.print(xls.getCellData("Login_SignUp_TestData", cNum, rNum)+" - ");
		   }
		   data[rNum-rowStartRowNum][0]=table;
		   //System.out.println();
		  }

		  return data;// dummy
		  
		  
		  
		  
		 }
		 

}
