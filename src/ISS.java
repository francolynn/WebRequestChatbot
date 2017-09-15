import java.text.DecimalFormat;

//International Space Station Object
public class ISS {

	//coordinates of the ISS
	private double latitude = 0;
	private double longitude = 0;
	
	//getters
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	//setters
	public void setLatitude(double lat) {
		latitude = lat;
	}
	public void setLongitude(double lon) {
		latitude = lon;
	}
	
	//method that returns a string with ISS lat long coordinates
	public String getLatLong() {
		
		//sets precision of output to 4 decimal places
		final DecimalFormat df = new DecimalFormat("#0.0000");
		
		return "Latitude: "+ df.format(getLatitude()) + " degrees" +
			   ", Longitude: " + df.format(getLongitude()) + " degrees";
	}
}

