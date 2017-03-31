package br.com.exercise1.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.exercise1.exception.AddressNotFound;
import br.com.exercise1.exception.InvalidZipcode;
import br.com.exercise1.model.Address;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest extends AddressService {
	
	@Test(expected = InvalidZipcode.class)
	public void mustThrowInvalidZipCodeWhenIsNull() throws InvalidZipcode, AddressNotFound {
		findAddressByZipcode(null);		
	}

	@Test(expected = InvalidZipcode.class)
	public void mustThrowInvalidZipCodeWhenIsNotNumber() throws InvalidZipcode, AddressNotFound {
		findAddressByZipcode("teste");		
	}
	
	@Test(expected = InvalidZipcode.class)
	public void mustThrowInvalidZipCodeWhenSizeIsIncorrect() throws InvalidZipcode, AddressNotFound {
		findAddressByZipcode("1171800");		
	}
	
	@Test(expected = InvalidZipcode.class)
	public void mustThrowInvalidZipCodeWhenSizeIsOnlyZero() throws InvalidZipcode, AddressNotFound {
		findAddressByZipcode("00000000");		
	}
	
	@Test(expected = AddressNotFound.class)
	public void mustThrowAddressNotFound() throws InvalidZipcode, AddressNotFound {
		findAddressByZipcode("11111111");		
	}
	
	@Test
	public void mustIncludeZeroAndReturnAddress() throws InvalidZipcode, AddressNotFound {
		Address address = findAddressByZipcode("11771111");
		
		Address address2 = getAddress();
		
		assertEquals(address.getStreet(), address2.getStreet());
		assertEquals(address.getCity(), address2.getCity());
		assertEquals(address.getCountry(), address2.getCountry());
		assertEquals(address.getDistrict(), address2.getDistrict());
		assertEquals(address.getState(), address2.getState());
		assertEquals(address.getZipcode(), address2.getZipcode());
	}
	
	@Test
	public void mustReturnAddress() throws InvalidZipcode, AddressNotFound {
		Address address = findAddressByZipcode("11770000");
		
		Address address2 = getAddress();
		
		assertEquals(address.getStreet(), address2.getStreet());
		assertEquals(address.getCity(), address2.getCity());
		assertEquals(address.getCountry(), address2.getCountry());
		assertEquals(address.getDistrict(), address2.getDistrict());
		assertEquals(address.getState(), address2.getState());
		assertEquals(address.getZipcode(), address2.getZipcode());
	}
	
	private Address getAddress() {
		return new Address("Rua 1", "Bairro 1", "Cidade 1", "SP", "Brasil", "11770000");
	}
}
