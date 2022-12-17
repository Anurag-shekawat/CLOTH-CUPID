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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CartException;
import com.masai.exception.OrderException;
import com.masai.module.OrderDetails;
import com.masai.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService os;

	@PostMapping("/AddOrder")
	public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order,
			@RequestParam("cartId") Integer cartId) throws OrderException,CartException {

		OrderDetails AddOrder = os.addOrder(order, cartId);

		return new ResponseEntity<OrderDetails>(AddOrder, HttpStatus.CREATED);
	}

	@PutMapping("/updateOrder/{id}")
	public ResponseEntity<OrderDetails> updateCustomer(@RequestBody OrderDetails order)
			throws OrderException {

		OrderDetails updatedOrder = os.updateOrder(order);

		return new ResponseEntity<OrderDetails>(updatedOrder, HttpStatus.OK);
	}

	@DeleteMapping("/removeOrder/{id}")
	public ResponseEntity<OrderDetails> removeCustomer(@PathVariable("id") Integer orderId) throws OrderException {

		OrderDetails removedOrder = os.removeOrder(orderId);

		return new ResponseEntity<OrderDetails>(removedOrder, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewOrder/{id}")
	public ResponseEntity<OrderDetails> viewOrder(@PathVariable("id") Integer orderId) throws OrderException {

		OrderDetails order = os.viewOrder(orderId);

		return new ResponseEntity<OrderDetails>(order, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewAllOrder")
	public ResponseEntity<List<OrderDetails>> viewAllOrder() throws OrderException {

		List<OrderDetails> orders = os.getAllOrderDetails();

		return new ResponseEntity<List<OrderDetails>>(orders, HttpStatus.OK);
	}

	// @GetMapping("/viewAllOrder/{date}")
	// public ResponseEntity<List<OrderDetails>>
	// getOrderDetailsByDate(@PathVariable("date") LocalDate date)
	// throws OrderException {

	// List<OrderDetails> orders = os.getOrderDetailsByDate(date);

	// return new ResponseEntity<List<OrderDetails>>(orders, HttpStatus.OK);
	// }

	// @GetMapping("/viewOrders/{c_id}")
	// public ResponseEntity<List<OrderDetails>>
	// getOrderDetailsByCustomerId(@PathVariable("c_id") Integer id)
	// throws OrderException {

	// List<OrderDetails> orders = os.getOrderDetailsByCustomerId(id);

	// return new ResponseEntity<List<OrderDetails>>(orders, HttpStatus.OK);
	// }

}
