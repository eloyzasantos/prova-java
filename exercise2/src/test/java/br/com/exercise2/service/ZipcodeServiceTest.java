package br.com.exercise2.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import br.com.exercise2.exception.InvalidZipcode;
import br.com.exercise2.model.Address;
import br.com.exercise2.model.ResponseError;

@RunWith(MockitoJUnitRunner.class)
public class ZipcodeServiceTest extends ZipcodeService {

	@Before
	public void setup() {
		this.restTemplate = Mockito.mock(RestTemplate.class);
		this.urlApiZipcode = "teste/%s";
	}
	
	@Test
	public void mustReturnOk() throws InvalidZipcode {
		Address address2 = getAddress2();
		ResponseEntity<Address> mockResponse = ResponseEntity.status(HttpStatus.OK).body(address2);
		
		when(restTemplate.getForEntity("teste/11770000", Address.class))
			.thenReturn(mockResponse);
		
		Address address = getAddress();
		ResponseEntity<ResponseError> response = validateZipcode(address);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(address.getDistrict(), address2.getDistrict());
		assertEquals(address.getCity(), address2.getCity());
	}
	
	
	
	@Test
	public void mustReplyStatusAndMessageError() throws InvalidZipcode {
		
		class StatusException extends HttpStatusCodeException  {

			protected StatusException(HttpStatus statusCode, String statusText, byte[] responseBody,
					Charset responseCharset) {
				super(statusCode, statusText, responseBody, responseCharset);
			}
		}
		
		HttpStatusCodeException ex = 
				new StatusException(HttpStatus.BAD_REQUEST, "", "{ \"message\": \"Invalid Zipcode.\" }".getBytes(), null);
		Mockito.doThrow(ex).when(restTemplate).getForEntity("teste/11770000", Address.class);
		
		ResponseEntity<ResponseError> response = validateZipcode(getAddress());
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
		assertEquals(response.getBody().getMessage(), "Invalid Zipcode.");
	}
	
	@Test(expected = InvalidZipcode.class) 
	public void mustThrowInvalidZipcode() throws InvalidZipcode {
		
		Mockito.doThrow(new RuntimeException()).when(restTemplate).getForEntity("teste/11770000", Address.class);
		
		validateZipcode(getAddress());
	}
	
	private Address getAddress() {
		return new Address("Rua 1", "Bairro 1", "Cidade 1", "SP", "Brasil", "11770000", 173, "complement");
	}
	
	private Address getAddress2() {
		return new Address("Rua 1", "Bairro 2", "Cidade 2", "SP", "Brasil", "11770000", 173, "complement");
	}
}
