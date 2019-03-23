package DFG3_Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataPackage.LeadingVehicle;
import dataPackage.UserInputs;
import dataPackage.VehicleData;
import dataPackage.WeatherInputs;
import servicePackage.SpeedController;

public class Test4 {
	WeatherInputs weatherInputs = new WeatherInputs();
	VehicleData vehicleData = new VehicleData();
	LeadingVehicle leadingVehicle = new LeadingVehicle();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 4 started ****\n\n");
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
		Assert.assertEquals("Accelrating", speedController.takeDecision(weatherInputs, userInputs,
											leadingVehicle, vehicleData));
		System.out.println("**** Test case 4 ended ****\n\n");
	}
}
