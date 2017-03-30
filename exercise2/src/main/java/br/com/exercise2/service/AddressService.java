package br.com.exercise2.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exercise2.exception.AddressNotFound;
import br.com.exercise2.model.Address;
import br.com.exercise2.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired AddressRepository repository;
		
	public void save(Address address)  {		
		repository.save(address);
	}
	
	public void update(Address address, Long id) throws AddressNotFound  {	
		Address found = repository.get(id, Address.class);
		if (found != null) {
			address.setId(found.getId());
			repository.save(address);
		} else {
			throw new AddressNotFound();
		}		
	}
	
	public Address findById(Long id) throws AddressNotFound {
		Address address = repository.get(id, Address.class);
		
		if (address == null) throw new AddressNotFound();
		
		return address;
	}
	
	public List<Address> list() {
		return repository.list();
	}
	
	public void delete(Long id) throws AddressNotFound {
		Address address = repository.get(id, Address.class);
		
		if (address == null) throw new AddressNotFound();
		
		repository.delete(address);
	}
}
