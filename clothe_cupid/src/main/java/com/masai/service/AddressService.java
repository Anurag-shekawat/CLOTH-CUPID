package com.masai.service;

import java.util.List;

import com.masai.exception.AddressException;
import com.masai.module.Address;

public interface AddressService {
	
	public Address addAddress(Address add) throws AddressException;
	
	public Address updateAddress(Address add) throws AddressException;
	
	public Address removeAddress(Address add) throws AddressException;
	
	public Address viewAddressbyId(int id) throws AddressException;
	
	public List<Address> viewAllAddress() throws AddressException;

}
