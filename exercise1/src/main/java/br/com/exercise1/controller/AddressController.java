package br.com.exercise1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.exercise1.exception.InvalidZipcode;
import br.com.exercise1.model.Address;
import br.com.exercise1.service.AddressService;

@Controller
public class AddressController {
	
	@Autowired AddressService service;
	
	@RequestMapping(value = "/address/get/zipcode/{zipcode}",  method = RequestMethod.GET)
	@ResponseBody
	public Address get(@PathVariable(value="zipcode") String zipcode) throws InvalidZipcode {
		return service.findAddressByZipcode(zipcode);
	}
	
}
