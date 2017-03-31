package br.com.exercise1.service;

import static org.mockito.Mockito.*;

import org.apache.commons.lang3.StringUtils;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import br.com.exercise1.exception.AddressNotFound;
import br.com.exercise1.exception.InvalidZipcode;
import br.com.exercise1.model.Address;
import br.com.exercise1.repository.AddressRepository;

@Service
public class AddressService {

	private AddressRepository repository;
	
	public AddressService() {
		this.repository = Mockito.mock(AddressRepository.class);
		
		when(repository.findAddressByZipcode(anyString())).thenReturn(null);

		when(repository.findAddressByZipcode("11770000"))
			.thenReturn(new Address("Rua 1", "Bairro 1", "Cidade 1", "SP", "Brasil", "11770000"));
		
		when(repository.findAddressByZipcode("11718000"))
			.thenReturn(new Address("Rua 2", "Bairro 2", "Cidade 3", "SP", "Brasil", "11718000"));
		
	}
	
	public Address findAddressByZipcode(String zipcode) throws InvalidZipcode, AddressNotFound {
		if (!validate(zipcode)) throw new InvalidZipcode();
		
		int attempts = 1;
		Address address = null;
		
		while (attempts <= 7) {
			address = repository.findAddressByZipcode(zipcode);
			
			if (address != null) return address;
						
			StringBuilder sb = new StringBuilder(zipcode);
			sb.setCharAt(zipcode.length() - attempts, '0');
			zipcode =  sb.toString();	
			
			attempts++;
		}
		
		throw new AddressNotFound();
	}
	
	private boolean validate(String zipcode) {
		if (zipcode != null && StringUtils.isNumeric(zipcode) 
				&& zipcode.length() == 8 && !zipcode.equals("00000000")) 
			return true;
		
		return false;
	}
}
