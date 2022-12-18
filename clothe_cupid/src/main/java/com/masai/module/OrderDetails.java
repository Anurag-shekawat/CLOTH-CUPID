package com.masai.module;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @NotNull(message = "order date cannot be null")
    private LocalDate orderDate;

    @NotNull(message = "order status cannot be null")
    private String orderStatus;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JsonIgnore
    // private Customer customer;

    // @OneToMany(cascade = CascadeType.ALL,mappedBy = "details",fetch = FetchType.EAGER)
    // private List<Product> productList = new ArrayList<>();

    // @OneToOne(cascade = CascadeType.ALL)
    // private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Cart cart;




}
