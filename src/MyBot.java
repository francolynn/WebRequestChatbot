import org.jibble.pircbot.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class MyBot extends PircBot {
    
	//constructor
    public MyBot() {
    	//set nickname for the chatbot
        this.setName("francoBot");
    }
    
    //method that responds to commands in chat
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        
    	//if user requests list of commands
    	if (message.equalsIgnoreCase("commands")) {
    		
    		//print list of commands
    		sendMessage(channel, "Commands:");
    		sendMessage(channel, "To view weather conditions: Enter weather and city (eg: weather Paris)");
    		sendMessage(channel, "To view location of the International Space Station: Enter 'ISS'");
    	}
    	else if (message.toLowerCase().startsWith("weather")) {

    		//remove white spaces from message
    		message = message.replaceAll("\\s+", "");
    		
    		//set city to the text following the word weather
			String city = message.toLowerCase().substring("weather".length());
			//api key
			String APIKey = "a6f4a64f4d7903425d7b4238b2917276";
			//url to weather API
			String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+APIKey;
			
			//call webrequest method to send API request to extract json data from site
			String unparsedJSONString = webRequest(url);
			
			//create gson object
			Gson myGson = new GsonBuilder().create();
			
			//create weather object using json data
			Weather myWeather = myGson.fromJson(unparsedJSONString, Weather.class);
			
			//print current temperatures to chat
			sendMessage(channel, myWeather.main.getTempData());
        }
        
        else if (message.equalsIgnoreCase("ISS")) {
        	
        	//address of ISS locator
			String webAddress = "https://api.wheretheiss.at/v1/satellites/25544";
			
			//get json data
			String unparsedJSONString = webRequest(webAddress);
			
			//create gson object
			Gson myGson = new GsonBuilder().create();
			
			//create ISS object using json data
			ISS myISS = myGson.fromJson(unparsedJSONString, ISS.class);
			
			//print lat-long to chat
			sendMessage(channel, myISS.getLatLong());
        }
    }

	//This method returns the JSON data from site in a String
    public String webRequest(String webAddress) {
    	
    	try {
			
    		//create httpClient object
    		CloseableHttpClient httpClient = HttpClients.createDefault();
    		
    		//create get object with api address
			HttpGet getRequest = new HttpGet(webAddress);
			
			//create httpresponse object and execute the get request
			CloseableHttpResponse response = httpClient.execute(getRequest);

			//if there is a URL error
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}

			//create buffered reader object
			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));

			//set string to JSON data on web page
			String jsonData = br.readLine();
			
			//return data
			return jsonData;

		  } catch (ClientProtocolException e) {

			e.printStackTrace();
			return "error";

		  } catch (IOException e) {
			  
			e.printStackTrace();
			return "error";
		  }
    }
}