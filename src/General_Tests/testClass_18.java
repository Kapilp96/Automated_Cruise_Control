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

public class testClass_18 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		weatherInputs.setRainDesnsity(8.6f);
		weatherInputs.setWindSpeed(15);
		weatherInputs.setWindDirection(250);
		userInputs.setAcc_Status(false);
		userInputs.setSetSpeed(10);
		userInputs.setSetDistance(10);
		leadingVehicle.setLv_present(false);
		leadingVehicle.setLv_distance(6);
		leadingVehicle.setLv_speed(5);
		vehicleData.setCurrentSpeed(10);
	}
	
	@Test
	public void extremeWeatherLeadingVehiclePresent(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("ACC NOT IN ON STATE", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
	}
}
