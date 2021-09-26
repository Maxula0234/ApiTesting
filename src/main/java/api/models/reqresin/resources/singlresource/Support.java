package api.models.reqresin.resources.singlresource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Support{

	@JsonProperty("text")
	private String text;

	@JsonProperty("url")
	private String url;

	public String getText(){
		return text;
	}

	public String getUrl(){
		return url;
	}
}