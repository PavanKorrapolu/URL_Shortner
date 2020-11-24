package com.pavan.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedirectService 
{
	@Autowired
	private RedirectRepo redirectRepo;
	
	public Optional<Redirect> createRedirect(RedirectCreationRequest redirectCreationRequest)
	{
		if(redirectRepo.existsByAlias(redirectCreationRequest.getAlias()))
		{
			throw new BadRequestException("Alias Already Exists");
		}
		System.out.println("Redirect Request"+redirectCreationRequest.toString());
		Redirect redirect = redirectRepo.save(new Redirect(redirectCreationRequest.getAlias(),redirectCreationRequest.getUrl()));
		System.out.println("Redirect"+redirect);
		return Optional.ofNullable(redirect);
	}
	
	public Optional<Redirect> getRedirect()
	{
		return Optional.empty();
	}
}
