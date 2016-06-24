package com.bc.babynumber.model;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class ClientPing {

	@Id
	private String id;
	  
	private String visitor_id;			//Omniture or similar Analytics tool created tracking id
	private String user_id;				//User or Account id from the source system
	private String device_type;			//Type of device - Desktop, Mobile, etc
	private String request_url;			//Resource being accessed by users
		  
	private boolean adblocker_enabled;	//Is user using an Ad blocker?
											//Assumption: 
											//1st hit from a user, its always false; 
											//On further hits we would track via header between user & server
	  
	private Date request_time;			//Time the server or client is processing the request
		  
	private Date log_create_time;			//Time when we logged this event
		
	public ClientPing(){}
	  
  	public ClientPing(String visitor_id, String user_id, String device_type, String request_url, boolean adblocker_enabled,
		Date request_time) {
		super();
		this.visitor_id = visitor_id;
		this.user_id = user_id;
		this.device_type = device_type;
		this.request_url = request_url;
		this.adblocker_enabled = adblocker_enabled;
		this.request_time = request_time;
		this.log_create_time = new Date();
	}

	public String getId() {
		return id;
	}
	
	public String getVisitor_id() {
		return visitor_id;
	}
	
	public String getUser_id() {
		return user_id;
	}
	
	public String getDevice_type() {
		return device_type;
	}
	
	public String getRequest_url() {
		return request_url;
	}
	
	public boolean isAdblocker_enabled() {
		return adblocker_enabled;
	}
	
	public Date getRequest_time() {
		return request_time;
	}
	
	public Date getLog_create_time() {
		return log_create_time;
	}
	
	public void setVisitor_id(String visitor_id) {
		this.visitor_id = visitor_id;
	}
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	
	public void setRequest_url(String request_url) {
		this.request_url = request_url;
	}
	
	public void setAdblocker_enabled(boolean adblocker_enabled) {
		this.adblocker_enabled = adblocker_enabled;
	}
	
	public void setRequest_time(Date request_time) {
		this.request_time = request_time;
	}
	
	public void setLog_create_time(Date log_create_time) {
		this.log_create_time = log_create_time;
	}

}