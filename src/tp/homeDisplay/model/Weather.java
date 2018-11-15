package tp.homeDisplay.model;


public class Weather {
	
	Channel channel;
	
	public String getTemp()
	{
		return channel.getItem().getCondition().getTemp();
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}

class Condition{
	String code;
	String date;
	String temp;
	String text;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}

class forecast{
	String code;
	String date;
	String day;
	String high;
	String low;
	String text;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}

class guid{
	String isPermaLink;

	public String getIsPermaLink() {
		return isPermaLink;
	}

	public void setIsPermaLink(String isPermaLink) {
		this.isPermaLink = isPermaLink;
	}
}

class image{
	String title;
	String width;
	String height;
	String link;
	String url;
}

		
class astronomy{
	String sunrise;
	String sunset;
}

class Channel{
	Item  item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
class Item{
	Condition condition;

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
}
