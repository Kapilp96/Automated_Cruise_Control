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

public class testClass_16 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 16 started ****\n");
		weatherInputs.setRainDesnsity(9.4f);
		weatherInputs.setWindSpeed(40);
		weatherInputs.setWindDirection(150);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(0);
		userInputs.setSetDistance(50);
		leadingVehicle.setLv_present(false);
		leadingVehicle.setLv_distance(6);
		leadingVehicle.setLv_speed(5);
		vehicleData.setCurrentSpeed(50);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("ACC NOT IN ON STATE", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("ACC NOT IN ON STATE as user has not set speed and distance inputs");
		System.out.println("\n**** Test case 16 ended ****\n\n");
	}
}
