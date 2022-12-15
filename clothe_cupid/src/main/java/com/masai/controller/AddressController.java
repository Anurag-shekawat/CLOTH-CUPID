package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exception.AddressException;
import com.masai.module.Address;
import com.masai.service.AddressService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AddressController {

    @Autowired
    private AddressService aService;

    @PostMapping("/Address")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) throws AddressException {
        Address regAddress = aService.addAddress(address);
        return new ResponseEntity<Address>(regAddress, HttpStatus.CREATED);
    }



    @PutMapping("/updateAddress")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) throws AddressException{
        Address updatedAddress = aService.updateAddress(address);
            return new ResponseEntity<Address>(updatedAddress, HttpStatus.OK);
        
    }



    @DeleteMapping("/deleteAdddress")
    public ResponseEntity<Address> DeleteAddress(@RequestBody Address add) throws AddressException{
        Address deletedAddress = aService.removeAddress(add);
    return new ResponseEntity<Address>(deletedAddress, HttpStatus.ACCEPTED);
    }



    @GetMapping("/getAddress/{id}")
    public ResponseEntity<Address> getAddressbyId(@PathVariable("id") int id) throws AddressException{
        Address address = aService.viewAddressbyId(id);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    



}
