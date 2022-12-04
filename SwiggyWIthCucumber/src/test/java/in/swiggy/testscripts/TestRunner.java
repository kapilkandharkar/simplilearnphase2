package in.swiggy.testscripts;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "Features"
		,glue = "in.swiggy.testscripts"
)

public class TestRunner extends  AbstractTestNGCucumberTests{

}
