package DFG2_Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataPackage.LeadingVehicle;
import dataPackage.UserInputs;
import dataPackage.VehicleData;
import dataPackage.WeatherInputs;
import servicePackage.SpeedController;
import servicePackage.WeatherController;

public class Test6 {

	WeatherInputs weatherInputs = new WeatherInputs();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	WeatherController weatherController = new WeatherController();
	
	@Before
	public void initialize(){
		
		System.out.println("**** Test Case Started ****");
		userInputs.setAcc_Status(true);
		userInputs.setSetDistance(35);
		userInputs.setSetSpeed(70);
		vehicleData.setCurrentState("STANDBY");
		weatherInputs.setWeatherStatus("extreme");
		leadingVehicle.setLv_distance(30);
		leadingVehicle.setLv_present(true);
		leadingVehicle.setLv_speed(50);
		
	
	}
	
	@Test
	public void test() {
	
		SpeedController speedController = new SpeedController();
		
		Assert.assertEquals("ACC NOT IN ON STATE", speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println(speedController.controlSpeed(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("**** Test Case Ended ****");
		
	}


}
