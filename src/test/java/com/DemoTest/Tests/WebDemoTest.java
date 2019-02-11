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
    @Test(dataProvider = "hardCodedBrowsers")
    public void LoginTestSuite(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
    	
    	Boolean value = true;

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting sauce labs demo page...");
        WebDemoPage page = WebDemoPage.visitPage(driver);
        
        this.annotate("Login Test..");
        Boolean returnvalue = page.Login("standard_user", "secret_sauce");
        
        this.annotate("Login Locked out user Test..");
        Boolean returnedvalue = page.LoginLockedoutUser("locked_out_user", "secret_sauce");
        
        // 
        this.annotate("Login Performance Glitch user Test..");
        Boolean returnedvalueglitch = page.LoginPerfGlitchUser("performance_glitch_user", "secret_sauce");
        


        this.annotate("Asserting that we are on a new page...");
        Assert.assertEquals(value,returnvalue);
    }


}