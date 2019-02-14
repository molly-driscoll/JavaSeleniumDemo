package com.DemoTest.Tests;

import com.DemoTest.Pages.WebDemoPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;


public class WebDemoTest extends TestBase {

    /**
     * 
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */

	 @Test(dataProvider = "hardCodedBrowserslinux")
	    public void Login(String browser, String version, String os, Method method)
	            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
	    	
		    System.out.println("\nStarting Login Function for Dataprovider HardCOdedBrowsersLinux");
	    	Boolean value = true;

	        //create webdriver session
	    	
	        this.createDriverlinux(browser, version, os, method.getName());
	        WebDriver driver = this.getWebDriver();

	        this.annotate("Visiting sauce labs demo page...");
	        WebDemoPage page = WebDemoPage.visitPage(driver);
	        
	        this.annotate("Login Test..");
	        Boolean returnvalue = page.Login("standard_user", "secret_sauce");
	        
	        this.annotate("Asserting the test: Login Test: result");
	        Assert.assertEquals(value,returnvalue);

	             
	    }


	 @Test(dataProvider = "hardCodedBrowsers")
	    public void Loginother(String browser, String version, String os, Method method)
	            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
	    	
		 
		 System.out.println("\nStarting Login Function for Dataprovider HardCOdedBrowsers");
		 // add boolean variable 
	    	Boolean value = true;
	    	
	    	// Added comment to sync file 

	    	
	    	 System.out.println("\nCreate an instance of the driver");
	        //create webdriver session
	        this.createDriver(browser, version, os, method.getName());
	        WebDriver driver = this.getWebDriver();

	        this.annotate("Visiting sauce labs demo page...");
	        WebDemoPage page = WebDemoPage.visitPage(driver);
	        
	       
	        
	        this.annotate("Login Test..");
	        Boolean returnvalue = page.Login("locked_out_user", "secret_sauce");
	        
	        this.annotate("Asserting the test: Login: result");
	        Assert.assertEquals(value,returnvalue);

	        
	     
	    }
	    
	    

	 /**
	@Test(dataProvider = "hardCodedBrowsers")
	    public void LoginPerfGlitchUser(String browser, String version, String os, Method method)
	            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
	    	
	    	Boolean value = true;

	        //create webdriver session
	        this.createDriver(browser, version, os, method.getName());
	        WebDriver driver = this.getWebDriver();

	        this.annotate("Visiting sauce labs demo page...");
	        WebDemoPage page = WebDemoPage.visitPage(driver);
	        
	       
	         // 
	        this.annotate("Login Performance Glitch user Test..");
	        Boolean returnedvalueglitch = page.LoginPerfGlitchUser("performance_glitch_user", "secret_sauce");
	        
	        this.annotate("Asserting the test: Login Performance Glitch user Test: result");
	        Assert.assertEquals(value,returnedvalueglitch);
	        
	             
	    }
**/



}