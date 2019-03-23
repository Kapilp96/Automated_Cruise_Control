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

public class testClass_5 {
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		System.out.println("**** Test case 5 started ****\n");
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(80);
		userInputs.setSetDistance(30);
		vehicleData.setCurrentSpeed(50);
	}
	
	@Test
	public void testFunction(){
			
		Assert.assertEquals("ON", stateController.detectState(userInputs, vehicleData));
		System.out.println("ACC STATUS : "+stateController.detectState(userInputs, vehicleData));
		System.out.println("\n**** Test case 5 ended ****\n\n");
	}
}
