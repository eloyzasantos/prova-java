package br.com.exercise1.repository;

import br.com.exercise1.model.Address;

public interface AddressRepository {

	public Address findAddressByZipcode(String value);
	
}
