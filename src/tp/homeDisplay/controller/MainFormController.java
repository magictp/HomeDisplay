package tp.homeDisplay.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import tp.homeDisplay.model.Weather;
import tp.homeDisplay.model.YahooQuery;
import tp.homeDisplay.service.MetroService;
import tp.homeDisplay.service.WeatherService;


public class MainFormController {

	public String getOncomingMetro(){
		return new MetroService().getOncomingShift();
	}
	
	public String getWeatherForecast() throws Exception{
		String jsonString = new WeatherService().getWeatherForecast();
		jsonString = jsonString.substring(9, jsonString.length() -1);
		YahooQuery<Weather> yw = (YahooQuery<Weather>)new Gson().fromJson(jsonString,new TypeToken<YahooQuery<Weather>>(){}.getType());
		Weather w = (Weather)yw.getResults();
		return w.getTemp();
	}
}
