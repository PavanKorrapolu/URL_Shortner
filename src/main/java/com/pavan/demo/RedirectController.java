package com.pavan.demo;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController 
{
	@Autowired
	private RedirectService redirectService;
	
	@GetMapping("/{alias}")
	public ResponseEntity<?> handleRedirect(@PathVariable String alias) throws URISyntaxException
	{
		URI uri = new URI("http://www.google.com");
		HttpHeaders httpheaders = new HttpHeaders();
		httpheaders.setLocation(uri);
		
		return new ResponseEntity<>(httpheaders,HttpStatus.MOVED_PERMANENTLY);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createRedirect(@Validated @RequestBody RedirectCreationRequest redirectCreationRequest)
	{
		return ResponseEntity.ok(redirectService.createRedirect(redirectCreationRequest));
	}	
	
	
	
}
