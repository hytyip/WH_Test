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

public class StakePage extends BaseClass{

	public StakePage(WebDriver driver){
		super(driver);
	}    

	@FindBy(how=How.XPATH, using="//*[starts-with(@id, 'bet-price_')]")
	public static WebElement bet_price;
	
	@FindBys({
	    @FindBy(className = "betslip-footer__total-stake"),
	    @FindBy(id = "total-stake-price")
	})
	public static WebElement total_stake;
	
	@FindBys({
		@FindBy(className = "betslip-footer__to-return-price-container"),
		@FindBy(id = "total-to-return-price") //change from total-stake-price
	})
	public static WebElement total_return;
		
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
