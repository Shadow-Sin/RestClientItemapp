package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.model.Sample;
class Sample1
{
    private String message;
    public Sample1()
    {
        
    }
    
    public void setMessage(String message)
    {
        this.message=message;
    }
    public String getMessage()
    {
        return message;
    }
}



@RestController
public class ItemClientController {
	
	@GetMapping("/getclient")
	public HttpEntity getclient() {
//		HttpHeaders headers = new HttpHeaders();
//		
//		headers.setContentType(MediaType.TEXT_PLAIN);
//		Sample s = new Sample();
//		
//		
//		HttpEntity entity= new HttpEntity("Hello User",headers);
//		return entity;
		 HttpHeaders headers=new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        Sample msg=new Sample();
	        msg.setMessage("Hello World");
	        HttpEntity<Sample> entity=new HttpEntity<Sample>(msg,headers);
	  return entity;    
	}
	
	@GetMapping("/getitems")
	public String getitemlist()
	{
		HttpHeaders headers= new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		RestTemplate template = new RestTemplate();
		
		return template.exchange("http://localhost:8083/getallitems", 
				HttpMethod.GET,entity,String.class).getBody();
		
	}
	
	@GetMapping("/getitemsasobject")
    public List getitemlistasobject()
    {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Item>> entity=new HttpEntity<List<Item>>(headers);
        
        RestTemplate template=new RestTemplate();
        
        return template.exchange("http://localhost:8083/getallitems",
                HttpMethod.GET,entity,List.class).getBody();
        
    }
	
	@PostMapping("/additem")
	public String creatitem(@RequestBody Item item) {
		 HttpHeaders headers=new HttpHeaders();
	     
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	     
		 HttpEntity<Item> entity=new HttpEntity<Item>(item,headers);

	        
	        RestTemplate template=new RestTemplate();
	        
	        return template.exchange("http://localhost:8083/addanitem",
	                HttpMethod.POST,entity,String.class).getBody();
			
	}
	@PostMapping("/adduser")
	public String adduser(@RequestBody AccountUser user) {
		
		HttpHeaders headers= new HttpHeaders();
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<AccountUser> entity = new HttpEntity<>(user,headers);
		
		RestTemplate template = new RestTemplate();
		
		
		return  template.exchange("http://localhost:8088/addauser", 
				HttpMethod.POST,entity,String.class).getBody();
	}
	
	@GetMapping("/getallusers")
	public List getallusers() {
		
		HttpHeaders headers= new HttpHeaders();
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<List<AccountUser>> entity = new HttpEntity<>(headers);
		
		RestTemplate template = new RestTemplate();
		
		
		return  template.exchange("http://localhost:8088/getallusers", 
				HttpMethod.GET,entity,List.class).getBody();
	}
	
	
	
	@GetMapping("/findbyemailid/{emailid}")
	public AccountUser getallusers(@PathVariable("emailid") String email) {
		
		HttpHeaders headers= new HttpHeaders();
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<AccountUser> entity = new HttpEntity<>(headers);
		
		RestTemplate template = new RestTemplate();
		
		
		return  template.exchange("http://localhost:8088/findbyemailid/"+email, 
				HttpMethod.GET,entity,AccountUser.class).getBody();
	}
	
	
	
	
	
	

}
