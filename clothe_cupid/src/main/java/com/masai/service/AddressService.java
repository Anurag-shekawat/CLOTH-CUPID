package com.masai.service;

import com.masai.exception.AddressException;
import com.masai.module.Address;

public interface AddressService {
	
	public Address addAddress(Address add);
	
	public Address updateAddress(Address add) throws AddressException;
	
	public Address removeAddress(Address add) throws AddressException;
	
	public Address viewAddressbyId(Address id) throws AddressException;

}
