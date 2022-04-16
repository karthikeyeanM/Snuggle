package org.Scrum;

import java.util.concurrent.TimeUnit;

import org.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends BaseClass{
	@Given("in the snuggle bugs")
	public void in_the_snuggle_bugs() {
		
		launchUrl("https://www.snugglebugz.ca/");
		implicitWait(20, TimeUnit.SECONDS);
		WebElement close = driver.findElement(By.xpath("//button[text()='No Thanks']"));
		click(close);
	   
	}

	@When("move to Deals")
	public void move_to_Deals() {
		WebElement deals = driver.findElement(By.xpath("//a[text()='Deals']"));
	    moveToElement(deals);
	}

	@When("click gift for baby")
	public void click_gift_for_baby() {
		WebElement baby = driver.findElement(By.xpath("//a[text()='Gifts For Baby (6-12M)']"));
		click(baby);
	    
	}

	@When("click Bonikka dolls")
	public void click_Bonikka_dolls() {
		WebElement doll = driver.findElement(By.xpath("//a[text()='Bonikka Dolls']"));
	    click(doll);
	}

	@When("quantity is {int}")
	public void quantity_is(Integer int1) {
		WebElement inc = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
		click(inc);
		WebElement dec = driver.findElement(By.xpath("(//button[@type='button'])[5]"));
		click(dec);
	    
	}

	@Then("click cart")
	public void click_cart() {
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"cart_link_desktop\"]/svg"));
		click(cart);
	   
	}



}
