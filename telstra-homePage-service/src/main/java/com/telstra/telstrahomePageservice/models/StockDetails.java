package com.telstra.telstrahomePageservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class StockDetails {

    private String name;
    private BigDecimal price;
    private BigDecimal change;
    private String currency;
    private BigDecimal bid;


}
