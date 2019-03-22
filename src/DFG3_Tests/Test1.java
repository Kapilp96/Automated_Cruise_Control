package DFG3_Tests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataPackage.LeadingVehicle;
import dataPackage.UserInputs;
import dataPackage.VehicleData;
import dataPackage.WeatherInputs;
import servicePackage.SpeedController;


public class Test1 {
	
		WeatherInputs weatherInputs = new WeatherInputs();
		VehicleData vehicleData = new VehicleData();
		LeadingVehicle leadingVehicle = new LeadingVehicle();
		UserInputs userInputs = new UserInputs();
		
		@Before
		public void initialize(){
			
			userInputs.setAcc_Status(true);
			userInputs.setSetSpeed(70);
			userInputs.setSetDistance(20);
			leadingVehicle.setLv_present(false);
//			leadingVehicle.setLv_distance();
//			leadingVehicle.setLv_speed(15);
			vehicleData.setCurrentSpeed(50);
		}
		
		@Test
		public void extremeWeatherLeadingVehiclePresent(){
			SpeedController speedController = new SpeedController();
			Assert.assertEquals("Accelrating", speedController.takeDecision(weatherInputs, userInputs,
												leadingVehicle, vehicleData));
		}
	}


