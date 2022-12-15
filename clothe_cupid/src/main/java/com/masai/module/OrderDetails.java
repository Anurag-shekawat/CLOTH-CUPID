package com.masai.module;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "details",fetch = FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


}
