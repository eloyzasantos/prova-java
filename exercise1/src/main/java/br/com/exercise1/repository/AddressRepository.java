package br.com.exercise1.repository;

import model.Address;

public interface AddressRepository {

	public Address findAddressByZipcode(String value);
	
}
