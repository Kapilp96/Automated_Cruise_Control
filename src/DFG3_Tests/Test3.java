package DFG3_Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataPackage.LeadingVehicle;
import dataPackage.UserInputs;
import dataPackage.VehicleData;
import dataPackage.WeatherInputs;
import servicePackage.SpeedController;

public class Test3 {
	WeatherInputs weatherInputs = new WeatherInputs();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 3 started ****\n\n");
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(70);
		userInputs.setSetDistance(20);
		leadingVehicle.setLv_present(false);
//		leadingVehicle.setLv_distance();
//		leadingVehicle.setLv_speed(15);
		vehicleData.setCurrentSpeed(70);
	}
	
	@Test
	public void testFunction(){
		SpeedController speedController = new SpeedController();
		Assert.assertEquals("Maintain Speed", speedController.takeDecision(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("**** Test case 3 ended ****\n\n");
	}
}
