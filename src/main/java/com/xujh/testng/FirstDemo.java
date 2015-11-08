package com.xujh.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FirstDemo {

	@Test
	public static void openAllLinks() throws Exception {

		// System.setProperty("webdriver.firefox.bin",
		// "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.baidu.com");
		
		Thread.sleep(15000);

		// starts-with, ends-with, contains
		// List links = driver.findElements(By.xpath("//a[starts-with(@href,'http')]"));
		// ^=, $=, *=
		List<WebElement> links = driver.findElements(By.cssSelector("a[href^='http']"));

		if (links != null && links.size() > 0) {

			System.out.println(links.size());

			for (int i = 0; i < links.size(); i++) {
				System.out.println(((WebElement) links.get(i)).getText()
						+ "-->isDisplayed:"
						+ ((WebElement) links.get(i)).isDisplayed()
						+ "-->isEnabled:"
						+ ((WebElement) links.get(i)).isEnabled());
				System.out.println(((WebElement) links.get(i))
						.getAttribute("href") + "\n");

				if (((WebElement) links.get(i)).isDisplayed()) {

					Actions builder = new Actions(driver);
					builder.keyDown(Keys.CONTROL)
							.click((WebElement) links.get(i))
							.keyUp(Keys.CONTROL).build().perform();
				}
			}
		}

		driver.close();

	}

}
