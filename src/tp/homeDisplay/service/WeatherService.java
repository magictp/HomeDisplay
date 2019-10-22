package tp.homeDisplay.service;


public class WeatherService {
	
	public String getWeatherForecast() throws Exception
	{
		String url = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%201118550%20and%20u%20%3D%20'c'&format=json";
		return tp.tools.RequestBuilder.sendGetRequest(url);
	}

}
