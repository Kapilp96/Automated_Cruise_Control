package servicePackage;

import java.util.Calendar;

import dataPackage.UserInputs;
import dataPackage.VehicleData;

public class StateController {	
	
	
	public String detectState(UserInputs userInputs , VehicleData vehicleData){
		if(!userInputs.isAcc_Status())
			return "OFF";
		else if(userInputs.isAcc_Status() &&
				(userInputs.getSetDistance() == 0 || userInputs.getSetSpeed() == 0))
			return "STANDBY";
		else{
			if(vehicleData.getCurrentSpeed() == 0){
			
				System.out.println("****************************");
				System.out.println("Car is currently Stopped");
				System.out.println("ACC is in Stand By state and waiting for user to push "
						+ "throttle before 10 seconds to resume the ACC");
				System.out.println("****************************");
				
				boolean throttle_status = false;
				
					long currentTime = System.currentTimeMillis();
					int counter = 0;
					
					for(long x = currentTime; x<= currentTime + 10*1000; x+=1000){
						System.out.println("Timer Count " + counter);
						counter++;
						if(counter ==5)
							throttle_status = true;
						if(throttle_status){
							System.out.println("User pushes throttle and Acc resumes again");
							return "ON";
						}
				}
					System.out.println("ACC goes to OFF from Stand By after waiting for more than 10 seconds");
					return "OFF";
			}
			else
				return "ON";
		} 
			
	}
	

}
