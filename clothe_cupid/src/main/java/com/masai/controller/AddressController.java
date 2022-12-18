package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exception.AddressException;
import com.masai.module.Address;
import com.masai.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    private AddressService aService;

    @PostMapping("/addresses")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) throws AddressException {
        Address regAddress = aService.addAddress(address);

        return new ResponseEntity<Address>(regAddress, HttpStatus.CREATED);
    }

    @PutMapping("/addresses")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) throws AddressException {
        Address updatedAddress = aService.updateAddress(address);

        return new ResponseEntity<Address>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable int id) throws AddressException {
        Address deletedAddress = aService.removeAddress(id);

        return new ResponseEntity<Address>(deletedAddress, HttpStatus.ACCEPTED);
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getAddressbyId(@PathVariable("id") int id) throws AddressException {
        Address address = aService.viewAddressbyId(id);

        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    @GetMapping("/addresses")

    public ResponseEntity<List<Address>> getAllAddress() throws AddressException{
        List<Address> list = aService.viewAllAddress();
        
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
