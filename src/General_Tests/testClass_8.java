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

public class testClass_8 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 8 started ****\n");
		weatherInputs.setRainDesnsity(1.2f);
		weatherInputs.setWindSpeed(20);
		weatherInputs.setWindDirection(105);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(60);
		userInputs.setSetDistance(50);
		leadingVehicle.setLv_present(true);
		leadingVehicle.setLv_distance(80);
		leadingVehicle.setLv_speed(70);
		vehicleData.setCurrentSpeed(60);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("Maintain Speed", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("\n**** Test case 8 ended ****\n\n");
	}
}
