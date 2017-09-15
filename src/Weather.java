import java.text.DecimalFormat;

public class Weather {
	
	//object that holds weather information under "main" parameter in weather json
	Main main;
	
	public class Main {
		
		//daily high and low temperature, in Kelvins
		private double temp_min = 0;
		private double temp_max = 0;

		//getters
		public double getTemp_min() {
			return temp_min;
		}
		public double getTemp_max() {
			return temp_max;
		}
		//setters
		public void setTemp_min(double temp) {
			temp_min = temp;
		}
		public void setTemp_max(double temp) {
			temp_max = temp;
		}
		//converts and returns temperature in farenheit
		public double getFarenheit(double temp) {
			//this is the formula to convert Kelvin to Farenheit
			temp = ((9.0/5) * temp ) - 459.67;
			return temp;
		}
		//method that returns a string with temperature information in Farenheit
		public String getTempData() {
			
			//sets precision of output to 1 decimal place
			final DecimalFormat df = new DecimalFormat("#0.0");
			
			return "High: "+ df.format(getFarenheit(getTemp_max())) + " degrees F" +
				   ", Low: " + df.format(getFarenheit(getTemp_min())) + " degrees F";
		}
	}
}
