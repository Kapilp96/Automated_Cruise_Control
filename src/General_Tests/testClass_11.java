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

public class testClass_11 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		weatherInputs.setRainDesnsity(2.4f);
		weatherInputs.setWindSpeed(22);
		weatherInputs.setWindDirection(135);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(60);
		userInputs.setSetDistance(45);
		leadingVehicle.setLv_present(true);
		leadingVehicle.setLv_distance(30);
		leadingVehicle.setLv_speed(40);
		vehicleData.setCurrentSpeed(55);
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
