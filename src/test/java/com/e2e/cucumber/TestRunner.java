package com.e2e.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\swaglab\\feature",
				glue = "com.e2e.cucumber.stepdefinition",
				monochrome = true,
				plugin = {"pretty", "html:target/cucumber-reports.html"}
		)

public class TestRunner {
	
	

}
