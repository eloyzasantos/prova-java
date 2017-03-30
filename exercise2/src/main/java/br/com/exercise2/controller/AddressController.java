package br.com.exercise2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.exercise2.exception.AddressNotFound;
import br.com.exercise2.exception.InvalidAddress;
import br.com.exercise2.model.Address;
import br.com.exercise2.service.AddressService;
import br.com.exercise2.util.ValidateUtil;

@Controller
public class AddressController {
	
	@Autowired AddressService service;
	
	@RequestMapping(value = "/address", method = RequestMethod.POST)
	@ResponseBody
	public void save(@RequestBody Address address) throws AddressNotFound, InvalidAddress {
		ValidateUtil.validateAddress(address);
		
		service.save(address);
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	@ResponseBody
	public List<Address> list() {
		return service.list();
	}
	
	@RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@RequestBody Address address, @PathVariable(value="id") Long id) throws AddressNotFound, InvalidAddress {
		ValidateUtil.validateAddress(address);
		
		service.update(address, id);
	}
	
	@RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Address get(@PathVariable(value="id") Long id) throws AddressNotFound {
		return service.findById(id);
	}
	
	@RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable(value="id") Long id) throws AddressNotFound {
		service.delete(id);
	}
	
}
