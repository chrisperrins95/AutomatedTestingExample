package com.qa.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\qa\\cucumber\\Parametisation.feature", glue = {"com.qa.cucumber"})
public class Runner {

}
