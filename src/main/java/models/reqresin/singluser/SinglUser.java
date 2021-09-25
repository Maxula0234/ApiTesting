package models.reqresin.singluser;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SinglUser{

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