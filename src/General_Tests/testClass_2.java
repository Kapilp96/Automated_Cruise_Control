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

public class testClass_2 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		weatherInputs.setRainDesnsity(3.4f);
		weatherInputs.setWindSpeed(25);
		weatherInputs.setWindDirection(80);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(50);
		userInputs.setSetDistance(30);
		leadingVehicle.setLv_present(false);
		leadingVehicle.setLv_distance(120);
		leadingVehicle.setLv_speed(15);
		vehicleData.setCurrentSpeed(60);
	}
	
	@Test
	public void extremeWeatherLeadingVehiclePresent(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("Deaccelrating", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
	}
}
