package org.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert al;
	public static JavascriptExecutor js;
	public static Select s;

	public static void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void launchUrl(String url) {

		driver.get(url);
	}

	public static void maximizeWindow() {

		driver.manage().window().maximize();
	}

	public static void getTitle() {

		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void getCurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void close() {
		driver.close();

	}

	public static void quit() {
		driver.quit();

	}

	public static void sendKeys(WebElement element, String text) {

		element.sendKeys(text);
	}

	public static void click(WebElement element) {

		element.click();
	}

	public static void moveToElement(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public static void dragAndDrop(WebElement from, WebElement to) {
		a.dragAndDrop(from, to).perform();
	}

	public static void doubleClick(WebElement element) {
		a.doubleClick(element).perform();

	}

	public static void rightClick(WebElement element) {
		a.contextClick(element).perform();
	}

	public static void enterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void tabKey() {
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	public static void keyUp() {
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	public static void keyDown() {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void copy() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	public static void paste() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

	}

	public static void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public static void dismissAlert() {
		al.dismiss();
	}

	public static void valuesAlert(String text) {
		al.sendKeys(text);
	}

	public static void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].scrollIntoView(true)", element);

	}

	public static void scrollDown(WebElement element) {
		js.executeAsyncScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void javaScriptSendKeys(String text, WebElement element) {
		js.executeAsyncScript("arguments[0].setAttribute('values','text')", element);

	}

	public static void javaScriptClick(WebElement element) {
		js.executeAsyncScript("arguments[0].click()", element);

	}

	public static void javaScriptGetAttribute(WebElement element) {
		js.executeAsyncScript("returnarguments[0].getAttribute'value')", element);

	}

	public static void parentWindowHandle() {
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
	}

	public static void allWindowHandlesList(int indexno) {
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow);
		LinkedList<String> li = new LinkedList<String>();
		li.addAll(allWindow);
		driver.switchTo().window(li.get(indexno));

	}

	public static void selectByIndexDropDown(WebElement element, int indexno) {

		Select s = new Select(element);
		s.selectByIndex(indexno);

	}

	public static void selectByVisibleTextDropDown(String text) {
		s.selectByVisibleText(text);

	}

	public static void selectByValueDropDown(String text) {
		s.selectByValue(text);

	}

	public static void deselectByIndexDropDown(WebElement element, int indexno) {

		s.deselectByIndex(indexno);

	}

	public static void deselectByVisibleTextDropDown(String text) {
		s.deselectByVisibleText(text);

	}

	public static void deselectByValueDropDown(String text) {
		s.deselectByValue(text);

	}

	public static void deselectAll() {
		s.deselectAll();

	}

	public static void multipleDropDown() {
		boolean multiple = s.isMultiple();
		System.out.println(multiple);

	}

	public static void getOptionsDropDown() {
		java.util.List<WebElement> options = s.getOptions();
		for (WebElement All : options) {
			System.out.println(All);

		}
	}

	public static void getSelectedOptionDropDown() {
		java.util.List<WebElement> SelectedOptions = s.getAllSelectedOptions();
		for (WebElement selected : SelectedOptions) {
			System.out.println(selected);

		}

	}

	public static void getFirstOptionDropDown() {
		WebElement firstoption = s.getFirstSelectedOption();
		System.out.println(firstoption);

	}

	public static void implicitWait(long sec, TimeUnit Timeunit) {
		driver.manage().timeouts().implicitlyWait(10, Timeunit.SECONDS);
	}
	
	public void screenShot() throws IOException {
		
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Chidambaram\\eclipse-workkkkk\\MyOwn\\ScreenShot");
		FileUtils.copyDirectory(src, dest);
		

	}
}

