package org.itap.http.ssl.client;

public class HttpServerResponse {

	private String responseStatusCode;
	private String responseBody;
	
	public HttpServerResponse() {
		super();
	}
	
	public HttpServerResponse(String responseStatusCode, String responseBody) {
		super();
		this.responseStatusCode = responseStatusCode;
		this.responseBody = responseBody;
	}
	
	public String getResponseStatusCode() {
		return responseStatusCode;
	}
	public void setResponseStatusCode(String responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	
	
}
