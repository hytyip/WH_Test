package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;

public class WilliamHill {
	public WebDriver driver;
	public static String browser = "Firefox"; //Choose between "Chrome" or "Firefox"
	public double stake = 0.05;
	public String odds;
	public String return_value;
	
	public WilliamHill() {
		driver = Hooks.driver;
	}

	@Given("^Open WilliamHill website$")
	public void open_williamhill_website() throws Throwable {
        // Open web browser and navigate to william hill sports
        driver.get("http://sports.williamhill.com/sr-admin-set-white-list-cookie.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	
	@When("^Click on Football$")
	public void click_on_football() throws Throwable {
		//click on football button
		driver.findElement(By.id("nav-football")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^Validate url$")
	public void validate_url() throws Throwable {
		//verify the football url
		assertEquals("Wrong url", "http://sports.williamhill.com/betting/en-gb/football", driver.getCurrentUrl());
		//Thread.sleep(2000);
	}
	
	@When("^Click Home on the first event$")
	public void click_home_on_the_first_event() throws Throwable {
		//Wait for the football page to load
		driver.findElement(By.id("match-highlights"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Click the first Home odds button
		driver.findElements(By.xpath("//*[starts-with(@id, 'OB_OU')]")).get(0).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);
	}
	
	@When("^Enter 0.05 on bet$")
	public void enter_value_on_bet() throws Throwable{
		//enter 0.05 on stake input
		driver.findElement(By.xpath("//*[starts-with(@id, 'stake-input_')]")).sendKeys("0.05");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^Validate Total stake value, odds and return value$")
	public void validate_total_stake_odds_return_value() throws Throwable{
		//Verify the stake value
		assertEquals("Wrong stake value", Double.toString(stake), driver.findElement(By.className("betslip-footer__total-stake")).findElement(By.id("total-stake-price")).getText());
		//Get the odds value
		odds = driver.findElement(By.xpath("//*[starts-with(@id, 'bet-price_')]")).getText();
		//Calculate the return value
		String[] parts = odds.split("/");
		double odds_value = Integer.parseInt(parts[0]) / Integer.parseInt(parts[1]);
		double return_value = (odds_value * stake) + stake ;
		System.out.println("The odd value is " + odds_value);
		System.out.println("The return value is " + return_value);
		//Verify the correct return value
		assertEquals("Wrong return value", Double.toString(return_value), driver.findElement(By.className("betslip-footer__to-return")).findElement(By.id("total-stake-price")).getText() );
	}

}
