package tp.homeDisplay.model;

public class YahooQuery<T> {
	
	String count;
	String created;
	String lang;
	T results;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public T getResults() {
		return results;
	}
	public void setResults(T results) {
		this.results = results;
	}

	
}
