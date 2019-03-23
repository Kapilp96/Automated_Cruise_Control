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

public class testClass_20 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 20 started ****\n");
		weatherInputs.setRainDesnsity(5.5f);
		weatherInputs.setWindSpeed(39);
		weatherInputs.setWindDirection(150);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(45);
		userInputs.setSetDistance(80);
		leadingVehicle.setLv_present(true);
		leadingVehicle.setLv_distance(65);
		leadingVehicle.setLv_speed(50);
		vehicleData.setCurrentSpeed(55);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("Deaccelrating", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("\n**** Test case 20 ended ****\n\n");
	}
}
