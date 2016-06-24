package com.bc.babynumber.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bc.babynumber.model.ClientPing;
import com.bc.babynumber.repository.ClientPingRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private ClientPingRepository clientPingRepository;

  @CrossOrigin(origins = "*")
  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> logClientPingMessage(@RequestBody Map<String, Object> msgMap){
	  
	Map<String, Object> response = new LinkedHashMap<String, Object>();
	System.out.println(msgMap.toString());
	
	//Date parse could be buggy, lets handle it safely; default to current time in this server if parse stuff is garbled.
	Date reqest_time_parse;
	try
	{
		reqest_time_parse = DateFormat.getDateTimeInstance().parse(msgMap.get("request_time").toString());
	}catch(ParseException pe) 
	{
		reqest_time_parse=new Date();
	}
	
	ClientPing pingMessage = new ClientPing(msgMap.get("visitor_id").toString(),
		msgMap.get("user_id").toString(),
		msgMap.get("device_type").toString(),
		msgMap.get("request_url").toString(),
        Boolean.parseBoolean(msgMap.get("adblocker_enabled").toString()),
        reqest_time_parse);
	
	try
	{
		clientPingRepository.save(pingMessage);
	}catch(Exception e)
	{
		System.out.println("Error saving information to Database: "+e.getMessage());
		System.out.println("Stack trace: " +e.getStackTrace());
		response.put("message", "Failed to post the Message");
		return response;
	}
	
    response.put("message", "Successfully posted the Message");
    response.put("ClientPing", pingMessage);
	return response;
  }
  
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAllClientPingMessages(){
    
		List<ClientPing> pingMessages = clientPingRepository.findAll();
	    
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("totalMessage", pingMessages.size());
	    response.put("Messages", pingMessages);
	    return response;
	}
  
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ClientPing getClientPingMessage(@PathVariable("id") String id){
		return clientPingRepository.findOne(id);
	}

}
