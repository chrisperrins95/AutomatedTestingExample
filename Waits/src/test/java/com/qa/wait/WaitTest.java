package com.qa.wait;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class WaitTest {

	WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chris\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testy() {
		driver.get("https://chrisperrins95.github.io/AutomatedTestingExample/");
		WaitPage waitPage = PageFactory.initElements(driver, WaitPage.class);
		System.out.println(waitPage.getElement(driver).getText());
	}
	
	@After
	public void teardown() {
		driver.close();
	}
}
