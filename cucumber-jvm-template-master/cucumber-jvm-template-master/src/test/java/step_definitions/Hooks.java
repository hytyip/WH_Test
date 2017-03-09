package step_definitions;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.*;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
    public static WebDriver driver;

    
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
    	if (WilliamHill.browser.equals("Chrome")){
    	//Open Chrome
    		System.out.println("Open Chrome Browser");
    		System.setProperty("webdriver.chrome.driver", "C:\\Cucumber\\chromedriver.exe");
    		driver = new ChromeDriver();
    	} else if (WilliamHill.browser.equals("Firefox")){
    		FirefoxProfile prof = new FirefoxProfile();
    		prof.setPreference("xpinstall.signatures.required", false);
    	    prof.setPreference("toolkit.telemetry.reportingpolicy.firstRun", false);
    		System.out.println("Open Firefox Browser");
    		driver = new FirefoxDriver(prof);
    	}
    	
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    }

     
    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
       
        if(scenario.isFailed()) {
        try {
        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
        driver.quit();
        
    }
    
}