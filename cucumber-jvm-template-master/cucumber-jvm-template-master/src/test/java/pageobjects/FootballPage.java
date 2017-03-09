package pageobjects;
import helpers.Log;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FootballPage extends BaseClass{

	public FootballPage(WebDriver driver){
		super(driver);
	}    

	
	@FindBy(how=How.ID, using="match-highlights")
	public static WebElement highlights;
	
	@FindBy(how=How.XPATH, using="//*[starts-with(@id, 'OB_OU')]")
	public static List<WebElement> Home_odds_btns;
	
	@FindBy(how=How.XPATH, using="//*[starts-with(@id, 'stake-input_')]")
	public static WebElement Stake_input;
	
	@FindBy(how=How.ID, using="total-stake-price")
	public static WebElement total_price;
	

	
		
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
