package com.masai.module;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    private LocalDate orderDate;

    private String orderStatus;

    

}