package steps;

import base.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Step_Base extends TestBase {

	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
		System.out.println("The scenaro is *==================" + scenario.getName() + "=======================*");
	}

	


	@After
	public void afterScenario()  {
		
			System.out.println("******* End of Executing afterScenario");
		}
		

}
