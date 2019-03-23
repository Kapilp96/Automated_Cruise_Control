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

public class testClass_4 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 4 started ****\n");
		weatherInputs.setRainDesnsity(4f);
		weatherInputs.setWindSpeed(10);
		weatherInputs.setWindDirection(50);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(0);
		userInputs.setSetDistance(0);
		leadingVehicle.setLv_present(false);
//		leadingVehicle.setLv_distance();
//		leadingVehicle.setLv_speed(15);
		vehicleData.setCurrentSpeed(60);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("ACC NOT IN ON STATE", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("ACC NOT IN ON STATE as user has not set the speed and distance inputs");
		System.out.println("\n**** Test case 4 ended ****\n\n");
		
	}
}
