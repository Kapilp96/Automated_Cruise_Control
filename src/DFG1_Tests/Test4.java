package DFG1_Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataPackage.UserInputs;
import dataPackage.VehicleData;
import servicePackage.StateController;

public class Test4 {
	
	
	VehicleData vehicleData = new VehicleData();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		
		System.out.println("**** Test case started ****");
		userInputs.setAcc_Status(true);
		userInputs.setSetSpeed(60);
		userInputs.setSetDistance(30);
		vehicleData.setCurrentSpeed(0);
	}
	
	@Test
	public void extremeWeatherLeadingVehiclePresent(){
		
		StateController stateController = new StateController();
		
		Assert.assertEquals("ON",stateController.detectState(userInputs, vehicleData));
		//System.out.println(stateController.detectState(userInputs, vehicleData));
		System.out.println("**** Test case ended ****");
		
	}
}
