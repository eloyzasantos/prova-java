package br.com.exercise2.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.exercise2.model.Address;

@Repository
@Transactional
public class AddressRepository extends GenericRepository<Address> {

	public List<Address> list() {
		return getSession().createQuery("from Address").list();
	}
	
}
