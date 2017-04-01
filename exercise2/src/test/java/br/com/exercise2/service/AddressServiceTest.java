package br.com.exercise2.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.exercise2.exception.AddressNotFound;
import br.com.exercise2.model.Address;
import br.com.exercise2.repository.AddressRepository;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest extends AddressService {
	
	@Before
	public void setup() {
		this.repository = Mockito.mock(AddressRepository.class);
		
		Mockito.doNothing().when(repository).save(getAddress());
		Mockito.doNothing().when(repository).delete(getAddress());
		
		Address found = getAddress();
		found.setId(1L);
		when(repository.get(1L, Address.class)).thenReturn(found);
		when(repository.get(2L, Address.class)).thenReturn(null);

	}
	
	@Test(expected = AddressNotFound.class)
	public void mustThrowAddressNotFoundWhenIdToUpdateNotFound() throws AddressNotFound {
		update(getAddress(), 2L);
	}
	
	@Test
	public void mustUpdateOk() throws AddressNotFound {
		Address address = getAddress(); 
		update(address, 1L);
		
		assertEquals(address.getId().longValue(), 1L);
	}
	
	@Test(expected = AddressNotFound.class)
	public void mustThrowAddressNotFoundWhenIdNotFound() throws AddressNotFound {
		findById(2L);
	}
	
	@Test
	public void mustFindAddress() throws AddressNotFound {
		Address found = findById(1L);
		
		assertEquals(found.getId().longValue(), 1L);
	}
	
	@Test(expected = AddressNotFound.class)
	public void mustThrowAddressNotFoundWhenIdRoDeleteNotFound() throws AddressNotFound {
		delete(2L);
	}
	
	@Test
	public void mustDeleteOk() throws AddressNotFound {
		delete(1L);
	}

	private Address getAddress() {
		return new Address("Rua 1", "Bairro 1", "Cidade 1", "SP", "Brasil", "11770000", 173, "complement");
	}
}
