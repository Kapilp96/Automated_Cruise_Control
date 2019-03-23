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

public class testClass_13 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 13 started ****\n");
		weatherInputs.setRainDesnsity(8f);
		weatherInputs.setWindSpeed(10);
		weatherInputs.setWindDirection(90);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(50);
		userInputs.setSetDistance(80);
		leadingVehicle.setLv_present(false);
		leadingVehicle.setLv_distance(60);
		leadingVehicle.setLv_speed(50);
		vehicleData.setCurrentSpeed(40);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("Accelrating", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("\n**** Test case 13 ended ****\n\n");
	}
}
