package br.com.exercise2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.exercise2.exception.InvalidZipcode;
import br.com.exercise2.model.Address;
import br.com.exercise2.model.ResponseError;

@Service
public class ZipcodeService {

	@Value("${zipcode.service.url}")
	protected String urlApiZipcode;
	
	protected RestTemplate restTemplate = new RestTemplate();
	
	public ResponseEntity<ResponseError> validateZipcode(Address address) throws InvalidZipcode {
		
		try {
			ResponseEntity<Address> response = restTemplate.getForEntity(String.format(urlApiZipcode, address.getZipcode()), Address.class);
			address.setZipcode(response.getBody().getZipcode());
			address.setCountry(response.getBody().getCountry());
			address.setState(response.getBody().getState());
			address.setCity(response.getBody().getCity());
			address.setDistrict(response.getBody().getDistrict());
			
			return ResponseEntity.status(HttpStatus.OK).body(null);
			
		} catch (HttpStatusCodeException e) {
	        String response = e.getResponseBodyAsString();
	        ObjectMapper mapper = new ObjectMapper();

	        ResponseError error;
			try {
				error = mapper.readValue(response, ResponseError.class);
			} catch (Exception ex) {
				 return ResponseEntity.status(e.getStatusCode()).body(null);
			} 
            return ResponseEntity.status(e.getStatusCode()).body(error);
	    } catch (Exception ex) {
	    	throw new InvalidZipcode();
	    }
	}
}
