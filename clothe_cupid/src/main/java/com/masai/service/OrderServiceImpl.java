package com.masai.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.module.OrderDetails;
import com.masai.repository.OrderRepo;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo or;

    @Override
    public OrderDetails addOrder(OrderDetails order) throws OrderException {
        if(order!=null){
            or.save(order);
            return order;
        }
        else{
            throw new OrderException("Fill all the proper detail of order");
        }
        
    }

    @Override
    public OrderDetails updateOrder(OrderDetails order, Integer id) throws OrderException {
        Optional<OrderDetails> opt=or.findById(id);
		
		if(opt.isPresent()) {
			
			OrderDetails updatedOrder= or.save(order);
			return updatedOrder;
			
		}else
			throw new OrderException("Invalid Order detils"); 
    }

    @Override
    public OrderDetails removeOrder(Integer orderId) throws OrderException {
        Optional<OrderDetails> opt=or.findById(orderId);
	      
        if(opt.isPresent()) {
            
            OrderDetails deletedOrder=opt.get();
            or.delete(deletedOrder);
            
            return deletedOrder;
        }
        else {
            throw new OrderException("Order not found with Id"+orderId);
        }
    }

    @Override
    public OrderDetails viewOrder(Integer orderId) throws OrderException {
        Optional<OrderDetails> opt=or.findById(orderId);
         
        if(opt.isPresent()) {
            OrderDetails order=opt.get();
            return order;
        }
        else {
            throw new OrderException("Order not found with Id: "+orderId);
            
        }
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() throws OrderException{
        List<OrderDetails> allOrders = or.findAll();
		
		if(allOrders.size()>0) {
            List<OrderDetails> list = new ArrayList<>(allOrders);
			return list;
		
	    }
        else {
            throw new OrderException("Order not found with Id");
            
        }
    }

    // @Override
    // public List<OrderDetails> getOrderDetailsByDate(LocalDate date) throws OrderException {
    //     List<OrderDetails> allOrders = or.findAllByDate(date);
		
	// 	if(allOrders.size()>0) {
    //         List<OrderDetails> list = new ArrayList<>(allOrders);
	// 		return list;
		
	//     }
    //     else {
    //         throw new OrderException("No order present on the order date");
            
    //     }
    // }

    // @Override
    // public List<OrderDetails> getOrderDetailsByCustomerId(Integer id) throws OrderException {
    //     List<OrderDetails> allOrders = or.findAllByUserId(id);
		
	// 	if(allOrders.size()>0) {
    //         List<OrderDetails> list = new ArrayList<>(allOrders);
	// 		return list;
		
	//     }
    //     else {
    //         throw new OrderException("No order found with the given customer Id");
            
    //     }
    // }


  
    
}
