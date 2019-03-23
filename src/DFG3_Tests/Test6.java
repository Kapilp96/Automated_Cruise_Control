 package DFG3_Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataPackage.LeadingVehicle;
import dataPackage.UserInputs;
import dataPackage.VehicleData;
import dataPackage.WeatherInputs;
import servicePackage.SpeedController;

public class Test6 {
	WeatherInputs weatherInputs = new WeatherInputs();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 6 started ****\n\n");
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
		Assert.assertEquals("Maintain Speed", speedController.takeDecision(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("**** Test case 6 ended ****\n\n");
	}
}
