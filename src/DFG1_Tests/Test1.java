package DFG1_Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataPackage.UserInputs;
import dataPackage.VehicleData;
import servicePackage.StateController;

public class Test1 {
	
	
	VehicleData vehicleData = new VehicleData();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		
		System.out.println("**** Test case started ****");
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(70);
		userInputs.setSetDistance(20);
		vehicleData.setCurrentSpeed(50);
	}
	
	@Test
	public void extremeWeatherLeadingVehiclePresent(){
		
		StateController stateController = new StateController();
		
		Assert.assertEquals("ON",stateController.detectState(userInputs, vehicleData));
		System.out.println(stateController.detectState(userInputs, vehicleData));
		System.out.println("**** Test case ended ****");
		
	}
}
