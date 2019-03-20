package dataPackage;

public class WeatherInputs {
		
	private  float rainDesnsity;
	private  float windSpeed;
	private  int windDirection;
	private String weatherStatus;
	
	
	public float getRainDesnsity() {
		return rainDesnsity;
	}
	public void setRainDesnsity(float rainDesnsity) {
		this.rainDesnsity = rainDesnsity;
	}
	public float getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}
	public int getWindDirection() {
		return windDirection;
	}
	public String getWeatherStatus() {
		return weatherStatus;
	}
	public void setWeatherStatus(String weatherStatus) {
		this.weatherStatus = weatherStatus;
	}
	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}
	
}
