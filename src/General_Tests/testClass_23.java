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
		
		weatherInputs.setRainDesnsity(3.5f);
		weatherInputs.setWindDirection(260);
		weatherInputs.setWindSpeed(8);
	}
	
	@Test
	public void extremeWeatherLeadingVehiclePresent(){
			
		Assert.assertEquals("normal", weatherController.detectWeather(weatherInputs));
	}
}
