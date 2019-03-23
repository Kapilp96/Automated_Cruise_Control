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

public class testClass_23 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 23 started ****\n");
		weatherInputs.setRainDesnsity(3.5f);
		weatherInputs.setWindDirection(260);
		weatherInputs.setWindSpeed(8);
	}
	
	@Test
	public void testFunction(){
			
		Assert.assertEquals("normal", weatherController.detectWeather(weatherInputs));
		System.out.println("Weather Status : "+weatherController.detectWeather(weatherInputs));
		System.out.println("\n**** Test case 23 ended ****\n\n");
	}
}
