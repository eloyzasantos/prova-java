package br.com.exercise1.service;

import static org.mockito.Mockito.*;

import org.apache.commons.lang3.StringUtils;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import br.com.exercise1.exception.InvalidZipcode;
import br.com.exercise1.model.Address;
import br.com.exercise1.repository.AddressRepository;

@Service
public class AddressService {

	protected AddressRepository repository;
	
	public AddressService() {
		this.repository = Mockito.mock(AddressRepository.class);
		
		when(repository.findAddressByZipcode(anyString()))
			.thenReturn(new Address("Rua 1", "Bairro 1", "Cidade 1", "SP", "Brasil", "11718000"));
		
		when(repository.findAddressByZipcode("11111111")).thenReturn(null);
	}
	
	public Address findAddressByZipcode(String zipcode) throws InvalidZipcode {
		if (!validate(zipcode)) throw new InvalidZipcode();
		
		return repository.findAddressByZipcode(zipcode);
	}
	
	protected boolean validate(String zipcode) {
		if (zipcode != null && StringUtils.isNumeric(zipcode) 
				&& zipcode.length() == 8 && !zipcode.equals("00000000")) 
			return true;
		
		return false;
	}
}
