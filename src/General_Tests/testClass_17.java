package General_Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataPackage.LeadingVehicle;
import dataPackage.UserInputs;
import dataPackage.VehicleData;
import dataPackage.WeatherInputs;
import servicePackage.SpeedController;
import servicePackage.StateController;
import servicePackage.WeatherController;

public class testClass_17 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 17 started ****\n");
		weatherInputs.setRainDesnsity(8.4f);
		weatherInputs.setWindDirection(120);
		weatherInputs.setWindSpeed(24);
	}
	
	@Test
	public void testFunction(){
			
		Assert.assertEquals("extreme", weatherController.detectWeather(weatherInputs));
		System.out.println("Weather Status : "+weatherController.detectWeather(weatherInputs));
		System.out.println("\n**** Test case 17 ended ****\n\n");
	}
}
