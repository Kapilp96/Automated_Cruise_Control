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

public class testClass_3 {
	WeatherController weatherController = new WeatherController();
	WeatherInputs weatherInputs = new WeatherInputs();
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 3 started ****\n");
		weatherInputs.setRainDesnsity(6.8f);
		weatherInputs.setWindSpeed(8);
		weatherInputs.setWindDirection(260);
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(50);
		userInputs.setSetDistance(10);
		leadingVehicle.setLv_present(false);
//		leadingVehicle.setLv_distance();
//		leadingVehicle.setLv_speed(15);
		vehicleData.setCurrentSpeed(50);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		vehicleData.setCurrentState(stateController.detectState(userInputs, vehicleData));
		weatherInputs.setWeatherStatus(weatherController.detectWeather(weatherInputs));
		
		
		Assert.assertEquals("Maintain Speed", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("\n**** Test case 3 ended ****\n\n");
	}
}
