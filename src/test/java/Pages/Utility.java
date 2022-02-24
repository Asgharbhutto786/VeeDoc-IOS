package Pages;


import org.openqa.selenium.By;

import Tests.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;


public class Utility {
	public IOSDriver<MobileElement> driver;

	public Utility() {
		this.driver = (IOSDriver<MobileElement>) BaseClass.getDriverInstance();

	}

	public void waitForElement(WebDriver d,WebElement element) throws Exception{
		WebDriverWait wait = new WebDriverWait(d, 100);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void fluentWaitForElement(WebDriver d,WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(d)
				.withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(Exception.class)
				.ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementEnabled(WebDriver d,WebElement element) throws Exception{
		WebDriverWait wait = new WebDriverWait(d, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickButton(MobileElement buttonLocator) throws Exception {
		waitForElementEnabled(driver, buttonLocator);
		buttonLocator.click();
	}

	public void clearText(MobileElement locator) throws Exception {
		waitForElementEnabled(driver, locator);
		locator.clear();
	}
	
	public void setText(MobileElement locator, String value) {
		fluentWaitForElement(driver,locator);
		locator.sendKeys(value);
	}

	public void Wait() throws InterruptedException {
		Thread.sleep(5000);
	}

	
	public String getTextFunc(MobileElement locator) {
		fluentWaitForElement(driver,locator);
		return locator.getText();
	}

	public void clickTextView(String textView) {
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+textView+"')]")).click();;
	}
	
	
	
	public void hideKeyboard() throws Exception {
		String keyDone = "label == \"Done\"";
		MobileElement  hideKyeboard =  driver.findElement(MobileBy.iOSNsPredicateString(keyDone));
		waitForElementEnabled(driver, hideKyeboard);
		hideKyeboard.click();
	}
}
