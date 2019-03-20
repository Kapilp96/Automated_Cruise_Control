package servicePackage;

import dataPackage.LeadingVehicle;
import dataPackage.UserInputs;
import dataPackage.VehicleData;
import dataPackage.WeatherInputs;

public class SpeedController {
	WeatherController wc;
	StateController sc;
	LeadingVehicle lv;
		
		public String controlSpeed(WeatherInputs weatherInputs,UserInputs userInputs,
				LeadingVehicle leadingVehicle,VehicleData vehicleData){
			
			// check ACC Current State
			
			if(vehicleData.getCurrentState().equals("ON")){
				
				// normal weather
				
				if(weatherInputs.getWeatherStatus().equalsIgnoreCase("normal")){
				
					return takeDecision(weatherInputs, userInputs, leadingVehicle,vehicleData);
				}
				
				// extreme weather
				
				else{
					// detect Safe Speed in extreme weather
					userInputs.setSetSpeed(calculateSafeSpeed(userInputs));
					// detect Safe Distance in extreme weather
					userInputs.setSetDistance(calculateSafeDistance(userInputs));
					return takeDecision(weatherInputs,userInputs,leadingVehicle,vehicleData);
				}
			}
			return "ACC NOT IN ON STATE";
		}
		
		public float calculateSafeSpeed(UserInputs userInputs){
			float safeSpeed = 60;
			if(safeSpeed < userInputs.getSetSpeed()){
				System.out.println("***********");
				System.out.println("Due to extreme weather conditions, speed controller "
						+ "changes the speed set by user by the safe speed under these conditions");
				System.out.println("Speed Set by User : " + userInputs.getSetSpeed());
				System.out.println("Safe Speed : " + safeSpeed);
				System.out.println("***********");
				return safeSpeed;
			}
			System.out.println("************");
			System.out.println("Speed set by user is determined to be safe even in extreme consitions");
			System.out.println("************");
			return userInputs.getSetSpeed();
		}
		
		public float calculateSafeDistance(UserInputs userInputs){
			float safeDistance = 75;
			if(safeDistance < userInputs.getSetDistance()){
				System.out.println("***********");
				System.out.println("Due to extreme weather conditions, speed controller "
					+ "changes the distance set by user by the safe distance under these conditions");
				System.out.println("Distance Set by User : " + userInputs.getSetDistance());
				System.out.println("Safe Distance : " + safeDistance);
				System.out.println("***********");
				return safeDistance;
			}
			System.out.println("************");
			System.out.println("Distance set by user is determined to be safe even in extreme consitions");
			System.out.println("************");
			return userInputs.getSetDistance();
		}
		
		public String takeDecision(WeatherInputs weatherInputs, UserInputs userInputs, 
							LeadingVehicle leadingVehicle, VehicleData vehicleData){
			
			// no leading vehicle
			if(!leadingVehicle.isLv_present()){
				
				System.out.println("Speed Set by user = " +userInputs.getSetSpeed());
				System.out.println("Current Speed of our vehicle = " + vehicleData.getCurrentSpeed());
				
				
				if(vehicleData.getCurrentSpeed() > userInputs.getSetSpeed()){
					// deaccelertes
					System.out.println("Decision by Speed Controller  ==> Car Needs to "
											+ "Decelerate at given time");
					 return "Deaccelrating";
				} else if(vehicleData.getCurrentSpeed() < userInputs.getSetSpeed()){
					System.out.println("Decision by Speed Controller  ==> Car Needs to "
							+ "Acclerate at given time");
					return "Accelrating";
				} else{
					System.out.println("Decision by Speed Controller  ==> Car Needs to "
							+ "Maintain Same Speed at given time");
					return "Maintain Speed";
				}
					
			}
			// leading vehicle present
			else{
				
				System.out.println("Speed set by user = " + userInputs.getSetSpeed());
				System.out.println("Distance set by user = " + userInputs.getSetDistance());
				System.out.println("Current speed of our vehicle = " + vehicleData.getCurrentSpeed());
				System.out.println("Speed of leading vehicle = " + leadingVehicle.getLv_speed());
				System.out.println("Distance of leading vehicle = " + leadingVehicle.getLv_distance());
							
				
				if(vehicleData.getCurrentSpeed() > userInputs.getSetSpeed() || 
						(leadingVehicle.getLv_speed()<vehicleData.getCurrentSpeed()
						&& leadingVehicle.getLv_distance() < userInputs.getSetDistance())){
					// Decelerates
					System.out.println("Decision by Speed Controller  ==> Car Needs to "
							+ "Decelerate at given time");
					 return "Deaccelrating";
				}
				else if((leadingVehicle.getLv_distance() > userInputs.getSetDistance()
							&& vehicleData.getCurrentSpeed() < userInputs.getSetSpeed())
						|| (leadingVehicle.getLv_speed() > userInputs.getSetSpeed()
							&& vehicleData.getCurrentSpeed() < userInputs.getSetSpeed())){
					// Accelerates
					System.out.println("Decision by Speed Controller  ==> Car Needs to "
							+ "Accelerate at given time");
					return "Accelrating";
				}
				else if(vehicleData.getCurrentSpeed() == userInputs.getSetSpeed() && 
						leadingVehicle.getLv_distance() > userInputs.getSetDistance()){
					// Maintain Speed
					System.out.println("Decision by Speed Controller  ==> Car Needs to "
							+ "Maintain Same Speed at given time");
					return "Maintain Speed";
				}
				return null;
			}
		
		}
}

