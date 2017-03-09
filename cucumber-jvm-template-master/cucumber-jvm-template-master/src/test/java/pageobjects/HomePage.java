package pageobjects;
import helpers.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends BaseClass{

	public HomePage(WebDriver driver){
		super(driver);
	}    

	
	@FindBy(how=How.ID, using="nav-football")
	public static WebElement Football_btn;
	

		
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
