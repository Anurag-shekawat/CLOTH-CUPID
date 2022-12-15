package com.masai.service;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.module.Address;
// import com.masai.repository.AddressDao;

@Service
public class AddressServiceImpl implements AddressService  {
	
	// @Autowired
	// private AddressDao aDao;

	@Override
	public Address addAddress(Address add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(Address add) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address removeAddress(Address add) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address viewAddressbyId(Address id) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}
}
