package com.qa.report;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingPage {
	@FindBy(id = "sb_form_q")
	private WebElement searchbox;
	
	public void search(String text) {
		searchbox.sendKeys(text);
		searchbox.submit();
	}
}
