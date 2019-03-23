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

public class testClass_21 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 21 started ****\n");
		weatherInputs.setRainDesnsity(2.4f);
		weatherInputs.setWindSpeed(15);
		weatherInputs.setWindDirection(310);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(55);
		userInputs.setSetDistance(65);
		leadingVehicle.setLv_present(true);
		leadingVehicle.setLv_distance(85);
		leadingVehicle.setLv_speed(50);
		vehicleData.setCurrentSpeed(55);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("Maintain Speed", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("\n**** Test case 21 ended ****\n\n");
	}
}
