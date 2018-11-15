package tp.tools;

import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;

public class RequestBuilder {

	static public String sendGetRequest(String url) throws Exception{
    HttpClient httpclient = HttpClientBuilder.create().build();
		String resp = "";
        URIBuilder builder = new URIBuilder(url);
        URI uri = builder.build();
        HttpGet request = new HttpGet(uri);
        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();

		if (entity != null) {
			resp = IOUtils.toString(entity.getContent(), "UTF8");
		}
		
		return resp;
	}
	
	static public String sendPostRequest(String url) throws Exception{
		HttpClient httpclient = HttpClientBuilder.create().build();
		String resp = "";
       URIBuilder builder = new URIBuilder(url);
       URI uri = builder.build();
       HttpPost request = new HttpPost(uri);
       HttpResponse response = httpclient.execute(request);
       HttpEntity entity = response.getEntity();

		if (entity != null) {
			resp = IOUtils.toString(entity.getContent(), "UTF8");
		}
		
		return resp;
	}
}
