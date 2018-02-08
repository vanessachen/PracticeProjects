
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpURLConnectionExample {

	private static final String USER_AGENT = "Chrome/63.0.3239.132";

	private static final String GET_URL = "https://www.random.org/integers/?num=10000&min=0&max=255&col=10000&base=10&format=plain&rnd=new";

	
	public ArrayList<Integer> numArray;

	public void sendGET() throws IOException {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			
			String randomNumString = response.toString();
			String[] stringArray = randomNumString.split("\t");//separating based on tab
			this.numArray = new ArrayList<Integer>(stringArray.length);
		    for (int i = 0; i < stringArray.length; i++) {
		         String numAsString = stringArray[i];
		         this.numArray.add(Integer.parseInt(numAsString));
		    }
		    System.out.println(this.numArray);
		    
		} else {
			System.out.println("GET request did not work");
		}

	}
}

