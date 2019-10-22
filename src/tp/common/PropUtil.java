package tp.common;

import java.util.ResourceBundle;

public class PropUtil {
	public static String getTwitterProp(String key) {
		ResourceBundle resource = ResourceBundle.getBundle("twitter");
		String value = resource.getString(key); 
		return value;
	}
	public static String getDBProp(String key) {
		ResourceBundle resource = ResourceBundle.getBundle("db");
		String value = resource.getString(key); 
		return value;
	}
	
}
