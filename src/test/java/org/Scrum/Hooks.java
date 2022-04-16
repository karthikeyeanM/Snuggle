package org.Scrum;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	
	@Before
	public void bef() {
		
		launchBrowser();
		maximizeWindow();
		implicitWait(20, TimeUnit.SECONDS);
		
	}
	
	@After
	public void aft() throws IOException {
		screenShot();
		
	}
}
