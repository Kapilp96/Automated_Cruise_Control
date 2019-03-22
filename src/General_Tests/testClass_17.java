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
		
		weatherInputs.setRainDesnsity(8.4f);
		weatherInputs.setWindDirection(120);
		weatherInputs.setWindSpeed(24);
	}
	
	@Test
	public void extremeWeatherLeadingVehiclePresent(){
			
		Assert.assertEquals("extreme", weatherController.detectWeather(weatherInputs));
	}
}
