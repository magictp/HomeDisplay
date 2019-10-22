package tp.homeDisplay.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//import tp.homeDisplay.model.Article;
//import tp.homeDisplay.model.NewsApiQuery;
//import tp.homeDisplay.model.Weather;
//import tp.homeDisplay.model.YahooQuery;
import tp.homeDisplay.service.MetroService;
//import tp.homeDisplay.service.NewsService;
//import tp.homeDisplay.service.WeatherService;
import com.opensymphony.xwork2.ActionSupport;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
public class MainFormController extends ActionSupport{

        private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getOncomingMetro(){
		String nextTime =  new MetroService().getOncomingShift();
		inputStream = new ByteArrayInputStream(nextTime.getBytes(StandardCharsets.UTF_8));
		return SUCCESS;	
	}
/*	
	public String getWeatherForecast() throws Exception{
		String jsonString = new WeatherService().getWeatherForecast();
		jsonString = jsonString.substring(9, jsonString.length() -1);
		YahooQuery<Weather> yw = (YahooQuery<Weather>)new Gson().fromJson(jsonString,new TypeToken<YahooQuery<Weather>>(){}.getType());
		Weather w = (Weather)yw.getResults();
		return w.getTemp();
	}
	
	public String getLatestNews() throws Exception{
		String newsString = "";
		String jsonString = new NewsService().getLatestNews();
		NewsApiQuery news = new Gson().fromJson(jsonString,new TypeToken<NewsApiQuery>(){}.getType());
		Article[] arts = news.getArticles();
		for(Article a : arts)
		{
			newsString += a.getTitle();
			newsString += "          ";
		}
		return newsString;
	}*/
}
