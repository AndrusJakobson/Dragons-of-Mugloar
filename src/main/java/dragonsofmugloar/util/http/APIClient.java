package dragonsofmugloar.util.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
	private static APIService service;
	private static APIClient instance;
	
	private APIClient() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://dragonsofmugloar.com/api/v2/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		service = retrofit.create(APIService.class);
	}
	
	public static APIClient getInstance() {
		if(instance == null) {
			instance = new APIClient();
		}
		return instance;
	}
	
	public APIService getService() {
		return service;
	}
}
