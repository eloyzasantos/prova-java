package br.com.exercise2.util;

import br.com.exercise2.exception.InvalidAddress;
import br.com.exercise2.model.Address;

public class ValidateUtil {

	public static void validateAddress(Address address) throws InvalidAddress {
		if (address == null ||
				address.getStreet() == null || address.getStreet().isEmpty() ||
				address.getStreetNumber() == null || address.getStreetNumber() == 0 ||
				address.getZipcode() == null || address.getZipcode().isEmpty() ||
				address.getCity() == null || address.getCity().isEmpty() ||
				address.getState() == null || address.getState().isEmpty()) 
					throw new InvalidAddress();
		
	}
}
