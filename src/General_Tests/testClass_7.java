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

public class testClass_7 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 7 started ****\n");
		weatherInputs.setRainDesnsity(0.8f);
		weatherInputs.setWindSpeed(15);
		weatherInputs.setWindDirection(45);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(70);
		userInputs.setSetDistance(40);
		leadingVehicle.setLv_present(true);
		leadingVehicle.setLv_distance(50);
		leadingVehicle.setLv_speed(55);
		vehicleData.setCurrentSpeed(60);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("Accelrating", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("\n**** Test case 7 ended ****\n\n");
	}
}
