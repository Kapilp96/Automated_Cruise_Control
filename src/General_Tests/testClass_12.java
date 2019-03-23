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

public class testClass_12 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 12 started ****\n");
		weatherInputs.setRainDesnsity(1.4f);
		weatherInputs.setWindSpeed(28);
		weatherInputs.setWindDirection(100);
		userInputs.setAcc_Status(false);
		userInputs.setSetSpeed(60);
		userInputs.setSetDistance(80);
		leadingVehicle.setLv_present(true);
		leadingVehicle.setLv_distance(90);
		leadingVehicle.setLv_speed(20);
		vehicleData.setCurrentSpeed(50);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("ACC NOT IN ON STATE", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("ACC NOT IN ON STATE as user has not turned on ACC");
		System.out.println("\n**** Test case 12 ended ****\n\n");
		
	}
}
