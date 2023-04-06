package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class GreencartStepDefinition {
	public WebDriver driver;
	public String  offerPageProduct;
	public String landingPageproduct;
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() 
	{
		 System.setProperty("webdriver.chrome.driver","C:\\.Development_Avecto\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	  
	}
	@When("User searched for shortname {string} and extracting actual name of product")
	public void user_searched_for_shortname_and_extracting_actual_name_of_product(String string) throws InterruptedException 
	{
	  driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Tom");
	  Thread.sleep(2000);
	  String landingPageproduct=driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	System.out.println(landingPageproduct +"is extracted from HomePage");
	}
	
	@Then("User searched for same shortname {string} in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String string1) throws InterruptedException 
	{
	   driver.findElement(By.linkText("Top Deals")).click();
	   Set<String> s1=driver.getWindowHandles();
	Iterator<String> i= s1.iterator();
	String parentwindow=i.next();  //control will go from first index
	String childWindow=i.next();  // control will go to 2nd child index
	driver.switchTo().window(childWindow);
	driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Tom");
	Thread.sleep(2000);
	String offerPageProduct=driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	System.out.println(offerPageProduct +"is extracted from offerPage");
	}
	
	@Then("validate product name in offer page matches with landing page")
	public void validate_product_name_in_offer_page_matches_with_landing_page()
	{
		Assert.assertEquals(landingPageproduct, offerPageProduct);
	} 
}
