package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.module.OrderDetails;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetails,Integer>{
    
    // @Query("select * from order_details where order_date=?1")
    // List<OrderDetails> findAllByDate(LocalDate date);

    // @Query("select * from order_details o inner join user u on u.user_id = o.order_id where u.user+id=?1")
    // List<OrderDetails> findAllByUserId(Integer id);
    
}
