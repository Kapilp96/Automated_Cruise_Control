package servicePackage;

import dataPackage.WeatherInputs;

// Rain Density --- < 2.5 => light rain
//					>2.5 & < 7.6 => moderate rain
//					> 7.6 => heavy

// Wind Speed --------   >=1 & <= 3  => light wind
//						 >=4 & <=10 => gentle wind
//						 > 10 => strong wind
//						 > 30 => extreme wind

public class WeatherController {
	
	public String detectWeather(WeatherInputs weatherInputs){	
		if(weatherInputs.getRainDesnsity() > 7.6 || weatherInputs.getWindSpeed() > 30)
			return "extreme";
		
		else if(weatherInputs.getWindDirection() >= 0 && weatherInputs.getWindDirection() <=180)
			return "normal" ;
		else {
			if(weatherInputs.getWindSpeed() >=10)
				return"extreme";
			 else 
				return "normal";
		}
	}
		
}


