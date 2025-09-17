package com.clientname.projectname.genricutil.WebDriverUtil;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
	WebDriver driver;

	public void implicitWait(WebDriver driver, int wait) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

	}

	public void waitUntilVisiblityOf(WebDriver driver, WebElement element, int wait) {
		WebDriverWait wDriver = new WebDriverWait(driver, Duration.ofSeconds(wait));
		wDriver.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilTextToBePresent(WebDriver driver, WebElement element, String text, int wait) {
		WebDriverWait wDriver = new WebDriverWait(driver, Duration.ofSeconds(wait));
		wDriver.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element, int wait) {
		WebDriverWait wDriver = new WebDriverWait(driver, Duration.ofSeconds(wait));
		wDriver.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void switchToAlertCance(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);

	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}

	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	public void selectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}

	public void selectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	public void deSelectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);

	}

	public void deSelectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);

	}

	public void deSelectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.deselectByValue(value);

	}

	public void deSelectAll(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();

	}

	public void getAllSelectedOptions(WebElement element) {
		Select sel = new Select(element);
		sel.getAllSelectedOptions();

	}

	public void getAllOptions(WebElement element) {
		Select sel = new Select(element);
		sel.getOptions();

	}

	public void SelectBy(WebElement element) {
		Select sel = new Select(element);
		sel.selectByIndex(0);

	}

	public void doubleClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();

	}

	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();

	}

	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();

	}

	public void dragAndDrop(WebDriver driver, WebElement elementOne, WebElement elementSecond) {
		Actions act = new Actions(driver);
		act.dragAndDrop(elementOne, elementSecond).perform();

	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

}
