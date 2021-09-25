package models.reqresin.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resource{

	@JsonProperty("data")
	private Data data;

	@JsonProperty("support")
	private Support support;

	public Data getData(){
		return data;
	}

	public Support getSupport(){
		return support;
	}
}