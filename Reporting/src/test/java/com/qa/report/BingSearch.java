package com.qa.report;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BingSearch {
WebDriver driver = null;
public static ExtentReports report;
public ExtentTest test;
	
	@BeforeClass
	public static void initial() {
		report = new ExtentReports("C:\\Users\\Chris\\Desktop\\Empty\\BingWebpageTest.html", true);
	}

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chris\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void searchText() throws InterruptedException, IOException {
		test = report.startTest("Search Text");
		driver.get("https://www.bing.com/");
		test.log(LogStatus.INFO, "Bing Opened");
		BingPage bingPage = PageFactory.initElements(driver, BingPage.class);
		BingSearchedPage bingSearchedPage = PageFactory.initElements(driver, BingSearchedPage.class);
		
		bingPage.search("Selenium");
		test.log(LogStatus.INFO, "Search Run");
		if (bingSearchedPage.getSearch().getText().equals("Selenium")) {
			test.log(LogStatus.PASS, "Search Text was found");
		}
		else {
			test.log(LogStatus.FAIL, "Search Text was not found");
		}
		report.endTest(test);
		assertEquals("Selenium", bingSearchedPage.getSearch().getText());
	}
	
	@Test
	public void searchText2() throws InterruptedException, IOException {
		test = report.startTest("Search Text");
		driver.get("https://www.bing.com/");
		test.log(LogStatus.INFO, "Bing Opened");
		BingPage bingPage = PageFactory.initElements(driver, BingPage.class);
		BingSearchedPage bingSearchedPage = PageFactory.initElements(driver, BingSearchedPage.class);
		
		bingPage.search("selenium");
		test.log(LogStatus.INFO, "Search Run");
		if (bingSearchedPage.getSearch().getText().equals("Selenium")) {
			test.log(LogStatus.PASS, "Search Text was found");
		}
		else {
			test.log(LogStatus.FAIL, "Search Text was not found");
		}
		report.endTest(test);
		assertEquals("Seleniumss", bingSearchedPage.getSearch().getText());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void end() {
		report.flush();
	}
}
