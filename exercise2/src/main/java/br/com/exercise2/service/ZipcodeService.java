package br.com.exercise2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.exercise2.exception.InvalidZipcode;
import br.com.exercise2.model.Address;

@Service
public class ZipcodeService {

	@Value("${zipcode.service.url}")
	protected String urlApiZipcode;
	
	protected RestTemplate restTemplate = new RestTemplate();
	
	public boolean validateZipcode(String zipcode) throws InvalidZipcode {
		
		try {
			ResponseEntity<Address> response = restTemplate.getForEntity(String.format(urlApiZipcode, zipcode), Address.class);
			if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
				return true;
			}
			
		} catch (HttpClientErrorException e) {
	        throw new InvalidZipcode();
	    }
		
		return false;
	}
}
