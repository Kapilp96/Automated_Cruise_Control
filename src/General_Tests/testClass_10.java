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

public class testClass_10 {
	StateController stateController = new StateController();
	VehicleData vehicleData = new VehicleData();
	UserInputs userInputs = new UserInputs();
	
	@Before
	public void initialize(){
		
		userInputs.setAcc_Status(true);
		vehicleData.setCurrentSpeed(50);
	}
	
	@Test
	public void extremeWeatherLeadingVehiclePresent(){
			
		Assert.assertEquals("STANDBY", stateController.detectState(userInputs, vehicleData));
	}
}
